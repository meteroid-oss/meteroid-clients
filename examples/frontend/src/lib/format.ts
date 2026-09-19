/**
 * Formatting helpers.
 *
 * Two rules from the contract are load-bearing here:
 *
 *  - Quantities (usage, limits, entitlement values) are **exact decimal strings**. They are never
 *    parsed into a JS number for anything but a bar width, and they are formatted by string
 *    surgery so `"0.30"` cannot come back as `0.30000000000000004`.
 *  - Invoice money is an **integer in minor units**, not a decimal. It is the one exception, and
 *    it is converted with the currency's own exponent rather than a hard-coded 100.
 */
import type { Currency, Decimal } from "../api/types";

/** Group an integer digit string in threes: "1234567" -> "1,234,567". */
function groupDigits(digits: string): string {
  return digits.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

/**
 * Render a decimal string for humans without ever touching floating point.
 * `"60"` -> `60`, `"3.50"` -> `3.5`, `"1234.5"` -> `1,234.5`.
 */
export function formatDecimal(value: Decimal): string {
  const negative = value.startsWith("-");
  const [rawInt = "0", rawFrac = ""] = value.replace(/^-/, "").split(".");
  const frac = rawFrac.replace(/0+$/, "");
  return (negative ? "-" : "") + groupDigits(rawInt) + (frac ? `.${frac}` : "");
}

/** How many fraction digits this currency uses (2 for USD, 0 for JPY). */
function currencyExponent(currency: Currency): number {
  try {
    return (
      new Intl.NumberFormat(undefined, { style: "currency", currency }).resolvedOptions()
        .maximumFractionDigits ?? 2
    );
  } catch {
    return 2;
  }
}

/** Format an invoice amount, which arrives as an integer number of minor units. */
export function formatMoney(minorUnits: number, currency: Currency): string {
  const exponent = currencyExponent(currency);
  const major = minorUnits / 10 ** exponent;
  try {
    return new Intl.NumberFormat(undefined, { style: "currency", currency }).format(major);
  } catch {
    return `${major.toFixed(exponent)} ${currency}`;
  }
}

/** Format a plan price, which arrives as a decimal string in major units. */
export function formatPrice(amount: Decimal, currency: Currency): string {
  const numeric = Number(amount);
  if (!Number.isFinite(numeric)) return `${amount} ${currency}`;
  try {
    return new Intl.NumberFormat(undefined, {
      style: "currency",
      currency,
      minimumFractionDigits: 0,
      maximumFractionDigits: currencyExponent(currency),
    }).format(numeric);
  } catch {
    return `${formatDecimal(amount)} ${currency}`;
  }
}

/** A `YYYY-MM-DD` date, rendered without dragging it through a timezone. */
export function formatDate(date: string): string {
  const [year, month, day] = date.split("-").map(Number);
  if (!year || !month || !day) return date;
  return new Date(Date.UTC(year, month - 1, day)).toLocaleDateString(undefined, {
    day: "numeric",
    month: "short",
    year: "numeric",
    timeZone: "UTC",
  });
}

/** An RFC 3339 timestamp, rendered in the viewer's timezone. */
export function formatDateTime(timestamp: string): string {
  const parsed = new Date(timestamp);
  if (Number.isNaN(parsed.getTime())) return timestamp;
  return parsed.toLocaleString(undefined, {
    day: "numeric",
    month: "short",
    hour: "2-digit",
    minute: "2-digit",
  });
}

/** An RFC 3339 timestamp as a bare day, for tight columns: "1 Oct". */
export function formatDay(timestamp: string): string {
  const parsed = new Date(timestamp);
  if (Number.isNaN(parsed.getTime())) return timestamp;
  return parsed.toLocaleDateString(undefined, { day: "numeric", month: "short" });
}

/** Seconds as a studio timecode: 210 -> "3:30". */
export function timecode(seconds: number): string {
  const minutes = Math.floor(seconds / 60);
  return `${minutes}:${String(seconds % 60).padStart(2, "0")}`;
}

/**
 * The minutes a clip will be billed for, matching the backend rule exactly:
 * `duration_seconds / 60`, rounded up to two decimals. Integer arithmetic throughout, so the
 * preview in the composer and the number the backend reports to Meteroid always agree.
 */
export function billableMinutes(durationSeconds: number): Decimal {
  const hundredths = Math.ceil((durationSeconds * 100) / 60);
  const whole = Math.floor(hundredths / 100);
  const rest = String(hundredths % 100).padStart(2, "0");
  return rest === "00" ? String(whole) : `${whole}.${rest}`.replace(/0$/, "");
}

/**
 * Is this decimal string zero or negative? Answered on the digits themselves rather than through
 * `Number()`, so a balance like `"0.0000000001"` is not rounded into "empty".
 */
export function isExhausted(remaining: Decimal | null): boolean {
  if (remaining === null) return false;
  if (remaining.startsWith("-")) return true;
  return /^0*(\.0*)?$/.test(remaining);
}

/**
 * Fraction of a quota that has been consumed, for the meter's width only.
 * Display maths, never a gating decision — the backend owns the quota check, in exact decimals.
 */
export function consumedFraction(consumed: Decimal | null, limit: Decimal | null): number {
  const used = Number(consumed ?? "0");
  const cap = Number(limit ?? "0");
  if (!Number.isFinite(used) || !Number.isFinite(cap) || cap <= 0) return 0;
  return Math.min(1, Math.max(0, used / cap));
}
