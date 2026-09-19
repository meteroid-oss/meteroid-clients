// this file is @generated
import { type BatchJobId, BatchJobIdSerializer } from "./batchJobId";
import { type BatchJobStatus, BatchJobStatusSerializer } from "./batchJobStatus";
import { type BatchJobType, BatchJobTypeSerializer } from "./batchJobType";

export interface BatchJobResponse {
  completedAt?: Date | null;

  createdAt: Date;

  createdBy: string;

  failedItems: number;

  id: BatchJobId;

  inputFileName?: string | null;

  jobType: BatchJobType;

  processedItems: number;

  status: BatchJobStatus;

  totalItems?: number | null;
}

export const BatchJobResponseSerializer = {
  _fromJsonObject(object: any): BatchJobResponse {
    return {
      completedAt:
        object["completed_at"] != null ? new Date(object["completed_at"]) : undefined,
      createdAt: new Date(object["created_at"]),
      createdBy: object["created_by"],
      failedItems: object["failed_items"],
      id: BatchJobIdSerializer._fromJsonObject(object["id"]),
      inputFileName: object["input_file_name"],
      jobType: BatchJobTypeSerializer._fromJsonObject(object["job_type"]),
      processedItems: object["processed_items"],
      status: BatchJobStatusSerializer._fromJsonObject(object["status"]),
      totalItems: object["total_items"],
    };
  },

  _toJsonObject(self: BatchJobResponse): any {
    return {
      completed_at: self.completedAt,
      created_at: self.createdAt,
      created_by: self.createdBy,
      failed_items: self.failedItems,
      id: BatchJobIdSerializer._toJsonObject(self.id),
      input_file_name: self.inputFileName,
      job_type: BatchJobTypeSerializer._toJsonObject(self.jobType),
      processed_items: self.processedItems,
      status: BatchJobStatusSerializer._toJsonObject(self.status),
      total_items: self.totalItems,
    };
  },
};
