/**
 * The shell: rail, tabs, and whichever screen the hash route names.
 *
 * The rail carries the level meter on every screen. That is the one deliberate structural choice
 * in this app — entitlement state is not a page you visit, it is the condition the whole product
 * runs under, so it sits above everything else and is never more than a glance away.
 */
import { API_BASE_URL } from "./api/client";
import { ErrorNotice } from "./components/ErrorNotice";
import { LevelMeter } from "./components/LevelMeter";
import { ROUTES, navigate, useRoute, type Route } from "./lib/router";
import { Billing } from "./screens/Billing";
import { Plans } from "./screens/Plans";
import { Settings } from "./screens/Settings";
import { Studio } from "./screens/Studio";
import { Usage } from "./screens/Usage";
import { useApp } from "./state/app";

const TAB_LABELS: Record<Route, string> = {
  studio: "Studio",
  usage: "Usage",
  plans: "Plans",
  billing: "Billing",
  settings: "Workspace",
};

/** A level-meter glyph — three lit segments. The product's own instrument, at 22px. */
function BrandMark() {
  return (
    <svg className="brand-mark" viewBox="0 0 22 22" fill="none" aria-hidden="true">
      <rect x="1" y="8" width="4" height="6" rx="1" fill="#56c78a" />
      <rect x="7.5" y="4" width="4" height="14" rx="1" fill="#e9b44c" />
      <rect x="14" y="1.5" width="4" height="19" rx="1" fill="#ea6150" />
    </svg>
  );
}

function Boot() {
  const { bootError } = useApp();

  return (
    <div className="boot">
      <section className="panel boot-card">
        <div className="row">
          <BrandMark />
          <h1 className="panel-title">Scribe</h1>
        </div>

        {bootError ? (
          <div style={{ marginTop: 18 }}>
            <ErrorNotice
              error={bootError}
              action={
                <button
                  type="button"
                  className="btn btn-small"
                  onClick={() => window.location.reload()}
                >
                  Try again
                </button>
              }
            />
          </div>
        ) : (
          <>
            <p className="panel-note">
              Setting up a demo workspace. This creates one Meteroid customer — nothing else.
            </p>
            <div className="boot-steps">
              <div className="boot-step">
                <span className="pulse" /> GET /api/health
              </div>
              <div className="boot-step">
                <span className="pulse" /> POST /api/session
              </div>
              <div className="boot-step">
                <span className="pulse" /> GET /api/me · /api/plans · /api/entitlements
              </div>
            </div>
            <p className="panel-note" style={{ marginTop: 16 }}>
              {API_BASE_URL}
            </p>
          </>
        )}
      </section>
    </div>
  );
}

function Banner() {
  const { notice, dismissNotice } = useApp();
  if (!notice) return null;

  return (
    <div className={`banner banner-${notice.tone}`} role="status">
      {notice.tone === "pending" && <span className="spin" />}
      <div className="banner-body">{notice.message}</div>
      <button type="button" className="btn btn-small btn-quiet" onClick={dismissNotice}>
        Dismiss
      </button>
    </div>
  );
}

const SCREENS: Record<Route, () => React.JSX.Element> = {
  studio: Studio,
  usage: Usage,
  plans: Plans,
  billing: Billing,
  settings: Settings,
};

export function App() {
  const route = useRoute();
  const { booting, quota, me, health, workspace } = useApp();

  if (booting || (!workspace && me.error)) return <Boot />;

  const Screen = SCREENS[route];
  const planCode = me.data?.subscription?.plan_code ?? null;

  return (
    <div className="shell">
      <header className="rail">
        <div className="rail-inner">
          <div className="brand">
            <BrandMark />
            Scribe
          </div>

          <span className="chip">{health ? `${health.backend} backend` : API_BASE_URL}</span>

          {planCode ? (
            <span className="chip chip-plan">{planCode}</span>
          ) : (
            <button
              type="button"
              className="btn btn-small btn-primary"
              onClick={() => navigate("plans")}
            >
              Choose a plan
            </button>
          )}

          <div className="rail-meter">
            {quota ? (
              <LevelMeter quota={quota} />
            ) : (
              <span className="label">no metered entitlement</span>
            )}
          </div>
        </div>

        <nav className="tabs">
          {ROUTES.map((item) => (
            <button
              key={item}
              type="button"
              className={`tab ${item === route ? "tab-active" : ""}`.trim()}
              onClick={() => navigate(item)}
              aria-current={item === route ? "page" : undefined}
            >
              {TAB_LABELS[item]}
            </button>
          ))}
        </nav>
      </header>

      <main className="main">
        <Banner />
        <Screen />
      </main>

      <footer className="foot">
        <div className="foot-inner">
          <span>
            Scribe is a fictional service demonstrating the Meteroid SDKs. Plans, entitlements and
            usage are real Meteroid objects; the transcripts are not.
          </span>
          <span className="num">{workspace?.customer_alias}</span>
        </div>
      </footer>
    </div>
  );
}
