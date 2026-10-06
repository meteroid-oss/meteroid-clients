// this file is @generated
import { extraProperties } from "../json.js";
import { type BatchJobChunkId, BatchJobChunkIdSerializer } from "./batchJobChunkId.js";

export interface BatchJobItemFailureResponse {
  chunkId: BatchJobChunkId;
  id: string;
  itemIdentifier?: string | null | undefined;
  itemIndex: number;
  reason: string;
}

/** Converts `BatchJobItemFailureResponse` values from (`parse`) and to (`serialize`) their JSON form. */
export const BatchJobItemFailureResponseSerializer = {
  parse(json: any): BatchJobItemFailureResponse {
    return {
      ...extraProperties(json, [
        "chunk_id",
        "id",
        "item_identifier",
        "item_index",
        "reason",
      ]),
      chunkId: BatchJobChunkIdSerializer.parse(json["chunk_id"]),
      id: json["id"],
      itemIdentifier: json["item_identifier"],
      itemIndex: json["item_index"],
      reason: json["reason"],
    };
  },

  serialize(value: BatchJobItemFailureResponse): any {
    return {
      ...extraProperties(value, [
        "chunkId",
        "id",
        "itemIdentifier",
        "itemIndex",
        "reason",
      ]),
      chunk_id: BatchJobChunkIdSerializer.serialize(value.chunkId),
      id: value.id,
      item_identifier: value.itemIdentifier,
      item_index: value.itemIndex,
      reason: value.reason,
    };
  },
};
