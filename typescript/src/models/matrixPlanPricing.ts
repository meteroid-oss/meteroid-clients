// this file is @generated
import { extraProperties } from "../json.js";
import { type MatrixRow, MatrixRowSerializer } from "./matrixRow.js";

export interface MatrixPlanPricing {
  rates: MatrixRow[];
}

/** Converts `MatrixPlanPricing` values from (`parse`) and to (`serialize`) their JSON form. */
export const MatrixPlanPricingSerializer = {
  parse(json: any): MatrixPlanPricing {
    return {
      ...extraProperties(json, ["rates"]),
      rates: json["rates"].map((item: any) => MatrixRowSerializer.parse(item)),
    };
  },

  serialize(value: MatrixPlanPricing): any {
    return {
      ...extraProperties(value, ["rates"]),
      rates: value.rates.map((item: any) => MatrixRowSerializer.serialize(item)),
    };
  },
};
