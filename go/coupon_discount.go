// this file is @generated
package meteroid

import "encoding/json"

// CouponDiscount is a tagged union discriminated by the type field.
// Exactly one variant pointer is set, matching Type.
type CouponDiscount struct {
	// Type selects the active variant. Compare it against the
	// CouponDiscount* constants.
	Type string `json:"type"`

	// Percentage is set when Type is CouponDiscountPercentage.
	Percentage *PercentageDiscount `json:"-"`
	// Fixed is set when Type is CouponDiscountFixed.
	Fixed *FixedDiscount `json:"-"`

	// raw keeps the payload of a variant this SDK version does not know about, so
	// that decoding and re-encoding an unknown variant preserves every field and
	// value. It is not byte-for-byte identical: `encoding/json` compacts the
	// whitespace and escapes `<`, `>` and `&` as `\u003c`, `\u003e` and `\u0026`.
	raw json.RawMessage
}

// Discriminator values for CouponDiscount.
const (
	CouponDiscountPercentage = "PERCENTAGE"
	CouponDiscountFixed      = "FIXED"
)

// NewCouponDiscountPercentage builds a CouponDiscount holding the PERCENTAGE variant.
func NewCouponDiscountPercentage(value PercentageDiscount) CouponDiscount {
	return CouponDiscount{Type: CouponDiscountPercentage, Percentage: &value}
}

// NewCouponDiscountFixed builds a CouponDiscount holding the FIXED variant.
func NewCouponDiscountFixed(value FixedDiscount) CouponDiscount {
	return CouponDiscount{Type: CouponDiscountFixed, Fixed: &value}
}

// MarshalJSON implements json.Marshaler.
func (u CouponDiscount) MarshalJSON() ([]byte, error) {
	switch u.Type {
	case CouponDiscountPercentage:
		if u.Percentage == nil {
			return nil, &UnionError{Union: "CouponDiscount", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Percentage)
	case CouponDiscountFixed:
		if u.Fixed == nil {
			return nil, &UnionError{Union: "CouponDiscount", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Fixed)
	}

	if len(u.raw) > 0 {
		return u.raw, nil
	}
	if u.Type == "" {
		return nil, &UnionError{Union: "CouponDiscount", Discriminator: "", Reason: "no variant set"}
	}
	return nil, &UnionError{Union: "CouponDiscount", Discriminator: u.Type, Reason: "unknown discriminator"}
}

// UnmarshalJSON implements json.Unmarshaler.
//
// Payloads carrying an unrecognized discriminator are kept rather than rejected,
// so a newer API version does not break older SDK builds. Re-encoding such a
// value reproduces the same JSON document, though not necessarily the same
// bytes: `encoding/json` compacts whitespace and escapes `<`, `>` and `&`.
func (u *CouponDiscount) UnmarshalJSON(data []byte) error {
	var tag struct {
		Type string `json:"type"`
	}
	if err := json.Unmarshal(data, &tag); err != nil {
		return err
	}

	*u = CouponDiscount{Type: tag.Type}
	switch tag.Type {
	case CouponDiscountPercentage:
		u.Percentage = new(PercentageDiscount)
		return json.Unmarshal(data, u.Percentage)
	case CouponDiscountFixed:
		u.Fixed = new(FixedDiscount)
		return json.Unmarshal(data, u.Fixed)
	default:
		u.raw = append(json.RawMessage(nil), data...)
		return nil
	}
}
