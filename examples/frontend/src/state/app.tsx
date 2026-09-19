/**
 * The whole application state, in one file.
 *
 * A demo that teaches an SDK should not make you learn a state library first, so this is plain
 * React: one context, one reducer-free store, explicit actions. The interesting parts are:
 *
 *  - **boot** — mint a session on first visit, then load everything the shell needs at once,
 *    tolerating per-resource failures (an unseeded catalog breaks `/api/plans` but not `/api/me`).
 *  - **the quota projection** — a successful `POST /api/transcriptions` returns a fresh
 *    `QuotaSnapshot`, which is folded straight into the entitlement so the meter moves at once
 *    instead of waiting for Meteroid's eventually-consistent counters.
 *  - **the checkout round trip** — the redirect leaves our origin entirely, so a localStorage
 *    marker, not a query parameter, is what tells the app to wait for the new subscription.
 */
import {
  createContext,
  useCallback,
  useContext,
  useEffect,
  useMemo,
  useRef,
  useState,
  type ReactNode,
} from "react";
import { API_BASE_URL, ApiError, ScribeClient } from "../api/client";
import type {
  Entitlement,
  Health,
  MeResponse,
  MeteredEntitlementValue,
  Plan,
  PlanCode,
  QuotaSnapshot,
  Transcription,
  Workspace,
} from "../api/types";
import { FEATURE } from "../api/types";
import {
  loadPendingCheckout,
  loadToken,
  savePendingCheckout,
  saveToken,
} from "../lib/storage";

/** A loaded-or-failed slice of remote data. */
export type Resource<T> = { data: T; error: ApiError | null; loading: boolean };

function idle<T>(initial: T): Resource<T> {
  return { data: initial, error: null, loading: true };
}

/** Why the metered action is unavailable. Persistent state, not a toast — see `Studio`. */
export type Block = {
  reason: "quota" | "not_entitled";
  message: string;
  quota: QuotaSnapshot | null;
  upgradePlanCode: PlanCode | null;
};

export type Notice = {
  tone: "pending" | "success" | "warning";
  message: string;
};

export type TranscribeResult =
  | { ok: true; transcription: Transcription }
  | { ok: false; error: ApiError };

type AppValue = {
  booting: boolean;
  bootError: ApiError | null;
  health: Health | null;
  workspace: Workspace | null;
  me: Resource<MeResponse | null>;
  plans: Resource<Plan[]>;
  entitlements: Resource<Entitlement[]>;
  transcriptions: Resource<Transcription[]>;
  /** The `transcription_minutes` entitlement, as the same snapshot the 402 error carries. */
  quota: QuotaSnapshot | null;
  block: Block | null;
  notice: Notice | null;
  client: ScribeClient;
  transcribe: (title: string, durationSeconds: number) => Promise<TranscribeResult>;
  checkout: (planCode: PlanCode) => Promise<void>;
  openPortal: () => Promise<void>;
  refresh: () => Promise<void>;
  resetWorkspace: () => void;
  dismissNotice: () => void;
};

const AppContext = createContext<AppValue | null>(null);

export function useApp(): AppValue {
  const value = useContext(AppContext);
  if (!value) throw new Error("useApp must be used inside <AppProvider>");
  return value;
}

/** Turn the metered entitlement into the same `QuotaSnapshot` shape errors use. */
function quotaOf(entitlements: Entitlement[]): QuotaSnapshot | null {
  const entry = entitlements.find((e) => e.feature_code === FEATURE.minutes);
  if (!entry || entry.value.type !== "METERED") return null;
  const value: MeteredEntitlementValue = entry.value;
  return {
    feature_code: entry.feature_code,
    enabled: value.enabled,
    limit: value.limit,
    consumed: value.consumed,
    remaining: value.remaining,
    reset_at: value.reset_at,
    unlimited: value.unlimited,
  };
}

/** Fold a fresh snapshot back into the entitlement list so the meter updates immediately. */
function applyQuota(entitlements: Entitlement[], quota: QuotaSnapshot): Entitlement[] {
  return entitlements.map((entry) =>
    entry.feature_code === quota.feature_code && entry.value.type === "METERED"
      ? {
          ...entry,
          value: {
            ...entry.value,
            enabled: quota.enabled,
            limit: quota.limit,
            consumed: quota.consumed,
            remaining: quota.remaining,
            reset_at: quota.reset_at,
            unlimited: quota.unlimited,
          },
        }
      : entry,
  );
}

