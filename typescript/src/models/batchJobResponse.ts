// this file is @generated
import { parseDateTime } from "../datetime.js";
import { extraProperties } from "../json.js";
import { type BatchJobId, BatchJobIdSerializer } from "./batchJobId.js";
import { type BatchJobStatus, BatchJobStatusSerializer } from "./batchJobStatus.js";
import { type BatchJobType, BatchJobTypeSerializer } from "./batchJobType.js";

export interface BatchJobResponse {
  completedAt?: Date | null | undefined;
  createdAt: Date;
  createdBy: string;
  failedItems: number;
  id: BatchJobId;
  inputFileName?: string | null | undefined;
  jobType: BatchJobType;
  processedItems: number;
  status: BatchJobStatus;
  totalItems?: number | null | undefined;
}

/** Converts `BatchJobResponse` values from (`parse`) and to (`serialize`) their JSON form. */
export const BatchJobResponseSerializer = {
  parse(json: any): BatchJobResponse {
    return {
      ...extraProperties(json, [
        "completed_at",
        "created_at",
        "created_by",
        "failed_items",
        "id",
        "input_file_name",
        "job_type",
        "processed_items",
        "status",
        "total_items",
      ]),
      completedAt:
        json["completed_at"] != null
          ? parseDateTime(json["completed_at"])
          : json["completed_at"],
      createdAt: parseDateTime(json["created_at"]),
      createdBy: json["created_by"],
      failedItems: json["failed_items"],
      id: BatchJobIdSerializer.parse(json["id"]),
      inputFileName: json["input_file_name"],
      jobType: BatchJobTypeSerializer.parse(json["job_type"]),
      processedItems: json["processed_items"],
      status: BatchJobStatusSerializer.parse(json["status"]),
      totalItems: json["total_items"],
    };
  },

  serialize(value: BatchJobResponse): any {
    return {
      ...extraProperties(value, [
        "completedAt",
        "createdAt",
        "createdBy",
        "failedItems",
        "id",
        "inputFileName",
        "jobType",
        "processedItems",
        "status",
        "totalItems",
      ]),
      completed_at: value.completedAt,
      created_at: value.createdAt,
      created_by: value.createdBy,
      failed_items: value.failedItems,
      id: BatchJobIdSerializer.serialize(value.id),
      input_file_name: value.inputFileName,
      job_type: BatchJobTypeSerializer.serialize(value.jobType),
      processed_items: value.processedItems,
      status: BatchJobStatusSerializer.serialize(value.status),
      total_items: value.totalItems,
    };
  },
};
