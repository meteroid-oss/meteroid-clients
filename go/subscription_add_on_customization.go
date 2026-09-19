// this file is @generated
package meteroid

import "encoding/json"

// SubscriptionAddOnCustomization is a tagged union discriminated by the type field.
// Exactly one variant pointer is set, matching Type.
type SubscriptionAddOnCustomization struct {
	// Type selects the active variant. Compare it against the
	// SubscriptionAddOnCustomization* constants.
	Type string `json:"type"`

	// PriceOverride is set when Type is SubscriptionAddOnCustomizationPriceOverride.
	PriceOverride *SubscriptionAddOnPriceOverride `json:"-"`
	// Parameterization is set when Type is SubscriptionAddOnCustomizationParameterization.
	Parameterization *SubscriptionAddOnParameterization `json:"-"`

	// raw keeps the payload of a variant this SDK version does not know about, so
	// that decoding and re-encoding an unknown variant preserves every field and
	// value. It is not byte-for-byte identical: `encoding/json` compacts the
	// whitespace and escapes `<`, `>` and `&` as `\u003c`, `\u003e` and `\u0026`.
	raw json.RawMessage
}

// Discriminator values for SubscriptionAddOnCustomization.
const (
	SubscriptionAddOnCustomizationPriceOverride    = "PRICE_OVERRIDE"
	SubscriptionAddOnCustomizationParameterization = "PARAMETERIZATION"
)

// NewSubscriptionAddOnCustomizationPriceOverride builds a SubscriptionAddOnCustomization holding the PRICE_OVERRIDE variant.
func NewSubscriptionAddOnCustomizationPriceOverride(value SubscriptionAddOnPriceOverride) SubscriptionAddOnCustomization {
	return SubscriptionAddOnCustomization{Type: SubscriptionAddOnCustomizationPriceOverride, PriceOverride: &value}
}

// NewSubscriptionAddOnCustomizationParameterization builds a SubscriptionAddOnCustomization holding the PARAMETERIZATION variant.
func NewSubscriptionAddOnCustomizationParameterization(value SubscriptionAddOnParameterization) SubscriptionAddOnCustomization {
	return SubscriptionAddOnCustomization{Type: SubscriptionAddOnCustomizationParameterization, Parameterization: &value}
}

// MarshalJSON implements json.Marshaler.
func (u SubscriptionAddOnCustomization) MarshalJSON() ([]byte, error) {
	switch u.Type {
	case SubscriptionAddOnCustomizationPriceOverride:
		if u.PriceOverride == nil {
			return nil, &UnionError{Union: "SubscriptionAddOnCustomization", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.PriceOverride)
	case SubscriptionAddOnCustomizationParameterization:
		if u.Parameterization == nil {
			return nil, &UnionError{Union: "SubscriptionAddOnCustomization", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Parameterization)
	}

	if len(u.raw) > 0 {
		return u.raw, nil
	}
	if u.Type == "" {
		return nil, &UnionError{Union: "SubscriptionAddOnCustomization", Discriminator: "", Reason: "no variant set"}
	}
	return nil, &UnionError{Union: "SubscriptionAddOnCustomization", Discriminator: u.Type, Reason: "unknown discriminator"}
}

// UnmarshalJSON implements json.Unmarshaler.
//
// Payloads carrying an unrecognized discriminator are kept rather than rejected,
// so a newer API version does not break older SDK builds. Re-encoding such a
// value reproduces the same JSON document, though not necessarily the same
// bytes: `encoding/json` compacts whitespace and escapes `<`, `>` and `&`.
func (u *SubscriptionAddOnCustomization) UnmarshalJSON(data []byte) error {
	var tag struct {
		Type string `json:"type"`
	}
	if err := json.Unmarshal(data, &tag); err != nil {
		return err
	}

	*u = SubscriptionAddOnCustomization{Type: tag.Type}
	switch tag.Type {
	case SubscriptionAddOnCustomizationPriceOverride:
		u.PriceOverride = new(SubscriptionAddOnPriceOverride)
		return json.Unmarshal(data, u.PriceOverride)
	case SubscriptionAddOnCustomizationParameterization:
		u.Parameterization = new(SubscriptionAddOnParameterization)
		return json.Unmarshal(data, u.Parameterization)
	default:
		u.raw = append(json.RawMessage(nil), data...)
		return nil
	}
}
