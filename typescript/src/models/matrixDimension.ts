// this file is @generated
import { extraProperties } from "../json.js";

export interface MatrixDimension {
  key: string;
  value: string;
}

/** Converts `MatrixDimension` values from (`parse`) and to (`serialize`) their JSON form. */
export const MatrixDimensionSerializer = {
  parse(json: any): MatrixDimension {
    return {
      ...extraProperties(json, ["key", "value"]),
      key: json["key"],
      value: json["value"],
    };
  },

  serialize(value: MatrixDimension): any {
    return {
      ...extraProperties(value, ["key", "value"]),
      key: value.key,
      value: value.value,
    };
  },
};
