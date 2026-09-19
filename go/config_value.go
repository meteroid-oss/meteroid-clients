// this file is @generated
package meteroid

import "encoding/json"

// A static, typed configuration value carried by a Config entitlement. Resolved synchronously
// through the entitlement hierarchy — no metric, no usage counter.
// ConfigValue is a tagged union discriminated by the kind field.
//
// When [ConfigValue.IsKnown] reports true, exactly one variant pointer is
// set, matching Kind. A variant added to the API after this SDK
// version was released still decodes without error, but with every variant
// pointer nil: always give a `switch` on Kind a `default:` branch (or
// check IsKnown first) instead of dereferencing a pointer unconditionally. The
// unknown variant's JSON is available from [ConfigValue.Raw].
type ConfigValue struct {
	// Kind selects the active variant. Compare it against the
	// ConfigValue* constants.
	Kind string `json:"kind"`

	// Number is set when Kind is ConfigValueNumber.
	Number *NumberConfigValue `json:"-"`
	// Boolean is set when Kind is ConfigValueBoolean.
	Boolean *BooleanConfigValue `json:"-"`
	// Text is set when Kind is ConfigValueText.
	Text *TextConfigValue `json:"-"`
	// Json is set when Kind is ConfigValueJson.
	Json *JsonConfigValue `json:"-"`

	// raw keeps the payload of a variant this SDK version does not know about, so
	// that decoding and re-encoding an unknown variant preserves every field and
	// value. It is not byte-for-byte identical: `encoding/json` compacts the
	// whitespace and escapes `<`, `>` and `&` as `\u003c`, `\u003e` and `\u0026`.
	raw json.RawMessage
}

// Discriminator values for ConfigValue.
const (
	ConfigValueNumber  = "NUMBER"
	ConfigValueBoolean = "BOOLEAN"
	ConfigValueText    = "TEXT"
	ConfigValueJson    = "JSON"
)

// NewConfigValueNumber builds a ConfigValue holding the NUMBER variant.
func NewConfigValueNumber(value NumberConfigValue) ConfigValue {
	return ConfigValue{Kind: ConfigValueNumber, Number: &value}
}

// NewConfigValueBoolean builds a ConfigValue holding the BOOLEAN variant.
func NewConfigValueBoolean(value BooleanConfigValue) ConfigValue {
	return ConfigValue{Kind: ConfigValueBoolean, Boolean: &value}
}

// NewConfigValueText builds a ConfigValue holding the TEXT variant.
func NewConfigValueText(value TextConfigValue) ConfigValue {
	return ConfigValue{Kind: ConfigValueText, Text: &value}
}

// NewConfigValueJson builds a ConfigValue holding the JSON variant.
func NewConfigValueJson(value JsonConfigValue) ConfigValue {
	return ConfigValue{Kind: ConfigValueJson, Json: &value}
}

// IsKnown reports whether Kind is one of the variants this SDK version
// knows about, i.e. one of the ConfigValue* constants. It is false for a
// variant added to the API later, whose payload is then only available from
// [ConfigValue.Raw].
func (u ConfigValue) IsKnown() bool {
	switch u.Kind {
	case ConfigValueNumber, ConfigValueBoolean, ConfigValueText, ConfigValueJson:
		return true
	}
	return false
}

// Raw returns the JSON of a variant this SDK version does not know about, as
// decoded (see [ConfigValue.IsKnown]). It is nil for a known variant, and
// for a value that was not decoded from JSON. The returned slice is a copy.
func (u ConfigValue) Raw() json.RawMessage {
	if u.IsKnown() || len(u.raw) == 0 {
		return nil
	}
	return append(json.RawMessage(nil), u.raw...)
}

// MarshalJSON implements json.Marshaler.
func (u ConfigValue) MarshalJSON() ([]byte, error) {
	switch u.Kind {
	case ConfigValueNumber:
		if u.Number == nil {
			return nil, &UnionError{Union: "ConfigValue", Discriminator: u.Kind, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("kind", u.Kind, u.Number)
	case ConfigValueBoolean:
		if u.Boolean == nil {
			return nil, &UnionError{Union: "ConfigValue", Discriminator: u.Kind, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("kind", u.Kind, u.Boolean)
	case ConfigValueText:
		if u.Text == nil {
			return nil, &UnionError{Union: "ConfigValue", Discriminator: u.Kind, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("kind", u.Kind, u.Text)
	case ConfigValueJson:
		if u.Json == nil {
			return nil, &UnionError{Union: "ConfigValue", Discriminator: u.Kind, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("kind", u.Kind, u.Json)
	}

	if len(u.raw) > 0 {
		return u.raw, nil
	}
	if u.Kind == "" {
		return nil, &UnionError{Union: "ConfigValue", Discriminator: "", Reason: "no variant set"}
	}
	return nil, &UnionError{Union: "ConfigValue", Discriminator: u.Kind, Reason: "unknown discriminator"}
}

// UnmarshalJSON implements json.Unmarshaler.
//
// Payloads carrying an unrecognized discriminator are kept rather than rejected,
// so a newer API version does not break older SDK builds. Re-encoding such a
// value reproduces the same JSON document, though not necessarily the same
// bytes: `encoding/json` compacts whitespace and escapes `<`, `>` and `&`.
func (u *ConfigValue) UnmarshalJSON(data []byte) error {
	var tag struct {
		Kind string `json:"kind"`
	}
	if err := json.Unmarshal(data, &tag); err != nil {
		return err
	}

	*u = ConfigValue{Kind: tag.Kind}
	switch tag.Kind {
	case ConfigValueNumber:
		u.Number = new(NumberConfigValue)
		return json.Unmarshal(data, u.Number)
	case ConfigValueBoolean:
		u.Boolean = new(BooleanConfigValue)
		return json.Unmarshal(data, u.Boolean)
	case ConfigValueText:
		u.Text = new(TextConfigValue)
		return json.Unmarshal(data, u.Text)
	case ConfigValueJson:
		u.Json = new(JsonConfigValue)
		return json.Unmarshal(data, u.Json)
	default:
		u.raw = append(json.RawMessage(nil), data...)
		return nil
	}
}
