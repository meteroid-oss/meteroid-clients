// this file is @generated
package meteroid

// Always ends at now — e.g. 30 days means the last 30 days, old usage drops off automatically.
type SlidingWindowResetPeriod struct {
	Interval int32 `json:"interval"`

	Unit CalendarUnit `json:"unit"`
}
