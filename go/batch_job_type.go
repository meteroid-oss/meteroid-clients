// this file is @generated
package meteroid

type BatchJobType string

// Known values of BatchJobType.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	BatchJobTypeEventCsvImport            BatchJobType = "EVENT_CSV_IMPORT"
	BatchJobTypeCustomerCsvImport         BatchJobType = "CUSTOMER_CSV_IMPORT"
	BatchJobTypeSubscriptionCsvImport     BatchJobType = "SUBSCRIPTION_CSV_IMPORT"
	BatchJobTypeSubscriptionPlanMigration BatchJobType = "SUBSCRIPTION_PLAN_MIGRATION"
	BatchJobTypeTaxReportExport           BatchJobType = "TAX_REPORT_EXPORT"
)

// AllBatchJobTypeValues lists every BatchJobType value known to this SDK version.
var AllBatchJobTypeValues = []BatchJobType{
	BatchJobTypeEventCsvImport,
	BatchJobTypeCustomerCsvImport,
	BatchJobTypeSubscriptionCsvImport,
	BatchJobTypeSubscriptionPlanMigration,
	BatchJobTypeTaxReportExport,
}

// String returns the wire representation of the value.
func (e BatchJobType) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e BatchJobType) IsKnown() bool {
	for _, known := range AllBatchJobTypeValues {
		if e == known {
			return true
		}
	}
	return false
}
