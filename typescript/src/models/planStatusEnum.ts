// this file is @generated

export const PlanStatusEnum = {
  Draft: "DRAFT",
  Active: "ACTIVE",
  Inactive: "INACTIVE",
  Archived: "ARCHIVED",
} as const;
export type PlanStatusEnum =
  | (typeof PlanStatusEnum)[keyof typeof PlanStatusEnum]
  | (string & {});

/** Converts `PlanStatusEnum` values from (`parse`) and to (`serialize`) their JSON form. */
export const PlanStatusEnumSerializer = {
  parse(json: any): PlanStatusEnum {
    return json;
  },

  serialize(value: PlanStatusEnum): any {
    return value;
  },
};
