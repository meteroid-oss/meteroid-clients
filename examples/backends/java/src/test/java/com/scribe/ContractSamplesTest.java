package com.scribe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * One serialized sample per response schema in {@code examples/openapi.yaml}, asserted against the
 * contract's rules — the Java twin of the Rust backend's {@code contract_samples.rs}.
 *
 * <p>The rule these exist to protect is the one that is easiest to break by accident:
 * <b>in a response, nullable means present-and-null, never absent.</b> A stray {@code
 * @JsonInclude(NON_NULL)} anywhere would silently drop keys and break a strict client; here it
 * breaks the build instead.
 *
 * <p>Set {@code SCRIBE_SAMPLE_OUT=/tmp/samples.json} to dump the samples and validate them against
 * {@code examples/openapi.yaml} with any JSON Schema tool.
 */
class ContractSamplesTest {

    /** Every top-level response schema, with the exact key set the contract requires. */
    private static Map<String, Sample> samples() {
        Map<String, Sample> samples = new LinkedHashMap<>();

        samples.put(
                "Health",
                new Sample(
                        new Dto.Health("ok", "java", true, Main.VERSION),
                        "status", "backend", "meteroid_configured", "version"));

        Dto.Workspace workspace =
                new Dto.Workspace(
                        "scribe-demo-8f2a1c",
                        "Scribe demo workspace",
                        "cus_7n42DGM5Tflk9n8mt7Fhc7",
                        "scribe-demo-8f2a1c",
                        "USD");

        samples.put(
                "CreateSessionResponse",
                new Sample(
                        new Dto.CreateSessionResponse("v1.abc.def", workspace),
                        "session_token", "workspace"));

        // A never-subscribed workspace: `subscription` and `plan` are present and null.
        samples.put(
                "MeResponse",
                new Sample(
                        new Dto.MeResponse(workspace, null, null),
                        "workspace", "subscription", "plan"));

        samples.put(
                "MeResponse (subscribed)",
                new Sample(
                        new Dto.MeResponse(workspace, subscription(), plan()),
                        "workspace", "subscription", "plan"));

        samples.put("PlanListResponse", new Sample(new Dto.PlanListResponse(List.of(plan())), "plans"));

        samples.put(
                "CreateCheckoutResponse",
                new Sample(
                        new Dto.CreateCheckoutResponse(
                                "https://checkout.meteroid.com/cs_123",
                                "cs_123",
                                PlanCode.PRO,
                                "plv_123",
                                "2026-10-01T00:00:00Z"),
                        "checkout_url",
                        "checkout_session_id",
                        "plan_code",
                        "plan_version_id",
                        "expires_at"));

        samples.put(
                "EntitlementListResponse",
                new Sample(
                        new Dto.EntitlementListResponse(
                                List.of(
                                        new Dto.Entitlement(
                                                "transcription_minutes",
                                                "Transcription minutes",
                                                new Dto.MeteredEntitlementValue(
                                                        true,
                                                        "60",
                                                        "56.5",
                                                        "3.5",
                                                        false,
                                                        "2026-10-01T00:00:00Z",
                                                        new Dto.ResetPeriod(
                                                                "BILLING_CYCLE", null, null),
                                                        "transcription_minutes")),
                                        new Dto.Entitlement(
                                                "sso", "SSO", new Dto.BooleanEntitlementValue(true)),
                                        new Dto.Entitlement(
                                                "retention_days",
                                                "Retention days",
                                                new Dto.ConfigEntitlementValue(
                                                        new Dto.NumberConfigValue("90"))),
                                        // An unlimited entitlement with no counter yet: every
                                        // amount is present and null.
                                        new Dto.Entitlement(
                                                "seats",
                                                "Seats",
                                                new Dto.MeteredEntitlementValue(
                                                        true,
                                                        null,
                                                        null,
                                                        null,
                                                        true,
                                                        null,
                                                        new Dto.ResetPeriod("NEVER", null, null),
                                                        null)))),
                        "entitlements"));

        samples.put(
                "TranscriptionListResponse",
                new Sample(
                        new Dto.TranscriptionListResponse(List.of(transcription())),
                        "transcriptions"));

        samples.put(
                "CreateTranscriptionResponse",
                new Sample(
                        new Dto.CreateTranscriptionResponse(transcription(), quota()),
                        "transcription", "quota"));

        samples.put(
                "UsageResponse",
                new Sample(
                        new Dto.UsageResponse(
                                "2026-09-01",
                                "2026-09-30",
                                "subscription",
                                List.of(
                                        new Dto.MetricUsage(
                                                "transcription_minutes",
                                                "Transcription minutes",
                                                "56.5",
                                                List.of(
                                                        new Dto.GroupedUsage(
                                                                Map.of("region", "eu"), "12.5"))))),
                        "period_start", "period_end", "scope", "metrics"));

        samples.put(
                "CreatePortalSessionResponse",
                new Sample(
                        new Dto.CreatePortalSessionResponse(
                                "https://portal.meteroid.com", "jwt.token.here", 86400),
                        "portal_url", "token", "expires_in_seconds"));

        samples.put(
                "InvoiceListResponse",
                new Sample(
                        new Dto.InvoiceListResponse(
                                List.of(
                                        new Dto.Invoice(
                                                "inv_1",
                                                "INV-0001",
                                                "DRAFT",
                                                "USD",
                                                "2026-09-01",
                                                null,
                                                2900L,
                                                2900L))),
                        "invoices"));

        samples.put(
                "WebhookAck",
                new Sample(
                        new Dto.WebhookAck(true, "evt_1", "invoice.paid", true),
                        "received", "event_id", "type", "handled"));

        samples.put(
                "Error",
                new Sample(
                        new ApiError(ErrorCode.QUOTA_EXHAUSTED, "…")
                                .withQuota(quota())
                                .withUpgrade(PlanCode.PRO)
                                .envelope(),
                        "code", "message", "quota", "upgrade_plan_code"));

        samples.put(
                "Error (no quota)",
                new Sample(
                        new ApiError(ErrorCode.UNAUTHORIZED, "…").envelope(),
                        "code", "message", "quota", "upgrade_plan_code"));

        return samples;
    }

