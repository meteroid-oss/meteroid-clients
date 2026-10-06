// this file is @generated
import { extraProperties } from "../json.js";
/**
 * Merge update of a credit note's custom property values (send a key with `null` to remove it).
 * Allowed at any status — custom properties stay editable after the credit note is finalized.
 */
export interface CreditNoteCustomPropertiesRequest {
  customProperties: unknown;
}

/** Converts `CreditNoteCustomPropertiesRequest` values from (`parse`) and to (`serialize`) their JSON form. */
export const CreditNoteCustomPropertiesRequestSerializer = {
  parse(json: any): CreditNoteCustomPropertiesRequest {
    return {
      ...extraProperties(json, ["custom_properties"]),
      customProperties: json["custom_properties"],
    };
  },

  serialize(value: CreditNoteCustomPropertiesRequest): any {
    return {
      ...extraProperties(value, ["customProperties"]),
      custom_properties: value.customProperties,
    };
  },
};
