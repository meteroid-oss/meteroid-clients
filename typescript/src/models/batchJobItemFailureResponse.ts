// this file is @generated
import { type BatchJobChunkId, BatchJobChunkIdSerializer } from "./batchJobChunkId";

export interface BatchJobItemFailureResponse {
  chunkId: BatchJobChunkId;

  id: string;

  itemIdentifier?: string | null;

  itemIndex: number;

  reason: string;
}

export const BatchJobItemFailureResponseSerializer = {
  _fromJsonObject(object: any): BatchJobItemFailureResponse {
    return {
      chunkId: BatchJobChunkIdSerializer._fromJsonObject(object["chunk_id"]),
      id: object["id"],
      itemIdentifier: object["item_identifier"],
      itemIndex: object["item_index"],
      reason: object["reason"],
    };
  },

  _toJsonObject(self: BatchJobItemFailureResponse): any {
    return {
      chunk_id: BatchJobChunkIdSerializer._toJsonObject(self.chunkId),
      id: self.id,
      item_identifier: self.itemIdentifier,
      item_index: self.itemIndex,
      reason: self.reason,
    };
  },
};
