// this file is @generated
import { type MatrixPricing, MatrixPricingSerializer } from "./matrixPricing.js";
import { type PackagePricing, PackagePricingSerializer } from "./packagePricing.js";
import { type PerUnitPricing, PerUnitPricingSerializer } from "./perUnitPricing.js";
import { type TieredPricing, TieredPricingSerializer } from "./tieredPricing.js";
import { type VolumePricing, VolumePricingSerializer } from "./volumePricing.js";

export interface UsagePricingModelPerUnit extends PerUnitPricing {
  type: "PER_UNIT";
}
export interface UsagePricingModelTiered extends TieredPricing {
  type: "TIERED";
}
export interface UsagePricingModelVolume extends VolumePricing {
  type: "VOLUME";
}
export interface UsagePricingModelPackage extends PackagePricing {
  type: "PACKAGE";
}
export interface UsagePricingModelMatrix extends MatrixPricing {
  type: "MATRIX";
}

export type UsagePricingModel =
  | UsagePricingModelPerUnit
  | UsagePricingModelTiered
  | UsagePricingModelVolume
  | UsagePricingModelPackage
  | UsagePricingModelMatrix;

/** Converts `UsagePricingModel` values from (`parse`) and to (`serialize`) their JSON form. */
export const UsagePricingModelSerializer = {
  parse(json: any): UsagePricingModel {
    switch (json["type"]) {
      case "PER_UNIT":
        return {
          ...PerUnitPricingSerializer.parse(json),
          type: "PER_UNIT",
        };
      case "TIERED":
        return {
          ...TieredPricingSerializer.parse(json),
          type: "TIERED",
        };
      case "VOLUME":
        return {
          ...VolumePricingSerializer.parse(json),
          type: "VOLUME",
        };
      case "PACKAGE":
        return {
          ...PackagePricingSerializer.parse(json),
          type: "PACKAGE",
        };
      case "MATRIX":
        return {
          ...MatrixPricingSerializer.parse(json),
          type: "MATRIX",
        };
      default:
        // A variant added to the API after this SDK was generated, kept as received.
        return json;
    }
  },

  serialize(value: UsagePricingModel): any {
    switch (value.type) {
      case "PER_UNIT":
        return {
          ...PerUnitPricingSerializer.serialize(value),
          type: "PER_UNIT",
        };
      case "TIERED":
        return {
          ...TieredPricingSerializer.serialize(value),
          type: "TIERED",
        };
      case "VOLUME":
        return {
          ...VolumePricingSerializer.serialize(value),
          type: "VOLUME",
        };
      case "PACKAGE":
        return {
          ...PackagePricingSerializer.serialize(value),
          type: "PACKAGE",
        };
      case "MATRIX":
        return {
          ...MatrixPricingSerializer.serialize(value),
          type: "MATRIX",
        };
      default:
        return value;
    }
  },
};
