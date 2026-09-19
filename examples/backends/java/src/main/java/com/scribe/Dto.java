package com.scribe;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/**
 * The wire types of {@code examples/openapi.yaml}, one record per schema — the Java twin of the
 * Rust backend's {@code src/dto.rs}. They are nested in one class so the file lines up with that
 * one, and so {@code Dto.Plan} never collides with {@code com.meteroid.models.Plan}.
 *
 * <p>Two rules from the contract are enforced here by construction:
 *
 * <ul>
 *   <li><b>Decimals are strings.</b> Every Meteroid {@code format: decimal} value is carried as a
 *       {@link String} produced by {@link #decimal}, never as a JSON number.
 *   <li><b>Nullable means present-and-null.</b> The application's {@code ObjectMapper} is left at
 *       Jackson's default inclusion, so every response object serializes every key. A strict
 *       deserializer on the other side never has to distinguish "absent" from "null".
 * </ul>
 *
 * <p>Record components are camelCase and the mapper applies a snake_case naming strategy (see
 * {@link Json}), so {@code planVersionId} goes out as {@code plan_version_id}.
 */
public final class Dto {

    private Dto() {}

    // ---------------------------------------------------------------- shared

    private static final DateTimeFormatter RFC3339_SECONDS =
            DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss'Z'").withZone(ZoneOffset.UTC);

    /**
     * Render a decimal the way the contract requires: an exact string, trailing zeros trimmed,
     * never scientific notation. {@code BigDecimal.toString()} would emit {@code 6E+2} for a
     * stripped {@code 600}, which the contract's {@code Decimal} pattern rejects.
     */
    public static String decimal(BigDecimal value) {
        return value.stripTrailingZeros().toPlainString();
    }

    public static String decimalOrNull(BigDecimal value) {
        return value == null ? null : decimal(value);
    }

    /** RFC 3339 in UTC, always with a seconds field — {@code 2026-10-01T00:00:00Z}. */
    public static String timestamp(OffsetDateTime value) {
        return value == null ? null : RFC3339_SECONDS.format(value.toInstant());
    }

    // ---------------------------------------------------------------- ops

    public record Health(String status, String backend, boolean meteroidConfigured, String version) {}

    // ---------------------------------------------------------------- session

    /** All fields optional; the backend generates whatever is not supplied. */
    public record CreateSessionRequest(String workspaceName, String email) {}

    public record Workspace(
            String id, String name, String customerId, String customerAlias, String currency) {}

    public record CreateSessionResponse(String sessionToken, Workspace workspace) {}

    public record Subscription(
            String id,
            String status,
            PlanCode planCode,
            String planName,
            String planVersionId,
            String currency,
            String currentPeriodStart,
            String currentPeriodEnd,
            Integer trialDurationDays,
            String createdAt) {}

    public record MeResponse(Workspace workspace, Subscription subscription, Plan plan) {}

    // ---------------------------------------------------------------- catalog

    public record PlanPrice(
            String componentId,
            String name,
            String kind,
            String cadence,
            String amount,
            String unitAmount,
            String includedAmount,
            String unitName,
            String pricingModel) {}

    public record PlanFeatureLine(String featureCode, String label) {}

    public record Plan(
            PlanCode code,
            String name,
            String description,
            String planId,
            String planVersionId,
            int version,
            String currency,
            boolean isFree,
            Integer trialDays,
            List<PlanPrice> prices,
            List<PlanFeatureLine> features) {}

    public record PlanListResponse(List<Plan> plans) {}

    // ---------------------------------------------------------------- checkout

    public record CreateCheckoutRequest(PlanCode planCode, String couponCode) {}

    public record CreateCheckoutResponse(
            String checkoutUrl,
            String checkoutSessionId,
            PlanCode planCode,
            String planVersionId,
            String expiresAt) {}

    // ----------------------------------------------------------- entitlements

    public record ResetPeriod(String type, Integer interval, String unit) {}

