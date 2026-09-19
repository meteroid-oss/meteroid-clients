/**
 * The Scribe backend client.
 *
 * Hand-written on top of the generated types in `schema.ts` — twelve operations do not justify a
 * generated runtime, and this way the request each screen makes is readable in one place. Every
 * request and response type comes from `examples/openapi.yaml`; nothing is re-typed by hand.
 *
 * The client is backend-agnostic on purpose: `VITE_API_BASE_URL` is the only thing that changes
 * when you point the SPA at the Rust, Java or TypeScript implementation.
 */
import type {
  CreateCheckoutRequest,
  CreateCheckoutResponse,
  CreatePortalSessionResponse,
  CreateSessionRequest,
  CreateSessionResponse,
  CreateTranscriptionRequest,
  CreateTranscriptionResponse,
  Entitlement,
  ErrorBody,
  ErrorCode,
  Health,
  Invoice,
  MeResponse,
  Plan,
  QuotaSnapshot,
  Transcription,
  UsageResponse,
} from "./types";

export const API_BASE_URL = (
  import.meta.env.VITE_API_BASE_URL ?? "http://localhost:8080"
).replace(/\/+$/, "");

/**
 * A failed request. `status` is 0 when the request never reached a backend at all — a wrong
 * `VITE_API_BASE_URL` or a backend that is not running, which is the single most common way to
 * get stuck in this demo, so it gets its own message rather than a generic "failed to fetch".
 */
export class ApiError extends Error {
  readonly status: number;
  readonly code: ErrorCode;
  readonly quota: QuotaSnapshot | null;
  readonly upgradePlanCode: ErrorBody["upgrade_plan_code"];

  constructor(status: number, body: ErrorBody) {
    super(body.message);
    this.name = "ApiError";
    this.status = status;
    this.code = body.code;
    this.quota = body.quota;
    this.upgradePlanCode = body.upgrade_plan_code;
  }

  /** True when no backend answered: nothing is wrong with the request, something is unreachable. */
  get unreachable(): boolean {
    return this.status === 0;
  }
}

function isErrorBody(value: unknown): value is ErrorBody {
  return (
    typeof value === "object" &&
    value !== null &&
    typeof (value as ErrorBody).code === "string" &&
    typeof (value as ErrorBody).message === "string"
  );
}

type RequestOptions = {
  method?: "GET" | "POST";
  body?: unknown;
  query?: Record<string, string | number | undefined>;
  /** Send the session token. Off for the unauthenticated operations. */
  auth?: boolean;
};

export class ScribeClient {
  constructor(
    private readonly baseUrl: string,
    /** Read at call time, so a session created after construction is picked up. */
    private readonly getToken: () => string | null,
  ) {}

  // ---------------------------------------------------------------- operations

  /** `GET /api/health` — which backend is answering, and is it configured. */
  getHealth() {
    return this.request<Health>("/api/health", { auth: false });
  }

  /** `POST /api/session` — creates the Meteroid customer behind this demo workspace. */
  createSession(body: CreateSessionRequest) {
    return this.request<CreateSessionResponse>("/api/session", {
      method: "POST",
      body,
      auth: false,
    });
  }

  /** `GET /api/me` — workspace, subscription and plan. The app's boot call. */
  getMe() {
    return this.request<MeResponse>("/api/me");
  }

  /** `GET /api/plans` — the pricing table, resolved from the seeded Meteroid plans. */
  async listPlans(): Promise<Plan[]> {
    const { plans } = await this.request<{ plans: Plan[] }>("/api/plans", { auth: false });
    return plans;
  }

  /** `POST /api/checkout` — returns the hosted Meteroid checkout URL to redirect to. */
  createCheckout(body: CreateCheckoutRequest) {
    return this.request<CreateCheckoutResponse>("/api/checkout", { method: "POST", body });
  }

  /** `GET /api/entitlements` — the normalized view every feature gate in this app reads. */
  async listEntitlements(): Promise<Entitlement[]> {
    const { entitlements } = await this.request<{ entitlements: Entitlement[] }>(
      "/api/entitlements",
    );
    return entitlements;
  }

  /** `GET /api/transcriptions` — demo-local history. Empty after a backend restart. */
  async listTranscriptions(): Promise<Transcription[]> {
    const { transcriptions } = await this.request<{ transcriptions: Transcription[] }>(
      "/api/transcriptions",
    );
    return transcriptions;
  }

  /** `POST /api/transcriptions` — the metered action. 402 when the quota is spent. */
  createTranscription(body: CreateTranscriptionRequest) {
    return this.request<CreateTranscriptionResponse>("/api/transcriptions", {
      method: "POST",
      body,
    });
  }

  /** `GET /api/usage` — current-period usage per billable metric, straight from Meteroid. */
  getUsage() {
    return this.request<UsageResponse>("/api/usage");
  }

  /** `POST /api/portal-session` — a short-lived Meteroid customer-portal token. */
  createPortalSession() {
    return this.request<CreatePortalSessionResponse>("/api/portal-session", { method: "POST" });
  }

  /** `GET /api/invoices` — the workspace customer's invoices, newest first. */
  async listInvoices(limit = 20): Promise<Invoice[]> {
    const { invoices } = await this.request<{ invoices: Invoice[] }>("/api/invoices", {
      query: { limit },
    });
    return invoices;
  }

  // ---------------------------------------------------------------- transport

  private async request<T>(path: string, options: RequestOptions = {}): Promise<T> {
    const { method = "GET", body, query, auth = true } = options;

    const url = new URL(this.baseUrl + path);
    for (const [key, value] of Object.entries(query ?? {})) {
      if (value !== undefined) url.searchParams.set(key, String(value));
    }

    const headers: Record<string, string> = { accept: "application/json" };
    if (body !== undefined) headers["content-type"] = "application/json";
    if (auth) {
      const token = this.getToken();
      if (token) headers["authorization"] = `Bearer ${token}`;
    }

    let response: Response;
    try {
      response = await fetch(url, {
        method,
        headers,
        ...(body === undefined ? {} : { body: JSON.stringify(body) }),
      });
    } catch {
      throw new ApiError(0, {
        code: "UPSTREAM_ERROR",
        message: `No Scribe backend answered at ${this.baseUrl}. Start one, or point VITE_API_BASE_URL somewhere else.`,
        quota: null,
        upgrade_plan_code: null,
      });
    }

    const payload = response.status === 204 ? null : await response.json().catch(() => null);

    if (!response.ok) {
      throw new ApiError(
        response.status,
        isErrorBody(payload)
          ? payload
          : {
              code: "INTERNAL",
              message: `${method} ${path} failed with HTTP ${response.status}.`,
              quota: null,
              upgrade_plan_code: null,
            },
      );
    }

    return payload as T;
  }
}
