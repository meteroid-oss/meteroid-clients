// this file is @generated
import {
  type AvailableParameters,
  AvailableParametersSerializer,
} from "./availableParameters";
import { type Entitlement, EntitlementSerializer } from "./entitlement";
import { type MinimumCommitment, MinimumCommitmentSerializer } from "./minimumCommitment";
import { type PlanId, PlanIdSerializer } from "./planId";
import { type PlanStatusEnum, PlanStatusEnumSerializer } from "./planStatusEnum";
import { type PlanTypeEnum, PlanTypeEnumSerializer } from "./planTypeEnum";
import { type PlanVersionId, PlanVersionIdSerializer } from "./planVersionId";
import { type PriceComponent, PriceComponentSerializer } from "./priceComponent";
import { type ProductFamily, ProductFamilySerializer } from "./productFamily";
import { type TrialConfig, TrialConfigSerializer } from "./trialConfig";

export interface Plan {
  availableParameters: AvailableParameters;

  billingCycles?: number | null;

  createdAt: Date;

  currency: string;

  description?: string | null;

  entitlements?: Entitlement[];

  id: PlanId;

  minimumCommitment?: MinimumCommitment | null;

  name: string;

  netTerms: number;

  periodStartDay?: number | null;

  planType: PlanTypeEnum;

  priceComponents: PriceComponent[];

  productFamily: ProductFamily;

  selfServiceRank?: number | null;

  status: PlanStatusEnum;

  trial?: TrialConfig | null;

  version: number;

  versionId: PlanVersionId;
}

export const PlanSerializer = {
  _fromJsonObject(object: any): Plan {
    return {
      availableParameters: AvailableParametersSerializer._fromJsonObject(
        object["available_parameters"]
      ),
      billingCycles: object["billing_cycles"],
      createdAt: new Date(object["created_at"]),
      currency: object["currency"],
      description: object["description"],
      entitlements:
        object["entitlements"] != null
          ? object["entitlements"].map((item: any) =>
              EntitlementSerializer._fromJsonObject(item)
            )
          : undefined,
      id: PlanIdSerializer._fromJsonObject(object["id"]),
      minimumCommitment:
        object["minimum_commitment"] != null
          ? MinimumCommitmentSerializer._fromJsonObject(object["minimum_commitment"])
          : undefined,
      name: object["name"],
      netTerms: object["net_terms"],
      periodStartDay: object["period_start_day"],
      planType: PlanTypeEnumSerializer._fromJsonObject(object["plan_type"]),
      priceComponents: object["price_components"].map((item: any) =>
        PriceComponentSerializer._fromJsonObject(item)
      ),
      productFamily: ProductFamilySerializer._fromJsonObject(object["product_family"]),
      selfServiceRank: object["self_service_rank"],
      status: PlanStatusEnumSerializer._fromJsonObject(object["status"]),
      trial:
        object["trial"] != null
          ? TrialConfigSerializer._fromJsonObject(object["trial"])
          : undefined,
      version: object["version"],
      versionId: PlanVersionIdSerializer._fromJsonObject(object["version_id"]),
    };
  },

  _toJsonObject(self: Plan): any {
    return {
      available_parameters: AvailableParametersSerializer._toJsonObject(
        self.availableParameters
      ),
      billing_cycles: self.billingCycles,
      created_at: self.createdAt,
      currency: self.currency,
      description: self.description,
      entitlements:
        self.entitlements != null
          ? self.entitlements.map((item: any) =>
              EntitlementSerializer._toJsonObject(item)
            )
          : undefined,
      id: PlanIdSerializer._toJsonObject(self.id),
      minimum_commitment:
        self.minimumCommitment != null
          ? MinimumCommitmentSerializer._toJsonObject(self.minimumCommitment)
          : undefined,
      name: self.name,
      net_terms: self.netTerms,
      period_start_day: self.periodStartDay,
      plan_type: PlanTypeEnumSerializer._toJsonObject(self.planType),
      price_components: self.priceComponents.map((item: any) =>
        PriceComponentSerializer._toJsonObject(item)
      ),
      product_family: ProductFamilySerializer._toJsonObject(self.productFamily),
      self_service_rank: self.selfServiceRank,
      status: PlanStatusEnumSerializer._toJsonObject(self.status),
      trial:
        self.trial != null ? TrialConfigSerializer._toJsonObject(self.trial) : undefined,
      version: self.version,
      version_id: PlanVersionIdSerializer._toJsonObject(self.versionId),
    };
  },
};
