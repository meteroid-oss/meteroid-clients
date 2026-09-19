// this file is @generated
package meteroid

import "encoding/json"

// SubscriptionFee is a tagged union discriminated by the type field.
//
// When [SubscriptionFee.IsKnown] reports true, exactly one variant pointer is
// set, matching Type. A variant added to the API after this SDK
// version was released still decodes without error, but with every variant
// pointer nil: always give a `switch` on Type a `default:` branch (or
// check IsKnown first) instead of dereferencing a pointer unconditionally. The
// unknown variant's JSON is available from [SubscriptionFee.Raw].
type SubscriptionFee struct {
	// Type selects the active variant. Compare it against the
	// SubscriptionFee* constants.
	Type string `json:"type"`

	// Rate is set when Type is SubscriptionFeeRate.
	Rate *RateFee `json:"-"`
	// OneTime is set when Type is SubscriptionFeeOneTime.
	OneTime *OneTimeFee `json:"-"`
	// Recurring is set when Type is SubscriptionFeeRecurring.
	Recurring *RecurringFee `json:"-"`
	// Capacity is set when Type is SubscriptionFeeCapacity.
	Capacity *CapacityFee `json:"-"`
	// Slot is set when Type is SubscriptionFeeSlot.
	Slot *SlotFee `json:"-"`
	// Usage is set when Type is SubscriptionFeeUsage.
	Usage *UsageFee `json:"-"`

	// raw keeps the payload of a variant this SDK version does not know about, so
	// that decoding and re-encoding an unknown variant preserves every field and
	// value. It is not byte-for-byte identical: `encoding/json` compacts the
	// whitespace and escapes `<`, `>` and `&` as `\u003c`, `\u003e` and `\u0026`.
	raw json.RawMessage
}

// Discriminator values for SubscriptionFee.
const (
	SubscriptionFeeRate      = "RATE"
	SubscriptionFeeOneTime   = "ONE_TIME"
	SubscriptionFeeRecurring = "RECURRING"
	SubscriptionFeeCapacity  = "CAPACITY"
	SubscriptionFeeSlot      = "SLOT"
	SubscriptionFeeUsage     = "USAGE"
)

// NewSubscriptionFeeRate builds a SubscriptionFee holding the RATE variant.
func NewSubscriptionFeeRate(value RateFee) SubscriptionFee {
	return SubscriptionFee{Type: SubscriptionFeeRate, Rate: &value}
}

// NewSubscriptionFeeOneTime builds a SubscriptionFee holding the ONE_TIME variant.
func NewSubscriptionFeeOneTime(value OneTimeFee) SubscriptionFee {
	return SubscriptionFee{Type: SubscriptionFeeOneTime, OneTime: &value}
}

// NewSubscriptionFeeRecurring builds a SubscriptionFee holding the RECURRING variant.
func NewSubscriptionFeeRecurring(value RecurringFee) SubscriptionFee {
	return SubscriptionFee{Type: SubscriptionFeeRecurring, Recurring: &value}
}

// NewSubscriptionFeeCapacity builds a SubscriptionFee holding the CAPACITY variant.
func NewSubscriptionFeeCapacity(value CapacityFee) SubscriptionFee {
	return SubscriptionFee{Type: SubscriptionFeeCapacity, Capacity: &value}
}

// NewSubscriptionFeeSlot builds a SubscriptionFee holding the SLOT variant.
func NewSubscriptionFeeSlot(value SlotFee) SubscriptionFee {
	return SubscriptionFee{Type: SubscriptionFeeSlot, Slot: &value}
}

// NewSubscriptionFeeUsage builds a SubscriptionFee holding the USAGE variant.
func NewSubscriptionFeeUsage(value UsageFee) SubscriptionFee {
	return SubscriptionFee{Type: SubscriptionFeeUsage, Usage: &value}
}