    @Test
    void everyResponseSchemaSerializesEveryKey() throws IOException {
        ObjectNode dump = Json.mapper().createObjectNode();

        for (Map.Entry<String, Sample> entry : samples().entrySet()) {
            JsonNode serialized = Json.mapper().valueToTree(entry.getValue().value());
            dump.set(entry.getKey(), serialized);

            assertEquals(
                    new TreeSet<>(entry.getValue().keys()),
                    keysOf(serialized),
                    entry.getKey() + " must serialize exactly the contract's key set");
        }

        String out = System.getenv("SCRIBE_SAMPLE_OUT");
        if (out != null && !out.isBlank()) {
            Files.writeString(Path.of(out), Json.mapper().writeValueAsString(dump));
        }
    }

    /** The two tagged unions carry their discriminator explicitly, exactly as Meteroid does. */
    @Test
    void taggedUnionsCarryTheirDiscriminator() {
        JsonNode metered =
                Json.mapper()
                        .valueToTree(
                                new Dto.MeteredEntitlementValue(
                                        true,
                                        "60",
                                        null,
                                        "60",
                                        false,
                                        null,
                                        new Dto.ResetPeriod("BILLING_CYCLE", null, null),
                                        null));
        assertEquals("METERED", metered.get("type").asText());
        // Nullable-but-present, all the way down.
        assertTrue(metered.get("consumed").isNull());
        assertTrue(metered.get("reset_at").isNull());
        assertTrue(metered.get("metric_code").isNull());

        assertEquals(
                "BOOLEAN",
                Json.mapper()
                        .valueToTree(new Dto.BooleanEntitlementValue(true))
                        .get("type")
                        .asText());
        assertEquals(
                "NUMBER",
                Json.mapper().valueToTree(new Dto.NumberConfigValue("90")).get("kind").asText());
        assertEquals(
                "JSON",
                Json.mapper().valueToTree(new Dto.JsonConfigValue(null)).get("kind").asText());
    }

