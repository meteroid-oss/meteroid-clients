// this file is @generated

export const PlanTypeEnum = {
  Standard: "STANDARD",
  Free: "FREE",
  Custom: "CUSTOM",
} as const;
export type PlanTypeEnum =
  | (typeof PlanTypeEnum)[keyof typeof PlanTypeEnum]
  | (string & {});

/** Converts `PlanTypeEnum` values from (`parse`) and to (`serialize`) their JSON form. */
export const PlanTypeEnumSerializer = {
  parse(json: any): PlanTypeEnum {
    return json;
  },

  serialize(value: PlanTypeEnum): any {
    return value;
  },
};
