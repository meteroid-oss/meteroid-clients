// this file is @generated
package meteroid

// Merged entitlement value for a feature for a specific customer, enriched with live usage data.
type EffectiveEntitlement struct {
	Feature FeatureRef `json:"feature"`

	Value EffectiveEntitlementValue `json:"value"`
}
