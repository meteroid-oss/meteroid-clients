// this file is @generated
import { extraProperties } from "../json.js";

export interface RateFeeStructure {}

/** Converts `RateFeeStructure` values from (`parse`) and to (`serialize`) their JSON form. */
export const RateFeeStructureSerializer = {
  parse(json: any): RateFeeStructure {
    return {
      ...extraProperties(json, []),
    };
  },

  serialize(value: RateFeeStructure): any {
    return {
      ...extraProperties(value, []),
    };
  },
};
