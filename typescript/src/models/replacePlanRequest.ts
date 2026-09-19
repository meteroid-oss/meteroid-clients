// this file is @generated
import { type BillingConfig, BillingConfigSerializer } from "./billingConfig";
import {
  type MinimumCommitmentInput,
  MinimumCommitmentInputSerializer,
} from "./minimumCommitmentInput";
import { type PlanAddOnInput, PlanAddOnInputSerializer } from "./planAddOnInput";
import { type PlanStatusEnum, PlanStatusEnumSerializer } from "./planStatusEnum";
import {
  type PriceComponentInput,
  PriceComponentInputSerializer,
} from "./priceComponentInput";
import { type TrialConfig, TrialConfigSerializer } from "./trialConfig";

export interface ReplacePlanRequest {
  addOns?: PlanAddOnInput[];

  billing?: BillingConfig | null;

  components: PriceComponentInput[];

  currency: string;

  description?: string | null;

  minimumCommitment?: MinimumCommitmentInput | null;

  name: string;

  status?: PlanStatusEnum | null;

  trial?: TrialConfig | null;
}

export const ReplacePlanRequestSerializer = {
  _fromJsonObject(object: any): ReplacePlanRequest {
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
      minimumCommitment:
        object["minimum_commitment"] != null
          ? MinimumCommitmentInputSerializer._fromJsonObject(object["minimum_commitment"])
          : undefined,
      name: object["name"],
      status:
        object["status"] != null
          ? PlanStatusEnumSerializer._fromJsonObject(object["status"])
          : undefined,
      trial:
        object["trial"] != null
          ? TrialConfigSerializer._fromJsonObject(object["trial"])
          : undefined,
    };
  },

  _toJsonObject(self: ReplacePlanRequest): any {
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
      minimum_commitment:
        self.minimumCommitment != null
          ? MinimumCommitmentInputSerializer._toJsonObject(self.minimumCommitment)
          : undefined,
      name: self.name,
      status:
        self.status != null
          ? PlanStatusEnumSerializer._toJsonObject(self.status)
          : undefined,
      trial:
        self.trial != null ? TrialConfigSerializer._toJsonObject(self.trial) : undefined,
    };
  },
};
