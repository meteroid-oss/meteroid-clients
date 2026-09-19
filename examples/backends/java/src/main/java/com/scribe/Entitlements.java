package com.scribe;

import com.meteroid.models.ConfigValue;
import com.meteroid.models.EffectiveEntitlement;
import com.meteroid.models.EffectiveEntitlementValue;
import com.meteroid.models.FeatureRef;
import com.meteroid.models.MeteredEffectiveEntitlementValue;
import com.meteroid.models.MeteredEntitlementSpec;
import com.meteroid.models.MeteredEntitlementUsage;
import com.meteroid.models.ResetPeriod;

import java.math.BigDecimal;
import java.util.List;

/**
 * Turning Meteroid's effective entitlements into the contract's normalized view — the Java twin of
 * the Rust backend's {@code src/entitlements.rs}.
 *
 * <p>This is the single most important piece of modelling in the demo, because it is what both the
 * UI gating and the server-side enforcement read.
 *
 * <p>Meteroid's {@code EffectiveEntitlementValue} is a {@code oneOf} tagged on {@code type}
 * ({@code BOOLEAN} / {@code METERED} / {@code CONFIG}), with the metered variant split into a
 * {@code spec} (what the plan grants) and a {@code usage} (what has been consumed). The contract
 * keeps the tag, flattens spec+usage into one object, and keeps every decimal a string.
 */
public final class Entitlements {

    private Entitlements() {}

    /**
     * Read the workspace's effective entitlements from Meteroid.
     *
     * <p>One call, by customer alias. Meteroid merges feature defaults, plan-version entitlements,
     * product and add-on entitlements, and attaches live usage counters.
     */
    public static List<EffectiveEntitlement> fetch(AppState state, String alias) {
        return Upstream.call(
                        "GET /api/v1/customers/" + alias + "/entitlements",
                        () -> state.meteroid.getCustomers().getEffectiveEntitlements(alias))
                .getData();
    }

    /** Project one Meteroid entitlement onto the contract's tagged union. */
    public static Dto.Entitlement normalize(AppState state, EffectiveEntitlement entitlement) {
        FeatureRef feature = entitlement.getFeature();
        EffectiveEntitlementValue value = entitlement.getValue();

        Dto.EntitlementValue normalized;
        if (value instanceof EffectiveEntitlementValue.Boolean bool) {
            normalized = new Dto.BooleanEntitlementValue(bool.getData().getEnabled());
        } else if (value instanceof EffectiveEntitlementValue.Metered metered) {
            MeteredEffectiveEntitlementValue data = metered.getData();
            // Meteroid names the metric behind an entitlement by id only. The code is
            // presentational (it lines this view up with `GET /api/usage`), so an unresolvable id
            // is a null rather than an error.
            String metricCode = state.metrics.codeFor(state.meteroid, data.getSpec().getMetricId());
            Dto.QuotaSnapshot quota = quotaSnapshot(feature.getCode(), data);

            normalized =
                    new Dto.MeteredEntitlementValue(
                            quota.enabled(),
                            quota.limit(),
                            quota.consumed(),
                            quota.remaining(),
                            quota.unlimited(),
                            quota.resetAt(),
                            resetPeriod(data.getSpec().getResetPeriod()),
                            metricCode);
        } else if (value instanceof EffectiveEntitlementValue.Config config) {
            normalized = new Dto.ConfigEntitlementValue(configValue(config.getData().getValue()));
        } else {
            throw ApiError.internal(
                    "Meteroid returned an entitlement of an unknown type for feature \""
                            + feature.getCode()
                            + "\".");
        }

        return new Dto.Entitlement(feature.getCode(), feature.getName(), normalized);
    }

