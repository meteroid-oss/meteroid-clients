// this file is @generated
package meteroid

type BatchJobItemFailureResponse struct {
	ChunkId BatchJobChunkId `json:"chunk_id"`

	Id string `json:"id"`

	ItemIdentifier *string `json:"item_identifier,omitempty"`

	ItemIndex int32 `json:"item_index"`

	Reason string `json:"reason"`
}
