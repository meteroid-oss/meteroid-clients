// this file is @generated
import { type MatrixRow, MatrixRowSerializer } from "./matrixRow";

export interface MatrixPlanPricing {
  rates: MatrixRow[];
}

export const MatrixPlanPricingSerializer = {
  _fromJsonObject(object: any): MatrixPlanPricing {
    return {
      rates: object["rates"].map((item: any) =>
        MatrixRowSerializer._fromJsonObject(item)
      ),
    };
  },

  _toJsonObject(self: MatrixPlanPricing): any {
    return {
      rates: self.rates.map((item: any) => MatrixRowSerializer._toJsonObject(item)),
    };
  },
};
