// this file is @generated

export enum PlanTypeEnum {
  Standard = "STANDARD",
  Free = "FREE",
  Custom = "CUSTOM",
}

export const PlanTypeEnumSerializer = {
  _fromJsonObject(object: any): PlanTypeEnum {
    return object;
  },

  _toJsonObject(self: PlanTypeEnum): any {
    return self;
  },
};
