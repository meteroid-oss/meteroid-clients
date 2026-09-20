// this file is @generated
package meteroid

import "encoding/json"

// MinimumCommitmentScope is a tagged union discriminated by the type field.
//
// When [MinimumCommitmentScope.IsKnown] reports true, exactly one variant pointer is
// set, matching Type. A variant added to the API after this SDK
// version was released still decodes without error, but with every variant
// pointer nil: always give a `switch` on Type a `default:` branch (or
// check IsKnown first) instead of dereferencing a pointer unconditionally. The
// unknown variant's JSON is available from [MinimumCommitmentScope.Raw].
type MinimumCommitmentScope struct {
	// Type selects the active variant. Compare it against the
	// MinimumCommitmentScope* constants.
	Type string `json:"type"`

	// AllComponents is set when Type is MinimumCommitmentScopeAllComponents.
	AllComponents *AllComponentsScope `json:"-"`
	// Products is set when Type is MinimumCommitmentScopeProducts.
	Products *ProductsScope `json:"-"`

	// raw keeps the payload of a variant this SDK version does not know about, so
	// that decoding and re-encoding an unknown variant preserves every field and
	// value. It is not byte-for-byte identical: `encoding/json` compacts the
	// whitespace and escapes `<`, `>` and `&` as `\u003c`, `\u003e` and `\u0026`.
	raw json.RawMessage
}

// Discriminator values for MinimumCommitmentScope.
const (
	MinimumCommitmentScopeAllComponents = "all_components"
	MinimumCommitmentScopeProducts      = "products"
)

// NewMinimumCommitmentScopeAllComponents builds a MinimumCommitmentScope holding the all_components variant.
func NewMinimumCommitmentScopeAllComponents(value AllComponentsScope) MinimumCommitmentScope {
	return MinimumCommitmentScope{Type: MinimumCommitmentScopeAllComponents, AllComponents: &value}
}

// NewMinimumCommitmentScopeProducts builds a MinimumCommitmentScope holding the products variant.
func NewMinimumCommitmentScopeProducts(value ProductsScope) MinimumCommitmentScope {
	return MinimumCommitmentScope{Type: MinimumCommitmentScopeProducts, Products: &value}
}

// IsKnown reports whether Type is one of the variants this SDK version
// knows about, i.e. one of the MinimumCommitmentScope* constants. It is false for a
// variant added to the API later, whose payload is then only available from
// [MinimumCommitmentScope.Raw].
func (u MinimumCommitmentScope) IsKnown() bool {
	switch u.Type {
	case MinimumCommitmentScopeAllComponents, MinimumCommitmentScopeProducts:
		return true
	}
	return false
}

// Raw returns the JSON of a variant this SDK version does not know about, as
// decoded (see [MinimumCommitmentScope.IsKnown]). It is nil for a known variant, and
// for a value that was not decoded from JSON. The returned slice is a copy.
func (u MinimumCommitmentScope) Raw() json.RawMessage {
	if u.IsKnown() || len(u.raw) == 0 {
		return nil
	}
	return append(json.RawMessage(nil), u.raw...)
}

// MarshalJSON implements json.Marshaler.
func (u MinimumCommitmentScope) MarshalJSON() ([]byte, error) {
	switch u.Type {
	case MinimumCommitmentScopeAllComponents:
		if u.AllComponents == nil {
			return nil, &UnionError{Union: "MinimumCommitmentScope", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.AllComponents)
	case MinimumCommitmentScopeProducts:
		if u.Products == nil {
			return nil, &UnionError{Union: "MinimumCommitmentScope", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Products)
	}

	if len(u.raw) > 0 {
		return u.raw, nil
	}
	if u.Type == "" {
		return nil, &UnionError{Union: "MinimumCommitmentScope", Discriminator: "", Reason: "no variant set"}
	}
	return nil, &UnionError{Union: "MinimumCommitmentScope", Discriminator: u.Type, Reason: "unknown discriminator"}
}

// UnmarshalJSON implements json.Unmarshaler.
//
// Payloads carrying an unrecognized discriminator are kept rather than rejected,
// so a newer API version does not break older SDK builds. Re-encoding such a
// value reproduces the same JSON document, though not necessarily the same
// bytes: `encoding/json` compacts whitespace and escapes `<`, `>` and `&`.
func (u *MinimumCommitmentScope) UnmarshalJSON(data []byte) error {
	var tag struct {
		Type string `json:"type"`
	}
	if err := json.Unmarshal(data, &tag); err != nil {
		return err
	}

	*u = MinimumCommitmentScope{Type: tag.Type}
	switch tag.Type {
	case MinimumCommitmentScopeAllComponents:
		u.AllComponents = new(AllComponentsScope)
		return json.Unmarshal(data, u.AllComponents)
	case MinimumCommitmentScopeProducts:
		u.Products = new(ProductsScope)
		return json.Unmarshal(data, u.Products)
	default:
		u.raw = append(json.RawMessage(nil), data...)
		return nil
	}
}
