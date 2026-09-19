// this file is @generated
package meteroid

import "encoding/json"

// MinimumCommitmentInputScope is a tagged union discriminated by the type field.
// Exactly one variant pointer is set, matching Type.
type MinimumCommitmentInputScope struct {
	// Type selects the active variant. Compare it against the
	// MinimumCommitmentInputScope* constants.
	Type string `json:"type"`

	// AllComponents is set when Type is MinimumCommitmentInputScopeAllComponents.
	AllComponents *AllComponentsScope `json:"-"`
	// Components is set when Type is MinimumCommitmentInputScopeComponents.
	Components *ComponentsScope `json:"-"`

	// raw keeps the payload of a variant this SDK version does not know about, so
	// that decoding and re-encoding an unknown variant preserves every field and
	// value. It is not byte-for-byte identical: `encoding/json` compacts the
	// whitespace and escapes `<`, `>` and `&` as `\u003c`, `\u003e` and `\u0026`.
	raw json.RawMessage
}

// Discriminator values for MinimumCommitmentInputScope.
const (
	MinimumCommitmentInputScopeAllComponents = "all_components"
	MinimumCommitmentInputScopeComponents    = "components"
)

// NewMinimumCommitmentInputScopeAllComponents builds a MinimumCommitmentInputScope holding the all_components variant.
func NewMinimumCommitmentInputScopeAllComponents(value AllComponentsScope) MinimumCommitmentInputScope {
	return MinimumCommitmentInputScope{Type: MinimumCommitmentInputScopeAllComponents, AllComponents: &value}
}

// NewMinimumCommitmentInputScopeComponents builds a MinimumCommitmentInputScope holding the components variant.
func NewMinimumCommitmentInputScopeComponents(value ComponentsScope) MinimumCommitmentInputScope {
	return MinimumCommitmentInputScope{Type: MinimumCommitmentInputScopeComponents, Components: &value}
}

// MarshalJSON implements json.Marshaler.
func (u MinimumCommitmentInputScope) MarshalJSON() ([]byte, error) {
	switch u.Type {
	case MinimumCommitmentInputScopeAllComponents:
		if u.AllComponents == nil {
			return nil, &UnionError{Union: "MinimumCommitmentInputScope", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.AllComponents)
	case MinimumCommitmentInputScopeComponents:
		if u.Components == nil {
			return nil, &UnionError{Union: "MinimumCommitmentInputScope", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Components)
	}

	if len(u.raw) > 0 {
		return u.raw, nil
	}
	if u.Type == "" {
		return nil, &UnionError{Union: "MinimumCommitmentInputScope", Discriminator: "", Reason: "no variant set"}
	}
	return nil, &UnionError{Union: "MinimumCommitmentInputScope", Discriminator: u.Type, Reason: "unknown discriminator"}
}

// UnmarshalJSON implements json.Unmarshaler.
//
// Payloads carrying an unrecognized discriminator are kept rather than rejected,
// so a newer API version does not break older SDK builds. Re-encoding such a
// value reproduces the same JSON document, though not necessarily the same
// bytes: `encoding/json` compacts whitespace and escapes `<`, `>` and `&`.
func (u *MinimumCommitmentInputScope) UnmarshalJSON(data []byte) error {
	var tag struct {
		Type string `json:"type"`
	}
	if err := json.Unmarshal(data, &tag); err != nil {
		return err
	}

	*u = MinimumCommitmentInputScope{Type: tag.Type}
	switch tag.Type {
	case MinimumCommitmentInputScopeAllComponents:
		u.AllComponents = new(AllComponentsScope)
		return json.Unmarshal(data, u.AllComponents)
	case MinimumCommitmentInputScopeComponents:
		u.Components = new(ComponentsScope)
		return json.Unmarshal(data, u.Components)
	default:
		u.raw = append(json.RawMessage(nil), data...)
		return nil
	}
}
