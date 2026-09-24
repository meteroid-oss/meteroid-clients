import type { EntitlementCheck, EntitlementUsage } from "@meteroid/browser";
import type { CSSProperties, ReactNode } from "react";
import { useEntitlement } from "./hooks";
import type { FeatureCode } from "./register";

export interface UsageMeterState extends EntitlementCheck {
  /**
   * Share of the limit consumed, clamped to [0, 1], for display only (it goes
   * through floats). Undefined when unlimited or when usage is unknown.
   */
  ratio: number | undefined;
}

export interface UsageMeterProps {
  feature: FeatureCode;
  /** Render prop, to draw the meter yourself. */
  children?: (state: UsageMeterState) => ReactNode;
  className?: string;
}

function usageRatio(usage: EntitlementUsage | undefined): number | undefined {
  if (usage?.limit === undefined || usage.unknown) {
    return undefined;
  }
  const limit = Number(usage.limit);
  const consumed =
    usage.consumed !== undefined
      ? Number(usage.consumed)
      : limit - Number(usage.remaining);
  if (!(limit > 0)) {
    return 1;
  }
  return Number.isFinite(consumed)
    ? Math.min(1, Math.max(0, consumed / limit))
    : undefined;
}

/**
 * Usage of a metered feature. Without a render prop, renders unstyled markup to
 * style from `[data-meteroid-*]` attributes and the `--meteroid-usage-ratio` and
 * `--meteroid-usage-percent` CSS variables.
 */
export function UsageMeter({ feature, children, className }: UsageMeterProps) {
  const check = useEntitlement(feature);
  const ratio = usageRatio(check.usage);
  if (children) {
    return <>{children({ ...check, ratio })}</>;
  }

  const { status, hasAccess, usage, entitlement } = check;
  const style =
    ratio === undefined
      ? undefined
      : ({
          "--meteroid-usage-ratio": ratio,
          "--meteroid-usage-percent": `${ratio * 100}%`,
        } as CSSProperties);
  const name = entitlement?.feature.name ?? feature;
  return (
    <div
      className={className}
      style={style}
      data-meteroid-usage-meter=""
      data-meteroid-feature={feature}
      data-meteroid-status={status}
      data-meteroid-access={hasAccess ? "granted" : "denied"}
      data-meteroid-unlimited={usage && usage.limit === undefined ? "" : undefined}
      data-meteroid-unknown={usage?.unknown ? "" : undefined}
    >
      {usage && (
        <>
          <span data-meteroid-usage-label="">{name}</span>
          <span data-meteroid-usage-value="">
            {usage.consumed ?? ""}
            {usage.limit !== undefined && ` / ${usage.limit}`}
          </span>
          {ratio !== undefined && (
            <meter
              data-meteroid-usage-bar=""
              aria-label={name}
              min={0}
              max={1}
              value={ratio}
            />
          )}
        </>
      )}
    </div>
  );
}
