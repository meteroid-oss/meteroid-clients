package main

import (
	"context"
	"fmt"
	"slices"
	"strconv"
	"strings"
	"sync"
	"unicode"
	"unicode/utf8"

	meteroid "github.com/meteroid-oss/meteroid-clients/go"
)

// Catalog resolution.
//
// The demo **never creates catalog objects** — the operator seeds them once, by hand
// (examples/CATALOG.md). Everything here is a lookup by a stable identifier, and every
// failure becomes 503 CATALOG_NOT_SEEDED naming exactly what was missing.
//
// Two things are resolved:
//
//   - the four **features**, by code, which is what tells an unseeded tenant apart from
//     a workspace that simply has no subscription (both show zero entitlements); and
//   - the three **plans**, by their exact seeded name, because Meteroid plans carry no
//     user-supplied code.
//
// The result is cached for the life of the process once it succeeds. Failures are not
// cached, so seeding the tenant while the backend runs fixes it without a restart.

// featureCodes are the four feature codes this demo gates on. Seeded in the dashboard;
// GET-only over REST.
var featureCodes = []string{"transcription_minutes", "sso", "retention_days", "seats"}

// transcriptionMinutes is the metered feature the transcription endpoint enforces, and
// the billable metric code the ingested events carry.
const transcriptionMinutes = "transcription_minutes"

const seedHint = "Seed the catalog per examples/CATALOG.md."

type catalog struct {
	// plans is in planCodes order — cheapest first.
	plans []Plan
	// planCodesByID maps a Meteroid plan id onto the demo's plan code, for labelling a
	// subscription's plan.
	planCodesByID map[string]PlanCode
}

func (c *catalog) plan(code PlanCode) (*Plan, error) {
	for i := range c.plans {
		if c.plans[i].Code == code {
			return &c.plans[i], nil
		}
	}
	return nil, internalError("The resolved catalog holds no %q plan.", code)
}

// planCodeFor labels a Meteroid subscription's plan. It matches on the plan id first —
// a dashboard rename then still resolves — and falls back to the exact seeded name.
func (c *catalog) planCodeFor(planID, planName string) *PlanCode {
	if code, ok := c.planCodesByID[planID]; ok {
		return &code
	}
	for _, code := range planCodes {
		if meteroidPlanName[code] == planName {
			return &code
		}
	}
	return nil
}

// catalogCache is the process-wide cache of the resolved catalog. Only successes are
// cached.
type catalogCache struct {
	mu       sync.Mutex
	resolved *catalog
}

func (c *catalogCache) get(ctx context.Context, client *meteroid.Client, metrics *metricCache, expectedCurrency string) (*catalog, error) {
	c.mu.Lock()
	resolved := c.resolved
	c.mu.Unlock()
	if resolved != nil {
		return resolved, nil
	}

	// Resolved outside the lock: two cold requests may both do the work, which is
	// harmless, where holding the lock would queue every request behind one slow
	// Meteroid — and behind a caller whose context may be cancelled any moment.
	resolved, err := resolveCatalog(ctx, client, metrics, expectedCurrency)
	if err != nil {
		return nil, err
	}
	c.mu.Lock()
	c.resolved = resolved
	c.mu.Unlock()
	return resolved, nil
}

// metricCache maps metric ids back onto the codes application code actually knows.
// Meteroid identifies the metric behind a metered entitlement, and behind a
// USAGE/CAPACITY price component, by **id** only.
type metricCache struct {
	mu        sync.RWMutex
	codesByID map[string]string
}

// refresh loads (or reloads) the whole map. Cheap: one page covers any realistic demo
// tenant.
func (m *metricCache) refresh(ctx context.Context, client *meteroid.Client) error {
	response, err := client.Metrics().ListMetrics(ctx, &meteroid.MetricsListMetricsOptions{PerPage: ptr(int32(100))})
	if err != nil {
		return upstream("GET /api/v1/metrics", err)
	}

	codesByID := make(map[string]string, len(response.Data))
	for _, metric := range response.Data {
		codesByID[metric.Id] = metric.Code
	}
	m.mu.Lock()
	m.codesByID = codesByID
	m.mu.Unlock()
	return nil
}

