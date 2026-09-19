// this file is @generated
package meteroid

// Resets at regular intervals — anchored to your subscription's exact activation time.
type FixedWindowResetPeriod struct {
	Interval int32 `json:"interval"`

	Unit CalendarUnit `json:"unit"`
}
