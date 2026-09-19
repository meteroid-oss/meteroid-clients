package main

import (
	"context"

	meteroid "github.com/meteroid-oss/meteroid-clients/go"
)

// Turning Meteroid's effective entitlements into the contract's normalized view.
//
// This is the single most important piece of modelling in the demo, because it is what
// both the UI gating and the server-side enforcement read.
//
// Meteroid's `EffectiveEntitlementValue` is a union tagged on `type`
// (BOOLEAN / METERED / CONFIG), with the metered variant split into a `spec` (what the
// plan grants) and a `usage` (what has been consumed). The SDK models it as the tag plus
// one pointer per variant; the contract keeps the tag, flattens spec+usage into one
// object, and keeps every decimal a string.

// fetchEntitlements reads the workspace's effective entitlements from Meteroid.
//
// One call, by customer alias. Meteroid merges feature defaults, plan-version
// entitlements, product and add-on entitlements, and attaches live usage counters.
func (a *app) fetchEntitlements(ctx context.Context, alias string) ([]meteroid.EffectiveEntitlement, error) {
	response, err := a.meteroid.Customers().GetEffectiveEntitlements(ctx, alias)
	if err != nil {
		return nil, upstream("GET /api/v1/customers/"+alias+"/entitlements", err)
	}
	return response.Data, nil
}

// normalizeEntitlement projects one Meteroid entitlement onto the contract's tagged union.
func (a *app) normalizeEntitlement(ctx context.Context, entitlement meteroid.EffectiveEntitlement) (Entitlement, error) {
	feature, value := entitlement.Feature, entitlement.Value
	normalized := Entitlement{FeatureCode: feature.Code, FeatureName: feature.Name}

	switch value.Type {
	case meteroid.EffectiveEntitlementValueBoolean:
		normalized.Value = BooleanEntitlementValue{Type: value.Type, Enabled: value.Boolean.Enabled}

	case meteroid.EffectiveEntitlementValueMetered:
		quota, err := quotaSnapshot(feature.Code, value.Metered)
		if err != nil {
			return Entitlement{}, err
		}
		normalized.Value = MeteredEntitlementValue{
			Type:        value.Type,
			Enabled:     quota.Enabled,
			Limit:       quota.Limit,
			Consumed:    quota.Consumed,
			Remaining:   quota.Remaining,
			Unlimited:   quota.Unlimited,
			ResetAt:     quota.ResetAt,
			ResetPeriod: resetPeriod(value.Metered.Spec.ResetPeriod),
			// Meteroid names the metric behind an entitlement by id only. The code is
			// presentational (it lines this view up with GET /api/usage), so an
			// unresolvable id is a null rather than an error.
			MetricCode: a.metrics.codeFor(ctx, a.meteroid, value.Metered.Spec.MetricId),
		}

	case meteroid.EffectiveEntitlementValueConfig:
		config, err := configValue(value.Config.Value)
		if err != nil {
			return Entitlement{}, err
		}
		normalized.Value = ConfigEntitlementValue{Type: value.Type, Value: config}

	default:
		// The SDK decodes a variant it does not know rather than failing; the
		// contract's union is closed, so there is nothing truthful to project it onto.
		return Entitlement{}, newAPIError(codeUpstreamError,
			"Meteroid returned an entitlement of unknown type %q for %q.", value.Type, feature.Code)
	}
	return normalized, nil
}

// quotaSnapshot is the consumption state of a metered entitlement, as both the
// entitlement view and the quota-exhausted error report it.
//
// `remaining` is the number the quota check compares against, and Meteroid does not
// always supply it: `MeteredEntitlementUsage` requires none of its properties, so an
// entitlement whose counter has not been written yet arrives with `remaining` absent
// but `limit` set. The contract therefore fixes the fallback — `limit - consumed`, then
// `limit` — so that a limited entitlement always reports a balance and no two backends
// can disagree about it.
func quotaSnapshot(featureCode string, metered *meteroid.MeteredEffectiveEntitlementValue) (QuotaSnapshot, error) {
	spec, usage := metered.Spec, metered.Usage

	limit, err := normalizeDecimalOpt(spec.Limit)
	if err != nil {
		return QuotaSnapshot{}, err
	}
	consumed, err := normalizeDecimalOpt(usage.Consumed)
	if err != nil {
		return QuotaSnapshot{}, err
	}
	remaining, err := remainingBalance(spec.Limit, usage.Consumed, usage.Remaining)
	if err != nil {
		return QuotaSnapshot{}, err
	}

	return QuotaSnapshot{
		FeatureCode: featureCode,
		Enabled:     spec.Enabled,
		Limit:       limit,
		Consumed:    consumed,
		Remaining:   remaining,
		ResetAt:     timestampOpt(usage.ResetAt),
		// A nil limit is Meteroid's way of saying "unlimited"; mirroring it as a boolean
		// saves every client the same null special-case.
		Unlimited: spec.Limit == nil,
	}, nil
}

// remainingBalance is exact decimal arithmetic, never binary floating point — this is
// money. The SDK types all three as strings, and they stay strings all the way through
// decimal.go.
func remainingBalance(limit, consumed, reported *string) (*string, error) {
	if limit == nil {
		return nil, nil
	}
	if reported != nil {
		return normalizeDecimalOpt(reported)
	}
	if consumed == nil {
		consumed = ptr("0")
	}
	remaining, err := subtractDecimal(*limit, *consumed)
	if err != nil {
		return nil, err
	}
	return &remaining, nil
}

// resetPeriod flattens Meteroid's five-variant reset-period union. Every variant beyond
// the tag carries at most an `interval`+`unit` pair, so the contract keeps the tag and
// two nullable fields rather than nesting a second union inside the first.
func resetPeriod(period meteroid.ResetPeriod) ResetPeriod {
	flat := ResetPeriod{Type: period.Type}
	window := func(interval int32, unit meteroid.CalendarUnit) {
		flat.Interval, flat.Unit = &interval, ptr(string(unit))
	}

	switch period.Type {
	case meteroid.ResetPeriodCalendar:
		window(period.Calendar.Interval, period.Calendar.Unit)
	case meteroid.ResetPeriodFixedWindow:
		window(period.FixedWindow.Interval, period.FixedWindow.Unit)
	case meteroid.ResetPeriodSlidingWindow:
		window(period.SlidingWindow.Interval, period.SlidingWindow.Unit)
	}
	return flat
}

// configValue: Meteroid's `ConfigValueType` also lists MAP and SELECT, but its
// `ConfigValue` union carries only these four, which is exactly the set the contract
// exposes.
func configValue(value meteroid.ConfigValue) (ConfigValue, error) {
	switch value.Kind {
	case meteroid.ConfigValueNumber:
		// Numbers stay decimal strings: Meteroid types this `format: decimal`.
		number, err := normalizeDecimal(value.Number.Value)
		if err != nil {
			return ConfigValue{}, err
		}
		return ConfigValue{Kind: value.Kind, Value: number}, nil
	case meteroid.ConfigValueBoolean:
		return ConfigValue{Kind: value.Kind, Value: value.Boolean.Value}, nil
	case meteroid.ConfigValueText:
		return ConfigValue{Kind: value.Kind, Value: value.Text.Value}, nil
	case meteroid.ConfigValueJson:
		return ConfigValue{Kind: value.Kind, Value: value.Json.Value}, nil
	default:
		return ConfigValue{}, newAPIError(codeUpstreamError,
			"Meteroid returned a config value of unknown kind %q.", value.Kind)
	}
}
