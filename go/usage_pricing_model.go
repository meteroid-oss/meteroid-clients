// this file is @generated
package meteroid

import "encoding/json"

// UsagePricingModel is a tagged union discriminated by the type field.
//
// When [UsagePricingModel.IsKnown] reports true, exactly one variant pointer is
// set, matching Type. A variant added to the API after this SDK
// version was released still decodes without error, but with every variant
// pointer nil: always give a `switch` on Type a `default:` branch (or
// check IsKnown first) instead of dereferencing a pointer unconditionally. The
// unknown variant's JSON is available from [UsagePricingModel.Raw].
type UsagePricingModel struct {
	// Type selects the active variant. Compare it against the
	// UsagePricingModel* constants.
	Type string `json:"type"`

	// PerUnit is set when Type is UsagePricingModelPerUnit.
	PerUnit *PerUnitPricing `json:"-"`
	// Tiered is set when Type is UsagePricingModelTiered.
	Tiered *TieredPricing `json:"-"`
	// Volume is set when Type is UsagePricingModelVolume.
	Volume *VolumePricing `json:"-"`
	// Package is set when Type is UsagePricingModelPackage.
	Package *PackagePricing `json:"-"`
	// Matrix is set when Type is UsagePricingModelMatrix.
	Matrix *MatrixPricing `json:"-"`

	// raw keeps the payload of a variant this SDK version does not know about, so
	// that decoding and re-encoding an unknown variant preserves every field and
	// value. It is not byte-for-byte identical: `encoding/json` compacts the
	// whitespace and escapes `<`, `>` and `&` as `\u003c`, `\u003e` and `\u0026`.
	raw json.RawMessage
}

// Discriminator values for UsagePricingModel.
const (
	UsagePricingModelPerUnit = "PER_UNIT"
	UsagePricingModelTiered  = "TIERED"
	UsagePricingModelVolume  = "VOLUME"
	UsagePricingModelPackage = "PACKAGE"
	UsagePricingModelMatrix  = "MATRIX"
)

// NewUsagePricingModelPerUnit builds a UsagePricingModel holding the PER_UNIT variant.
func NewUsagePricingModelPerUnit(value PerUnitPricing) UsagePricingModel {
	return UsagePricingModel{Type: UsagePricingModelPerUnit, PerUnit: &value}
}

// NewUsagePricingModelTiered builds a UsagePricingModel holding the TIERED variant.
func NewUsagePricingModelTiered(value TieredPricing) UsagePricingModel {
	return UsagePricingModel{Type: UsagePricingModelTiered, Tiered: &value}
}

// NewUsagePricingModelVolume builds a UsagePricingModel holding the VOLUME variant.
func NewUsagePricingModelVolume(value VolumePricing) UsagePricingModel {
	return UsagePricingModel{Type: UsagePricingModelVolume, Volume: &value}
}

// NewUsagePricingModelPackage builds a UsagePricingModel holding the PACKAGE variant.
func NewUsagePricingModelPackage(value PackagePricing) UsagePricingModel {
	return UsagePricingModel{Type: UsagePricingModelPackage, Package: &value}
}

// NewUsagePricingModelMatrix builds a UsagePricingModel holding the MATRIX variant.
func NewUsagePricingModelMatrix(value MatrixPricing) UsagePricingModel {
	return UsagePricingModel{Type: UsagePricingModelMatrix, Matrix: &value}
}

// IsKnown reports whether Type is one of the variants this SDK version
// knows about, i.e. one of the UsagePricingModel* constants. It is false for a
// variant added to the API later, whose payload is then only available from
// [UsagePricingModel.Raw].
func (u UsagePricingModel) IsKnown() bool {
	switch u.Type {
	case UsagePricingModelPerUnit, UsagePricingModelTiered, UsagePricingModelVolume, UsagePricingModelPackage, UsagePricingModelMatrix:
		return true
	}
	return false
}

// Raw returns the JSON of a variant this SDK version does not know about, as
// decoded (see [UsagePricingModel.IsKnown]). It is nil for a known variant, and
// for a value that was not decoded from JSON. The returned slice is a copy.
func (u UsagePricingModel) Raw() json.RawMessage {
	if u.IsKnown() || len(u.raw) == 0 {
		return nil
	}
	return append(json.RawMessage(nil), u.raw...)
}

// MarshalJSON implements json.Marshaler.
func (u UsagePricingModel) MarshalJSON() ([]byte, error) {
	switch u.Type {
	case UsagePricingModelPerUnit:
		if u.PerUnit == nil {
			return nil, &UnionError{Union: "UsagePricingModel", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.PerUnit)
	case UsagePricingModelTiered:
		if u.Tiered == nil {
			return nil, &UnionError{Union: "UsagePricingModel", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Tiered)
	case UsagePricingModelVolume:
		if u.Volume == nil {
			return nil, &UnionError{Union: "UsagePricingModel", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Volume)
	case UsagePricingModelPackage:
		if u.Package == nil {
			return nil, &UnionError{Union: "UsagePricingModel", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Package)
	case UsagePricingModelMatrix:
		if u.Matrix == nil {
			return nil, &UnionError{Union: "UsagePricingModel", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Matrix)
	}

	if len(u.raw) > 0 {
		return u.raw, nil
	}
	if u.Type == "" {
		return nil, &UnionError{Union: "UsagePricingModel", Discriminator: "", Reason: "no variant set"}
	}
	return nil, &UnionError{Union: "UsagePricingModel", Discriminator: u.Type, Reason: "unknown discriminator"}
}

// UnmarshalJSON implements json.Unmarshaler.
//
// Payloads carrying an unrecognized discriminator are kept rather than rejected,
// so a newer API version does not break older SDK builds. Re-encoding such a
// value reproduces the same JSON document, though not necessarily the same
// bytes: `encoding/json` compacts whitespace and escapes `<`, `>` and `&`.
func (u *UsagePricingModel) UnmarshalJSON(data []byte) error {
	var tag struct {
		Type string `json:"type"`
	}
	if err := json.Unmarshal(data, &tag); err != nil {
		return err
	}

	*u = UsagePricingModel{Type: tag.Type}
	switch tag.Type {
	case UsagePricingModelPerUnit:
		u.PerUnit = new(PerUnitPricing)
		return json.Unmarshal(data, u.PerUnit)
	case UsagePricingModelTiered:
		u.Tiered = new(TieredPricing)
		return json.Unmarshal(data, u.Tiered)
	case UsagePricingModelVolume:
		u.Volume = new(VolumePricing)
		return json.Unmarshal(data, u.Volume)
	case UsagePricingModelPackage:
		u.Package = new(PackagePricing)
		return json.Unmarshal(data, u.Package)
	case UsagePricingModelMatrix:
		u.Matrix = new(MatrixPricing)
		return json.Unmarshal(data, u.Matrix)
	default:
		u.raw = append(json.RawMessage(nil), data...)
		return nil
	}
}
