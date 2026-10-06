// this file is @generated
import {
  type MatrixPlanPricing,
  MatrixPlanPricingSerializer,
} from "./matrixPlanPricing.js";
import {
  type PackagePlanPricing,
  PackagePlanPricingSerializer,
} from "./packagePlanPricing.js";
import {
  type PerUnitPlanPricing,
  PerUnitPlanPricingSerializer,
} from "./perUnitPlanPricing.js";
import {
  type TieredPlanPricing,
  TieredPlanPricingSerializer,
} from "./tieredPlanPricing.js";
import {
  type VolumePlanPricing,
  VolumePlanPricingSerializer,
} from "./volumePlanPricing.js";

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

/** Converts `PlanUsagePricingModel` values from (`parse`) and to (`serialize`) their JSON form. */
export const PlanUsagePricingModelSerializer = {
  parse(json: any): PlanUsagePricingModel {
    switch (json["type"]) {
      case "PER_UNIT":
        return {
          ...PerUnitPlanPricingSerializer.parse(json),
          type: "PER_UNIT",
        };
      case "TIERED":
        return {
          ...TieredPlanPricingSerializer.parse(json),
          type: "TIERED",
        };
      case "VOLUME":
        return {
          ...VolumePlanPricingSerializer.parse(json),
          type: "VOLUME",
        };
      case "PACKAGE":
        return {
          ...PackagePlanPricingSerializer.parse(json),
          type: "PACKAGE",
        };
      case "MATRIX":
        return {
          ...MatrixPlanPricingSerializer.parse(json),
          type: "MATRIX",
        };
      default:
        // A variant added to the API after this SDK was generated, kept as received.
        return json;
    }
  },

  serialize(value: PlanUsagePricingModel): any {
    switch (value.type) {
      case "PER_UNIT":
        return {
          ...PerUnitPlanPricingSerializer.serialize(value),
          type: "PER_UNIT",
        };
      case "TIERED":
        return {
          ...TieredPlanPricingSerializer.serialize(value),
          type: "TIERED",
        };
      case "VOLUME":
        return {
          ...VolumePlanPricingSerializer.serialize(value),
          type: "VOLUME",
        };
      case "PACKAGE":
        return {
          ...PackagePlanPricingSerializer.serialize(value),
          type: "PACKAGE",
        };
      case "MATRIX":
        return {
          ...MatrixPlanPricingSerializer.serialize(value),
          type: "MATRIX",
        };
      default:
        return value;
    }
  },
};
