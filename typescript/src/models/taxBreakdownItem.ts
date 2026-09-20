// this file is @generated
import { type TaxExemptionType, TaxExemptionTypeSerializer } from "./taxExemptionType";

export interface TaxBreakdownItem {
  /** Free-text legal exemption mention (EU exempt/reverse-charge invoices). */
  exemptionReason?: string | null;

  exemptionType?: TaxExemptionType | null;

  name: string;

  taxAmount: number;

  taxRate: string;

  /** Accounting/reporting code of the tax rate for this line, for exports. */
  taxReference?: string | null;

  taxableAmount: number;
}

export const TaxBreakdownItemSerializer = {
  _fromJsonObject(object: any): TaxBreakdownItem {
    return {
      exemptionReason: object["exemption_reason"],
      exemptionType:
        object["exemption_type"] != null
          ? TaxExemptionTypeSerializer._fromJsonObject(object["exemption_type"])
          : undefined,
      name: object["name"],
      taxAmount: object["tax_amount"],
      taxRate: object["tax_rate"],
      taxReference: object["tax_reference"],
      taxableAmount: object["taxable_amount"],
    };
  },

  _toJsonObject(self: TaxBreakdownItem): any {
    return {
      exemption_reason: self.exemptionReason,
      exemption_type:
        self.exemptionType != null
          ? TaxExemptionTypeSerializer._toJsonObject(self.exemptionType)
          : undefined,
      name: self.name,
      tax_amount: self.taxAmount,
      tax_rate: self.taxRate,
      tax_reference: self.taxReference,
      taxable_amount: self.taxableAmount,
    };
  },
};
