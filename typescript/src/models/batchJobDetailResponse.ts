// this file is @generated
import { parseDateTime } from "../datetime.js";
import { extraProperties } from "../json.js";
import { type BatchJobId, BatchJobIdSerializer } from "./batchJobId.js";
import { type BatchJobStatus, BatchJobStatusSerializer } from "./batchJobStatus.js";
import { type BatchJobType, BatchJobTypeSerializer } from "./batchJobType.js";

export interface BatchJobDetailResponse {
  completedAt?: Date | null | undefined;
  createdAt: Date;
  createdBy: string;
  errorCsvUrl?: string | null | undefined;
  failedItems: number;
  failureCount: number;
  hasErrorCsv: boolean;
  hasOutput: boolean;
  id: BatchJobId;
  inputFileName?: string | null | undefined;
  inputFileUrl?: string | null | undefined;
  jobType: BatchJobType;
  outputUrl?: string | null | undefined;
  processedItems: number;
  status: BatchJobStatus;
  totalItems?: number | null | undefined;
}

/** Converts `BatchJobDetailResponse` values from (`parse`) and to (`serialize`) their JSON form. */
export const BatchJobDetailResponseSerializer = {
  parse(json: any): BatchJobDetailResponse {
    return {
      ...extraProperties(json, [
        "completed_at",
        "created_at",
        "created_by",
        "error_csv_url",
        "failed_items",
        "failure_count",
        "has_error_csv",
        "has_output",
        "id",
        "input_file_name",
        "input_file_url",
        "job_type",
        "output_url",
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
      errorCsvUrl: json["error_csv_url"],
      failedItems: json["failed_items"],
      failureCount: json["failure_count"],
      hasErrorCsv: json["has_error_csv"],
      hasOutput: json["has_output"],
      id: BatchJobIdSerializer.parse(json["id"]),
      inputFileName: json["input_file_name"],
      inputFileUrl: json["input_file_url"],
      jobType: BatchJobTypeSerializer.parse(json["job_type"]),
      outputUrl: json["output_url"],
      processedItems: json["processed_items"],
      status: BatchJobStatusSerializer.parse(json["status"]),
      totalItems: json["total_items"],
    };
  },

  serialize(value: BatchJobDetailResponse): any {
    return {
      ...extraProperties(value, [
        "completedAt",
        "createdAt",
        "createdBy",
        "errorCsvUrl",
        "failedItems",
        "failureCount",
        "hasErrorCsv",
        "hasOutput",
        "id",
        "inputFileName",
        "inputFileUrl",
        "jobType",
        "outputUrl",
        "processedItems",
        "status",
        "totalItems",
      ]),
      completed_at: value.completedAt,
      created_at: value.createdAt,
      created_by: value.createdBy,
      error_csv_url: value.errorCsvUrl,
      failed_items: value.failedItems,
      failure_count: value.failureCount,
      has_error_csv: value.hasErrorCsv,
      has_output: value.hasOutput,
      id: BatchJobIdSerializer.serialize(value.id),
      input_file_name: value.inputFileName,
      input_file_url: value.inputFileUrl,
      job_type: BatchJobTypeSerializer.serialize(value.jobType),
      output_url: value.outputUrl,
      processed_items: value.processedItems,
      status: BatchJobStatusSerializer.serialize(value.status),
      total_items: value.totalItems,
    };
  },
};
