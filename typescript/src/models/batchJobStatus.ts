// this file is @generated

export enum BatchJobStatus {
  Pending = "PENDING",
  Chunking = "CHUNKING",
  Processing = "PROCESSING",
  Completed = "COMPLETED",
  CompletedWithErrors = "COMPLETED_WITH_ERRORS",
  Failed = "FAILED",
  Cancelled = "CANCELLED",
}

export const BatchJobStatusSerializer = {
  _fromJsonObject(object: any): BatchJobStatus {
    return object;
  },

  _toJsonObject(self: BatchJobStatus): any {
    return self;
  },
};
