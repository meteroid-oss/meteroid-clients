// this file is @generated

import {
  type CreatePlanRequest,
  CreatePlanRequestSerializer,
} from "../models/createPlanRequest.js";
import {
  type MinimumCommitment,
  MinimumCommitmentSerializer,
} from "../models/minimumCommitment.js";
import {
  type PatchPlanRequest,
  PatchPlanRequestSerializer,
} from "../models/patchPlanRequest.js";
import { type Plan, PlanSerializer } from "../models/plan.js";
import {
  type PlanListResponse,
  PlanListResponseSerializer,
} from "../models/planListResponse.js";
import type { PlanStatusEnum } from "../models/planStatusEnum.js";
import type { PlanTypeEnum } from "../models/planTypeEnum.js";
import {
  type PlanVersionListResponse,
  PlanVersionListResponseSerializer,
} from "../models/planVersionListResponse.js";
import type { ProductFamilyId } from "../models/productFamilyId.js";
import {
  type ReplacePlanRequest,
  ReplacePlanRequestSerializer,
} from "../models/replacePlanRequest.js";
import {
  type ResolvedEntitlementListResponse,
  ResolvedEntitlementListResponseSerializer,
} from "../models/resolvedEntitlementListResponse.js";
import type { APIPromise } from "../apiPromise.js";
import {
  MeteroidRequest,
  type MeteroidRequestContext,
  type RequestOptions,
} from "../request.js";

/** The query and header parameters of `list`. */
export interface PlansListOptions {
  productFamilyId?: ProductFamilyId | undefined;
  /** Search by plan name */
  search?: string | undefined;
  /** Filter by plan status (can be repeated) */
  status?: PlanStatusEnum[] | undefined;
  /** Filter by plan type (can be repeated) */
  planType?: PlanTypeEnum[] | undefined;
  /** Sort order. Format: `column.direction`. Allowed columns: `name`, `status`, `plan_type`, `created_at`. Direction: `asc` or `desc`. Default: `created_at.desc`. */
  orderBy?: string | undefined;
  /** Page number (0-indexed) */
  page?: number | undefined;
  /** Number of items per page */
  perPage?: number | undefined;
}

/** The query and header parameters of `retrieve`. */
export interface PlansRetrieveOptions {
  /** Filter by version: "draft", a version number, or omitted for active */
  version?: string | undefined;
}

/** The query and header parameters of `listVersions`. */
export interface PlansListVersionsOptions {
  /** Page number (0-indexed) */
  page?: number | undefined;
  /** Number of items per page */
  perPage?: number | undefined;
}

/** The plans operations, reached through the client's `plans`. */
export class Plans {
  /** @internal */
  public constructor(private readonly requestCtx: MeteroidRequestContext) {}

  /** List plan version entitlements */
  public listPlanVersionEntitlements(
    planVersionId: string,
    requestOptions?: RequestOptions
  ): APIPromise<ResolvedEntitlementListResponse> {
    const request = new MeteroidRequest(
      "GET",
      "/api/v1/plan-versions/{plan_version_id}/entitlements"
    );

    request.setPathParam("plan_version_id", planVersionId);
    return request.send(
      this.requestCtx,
      ResolvedEntitlementListResponseSerializer.parse,
      requestOptions
    );
  }

  /** List plans */
  public list(
    options?: PlansListOptions,
    requestOptions?: RequestOptions
  ): APIPromise<PlanListResponse> {
    const request = new MeteroidRequest("GET", "/api/v1/plans");

    request.setQueryParam("product_family_id", options?.productFamilyId);
    request.setQueryParam("search", options?.search);
    request.setExplodedQueryParam("status", options?.status);
    request.setExplodedQueryParam("plan_type", options?.planType);
    request.setQueryParam("order_by", options?.orderBy);
    request.setQueryParam("page", options?.page);
    request.setQueryParam("per_page", options?.perPage);
    return request.send(
      this.requestCtx,
      PlanListResponseSerializer.parse,
      requestOptions
    );
  }

  /**
   * Create a plan
   *
   * Create a new plan with components and pricing. Set `status` to `ACTIVE` to
   * publish immediately, or `DRAFT` to stage for review.
   */
  public create(
    createPlanRequest: CreatePlanRequest,
    requestOptions?: RequestOptions
  ): APIPromise<Plan> {
    const request = new MeteroidRequest("POST", "/api/v1/plans");

    request.setBody(CreatePlanRequestSerializer.serialize(createPlanRequest));
    return request.send(this.requestCtx, PlanSerializer.parse, requestOptions);
  }

