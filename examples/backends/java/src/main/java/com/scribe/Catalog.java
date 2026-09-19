package com.scribe;

import com.meteroid.Meteroid;
import com.meteroid.api.PlansListPlansOptions;
import com.meteroid.exceptions.ApiException;
import com.meteroid.models.BillingPeriodEnum;
import com.meteroid.models.CapacityThreshold;
import com.meteroid.models.ConfigValue;
import com.meteroid.models.Fee;
import com.meteroid.models.Plan;
import com.meteroid.models.PlanListResponse;
import com.meteroid.models.PlanStatusEnum;
import com.meteroid.models.PlanTypeEnum;
import com.meteroid.models.PlanUsagePricingModel;
import com.meteroid.models.PriceComponent;
import com.meteroid.models.ResetPeriod;
import com.meteroid.models.ResolvedEntitlement;
import com.meteroid.models.ResolvedEntitlementListResponse;
import com.meteroid.models.ResolvedEntitlementValue;
import com.meteroid.models.TermRate;
import com.meteroid.models.TrialConfig;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Catalog resolution — the Java twin of the Rust backend's {@code src/catalog.rs}.
 *
 * <p>The demo <b>never creates catalog objects</b>: the operator seeds them once, by hand
 * ({@code examples/CATALOG.md}). Everything here is a lookup by a stable identifier, and every
 * failure becomes {@code 503 CATALOG_NOT_SEEDED} naming exactly what was missing.
 *
 * <p>Two things are resolved:
 *
 * <ul>
 *   <li>the four <b>features</b>, by code, which is what tells an unseeded tenant apart from a
 *       workspace that simply has no subscription (both show zero entitlements); and
 *   <li>the three <b>plans</b>, by their exact seeded name, because Meteroid plans carry no
 *       user-supplied code.
 * </ul>
 */
public final class Catalog {

    /** The four feature codes this demo gates on. Seeded in the dashboard; GET-only over REST. */
    public static final List<String> FEATURE_CODES =
            List.of("transcription_minutes", "sso", "retention_days", "seats");

    /**
     * The metered feature the transcription endpoint enforces, and the billable metric code the
     * ingested events carry.
     */
    public static final String TRANSCRIPTION_MINUTES = "transcription_minutes";

    private static final String SEED_HINT = "Seed the catalog per examples/CATALOG.md.";

    /** In {@link PlanCode#ALL} order — cheapest first. */
    private final List<Dto.Plan> plans;

    /** Meteroid plan id → the demo's plan code, for labelling a subscription's plan. */
    private final Map<String, PlanCode> planCodesById;

    private Catalog(List<Dto.Plan> plans, Map<String, PlanCode> planCodesById) {
        this.plans = List.copyOf(plans);
        this.planCodesById = Map.copyOf(planCodesById);
    }

    public List<Dto.Plan> plans() {
        return plans;
    }

    public Dto.Plan plan(PlanCode code) {
        for (Dto.Plan plan : plans) {
            if (plan.code() == code) {
                return plan;
            }
        }
        throw new IllegalStateException("the catalog always holds every plan code once resolved");
    }

    /**
     * Label a Meteroid subscription's plan. Matches on {@code plan_id} first — a dashboard rename
     * then still resolves — and falls back to the exact seeded name.
     */
    public PlanCode planCodeFor(String planId, String planName) {
        PlanCode byId = planCodesById.get(planId);
        if (byId != null) {
            return byId;
        }
        for (PlanCode code : PlanCode.ALL) {
            if (code.meteroidPlanName().equals(planName)) {
                return code;
            }
        }
        return null;
    }

    // ------------------------------------------------------------------ resolution

    /**
     * Resolve the whole catalog. Called by {@link CatalogCache}, which caches only successes so
     * that seeding the tenant while the demo runs fixes it without a restart.
     */
    static Catalog resolve(Meteroid meteroid, MetricCache metrics, String expectedCurrency) {
        // 1. The four features must exist. This is the check that keeps an unseeded tenant from
        //    masquerading as "your plan doesn't include that" on the first transcription.
        for (String code : FEATURE_CODES) {
            try {
                meteroid.getFeatures().getFeature(code);
            } catch (ApiException e) {
                if (ApiError.isNotFound(e)) {
                    throw ApiError.catalogNotSeeded(
                            "No feature with code \""
                                    + code
                                    + "\". Features cannot be created over the REST API; create it"
                                    + " in the Meteroid dashboard. "
                                    + SEED_HINT);
                }
                throw ApiError.upstream("GET /api/v1/features/" + code, e);
            } catch (java.io.IOException e) {
                throw ApiError.unreachable("GET /api/v1/features/" + code, e);
            }
        }

        // 2. metric id → code, used to name the unit of usage-priced components below.
        metrics.refresh(meteroid);

        // 3. The three plans, by exact seeded name.
        List<Dto.Plan> plans = new ArrayList<>(PlanCode.ALL.length);
        Map<String, PlanCode> planCodesById = new HashMap<>();
        for (PlanCode code : PlanCode.ALL) {
            Dto.Plan plan = resolvePlan(meteroid, metrics, code, expectedCurrency);
            planCodesById.put(plan.planId(), code);
            plans.add(plan);
        }

        return new Catalog(plans, planCodesById);
    }

