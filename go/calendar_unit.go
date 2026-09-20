// this file is @generated
package meteroid

type CalendarUnit string

// Known values of CalendarUnit.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	CalendarUnitHour  CalendarUnit = "HOUR"
	CalendarUnitDay   CalendarUnit = "DAY"
	CalendarUnitWeek  CalendarUnit = "WEEK"
	CalendarUnitMonth CalendarUnit = "MONTH"
	CalendarUnitYear  CalendarUnit = "YEAR"
)

// AllCalendarUnitValues lists every CalendarUnit value known to this SDK version.
var AllCalendarUnitValues = []CalendarUnit{
	CalendarUnitHour,
	CalendarUnitDay,
	CalendarUnitWeek,
	CalendarUnitMonth,
	CalendarUnitYear,
}

// String returns the wire representation of the value.
func (e CalendarUnit) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e CalendarUnit) IsKnown() bool {
	for _, known := range AllCalendarUnitValues {
		if e == known {
			return true
		}
	}
	return false
}
