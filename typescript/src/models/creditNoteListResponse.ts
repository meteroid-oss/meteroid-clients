// this file is @generated
import { type CreditNote, CreditNoteSerializer } from "./creditNote";
import {
  type PaginationResponse,
  PaginationResponseSerializer,
} from "./paginationResponse";

export interface CreditNoteListResponse {
  data: CreditNote[];

  paginationMeta: PaginationResponse;
}

export const CreditNoteListResponseSerializer = {
  _fromJsonObject(object: any): CreditNoteListResponse {
    return {
      data: object["data"].map((item: any) => CreditNoteSerializer._fromJsonObject(item)),
      paginationMeta: PaginationResponseSerializer._fromJsonObject(
        object["pagination_meta"]
      ),
    };
  },

  _toJsonObject(self: CreditNoteListResponse): any {
    return {
      data: self.data.map((item: any) => CreditNoteSerializer._toJsonObject(item)),
      pagination_meta: PaginationResponseSerializer._toJsonObject(self.paginationMeta),
    };
  },
};
