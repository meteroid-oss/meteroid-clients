// this file is @generated
import { parseDateTime } from "../datetime.js";
import { extraProperties } from "../json.js";
import {
  type AvailableParameters,
  AvailableParametersSerializer,
} from "./availableParameters.js";
import { type Entitlement, EntitlementSerializer } from "./entitlement.js";
import {
  type MinimumCommitment,
  MinimumCommitmentSerializer,
} from "./minimumCommitment.js";
import { type PlanId, PlanIdSerializer } from "./planId.js";
import { type PlanStatusEnum, PlanStatusEnumSerializer } from "./planStatusEnum.js";
import { type PlanTypeEnum, PlanTypeEnumSerializer } from "./planTypeEnum.js";
import { type PlanVersionId, PlanVersionIdSerializer } from "./planVersionId.js";
import { type PriceComponent, PriceComponentSerializer } from "./priceComponent.js";
import { type ProductFamily, ProductFamilySerializer } from "./productFamily.js";
import { type TrialConfig, TrialConfigSerializer } from "./trialConfig.js";

export interface Plan {
  availableParameters: AvailableParameters;
  billingCycles?: number | null | undefined;
  createdAt: Date;
  currency: string;
  description?: string | null | undefined;
  entitlements?: Entitlement[] | undefined;
  id: PlanId;
  minimumCommitment?: MinimumCommitment | null | undefined;
  name: string;
  netTerms: number;
  periodStartDay?: number | null | undefined;
  planType: PlanTypeEnum;
  priceComponents: PriceComponent[];
  productFamily: ProductFamily;
  selfServiceRank?: number | null | undefined;
  status: PlanStatusEnum;
  trial?: TrialConfig | null | undefined;
  version: number;
  versionId: PlanVersionId;
}

/** Converts `Plan` values from (`parse`) and to (`serialize`) their JSON form. */
export const PlanSerializer = {
  parse(json: any): Plan {
    return {
      ...extraProperties(json, [
        "available_parameters",
        "billing_cycles",
        "created_at",
        "currency",
        "description",
        "entitlements",
        "id",
        "minimum_commitment",
        "name",
        "net_terms",
        "period_start_day",
        "plan_type",
        "price_components",
        "product_family",
        "self_service_rank",
        "status",
        "trial",
        "version",
        "version_id",
      ]),
      availableParameters: AvailableParametersSerializer.parse(
        json["available_parameters"]
      ),
      billingCycles: json["billing_cycles"],
      createdAt: parseDateTime(json["created_at"]),
      currency: json["currency"],
      description: json["description"],
      entitlements:
        json["entitlements"] != null
          ? json["entitlements"].map((item: any) => EntitlementSerializer.parse(item))
          : undefined,
      id: PlanIdSerializer.parse(json["id"]),
      minimumCommitment:
        json["minimum_commitment"] != null
          ? MinimumCommitmentSerializer.parse(json["minimum_commitment"])
          : json["minimum_commitment"],
      name: json["name"],
      netTerms: json["net_terms"],
      periodStartDay: json["period_start_day"],
      planType: PlanTypeEnumSerializer.parse(json["plan_type"]),
      priceComponents: json["price_components"].map((item: any) =>
        PriceComponentSerializer.parse(item)
      ),
      productFamily: ProductFamilySerializer.parse(json["product_family"]),
      selfServiceRank: json["self_service_rank"],
      status: PlanStatusEnumSerializer.parse(json["status"]),
      trial:
        json["trial"] != null
          ? TrialConfigSerializer.parse(json["trial"])
          : json["trial"],
      version: json["version"],
      versionId: PlanVersionIdSerializer.parse(json["version_id"]),
    };
  },

  serialize(value: Plan): any {
    return {
      ...extraProperties(value, [
        "availableParameters",
        "billingCycles",
        "createdAt",
        "currency",
        "description",
        "entitlements",
        "id",
        "minimumCommitment",
        "name",
        "netTerms",
        "periodStartDay",
        "planType",
        "priceComponents",
        "productFamily",
        "selfServiceRank",
        "status",
        "trial",
        "version",
        "versionId",
      ]),
      available_parameters: AvailableParametersSerializer.serialize(
        value.availableParameters
      ),
      billing_cycles: value.billingCycles,
      created_at: value.createdAt,
      currency: value.currency,
      description: value.description,
      entitlements:
        value.entitlements != null
          ? value.entitlements.map((item: any) => EntitlementSerializer.serialize(item))
          : undefined,
      id: PlanIdSerializer.serialize(value.id),
      minimum_commitment:
        value.minimumCommitment != null
          ? MinimumCommitmentSerializer.serialize(value.minimumCommitment)
          : value.minimumCommitment,
      name: value.name,
      net_terms: value.netTerms,
      period_start_day: value.periodStartDay,
      plan_type: PlanTypeEnumSerializer.serialize(value.planType),
      price_components: value.priceComponents.map((item: any) =>
        PriceComponentSerializer.serialize(item)
      ),
      product_family: ProductFamilySerializer.serialize(value.productFamily),
      self_service_rank: value.selfServiceRank,
      status: PlanStatusEnumSerializer.serialize(value.status),
      trial:
        value.trial != null ? TrialConfigSerializer.serialize(value.trial) : value.trial,
      version: value.version,
      version_id: PlanVersionIdSerializer.serialize(value.versionId),
    };
  },
};
