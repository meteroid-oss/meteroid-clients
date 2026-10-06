// this file is @generated

export const BatchJobType = {
  EventCsvImport: "EVENT_CSV_IMPORT",
  CustomerCsvImport: "CUSTOMER_CSV_IMPORT",
  SubscriptionCsvImport: "SUBSCRIPTION_CSV_IMPORT",
  SubscriptionPlanMigration: "SUBSCRIPTION_PLAN_MIGRATION",
  TaxReportExport: "TAX_REPORT_EXPORT",
} as const;
export type BatchJobType =
  | (typeof BatchJobType)[keyof typeof BatchJobType]
  | (string & {});

/** Converts `BatchJobType` values from (`parse`) and to (`serialize`) their JSON form. */
export const BatchJobTypeSerializer = {
  parse(json: any): BatchJobType {
    return json;
  },

  serialize(value: BatchJobType): any {
    return value;
  },
};
