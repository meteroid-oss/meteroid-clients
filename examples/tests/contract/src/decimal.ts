/**
 * Exact decimal arithmetic on the contract's decimal *strings*.
 *
 * The contract keeps every Meteroid `format: decimal` value as a string precisely so it
 * survives a round trip, so the suite must not parse those values with `Number()` to
 * compare them — that is the bug the rule exists to prevent, and a suite that does it
 * cannot catch a backend that does it. Everything here is `bigint` on scaled integers.
 *
 * Values compare numerically, not textually: `"1"`, `"1.0"` and `"1.00"` are the same
 * balance, and a backend is free to emit any of them.
 */

export const DECIMAL_PATTERN = /^-?\d+(\.\d+)?$/;

export function isDecimalString(value: unknown): value is string {
  return typeof value === 'string' && DECIMAL_PATTERN.test(value);
}

interface Scaled {
  units: bigint;
  scale: number;
}

function parse(value: string, label: string): Scaled {
  if (!isDecimalString(value)) {
    throw new Error(`${label} is not a contract decimal string: ${JSON.stringify(value)}`);
  }
  const [whole, fraction = ''] = value.split('.');
  const negative = whole.startsWith('-');
  const digits = `${whole.replace('-', '')}${fraction}`;
  const units = BigInt(digits) * (negative ? -1n : 1n);
  return { units, scale: fraction.length };
}

function align(a: Scaled, b: Scaled): [bigint, bigint] {
  const scale = Math.max(a.scale, b.scale);
  const lift = (value: Scaled) => value.units * 10n ** BigInt(scale - value.scale);
  return [lift(a), lift(b)];
}

function render({ units, scale }: Scaled): string {
  if (scale === 0) return units.toString();
  const negative = units < 0n;
  const digits = (negative ? -units : units).toString().padStart(scale + 1, '0');
  const whole = digits.slice(0, digits.length - scale);
  const fraction = digits.slice(digits.length - scale).replace(/0+$/, '');
  return `${negative ? '-' : ''}${whole}${fraction ? `.${fraction}` : ''}`;
}

/** -1, 0 or 1. Numeric comparison, so `"1"` and `"1.00"` are equal. */
export function compareDecimal(a: string, b: string, label = 'decimal'): number {
  const [left, right] = align(parse(a, `${label} (left)`), parse(b, `${label} (right)`));
  if (left < right) return -1;
  if (left > right) return 1;
  return 0;
}

export function decimalsEqual(a: string, b: string): boolean {
  return compareDecimal(a, b) === 0;
}

export function subtractDecimal(a: string, b: string): string {
  const left = parse(a, 'minuend');
  const right = parse(b, 'subtrahend');
  const scale = Math.max(left.scale, right.scale);
  const [x, y] = align(left, right);
  return render({ units: x - y, scale });
}

export function addDecimal(a: string, b: string): string {
  const left = parse(a, 'augend');
  const right = parse(b, 'addend');
  const scale = Math.max(left.scale, right.scale);
  const [x, y] = align(left, right);
  return render({ units: x + y, scale });
}

/**
 * The minutes the contract says a transcription bills: `duration_seconds / 60`, rounded
 * **up** to two decimals. Computed with integer arithmetic so the expectation is exact —
 * `100 / 60` is `1.67`, never `1.6666666666666667`.
 */
export function billableMinutes(durationSeconds: number): string {
  if (!Number.isInteger(durationSeconds) || durationSeconds < 0) {
    throw new Error(`durationSeconds must be a non-negative integer, got ${durationSeconds}`);
  }
  const hundredths = (BigInt(durationSeconds) * 100n + 59n) / 60n; // ceiling division
  return render({ units: hundredths, scale: 2 });
}

/** The whole seconds that bill *at least* `minutes`. Used to build a request that overruns a quota. */
export function secondsForMinutes(minutes: string): number {
  const { units, scale } = parse(minutes, 'minutes');
  const seconds = (units * 60n + (10n ** BigInt(scale) - 1n)) / 10n ** BigInt(scale);
  return Number(seconds);
}
