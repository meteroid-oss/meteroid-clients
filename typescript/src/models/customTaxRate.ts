// this file is @generated

export interface CustomTaxRate {
  name: string;

  rate: string;

  taxCode: string;
}

export const CustomTaxRateSerializer = {
  _fromJsonObject(object: any): CustomTaxRate {
    return {
      name: object["name"],
      rate: object["rate"],
      taxCode: object["tax_code"],
    };
  },

  _toJsonObject(self: CustomTaxRate): any {
    return {
      name: self.name,
      rate: self.rate,
      tax_code: self.taxCode,
    };
  },
};
