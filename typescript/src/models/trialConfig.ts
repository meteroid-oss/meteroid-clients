// this file is @generated
import { extraProperties } from "../json.js";
import { type PlanId, PlanIdSerializer } from "./planId.js";

export interface TrialConfig {
  durationDays: number;
  isFree: boolean;
  trialingPlanId?: PlanId | null | undefined;
}

/** Converts `TrialConfig` values from (`parse`) and to (`serialize`) their JSON form. */
export const TrialConfigSerializer = {
  parse(json: any): TrialConfig {
    return {
      ...extraProperties(json, ["duration_days", "is_free", "trialing_plan_id"]),
      durationDays: json["duration_days"],
      isFree: json["is_free"],
      trialingPlanId:
        json["trialing_plan_id"] != null
          ? PlanIdSerializer.parse(json["trialing_plan_id"])
          : json["trialing_plan_id"],
    };
  },

  serialize(value: TrialConfig): any {
    return {
      ...extraProperties(value, ["durationDays", "isFree", "trialingPlanId"]),
      duration_days: value.durationDays,
      is_free: value.isFree,
      trialing_plan_id:
        value.trialingPlanId != null
          ? PlanIdSerializer.serialize(value.trialingPlanId)
          : value.trialingPlanId,
    };
  },
};
