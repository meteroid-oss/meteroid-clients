// this file is @generated
package meteroid

import "encoding/json"

// ProductFeeStructure is a tagged union discriminated by the type field.
//
// When [ProductFeeStructure.IsKnown] reports true, exactly one variant pointer is
// set, matching Type. A variant added to the API after this SDK
// version was released still decodes without error, but with every variant
// pointer nil: always give a `switch` on Type a `default:` branch (or
// check IsKnown first) instead of dereferencing a pointer unconditionally. The
// unknown variant's JSON is available from [ProductFeeStructure.Raw].
type ProductFeeStructure struct {
	// Type selects the active variant. Compare it against the
	// ProductFeeStructure* constants.
	Type string `json:"type"`

	// Rate is set when Type is ProductFeeStructureRate.
	Rate *RateFeeStructure `json:"-"`
	// Slot is set when Type is ProductFeeStructureSlot.
	Slot *SlotFeeStructure `json:"-"`
	// Capacity is set when Type is ProductFeeStructureCapacity.
	Capacity *CapacityFeeStructure `json:"-"`
	// Usage is set when Type is ProductFeeStructureUsage.
	Usage *UsageFeeStructure `json:"-"`
	// ExtraRecurring is set when Type is ProductFeeStructureExtraRecurring.
	ExtraRecurring *ExtraRecurringFeeStructure `json:"-"`
	// OneTime is set when Type is ProductFeeStructureOneTime.
	OneTime *OneTimeFeeStructure `json:"-"`

	// raw keeps the payload of a variant this SDK version does not know about, so
	// that decoding and re-encoding an unknown variant preserves every field and
	// value. It is not byte-for-byte identical: `encoding/json` compacts the
	// whitespace and escapes `<`, `>` and `&` as `\u003c`, `\u003e` and `\u0026`.
	raw json.RawMessage
}

// Discriminator values for ProductFeeStructure.
const (
	ProductFeeStructureRate           = "RATE"
	ProductFeeStructureSlot           = "SLOT"
	ProductFeeStructureCapacity       = "CAPACITY"
	ProductFeeStructureUsage          = "USAGE"
	ProductFeeStructureExtraRecurring = "EXTRA_RECURRING"
	ProductFeeStructureOneTime        = "ONE_TIME"
)

// NewProductFeeStructureRate builds a ProductFeeStructure holding the RATE variant.
func NewProductFeeStructureRate(value RateFeeStructure) ProductFeeStructure {
	return ProductFeeStructure{Type: ProductFeeStructureRate, Rate: &value}
}

// NewProductFeeStructureSlot builds a ProductFeeStructure holding the SLOT variant.
func NewProductFeeStructureSlot(value SlotFeeStructure) ProductFeeStructure {
	return ProductFeeStructure{Type: ProductFeeStructureSlot, Slot: &value}
}

// NewProductFeeStructureCapacity builds a ProductFeeStructure holding the CAPACITY variant.
func NewProductFeeStructureCapacity(value CapacityFeeStructure) ProductFeeStructure {
	return ProductFeeStructure{Type: ProductFeeStructureCapacity, Capacity: &value}
}

// NewProductFeeStructureUsage builds a ProductFeeStructure holding the USAGE variant.
func NewProductFeeStructureUsage(value UsageFeeStructure) ProductFeeStructure {
	return ProductFeeStructure{Type: ProductFeeStructureUsage, Usage: &value}
}

// NewProductFeeStructureExtraRecurring builds a ProductFeeStructure holding the EXTRA_RECURRING variant.
func NewProductFeeStructureExtraRecurring(value ExtraRecurringFeeStructure) ProductFeeStructure {
	return ProductFeeStructure{Type: ProductFeeStructureExtraRecurring, ExtraRecurring: &value}
}

// NewProductFeeStructureOneTime builds a ProductFeeStructure holding the ONE_TIME variant.
func NewProductFeeStructureOneTime(value OneTimeFeeStructure) ProductFeeStructure {
	return ProductFeeStructure{Type: ProductFeeStructureOneTime, OneTime: &value}
}

