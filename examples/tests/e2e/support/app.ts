/**
 * Helpers for putting the SPA into a known state.
 *
 * Specs locate elements with Playwright's built-in `page.getByTestId(...)`, which reads the
 * `data-testid` attribute named in `playwright.config.ts`. The ids themselves live in
 * `selectors.ts`.
 */
import type { Page } from '@playwright/test';

import { FRONTEND_URL, SESSION_STORAGE_KEY } from './env.js';

/**
 * Signs the browser in as an existing workspace before the SPA's own scripts run.
 *
 * `addInitScript` is what makes this sleep-free: it executes on every navigation *before* any page
 * script, so the SPA boots already authenticated and there is no window in which it renders a
 * signed-out state we would then have to wait out.
 */
export async function useSession(page: Page, sessionToken: string): Promise<void> {
  await page.addInitScript(
    ([key, value]) => {
      try {
        window.localStorage.setItem(key, value);
      } catch {
        // Storage can be unavailable (private mode, blocked cookies). The spec's own assertions
        // report the resulting signed-out UI far more clearly than a throw from here would.
      }
    },
    [SESSION_STORAGE_KEY, sessionToken] as const,
  );
}

/**
 * The SPA's screens. It uses a **hash** router (`frontend/src/lib/router.ts`) so the return trip
 * from Meteroid's hosted checkout needs no dev-server rewrite rules, and it defaults to `studio`
 * when the hash names no known screen.
 *
 * Specs therefore have to ask for a screen by name: navigating to `/` lands on the studio, where
 * there is no pricing table and no billing button.
 */
export type Screen = 'studio' | 'usage' | 'plans' | 'billing' | 'settings';

/** Navigates to a screen of the SPA. */
export async function openApp(page: Page, screen: Screen = 'studio'): Promise<void> {
  await page.goto(`${FRONTEND_URL}/#/${screen}`);
}

/**
 * Sets the value of a form control addressed by testid, and tells React about it.
 *
 * Playwright's `fill()` refuses `input[type=range]`, and the duration control is a slider. Worse,
 * setting `.value` directly is invisible to React: React installs its own value setter on the
 * element, so a naive assignment updates the DOM while the component's state keeps the old number
 * and the form submits it. The fix is the standard one — call the *native* setter, then dispatch
 * the events React listens for.
 *
 * Written against the control's `value` rather than its type, so it keeps working if the slider
 * ever becomes a number input.
 */
export async function setControlValue(page: Page, testId: string, value: string): Promise<void> {
  await page.getByTestId(testId).evaluate((element, next) => {
    const input = element as HTMLInputElement;
    const prototype = Object.getPrototypeOf(input) as object;
    const setter = Object.getOwnPropertyDescriptor(prototype, 'value')?.set;
    if (setter) setter.call(input, next);
    else input.value = next;
    input.dispatchEvent(new Event('input', { bubbles: true }));
    input.dispatchEvent(new Event('change', { bubbles: true }));
  }, value);
}
