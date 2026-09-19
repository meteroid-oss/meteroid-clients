package com.scribe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.meteroid.models.BillingCycleResetPeriod;
import com.meteroid.models.BooleanResolvedEntitlementValue;
import com.meteroid.models.ConfigResolvedEntitlementValue;
import com.meteroid.models.ConfigValue;
import com.meteroid.models.MeteredResolvedEntitlementValue;
import com.meteroid.models.NumberConfigValue;
import com.meteroid.models.ResetPeriod;
import com.meteroid.models.ResolvedEntitlementValue;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/** The marketing bullets on the pricing page, derived from the plan version's entitlements. */
class CatalogTest {

    @Test
    void labelsAMeteredLimit() {
        ResolvedEntitlementValue value =
                new ResolvedEntitlementValue.Metered(
                        new MeteredResolvedEntitlementValue()
                                .enabled(true)
                                .limit(BigDecimal.valueOf(600))
                                .metricId("met_1")
                                .resetPeriod(
                                        new ResetPeriod.BillingCycle(new BillingCycleResetPeriod())));
        assertEquals(
                "600 transcription minutes per billing cycle",
                Catalog.featureLabel("Transcription minutes", value));
    }

    @Test
    void labelsAnUnlimitedEntitlement() {
        ResolvedEntitlementValue value =
                new ResolvedEntitlementValue.Metered(
                        new MeteredResolvedEntitlementValue()
                                .enabled(true)
                                .metricId("met_1")
                                .resetPeriod(
                                        new ResetPeriod.BillingCycle(new BillingCycleResetPeriod())));
        assertEquals(
                "Unlimited transcription minutes",
                Catalog.featureLabel("Transcription minutes", value));
    }

    @Test
    void labelsBooleanAndConfig() {
        ResolvedEntitlementValue sso =
                new ResolvedEntitlementValue.Boolean(
                        new BooleanResolvedEntitlementValue().enabled(true));
        assertEquals("SSO included", Catalog.featureLabel("SSO", sso));

        ResolvedEntitlementValue retention =
                new ResolvedEntitlementValue.Config(
                        new ConfigResolvedEntitlementValue()
                                .value(
                                        new ConfigValue.Number(
                                                new NumberConfigValue()
                                                        .value(BigDecimal.valueOf(90)))));
        assertEquals("90 retention days", Catalog.featureLabel("Retention days", retention));
    }

    /** The plan-code ladder the {@code 402} / {@code 403} upsell walks. */
    @Test
    void walksThePlanLadderOneStepAtATime() {
        assertEquals(PlanCode.PRO, PlanCode.FREE.nextUp());
        assertEquals(PlanCode.SCALE, PlanCode.PRO.nextUp());
        assertNull(PlanCode.SCALE.nextUp());
    }

    /** Plans are resolved by their exact seeded Meteroid name — see examples/CATALOG.md. */
    @Test
    void mapsEachCodeOntoItsSeededPlanName() {
        assertEquals("Scribe Free", PlanCode.FREE.meteroidPlanName());
        assertEquals("Scribe Pro", PlanCode.PRO.meteroidPlanName());
        assertEquals("Scribe Scale", PlanCode.SCALE.meteroidPlanName());
    }
}