    /** Every decimal is a JSON string, never a number — this is what makes them survive a round trip. */
    @Test
    void everyDecimalIsAString() {
        JsonNode quota = Json.mapper().valueToTree(quota());
        assertTrue(quota.get("limit").isTextual());
        assertTrue(quota.get("consumed").isTextual());
        assertTrue(quota.get("remaining").isTextual());

        JsonNode usage =
                Json.mapper()
                        .valueToTree(
                                new Dto.MetricUsage(
                                        "transcription_minutes",
                                        "Transcription minutes",
                                        Dto.decimal(new BigDecimal("56.50")),
                                        List.of()));
        assertTrue(usage.get("total_value").isTextual());
        assertEquals("56.5", usage.get("total_value").asText());
    }

    /** Invoice money is the one exception: integer minor units, matching Meteroid. */
    @Test
    void invoiceMoneyIsAnInteger() {
        JsonNode invoice =
                Json.mapper()
                        .valueToTree(
                                new Dto.Invoice(
                                        "inv_1", "INV-0001", "DRAFT", "USD", "2026-09-01", null,
                                        2900L, 2900L));
        assertTrue(invoice.get("total").isIntegralNumber());
        assertTrue(invoice.get("amount_due").isIntegralNumber());
        assertTrue(invoice.get("due_date").isNull());
    }

    // ------------------------------------------------------------------ fixtures

    private record Sample(Object value, Set<String> keys) {
        Sample(Object value, String... keys) {
            this(value, Set.of(keys));
        }
    }

    private static Set<String> keysOf(JsonNode node) {
        Set<String> keys = new TreeSet<>();
        Iterator<String> names = node.fieldNames();
        while (names.hasNext()) {
            keys.add(names.next());
        }
        return keys;
    }

    private static Dto.Subscription subscription() {
        return new Dto.Subscription(
                "sub_1",
                "ACTIVE",
                PlanCode.PRO,
                "Scribe Pro",
                "plv_123",
                "USD",
                "2026-09-01",
                "2026-09-30",
                null,
                "2026-09-01T12:00:00Z");
    }

    private static Dto.Plan plan() {
        List<Dto.PlanPrice> prices = new ArrayList<>();
        prices.add(
                new Dto.PlanPrice(
                        "pc_1", "Pro monthly", "RATE", "MONTHLY", "29", null, null, null, null));
        prices.add(
                new Dto.PlanPrice(
                        "pc_2",
                        "Overage minutes",
                        "USAGE",
                        "MONTHLY",
                        null,
                        "0.02",
                        null,
                        "transcription_minutes",
                        "PER_UNIT"));
        return new Dto.Plan(
                PlanCode.PRO,
                "Scribe Pro",
                "For teams that record every meeting.",
                "pln_123",
                "plv_123",
                1,
                "USD",
                false,
                14,
                prices,
                List.of(
                        new Dto.PlanFeatureLine(
                                "transcription_minutes", "600 transcription minutes per billing cycle"),
                        new Dto.PlanFeatureLine("sso", "SSO included")));
    }

    private static Dto.Transcription transcription() {
        return new Dto.Transcription(
                "tr_01J9Z4X0",
                "Weekly standup",
                210,
                "3.5",
                "[demo transcript] …",
                "2026-09-01T12:00:00Z",
                "tr_01J9Z4X0");
    }

    private static Dto.QuotaSnapshot quota() {
        return new Dto.QuotaSnapshot(
                "transcription_minutes", true, "60", "56.5", "3.5", "2026-10-01T00:00:00Z", false);
    }
}
