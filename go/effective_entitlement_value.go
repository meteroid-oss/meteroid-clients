// this file is @generated
package meteroid

import "encoding/json"

// EffectiveEntitlementValue is a tagged union discriminated by the type field.
//
// When [EffectiveEntitlementValue.IsKnown] reports true, exactly one variant pointer is
// set, matching Type. A variant added to the API after this SDK
// version was released still decodes without error, but with every variant
// pointer nil: always give a `switch` on Type a `default:` branch (or
// check IsKnown first) instead of dereferencing a pointer unconditionally. The
// unknown variant's JSON is available from [EffectiveEntitlementValue.Raw].
type EffectiveEntitlementValue struct {
	// Type selects the active variant. Compare it against the
	// EffectiveEntitlementValue* constants.
	Type string `json:"type"`

	// Boolean is set when Type is EffectiveEntitlementValueBoolean.
	Boolean *BooleanEffectiveEntitlementValue `json:"-"`
	// Metered is set when Type is EffectiveEntitlementValueMetered.
	Metered *MeteredEffectiveEntitlementValue `json:"-"`
	// Config is set when Type is EffectiveEntitlementValueConfig.
	Config *ConfigEffectiveEntitlementValue `json:"-"`

	// raw keeps the payload of a variant this SDK version does not know about, so
	// that decoding and re-encoding an unknown variant preserves every field and
	// value. It is not byte-for-byte identical: `encoding/json` compacts the
	// whitespace and escapes `<`, `>` and `&` as `\u003c`, `\u003e` and `\u0026`.
	raw json.RawMessage
}

// Discriminator values for EffectiveEntitlementValue.
const (
	EffectiveEntitlementValueBoolean = "BOOLEAN"
	EffectiveEntitlementValueMetered = "METERED"
	EffectiveEntitlementValueConfig  = "CONFIG"
)

// NewEffectiveEntitlementValueBoolean builds a EffectiveEntitlementValue holding the BOOLEAN variant.
func NewEffectiveEntitlementValueBoolean(value BooleanEffectiveEntitlementValue) EffectiveEntitlementValue {
	return EffectiveEntitlementValue{Type: EffectiveEntitlementValueBoolean, Boolean: &value}
}

// NewEffectiveEntitlementValueMetered builds a EffectiveEntitlementValue holding the METERED variant.
func NewEffectiveEntitlementValueMetered(value MeteredEffectiveEntitlementValue) EffectiveEntitlementValue {
	return EffectiveEntitlementValue{Type: EffectiveEntitlementValueMetered, Metered: &value}
}

// NewEffectiveEntitlementValueConfig builds a EffectiveEntitlementValue holding the CONFIG variant.
func NewEffectiveEntitlementValueConfig(value ConfigEffectiveEntitlementValue) EffectiveEntitlementValue {
	return EffectiveEntitlementValue{Type: EffectiveEntitlementValueConfig, Config: &value}
}

// IsKnown reports whether Type is one of the variants this SDK version
// knows about, i.e. one of the EffectiveEntitlementValue* constants. It is false for a
// variant added to the API later, whose payload is then only available from
// [EffectiveEntitlementValue.Raw].
func (u EffectiveEntitlementValue) IsKnown() bool {
	switch u.Type {
	case EffectiveEntitlementValueBoolean, EffectiveEntitlementValueMetered, EffectiveEntitlementValueConfig:
		return true
	}
	return false
}

// Raw returns the JSON of a variant this SDK version does not know about, as
// decoded (see [EffectiveEntitlementValue.IsKnown]). It is nil for a known variant, and
// for a value that was not decoded from JSON. The returned slice is a copy.
func (u EffectiveEntitlementValue) Raw() json.RawMessage {
	if u.IsKnown() || len(u.raw) == 0 {
		return nil
	}
	return append(json.RawMessage(nil), u.raw...)
}

// MarshalJSON implements json.Marshaler.
func (u EffectiveEntitlementValue) MarshalJSON() ([]byte, error) {
	switch u.Type {
	case EffectiveEntitlementValueBoolean:
		if u.Boolean == nil {
			return nil, &UnionError{Union: "EffectiveEntitlementValue", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Boolean)
	case EffectiveEntitlementValueMetered:
		if u.Metered == nil {
			return nil, &UnionError{Union: "EffectiveEntitlementValue", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Metered)
	case EffectiveEntitlementValueConfig:
		if u.Config == nil {
			return nil, &UnionError{Union: "EffectiveEntitlementValue", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Config)
	}

	if len(u.raw) > 0 {
		return u.raw, nil
	}
	if u.Type == "" {
		return nil, &UnionError{Union: "EffectiveEntitlementValue", Discriminator: "", Reason: "no variant set"}
	}
	return nil, &UnionError{Union: "EffectiveEntitlementValue", Discriminator: u.Type, Reason: "unknown discriminator"}
}

// UnmarshalJSON implements json.Unmarshaler.
//
// Payloads carrying an unrecognized discriminator are kept rather than rejected,
// so a newer API version does not break older SDK builds. Re-encoding such a
// value reproduces the same JSON document, though not necessarily the same
// bytes: `encoding/json` compacts whitespace and escapes `<`, `>` and `&`.
func (u *EffectiveEntitlementValue) UnmarshalJSON(data []byte) error {
	var tag struct {
		Type string `json:"type"`
	}
	if err := json.Unmarshal(data, &tag); err != nil {
		return err
	}

	*u = EffectiveEntitlementValue{Type: tag.Type}
	switch tag.Type {
	case EffectiveEntitlementValueBoolean:
		u.Boolean = new(BooleanEffectiveEntitlementValue)
		return json.Unmarshal(data, u.Boolean)
	case EffectiveEntitlementValueMetered:
		u.Metered = new(MeteredEffectiveEntitlementValue)
		return json.Unmarshal(data, u.Metered)
	case EffectiveEntitlementValueConfig:
		u.Config = new(ConfigEffectiveEntitlementValue)
		return json.Unmarshal(data, u.Config)
	default:
		u.raw = append(json.RawMessage(nil), data...)
		return nil
	}
}