function asApiError(error: unknown): ApiError {
  return error instanceof ApiError
    ? error
    : new ApiError(0, {
        code: "INTERNAL",
        message: error instanceof Error ? error.message : String(error),
        quota: null,
        upgrade_plan_code: null,
      });
}

const CHECKOUT_POLL_INTERVAL_MS = 2500;
const CHECKOUT_POLL_ATTEMPTS = 12;

export function AppProvider({ children }: { children: ReactNode }) {
  const tokenRef = useRef<string | null>(loadToken());
  const client = useMemo(() => new ScribeClient(API_BASE_URL, () => tokenRef.current), []);

  const [booting, setBooting] = useState(true);
  const [bootError, setBootError] = useState<ApiError | null>(null);
  const [health, setHealth] = useState<Health | null>(null);
  const [workspace, setWorkspace] = useState<Workspace | null>(null);
  const [me, setMe] = useState<Resource<MeResponse | null>>(idle(null));
  const [plans, setPlans] = useState<Resource<Plan[]>>(idle([]));
  const [entitlements, setEntitlements] = useState<Resource<Entitlement[]>>(idle([]));
  const [transcriptions, setTranscriptions] = useState<Resource<Transcription[]>>(idle([]));
  const [block, setBlock] = useState<Block | null>(null);
  const [notice, setNotice] = useState<Notice | null>(null);

  // ------------------------------------------------------------------ loading

  /**
   * Create the workspace at most once.
   *
   * `POST /api/session` creates a real Meteroid customer, and React's StrictMode runs this
   * provider's boot effect twice in development — so the in-flight promise is shared rather than
   * the check being a bare `if (!token)`, which two concurrent runs would both pass.
   */
  const sessionRequest = useRef<Promise<void> | null>(null);
  const ensureSession = useCallback(async () => {
    if (tokenRef.current) return;
    sessionRequest.current ??= client
      .createSession({})
      .then((created) => {
        tokenRef.current = created.session_token;
        saveToken(created.session_token);
        setWorkspace(created.workspace);
      })
      .catch((error: unknown) => {
        sessionRequest.current = null; // let a retry try again
        throw error;
      });
    return sessionRequest.current;
  }, [client]);

  const loadAll = useCallback(async () => {
    const [meResult, plansResult, entitlementsResult, historyResult] = await Promise.allSettled([
      client.getMe(),
      client.listPlans(),
      client.listEntitlements(),
      client.listTranscriptions(),
    ]);

    if (meResult.status === "fulfilled") {
      setMe({ data: meResult.value, error: null, loading: false });
      setWorkspace(meResult.value.workspace);
    } else {
      setMe((prev) => ({ ...prev, error: asApiError(meResult.reason), loading: false }));
    }

    setPlans(
      plansResult.status === "fulfilled"
        ? { data: plansResult.value, error: null, loading: false }
        : { data: [], error: asApiError(plansResult.reason), loading: false },
    );

    setEntitlements(
      entitlementsResult.status === "fulfilled"
        ? { data: entitlementsResult.value, error: null, loading: false }
        : { data: [], error: asApiError(entitlementsResult.reason), loading: false },
    );

    setTranscriptions(
      historyResult.status === "fulfilled"
        ? { data: historyResult.value, error: null, loading: false }
        : { data: [], error: asApiError(historyResult.reason), loading: false },
    );

    // The gate reopens by itself once the plan grants more minutes.
    if (entitlementsResult.status === "fulfilled") {
      const fresh = quotaOf(entitlementsResult.value);
      setBlock((current) =>
        current && fresh && (fresh.unlimited || fresh.remaining !== "0") ? null : current,
      );
    }
  }, [client]);

  /** Wait for Meteroid to report the subscription the visitor just bought. */
  const confirmCheckout = useCallback(
    async (planCode: PlanCode) => {
      setNotice({ tone: "pending", message: `Confirming your ${planCode} subscription…` });
      for (let attempt = 0; attempt < CHECKOUT_POLL_ATTEMPTS; attempt += 1) {
        try {
          const next = await client.getMe();
          if (next.subscription?.plan_code === planCode) {
            savePendingCheckout(null);
            setBlock(null);
            await loadAll();
            setNotice({ tone: "success", message: `You are on the ${planCode} plan.` });
            return;
          }
        } catch {
          /* keep polling — a transient failure here should not strand the banner */
        }
        await new Promise((resolve) => setTimeout(resolve, CHECKOUT_POLL_INTERVAL_MS));
      }
      savePendingCheckout(null);
      await loadAll();
      setNotice({
        tone: "warning",
        message:
          "Meteroid has not reported the new subscription yet. It usually lands within a minute — reload then.",
      });
    },
    [client, loadAll],
  );

  useEffect(() => {
    let cancelled = false;

    void (async () => {
      try {
        setHealth(await client.getHealth());
      } catch (error) {
        // Health is diagnostic. If it fails, the calls below will fail too and say why.
        if (!cancelled) setHealth(null);
        if (asApiError(error).unreachable && !cancelled) {
          setBootError(asApiError(error));
          setBooting(false);
          return;
        }
      }

      try {
        await ensureSession();
      } catch (error) {
        if (!cancelled) {
          setBootError(asApiError(error));
          setBooting(false);
        }
        return;
      }

      await loadAll();
      if (cancelled) return;
      setBooting(false);

      const pending = loadPendingCheckout();
      if (pending) void confirmCheckout(pending.plan_code);
    })();

    return () => {
      cancelled = true;
    };
  }, [client, ensureSession, loadAll, confirmCheckout]);

  // ------------------------------------------------------------------ actions

  const transcribe = useCallback(
    async (title: string, durationSeconds: number): Promise<TranscribeResult> => {
      try {
        const result = await client.createTranscription({
          title,
          duration_seconds: durationSeconds,
        });
        setBlock(null);
        setTranscriptions((prev) => ({
          ...prev,
          data: [result.transcription, ...prev.data],
        }));
        setEntitlements((prev) => ({ ...prev, data: applyQuota(prev.data, result.quota) }));
        return { ok: true, transcription: result.transcription };
      } catch (caught) {
        const error = asApiError(caught);
        if (error.code === "QUOTA_EXHAUSTED" || error.code === "FEATURE_NOT_ENTITLED") {
          const quota = error.quota;
          setBlock({
            reason: error.code === "QUOTA_EXHAUSTED" ? "quota" : "not_entitled",
            message: error.message,
            quota,
            upgradePlanCode: error.upgradePlanCode,
          });
          // The 402 body carries the live snapshot, so the meter lands on the real balance.
          if (quota) {
            setEntitlements((prev) => ({ ...prev, data: applyQuota(prev.data, quota) }));
          }
        }
        return { ok: false, error };
      }
    },
    [client],
  );

  const checkout = useCallback(
    async (planCode: PlanCode) => {
      const session = await client.createCheckout({ plan_code: planCode });
      savePendingCheckout({ plan_code: planCode, started_at: Date.now() });
      window.location.assign(session.checkout_url);
    },
    [client],
  );

  const openPortal = useCallback(async () => {
    const session = await client.createPortalSession();
    const url = new URL(session.portal_url);
    url.searchParams.set("token", session.token);
    window.open(url.toString(), "_blank", "noopener,noreferrer");
  }, [client]);

  const refresh = useCallback(async () => {
    setMe((prev) => ({ ...prev, loading: true }));
    setEntitlements((prev) => ({ ...prev, loading: true }));
    await loadAll();
  }, [loadAll]);

  const resetWorkspace = useCallback(() => {
    saveToken(null);
    savePendingCheckout(null);
    window.location.reload();
  }, []);

  const value: AppValue = {
    booting,
    bootError,
    health,
    workspace,
    me,
    plans,
    entitlements,
    transcriptions,
    quota: quotaOf(entitlements.data),
    block,
    notice,
    client,
    transcribe,
    checkout,
    openPortal,
    refresh,
    resetWorkspace,
    dismissNotice: () => setNotice(null),
  };

  return <AppContext.Provider value={value}>{children}</AppContext.Provider>;
}
