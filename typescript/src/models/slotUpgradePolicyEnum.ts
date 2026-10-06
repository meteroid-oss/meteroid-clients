// this file is @generated

export const SlotUpgradePolicyEnum = {
  Prorated: "PRORATED",
} as const;
export type SlotUpgradePolicyEnum =
  | (typeof SlotUpgradePolicyEnum)[keyof typeof SlotUpgradePolicyEnum]
  | (string & {});

/** Converts `SlotUpgradePolicyEnum` values from (`parse`) and to (`serialize`) their JSON form. */
export const SlotUpgradePolicyEnumSerializer = {
  parse(json: any): SlotUpgradePolicyEnum {
    return json;
  },

  serialize(value: SlotUpgradePolicyEnum): any {
    return value;
  },
};
