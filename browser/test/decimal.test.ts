import assert from "node:assert/strict";
import { describe, it } from "node:test";
import { compareDecimal } from "../src/decimal";

describe("compareDecimal", () => {
  const cases: [string, string, number][] = [
    ["1", "2", -1],
    ["10000", "9999", 1],
    ["10000", "10000.000", 0],
    ["0.5", "0", 1],
    ["0.10", "0.1", 0],
    ["0.09", "0.1", -1],
    ["-1", "0", -1],
    ["-0", "0", 0],
    ["-2.5", "-2.25", -1],
    ["-2.25", "-2.5", 1],
    ["+3", "3", 0],
    ["007", "7", 0],
    [".5", "0.5", 0],
    // Beyond Number.MAX_SAFE_INTEGER, where floats would say "equal".
    ["9007199254740993", "9007199254740992", 1],
    ["0.30000000000000000001", "0.3", 1],
  ];
  for (const [a, b, expected] of cases) {
    it(`compares ${a} with ${b}`, () => {
      assert.equal(compareDecimal(a, b), expected);
      assert.equal(compareDecimal(b, a), -expected || 0);
    });
  }

  it("returns undefined for anything that is not a plain decimal", () => {
    for (const value of ["", ".", "-", "abc", "1e3", "1.2.3", "NaN", "Infinity"]) {
      assert.equal(compareDecimal(value, "0"), undefined, value);
    }
  });
});
