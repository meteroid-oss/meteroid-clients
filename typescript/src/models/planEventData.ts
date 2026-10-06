// this file is @generated
import { parseDateTime } from "../datetime.js";
import { extraProperties } from "../json.js";
import { type PlanId, PlanIdSerializer } from "./planId.js";
import { type PlanStatusEnum, PlanStatusEnumSerializer } from "./planStatusEnum.js";
import { type PlanTypeEnum, PlanTypeEnumSerializer } from "./planTypeEnum.js";

export interface PlanEventData {
  createdAt: Date;
  currency: string;
  description?: string | null | undefined;
  name: string;
  planId: PlanId;
  planType: PlanTypeEnum;
  status: PlanStatusEnum;
  version: number;
}

/** Converts `PlanEventData` values from (`parse`) and to (`serialize`) their JSON form. */
export const PlanEventDataSerializer = {
  parse(json: any): PlanEventData {
    return {
      ...extraProperties(json, [
        "created_at",
        "currency",
        "description",
        "name",
        "plan_id",
        "plan_type",
        "status",
        "version",
      ]),
      createdAt: parseDateTime(json["created_at"]),
      currency: json["currency"],
      description: json["description"],
      name: json["name"],
      planId: PlanIdSerializer.parse(json["plan_id"]),
      planType: PlanTypeEnumSerializer.parse(json["plan_type"]),
      status: PlanStatusEnumSerializer.parse(json["status"]),
      version: json["version"],
    };
  },

  serialize(value: PlanEventData): any {
    return {
      ...extraProperties(value, [
        "createdAt",
        "currency",
        "description",
        "name",
        "planId",
        "planType",
        "status",
        "version",
      ]),
      created_at: value.createdAt,
      currency: value.currency,
      description: value.description,
      name: value.name,
      plan_id: PlanIdSerializer.serialize(value.planId),
      plan_type: PlanTypeEnumSerializer.serialize(value.planType),
      status: PlanStatusEnumSerializer.serialize(value.status),
      version: value.version,
    };
  },
};
