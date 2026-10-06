// this file is @generated

export const UsageModelEnum = {
  PerUnit: "PER_UNIT",
  Tiered: "TIERED",
  Volume: "VOLUME",
  Package: "PACKAGE",
  Matrix: "MATRIX",
} as const;
export type UsageModelEnum =
  | (typeof UsageModelEnum)[keyof typeof UsageModelEnum]
  | (string & {});

/** Converts `UsageModelEnum` values from (`parse`) and to (`serialize`) their JSON form. */
export const UsageModelEnumSerializer = {
  parse(json: any): UsageModelEnum {
    return json;
  },

  serialize(value: UsageModelEnum): any {
    return value;
  },
};
