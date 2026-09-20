// this file is @generated

export enum CreditNoteStatus {
  Draft = "DRAFT",
  Finalized = "FINALIZED",
  Voided = "VOIDED",
}

export const CreditNoteStatusSerializer = {
  _fromJsonObject(object: any): CreditNoteStatus {
    return object;
  },

  _toJsonObject(self: CreditNoteStatus): any {
    return self;
  },
};