// codeFor resolves one metric id, refreshing once on a miss so a metric seeded after
// startup still shows up. Nil is not fatal anywhere — the code is presentational.
func (m *metricCache) codeFor(ctx context.Context, client *meteroid.Client, metricID string) *string {
	if code := m.codeForCached(metricID); code != nil {
		return code
	}
	if err := m.refresh(ctx, client); err != nil {
		return nil
	}
	return m.codeForCached(metricID)
}

func (m *metricCache) codeForCached(metricID string) *string {
	m.mu.RLock()
	defer m.mu.RUnlock()
	if code, ok := m.codesByID[metricID]; ok {
		return &code
	}
	return nil
}

func resolveCatalog(ctx context.Context, client *meteroid.Client, metrics *metricCache, expectedCurrency string) (*catalog, error) {
	// 1. The four features must exist. This is the check that keeps an unseeded tenant
	//    from masquerading as "your plan doesn't include that" on the first transcription.
	for _, code := range featureCodes {
		_, err := client.Features().GetFeature(ctx, code)
		if isNotFound(err) {
			return nil, catalogNotSeeded("No feature with code %q. Features cannot be created over the "+
				"REST API; create it in the Meteroid dashboard. %s", code, seedHint)
		}
		if err != nil {
			return nil, upstream("GET /api/v1/features/"+code, err)
		}
	}

	// 2. metric id → code, used to name the unit of usage-priced components below.
	if err := metrics.refresh(ctx, client); err != nil {
		return nil, err
	}

	// 3. The three plans, by exact seeded name.
	resolved := &catalog{planCodesByID: make(map[string]PlanCode, len(planCodes))}
	for _, code := range planCodes {
		plan, err := resolvePlan(ctx, client, metrics, code, expectedCurrency)
		if err != nil {
			return nil, err
		}
		resolved.planCodesByID[plan.PlanID] = code
		resolved.plans = append(resolved.plans, plan)
	}
	return resolved, nil
}

func resolvePlan(ctx context.Context, client *meteroid.Client, metrics *metricCache, code PlanCode, expectedCurrency string) (Plan, error) {
	name := meteroidPlanName[code]

	// `search` is a fuzzy name match — "Scribe" alone returns all three plans — so the
	// exact-name filter below is what actually pins the plan down.
	found, err := client.Plans().ListPlans(ctx, &meteroid.PlansListPlansOptions{
		Search:  &name,
		Status:  []meteroid.PlanStatusEnum{meteroid.PlanStatusEnumActive},
		PerPage: ptr(int32(100)),
	})
	if err != nil {
		return Plan{}, upstream("GET /api/v1/plans", err)
	}

	index := slices.IndexFunc(found.Data, func(candidate meteroid.Plan) bool { return candidate.Name == name })
	if index < 0 {
		return Plan{}, catalogNotSeeded("No published plan named %q (plan_code=%s). %s", name, code, seedHint)
	}
	plan := found.Data[index]

	// Meteroid refuses to check a customer out against a plan version in another
	// currency, so catching the mismatch here beats a confusing failure at checkout.
	if !strings.EqualFold(plan.Currency, expectedCurrency) {
		return Plan{}, catalogNotSeeded("Plan %q is priced in %s but SCRIBE_DEFAULT_CURRENCY is %s; Meteroid "+
			"will not check out a customer against a plan in another currency.", name, plan.Currency, expectedCurrency)
	}

	// The marketing bullets come from the plan version's entitlements, so the pricing
	// page and the enforcement path cannot drift apart.
	entitlements, err := client.Plans().ListPlanVersionEntitlements(ctx, plan.VersionId)
	if err != nil {
		return Plan{}, upstream("GET /api/v1/plan-versions/"+plan.VersionId+"/entitlements", err)
	}

	features := make([]PlanFeatureLine, 0, len(entitlements.Data))
	for _, entitlement := range entitlements.Data {
		label, err := featureLabel(entitlement.Feature.Name, entitlement.Value)
		if err != nil {
			return Plan{}, err
		}
		features = append(features, PlanFeatureLine{FeatureCode: entitlement.Feature.Code, Label: label})
	}

	prices := make([]PlanPrice, 0, len(plan.PriceComponents))
	for _, component := range plan.PriceComponents {
		// A component with no fee has nothing to show, so it is dropped entirely.
		if component.Fee == nil {
			continue
		}
		price, err := flattenFee(metrics, component.Id, component.Name, *component.Fee)
		if err != nil {
			return Plan{}, err
		}
		prices = append(prices, price)
	}

	resolved := Plan{
		Code:          code,
		Name:          plan.Name,
		Description:   plan.Description,
		PlanID:        plan.Id,
		PlanVersionID: plan.VersionId,
		Version:       plan.Version,
		Currency:      plan.Currency,
		IsFree:        plan.PlanType == meteroid.PlanTypeEnumFree,
		Prices:        prices,
		Features:      features,
	}
	if plan.Trial != nil {
		resolved.TrialDays = &plan.Trial.DurationDays
	}
	return resolved, nil
}

