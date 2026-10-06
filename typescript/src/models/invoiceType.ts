// this file is @generated

export const InvoiceType = {
  Recurring: "RECURRING",
  OneOff: "ONE_OFF",
  Adjustment: "ADJUSTMENT",
  UsageThreshold: "USAGE_THRESHOLD",
} as const;
export type InvoiceType = (typeof InvoiceType)[keyof typeof InvoiceType] | (string & {});

/** Converts `InvoiceType` values from (`parse`) and to (`serialize`) their JSON form. */
export const InvoiceTypeSerializer = {
  parse(json: any): InvoiceType {
    return json;
  },

  serialize(value: InvoiceType): any {
    return value;
  },
};
