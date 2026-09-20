// this file is @generated
import { type MatrixPricing, MatrixPricingSerializer } from "./matrixPricing";
import { type PackagePricing, PackagePricingSerializer } from "./packagePricing";
import { type PerUnitPricing, PerUnitPricingSerializer } from "./perUnitPricing";
import { type TieredPricing, TieredPricingSerializer } from "./tieredPricing";
import { type VolumePricing, VolumePricingSerializer } from "./volumePricing";

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

export const UsagePricingModelSerializer = {
  _fromJsonObject(object: any): UsagePricingModel {
    const type = object["type"];

    switch (type) {
      case "PER_UNIT":
        return {
          ...PerUnitPricingSerializer._fromJsonObject(object),
          type: "PER_UNIT",
        };
      case "TIERED":
        return {
          ...TieredPricingSerializer._fromJsonObject(object),
          type: "TIERED",
        };
      case "VOLUME":
        return {
          ...VolumePricingSerializer._fromJsonObject(object),
          type: "VOLUME",
        };
      case "PACKAGE":
        return {
          ...PackagePricingSerializer._fromJsonObject(object),
          type: "PACKAGE",
        };
      case "MATRIX":
        return {
          ...MatrixPricingSerializer._fromJsonObject(object),
          type: "MATRIX",
        };
      default:
        throw new Error(`Unexpected type for UsagePricingModel: ${type}`);
    }
  },

  _toJsonObject(self: UsagePricingModel): any {
    switch (self.type) {
      case "PER_UNIT":
        return {
          ...PerUnitPricingSerializer._toJsonObject(self),
          type: "PER_UNIT",
        };
      case "TIERED":
        return {
          ...TieredPricingSerializer._toJsonObject(self),
          type: "TIERED",
        };
      case "VOLUME":
        return {
          ...VolumePricingSerializer._toJsonObject(self),
          type: "VOLUME",
        };
      case "PACKAGE":
        return {
          ...PackagePricingSerializer._toJsonObject(self),
          type: "PACKAGE",
        };
      case "MATRIX":
        return {
          ...MatrixPricingSerializer._toJsonObject(self),
          type: "MATRIX",
        };
      default:
        throw new Error(`Unexpected type for UsagePricingModel`);
    }
  },
};
