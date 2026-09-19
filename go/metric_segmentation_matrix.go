// this file is @generated
package meteroid

import "encoding/json"

// MetricSegmentationMatrix is a tagged union discriminated by the type field.
// Exactly one variant pointer is set, matching Type.
type MetricSegmentationMatrix struct {
	// Type selects the active variant. Compare it against the
	// MetricSegmentationMatrix* constants.
	Type string `json:"type"`

	// Single is set when Type is MetricSegmentationMatrixSingle.
	Single *MetricDimension `json:"-"`
	// Double is set when Type is MetricSegmentationMatrixDouble.
	Double *DoubleSegmentationMatrix `json:"-"`
	// Linked is set when Type is MetricSegmentationMatrixLinked.
	Linked *LinkedSegmentationMatrix `json:"-"`

	// raw keeps the payload of a variant this SDK version does not know about, so
	// that decoding and re-encoding an unknown variant preserves every field and
	// value. It is not byte-for-byte identical: `encoding/json` compacts the
	// whitespace and escapes `<`, `>` and `&` as `\u003c`, `\u003e` and `\u0026`.
	raw json.RawMessage
}

// Discriminator values for MetricSegmentationMatrix.
const (
	MetricSegmentationMatrixSingle = "SINGLE"
	MetricSegmentationMatrixDouble = "DOUBLE"
	MetricSegmentationMatrixLinked = "LINKED"
)

// NewMetricSegmentationMatrixSingle builds a MetricSegmentationMatrix holding the SINGLE variant.
func NewMetricSegmentationMatrixSingle(value MetricDimension) MetricSegmentationMatrix {
	return MetricSegmentationMatrix{Type: MetricSegmentationMatrixSingle, Single: &value}
}

// NewMetricSegmentationMatrixDouble builds a MetricSegmentationMatrix holding the DOUBLE variant.
func NewMetricSegmentationMatrixDouble(value DoubleSegmentationMatrix) MetricSegmentationMatrix {
	return MetricSegmentationMatrix{Type: MetricSegmentationMatrixDouble, Double: &value}
}

// NewMetricSegmentationMatrixLinked builds a MetricSegmentationMatrix holding the LINKED variant.
func NewMetricSegmentationMatrixLinked(value LinkedSegmentationMatrix) MetricSegmentationMatrix {
	return MetricSegmentationMatrix{Type: MetricSegmentationMatrixLinked, Linked: &value}
}

// MarshalJSON implements json.Marshaler.
func (u MetricSegmentationMatrix) MarshalJSON() ([]byte, error) {
	switch u.Type {
	case MetricSegmentationMatrixSingle:
		if u.Single == nil {
			return nil, &UnionError{Union: "MetricSegmentationMatrix", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Single)
	case MetricSegmentationMatrixDouble:
		if u.Double == nil {
			return nil, &UnionError{Union: "MetricSegmentationMatrix", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Double)
	case MetricSegmentationMatrixLinked:
		if u.Linked == nil {
			return nil, &UnionError{Union: "MetricSegmentationMatrix", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Linked)
	}

	if len(u.raw) > 0 {
		return u.raw, nil
	}
	if u.Type == "" {
		return nil, &UnionError{Union: "MetricSegmentationMatrix", Discriminator: "", Reason: "no variant set"}
	}
	return nil, &UnionError{Union: "MetricSegmentationMatrix", Discriminator: u.Type, Reason: "unknown discriminator"}
}

// UnmarshalJSON implements json.Unmarshaler.
//
// Payloads carrying an unrecognized discriminator are kept rather than rejected,
// so a newer API version does not break older SDK builds. Re-encoding such a
// value reproduces the same JSON document, though not necessarily the same
// bytes: `encoding/json` compacts whitespace and escapes `<`, `>` and `&`.
func (u *MetricSegmentationMatrix) UnmarshalJSON(data []byte) error {
	var tag struct {
		Type string `json:"type"`
	}
	if err := json.Unmarshal(data, &tag); err != nil {
		return err
	}

	*u = MetricSegmentationMatrix{Type: tag.Type}
	switch tag.Type {
	case MetricSegmentationMatrixSingle:
		u.Single = new(MetricDimension)
		return json.Unmarshal(data, u.Single)
	case MetricSegmentationMatrixDouble:
		u.Double = new(DoubleSegmentationMatrix)
		return json.Unmarshal(data, u.Double)
	case MetricSegmentationMatrixLinked:
		u.Linked = new(LinkedSegmentationMatrix)
		return json.Unmarshal(data, u.Linked)
	default:
		u.raw = append(json.RawMessage(nil), data...)
		return nil
	}
}
