/**
 * Feature gates driven by the boolean and config entitlements.
 *
 * `transcription_minutes` gates an action (the studio). These three gate *capabilities*, which is
 * the other half of entitlements and the half demos usually skip:
 *
 *  - `sso` — a boolean. The control is present but inert without it, with the plan that grants it
 *    named, rather than the feature being hidden and the visitor left guessing.
 *  - `seats` — a config number. It sizes the seat row.
 *  - `retention_days` — a config number. It is turned into the date transcripts are kept back to.
 *
 * Nothing here is hard-coded per plan: the UI reads the entitlement and renders what it finds.
 */
import { API_BASE_URL } from "../api/client";
import type { ConfigValue } from "../api/types";
import { FEATURE, asBoolean, asConfig } from "../api/types";
import { ErrorNotice } from "../components/ErrorNotice";
import { Panel } from "../components/Panel";
import { formatDecimal } from "../lib/format";
import { navigate } from "../lib/router";
import { useApp } from "../state/app";

/** Render any config value. Four kinds, tagged — no shape sniffing. */
function configText(value: ConfigValue | null): string {
  if (!value) return "—";
  switch (value.kind) {
    case "NUMBER":
      return formatDecimal(value.value);
    case "BOOLEAN":
      return value.value ? "on" : "off";
    case "TEXT":
      return value.value;
    case "JSON":
      return JSON.stringify(value.value);
  }
}

function configNumber(value: ConfigValue | null): number | null {
  return value?.kind === "NUMBER" ? Number(value.value) : null;
}

export function Settings() {
  const { workspace, entitlements, health, me, resetWorkspace } = useApp();

  const find = (code: string) => entitlements.data.find((entry) => entry.feature_code === code);
  const sso = asBoolean(find(FEATURE.sso));
  const seats = asConfig(find(FEATURE.seats));
  const retention = asConfig(find(FEATURE.retention));

  const seatCount = configNumber(seats);
  const retentionDays = configNumber(retention);
  const keptSince =
    retentionDays === null
      ? null
      : new Date(Date.now() - retentionDays * 86_400_000).toLocaleDateString(undefined, {
          day: "numeric",
          month: "short",
          year: "numeric",
        });

  return (
    <>
      <header className="screen-head">
        <h1 className="screen-title">Workspace</h1>
        <p className="screen-sub">
          Capabilities gated by the boolean and config entitlements on{" "}
          <code>GET /api/entitlements</code>. Change the plan and this screen changes with it.
        </p>
      </header>

      {entitlements.error && <ErrorNotice error={entitlements.error} />}

      <div className="stack">
        <div className="gates">
          <section className={`panel gate ${sso?.enabled ? "" : "gate-off"}`.trim()}>
            <div className="label">sso · boolean</div>
            <h2>Single sign-on</h2>
            <div className="gate-value">{sso?.enabled ? "Enabled" : "Locked"}</div>
            <p className="panel-note">
              {sso?.enabled
                ? "Connect your identity provider and require SSO for everyone in the workspace."
                : "SAML and OIDC sign-in are not part of this plan. They are included on Scale."}
            </p>
            <div className="row">
              <button type="button" className="btn btn-small" disabled={!sso?.enabled}>
                Connect identity provider
              </button>
              {!sso?.enabled && (
                <button
                  type="button"
                  className="btn btn-small btn-quiet"
                  onClick={() => navigate("plans")}
                >
                  See plans
                </button>
              )}
            </div>
          </section>

          <section className={`panel gate ${seatCount ? "" : "gate-off"}`.trim()}>
            <div className="label">seats · config</div>
            <h2>Team seats</h2>
            <div className="gate-value">
              {seatCount === null ? "—" : `1 / ${configText(seats)}`}
            </div>
            {seatCount !== null && (
              <div className="seats" aria-hidden="true">
                {Array.from({ length: Math.min(seatCount, 12) }, (_, index) => (
                  <span key={index} className={`seat ${index === 0 ? "" : "seat-free"}`.trim()} />
                ))}
              </div>
            )}
            <p className="panel-note">
              {seatCount === null
                ? "No seat entitlement on this plan."
                : `You can invite ${Math.max(seatCount - 1, 0)} more people.`}
            </p>
            <div className="row">
              <button type="button" className="btn btn-small" disabled={!seatCount || seatCount < 2}>
                Invite teammate
              </button>
            </div>
          </section>

          <section className={`panel gate ${retentionDays ? "" : "gate-off"}`.trim()}>
            <div className="label">retention_days · config</div>
            <h2>Transcript retention</h2>
            <div className="gate-value">
              {retentionDays === null ? "—" : `${configText(retention)} days`}
            </div>
            <p className="panel-note">
              {keptSince
                ? `Transcripts are kept back to ${keptSince}. Older ones are deleted automatically.`
                : "No retention entitlement on this plan."}
            </p>
          </section>
        </div>

        <Panel eyebrow="workspace" title={workspace?.name ?? "—"}>
          <div className="quota-facts">
            <div className="fact">
              <div className="label">customer alias</div>
              <div className="fact-value">{workspace?.customer_alias ?? "—"}</div>
            </div>
            <div className="fact">
              <div className="label">customer id</div>
              <div className="fact-value">{workspace?.customer_id ?? "—"}</div>
            </div>
            <div className="fact">
              <div className="label">currency</div>
              <div className="fact-value">{workspace?.currency ?? "—"}</div>
            </div>
            <div className="fact">
              <div className="label">plan</div>
              <div className="fact-value">{me.data?.subscription?.plan_code ?? "none"}</div>
            </div>
          </div>
          <p className="panel-note">
            The alias is what usage events are addressed to, so Meteroid counts against your own
            identifier rather than one you have to store.
          </p>
          <div className="locked-actions">
            <button type="button" className="btn btn-small" onClick={resetWorkspace}>
              Start a fresh workspace
            </button>
            <span className="label">creates a new Meteroid customer</span>
          </div>
        </Panel>

        <Panel eyebrow="backend" title={health ? `${health.backend} backend` : "Backend"}>
          <div className="quota-facts">
            <div className="fact">
              <div className="label">base url</div>
              <div className="fact-value">{API_BASE_URL}</div>
            </div>
            <div className="fact">
              <div className="label">version</div>
              <div className="fact-value">{health?.version ?? "—"}</div>
            </div>
            <div className="fact">
              <div className="label">meteroid key</div>
              <div className="fact-value">
                {health?.meteroid_configured ? "configured" : "missing"}
              </div>
            </div>
          </div>
          <p className="panel-note">
            Every screen in this app is the same code against whichever backend answers here. Point{" "}
            <code>VITE_API_BASE_URL</code> at the Rust, Java or TypeScript implementation and
            nothing else changes.
          </p>
        </Panel>

        <details className="panel">
          <summary className="panel-head" style={{ cursor: "pointer" }}>
            <span>
              <span className="label">raw</span>
              <h2 className="panel-title">GET /api/entitlements</h2>
            </span>
          </summary>
          <pre className="raw">{JSON.stringify(entitlements.data, null, 2)}</pre>
        </details>
      </div>
    </>
  );
}
