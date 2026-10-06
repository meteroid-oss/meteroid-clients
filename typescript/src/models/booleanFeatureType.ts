// this file is @generated
import { extraProperties } from "../json.js";

export interface BooleanFeatureType {}

/** Converts `BooleanFeatureType` values from (`parse`) and to (`serialize`) their JSON form. */
export const BooleanFeatureTypeSerializer = {
  parse(json: any): BooleanFeatureType {
    return {
      ...extraProperties(json, []),
    };
  },

  serialize(value: BooleanFeatureType): any {
    return {
      ...extraProperties(value, []),
    };
  },
};
