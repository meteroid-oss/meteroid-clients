/**
 * Skipping, with the reason printed.
 *
 * Several tests need something this environment may not have — a webhook secret, a
 * workspace that has completed checkout, a plan with a finite quota. Skipping quietly
 * would let a run report "all green" while never touching the paths that matter, so
 * every skip says what is missing and how to supply it.
 */

export interface Skippable {
  skip: (note?: string) => void;
}

export function skipTest(context: Skippable, reason: string): never {
  console.warn(`  ↷ SKIPPED: ${reason}`);
  context.skip(reason);
  // `skip()` aborts the test; this only tells the compiler the function does not return.
  throw new Error(`skipped: ${reason}`);
}
