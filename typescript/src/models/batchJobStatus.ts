// this file is @generated

export const BatchJobStatus = {
  Pending: "PENDING",
  Chunking: "CHUNKING",
  Processing: "PROCESSING",
  Completed: "COMPLETED",
  CompletedWithErrors: "COMPLETED_WITH_ERRORS",
  Failed: "FAILED",
  Cancelled: "CANCELLED",
} as const;
export type BatchJobStatus =
  | (typeof BatchJobStatus)[keyof typeof BatchJobStatus]
  | (string & {});

/** Converts `BatchJobStatus` values from (`parse`) and to (`serialize`) their JSON form. */
export const BatchJobStatusSerializer = {
  parse(json: any): BatchJobStatus {
    return json;
  },

  serialize(value: BatchJobStatus): any {
    return value;
  },
};
