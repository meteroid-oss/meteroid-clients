package com.scribe.routes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.scribe.Catalog;
import com.scribe.Dto;

import org.junit.jupiter.api.Test;

/** Billing arithmetic for the metered action, mirroring the Rust backend's tests case for case. */
class TranscriptionBillingTest {

    @Test
    void roundsBillableMinutesUpToTwoDecimals() {
        assertEquals("1", Dto.decimal(TranscriptionRoutes.billableMinutes(60)));
        assertEquals("3.5", Dto.decimal(TranscriptionRoutes.billableMinutes(210)));
        // 100/60 = 1.666… must never round down: the demo bills what it used.
        assertEquals("1.67", Dto.decimal(TranscriptionRoutes.billableMinutes(100)));
        assertEquals("0.02", Dto.decimal(TranscriptionRoutes.billableMinutes(1)));
    }

    @Test
    void projectsTheQuotaForward() {
        Dto.QuotaSnapshot quota =
                new Dto.QuotaSnapshot(
                        Catalog.TRANSCRIPTION_MINUTES, true, "60", "56.5", "3.5", null, false);
        Dto.QuotaSnapshot projected = quota.minus(TranscriptionRoutes.billableMinutes(60));
        assertEquals("57.5", projected.consumed());
        assertEquals("2.5", projected.remaining());
    }

    @Test
    void anUnlimitedQuotaStaysUnlimited() {
        Dto.QuotaSnapshot quota =
                new Dto.QuotaSnapshot(
                        Catalog.TRANSCRIPTION_MINUTES, true, null, null, null, null, true);
        Dto.QuotaSnapshot projected = quota.minus(TranscriptionRoutes.billableMinutes(120));
        assertTrue(projected.unlimited());
        assertNull(projected.limit());
        assertNull(projected.remaining());
        assertEquals("2", projected.consumed());
    }

    /** {@code BigDecimal.toString()} would emit {@code 6E+2} here, which the contract rejects. */
    @Test
    void neverEmitsScientificNotation() {
        assertEquals("600", Dto.decimal(new java.math.BigDecimal("600.00")));
        assertEquals("0", Dto.decimal(java.math.BigDecimal.ZERO));
        assertEquals("0.02", Dto.decimal(new java.math.BigDecimal("0.0200")));
    }
}
