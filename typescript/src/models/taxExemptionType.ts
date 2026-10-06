// this file is @generated

export const TaxExemptionType = {
  ReverseCharge: "REVERSE_CHARGE",
  TaxExempt: "TAX_EXEMPT",
  NotRegistered: "NOT_REGISTERED",
  Export: "EXPORT",
  NoVatTerritory: "NO_VAT_TERRITORY",
} as const;
export type TaxExemptionType =
  | (typeof TaxExemptionType)[keyof typeof TaxExemptionType]
  | (string & {});

/** Converts `TaxExemptionType` values from (`parse`) and to (`serialize`) their JSON form. */
export const TaxExemptionTypeSerializer = {
  parse(json: any): TaxExemptionType {
    return json;
  },

  serialize(value: TaxExemptionType): any {
    return value;
  },
};
