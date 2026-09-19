/**
 * Load one screen's data on mount, with a manual reload. Used by the screens whose data is not
 * worth fetching at boot — usage and invoices.
 */
import { useCallback, useEffect, useState } from "react";
import { ApiError } from "../api/client";
import type { Resource } from "./app";

export function useResource<T>(
  load: () => Promise<T>,
  initial: T,
): Resource<T> & { reload: () => void } {
  const [state, setState] = useState<Resource<T>>({ data: initial, error: null, loading: true });

  const run = useCallback(() => {
    let cancelled = false;
    setState((prev) => ({ ...prev, loading: true }));
    load().then(
      (data) => {
        if (!cancelled) setState({ data, error: null, loading: false });
      },
      (caught: unknown) => {
        if (cancelled) return;
        const error =
          caught instanceof ApiError
            ? caught
            : new ApiError(0, {
                code: "INTERNAL",
                message: caught instanceof Error ? caught.message : String(caught),
                quota: null,
                upgrade_plan_code: null,
              });
        setState((prev) => ({ data: prev.data, error, loading: false }));
      },
    );
    return () => {
      cancelled = true;
    };
  }, [load]);

  useEffect(run, [run]);

  return { ...state, reload: run };
}
