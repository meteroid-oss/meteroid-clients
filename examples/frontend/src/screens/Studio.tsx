/**
 * The studio — where the metered action happens.
 *
 * Everything on this screen exists to make one thing visible: what a metered entitlement does to a
 * product. The meter is always on screen, the composer previews the minutes it is about to bill,
 * and when the quota runs out the composer is *replaced* by the locked panel — the demo degrades
 * in place rather than flashing a toast, because "you are out of minutes" is a state, not an event.
 */
import { useState, type FormEvent } from "react";
import type { ApiError } from "../api/client";
import type { PlanCode } from "../api/types";
import { ErrorNotice } from "../components/ErrorNotice";
import { LevelMeter } from "../components/LevelMeter";
import { Panel } from "../components/Panel";
import { billableMinutes, formatDateTime, formatDay, formatDecimal, timecode } from "../lib/format";
import { navigate } from "../lib/router";
import { useApp } from "../state/app";

const DEFAULT_TITLE = "Weekly standup";

export function Studio() {
  const { quota, block, transcriptions, entitlements, transcribe, checkout } = useApp();
  const [title, setTitle] = useState(DEFAULT_TITLE);
  const [duration, setDuration] = useState(210);
  const [running, setRunning] = useState(false);
  const [error, setError] = useState<ApiError | null>(null);
  const [upgrading, setUpgrading] = useState(false);

  const minutes = billableMinutes(duration);
  const lastEvent = transcriptions.data[0]?.event_id ?? null;

  async function submit(event: FormEvent) {
    event.preventDefault();
    setRunning(true);
    setError(null);
    const result = await transcribe(title.trim() || DEFAULT_TITLE, duration);
    setRunning(false);
    if (!result.ok && result.error.code !== "QUOTA_EXHAUSTED" && result.error.code !== "FEATURE_NOT_ENTITLED") {
      setError(result.error);
    }
  }

  async function upgrade(planCode: PlanCode | null) {
    if (!planCode) {
      navigate("plans");
      return;
    }
    setUpgrading(true);
    try {
      await checkout(planCode);
    } catch (caught) {
      setError(caught as ApiError);
      setUpgrading(false);
    }
  }

  return (
    <>
      <header className="screen-head">
        <h1 className="screen-title">Studio</h1>
        <p className="screen-sub">
          Transcribe a clip. Each one reports its billed minutes to Meteroid as a usage event and
          draws down the <code>transcription_minutes</code> entitlement.
        </p>
      </header>

      <div className="studio">
        <div className="stack">
          {block ? (
            <Panel
              className="locked"
              eyebrow="metered action"
              title="Transcription is locked"
              testId="quota-exhausted"
            >
              <div className="locked-head">
                <span className="lamp lamp-on">
                  {block.reason === "quota" ? "clip" : "no entitlement"}
                </span>
              </div>
              <h3 className="locked-title">
                {block.reason === "quota"
                  ? "You are out of transcription minutes."
                  : "This plan does not include transcription."}
              </h3>
              <p className="locked-message">{block.message}</p>
              <div className="locked-actions">
                <button
                  type="button"
                  data-testid="upgrade-cta"
                  className="btn btn-primary"
                  onClick={() => void upgrade(block.upgradePlanCode)}
                  disabled={upgrading}
                >
                  {upgrading && <span className="spin" />}
                  {block.upgradePlanCode ? (
                    <>
                      Upgrade to{" "}
                      {/* The plan code alone, unpunctuated: the e2e suite asserts this element's
                          text equals the `upgrade_plan_code` the 402 carried. */}
                      <span data-testid="upgrade-plan-code">{block.upgradePlanCode}</span>
                    </>
                  ) : (
                    "See plans"
                  )}
                </button>
                <button type="button" className="btn btn-quiet" onClick={() => navigate("plans")}>
                  Compare plans
                </button>
              </div>
              {block.quota?.reset_at && (
                <p className="panel-note">
                  Or wait — the counter resets on {formatDateTime(block.quota.reset_at)}.
                </p>
              )}
            </Panel>
          ) : (
            <Panel eyebrow="new transcription" title="Transcribe a clip">
              <form className="composer" onSubmit={(event) => void submit(event)}>
                <div className="field">
                  <label className="label" htmlFor="title">
                    title
                  </label>
                  <input
                    id="title"
                    data-testid="transcribe-title"
                    className="input"
                    value={title}
                    maxLength={200}
                    placeholder={DEFAULT_TITLE}
                    onChange={(event) => setTitle(event.target.value)}
                  />
                </div>

                <div className="field">
                  <div className="duration-readout">
                    <label className="label" htmlFor="duration">
                      clip length
                    </label>
                    <span className="label">
                      bills {formatDecimal(minutes)} min
                    </span>
                  </div>
                  <div className="timecode">{timecode(duration)}</div>
                  {/* Value is in SECONDS, and the range is the contract's own
                      `duration_seconds` range, so a value the UI accepts is always a value the
                      backend accepts. `tests/e2e` addresses this control by testid and sets it in
                      seconds — see selectors.ts. */}
                  <input
                    id="duration"
                    data-testid="transcribe-duration"
                    className="slider"
                    type="range"
                    min={30}
                    max={7200}
                    step={30}
                    value={duration}
                    onChange={(event) => setDuration(Number(event.target.value))}
                  />
                </div>

                <div className="composer-foot">
                  <span className="label">
                    posts one event · code transcription_minutes
                  </span>
                  <button
                    type="submit"
                    data-testid="transcribe-submit"
                    className="btn btn-primary"
                    disabled={running}
                  >
                    {running && <span className="spin" />}
                    {running ? "Transcribing…" : "Transcribe"}
                  </button>
                </div>
              </form>
            </Panel>
          )}

          {error && <ErrorNotice error={error} />}

          <Panel
            eyebrow="history"
            title="Transcriptions"
            actions={<span className="chip">{transcriptions.data.length}</span>}
            bodyClassName="list"
          >
            {transcriptions.data.length === 0 ? (
              <p className="empty">
                Nothing yet. Transcribe a clip and it shows up here — and in Meteroid&apos;s usage
                for this period.
              </p>
            ) : (
              transcriptions.data.map((item) => (
                <article key={item.id} className="list-row">
                  <div className="list-main">
                    <h3 className="list-title">{item.title}</h3>
                    <div className="list-meta">
                      {timecode(item.duration_seconds)} · {formatDecimal(item.minutes_billed)} min
                      billed · {formatDateTime(item.created_at)} · event {item.event_id}
                    </div>
                    <p className="transcript">{item.text}</p>
                  </div>
                </article>
              ))
            )}
          </Panel>
        </div>

        <div className="stack">
          <Panel eyebrow="entitlement" title="transcription_minutes">
            {quota ? (
              <>
                <LevelMeter quota={quota} size="large" />
                <div className="quota-facts">
                  <div className="fact">
                    <div className="label">consumed</div>
                    <div className="fact-value">
                      {quota.consumed === null ? "—" : formatDecimal(quota.consumed)}
                    </div>
                  </div>
                  <div className="fact">
                    <div className="label">limit</div>
                    <div className="fact-value">
                      {quota.limit === null ? "∞" : formatDecimal(quota.limit)}
                    </div>
                  </div>
                  <div className="fact">
                    <div className="label">resets</div>
                    <div className="fact-value">
                      {quota.reset_at ? formatDay(quota.reset_at) : "—"}
                    </div>
                  </div>
                </div>
                <p className="panel-note">
                  Read from <code>GET /api/entitlements</code>, then advanced locally by the quota
                  the backend returns with each transcription. Meteroid&apos;s own counters are
                  eventually consistent, so Usage may lag this by a few seconds.
                </p>
              </>
            ) : entitlements.error ? (
              <ErrorNotice error={entitlements.error} />
            ) : (
              <p className="empty">
                No metered entitlement yet. Subscribe to a plan and the meter appears.
              </p>
            )}
          </Panel>

          <Panel eyebrow="how it bills" title="One transcription, three calls">
            <ol className="steps">
              <li className="step">
                <div className="step-body">
                  <div className="step-title">Read the entitlement</div>
                  <div className="step-detail">GET /customers/&#123;alias&#125;/entitlements</div>
                </div>
              </li>
              <li className="step">
                <div className="step-body">
                  <div className="step-title">Check the balance, in exact decimals</div>
                  <div className="step-detail">short by any amount &rarr; 402, and no event is sent</div>
                </div>
              </li>
              <li className="step">
                <div className="step-body">
                  <div className="step-title">Report the consumption</div>
                  <div className="step-detail">POST /events/ingest &middot; one event, keyed by alias</div>
                </div>
              </li>
            </ol>
            {lastEvent && (
              <p className="panel-note">
                Last event id <span className="num">{lastEvent}</span> — deterministic per
                transcription, so a retry is idempotent.
              </p>
            )}
          </Panel>
        </div>
      </div>
    </>
  );
}
