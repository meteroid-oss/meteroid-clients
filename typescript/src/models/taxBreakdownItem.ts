// this file is @generated
import { extraProperties } from "../json.js";
import { type TaxExemptionType, TaxExemptionTypeSerializer } from "./taxExemptionType.js";

export interface TaxBreakdownItem {
  /** Free-text legal exemption mention (EU exempt/reverse-charge invoices). */
  exemptionReason?: string | null | undefined;
  exemptionType?: TaxExemptionType | null | undefined;
  name: string;
  taxAmount: number;
  taxRate: string;
  /** Accounting/reporting code of the tax rate for this line, for exports. */
  taxReference?: string | null | undefined;
  taxableAmount: number;
}

/** Converts `TaxBreakdownItem` values from (`parse`) and to (`serialize`) their JSON form. */
export const TaxBreakdownItemSerializer = {
  parse(json: any): TaxBreakdownItem {
    return {
      ...extraProperties(json, [
        "exemption_reason",
        "exemption_type",
        "name",
        "tax_amount",
        "tax_rate",
        "tax_reference",
        "taxable_amount",
      ]),
      exemptionReason: json["exemption_reason"],
      exemptionType:
        json["exemption_type"] != null
          ? TaxExemptionTypeSerializer.parse(json["exemption_type"])
          : json["exemption_type"],
      name: json["name"],
      taxAmount: json["tax_amount"],
      taxRate: json["tax_rate"],
      taxReference: json["tax_reference"],
      taxableAmount: json["taxable_amount"],
    };
  },

  serialize(value: TaxBreakdownItem): any {
    return {
      ...extraProperties(value, [
        "exemptionReason",
        "exemptionType",
        "name",
        "taxAmount",
        "taxRate",
        "taxReference",
        "taxableAmount",
      ]),
      exemption_reason: value.exemptionReason,
      exemption_type:
        value.exemptionType != null
          ? TaxExemptionTypeSerializer.serialize(value.exemptionType)
          : value.exemptionType,
      name: value.name,
      tax_amount: value.taxAmount,
      tax_rate: value.taxRate,
      tax_reference: value.taxReference,
      taxable_amount: value.taxableAmount,
    };
  },
};
