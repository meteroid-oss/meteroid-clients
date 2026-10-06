// this file is @generated
import { extraProperties } from "../json.js";
import { type MatrixDimension, MatrixDimensionSerializer } from "./matrixDimension.js";

export interface MatrixRow {
  dimension1: MatrixDimension;
  dimension2?: MatrixDimension | null | undefined;
  perUnitPrice: string;
}

/** Converts `MatrixRow` values from (`parse`) and to (`serialize`) their JSON form. */
export const MatrixRowSerializer = {
  parse(json: any): MatrixRow {
    return {
      ...extraProperties(json, ["dimension1", "dimension2", "per_unit_price"]),
      dimension1: MatrixDimensionSerializer.parse(json["dimension1"]),
      dimension2:
        json["dimension2"] != null
          ? MatrixDimensionSerializer.parse(json["dimension2"])
          : json["dimension2"],
      perUnitPrice: json["per_unit_price"],
    };
  },

  serialize(value: MatrixRow): any {
    return {
      ...extraProperties(value, ["dimension1", "dimension2", "perUnitPrice"]),
      dimension1: MatrixDimensionSerializer.serialize(value.dimension1),
      dimension2:
        value.dimension2 != null
          ? MatrixDimensionSerializer.serialize(value.dimension2)
          : value.dimension2,
      per_unit_price: value.perUnitPrice,
    };
  },
};
