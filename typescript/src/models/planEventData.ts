// this file is @generated
import { parseDateTime } from "../datetime";
import { type PlanId, PlanIdSerializer } from "./planId";
import { type PlanStatusEnum, PlanStatusEnumSerializer } from "./planStatusEnum";
import { type PlanTypeEnum, PlanTypeEnumSerializer } from "./planTypeEnum";

export interface PlanEventData {
  createdAt: Date;

  currency: string;

  description?: string | null;

  name: string;

  planId: PlanId;

  planType: PlanTypeEnum;

  status: PlanStatusEnum;

  version: number;
}

export const PlanEventDataSerializer = {
  _fromJsonObject(object: any): PlanEventData {
    return {
      createdAt: parseDateTime(object["created_at"]),
      currency: object["currency"],
      description: object["description"],
      name: object["name"],
      planId: PlanIdSerializer._fromJsonObject(object["plan_id"]),
      planType: PlanTypeEnumSerializer._fromJsonObject(object["plan_type"]),
      status: PlanStatusEnumSerializer._fromJsonObject(object["status"]),
      version: object["version"],
    };
  },

  _toJsonObject(self: PlanEventData): any {
    return {
      created_at: self.createdAt,
      currency: self.currency,
      description: self.description,
      name: self.name,
      plan_id: PlanIdSerializer._toJsonObject(self.planId),
      plan_type: PlanTypeEnumSerializer._toJsonObject(self.planType),
      status: PlanStatusEnumSerializer._toJsonObject(self.status),
      version: self.version,
    };
  },
};
