// this file is @generated
package meteroid

import "encoding/json"

// ProductRef is a tagged union discriminated by the type field.
//
// When [ProductRef.IsKnown] reports true, exactly one variant pointer is
// set, matching Type. A variant added to the API after this SDK
// version was released still decodes without error, but with every variant
// pointer nil: always give a `switch` on Type a `default:` branch (or
// check IsKnown first) instead of dereferencing a pointer unconditionally. The
// unknown variant's JSON is available from [ProductRef.Raw].
type ProductRef struct {
	// Type selects the active variant. Compare it against the
	// ProductRef* constants.
	Type string `json:"type"`

	// Existing is set when Type is ProductRefExisting.
	Existing *ExistingProductRef `json:"-"`
	// New is set when Type is ProductRefNew.
	New *NewProductRef `json:"-"`

	// raw keeps the payload of a variant this SDK version does not know about, so
	// that decoding and re-encoding an unknown variant preserves every field and
	// value. It is not byte-for-byte identical: `encoding/json` compacts the
	// whitespace and escapes `<`, `>` and `&` as `\u003c`, `\u003e` and `\u0026`.
	raw json.RawMessage
}

// Discriminator values for ProductRef.
const (
	ProductRefExisting = "EXISTING"
	ProductRefNew      = "NEW"
)

// NewProductRefExisting builds a ProductRef holding the EXISTING variant.
func NewProductRefExisting(value ExistingProductRef) ProductRef {
	return ProductRef{Type: ProductRefExisting, Existing: &value}
}

// NewProductRefNew builds a ProductRef holding the NEW variant.
func NewProductRefNew(value NewProductRef) ProductRef {
	return ProductRef{Type: ProductRefNew, New: &value}
}

// IsKnown reports whether Type is one of the variants this SDK version
// knows about, i.e. one of the ProductRef* constants. It is false for a
// variant added to the API later, whose payload is then only available from
// [ProductRef.Raw].
func (u ProductRef) IsKnown() bool {
	switch u.Type {
	case ProductRefExisting, ProductRefNew:
		return true
	}
	return false
}

// Raw returns the JSON of a variant this SDK version does not know about, as
// decoded (see [ProductRef.IsKnown]). It is nil for a known variant, and
// for a value that was not decoded from JSON. The returned slice is a copy.
func (u ProductRef) Raw() json.RawMessage {
	if u.IsKnown() || len(u.raw) == 0 {
		return nil
	}
	return append(json.RawMessage(nil), u.raw...)
}

// MarshalJSON implements json.Marshaler.
func (u ProductRef) MarshalJSON() ([]byte, error) {
	switch u.Type {
	case ProductRefExisting:
		if u.Existing == nil {
			return nil, &UnionError{Union: "ProductRef", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Existing)
	case ProductRefNew:
		if u.New == nil {
			return nil, &UnionError{Union: "ProductRef", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.New)
	}

	if len(u.raw) > 0 {
		return u.raw, nil
	}
	if u.Type == "" {
		return nil, &UnionError{Union: "ProductRef", Discriminator: "", Reason: "no variant set"}
	}
	return nil, &UnionError{Union: "ProductRef", Discriminator: u.Type, Reason: "unknown discriminator"}
}

// UnmarshalJSON implements json.Unmarshaler.
//
// Payloads carrying an unrecognized discriminator are kept rather than rejected,
// so a newer API version does not break older SDK builds. Re-encoding such a
// value reproduces the same JSON document, though not necessarily the same
// bytes: `encoding/json` compacts whitespace and escapes `<`, `>` and `&`.
func (u *ProductRef) UnmarshalJSON(data []byte) error {
	var tag struct {
		Type string `json:"type"`
	}
	if err := json.Unmarshal(data, &tag); err != nil {
		return err
	}

	*u = ProductRef{Type: tag.Type}
	switch tag.Type {
	case ProductRefExisting:
		u.Existing = new(ExistingProductRef)
		return json.Unmarshal(data, u.Existing)
	case ProductRefNew:
		u.New = new(NewProductRef)
		return json.Unmarshal(data, u.New)
	default:
		u.raw = append(json.RawMessage(nil), data...)
		return nil
	}
}
