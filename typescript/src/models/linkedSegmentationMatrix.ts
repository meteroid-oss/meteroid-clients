// this file is @generated
import { extraProperties } from "../json.js";

export interface LinkedSegmentationMatrix {
  dimension1Key: string;
  dimension2Key: string;
  values: { [key: string]: string[] };
}

/** Converts `LinkedSegmentationMatrix` values from (`parse`) and to (`serialize`) their JSON form. */
export const LinkedSegmentationMatrixSerializer = {
  parse(json: any): LinkedSegmentationMatrix {
    return {
      ...extraProperties(json, ["dimension1_key", "dimension2_key", "values"]),
      dimension1Key: json["dimension1_key"],
      dimension2Key: json["dimension2_key"],
      values: json["values"],
    };
  },

  serialize(value: LinkedSegmentationMatrix): any {
    return {
      ...extraProperties(value, ["dimension1Key", "dimension2Key", "values"]),
      dimension1_key: value.dimension1Key,
      dimension2_key: value.dimension2Key,
      values: value.values,
    };
  },
};
