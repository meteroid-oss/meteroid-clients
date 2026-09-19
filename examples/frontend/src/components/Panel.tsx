import type { ReactNode } from "react";

/**
 * A rack panel: silkscreened label, optional control on the right, and a body.
 *
 * `testId` is threaded through because `tests/e2e/support/selectors.ts` treats `data-testid`
 * values as API — a panel that a spec addresses has to be able to carry one without the spec
 * reaching for a class name that exists for styling reasons.
 */
export function Panel({
  eyebrow,
  title,
  actions,
  children,
  className = "",
  bodyClassName = "panel-body",
  testId,
}: {
  eyebrow?: string;
  title?: ReactNode;
  actions?: ReactNode;
  children: ReactNode;
  className?: string;
  bodyClassName?: string;
  testId?: string;
}) {
  return (
    <section className={`panel ${className}`.trim()} data-testid={testId}>
      {(title || eyebrow || actions) && (
        <header className="panel-head">
          <div>
            {eyebrow && <div className="label">{eyebrow}</div>}
            {title && <h2 className="panel-title">{title}</h2>}
          </div>
          {actions}
        </header>
      )}
      <div className={bodyClassName}>{children}</div>
    </section>
  );
}
