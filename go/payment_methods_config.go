// this file is @generated
package meteroid

import "encoding/json"

// Online (card/direct debit), BankTransfer, or External.
// PaymentMethodsConfig is a tagged union discriminated by the type field.
//
// When [PaymentMethodsConfig.IsKnown] reports true, exactly one variant pointer is
// set, matching Type. A variant added to the API after this SDK
// version was released still decodes without error, but with every variant
// pointer nil: always give a `switch` on Type a `default:` branch (or
// check IsKnown first) instead of dereferencing a pointer unconditionally. The
// unknown variant's JSON is available from [PaymentMethodsConfig.Raw].
type PaymentMethodsConfig struct {
	// Type selects the active variant. Compare it against the
	// PaymentMethodsConfig* constants.
	Type string `json:"type"`

	// Online is set when Type is PaymentMethodsConfigOnline.
	Online *OnlinePaymentMethodConfig `json:"-"`
	// BankTransfer is set when Type is PaymentMethodsConfigBankTransfer.
	BankTransfer *BankTransferPaymentMethodConfig `json:"-"`
	// External is set when Type is PaymentMethodsConfigExternal.
	External *ExternalPaymentMethodConfig `json:"-"`

	// raw keeps the payload of a variant this SDK version does not know about, so
	// that decoding and re-encoding an unknown variant preserves every field and
	// value. It is not byte-for-byte identical: `encoding/json` compacts the
	// whitespace and escapes `<`, `>` and `&` as `\u003c`, `\u003e` and `\u0026`.
	raw json.RawMessage
}

// Discriminator values for PaymentMethodsConfig.
const (
	PaymentMethodsConfigOnline       = "online"
	PaymentMethodsConfigBankTransfer = "bank_transfer"
	PaymentMethodsConfigExternal     = "external"
)

// NewPaymentMethodsConfigOnline builds a PaymentMethodsConfig holding the online variant.
func NewPaymentMethodsConfigOnline(value OnlinePaymentMethodConfig) PaymentMethodsConfig {
	return PaymentMethodsConfig{Type: PaymentMethodsConfigOnline, Online: &value}
}

// NewPaymentMethodsConfigBankTransfer builds a PaymentMethodsConfig holding the bank_transfer variant.
func NewPaymentMethodsConfigBankTransfer(value BankTransferPaymentMethodConfig) PaymentMethodsConfig {
	return PaymentMethodsConfig{Type: PaymentMethodsConfigBankTransfer, BankTransfer: &value}
}

// NewPaymentMethodsConfigExternal builds a PaymentMethodsConfig holding the external variant.
func NewPaymentMethodsConfigExternal(value ExternalPaymentMethodConfig) PaymentMethodsConfig {
	return PaymentMethodsConfig{Type: PaymentMethodsConfigExternal, External: &value}
}

// IsKnown reports whether Type is one of the variants this SDK version
// knows about, i.e. one of the PaymentMethodsConfig* constants. It is false for a
// variant added to the API later, whose payload is then only available from
// [PaymentMethodsConfig.Raw].
func (u PaymentMethodsConfig) IsKnown() bool {
	switch u.Type {
	case PaymentMethodsConfigOnline, PaymentMethodsConfigBankTransfer, PaymentMethodsConfigExternal:
		return true
	}
	return false
}

// Raw returns the JSON of a variant this SDK version does not know about, as
// decoded (see [PaymentMethodsConfig.IsKnown]). It is nil for a known variant, and
// for a value that was not decoded from JSON. The returned slice is a copy.
func (u PaymentMethodsConfig) Raw() json.RawMessage {
	if u.IsKnown() || len(u.raw) == 0 {
		return nil
	}
	return append(json.RawMessage(nil), u.raw...)
}

// MarshalJSON implements json.Marshaler.
func (u PaymentMethodsConfig) MarshalJSON() ([]byte, error) {
	switch u.Type {
	case PaymentMethodsConfigOnline:
		if u.Online == nil {
			return nil, &UnionError{Union: "PaymentMethodsConfig", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Online)
	case PaymentMethodsConfigBankTransfer:
		if u.BankTransfer == nil {
			return nil, &UnionError{Union: "PaymentMethodsConfig", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.BankTransfer)
	case PaymentMethodsConfigExternal:
		if u.External == nil {
			return nil, &UnionError{Union: "PaymentMethodsConfig", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.External)
	}

	if len(u.raw) > 0 {
		return u.raw, nil
	}
	if u.Type == "" {
		return nil, &UnionError{Union: "PaymentMethodsConfig", Discriminator: "", Reason: "no variant set"}
	}
	return nil, &UnionError{Union: "PaymentMethodsConfig", Discriminator: u.Type, Reason: "unknown discriminator"}
}

// UnmarshalJSON implements json.Unmarshaler.
//
// Payloads carrying an unrecognized discriminator are kept rather than rejected,
// so a newer API version does not break older SDK builds. Re-encoding such a
// value reproduces the same JSON document, though not necessarily the same
// bytes: `encoding/json` compacts whitespace and escapes `<`, `>` and `&`.
func (u *PaymentMethodsConfig) UnmarshalJSON(data []byte) error {
	var tag struct {
		Type string `json:"type"`
	}
	if err := json.Unmarshal(data, &tag); err != nil {
		return err
	}

	*u = PaymentMethodsConfig{Type: tag.Type}
	switch tag.Type {
	case PaymentMethodsConfigOnline:
		u.Online = new(OnlinePaymentMethodConfig)
		return json.Unmarshal(data, u.Online)
	case PaymentMethodsConfigBankTransfer:
		u.BankTransfer = new(BankTransferPaymentMethodConfig)
		return json.Unmarshal(data, u.BankTransfer)
	case PaymentMethodsConfigExternal:
		u.External = new(ExternalPaymentMethodConfig)
		return json.Unmarshal(data, u.External)
	default:
		u.raw = append(json.RawMessage(nil), data...)
		return nil
	}
}