    private static Dto.Plan resolvePlan(
            Meteroid meteroid, MetricCache metrics, PlanCode code, String expectedCurrency) {
        String name = code.meteroidPlanName();

        // `search` is a fuzzy name match — "Scribe" alone returns all three plans — so the
        // exact-name filter below is what actually pins the plan down.
        PlansListPlansOptions options = new PlansListPlansOptions();
        options.setSearch(name);
        options.setStatus(List.of(PlanStatusEnum.ACTIVE));
        options.setPerPage(100);

        PlanListResponse found =
                Upstream.call("GET /api/v1/plans", () -> meteroid.getPlans().listPlans(options));

        Plan plan =
                found.getData().stream()
                        .filter(candidate -> name.equals(candidate.getName()))
                        .findFirst()
                        .orElseThrow(
                                () ->
                                        ApiError.catalogNotSeeded(
                                                "No published plan named \""
                                                        + name
                                                        + "\" (plan_code="
                                                        + code.wireValue()
                                                        + "). "
                                                        + SEED_HINT));

        // Meteroid refuses to check a customer out against a plan version in another currency, so
        // catching the mismatch here beats a confusing failure at checkout.
        if (!plan.getCurrency().equalsIgnoreCase(expectedCurrency)) {
            throw ApiError.catalogNotSeeded(
                    "Plan \""
                            + name
                            + "\" is priced in "
                            + plan.getCurrency()
                            + " but SCRIBE_DEFAULT_CURRENCY is "
                            + expectedCurrency
                            + "; Meteroid will not check out a customer against a plan in another"
                            + " currency.");
        }

        // The marketing bullets come from the plan version's entitlements, so the pricing page and
        // the enforcement path cannot drift apart.
        String versionId = plan.getVersionId();
        ResolvedEntitlementListResponse entitlements =
                Upstream.call(
                        "GET /api/v1/plan-versions/" + versionId + "/entitlements",
                        () -> meteroid.getPlans().listPlanVersionEntitlements(versionId));

        List<Dto.PlanFeatureLine> features = new ArrayList<>();
        for (ResolvedEntitlement entitlement : entitlements.getData()) {
            features.add(
                    new Dto.PlanFeatureLine(
                            entitlement.getFeature().getCode(),
                            featureLabel(
                                    entitlement.getFeature().getName(), entitlement.getValue())));
        }

        List<Dto.PlanPrice> prices = new ArrayList<>();
        for (PriceComponent component : plan.getPriceComponents()) {
            // A component with no fee has nothing to show, so it is dropped entirely.
            if (component.getFee() != null) {
                prices.add(flattenFee(metrics, component));
            }
        }

        TrialConfig trial = plan.getTrial();
        return new Dto.Plan(
                code,
                plan.getName(),
                plan.getDescription(),
                plan.getId(),
                versionId,
                plan.getVersion(),
                plan.getCurrency(),
                plan.getPlanType() == PlanTypeEnum.FREE,
                trial == null ? null : trial.getDurationDays(),
                prices,
                features);
    }

    // ------------------------------------------------------------------ price flattening

