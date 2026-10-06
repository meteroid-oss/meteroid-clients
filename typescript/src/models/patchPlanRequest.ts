// this file is @generated
import { extraProperties } from "../json.js";

export interface PatchPlanRequest {
  description?: string | null | undefined;
  name?: string | null | undefined;
  selfServiceRank?: number | null | undefined;
}

/** Converts `PatchPlanRequest` values from (`parse`) and to (`serialize`) their JSON form. */
export const PatchPlanRequestSerializer = {
  parse(json: any): PatchPlanRequest {
    return {
      ...extraProperties(json, ["description", "name", "self_service_rank"]),
      description: json["description"],
      name: json["name"],
      selfServiceRank: json["self_service_rank"],
    };
  },

  serialize(value: PatchPlanRequest): any {
    return {
      ...extraProperties(value, ["description", "name", "selfServiceRank"]),
      description: value.description,
      name: value.name,
      self_service_rank: value.selfServiceRank,
    };
  },
};
