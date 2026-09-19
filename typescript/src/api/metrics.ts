// this file is @generated
import {
  type CreateMetricRequest,
  CreateMetricRequestSerializer,
} from "../models/createMetricRequest";
import { type Metric, MetricSerializer } from "../models/metric";
import {
  type MetricListResponse,
  MetricListResponseSerializer,
} from "../models/metricListResponse";
import type { ProductFamilyId } from "../models/productFamilyId";
import {
  type UpdateMetricRequest,
  UpdateMetricRequestSerializer,
} from "../models/updateMetricRequest";
import { HttpMethod, MeteroidRequest, type MeteroidRequestContext } from "../request";

export interface MetricsListMetricsOptions {
  productFamilyId?: ProductFamilyId;
  /** Search by metric name or code */
  search?: string;
  /** Sort order. Format: `column.direction`. Allowed columns: `name`, `code`, `created_at`. Direction: `asc` or `desc`. Default: `name.asc`. */
  orderBy?: string;
  /** Page number (0-indexed) */
  page?: number;
  /** Number of items per page */
  perPage?: number;
}

export class Metrics {
  public constructor(private readonly requestCtx: MeteroidRequestContext) {}

  /**  */
  public listMetrics(options?: MetricsListMetricsOptions): Promise<MetricListResponse> {
    const request = new MeteroidRequest(HttpMethod.GET, "/api/v1/metrics");

    request.setQueryParam("product_family_id", options?.productFamilyId);
    request.setQueryParam("search", options?.search);
    request.setQueryParam("order_by", options?.orderBy);
    request.setQueryParam("page", options?.page);
    request.setQueryParam("per_page", options?.perPage);
    return request.send(this.requestCtx, MetricListResponseSerializer._fromJsonObject);
  }

  /**  */
  public createMetric(createMetricRequest: CreateMetricRequest): Promise<Metric> {
    const request = new MeteroidRequest(HttpMethod.POST, "/api/v1/metrics");

    request.setBody(CreateMetricRequestSerializer._toJsonObject(createMetricRequest));
    return request.send(this.requestCtx, MetricSerializer._fromJsonObject);
  }

  /**  */
  public getMetric(metricId: string): Promise<Metric> {
    const request = new MeteroidRequest(HttpMethod.GET, "/api/v1/metrics/{metric_id}");

    request.setPathParam("metric_id", metricId);
    return request.send(this.requestCtx, MetricSerializer._fromJsonObject);
  }

  /** Partially update metric fields. Code and aggregation_type are immutable. */
  public updateMetric(
    metricId: string,
    updateMetricRequest: UpdateMetricRequest
  ): Promise<Metric> {
    const request = new MeteroidRequest(HttpMethod.PATCH, "/api/v1/metrics/{metric_id}");

    request.setPathParam("metric_id", metricId);
    request.setBody(UpdateMetricRequestSerializer._toJsonObject(updateMetricRequest));
    return request.send(this.requestCtx, MetricSerializer._fromJsonObject);
  }

  /**  */
  public archiveMetric(metricId: string): Promise<void> {
    const request = new MeteroidRequest(
      HttpMethod.POST,
      "/api/v1/metrics/{metric_id}/archive"
    );

    request.setPathParam("metric_id", metricId);
    return request.sendNoResponseBody(this.requestCtx);
  }

  /**  */
  public unarchiveMetric(metricId: string): Promise<void> {
    const request = new MeteroidRequest(
      HttpMethod.POST,
      "/api/v1/metrics/{metric_id}/unarchive"
    );

    request.setPathParam("metric_id", metricId);
    return request.sendNoResponseBody(this.requestCtx);
  }
}