// IsKnown reports whether Type is one of the variants this SDK version
// knows about, i.e. one of the ProductFeeStructure* constants. It is false for a
// variant added to the API later, whose payload is then only available from
// [ProductFeeStructure.Raw].
func (u ProductFeeStructure) IsKnown() bool {
	switch u.Type {
	case ProductFeeStructureRate, ProductFeeStructureSlot, ProductFeeStructureCapacity, ProductFeeStructureUsage, ProductFeeStructureExtraRecurring, ProductFeeStructureOneTime:
		return true
	}
	return false
}

// Raw returns the JSON of a variant this SDK version does not know about, as
// decoded (see [ProductFeeStructure.IsKnown]). It is nil for a known variant, and
// for a value that was not decoded from JSON. The returned slice is a copy.
func (u ProductFeeStructure) Raw() json.RawMessage {
	if u.IsKnown() || len(u.raw) == 0 {
		return nil
	}
	return append(json.RawMessage(nil), u.raw...)
}

// MarshalJSON implements json.Marshaler.
func (u ProductFeeStructure) MarshalJSON() ([]byte, error) {
	switch u.Type {
	case ProductFeeStructureRate:
		if u.Rate == nil {
			return nil, &UnionError{Union: "ProductFeeStructure", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Rate)
	case ProductFeeStructureSlot:
		if u.Slot == nil {
			return nil, &UnionError{Union: "ProductFeeStructure", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Slot)
	case ProductFeeStructureCapacity:
		if u.Capacity == nil {
			return nil, &UnionError{Union: "ProductFeeStructure", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Capacity)
	case ProductFeeStructureUsage:
		if u.Usage == nil {
			return nil, &UnionError{Union: "ProductFeeStructure", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Usage)
	case ProductFeeStructureExtraRecurring:
		if u.ExtraRecurring == nil {
			return nil, &UnionError{Union: "ProductFeeStructure", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.ExtraRecurring)
	case ProductFeeStructureOneTime:
		if u.OneTime == nil {
			return nil, &UnionError{Union: "ProductFeeStructure", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.OneTime)
	}

	if len(u.raw) > 0 {
		return u.raw, nil
	}
	if u.Type == "" {
		return nil, &UnionError{Union: "ProductFeeStructure", Discriminator: "", Reason: "no variant set"}
	}
	return nil, &UnionError{Union: "ProductFeeStructure", Discriminator: u.Type, Reason: "unknown discriminator"}
}

// UnmarshalJSON implements json.Unmarshaler.
//
// Payloads carrying an unrecognized discriminator are kept rather than rejected,
// so a newer API version does not break older SDK builds. Re-encoding such a
// value reproduces the same JSON document, though not necessarily the same
// bytes: `encoding/json` compacts whitespace and escapes `<`, `>` and `&`.
func (u *ProductFeeStructure) UnmarshalJSON(data []byte) error {
	var tag struct {
		Type string `json:"type"`
	}
	if err := json.Unmarshal(data, &tag); err != nil {
		return err
	}

	*u = ProductFeeStructure{Type: tag.Type}
	switch tag.Type {
	case ProductFeeStructureRate:
		u.Rate = new(RateFeeStructure)
		return json.Unmarshal(data, u.Rate)
	case ProductFeeStructureSlot:
		u.Slot = new(SlotFeeStructure)
		return json.Unmarshal(data, u.Slot)
	case ProductFeeStructureCapacity:
		u.Capacity = new(CapacityFeeStructure)
		return json.Unmarshal(data, u.Capacity)
	case ProductFeeStructureUsage:
		u.Usage = new(UsageFeeStructure)
		return json.Unmarshal(data, u.Usage)
	case ProductFeeStructureExtraRecurring:
		u.ExtraRecurring = new(ExtraRecurringFeeStructure)
		return json.Unmarshal(data, u.ExtraRecurring)
	case ProductFeeStructureOneTime:
		u.OneTime = new(OneTimeFeeStructure)
		return json.Unmarshal(data, u.OneTime)
	default:
		u.raw = append(json.RawMessage(nil), data...)
		return nil
	}
}
