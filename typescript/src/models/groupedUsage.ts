// this file is @generated
import { extraProperties } from "../json.js";

export interface GroupedUsage {
  dimensions: { [key: string]: string };
  value: string;
}

/** Converts `GroupedUsage` values from (`parse`) and to (`serialize`) their JSON form. */
export const GroupedUsageSerializer = {
  parse(json: any): GroupedUsage {
    return {
      ...extraProperties(json, ["dimensions", "value"]),
      dimensions: json["dimensions"],
      value: json["value"],
    };
  },

  serialize(value: GroupedUsage): any {
    return {
      ...extraProperties(value, ["dimensions", "value"]),
      dimensions: value.dimensions,
      value: value.value,
    };
  },
};
