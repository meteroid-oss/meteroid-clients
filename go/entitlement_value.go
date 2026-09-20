// this file is @generated
package meteroid

import "encoding/json"

// EntitlementValue is a tagged union discriminated by the type field.
//
// When [EntitlementValue.IsKnown] reports true, exactly one variant pointer is
// set, matching Type. A variant added to the API after this SDK
// version was released still decodes without error, but with every variant
// pointer nil: always give a `switch` on Type a `default:` branch (or
// check IsKnown first) instead of dereferencing a pointer unconditionally. The
// unknown variant's JSON is available from [EntitlementValue.Raw].
type EntitlementValue struct {
	// Type selects the active variant. Compare it against the
	// EntitlementValue* constants.
	Type string `json:"type"`

	// Boolean is set when Type is EntitlementValueBoolean.
	Boolean *BooleanEntitlementValue `json:"-"`
	// Metered is set when Type is EntitlementValueMetered.
	Metered *MeteredEntitlementValue `json:"-"`
	// Config is set when Type is EntitlementValueConfig.
	Config *ConfigEntitlementValue `json:"-"`

	// raw keeps the payload of a variant this SDK version does not know about, so
	// that decoding and re-encoding an unknown variant preserves every field and
	// value. It is not byte-for-byte identical: `encoding/json` compacts the
	// whitespace and escapes `<`, `>` and `&` as `\u003c`, `\u003e` and `\u0026`.
	raw json.RawMessage
}

// Discriminator values for EntitlementValue.
const (
	EntitlementValueBoolean = "BOOLEAN"
	EntitlementValueMetered = "METERED"
	EntitlementValueConfig  = "CONFIG"
)

// NewEntitlementValueBoolean builds a EntitlementValue holding the BOOLEAN variant.
func NewEntitlementValueBoolean(value BooleanEntitlementValue) EntitlementValue {
	return EntitlementValue{Type: EntitlementValueBoolean, Boolean: &value}
}

// NewEntitlementValueMetered builds a EntitlementValue holding the METERED variant.
func NewEntitlementValueMetered(value MeteredEntitlementValue) EntitlementValue {
	return EntitlementValue{Type: EntitlementValueMetered, Metered: &value}
}

// NewEntitlementValueConfig builds a EntitlementValue holding the CONFIG variant.
func NewEntitlementValueConfig(value ConfigEntitlementValue) EntitlementValue {
	return EntitlementValue{Type: EntitlementValueConfig, Config: &value}
}

// IsKnown reports whether Type is one of the variants this SDK version
// knows about, i.e. one of the EntitlementValue* constants. It is false for a
// variant added to the API later, whose payload is then only available from
// [EntitlementValue.Raw].
func (u EntitlementValue) IsKnown() bool {
	switch u.Type {
	case EntitlementValueBoolean, EntitlementValueMetered, EntitlementValueConfig:
		return true
	}
	return false
}

// Raw returns the JSON of a variant this SDK version does not know about, as
// decoded (see [EntitlementValue.IsKnown]). It is nil for a known variant, and
// for a value that was not decoded from JSON. The returned slice is a copy.
func (u EntitlementValue) Raw() json.RawMessage {
	if u.IsKnown() || len(u.raw) == 0 {
		return nil
	}
	return append(json.RawMessage(nil), u.raw...)
}

// MarshalJSON implements json.Marshaler.
func (u EntitlementValue) MarshalJSON() ([]byte, error) {
	switch u.Type {
	case EntitlementValueBoolean:
		if u.Boolean == nil {
			return nil, &UnionError{Union: "EntitlementValue", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Boolean)
	case EntitlementValueMetered:
		if u.Metered == nil {
			return nil, &UnionError{Union: "EntitlementValue", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Metered)
	case EntitlementValueConfig:
		if u.Config == nil {
			return nil, &UnionError{Union: "EntitlementValue", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Config)
	}

	if len(u.raw) > 0 {
		return u.raw, nil
	}
	if u.Type == "" {
		return nil, &UnionError{Union: "EntitlementValue", Discriminator: "", Reason: "no variant set"}
	}
	return nil, &UnionError{Union: "EntitlementValue", Discriminator: u.Type, Reason: "unknown discriminator"}
}

// UnmarshalJSON implements json.Unmarshaler.
//
// Payloads carrying an unrecognized discriminator are kept rather than rejected,
// so a newer API version does not break older SDK builds. Re-encoding such a
// value reproduces the same JSON document, though not necessarily the same
// bytes: `encoding/json` compacts whitespace and escapes `<`, `>` and `&`.
func (u *EntitlementValue) UnmarshalJSON(data []byte) error {
	var tag struct {
		Type string `json:"type"`
	}
	if err := json.Unmarshal(data, &tag); err != nil {
		return err
	}

	*u = EntitlementValue{Type: tag.Type}
	switch tag.Type {
	case EntitlementValueBoolean:
		u.Boolean = new(BooleanEntitlementValue)
		return json.Unmarshal(data, u.Boolean)
	case EntitlementValueMetered:
		u.Metered = new(MeteredEntitlementValue)
		return json.Unmarshal(data, u.Metered)
	case EntitlementValueConfig:
		u.Config = new(ConfigEntitlementValue)
		return json.Unmarshal(data, u.Config)
	default:
		u.raw = append(json.RawMessage(nil), data...)
		return nil
	}
}
