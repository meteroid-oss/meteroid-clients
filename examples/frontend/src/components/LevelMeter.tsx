/**
 * The signature instrument.
 *
 * A metered entitlement is a level: minutes consumed against minutes granted. So it is drawn as a
 * segmented level meter — nominal green, caution amber past three quarters, and a lit CLIP lamp
 * when the balance reaches zero. The meter lives in the top rail on every screen and again, full
 * size, in the studio, so the quota state is part of the furniture rather than a toast that
 * disappears before you have read it.
 *
 * It reads a `QuotaSnapshot`, which is what both `GET /api/entitlements` (via the store) and the
 * `402 QUOTA_EXHAUSTED` error body carry — one widget, one shape, no second rendering path.
 */
import type { QuotaSnapshot } from "../api/types";
import { consumedFraction, formatDecimal, isExhausted } from "../lib/format";

const SEGMENTS = 32;

export function LevelMeter({
  quota,
  size = "rail",
}: {
  quota: QuotaSnapshot;
  size?: "rail" | "large";
}) {
  const exhausted = isExhausted(quota.remaining);
  const fraction = quota.unlimited ? 0 : consumedFraction(quota.consumed, quota.limit);
  const lit = quota.unlimited ? 0 : Math.min(SEGMENTS, Math.ceil(fraction * SEGMENTS));

  const tone = quota.unlimited
    ? "meter-unlimited"
    : exhausted || fraction >= 1
      ? "meter-clip"
      : fraction >= 0.75
        ? "meter-caution"
        : "";

  const remaining = quota.unlimited ? "∞" : formatDecimal(quota.remaining ?? "0");
  const scale = quota.unlimited ? "unmetered" : `of ${formatDecimal(quota.limit ?? "0")}`;

  return (
    <div
      className={`meter ${tone} ${size === "large" ? "meter-large" : ""}`.trim()}
      // Only the full-size instance is the addressable one. The rail meter is a second copy of
      // the same state on the same page, and two elements under one testid would make every
      // `getByTestId('quota-meter')` in tests/e2e ambiguous.
      data-testid={size === "large" ? "quota-meter" : undefined}
      role="meter"
      aria-label="Transcription minutes remaining"
      aria-valuenow={quota.unlimited ? undefined : Number(quota.remaining ?? 0)}
      aria-valuemin={0}
      aria-valuemax={quota.unlimited ? undefined : Number(quota.limit ?? 0)}
      aria-valuetext={
        quota.unlimited ? "Unlimited minutes" : `${remaining} of ${quota.limit} minutes remaining`
      }
    >
      {size === "large" && (
        <div className="meter-readout">
          <div>
            {/* Text content is the remaining balance exactly as the API returned it — the e2e
                suite compares it against the decimal string in the response. */}
            <span className="meter-value" data-testid="quota-remaining">
              {remaining}
            </span>
            <span className="meter-unit">MIN LEFT {scale}</span>
          </div>
          <span className={`lamp ${exhausted ? "lamp-on" : ""}`.trim()}>clip</span>
        </div>
      )}

      <div className="meter-scale">
        {Array.from({ length: SEGMENTS }, (_, index) => (
          <span
            key={index}
            className={`meter-seg ${index < lit ? "meter-seg-lit" : ""}`.trim()}
            aria-hidden="true"
          />
        ))}
      </div>

      {size === "rail" && (
        <div className="meter-readout">
          <span className="label">minutes</span>
          <span className="meter-value">
            {remaining} {scale}
          </span>
        </div>
      )}
    </div>
  );
}