  /** Set or replace the plan-level minimum commitment for a draft plan version. */
  public updateVersionMinimum(
    planVersionId: string,
    minimumCommitment: MinimumCommitment,
    requestOptions?: RequestOptions
  ): APIPromise<MinimumCommitment> {
    const request = new MeteroidRequest(
      "PUT",
      "/api/v1/plans/versions/{plan_version_id}/minimum"
    );

    request.setPathParam("plan_version_id", planVersionId);
    request.setBody(MinimumCommitmentSerializer.serialize(minimumCommitment));
    return request.send(
      this.requestCtx,
      MinimumCommitmentSerializer.parse,
      requestOptions
    );
  }

  /** Remove the plan-level minimum commitment for a draft plan version. */
  public deleteVersionMinimum(
    planVersionId: string,
    requestOptions?: RequestOptions
  ): APIPromise<void> {
    const request = new MeteroidRequest(
      "DELETE",
      "/api/v1/plans/versions/{plan_version_id}/minimum"
    );

    request.setPathParam("plan_version_id", planVersionId);
    return request.sendNoResponseBody(this.requestCtx, requestOptions);
  }

  /**
   * Get plan details
   *
   * Retrieve a specific plan. Use `?version=draft` for the draft version,
   * `?version=2` for a specific version number, or omit for the active version.
   */
  public retrieve(
    planId: string,
    options?: PlansRetrieveOptions,
    requestOptions?: RequestOptions
  ): APIPromise<Plan> {
    const request = new MeteroidRequest("GET", "/api/v1/plans/{plan_id}");

    request.setPathParam("plan_id", planId);
    request.setQueryParam("version", options?.version);
    return request.send(this.requestCtx, PlanSerializer.parse, requestOptions);
  }

  /**
   * Replace a plan
   *
   * Full replacement of a plan's version. On a draft plan, updates in-place.
   * On a published plan, creates a new version. Set `status` to `DRAFT` to
   * stage as a new draft without publishing.
   */
  public replace(
    planId: string,
    replacePlanRequest: ReplacePlanRequest,
    requestOptions?: RequestOptions
  ): APIPromise<Plan> {
    const request = new MeteroidRequest("PUT", "/api/v1/plans/{plan_id}");

    request.setPathParam("plan_id", planId);
    request.setBody(ReplacePlanRequestSerializer.serialize(replacePlanRequest));
    return request.send(this.requestCtx, PlanSerializer.parse, requestOptions);
  }

  /**
   * Update plan metadata
   *
   * Partially update plan-level fields (name, description, self_service_rank).
   * Does not modify version-level configuration or components.
   */
  public update(
    planId: string,
    patchPlanRequest: PatchPlanRequest,
    requestOptions?: RequestOptions
  ): APIPromise<Plan> {
    const request = new MeteroidRequest("PATCH", "/api/v1/plans/{plan_id}");

    request.setPathParam("plan_id", planId);
    request.setBody(PatchPlanRequestSerializer.serialize(patchPlanRequest));
    return request.send(this.requestCtx, PlanSerializer.parse, requestOptions);
  }

  /** Archive a plan */
  public archive(planId: string, requestOptions?: RequestOptions): APIPromise<void> {
    const request = new MeteroidRequest("POST", "/api/v1/plans/{plan_id}/archive");

    request.setPathParam("plan_id", planId);
    return request.sendNoResponseBody(this.requestCtx, requestOptions);
  }

  /**
   * Publish a draft plan version
   *
   * Publishes the current draft version, making it the active version.
   */
  public publish(planId: string, requestOptions?: RequestOptions): APIPromise<Plan> {
    const request = new MeteroidRequest("POST", "/api/v1/plans/{plan_id}/publish");

    request.setPathParam("plan_id", planId);
    return request.send(this.requestCtx, PlanSerializer.parse, requestOptions);
  }

  /** Unarchive a plan */
  public unarchive(planId: string, requestOptions?: RequestOptions): APIPromise<void> {
    const request = new MeteroidRequest("POST", "/api/v1/plans/{plan_id}/unarchive");

    request.setPathParam("plan_id", planId);
    return request.sendNoResponseBody(this.requestCtx, requestOptions);
  }

  /** List plan versions */
  public listVersions(
    planId: string,
    options?: PlansListVersionsOptions,
    requestOptions?: RequestOptions
  ): APIPromise<PlanVersionListResponse> {
    const request = new MeteroidRequest("GET", "/api/v1/plans/{plan_id}/versions");

    request.setPathParam("plan_id", planId);
    request.setQueryParam("page", options?.page);
    request.setQueryParam("per_page", options?.perPage);
    return request.send(
      this.requestCtx,
      PlanVersionListResponseSerializer.parse,
      requestOptions
    );
  }
}
