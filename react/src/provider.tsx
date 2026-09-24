import {
  createMeteroid,
  type EffectiveEntitlementListResponse,
  type GetToken,
  type Meteroid,
} from "@meteroid/browser";
import {
  createContext,
  type ReactNode,
  useEffect,
  useLayoutEffect,
  useRef,
  useState,
} from "react";

export const MeteroidContext = createContext<Meteroid | null>(null);

/** @internal `useLayoutEffect` in the browser, `useEffect` (a no-op) on the server. */
export const useIsomorphicLayoutEffect =
  typeof window === "undefined" ? useEffect : useLayoutEffect;

export interface MeteroidProviderProps {
  /**
   * Fetches a token for the signed-in customer from your backend, e.g.
   * `() => fetch("/billing-token").then((r) => r.json())`. An inline function is fine.
   */
  getToken: GetToken;
  /** Identifies the signed-in customer: when it changes, all billing state is reset. */
  customerKey?: string | number;
  /**
   * Entitlements loaded on the server (with `@meteroid/sdk` or the REST API), so that
   * the first render, and the server render, already know them.
   */
  initialEntitlements?: EffectiveEntitlementListResponse;
  /** Base URL of the REST API. Defaults to the token's `api_url`. */
  apiUrl?: string;
  /** Base URL of the portal, for embeds. Defaults to the token's `portal_url`. */
  portalUrl?: string;
  children?: ReactNode;
}

type ClientState = { key: unknown[]; client: Meteroid };

/** Provides the billing state of the signed-in customer to the hooks and components. */
export function MeteroidProvider({
  getToken,
  customerKey,
  initialEntitlements,
  apiUrl,
  portalUrl,
  children,
}: MeteroidProviderProps) {
  const getTokenRef = useRef(getToken);
  useIsomorphicLayoutEffect(() => {
    getTokenRef.current = getToken;
  });

  const key = [customerKey, apiUrl, portalUrl];
  const create = (): ClientState => ({
    key,
    client: createMeteroid({
      getToken: () => getTokenRef.current(),
      apiUrl,
      portalUrl,
      initialEntitlements,
    }),
  });
  const [state, setState] = useState(create);
  let client = state.client;
  if (key.some((value, index) => value !== state.key[index])) {
    // The client starts on its first subscriber and stops with its last one, so a
    // replaced client needs no teardown.
    const next = create();
    client = next.client;
    setState(next);
  }

  return <MeteroidContext.Provider value={client}>{children}</MeteroidContext.Provider>;
}
