/**
 * Exact decimal arithmetic on decimal *strings*.
 *
 * The Meteroid TypeScript SDK types every `format: decimal` value as a `string`, because
 * a JS `number` cannot hold one losslessly — and it ships no arithmetic for them. The
 * quota check has to subtract and compare those values, so this does it on `bigint`
 * scaled integers. Nothing in this backend ever passes a decimal through `Number()`:
 * that is how a 0.1-minute clip eventually bills wrong.
 */

import { ApiError } from "./error.js";

const PATTERN = /^-?\d+(\.\d+)?$/;

interface Scaled {
  units: bigint;
  scale: number;
}

function parse(value: string): Scaled {
  // The `typeof` is not paranoia: the SDK's deserializers do not validate, so a decimal
  // Meteroid sent as a JSON number arrives here as a `number` typed `string`. Every
  // decimal this backend parses came from Meteroid, so a malformed one is an upstream
  // problem rather than a bug here or a bad request.
  if (typeof value !== "string" || !PATTERN.test(value)) {
    throw new ApiError(
      "UPSTREAM_ERROR",
      `Meteroid returned ${JSON.stringify(value)} where an exact decimal was expected.`,
    );
  }
  const [whole = "", fraction = ""] = value.split(".");
  const negative = whole.startsWith("-");
  const units = BigInt(`${whole.replace("-", "")}${fraction}`);
  return { units: negative ? -units : units, scale: fraction.length };
}

function align(a: Scaled, b: Scaled): [bigint, bigint, number] {
  const scale = Math.max(a.scale, b.scale);
  const lift = (value: Scaled) => value.units * 10n ** BigInt(scale - value.scale);
  return [lift(a), lift(b), scale];
}

/** Trailing zeros trimmed, never scientific notation — what the contract's `Decimal` wants. */
function render({ units, scale }: Scaled): string {
  const negative = units < 0n;
  const digits = (negative ? -units : units).toString().padStart(scale + 1, "0");
  const whole = digits.slice(0, digits.length - scale);
  const fraction = digits.slice(digits.length - scale).replace(/0+$/, "");
  return `${negative ? "-" : ""}${whole}${fraction ? `.${fraction}` : ""}`;
}

/** Render a Meteroid decimal the way the contract requires: `"3.50"` becomes `"3.5"`. */
export function normalize(value: string): string {
  return render(parse(value));
}

export function normalizeOpt(value: string | null | undefined): string | null {
  return value == null ? null : normalize(value);
}

export function add(a: string, b: string): string {
  const [x, y, scale] = align(parse(a), parse(b));
  return render({ units: x + y, scale });
}

export function subtract(a: string, b: string): string {
  const [x, y, scale] = align(parse(a), parse(b));
  return render({ units: x - y, scale });
}

/** Numeric, not textual: `"1"` and `"1.00"` are the same balance. */
export function greaterThan(a: string, b: string): boolean {
  const [x, y] = align(parse(a), parse(b));
  return x > y;
}

/**
 * `durationSeconds / 60`, rounded **up** to two decimals — the demo always bills at
 * least what it used. Integer ceiling division, so `100 / 60` is exactly `1.67`.
 */
export function billableMinutes(durationSeconds: number): string {
  const hundredths = (BigInt(durationSeconds) * 100n + 59n) / 60n;
  return render({ units: hundredths, scale: 2 });
}
