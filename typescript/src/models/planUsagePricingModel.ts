// this file is @generated
import { type MatrixPlanPricing, MatrixPlanPricingSerializer } from "./matrixPlanPricing";
import {
  type PackagePlanPricing,
  PackagePlanPricingSerializer,
} from "./packagePlanPricing";
import {
  type PerUnitPlanPricing,
  PerUnitPlanPricingSerializer,
} from "./perUnitPlanPricing";
import { type TieredPlanPricing, TieredPlanPricingSerializer } from "./tieredPlanPricing";
import { type VolumePlanPricing, VolumePlanPricingSerializer } from "./volumePlanPricing";

export interface PlanUsagePricingModelPerUnit extends PerUnitPlanPricing {
  type: "PER_UNIT";
}
export interface PlanUsagePricingModelTiered extends TieredPlanPricing {
  type: "TIERED";
}
export interface PlanUsagePricingModelVolume extends VolumePlanPricing {
  type: "VOLUME";
}
export interface PlanUsagePricingModelPackage extends PackagePlanPricing {
  type: "PACKAGE";
}
export interface PlanUsagePricingModelMatrix extends MatrixPlanPricing {
  type: "MATRIX";
}

export type PlanUsagePricingModel =
  | PlanUsagePricingModelPerUnit
  | PlanUsagePricingModelTiered
  | PlanUsagePricingModelVolume
  | PlanUsagePricingModelPackage
  | PlanUsagePricingModelMatrix;

export const PlanUsagePricingModelSerializer = {
  _fromJsonObject(object: any): PlanUsagePricingModel {
    const type = object["type"];

    switch (type) {
      case "PER_UNIT":
        return {
          ...PerUnitPlanPricingSerializer._fromJsonObject(object),
          type: "PER_UNIT",
        };
      case "TIERED":
        return {
          ...TieredPlanPricingSerializer._fromJsonObject(object),
          type: "TIERED",
        };
      case "VOLUME":
        return {
          ...VolumePlanPricingSerializer._fromJsonObject(object),
          type: "VOLUME",
        };
      case "PACKAGE":
        return {
          ...PackagePlanPricingSerializer._fromJsonObject(object),
          type: "PACKAGE",
        };
      case "MATRIX":
        return {
          ...MatrixPlanPricingSerializer._fromJsonObject(object),
          type: "MATRIX",
        };
      default:
        throw new Error(`Unexpected type for PlanUsagePricingModel: ${type}`);
    }
  },

  _toJsonObject(self: PlanUsagePricingModel): any {
    switch (self.type) {
      case "PER_UNIT":
        return {
          ...PerUnitPlanPricingSerializer._toJsonObject(self),
          type: "PER_UNIT",
        };
      case "TIERED":
        return {
          ...TieredPlanPricingSerializer._toJsonObject(self),
          type: "TIERED",
        };
      case "VOLUME":
        return {
          ...VolumePlanPricingSerializer._toJsonObject(self),
          type: "VOLUME",
        };
      case "PACKAGE":
        return {
          ...PackagePlanPricingSerializer._toJsonObject(self),
          type: "PACKAGE",
        };
      case "MATRIX":
        return {
          ...MatrixPlanPricingSerializer._toJsonObject(self),
          type: "MATRIX",
        };
      default:
        throw new Error(`Unexpected type for PlanUsagePricingModel`);
    }
  },
};
