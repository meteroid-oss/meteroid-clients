// this file is @generated
package meteroid

import "encoding/json"

// FeatureType is a tagged union discriminated by the type field.
//
// When [FeatureType.IsKnown] reports true, exactly one variant pointer is
// set, matching Type. A variant added to the API after this SDK
// version was released still decodes without error, but with every variant
// pointer nil: always give a `switch` on Type a `default:` branch (or
// check IsKnown first) instead of dereferencing a pointer unconditionally. The
// unknown variant's JSON is available from [FeatureType.Raw].
type FeatureType struct {
	// Type selects the active variant. Compare it against the
	// FeatureType* constants.
	Type string `json:"type"`

	// Boolean is set when Type is FeatureTypeBoolean.
	Boolean *BooleanFeatureType `json:"-"`
	// Metered is set when Type is FeatureTypeMetered.
	Metered *MeteredFeatureType `json:"-"`
	// Config is set when Type is FeatureTypeConfig.
	Config *ConfigFeatureType `json:"-"`

	// raw keeps the payload of a variant this SDK version does not know about, so
	// that decoding and re-encoding an unknown variant preserves every field and
	// value. It is not byte-for-byte identical: `encoding/json` compacts the
	// whitespace and escapes `<`, `>` and `&` as `\u003c`, `\u003e` and `\u0026`.
	raw json.RawMessage
}

// Discriminator values for FeatureType.
const (
	FeatureTypeBoolean = "BOOLEAN"
	FeatureTypeMetered = "METERED"
	FeatureTypeConfig  = "CONFIG"
)

// NewFeatureTypeBoolean builds a FeatureType holding the BOOLEAN variant.
func NewFeatureTypeBoolean(value BooleanFeatureType) FeatureType {
	return FeatureType{Type: FeatureTypeBoolean, Boolean: &value}
}

// NewFeatureTypeMetered builds a FeatureType holding the METERED variant.
func NewFeatureTypeMetered(value MeteredFeatureType) FeatureType {
	return FeatureType{Type: FeatureTypeMetered, Metered: &value}
}

// NewFeatureTypeConfig builds a FeatureType holding the CONFIG variant.
func NewFeatureTypeConfig(value ConfigFeatureType) FeatureType {
	return FeatureType{Type: FeatureTypeConfig, Config: &value}
}

// IsKnown reports whether Type is one of the variants this SDK version
// knows about, i.e. one of the FeatureType* constants. It is false for a
// variant added to the API later, whose payload is then only available from
// [FeatureType.Raw].
func (u FeatureType) IsKnown() bool {
	switch u.Type {
	case FeatureTypeBoolean, FeatureTypeMetered, FeatureTypeConfig:
		return true
	}
	return false
}

// Raw returns the JSON of a variant this SDK version does not know about, as
// decoded (see [FeatureType.IsKnown]). It is nil for a known variant, and
// for a value that was not decoded from JSON. The returned slice is a copy.
func (u FeatureType) Raw() json.RawMessage {
	if u.IsKnown() || len(u.raw) == 0 {
		return nil
	}
	return append(json.RawMessage(nil), u.raw...)
}

// MarshalJSON implements json.Marshaler.
func (u FeatureType) MarshalJSON() ([]byte, error) {
	switch u.Type {
	case FeatureTypeBoolean:
		if u.Boolean == nil {
			return nil, &UnionError{Union: "FeatureType", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Boolean)
	case FeatureTypeMetered:
		if u.Metered == nil {
			return nil, &UnionError{Union: "FeatureType", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Metered)
	case FeatureTypeConfig:
		if u.Config == nil {
			return nil, &UnionError{Union: "FeatureType", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Config)
	}

	if len(u.raw) > 0 {
		return u.raw, nil
	}
	if u.Type == "" {
		return nil, &UnionError{Union: "FeatureType", Discriminator: "", Reason: "no variant set"}
	}
	return nil, &UnionError{Union: "FeatureType", Discriminator: u.Type, Reason: "unknown discriminator"}
}

// UnmarshalJSON implements json.Unmarshaler.
//
// Payloads carrying an unrecognized discriminator are kept rather than rejected,
// so a newer API version does not break older SDK builds. Re-encoding such a
// value reproduces the same JSON document, though not necessarily the same
// bytes: `encoding/json` compacts whitespace and escapes `<`, `>` and `&`.
func (u *FeatureType) UnmarshalJSON(data []byte) error {
	var tag struct {
		Type string `json:"type"`
	}
	if err := json.Unmarshal(data, &tag); err != nil {
		return err
	}

	*u = FeatureType{Type: tag.Type}
	switch tag.Type {
	case FeatureTypeBoolean:
		u.Boolean = new(BooleanFeatureType)
		return json.Unmarshal(data, u.Boolean)
	case FeatureTypeMetered:
		u.Metered = new(MeteredFeatureType)
		return json.Unmarshal(data, u.Metered)
	case FeatureTypeConfig:
		u.Config = new(ConfigFeatureType)
		return json.Unmarshal(data, u.Config)
	default:
		u.raw = append(json.RawMessage(nil), data...)
		return nil
	}
}
