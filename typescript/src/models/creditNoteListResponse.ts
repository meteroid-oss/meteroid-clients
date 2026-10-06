// this file is @generated
import { extraProperties } from "../json.js";
import { type CreditNote, CreditNoteSerializer } from "./creditNote.js";
import {
  type PaginationResponse,
  PaginationResponseSerializer,
} from "./paginationResponse.js";

export interface CreditNoteListResponse {
  data: CreditNote[];
  paginationMeta: PaginationResponse;
}

/** Converts `CreditNoteListResponse` values from (`parse`) and to (`serialize`) their JSON form. */
export const CreditNoteListResponseSerializer = {
  parse(json: any): CreditNoteListResponse {
    return {
      ...extraProperties(json, ["data", "pagination_meta"]),
      data: json["data"].map((item: any) => CreditNoteSerializer.parse(item)),
      paginationMeta: PaginationResponseSerializer.parse(json["pagination_meta"]),
    };
  },

  serialize(value: CreditNoteListResponse): any {
    return {
      ...extraProperties(value, ["data", "paginationMeta"]),
      data: value.data.map((item: any) => CreditNoteSerializer.serialize(item)),
      pagination_meta: PaginationResponseSerializer.serialize(value.paginationMeta),
    };
  },
};