    public record QuotaSnapshot(
            String featureCode,
            boolean enabled,
            String limit,
            String consumed,
            String remaining,
            String resetAt,
            boolean unlimited) {

        /** The projection {@code POST /api/transcriptions} returns: this snapshot minus what it billed. */
        public QuotaSnapshot minus(BigDecimal billed) {
            BigDecimal alreadyConsumed = consumed == null ? BigDecimal.ZERO : new BigDecimal(consumed);
            return new QuotaSnapshot(
                    featureCode,
                    enabled,
                    limit,
                    decimal(alreadyConsumed.add(billed)),
                    remaining == null ? null : decimal(new BigDecimal(remaining).subtract(billed)),
                    resetAt,
                    unlimited);
        }
    }

    /**
     * The three-way entitlement union, tagged by {@code type} exactly as Meteroid tags it. Clients
     * switch on {@code type} and never guess from the shape.
     */
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
    @JsonSubTypes({
        @JsonSubTypes.Type(value = BooleanEntitlementValue.class, name = "BOOLEAN"),
        @JsonSubTypes.Type(value = MeteredEntitlementValue.class, name = "METERED"),
        @JsonSubTypes.Type(value = ConfigEntitlementValue.class, name = "CONFIG")
    })
    public sealed interface EntitlementValue {}

    public record BooleanEntitlementValue(boolean enabled) implements EntitlementValue {}

    public record MeteredEntitlementValue(
            boolean enabled,
            String limit,
            String consumed,
            String remaining,
            boolean unlimited,
            String resetAt,
            ResetPeriod resetPeriod,
            String metricCode)
            implements EntitlementValue {}

    public record ConfigEntitlementValue(ConfigValue value) implements EntitlementValue {}

    /** A typed configuration value, tagged by {@code kind}. */
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "kind")
    @JsonSubTypes({
        @JsonSubTypes.Type(value = NumberConfigValue.class, name = "NUMBER"),
        @JsonSubTypes.Type(value = BooleanConfigValue.class, name = "BOOLEAN"),
        @JsonSubTypes.Type(value = TextConfigValue.class, name = "TEXT"),
        @JsonSubTypes.Type(value = JsonConfigValue.class, name = "JSON")
    })
    public sealed interface ConfigValue {}

    /** Meteroid types a number config value {@code format: decimal}, so it stays a string. */
    public record NumberConfigValue(String value) implements ConfigValue {}

    public record BooleanConfigValue(boolean value) implements ConfigValue {}

    public record TextConfigValue(String value) implements ConfigValue {}

    /** Arbitrary JSON, passed through unchanged — any JSON value, {@code null} included. */
    public record JsonConfigValue(Object value) implements ConfigValue {}

    public record Entitlement(String featureCode, String featureName, EntitlementValue value) {}

    public record EntitlementListResponse(List<Entitlement> entitlements) {}

    // ----------------------------------------------------------- transcription

    public record CreateTranscriptionRequest(String title, Integer durationSeconds) {}

    public record Transcription(
            String id,
            String title,
            int durationSeconds,
            String minutesBilled,
            String text,
            String createdAt,
            String eventId) {}

    public record CreateTranscriptionResponse(Transcription transcription, QuotaSnapshot quota) {}

    public record TranscriptionListResponse(List<Transcription> transcriptions) {}

    // ---------------------------------------------------------------- usage

    public record GroupedUsage(Map<String, String> dimensions, String value) {}

    public record MetricUsage(
            String metricCode, String metricName, String totalValue, List<GroupedUsage> groupedUsage) {}

    public record UsageResponse(
            String periodStart, String periodEnd, String scope, List<MetricUsage> metrics) {}

    // ---------------------------------------------------------------- portal

    public record CreatePortalSessionRequest(Integer expiresInSeconds) {}

    public record CreatePortalSessionResponse(String portalUrl, String token, int expiresInSeconds) {}

    // ---------------------------------------------------------------- invoices

    public record Invoice(
            String id,
            String invoiceNumber,
            String status,
            String currency,
            String invoiceDate,
            String dueDate,
            long total,
            long amountDue) {}

    public record InvoiceListResponse(List<Invoice> invoices) {}

    // ---------------------------------------------------------------- webhooks

    public record WebhookAck(boolean received, String eventId, String type, boolean handled) {}
}
