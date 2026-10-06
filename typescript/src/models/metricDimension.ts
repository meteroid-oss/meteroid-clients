// this file is @generated
import { extraProperties } from "../json.js";

export interface MetricDimension {
  key: string;
  values: string[];
}

/** Converts `MetricDimension` values from (`parse`) and to (`serialize`) their JSON form. */
export const MetricDimensionSerializer = {
  parse(json: any): MetricDimension {
    return {
      ...extraProperties(json, ["key", "values"]),
      key: json["key"],
      values: json["values"],
    };
  },

  serialize(value: MetricDimension): any {
    return {
      ...extraProperties(value, ["key", "values"]),
      key: value.key,
      values: value.values,
    };
  },
};
