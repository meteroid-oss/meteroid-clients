// this file is @generated

export const ExtraRecurringBillingTypeEnum = {
  Advance: "ADVANCE",
  Arrears: "ARREARS",
} as const;
export type ExtraRecurringBillingTypeEnum =
  | (typeof ExtraRecurringBillingTypeEnum)[keyof typeof ExtraRecurringBillingTypeEnum]
  | (string & {});

/** Converts `ExtraRecurringBillingTypeEnum` values from (`parse`) and to (`serialize`) their JSON form. */
export const ExtraRecurringBillingTypeEnumSerializer = {
  parse(json: any): ExtraRecurringBillingTypeEnum {
    return json;
  },

  serialize(value: ExtraRecurringBillingTypeEnum): any {
    return value;
  },
};