// flattenFee flattens one Meteroid price component into the display-oriented PlanPrice
// of the contract. Deliberately lossy: this renders a pricing table, it does not reprice.
//
// The SDK models `Fee` as a tag plus one pointer per variant, and decodes a variant it
// does not know without complaint. The contract's `PriceKind` is a closed enum, so that
// case cannot be passed along and is reported instead.
func flattenFee(metrics *metricCache, componentID, componentName string, fee meteroid.Fee) (PlanPrice, error) {
	price := PlanPrice{ComponentID: componentID, Name: componentName, Kind: fee.Type}

	// Meteroid spells a price "29.00"; the contract wants "29". The first value that is
	// not a decimal at all fails the whole component.
	var malformed error
	amount := func(value string) *string {
		normalized, err := normalizeDecimal(value)
		if err != nil && malformed == nil {
			malformed = err
		}
		return &normalized
	}
	term := func(rates []meteroid.TermRate) {
		if rate, ok := pickTerm(rates); ok {
			price.Cadence = ptr(string(rate.Term))
			price.Amount = amount(rate.Price)
		}
	}

	switch fee.Type {
	case meteroid.FeeRate:
		term(fee.Rate.Rates)
	case meteroid.FeeSlot:
		term(fee.Slot.Rates)
		price.UnitName = &fee.Slot.SlotUnitName
	case meteroid.FeeCapacity:
		price.Cadence = ptr(string(fee.Capacity.Cadence))
		price.UnitName = metrics.codeForCached(fee.Capacity.MetricId)
		if len(fee.Capacity.Thresholds) > 0 {
			threshold := fee.Capacity.Thresholds[0]
			price.Amount = amount(threshold.Price)
			price.UnitAmount = amount(threshold.PerUnitOverage)
			// Meteroid types this one as an integer count; the contract carries every
			// quantity as a decimal string.
			price.IncludedAmount = ptr(strconv.FormatInt(threshold.IncludedAmount, 10))
		}
	case meteroid.FeeUsage:
		price.Cadence = ptr(string(fee.Usage.Cadence))
		price.UnitName = metrics.codeForCached(fee.Usage.MetricId)
		price.PricingModel = ptr(fee.Usage.Pricing.Type)
		// Only PER_UNIT has a single displayable unit price.
		if fee.Usage.Pricing.Type == meteroid.PlanUsagePricingModelPerUnit {
			price.UnitAmount = amount(fee.Usage.Pricing.PerUnit.Rate)
		}
	case meteroid.FeeExtraRecurring:
		price.Cadence = ptr(string(fee.ExtraRecurring.Cadence))
		price.Amount = amount(fee.ExtraRecurring.UnitPrice)
	case meteroid.FeeOneTime:
		price.Amount = amount(fee.OneTime.UnitPrice)
	default:
		return PlanPrice{}, newAPIError(codeUpstreamError,
			"Price component %q has a fee of type %q, which this demo does not know how to show.", componentName, fee.Type)
	}

	if malformed != nil {
		return PlanPrice{}, malformed
	}
	return price, nil
}

