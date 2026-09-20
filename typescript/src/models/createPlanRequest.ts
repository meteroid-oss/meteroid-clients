// this file is @generated
import { type BillingConfig, BillingConfigSerializer } from "./billingConfig";
import { type PlanAddOnInput, PlanAddOnInputSerializer } from "./planAddOnInput";
import { type PlanStatusEnum, PlanStatusEnumSerializer } from "./planStatusEnum";
import { type PlanTypeEnum, PlanTypeEnumSerializer } from "./planTypeEnum";
import {
  type PriceComponentInput,
  PriceComponentInputSerializer,
} from "./priceComponentInput";
import { type ProductFamilyId, ProductFamilyIdSerializer } from "./productFamilyId";
import { type TrialConfig, TrialConfigSerializer } from "./trialConfig";

export interface CreatePlanRequest {
  addOns?: PlanAddOnInput[];

  billing?: BillingConfig | null;

  components: PriceComponentInput[];

  currency: string;

  description?: string | null;

  name: string;

  planType: PlanTypeEnum;

  productFamilyId: ProductFamilyId;

  selfServiceRank?: number | null;

  status: PlanStatusEnum;

  trial?: TrialConfig | null;
}

export const CreatePlanRequestSerializer = {
  _fromJsonObject(object: any): CreatePlanRequest {
    return {
      addOns:
        object["add_ons"] != null
          ? object["add_ons"].map((item: any) =>
              PlanAddOnInputSerializer._fromJsonObject(item)
            )
          : undefined,
      billing:
        object["billing"] != null
          ? BillingConfigSerializer._fromJsonObject(object["billing"])
          : undefined,
      components: object["components"].map((item: any) =>
        PriceComponentInputSerializer._fromJsonObject(item)
      ),
      currency: object["currency"],
      description: object["description"],
      name: object["name"],
      planType: PlanTypeEnumSerializer._fromJsonObject(object["plan_type"]),
      productFamilyId: ProductFamilyIdSerializer._fromJsonObject(
        object["product_family_id"]
      ),
      selfServiceRank: object["self_service_rank"],
      status: PlanStatusEnumSerializer._fromJsonObject(object["status"]),
      trial:
        object["trial"] != null
          ? TrialConfigSerializer._fromJsonObject(object["trial"])
          : undefined,
    };
  },

  _toJsonObject(self: CreatePlanRequest): any {
    return {
      add_ons:
        self.addOns != null
          ? self.addOns.map((item: any) => PlanAddOnInputSerializer._toJsonObject(item))
          : undefined,
      billing:
        self.billing != null
          ? BillingConfigSerializer._toJsonObject(self.billing)
          : undefined,
      components: self.components.map((item: any) =>
        PriceComponentInputSerializer._toJsonObject(item)
      ),
      currency: self.currency,
      description: self.description,
      name: self.name,
      plan_type: PlanTypeEnumSerializer._toJsonObject(self.planType),
      product_family_id: ProductFamilyIdSerializer._toJsonObject(self.productFamilyId),
      self_service_rank: self.selfServiceRank,
      status: PlanStatusEnumSerializer._toJsonObject(self.status),
      trial:
        self.trial != null ? TrialConfigSerializer._toJsonObject(self.trial) : undefined,
    };
  },
};
