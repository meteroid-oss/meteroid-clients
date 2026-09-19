// this file is @generated
package meteroid

type BatchJobFailuresResponse struct {
	Data RequiredSlice[BatchJobItemFailureResponse] `json:"data"`

	TotalCount int64 `json:"total_count"`
}
