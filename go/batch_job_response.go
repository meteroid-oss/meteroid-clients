// this file is @generated
package meteroid

import "time"

type BatchJobResponse struct {
	// RFC 3339 timestamp.
	CompletedAt *time.Time `json:"completed_at,omitempty"`

	// RFC 3339 timestamp.
	CreatedAt time.Time `json:"created_at"`

	CreatedBy string `json:"created_by"`

	FailedItems int32 `json:"failed_items"`

	Id BatchJobId `json:"id"`

	InputFileName *string `json:"input_file_name,omitempty"`

	JobType BatchJobType `json:"job_type"`

	ProcessedItems int32 `json:"processed_items"`

	Status BatchJobStatus `json:"status"`

	TotalItems *int32 `json:"total_items,omitempty"`
}
