// this file is @generated
import { extraProperties } from "../json.js";
import { type MatrixRow, MatrixRowSerializer } from "./matrixRow.js";

export interface MatrixPricing {
  rates: MatrixRow[];
}

/** Converts `MatrixPricing` values from (`parse`) and to (`serialize`) their JSON form. */
export const MatrixPricingSerializer = {
  parse(json: any): MatrixPricing {
    return {
      ...extraProperties(json, ["rates"]),
      rates: json["rates"].map((item: any) => MatrixRowSerializer.parse(item)),
    };
  },

  serialize(value: MatrixPricing): any {
    return {
      ...extraProperties(value, ["rates"]),
      rates: value.rates.map((item: any) => MatrixRowSerializer.serialize(item)),
    };
  },
};
