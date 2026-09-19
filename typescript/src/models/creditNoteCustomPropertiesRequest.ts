// this file is @generated
/**
 * Merge update of a credit note's custom property values (send a key with `null` to remove it).
 * Allowed at any status — custom properties stay editable after the credit note is finalized.
 */
export interface CreditNoteCustomPropertiesRequest {
  customProperties: unknown;
}

export const CreditNoteCustomPropertiesRequestSerializer = {
  _fromJsonObject(object: any): CreditNoteCustomPropertiesRequest {
    return {
      customProperties: object["custom_properties"],
    };
  },

  _toJsonObject(self: CreditNoteCustomPropertiesRequest): any {
    return {
      custom_properties: self.customProperties,
    };
  },
};
