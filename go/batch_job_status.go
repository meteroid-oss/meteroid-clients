// this file is @generated
package meteroid

type BatchJobStatus string

// Known values of BatchJobStatus.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	BatchJobStatusPending             BatchJobStatus = "PENDING"
	BatchJobStatusChunking            BatchJobStatus = "CHUNKING"
	BatchJobStatusProcessing          BatchJobStatus = "PROCESSING"
	BatchJobStatusCompleted           BatchJobStatus = "COMPLETED"
	BatchJobStatusCompletedWithErrors BatchJobStatus = "COMPLETED_WITH_ERRORS"
	BatchJobStatusFailed              BatchJobStatus = "FAILED"
	BatchJobStatusCancelled           BatchJobStatus = "CANCELLED"
)

// AllBatchJobStatusValues lists every BatchJobStatus value known to this SDK version.
var AllBatchJobStatusValues = []BatchJobStatus{
	BatchJobStatusPending,
	BatchJobStatusChunking,
	BatchJobStatusProcessing,
	BatchJobStatusCompleted,
	BatchJobStatusCompletedWithErrors,
	BatchJobStatusFailed,
	BatchJobStatusCancelled,
}

// String returns the wire representation of the value.
func (e BatchJobStatus) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e BatchJobStatus) IsKnown() bool {
	for _, known := range AllBatchJobStatusValues {
		if e == known {
			return true
		}
	}
	return false
}
