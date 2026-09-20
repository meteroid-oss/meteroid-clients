// this file is @generated

export enum PlanStatusEnum {
  Draft = "DRAFT",
  Active = "ACTIVE",
  Inactive = "INACTIVE",
  Archived = "ARCHIVED",
}

export const PlanStatusEnumSerializer = {
  _fromJsonObject(object: any): PlanStatusEnum {
    return object;
  },

  _toJsonObject(self: PlanStatusEnum): any {
    return self;
  },
};
