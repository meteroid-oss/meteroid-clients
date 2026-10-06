// this file is @generated

import {
  type CreateMetricRequest,
  CreateMetricRequestSerializer,
} from "../models/createMetricRequest.js";
import { type Metric, MetricSerializer } from "../models/metric.js";
import {
  type MetricListResponse,
  MetricListResponseSerializer,
} from "../models/metricListResponse.js";
import type { ProductFamilyId } from "../models/productFamilyId.js";
import {
  type UpdateMetricRequest,
  UpdateMetricRequestSerializer,
} from "../models/updateMetricRequest.js";
import type { APIPromise } from "../apiPromise.js";
import {
  MeteroidRequest,
  type MeteroidRequestContext,
  type RequestOptions,
} from "../request.js";

/** The query and header parameters of `list`. */
export interface MetricsListOptions {
  productFamilyId?: ProductFamilyId | undefined;
  /** Search by metric name or code */
  search?: string | undefined;
  /** Sort order. Format: `column.direction`. Allowed columns: `name`, `code`, `created_at`. Direction: `asc` or `desc`. Default: `name.asc`. */
  orderBy?: string | undefined;
  /** Page number (0-indexed) */
  page?: number | undefined;
  /** Number of items per page */
  perPage?: number | undefined;
}

/** The metrics operations, reached through the client's `metrics`. */
export class Metrics {
  /** @internal */
  public constructor(private readonly requestCtx: MeteroidRequestContext) {}

  /** List billable metrics */
  public list(
    options?: MetricsListOptions,
    requestOptions?: RequestOptions
  ): APIPromise<MetricListResponse> {
    const request = new MeteroidRequest("GET", "/api/v1/metrics");

    request.setQueryParam("product_family_id", options?.productFamilyId);
    request.setQueryParam("search", options?.search);
    request.setQueryParam("order_by", options?.orderBy);
    request.setQueryParam("page", options?.page);
    request.setQueryParam("per_page", options?.perPage);
    return request.send(
      this.requestCtx,
      MetricListResponseSerializer.parse,
      requestOptions
    );
  }

  /** Create a billable metric */
  public create(
    createMetricRequest: CreateMetricRequest,
    requestOptions?: RequestOptions
  ): APIPromise<Metric> {
    const request = new MeteroidRequest("POST", "/api/v1/metrics");

    request.setBody(CreateMetricRequestSerializer.serialize(createMetricRequest));
    return request.send(this.requestCtx, MetricSerializer.parse, requestOptions);
  }

  /** Get metric details */
  public retrieve(metricId: string, requestOptions?: RequestOptions): APIPromise<Metric> {
    const request = new MeteroidRequest("GET", "/api/v1/metrics/{metric_id}");

    request.setPathParam("metric_id", metricId);
    return request.send(this.requestCtx, MetricSerializer.parse, requestOptions);
  }

  /**
   * Update a billable metric
   *
   * Partially update metric fields. Code and aggregation_type are immutable.
   */
  public update(
    metricId: string,
    updateMetricRequest: UpdateMetricRequest,
    requestOptions?: RequestOptions
  ): APIPromise<Metric> {
    const request = new MeteroidRequest("PATCH", "/api/v1/metrics/{metric_id}");

    request.setPathParam("metric_id", metricId);
    request.setBody(UpdateMetricRequestSerializer.serialize(updateMetricRequest));
    return request.send(this.requestCtx, MetricSerializer.parse, requestOptions);
  }

  /** Archive a billable metric */
  public archive(metricId: string, requestOptions?: RequestOptions): APIPromise<void> {
    const request = new MeteroidRequest("POST", "/api/v1/metrics/{metric_id}/archive");

    request.setPathParam("metric_id", metricId);
    return request.sendNoResponseBody(this.requestCtx, requestOptions);
  }

  /** Unarchive a billable metric */
  public unarchive(metricId: string, requestOptions?: RequestOptions): APIPromise<void> {
    const request = new MeteroidRequest("POST", "/api/v1/metrics/{metric_id}/unarchive");

    request.setPathParam("metric_id", metricId);
    return request.sendNoResponseBody(this.requestCtx, requestOptions);
  }
}
