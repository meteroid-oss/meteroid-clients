// this file is @generated
import { extraProperties } from "../json.js";
import { type BillingConfig, BillingConfigSerializer } from "./billingConfig.js";
import {
  type MinimumCommitmentInput,
  MinimumCommitmentInputSerializer,
} from "./minimumCommitmentInput.js";
import { type PlanAddOnInput, PlanAddOnInputSerializer } from "./planAddOnInput.js";
import { type PlanStatusEnum, PlanStatusEnumSerializer } from "./planStatusEnum.js";
import {
  type PriceComponentInput,
  PriceComponentInputSerializer,
} from "./priceComponentInput.js";
import { type TrialConfig, TrialConfigSerializer } from "./trialConfig.js";

export interface ReplacePlanRequest {
  addOns?: PlanAddOnInput[] | undefined;
  billing?: BillingConfig | null | undefined;
  components: PriceComponentInput[];
  currency: string;
  description?: string | null | undefined;
  minimumCommitment?: MinimumCommitmentInput | null | undefined;
  name: string;
  status?: PlanStatusEnum | null | undefined;
  trial?: TrialConfig | null | undefined;
}

/** Converts `ReplacePlanRequest` values from (`parse`) and to (`serialize`) their JSON form. */
export const ReplacePlanRequestSerializer = {
  parse(json: any): ReplacePlanRequest {
    return {
      ...extraProperties(json, [
        "add_ons",
        "billing",
        "components",
        "currency",
        "description",
        "minimum_commitment",
        "name",
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
      minimumCommitment:
        json["minimum_commitment"] != null
          ? MinimumCommitmentInputSerializer.parse(json["minimum_commitment"])
          : json["minimum_commitment"],
      name: json["name"],
      status:
        json["status"] != null
          ? PlanStatusEnumSerializer.parse(json["status"])
          : json["status"],
      trial:
        json["trial"] != null
          ? TrialConfigSerializer.parse(json["trial"])
          : json["trial"],
    };
  },

  serialize(value: ReplacePlanRequest): any {
    return {
      ...extraProperties(value, [
        "addOns",
        "billing",
        "components",
        "currency",
        "description",
        "minimumCommitment",
        "name",
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
      minimum_commitment:
        value.minimumCommitment != null
          ? MinimumCommitmentInputSerializer.serialize(value.minimumCommitment)
          : value.minimumCommitment,
      name: value.name,
      status:
        value.status != null
          ? PlanStatusEnumSerializer.serialize(value.status)
          : value.status,
      trial:
        value.trial != null ? TrialConfigSerializer.serialize(value.trial) : value.trial,
    };
  },
};
