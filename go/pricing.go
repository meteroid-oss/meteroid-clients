// this file is @generated
package meteroid

import "encoding/json"

// Pricing is a tagged union discriminated by the type field.
//
// When [Pricing.IsKnown] reports true, exactly one variant pointer is
// set, matching Type. A variant added to the API after this SDK
// version was released still decodes without error, but with every variant
// pointer nil: always give a `switch` on Type a `default:` branch (or
// check IsKnown first) instead of dereferencing a pointer unconditionally. The
// unknown variant's JSON is available from [Pricing.Raw].
type Pricing struct {
	// Type selects the active variant. Compare it against the
	// Pricing* constants.
	Type string `json:"type"`

	// Rate is set when Type is PricingRate.
	Rate *RatePricing `json:"-"`
	// Slot is set when Type is PricingSlot.
	Slot *SlotPricing `json:"-"`
	// Capacity is set when Type is PricingCapacity.
	Capacity *CapacityPricing `json:"-"`
	// Usage is set when Type is PricingUsage.
	Usage *UsagePricing `json:"-"`
	// ExtraRecurring is set when Type is PricingExtraRecurring.
	ExtraRecurring *ExtraRecurringPricing `json:"-"`
	// OneTime is set when Type is PricingOneTime.
	OneTime *OneTimePricing `json:"-"`

	// raw keeps the payload of a variant this SDK version does not know about, so
	// that decoding and re-encoding an unknown variant preserves every field and
	// value. It is not byte-for-byte identical: `encoding/json` compacts the
	// whitespace and escapes `<`, `>` and `&` as `\u003c`, `\u003e` and `\u0026`.
	raw json.RawMessage
}

// Discriminator values for Pricing.
const (
	PricingRate           = "RATE"
	PricingSlot           = "SLOT"
	PricingCapacity       = "CAPACITY"
	PricingUsage          = "USAGE"
	PricingExtraRecurring = "EXTRA_RECURRING"
	PricingOneTime        = "ONE_TIME"
)

// NewPricingRate builds a Pricing holding the RATE variant.
func NewPricingRate(value RatePricing) Pricing {
	return Pricing{Type: PricingRate, Rate: &value}
}

// NewPricingSlot builds a Pricing holding the SLOT variant.
func NewPricingSlot(value SlotPricing) Pricing {
	return Pricing{Type: PricingSlot, Slot: &value}
}

// NewPricingCapacity builds a Pricing holding the CAPACITY variant.
func NewPricingCapacity(value CapacityPricing) Pricing {
	return Pricing{Type: PricingCapacity, Capacity: &value}
}

// NewPricingUsage builds a Pricing holding the USAGE variant.
func NewPricingUsage(value UsagePricing) Pricing {
	return Pricing{Type: PricingUsage, Usage: &value}
}

// NewPricingExtraRecurring builds a Pricing holding the EXTRA_RECURRING variant.
func NewPricingExtraRecurring(value ExtraRecurringPricing) Pricing {
	return Pricing{Type: PricingExtraRecurring, ExtraRecurring: &value}
}

// NewPricingOneTime builds a Pricing holding the ONE_TIME variant.
func NewPricingOneTime(value OneTimePricing) Pricing {
	return Pricing{Type: PricingOneTime, OneTime: &value}
}

// IsKnown reports whether Type is one of the variants this SDK version
// knows about, i.e. one of the Pricing* constants. It is false for a
// variant added to the API later, whose payload is then only available from
// [Pricing.Raw].
func (u Pricing) IsKnown() bool {
	switch u.Type {
	case PricingRate, PricingSlot, PricingCapacity, PricingUsage, PricingExtraRecurring, PricingOneTime:
		return true
	}
	return false
}

// Raw returns the JSON of a variant this SDK version does not know about, as
// decoded (see [Pricing.IsKnown]). It is nil for a known variant, and
// for a value that was not decoded from JSON. The returned slice is a copy.
func (u Pricing) Raw() json.RawMessage {
	if u.IsKnown() || len(u.raw) == 0 {
		return nil
	}
	return append(json.RawMessage(nil), u.raw...)
}

// MarshalJSON implements json.Marshaler.
func (u Pricing) MarshalJSON() ([]byte, error) {
	switch u.Type {
	case PricingRate:
		if u.Rate == nil {
			return nil, &UnionError{Union: "Pricing", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Rate)
	case PricingSlot:
		if u.Slot == nil {
			return nil, &UnionError{Union: "Pricing", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Slot)
	case PricingCapacity:
		if u.Capacity == nil {
			return nil, &UnionError{Union: "Pricing", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Capacity)
	case PricingUsage:
		if u.Usage == nil {
			return nil, &UnionError{Union: "Pricing", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Usage)
	case PricingExtraRecurring:
		if u.ExtraRecurring == nil {
			return nil, &UnionError{Union: "Pricing", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.ExtraRecurring)
	case PricingOneTime:
		if u.OneTime == nil {
			return nil, &UnionError{Union: "Pricing", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.OneTime)
	}

	if len(u.raw) > 0 {
		return u.raw, nil
	}
	if u.Type == "" {
		return nil, &UnionError{Union: "Pricing", Discriminator: "", Reason: "no variant set"}
	}
	return nil, &UnionError{Union: "Pricing", Discriminator: u.Type, Reason: "unknown discriminator"}
}

// UnmarshalJSON implements json.Unmarshaler.
//
// Payloads carrying an unrecognized discriminator are kept rather than rejected,
// so a newer API version does not break older SDK builds. Re-encoding such a
// value reproduces the same JSON document, though not necessarily the same
// bytes: `encoding/json` compacts whitespace and escapes `<`, `>` and `&`.
func (u *Pricing) UnmarshalJSON(data []byte) error {
	var tag struct {
		Type string `json:"type"`
	}
	if err := json.Unmarshal(data, &tag); err != nil {
		return err
	}

	*u = Pricing{Type: tag.Type}
	switch tag.Type {
	case PricingRate:
		u.Rate = new(RatePricing)
		return json.Unmarshal(data, u.Rate)
	case PricingSlot:
		u.Slot = new(SlotPricing)
		return json.Unmarshal(data, u.Slot)
	case PricingCapacity:
		u.Capacity = new(CapacityPricing)
		return json.Unmarshal(data, u.Capacity)
	case PricingUsage:
		u.Usage = new(UsagePricing)
		return json.Unmarshal(data, u.Usage)
	case PricingExtraRecurring:
		u.ExtraRecurring = new(ExtraRecurringPricing)
		return json.Unmarshal(data, u.ExtraRecurring)
	case PricingOneTime:
		u.OneTime = new(OneTimePricing)
		return json.Unmarshal(data, u.OneTime)
	default:
		u.raw = append(json.RawMessage(nil), data...)
		return nil
	}
}
