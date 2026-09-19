/**
 * One place where every failure is explained.
 *
 * The contract gives errors a machine-readable `code`, and most of the codes mean "the operator
 * has something to fix", not "the visitor did something wrong". So each one gets a specific next
 * step instead of a red box — an unseeded catalog and a revoked API key are the two ways this
 * demo actually breaks in the wild.
 */
import type { ReactNode } from "react";
import type { ApiError } from "../api/client";
import { API_BASE_URL } from "../api/client";
import type { ErrorCode } from "../api/types";

const HINTS: Partial<Record<ErrorCode, string>> = {
  CATALOG_NOT_SEEDED:
    "The Meteroid tenant is missing a plan, feature or metric this demo expects. Seed it once in the dashboard — examples/CATALOG.md lists the exact codes and names the backend looks up.",
  UPSTREAM_UNAUTHORIZED:
    "The backend's METEROID_API_KEY was rejected. Check the key in examples/.env and restart the backend.",
  UPSTREAM_ERROR: "Meteroid errored or was unreachable. Retry in a moment.",
  RATE_LIMITED: "Meteroid is throttling this API key. Wait a few seconds and retry.",
  UNAUTHORIZED:
    "This session token is not valid for the backend you are pointed at. Reset the workspace to mint a new one.",
  CHECKOUT_UNAVAILABLE:
    "Meteroid produced no hosted checkout URL for this plan — usually because the workspace is already on it.",
};

export function ErrorNotice({ error, action }: { error: ApiError; action?: ReactNode }) {
  const hint = error.unreachable
    ? `Start a backend, or set VITE_API_BASE_URL to one that is running. Currently pointed at ${API_BASE_URL}.`
    : HINTS[error.code];

  return (
    <div className="notice" role="alert">
      <div className="notice-head">
        <span className="notice-code">{error.unreachable ? "NO BACKEND" : error.code}</span>
        {error.status > 0 && <span className="label">HTTP {error.status}</span>}
      </div>
      <p className="notice-message">{error.message}</p>
      {hint && <p className="notice-hint">{hint}</p>}
      {action && <div className="locked-actions">{action}</div>}
    </div>
  );
}
