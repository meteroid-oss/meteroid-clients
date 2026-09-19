// this file is @generated
package meteroid

type CouponFilter string

// Known values of CouponFilter.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	CouponFilterAll      CouponFilter = "ALL"
	CouponFilterActive   CouponFilter = "ACTIVE"
	CouponFilterInactive CouponFilter = "INACTIVE"
	CouponFilterArchived CouponFilter = "ARCHIVED"
)

// AllCouponFilterValues lists every CouponFilter value known to this SDK version.
var AllCouponFilterValues = []CouponFilter{
	CouponFilterAll,
	CouponFilterActive,
	CouponFilterInactive,
	CouponFilterArchived,
}

// String returns the wire representation of the value.
func (e CouponFilter) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e CouponFilter) IsKnown() bool {
	for _, known := range AllCouponFilterValues {
		if e == known {
			return true
		}
	}
	return false
}
