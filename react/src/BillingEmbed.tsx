import type {
  EmbedEvents,
  EmbedEventType,
  EmbedHandle,
  EmbedOptions,
  EmbedView,
} from "@meteroid/browser";
import { type CSSProperties, type RefObject, useEffect, useRef } from "react";
import { useMeteroid } from "./hooks";
import { useIsomorphicLayoutEffect } from "./provider";

type Callback<T extends EmbedEventType> = (event: EmbedEvents[T]) => void;

export interface BillingEmbedProps
  extends Omit<EmbedOptions, "view" | "className" | "onNavigate"> {
  view: EmbedView;
  /** Class name of the element the iframe is mounted in. */
  className?: string;
  style?: CSSProperties;
  onReady?: Callback<"ready">;
  onPlanChanged?: Callback<"plan_changed">;
  onSubscriptionCanceled?: Callback<"subscription_canceled">;
  onPaymentMethodAdded?: Callback<"payment_method_added">;
  onCheckoutOpened?: Callback<"checkout_opened">;
  onCheckoutCompleted?: Callback<"checkout_completed">;
  /**
   * Handle navigation yourself: the embed then asks (a portal page, or
   * `target: "checkout"` with its `url`) instead of opening it.
   */
  onNavigate?: Callback<"navigate">;
  /** No token could be fetched for the embed. */
  onError?: Callback<"error">;
}

function forward<T extends EmbedEventType>(
  handle: EmbedHandle,
  type: T,
  props: RefObject<BillingEmbedProps>,
  pick: (props: BillingEmbedProps) => Callback<T> | undefined
) {
  handle.on(type, (event) => pick(props.current)?.(event));
}

/**
 * An embedded view of the billing portal. Change events refresh the provider's
 * state, so gates and meters follow without a reload. Renders an empty placeholder
 * on the server.
 */
export function BillingEmbed(props: BillingEmbedProps) {
  const client = useMeteroid();
  const container = useRef<HTMLDivElement>(null);
  const latest = useRef(props);
  useIsomorphicLayoutEffect(() => {
    latest.current = props;
  });

  const { view, theme, accent, radius, bg, surface, text, border } = props;
  const { count, subscriptionId, branding, height, className, style } = props;
  const hostNavigation = props.onNavigate !== undefined;

  useEffect(() => {
    const handle = client.mountEmbed(container.current!, {
      view,
      theme,
      accent,
      radius,
      bg,
      surface,
      text,
      border,
      count,
      subscriptionId,
      branding,
      height,
      onNavigate: hostNavigation
        ? (event) => latest.current.onNavigate?.(event)
        : undefined,
    });
    forward(handle, "ready", latest, (p) => p.onReady);
    forward(handle, "plan_changed", latest, (p) => p.onPlanChanged);
    forward(handle, "subscription_canceled", latest, (p) => p.onSubscriptionCanceled);
    forward(handle, "payment_method_added", latest, (p) => p.onPaymentMethodAdded);
    forward(handle, "checkout_opened", latest, (p) => p.onCheckoutOpened);
    forward(handle, "checkout_completed", latest, (p) => p.onCheckoutCompleted);
    forward(handle, "error", latest, (p) => p.onError);
    return handle.destroy;
  }, [
    client,
    view,
    theme,
    accent,
    radius,
    bg,
    surface,
    text,
    border,
    count,
    subscriptionId,
    branding,
    height,
    hostNavigation,
  ]);

  return (
    <div ref={container} className={className} style={style} data-meteroid-embed={view} />
  );
}

export type BillingPortalProps = Omit<BillingEmbedProps, "view"> & { view?: EmbedView };

/** The full billing portal, embedded. */
export function BillingPortal({ view = "portal", ...props }: BillingPortalProps) {
  return <BillingEmbed view={view} {...props} />;
}