// IsKnown reports whether Type is one of the variants this SDK version
// knows about, i.e. one of the SubscriptionFee* constants. It is false for a
// variant added to the API later, whose payload is then only available from
// [SubscriptionFee.Raw].
func (u SubscriptionFee) IsKnown() bool {
	switch u.Type {
	case SubscriptionFeeRate, SubscriptionFeeOneTime, SubscriptionFeeRecurring, SubscriptionFeeCapacity, SubscriptionFeeSlot, SubscriptionFeeUsage:
		return true
	}
	return false
}

// Raw returns the JSON of a variant this SDK version does not know about, as
// decoded (see [SubscriptionFee.IsKnown]). It is nil for a known variant, and
// for a value that was not decoded from JSON. The returned slice is a copy.
func (u SubscriptionFee) Raw() json.RawMessage {
	if u.IsKnown() || len(u.raw) == 0 {
		return nil
	}
	return append(json.RawMessage(nil), u.raw...)
}

// MarshalJSON implements json.Marshaler.
func (u SubscriptionFee) MarshalJSON() ([]byte, error) {
	switch u.Type {
	case SubscriptionFeeRate:
		if u.Rate == nil {
			return nil, &UnionError{Union: "SubscriptionFee", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Rate)
	case SubscriptionFeeOneTime:
		if u.OneTime == nil {
			return nil, &UnionError{Union: "SubscriptionFee", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.OneTime)
	case SubscriptionFeeRecurring:
		if u.Recurring == nil {
			return nil, &UnionError{Union: "SubscriptionFee", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Recurring)
	case SubscriptionFeeCapacity:
		if u.Capacity == nil {
			return nil, &UnionError{Union: "SubscriptionFee", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Capacity)
	case SubscriptionFeeSlot:
		if u.Slot == nil {
			return nil, &UnionError{Union: "SubscriptionFee", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Slot)
	case SubscriptionFeeUsage:
		if u.Usage == nil {
			return nil, &UnionError{Union: "SubscriptionFee", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Usage)
	}

	if len(u.raw) > 0 {
		return u.raw, nil
	}
	if u.Type == "" {
		return nil, &UnionError{Union: "SubscriptionFee", Discriminator: "", Reason: "no variant set"}
	}
	return nil, &UnionError{Union: "SubscriptionFee", Discriminator: u.Type, Reason: "unknown discriminator"}
}

// UnmarshalJSON implements json.Unmarshaler.
//
// Payloads carrying an unrecognized discriminator are kept rather than rejected,
// so a newer API version does not break older SDK builds. Re-encoding such a
// value reproduces the same JSON document, though not necessarily the same
// bytes: `encoding/json` compacts whitespace and escapes `<`, `>` and `&`.
func (u *SubscriptionFee) UnmarshalJSON(data []byte) error {
	var tag struct {
		Type string `json:"type"`
	}
	if err := json.Unmarshal(data, &tag); err != nil {
		return err
	}

	*u = SubscriptionFee{Type: tag.Type}
	switch tag.Type {
	case SubscriptionFeeRate:
		u.Rate = new(RateFee)
		return json.Unmarshal(data, u.Rate)
	case SubscriptionFeeOneTime:
		u.OneTime = new(OneTimeFee)
		return json.Unmarshal(data, u.OneTime)
	case SubscriptionFeeRecurring:
		u.Recurring = new(RecurringFee)
		return json.Unmarshal(data, u.Recurring)
	case SubscriptionFeeCapacity:
		u.Capacity = new(CapacityFee)
		return json.Unmarshal(data, u.Capacity)
	case SubscriptionFeeSlot:
		u.Slot = new(SlotFee)
		return json.Unmarshal(data, u.Slot)
	case SubscriptionFeeUsage:
		u.Usage = new(UsageFee)
		return json.Unmarshal(data, u.Usage)
	default:
		u.raw = append(json.RawMessage(nil), data...)
		return nil
	}
}
