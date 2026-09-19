/**
 * Usage for the current period, straight from Meteroid.
 *
 * This is the authority, and it is deliberately not the same number as the studio meter: the meter
 * is the backend's optimistic projection, while these totals are Meteroid's counters, which are
 * eventually consistent. The screen says so rather than pretending they are transactional.
 */
import { useCallback } from "react";
import type { UsageResponse } from "../api/types";
import { ErrorNotice } from "../components/ErrorNotice";
import { Panel } from "../components/Panel";
import { formatDate, formatDecimal } from "../lib/format";
import { useApp } from "../state/app";
import { useResource } from "../state/useResource";

export function Usage() {
  const { client } = useApp();
  const load = useCallback(() => client.getUsage(), [client]);
  const usage = useResource<UsageResponse | null>(load, null);

  const metrics = usage.data?.metrics ?? [];
  const peak = metrics.reduce((max, metric) => Math.max(max, Number(metric.total_value) || 0), 0);

  return (
    <>
      <header className="screen-head">
        <h1 className="screen-title">Usage</h1>
        <p className="screen-sub">
          What Meteroid has counted for this workspace in the current period, per billable metric.
          Totals are exact decimals and are carried as strings all the way here.
        </p>
      </header>

      {usage.error && <ErrorNotice error={usage.error} />}

      <Panel
        eyebrow={
          usage.data
            ? `${usage.data.scope} period · ${formatDate(usage.data.period_start)} → ${formatDate(usage.data.period_end)}`
            : "period"
        }
        title="Metered consumption"
        actions={
          <button type="button" className="btn btn-small btn-quiet" onClick={usage.reload}>
            {usage.loading ? <span className="spin" /> : null}
            Refresh
          </button>
        }
        bodyClassName=""
      >
        {metrics.length === 0 ? (
          <p className="empty">
            {usage.loading
              ? "Loading…"
              : "No usage in this period yet. Transcribe something in the studio."}
          </p>
        ) : (
          metrics.map((metric) => (
            <div key={metric.metric_code} className="metric">
              <div className="metric-head">
                <div>
                  <h3>{metric.metric_name}</h3>
                  <div className="label">{metric.metric_code}</div>
                </div>
                <span className="metric-total">{formatDecimal(metric.total_value)}</span>
              </div>

              <div className="bar">
                <div
                  className="bar-fill"
                  style={{
                    width: `${peak > 0 ? ((Number(metric.total_value) || 0) / peak) * 100 : 0}%`,
                  }}
                />
              </div>

              {metric.grouped_usage.length > 0 && (
                <div className="dimensions">
                  {metric.grouped_usage.map((group, index) => (
                    <span key={index} className="chip">
                      {Object.entries(group.dimensions)
                        .map(([key, value]) => `${key}=${value}`)
                        .join(" ")}{" "}
                      · {formatDecimal(group.value)}
                    </span>
                  ))}
                </div>
              )}
            </div>
          ))
        )}
      </Panel>

      {usage.data?.scope === "customer" && (
        <p className="panel-note">
          No subscription yet, so this is the customer-scoped query over the current calendar month
          — a demo convention, not a billing period.
        </p>
      )}
    </>
  );
}
