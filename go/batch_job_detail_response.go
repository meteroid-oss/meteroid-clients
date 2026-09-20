// this file is @generated
package meteroid

import "time"

type BatchJobDetailResponse struct {
	// RFC 3339 timestamp.
	CompletedAt *time.Time `json:"completed_at,omitempty"`

	// RFC 3339 timestamp.
	CreatedAt time.Time `json:"created_at"`

	CreatedBy string `json:"created_by"`

	ErrorCsvUrl *string `json:"error_csv_url,omitempty"`

	FailedItems int32 `json:"failed_items"`

	FailureCount int64 `json:"failure_count"`

	HasErrorCsv bool `json:"has_error_csv"`

	HasOutput bool `json:"has_output"`

	Id BatchJobId `json:"id"`

	InputFileName *string `json:"input_file_name,omitempty"`

	InputFileUrl *string `json:"input_file_url,omitempty"`

	JobType BatchJobType `json:"job_type"`

	OutputUrl *string `json:"output_url,omitempty"`

	ProcessedItems int32 `json:"processed_items"`

	Status BatchJobStatus `json:"status"`

	TotalItems *int32 `json:"total_items,omitempty"`
}
