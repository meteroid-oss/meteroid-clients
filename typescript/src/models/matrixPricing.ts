// this file is @generated
import { type MatrixRow, MatrixRowSerializer } from "./matrixRow";

export interface MatrixPricing {
  rates: MatrixRow[];
}

export const MatrixPricingSerializer = {
  _fromJsonObject(object: any): MatrixPricing {
    return {
      rates: object["rates"].map((item: any) =>
        MatrixRowSerializer._fromJsonObject(item)
      ),
    };
  },

  _toJsonObject(self: MatrixPricing): any {
    return {
      rates: self.rates.map((item: any) => MatrixRowSerializer._toJsonObject(item)),
    };
  },
};
