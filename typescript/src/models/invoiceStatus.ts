// this file is @generated

export const InvoiceStatus = {
  Draft: "DRAFT",
  Finalized: "FINALIZED",
  Uncollectible: "UNCOLLECTIBLE",
  Void: "VOID",
  Closed: "CLOSED",
} as const;
export type InvoiceStatus =
  | (typeof InvoiceStatus)[keyof typeof InvoiceStatus]
  | (string & {});

/** Converts `InvoiceStatus` values from (`parse`) and to (`serialize`) their JSON form. */
export const InvoiceStatusSerializer = {
  parse(json: any): InvoiceStatus {
    return json;
  },

  serialize(value: InvoiceStatus): any {
    return value;
  },
};
