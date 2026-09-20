// Every test file runs in its own process under `node --test`, so this only
// affects this file. It must be set before any `Date` is created.
process.env.TZ = "Europe/Paris";

import assert from "node:assert/strict";
import { describe, it } from "node:test";
import { parseDateTime } from "../src/datetime";
import { AppliedCouponSerializer } from "../src/models/appliedCoupon";

describe("parseDateTime", () => {
  it("runs in a non-UTC time zone", () => {
    // Guards the tests below: in UTC they would pass even with `new Date()`.
    assert.equal(new Date("2026-09-19T10:00:00Z").getTimezoneOffset(), -120);
    // What `new Date()` does with an offset-less string: local time.
    assert.equal(
      new Date("2026-09-19T10:00:00.123").toISOString(),
      "2026-09-19T08:00:00.123Z"
    );
  });

  it("reads an offset-less date-time as UTC", () => {
    const d = parseDateTime("2026-09-19T10:00:00.123456");
    // A JS `Date` only has millisecond precision: the microseconds are dropped.
    assert.equal(d.toISOString(), "2026-09-19T10:00:00.123Z");
    assert.equal(d.getTime(), Date.UTC(2026, 8, 19, 10, 0, 0, 123));
  });

  it("handles offset-less values with and without fractional seconds", () => {
    assert.equal(
      parseDateTime("2026-09-19T10:00:00").toISOString(),
      "2026-09-19T10:00:00.000Z"
    );
    assert.equal(
      parseDateTime("2026-09-19T10:00:00.5").toISOString(),
      "2026-09-19T10:00:00.500Z"
    );
    assert.equal(
      parseDateTime("2026-09-19 10:00:00.999999").toISOString(),
      "2026-09-19T10:00:00.999Z"
    );
  });

  it("leaves `Z` values unchanged", () => {
    assert.equal(
      parseDateTime("2026-09-19T10:00:00.123Z").toISOString(),
      "2026-09-19T10:00:00.123Z"
    );
    assert.equal(
      parseDateTime("2026-09-19T10:00:00.123456789Z").toISOString(),
      "2026-09-19T10:00:00.123Z"
    );
  });

  it("keeps an explicit non-UTC offset", () => {
    assert.equal(
      parseDateTime("2026-09-19T12:00:00+02:00").toISOString(),
      "2026-09-19T10:00:00.000Z"
    );
    assert.equal(
      parseDateTime("2026-09-19T05:30:00.250-0430").toISOString(),
      "2026-09-19T10:00:00.250Z"
    );
    assert.equal(
      parseDateTime("2026-09-19T12:00:00+02").toISOString(),
      "2026-09-19T10:00:00.000Z"
    );
  });

  it("returns an invalid Date for garbage, like `new Date()`", () => {
    assert.ok(Number.isNaN(parseDateTime("not a date").getTime()));
  });
});

describe("generated models", () => {
  it("deserialize offset-less date-times as UTC", () => {
    const coupon = AppliedCouponSerializer._fromJsonObject({
      id: "ac_1",
      coupon_id: "c_1",
      is_active: true,
      created_at: "2026-09-19T10:00:00.123456",
      applied_amount: "1",
    });
    assert.ok(coupon.createdAt instanceof Date);
    assert.equal(coupon.createdAt.toISOString(), "2026-09-19T10:00:00.123Z");
    assert.equal(
      JSON.stringify(AppliedCouponSerializer._toJsonObject(coupon).created_at),
      '"2026-09-19T10:00:00.123Z"'
    );
  });
});
