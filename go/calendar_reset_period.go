// this file is @generated
package meteroid

// Resets on calendar boundaries (e.g. the 1st of every month) — not tied to subscription start date.
type CalendarResetPeriod struct {
	Interval int32 `json:"interval"`

	Unit CalendarUnit `json:"unit"`
}
