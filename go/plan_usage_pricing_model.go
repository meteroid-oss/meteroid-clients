// this file is @generated
package meteroid

import "encoding/json"

// PlanUsagePricingModel is a tagged union discriminated by the type field.
//
// When [PlanUsagePricingModel.IsKnown] reports true, exactly one variant pointer is
// set, matching Type. A variant added to the API after this SDK
// version was released still decodes without error, but with every variant
// pointer nil: always give a `switch` on Type a `default:` branch (or
// check IsKnown first) instead of dereferencing a pointer unconditionally. The
// unknown variant's JSON is available from [PlanUsagePricingModel.Raw].
type PlanUsagePricingModel struct {
	// Type selects the active variant. Compare it against the
	// PlanUsagePricingModel* constants.
	Type string `json:"type"`

	// PerUnit is set when Type is PlanUsagePricingModelPerUnit.
	PerUnit *PerUnitPlanPricing `json:"-"`
	// Tiered is set when Type is PlanUsagePricingModelTiered.
	Tiered *TieredPlanPricing `json:"-"`
	// Volume is set when Type is PlanUsagePricingModelVolume.
	Volume *VolumePlanPricing `json:"-"`
	// Package is set when Type is PlanUsagePricingModelPackage.
	Package *PackagePlanPricing `json:"-"`
	// Matrix is set when Type is PlanUsagePricingModelMatrix.
	Matrix *MatrixPlanPricing `json:"-"`

	// raw keeps the payload of a variant this SDK version does not know about, so
	// that decoding and re-encoding an unknown variant preserves every field and
	// value. It is not byte-for-byte identical: `encoding/json` compacts the
	// whitespace and escapes `<`, `>` and `&` as `\u003c`, `\u003e` and `\u0026`.
	raw json.RawMessage
}

// Discriminator values for PlanUsagePricingModel.
const (
	PlanUsagePricingModelPerUnit = "PER_UNIT"
	PlanUsagePricingModelTiered  = "TIERED"
	PlanUsagePricingModelVolume  = "VOLUME"
	PlanUsagePricingModelPackage = "PACKAGE"
	PlanUsagePricingModelMatrix  = "MATRIX"
)

// NewPlanUsagePricingModelPerUnit builds a PlanUsagePricingModel holding the PER_UNIT variant.
func NewPlanUsagePricingModelPerUnit(value PerUnitPlanPricing) PlanUsagePricingModel {
	return PlanUsagePricingModel{Type: PlanUsagePricingModelPerUnit, PerUnit: &value}
}

// NewPlanUsagePricingModelTiered builds a PlanUsagePricingModel holding the TIERED variant.
func NewPlanUsagePricingModelTiered(value TieredPlanPricing) PlanUsagePricingModel {
	return PlanUsagePricingModel{Type: PlanUsagePricingModelTiered, Tiered: &value}
}

// NewPlanUsagePricingModelVolume builds a PlanUsagePricingModel holding the VOLUME variant.
func NewPlanUsagePricingModelVolume(value VolumePlanPricing) PlanUsagePricingModel {
	return PlanUsagePricingModel{Type: PlanUsagePricingModelVolume, Volume: &value}
}

// NewPlanUsagePricingModelPackage builds a PlanUsagePricingModel holding the PACKAGE variant.
func NewPlanUsagePricingModelPackage(value PackagePlanPricing) PlanUsagePricingModel {
	return PlanUsagePricingModel{Type: PlanUsagePricingModelPackage, Package: &value}
}

// NewPlanUsagePricingModelMatrix builds a PlanUsagePricingModel holding the MATRIX variant.
func NewPlanUsagePricingModelMatrix(value MatrixPlanPricing) PlanUsagePricingModel {
	return PlanUsagePricingModel{Type: PlanUsagePricingModelMatrix, Matrix: &value}
}

// IsKnown reports whether Type is one of the variants this SDK version
// knows about, i.e. one of the PlanUsagePricingModel* constants. It is false for a
// variant added to the API later, whose payload is then only available from
// [PlanUsagePricingModel.Raw].
func (u PlanUsagePricingModel) IsKnown() bool {
	switch u.Type {
	case PlanUsagePricingModelPerUnit, PlanUsagePricingModelTiered, PlanUsagePricingModelVolume, PlanUsagePricingModelPackage, PlanUsagePricingModelMatrix:
		return true
	}
	return false
}

// Raw returns the JSON of a variant this SDK version does not know about, as
// decoded (see [PlanUsagePricingModel.IsKnown]). It is nil for a known variant, and
// for a value that was not decoded from JSON. The returned slice is a copy.
func (u PlanUsagePricingModel) Raw() json.RawMessage {
	if u.IsKnown() || len(u.raw) == 0 {
		return nil
	}
	return append(json.RawMessage(nil), u.raw...)
}

// MarshalJSON implements json.Marshaler.
func (u PlanUsagePricingModel) MarshalJSON() ([]byte, error) {
	switch u.Type {
	case PlanUsagePricingModelPerUnit:
		if u.PerUnit == nil {
			return nil, &UnionError{Union: "PlanUsagePricingModel", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.PerUnit)
	case PlanUsagePricingModelTiered:
		if u.Tiered == nil {
			return nil, &UnionError{Union: "PlanUsagePricingModel", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Tiered)
	case PlanUsagePricingModelVolume:
		if u.Volume == nil {
			return nil, &UnionError{Union: "PlanUsagePricingModel", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Volume)
	case PlanUsagePricingModelPackage:
		if u.Package == nil {
			return nil, &UnionError{Union: "PlanUsagePricingModel", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Package)
	case PlanUsagePricingModelMatrix:
		if u.Matrix == nil {
			return nil, &UnionError{Union: "PlanUsagePricingModel", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Matrix)
	}

	if len(u.raw) > 0 {
		return u.raw, nil
	}
	if u.Type == "" {
		return nil, &UnionError{Union: "PlanUsagePricingModel", Discriminator: "", Reason: "no variant set"}
	}
	return nil, &UnionError{Union: "PlanUsagePricingModel", Discriminator: u.Type, Reason: "unknown discriminator"}
}

// UnmarshalJSON implements json.Unmarshaler.
//
// Payloads carrying an unrecognized discriminator are kept rather than rejected,
// so a newer API version does not break older SDK builds. Re-encoding such a
// value reproduces the same JSON document, though not necessarily the same
// bytes: `encoding/json` compacts whitespace and escapes `<`, `>` and `&`.
func (u *PlanUsagePricingModel) UnmarshalJSON(data []byte) error {
	var tag struct {
		Type string `json:"type"`
	}
	if err := json.Unmarshal(data, &tag); err != nil {
		return err
	}

	*u = PlanUsagePricingModel{Type: tag.Type}
	switch tag.Type {
	case PlanUsagePricingModelPerUnit:
		u.PerUnit = new(PerUnitPlanPricing)
		return json.Unmarshal(data, u.PerUnit)
	case PlanUsagePricingModelTiered:
		u.Tiered = new(TieredPlanPricing)
		return json.Unmarshal(data, u.Tiered)
	case PlanUsagePricingModelVolume:
		u.Volume = new(VolumePlanPricing)
		return json.Unmarshal(data, u.Volume)
	case PlanUsagePricingModelPackage:
		u.Package = new(PackagePlanPricing)
		return json.Unmarshal(data, u.Package)
	case PlanUsagePricingModelMatrix:
		u.Matrix = new(MatrixPlanPricing)
		return json.Unmarshal(data, u.Matrix)
	default:
		u.raw = append(json.RawMessage(nil), data...)
		return nil
	}
}
