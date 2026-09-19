/**
 * A hash router in twenty lines. The demo has five screens and no server-side routing, and a hash
 * route survives the return trip from Meteroid's hosted checkout without any dev-server rewrite
 * rules — which is exactly what a demo you clone and run needs.
 */
import { useCallback, useEffect, useState } from "react";

export const ROUTES = ["studio", "usage", "plans", "billing", "settings"] as const;
export type Route = (typeof ROUTES)[number];

function currentRoute(): Route {
  const hash = window.location.hash.replace(/^#\/?/, "");
  return (ROUTES as readonly string[]).includes(hash) ? (hash as Route) : "studio";
}

export function navigate(route: Route): void {
  window.location.hash = `#/${route}`;
}

export function useRoute(): Route {
  const [route, setRoute] = useState<Route>(currentRoute);

  const sync = useCallback(() => setRoute(currentRoute()), []);

  useEffect(() => {
    window.addEventListener("hashchange", sync);
    return () => window.removeEventListener("hashchange", sync);
  }, [sync]);

  return route;
}
