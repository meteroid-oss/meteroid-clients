type ParsedDecimal = [sign: number, integer: string, fraction: string];

const DECIMAL_RE = /^([+-]?)(\d*)(?:\.(\d*))?$/;

function parseDecimal(value: string): ParsedDecimal | undefined {
  const match = DECIMAL_RE.exec(value.trim());
  if (match === null || (match[2] === "" && !match[3])) {
    return undefined;
  }
  const integer = match[2].replace(/^0+/, "");
  const fraction = (match[3] ?? "").replace(/0+$/, "");
  const sign = integer === "" && fraction === "" ? 0 : match[1] === "-" ? -1 : 1;
  return [sign, integer, fraction];
}

const compareDigits = (a: string, b: string): number => (a < b ? -1 : a > b ? 1 : 0);

/**
 * Compare two decimal strings (`"10000"`, `"0.5"`, `"-1"`) exactly, without going
 * through floating point: returns -1, 0 or 1, or `undefined` when either value is
 * not a plain decimal.
 */
export function compareDecimal(a: string, b: string): number | undefined {
  const x = parseDecimal(a);
  const y = parseDecimal(b);
  if (x === undefined || y === undefined) {
    return undefined;
  }
  if (x[0] !== y[0]) {
    return x[0] < y[0] ? -1 : 1;
  }
  const width = Math.max(x[2].length, y[2].length);
  const magnitude =
    x[1].length !== y[1].length
      ? Math.sign(x[1].length - y[1].length)
      : compareDigits(x[1], y[1]) ||
        compareDigits(x[2].padEnd(width, "0"), y[2].padEnd(width, "0"));
  return x[0] * magnitude || 0;
}
