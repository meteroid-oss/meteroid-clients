// this file is @generated
package meteroid

import "encoding/json"

// ResolvedEntitlementValue is a tagged union discriminated by the type field.
// Exactly one variant pointer is set, matching Type.
type ResolvedEntitlementValue struct {
	// Type selects the active variant. Compare it against the
	// ResolvedEntitlementValue* constants.
	Type string `json:"type"`

	// Boolean is set when Type is ResolvedEntitlementValueBoolean.
	Boolean *BooleanResolvedEntitlementValue `json:"-"`
	// Metered is set when Type is ResolvedEntitlementValueMetered.
	Metered *MeteredResolvedEntitlementValue `json:"-"`
	// Config is set when Type is ResolvedEntitlementValueConfig.
	Config *ConfigResolvedEntitlementValue `json:"-"`

	// raw keeps the payload of a variant this SDK version does not know about, so
	// that decoding and re-encoding an unknown variant preserves every field and
	// value. It is not byte-for-byte identical: `encoding/json` compacts the
	// whitespace and escapes `<`, `>` and `&` as `\u003c`, `\u003e` and `\u0026`.
	raw json.RawMessage
}

// Discriminator values for ResolvedEntitlementValue.
const (
	ResolvedEntitlementValueBoolean = "BOOLEAN"
	ResolvedEntitlementValueMetered = "METERED"
	ResolvedEntitlementValueConfig  = "CONFIG"
)

// NewResolvedEntitlementValueBoolean builds a ResolvedEntitlementValue holding the BOOLEAN variant.
func NewResolvedEntitlementValueBoolean(value BooleanResolvedEntitlementValue) ResolvedEntitlementValue {
	return ResolvedEntitlementValue{Type: ResolvedEntitlementValueBoolean, Boolean: &value}
}

// NewResolvedEntitlementValueMetered builds a ResolvedEntitlementValue holding the METERED variant.
func NewResolvedEntitlementValueMetered(value MeteredResolvedEntitlementValue) ResolvedEntitlementValue {
	return ResolvedEntitlementValue{Type: ResolvedEntitlementValueMetered, Metered: &value}
}

// NewResolvedEntitlementValueConfig builds a ResolvedEntitlementValue holding the CONFIG variant.
func NewResolvedEntitlementValueConfig(value ConfigResolvedEntitlementValue) ResolvedEntitlementValue {
	return ResolvedEntitlementValue{Type: ResolvedEntitlementValueConfig, Config: &value}
}

// MarshalJSON implements json.Marshaler.
func (u ResolvedEntitlementValue) MarshalJSON() ([]byte, error) {
	switch u.Type {
	case ResolvedEntitlementValueBoolean:
		if u.Boolean == nil {
			return nil, &UnionError{Union: "ResolvedEntitlementValue", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Boolean)
	case ResolvedEntitlementValueMetered:
		if u.Metered == nil {
			return nil, &UnionError{Union: "ResolvedEntitlementValue", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Metered)
	case ResolvedEntitlementValueConfig:
		if u.Config == nil {
			return nil, &UnionError{Union: "ResolvedEntitlementValue", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Config)
	}

	if len(u.raw) > 0 {
		return u.raw, nil
	}
	if u.Type == "" {
		return nil, &UnionError{Union: "ResolvedEntitlementValue", Discriminator: "", Reason: "no variant set"}
	}
	return nil, &UnionError{Union: "ResolvedEntitlementValue", Discriminator: u.Type, Reason: "unknown discriminator"}
}

// UnmarshalJSON implements json.Unmarshaler.
//
// Payloads carrying an unrecognized discriminator are kept rather than rejected,
// so a newer API version does not break older SDK builds. Re-encoding such a
// value reproduces the same JSON document, though not necessarily the same
// bytes: `encoding/json` compacts whitespace and escapes `<`, `>` and `&`.
func (u *ResolvedEntitlementValue) UnmarshalJSON(data []byte) error {
	var tag struct {
		Type string `json:"type"`
	}
	if err := json.Unmarshal(data, &tag); err != nil {
		return err
	}

	*u = ResolvedEntitlementValue{Type: tag.Type}
	switch tag.Type {
	case ResolvedEntitlementValueBoolean:
		u.Boolean = new(BooleanResolvedEntitlementValue)
		return json.Unmarshal(data, u.Boolean)
	case ResolvedEntitlementValueMetered:
		u.Metered = new(MeteredResolvedEntitlementValue)
		return json.Unmarshal(data, u.Metered)
	case ResolvedEntitlementValueConfig:
		u.Config = new(ConfigResolvedEntitlementValue)
		return json.Unmarshal(data, u.Config)
	default:
		u.raw = append(json.RawMessage(nil), data...)
		return nil
	}
}