    /**
     * Flatten one Meteroid price component into the display-oriented {@code PlanPrice} of the
     * contract. Deliberately lossy: this renders a pricing table, it does not reprice.
     */
    private static Dto.PlanPrice flattenFee(MetricCache metrics, PriceComponent component) {
        String componentId = component.getId();
        String name = component.getName();
        Fee fee = component.getFee();

        String kind;
        String cadence = null;
        String amount = null;
        String unitAmount = null;
        String includedAmount = null;
        String unitName = null;
        String pricingModel = null;

        if (fee instanceof Fee.Rate rate) {
            kind = "RATE";
            TermRate term = pickTerm(rate.getData().getRates());
            if (term != null) {
                cadence = term.getTerm().getValue();
                amount = Dto.decimal(term.getPrice());
            }
        } else if (fee instanceof Fee.Slot slot) {
            kind = "SLOT";
            unitName = slot.getData().getSlotUnitName();
            TermRate term = pickTerm(slot.getData().getRates());
            if (term != null) {
                cadence = term.getTerm().getValue();
                amount = Dto.decimal(term.getPrice());
            }
        } else if (fee instanceof Fee.Capacity capacity) {
            kind = "CAPACITY";
            cadence = capacity.getData().getCadence().getValue();
            unitName = metrics.cachedCodeFor(capacity.getData().getMetricId());
            List<CapacityThreshold> thresholds = capacity.getData().getThresholds();
            if (thresholds != null && !thresholds.isEmpty()) {
                CapacityThreshold threshold = thresholds.get(0);
                amount = Dto.decimal(threshold.getPrice());
                unitAmount = Dto.decimal(threshold.getPerUnitOverage());
                includedAmount = Dto.decimal(BigDecimal.valueOf(threshold.getIncludedAmount()));
            }
        } else if (fee instanceof Fee.Usage usage) {
            kind = "USAGE";
            cadence = usage.getData().getCadence().getValue();
            unitName = metrics.cachedCodeFor(usage.getData().getMetricId());
            PlanUsagePricingModel pricing = usage.getData().getPricing();
            pricingModel = pricing.getType();
            // Only PER_UNIT has a single displayable unit price.
            if (pricing instanceof PlanUsagePricingModel.PerUnit perUnit) {
                unitAmount = Dto.decimal(perUnit.getData().getRate());
            }
        } else if (fee instanceof Fee.ExtraRecurring extra) {
            kind = "EXTRA_RECURRING";
            cadence = extra.getData().getCadence().getValue();
            amount = Dto.decimal(extra.getData().getUnitPrice());
        } else if (fee instanceof Fee.OneTime oneTime) {
            kind = "ONE_TIME";
            amount = Dto.decimal(oneTime.getData().getUnitPrice());
        } else {
            // Meteroid's `Fee` union is closed today; a new variant should show up in the pricing
            // table as an unpriced row rather than take the whole endpoint down.
            kind = fee.getType();
        }

        return new Dto.PlanPrice(
                componentId, name, kind, cadence, amount, unitAmount, includedAmount, unitName,
                pricingModel);
    }

    /**
     * A {@code RATE} or {@code SLOT} fee prices one billing term each. The table shows one of them:
     * the monthly term when it exists (that is what the seeded catalog uses), else the first.
     * Meteroid's {@code Plan} carries no cadence of its own to match against.
     */
    private static TermRate pickTerm(List<TermRate> rates) {
        if (rates == null || rates.isEmpty()) {
            return null;
        }
        for (TermRate rate : rates) {
            if (rate.getTerm() == BillingPeriodEnum.MONTHLY) {
                return rate;
            }
        }
        return rates.get(0);
    }

    // ------------------------------------------------------------------ marketing bullets

    /** Render one plan-version entitlement as a marketing bullet. */
    static String featureLabel(String featureName, ResolvedEntitlementValue value) {
        if (value instanceof ResolvedEntitlementValue.Boolean bool) {
            return bool.getData().getEnabled()
                    ? featureName + " included"
                    : featureName + " not included";
        }
        if (value instanceof ResolvedEntitlementValue.Metered metered) {
            var data = metered.getData();
            if (!data.getEnabled()) {
                return featureName + " not included";
            }
            if (data.getLimit() == null) {
                return "Unlimited " + lowerFirst(featureName);
            }
            return Dto.decimal(data.getLimit())
                    + " "
                    + lowerFirst(featureName)
                    + resetSuffix(data.getResetPeriod());
        }
        if (value instanceof ResolvedEntitlementValue.Config config) {
            ConfigValue configValue = config.getData().getValue();
            if (configValue instanceof ConfigValue.Number number) {
                return Dto.decimal(number.getData().getValue()) + " " + lowerFirst(featureName);
            }
            if (configValue instanceof ConfigValue.Boolean bool) {
                return bool.getData().getValue()
                        ? featureName + " included"
                        : featureName + " not included";
            }
            if (configValue instanceof ConfigValue.Text text) {
                return featureName + ": " + text.getData().getValue();
            }
            return featureName + " configured";
        }
        return featureName;
    }

    private static String resetSuffix(ResetPeriod resetPeriod) {
        if (resetPeriod instanceof ResetPeriod.BillingCycle) {
            return " per billing cycle";
        }
        if (resetPeriod instanceof ResetPeriod.Calendar calendar) {
            return " per "
                    + interval(calendar.getData().getInterval(), calendar.getData().getUnit().getValue());
        }
        if (resetPeriod instanceof ResetPeriod.FixedWindow window) {
            return " per "
                    + interval(window.getData().getInterval(), window.getData().getUnit().getValue());
        }
        if (resetPeriod instanceof ResetPeriod.SlidingWindow window) {
            return " per rolling "
                    + interval(window.getData().getInterval(), window.getData().getUnit().getValue());
        }
        // NEVER, and anything Meteroid adds later.
        return "";
    }

    private static String interval(int interval, String unit) {
        String lower = unit.toLowerCase(Locale.ROOT);
        return interval == 1 ? lower : interval + " " + lower + "s";
    }

    private static String lowerFirst(String value) {
        if (value.isEmpty()) {
            return value;
        }
        return value.substring(0, 1).toLowerCase(Locale.ROOT) + value.substring(1);
    }
}