    /**
     * The consumption state of a metered entitlement, as both the entitlement view and the
     * quota-exhausted error report it.
     *
     * <p>{@code remaining} is the number the quota check compares against, and Meteroid does not
     * always supply it: {@code MeteredEntitlementUsage} requires none of its properties, so an
     * entitlement whose counter has not been written yet arrives with {@code remaining} absent but
     * {@code limit} set. The contract therefore fixes the fallback — {@code limit - consumed}, then
     * {@code limit} — so that a limited entitlement always reports a balance and Rust and Java can
     * never disagree about it.
     */
    public static Dto.QuotaSnapshot quotaSnapshot(
            String featureCode, MeteredEffectiveEntitlementValue metered) {
        MeteredEntitlementSpec spec = metered.getSpec();
        MeteredEntitlementUsage usage = metered.getUsage();

        BigDecimal limit = spec.getLimit();
        BigDecimal consumed = usage == null ? null : usage.getConsumed();
        BigDecimal remaining =
                remainingBalance(limit, consumed, usage == null ? null : usage.getRemaining());

        return new Dto.QuotaSnapshot(
                featureCode,
                spec.getEnabled(),
                Dto.decimalOrNull(limit),
                Dto.decimalOrNull(consumed),
                Dto.decimalOrNull(remaining),
                usage == null ? null : Dto.timestamp(usage.getResetAt()),
                // A null limit is Meteroid's way of saying "unlimited"; mirroring it as a boolean
                // saves every client the same null special-case.
                limit == null);
    }

    /**
     * Exact decimal arithmetic, never binary floating point — this is money. {@code null} means
     * unlimited.
     */
    public static BigDecimal remainingBalance(
            BigDecimal limit, BigDecimal consumed, BigDecimal reported) {
        if (limit == null) {
            return null;
        }
        if (reported != null) {
            return reported;
        }
        return limit.subtract(consumed == null ? BigDecimal.ZERO : consumed);
    }

    /**
     * Meteroid models the reset period as its own five-variant tagged union, but every variant
     * beyond the tag carries at most an {@code interval}+{@code unit} pair. The contract keeps the
     * tag and makes both fields nullable rather than nesting a second union inside the first.
     */
    static Dto.ResetPeriod resetPeriod(ResetPeriod period) {
        if (period instanceof ResetPeriod.Calendar calendar) {
            return new Dto.ResetPeriod(
                    "CALENDAR",
                    calendar.getData().getInterval(),
                    calendar.getData().getUnit().getValue());
        }
        if (period instanceof ResetPeriod.FixedWindow window) {
            return new Dto.ResetPeriod(
                    "FIXED_WINDOW",
                    window.getData().getInterval(),
                    window.getData().getUnit().getValue());
        }
        if (period instanceof ResetPeriod.SlidingWindow window) {
            return new Dto.ResetPeriod(
                    "SLIDING_WINDOW",
                    window.getData().getInterval(),
                    window.getData().getUnit().getValue());
        }
        // BILLING_CYCLE and NEVER carry nothing but the tag.
        return new Dto.ResetPeriod(period.getType(), null, null);
    }

    /**
     * Meteroid's {@code ConfigValueType} also lists {@code MAP} and {@code SELECT}, but its {@code
     * ConfigValue} union carries only these four, which is exactly the set the contract exposes.
     */
    static Dto.ConfigValue configValue(ConfigValue value) {
        if (value instanceof ConfigValue.Number number) {
            // Numbers stay decimal strings: Meteroid types this `format: decimal`.
            return new Dto.NumberConfigValue(Dto.decimal(number.getData().getValue()));
        }
        if (value instanceof ConfigValue.Boolean bool) {
            return new Dto.BooleanConfigValue(bool.getData().getValue());
        }
        if (value instanceof ConfigValue.Text text) {
            return new Dto.TextConfigValue(text.getData().getValue());
        }
        if (value instanceof ConfigValue.Json json) {
            return new Dto.JsonConfigValue(json.getData().getValue());
        }
        throw ApiError.internal("Meteroid returned a config value of an unknown kind.");
    }
}
