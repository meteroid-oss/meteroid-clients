// this file is @generated
package meteroid

type CustomPropertyType string

// Known values of CustomPropertyType.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	CustomPropertyTypeText         CustomPropertyType = "TEXT"
	CustomPropertyTypeNumber       CustomPropertyType = "NUMBER"
	CustomPropertyTypeBoolean      CustomPropertyType = "BOOLEAN"
	CustomPropertyTypeDate         CustomPropertyType = "DATE"
	CustomPropertyTypeDatetime     CustomPropertyType = "DATETIME"
	CustomPropertyTypeSingleSelect CustomPropertyType = "SINGLE_SELECT"
	CustomPropertyTypeMultiSelect  CustomPropertyType = "MULTI_SELECT"
	CustomPropertyTypeJson         CustomPropertyType = "JSON"
	CustomPropertyTypeUrl          CustomPropertyType = "URL"
	CustomPropertyTypeEmail        CustomPropertyType = "EMAIL"
)

// AllCustomPropertyTypeValues lists every CustomPropertyType value known to this SDK version.
var AllCustomPropertyTypeValues = []CustomPropertyType{
	CustomPropertyTypeText,
	CustomPropertyTypeNumber,
	CustomPropertyTypeBoolean,
	CustomPropertyTypeDate,
	CustomPropertyTypeDatetime,
	CustomPropertyTypeSingleSelect,
	CustomPropertyTypeMultiSelect,
	CustomPropertyTypeJson,
	CustomPropertyTypeUrl,
	CustomPropertyTypeEmail,
}

// String returns the wire representation of the value.
func (e CustomPropertyType) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e CustomPropertyType) IsKnown() bool {
	for _, known := range AllCustomPropertyTypeValues {
		if e == known {
			return true
		}
	}
	return false
}
