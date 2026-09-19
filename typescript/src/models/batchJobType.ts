// this file is @generated

export enum BatchJobType {
  EventCsvImport = "EVENT_CSV_IMPORT",
  CustomerCsvImport = "CUSTOMER_CSV_IMPORT",
  SubscriptionCsvImport = "SUBSCRIPTION_CSV_IMPORT",
  SubscriptionPlanMigration = "SUBSCRIPTION_PLAN_MIGRATION",
  TaxReportExport = "TAX_REPORT_EXPORT",
}

export const BatchJobTypeSerializer = {
  _fromJsonObject(object: any): BatchJobType {
    return object;
  },

  _toJsonObject(self: BatchJobType): any {
    return self;
  },
};
