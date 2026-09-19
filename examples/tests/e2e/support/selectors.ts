/**
 * The SPA contract this suite drives against.
 *
 * `examples/openapi.yaml` pins the HTTP surface between the frontend and the backends. Nothing
 * pins the surface between the *tests* and the frontend, so this file is it: every DOM hook the
 * suite depends on, named once, in one place.
 *
 * The rule for the frontend: these are `data-testid` attributes and they are API. Rename a heading,
 * restructure a component, swap the CSS framework — none of that may change a value below without
 * changing it here too. Testids are used rather than text or CSS because text is copy (it changes
 * for product reasons) and CSS is layout (it changes for design reasons); neither should be able to
 * break a billing test.
 *
 * They are deliberately few. Everything the contract suite can assert over HTTP is asserted there
 * instead, so this list covers only what genuinely needs a browser.
 */
export const testIds = {
  /** Root of the pricing table. Present once plans have loaded. */
  pricingTable: 'pricing-table',
  /** Per-plan checkout button. `data-testid="checkout-pro"`, etc. */
  checkoutButton: (planCode: string) => `checkout-${planCode}`,

  /** Opens the Meteroid customer portal in a new tab. */
  managePortalButton: 'manage-billing',

  /** The transcribe form and its fields. */
  transcribeTitle: 'transcribe-title',
  /**
   * Duration input, in **seconds** — the same unit and the same range (1..7200) as the contract's
   * `duration_seconds`. If the UI would rather show minutes, it converts on submit and this testid
   * still goes on a control whose value is seconds, because a test that has to know the conversion
   * is a test that breaks when the copy changes.
   */
  transcribeDuration: 'transcribe-duration',
  transcribeSubmit: 'transcribe-submit',

  /**
   * The quota widget. Rendered from `QuotaSnapshot`, so it exists whenever the workspace has a
   * metered entitlement.
   */
  quotaMeter: 'quota-meter',
  /** Text content is the remaining balance as returned by the API — a decimal string. */
  quotaRemaining: 'quota-remaining',

  /**
   * The quota-exhausted state: what the visitor sees after a `402 QUOTA_EXHAUSTED`.
   * This is the single most important thing in the demo, so the suite pins all three parts.
   */
  quotaExhausted: 'quota-exhausted',
  /** Text content is the `upgrade_plan_code` from the error body, e.g. `pro`. */
  upgradePlanCode: 'upgrade-plan-code',
  /** The call to action that starts a checkout for that plan. */
  upgradeCta: 'upgrade-cta',
} as const;
