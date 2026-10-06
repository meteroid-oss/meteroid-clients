// this file is @generated
import { extraProperties } from "../json.js";

export interface OneTimeFeeStructure {}

/** Converts `OneTimeFeeStructure` values from (`parse`) and to (`serialize`) their JSON form. */
export const OneTimeFeeStructureSerializer = {
  parse(json: any): OneTimeFeeStructure {
    return {
      ...extraProperties(json, []),
    };
  },

  serialize(value: OneTimeFeeStructure): any {
    return {
      ...extraProperties(value, []),
    };
  },
};
