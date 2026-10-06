// this file is @generated
import { extraProperties } from "../json.js";
import { type BillingConfig, BillingConfigSerializer } from "./billingConfig.js";
import { type PlanAddOnInput, PlanAddOnInputSerializer } from "./planAddOnInput.js";
import { type PlanStatusEnum, PlanStatusEnumSerializer } from "./planStatusEnum.js";
import { type PlanTypeEnum, PlanTypeEnumSerializer } from "./planTypeEnum.js";
import {
  type PriceComponentInput,
  PriceComponentInputSerializer,
} from "./priceComponentInput.js";
import { type ProductFamilyId, ProductFamilyIdSerializer } from "./productFamilyId.js";
import { type TrialConfig, TrialConfigSerializer } from "./trialConfig.js";

export interface CreatePlanRequest {
  addOns?: PlanAddOnInput[] | undefined;
  billing?: BillingConfig | null | undefined;
  components: PriceComponentInput[];
  currency: string;
  description?: string | null | undefined;
  name: string;
  planType: PlanTypeEnum;
  productFamilyId: ProductFamilyId;
  selfServiceRank?: number | null | undefined;
  status: PlanStatusEnum;
  trial?: TrialConfig | null | undefined;
}

/** Converts `CreatePlanRequest` values from (`parse`) and to (`serialize`) their JSON form. */
export const CreatePlanRequestSerializer = {
  parse(json: any): CreatePlanRequest {
    return {
      ...extraProperties(json, [
        "add_ons",
        "billing",
        "components",
        "currency",
        "description",
        "name",
        "plan_type",
        "product_family_id",
        "self_service_rank",
        "status",
        "trial",
      ]),
      addOns:
        json["add_ons"] != null
          ? json["add_ons"].map((item: any) => PlanAddOnInputSerializer.parse(item))
          : undefined,
      billing:
        json["billing"] != null
          ? BillingConfigSerializer.parse(json["billing"])
          : json["billing"],
      components: json["components"].map((item: any) =>
        PriceComponentInputSerializer.parse(item)
      ),
      currency: json["currency"],
      description: json["description"],
      name: json["name"],
      planType: PlanTypeEnumSerializer.parse(json["plan_type"]),
      productFamilyId: ProductFamilyIdSerializer.parse(json["product_family_id"]),
      selfServiceRank: json["self_service_rank"],
      status: PlanStatusEnumSerializer.parse(json["status"]),
      trial:
        json["trial"] != null
          ? TrialConfigSerializer.parse(json["trial"])
          : json["trial"],
    };
  },

  serialize(value: CreatePlanRequest): any {
    return {
      ...extraProperties(value, [
        "addOns",
        "billing",
        "components",
        "currency",
        "description",
        "name",
        "planType",
        "productFamilyId",
        "selfServiceRank",
        "status",
        "trial",
      ]),
      add_ons:
        value.addOns != null
          ? value.addOns.map((item: any) => PlanAddOnInputSerializer.serialize(item))
          : undefined,
      billing:
        value.billing != null
          ? BillingConfigSerializer.serialize(value.billing)
          : value.billing,
      components: value.components.map((item: any) =>
        PriceComponentInputSerializer.serialize(item)
      ),
      currency: value.currency,
      description: value.description,
      name: value.name,
      plan_type: PlanTypeEnumSerializer.serialize(value.planType),
      product_family_id: ProductFamilyIdSerializer.serialize(value.productFamilyId),
      self_service_rank: value.selfServiceRank,
      status: PlanStatusEnumSerializer.serialize(value.status),
      trial:
        value.trial != null ? TrialConfigSerializer.serialize(value.trial) : value.trial,
    };
  },
};
