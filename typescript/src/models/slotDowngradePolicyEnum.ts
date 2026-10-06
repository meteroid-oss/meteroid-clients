// this file is @generated

export const SlotDowngradePolicyEnum = {
  RemoveAtEndOfPeriod: "REMOVE_AT_END_OF_PERIOD",
} as const;
export type SlotDowngradePolicyEnum =
  | (typeof SlotDowngradePolicyEnum)[keyof typeof SlotDowngradePolicyEnum]
  | (string & {});

/** Converts `SlotDowngradePolicyEnum` values from (`parse`) and to (`serialize`) their JSON form. */
export const SlotDowngradePolicyEnumSerializer = {
  parse(json: any): SlotDowngradePolicyEnum {
    return json;
  },

  serialize(value: SlotDowngradePolicyEnum): any {
    return value;
  },
};
