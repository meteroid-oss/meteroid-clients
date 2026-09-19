package com.scribe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.meteroid.models.BillingCycleResetPeriod;
import com.meteroid.models.BooleanConfigValue;
import com.meteroid.models.CalendarResetPeriod;
import com.meteroid.models.CalendarUnit;
import com.meteroid.models.ConfigValue;
import com.meteroid.models.MeteredEffectiveEntitlementValue;
import com.meteroid.models.MeteredEntitlementSpec;
import com.meteroid.models.MeteredEntitlementUsage;
import com.meteroid.models.NumberConfigValue;
import com.meteroid.models.ResetPeriod;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * The quota arithmetic, which is what a wrong answer here bills wrong. These mirror the Rust
 * backend's {@code entitlements.rs} tests case for case, so a divergence between the two backends
 * shows up as a failing test rather than as two different numbers in production.
 */
class EntitlementsTest {

    private static MeteredEffectiveEntitlementValue metered(
            Long limit, Long consumed, Long remaining) {
        return new MeteredEffectiveEntitlementValue()
                .spec(
                        new MeteredEntitlementSpec()
                                .enabled(true)
                                .limit(limit == null ? null : BigDecimal.valueOf(limit))
                                .metricId("met_1")
                                .resetPeriod(
                                        new ResetPeriod.BillingCycle(new BillingCycleResetPeriod())))
                .usage(
                        new MeteredEntitlementUsage()
                                .consumed(consumed == null ? null : BigDecimal.valueOf(consumed))
                                .remaining(remaining == null ? null : BigDecimal.valueOf(remaining)));
    }

    @Test
    void usesMeteroidsRemainingWhenItHasOne() {
        Dto.QuotaSnapshot quota =
                Entitlements.quotaSnapshot("transcription_minutes", metered(60L, 15L, 45L));
        assertEquals("45", quota.remaining());
        assertFalse(quota.unlimited());
    }

    @Test
    void derivesRemainingWhenMeteroidHasNoCounter() {
        Dto.QuotaSnapshot quota =
                Entitlements.quotaSnapshot("transcription_minutes", metered(60L, 15L, null));
        assertEquals("45", quota.remaining());

        Dto.QuotaSnapshot untouched =
                Entitlements.quotaSnapshot("transcription_minutes", metered(60L, null, null));
        assertEquals("60", untouched.remaining());
    }

    @Test
    void anAbsentLimitIsUnlimited() {
        Dto.QuotaSnapshot quota =
                Entitlements.quotaSnapshot("transcription_minutes", metered(null, 900L, null));
        assertTrue(quota.unlimited());
        assertNull(quota.limit());
        assertNull(quota.remaining());
        assertEquals("900", quota.consumed());
    }

    /** Meteroid's {@code MeteredEntitlementUsage} requires none of its properties. */
    @Test
    void toleratesAnEntitlementWithNoUsageObjectAtAll() {
        MeteredEffectiveEntitlementValue value =
                new MeteredEffectiveEntitlementValue()
                        .spec(
                                new MeteredEntitlementSpec()
                                        .enabled(true)
                                        .limit(BigDecimal.valueOf(30))
                                        .metricId("met_1")
                                        .resetPeriod(
                                                new ResetPeriod.BillingCycle(
                                                        new BillingCycleResetPeriod())));

        Dto.QuotaSnapshot quota = Entitlements.quotaSnapshot("transcription_minutes", value);
        assertEquals("30", quota.limit());
        assertNull(quota.consumed());
        assertEquals("30", quota.remaining());
        assertNull(quota.resetAt());
    }

    @Test
    void flattensTheResetPeriodUnionOntoOneTaggedObject() {
        Dto.ResetPeriod billingCycle =
                Entitlements.resetPeriod(new ResetPeriod.BillingCycle(new BillingCycleResetPeriod()));
        assertEquals("BILLING_CYCLE", billingCycle.type());
        assertNull(billingCycle.interval());
        assertNull(billingCycle.unit());

        Dto.ResetPeriod calendar =
                Entitlements.resetPeriod(
                        new ResetPeriod.Calendar(
                                new CalendarResetPeriod().interval(1).unit(CalendarUnit.MONTH)));
        assertEquals("CALENDAR", calendar.type());
        assertEquals(1, calendar.interval());
        assertEquals("MONTH", calendar.unit());
    }

    /** A number config value stays a decimal string — {@code retention_days: "90"}, never {@code 90}. */
    @Test
    void keepsConfigNumbersAsDecimalStrings() {
        Dto.ConfigValue value =
                Entitlements.configValue(
                        new ConfigValue.Number(
                                new NumberConfigValue().value(BigDecimal.valueOf(90))));
        assertEquals(new Dto.NumberConfigValue("90"), value);

        Dto.ConfigValue enabled =
                Entitlements.configValue(
                        new ConfigValue.Boolean(new BooleanConfigValue().value(true)));
        assertEquals(new Dto.BooleanConfigValue(true), enabled);
    }
}
