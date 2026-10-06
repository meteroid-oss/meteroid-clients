// this file is @generated
import { extraProperties } from "../json.js";

export interface CustomTaxRate {
  name: string;
  rate: string;
  taxCode: string;
}

/** Converts `CustomTaxRate` values from (`parse`) and to (`serialize`) their JSON form. */
export const CustomTaxRateSerializer = {
  parse(json: any): CustomTaxRate {
    return {
      ...extraProperties(json, ["name", "rate", "tax_code"]),
      name: json["name"],
      rate: json["rate"],
      taxCode: json["tax_code"],
    };
  },

  serialize(value: CustomTaxRate): any {
    return {
      ...extraProperties(value, ["name", "rate", "taxCode"]),
      name: value.name,
      rate: value.rate,
      tax_code: value.taxCode,
    };
  },
};
