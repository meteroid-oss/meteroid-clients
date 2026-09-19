// this file is @generated
/**
 * Merge update of an invoice's custom property values (send a key with `null` to remove it).
 * Allowed at any status — custom properties stay editable after the invoice is finalized.
 */
export interface InvoiceCustomPropertiesRequest {
  customProperties: any;
}

export const InvoiceCustomPropertiesRequestSerializer = {
  _fromJsonObject(object: any): InvoiceCustomPropertiesRequest {
    return {
      customProperties: object["custom_properties"],
    };
  },

  _toJsonObject(self: InvoiceCustomPropertiesRequest): any {
    return {
      custom_properties: self.customProperties,
    };
  },
};
