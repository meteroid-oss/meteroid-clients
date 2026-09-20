// this file is @generated
package meteroid

import "encoding/json"

// Fee is a tagged union discriminated by the type field.
//
// When [Fee.IsKnown] reports true, exactly one variant pointer is
// set, matching Type. A variant added to the API after this SDK
// version was released still decodes without error, but with every variant
// pointer nil: always give a `switch` on Type a `default:` branch (or
// check IsKnown first) instead of dereferencing a pointer unconditionally. The
// unknown variant's JSON is available from [Fee.Raw].
type Fee struct {
	// Type selects the active variant. Compare it against the
	// Fee* constants.
	Type string `json:"type"`

	// Rate is set when Type is FeeRate.
	Rate *RatePlanFee `json:"-"`
	// Slot is set when Type is FeeSlot.
	Slot *SlotPlanFee `json:"-"`
	// Capacity is set when Type is FeeCapacity.
	Capacity *CapacityPlanFee `json:"-"`
	// Usage is set when Type is FeeUsage.
	Usage *UsagePlanFee `json:"-"`
	// ExtraRecurring is set when Type is FeeExtraRecurring.
	ExtraRecurring *ExtraRecurringPlanFee `json:"-"`
	// OneTime is set when Type is FeeOneTime.
	OneTime *OneTimePlanFee `json:"-"`

	// raw keeps the payload of a variant this SDK version does not know about, so
	// that decoding and re-encoding an unknown variant preserves every field and
	// value. It is not byte-for-byte identical: `encoding/json` compacts the
	// whitespace and escapes `<`, `>` and `&` as `\u003c`, `\u003e` and `\u0026`.
	raw json.RawMessage
}

// Discriminator values for Fee.
const (
	FeeRate           = "RATE"
	FeeSlot           = "SLOT"
	FeeCapacity       = "CAPACITY"
	FeeUsage          = "USAGE"
	FeeExtraRecurring = "EXTRA_RECURRING"
	FeeOneTime        = "ONE_TIME"
)

// NewFeeRate builds a Fee holding the RATE variant.
func NewFeeRate(value RatePlanFee) Fee {
	return Fee{Type: FeeRate, Rate: &value}
}

// NewFeeSlot builds a Fee holding the SLOT variant.
func NewFeeSlot(value SlotPlanFee) Fee {
	return Fee{Type: FeeSlot, Slot: &value}
}

// NewFeeCapacity builds a Fee holding the CAPACITY variant.
func NewFeeCapacity(value CapacityPlanFee) Fee {
	return Fee{Type: FeeCapacity, Capacity: &value}
}

// NewFeeUsage builds a Fee holding the USAGE variant.
func NewFeeUsage(value UsagePlanFee) Fee {
	return Fee{Type: FeeUsage, Usage: &value}
}

// NewFeeExtraRecurring builds a Fee holding the EXTRA_RECURRING variant.
func NewFeeExtraRecurring(value ExtraRecurringPlanFee) Fee {
	return Fee{Type: FeeExtraRecurring, ExtraRecurring: &value}
}

// NewFeeOneTime builds a Fee holding the ONE_TIME variant.
func NewFeeOneTime(value OneTimePlanFee) Fee {
	return Fee{Type: FeeOneTime, OneTime: &value}
}

// IsKnown reports whether Type is one of the variants this SDK version
// knows about, i.e. one of the Fee* constants. It is false for a
// variant added to the API later, whose payload is then only available from
// [Fee.Raw].
func (u Fee) IsKnown() bool {
	switch u.Type {
	case FeeRate, FeeSlot, FeeCapacity, FeeUsage, FeeExtraRecurring, FeeOneTime:
		return true
	}
	return false
}

// Raw returns the JSON of a variant this SDK version does not know about, as
// decoded (see [Fee.IsKnown]). It is nil for a known variant, and
// for a value that was not decoded from JSON. The returned slice is a copy.
func (u Fee) Raw() json.RawMessage {
	if u.IsKnown() || len(u.raw) == 0 {
		return nil
	}
	return append(json.RawMessage(nil), u.raw...)
}

// MarshalJSON implements json.Marshaler.
func (u Fee) MarshalJSON() ([]byte, error) {
	switch u.Type {
	case FeeRate:
		if u.Rate == nil {
			return nil, &UnionError{Union: "Fee", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Rate)
	case FeeSlot:
		if u.Slot == nil {
			return nil, &UnionError{Union: "Fee", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Slot)
	case FeeCapacity:
		if u.Capacity == nil {
			return nil, &UnionError{Union: "Fee", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Capacity)
	case FeeUsage:
		if u.Usage == nil {
			return nil, &UnionError{Union: "Fee", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Usage)
	case FeeExtraRecurring:
		if u.ExtraRecurring == nil {
			return nil, &UnionError{Union: "Fee", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.ExtraRecurring)
	case FeeOneTime:
		if u.OneTime == nil {
			return nil, &UnionError{Union: "Fee", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.OneTime)
	}

	if len(u.raw) > 0 {
		return u.raw, nil
	}
	if u.Type == "" {
		return nil, &UnionError{Union: "Fee", Discriminator: "", Reason: "no variant set"}
	}
	return nil, &UnionError{Union: "Fee", Discriminator: u.Type, Reason: "unknown discriminator"}
}

// UnmarshalJSON implements json.Unmarshaler.
//
// Payloads carrying an unrecognized discriminator are kept rather than rejected,
// so a newer API version does not break older SDK builds. Re-encoding such a
// value reproduces the same JSON document, though not necessarily the same
// bytes: `encoding/json` compacts whitespace and escapes `<`, `>` and `&`.
func (u *Fee) UnmarshalJSON(data []byte) error {
	var tag struct {
		Type string `json:"type"`
	}
	if err := json.Unmarshal(data, &tag); err != nil {
		return err
	}

	*u = Fee{Type: tag.Type}
	switch tag.Type {
	case FeeRate:
		u.Rate = new(RatePlanFee)
		return json.Unmarshal(data, u.Rate)
	case FeeSlot:
		u.Slot = new(SlotPlanFee)
		return json.Unmarshal(data, u.Slot)
	case FeeCapacity:
		u.Capacity = new(CapacityPlanFee)
		return json.Unmarshal(data, u.Capacity)
	case FeeUsage:
		u.Usage = new(UsagePlanFee)
		return json.Unmarshal(data, u.Usage)
	case FeeExtraRecurring:
		u.ExtraRecurring = new(ExtraRecurringPlanFee)
		return json.Unmarshal(data, u.ExtraRecurring)
	case FeeOneTime:
		u.OneTime = new(OneTimePlanFee)
		return json.Unmarshal(data, u.OneTime)
	default:
		u.raw = append(json.RawMessage(nil), data...)
		return nil
	}
}
