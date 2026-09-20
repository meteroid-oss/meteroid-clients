// this file is @generated
package meteroid

import "encoding/json"

// ResetPeriod is a tagged union discriminated by the type field.
//
// When [ResetPeriod.IsKnown] reports true, exactly one variant pointer is
// set, matching Type. A variant added to the API after this SDK
// version was released still decodes without error, but with every variant
// pointer nil: always give a `switch` on Type a `default:` branch (or
// check IsKnown first) instead of dereferencing a pointer unconditionally. The
// unknown variant's JSON is available from [ResetPeriod.Raw].
type ResetPeriod struct {
	// Type selects the active variant. Compare it against the
	// ResetPeriod* constants.
	Type string `json:"type"`

	// BillingCycle is set when Type is ResetPeriodBillingCycle.
	BillingCycle *BillingCycleResetPeriod `json:"-"`
	// Calendar is set when Type is ResetPeriodCalendar.
	Calendar *CalendarResetPeriod `json:"-"`
	// FixedWindow is set when Type is ResetPeriodFixedWindow.
	FixedWindow *FixedWindowResetPeriod `json:"-"`
	// SlidingWindow is set when Type is ResetPeriodSlidingWindow.
	SlidingWindow *SlidingWindowResetPeriod `json:"-"`
	// Never is set when Type is ResetPeriodNever.
	Never *NeverResetPeriod `json:"-"`

	// raw keeps the payload of a variant this SDK version does not know about, so
	// that decoding and re-encoding an unknown variant preserves every field and
	// value. It is not byte-for-byte identical: `encoding/json` compacts the
	// whitespace and escapes `<`, `>` and `&` as `\u003c`, `\u003e` and `\u0026`.
	raw json.RawMessage
}

// Discriminator values for ResetPeriod.
const (
	ResetPeriodBillingCycle  = "BILLING_CYCLE"
	ResetPeriodCalendar      = "CALENDAR"
	ResetPeriodFixedWindow   = "FIXED_WINDOW"
	ResetPeriodSlidingWindow = "SLIDING_WINDOW"
	ResetPeriodNever         = "NEVER"
)

// NewResetPeriodBillingCycle builds a ResetPeriod holding the BILLING_CYCLE variant.
func NewResetPeriodBillingCycle(value BillingCycleResetPeriod) ResetPeriod {
	return ResetPeriod{Type: ResetPeriodBillingCycle, BillingCycle: &value}
}

// NewResetPeriodCalendar builds a ResetPeriod holding the CALENDAR variant.
func NewResetPeriodCalendar(value CalendarResetPeriod) ResetPeriod {
	return ResetPeriod{Type: ResetPeriodCalendar, Calendar: &value}
}

// NewResetPeriodFixedWindow builds a ResetPeriod holding the FIXED_WINDOW variant.
func NewResetPeriodFixedWindow(value FixedWindowResetPeriod) ResetPeriod {
	return ResetPeriod{Type: ResetPeriodFixedWindow, FixedWindow: &value}
}

// NewResetPeriodSlidingWindow builds a ResetPeriod holding the SLIDING_WINDOW variant.
func NewResetPeriodSlidingWindow(value SlidingWindowResetPeriod) ResetPeriod {
	return ResetPeriod{Type: ResetPeriodSlidingWindow, SlidingWindow: &value}
}

// NewResetPeriodNever builds a ResetPeriod holding the NEVER variant.
func NewResetPeriodNever(value NeverResetPeriod) ResetPeriod {
	return ResetPeriod{Type: ResetPeriodNever, Never: &value}
}

// IsKnown reports whether Type is one of the variants this SDK version
// knows about, i.e. one of the ResetPeriod* constants. It is false for a
// variant added to the API later, whose payload is then only available from
// [ResetPeriod.Raw].
func (u ResetPeriod) IsKnown() bool {
	switch u.Type {
	case ResetPeriodBillingCycle, ResetPeriodCalendar, ResetPeriodFixedWindow, ResetPeriodSlidingWindow, ResetPeriodNever:
		return true
	}
	return false
}

// Raw returns the JSON of a variant this SDK version does not know about, as
// decoded (see [ResetPeriod.IsKnown]). It is nil for a known variant, and
// for a value that was not decoded from JSON. The returned slice is a copy.
func (u ResetPeriod) Raw() json.RawMessage {
	if u.IsKnown() || len(u.raw) == 0 {
		return nil
	}
	return append(json.RawMessage(nil), u.raw...)
}

// MarshalJSON implements json.Marshaler.
func (u ResetPeriod) MarshalJSON() ([]byte, error) {
	switch u.Type {
	case ResetPeriodBillingCycle:
		if u.BillingCycle == nil {
			return nil, &UnionError{Union: "ResetPeriod", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.BillingCycle)
	case ResetPeriodCalendar:
		if u.Calendar == nil {
			return nil, &UnionError{Union: "ResetPeriod", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Calendar)
	case ResetPeriodFixedWindow:
		if u.FixedWindow == nil {
			return nil, &UnionError{Union: "ResetPeriod", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.FixedWindow)
	case ResetPeriodSlidingWindow:
		if u.SlidingWindow == nil {
			return nil, &UnionError{Union: "ResetPeriod", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.SlidingWindow)
	case ResetPeriodNever:
		if u.Never == nil {
			return nil, &UnionError{Union: "ResetPeriod", Discriminator: u.Type, Reason: "variant payload is nil"}
		}
		return marshalUnionVariant("type", u.Type, u.Never)
	}

	if len(u.raw) > 0 {
		return u.raw, nil
	}
	if u.Type == "" {
		return nil, &UnionError{Union: "ResetPeriod", Discriminator: "", Reason: "no variant set"}
	}
	return nil, &UnionError{Union: "ResetPeriod", Discriminator: u.Type, Reason: "unknown discriminator"}
}

// UnmarshalJSON implements json.Unmarshaler.
//
// Payloads carrying an unrecognized discriminator are kept rather than rejected,
// so a newer API version does not break older SDK builds. Re-encoding such a
// value reproduces the same JSON document, though not necessarily the same
// bytes: `encoding/json` compacts whitespace and escapes `<`, `>` and `&`.
func (u *ResetPeriod) UnmarshalJSON(data []byte) error {
	var tag struct {
		Type string `json:"type"`
	}
	if err := json.Unmarshal(data, &tag); err != nil {
		return err
	}

	*u = ResetPeriod{Type: tag.Type}
	switch tag.Type {
	case ResetPeriodBillingCycle:
		u.BillingCycle = new(BillingCycleResetPeriod)
		return json.Unmarshal(data, u.BillingCycle)
	case ResetPeriodCalendar:
		u.Calendar = new(CalendarResetPeriod)
		return json.Unmarshal(data, u.Calendar)
	case ResetPeriodFixedWindow:
		u.FixedWindow = new(FixedWindowResetPeriod)
		return json.Unmarshal(data, u.FixedWindow)
	case ResetPeriodSlidingWindow:
		u.SlidingWindow = new(SlidingWindowResetPeriod)
		return json.Unmarshal(data, u.SlidingWindow)
	case ResetPeriodNever:
		u.Never = new(NeverResetPeriod)
		return json.Unmarshal(data, u.Never)
	default:
		u.raw = append(json.RawMessage(nil), data...)
		return nil
	}
}