// pickTerm chooses the one billing term the table shows. A RATE or SLOT fee prices one
// term each: the monthly one when it exists (that is what the seeded catalog uses), else
// the first. Meteroid's Plan carries no cadence of its own to match against.
func pickTerm(rates []meteroid.TermRate) (meteroid.TermRate, bool) {
	for _, rate := range rates {
		if rate.Term == meteroid.BillingPeriodEnumMonthly {
			return rate, true
		}
	}
	if len(rates) == 0 {
		return meteroid.TermRate{}, false
	}
	return rates[0], true
}

// featureLabel renders one plan-version entitlement as a marketing bullet.
func featureLabel(featureName string, value meteroid.ResolvedEntitlementValue) (string, error) {
	included := func(on bool) string {
		if on {
			return featureName + " included"
		}
		return featureName + " not included"
	}

	switch value.Type {
	case meteroid.ResolvedEntitlementValueBoolean:
		return included(value.Boolean.Enabled), nil

	case meteroid.ResolvedEntitlementValueMetered:
		metered := value.Metered
		if !metered.Enabled {
			return included(false), nil
		}
		if metered.Limit == nil {
			return "Unlimited " + lowerFirst(featureName), nil
		}
		limit, err := normalizeDecimal(*metered.Limit)
		if err != nil {
			return "", err
		}
		return limit + " " + lowerFirst(featureName) + resetSuffix(metered.ResetPeriod), nil

	case meteroid.ResolvedEntitlementValueConfig:
		config := value.Config.Value
		switch config.Kind {
		case meteroid.ConfigValueNumber:
			number, err := normalizeDecimal(config.Number.Value)
			if err != nil {
				return "", err
			}
			return number + " " + lowerFirst(featureName), nil
		case meteroid.ConfigValueBoolean:
			return included(config.Boolean.Value), nil
		case meteroid.ConfigValueText:
			return featureName + ": " + config.Text.Value, nil
		case meteroid.ConfigValueJson:
			return featureName + " configured", nil
		}
	}
	return "", newAPIError(codeUpstreamError,
		"Meteroid returned an entitlement of unknown type %q for %q.", value.Type, featureName)
}

func resetSuffix(period meteroid.ResetPeriod) string {
	switch period.Type {
	case meteroid.ResetPeriodBillingCycle:
		return " per billing cycle"
	case meteroid.ResetPeriodCalendar:
		return " per " + interval(period.Calendar.Interval, period.Calendar.Unit)
	case meteroid.ResetPeriodFixedWindow:
		return " per " + interval(period.FixedWindow.Interval, period.FixedWindow.Unit)
	case meteroid.ResetPeriodSlidingWindow:
		return " per rolling " + interval(period.SlidingWindow.Interval, period.SlidingWindow.Unit)
	default:
		return ""
	}
}

func interval(count int32, unit meteroid.CalendarUnit) string {
	name := strings.ToLower(string(unit))
	if count == 1 {
		return name
	}
	return fmt.Sprintf("%d %ss", count, name)
}

func lowerFirst(value string) string {
	first, size := utf8.DecodeRuneInString(value)
	if size == 0 {
		return value
	}
	return string(unicode.ToLower(first)) + value[size:]
}
