// this file is @generated

import { type Coupon, CouponSerializer } from "../models/coupon.js";
import type { CouponFilter } from "../models/couponFilter.js";
import {
  type CouponListResponse,
  CouponListResponseSerializer,
} from "../models/couponListResponse.js";
import {
  type CreateCouponRequest,
  CreateCouponRequestSerializer,
} from "../models/createCouponRequest.js";
import {
  type UpdateCouponRequest,
  UpdateCouponRequestSerializer,
} from "../models/updateCouponRequest.js";
import type { APIPromise } from "../apiPromise.js";
import {
  MeteroidRequest,
  type MeteroidRequestContext,
  type RequestOptions,
} from "../request.js";

/** The query and header parameters of `list`. */
export interface CouponsListOptions {
  search?: string | undefined;
  filter?: CouponFilter | undefined;
  /** Sort order. Format: `column.direction`. Allowed columns: `code`, `created_at`, `expires_at`. Direction: `asc` or `desc`. Default: `created_at.desc`. */
  orderBy?: string | undefined;
  /** Page number (0-indexed) */
  page?: number | undefined;
  /** Number of items per page */
  perPage?: number | undefined;
}

/** The coupons operations, reached through the client's `coupons`. */
export class Coupons {
  /** @internal */
  public constructor(private readonly requestCtx: MeteroidRequestContext) {}

  /** List coupons */
  public list(
    options?: CouponsListOptions,
    requestOptions?: RequestOptions
  ): APIPromise<CouponListResponse> {
    const request = new MeteroidRequest("GET", "/api/v1/coupons");

    request.setQueryParam("search", options?.search);
    request.setQueryParam("filter", options?.filter);
    request.setQueryParam("order_by", options?.orderBy);
    request.setQueryParam("page", options?.page);
    request.setQueryParam("per_page", options?.perPage);
    return request.send(
      this.requestCtx,
      CouponListResponseSerializer.parse,
      requestOptions
    );
  }

  /** Create a coupon */
  public create(
    createCouponRequest: CreateCouponRequest,
    requestOptions?: RequestOptions
  ): APIPromise<Coupon> {
    const request = new MeteroidRequest("POST", "/api/v1/coupons");

    request.setBody(CreateCouponRequestSerializer.serialize(createCouponRequest));
    return request.send(this.requestCtx, CouponSerializer.parse, requestOptions);
  }

  /** Get coupon details */
  public retrieve(couponId: string, requestOptions?: RequestOptions): APIPromise<Coupon> {
    const request = new MeteroidRequest("GET", "/api/v1/coupons/{coupon_id}");

    request.setPathParam("coupon_id", couponId);
    return request.send(this.requestCtx, CouponSerializer.parse, requestOptions);
  }

  /** Update a coupon */
  public update(
    couponId: string,
    updateCouponRequest: UpdateCouponRequest,
    requestOptions?: RequestOptions
  ): APIPromise<Coupon> {
    const request = new MeteroidRequest("PATCH", "/api/v1/coupons/{coupon_id}");

    request.setPathParam("coupon_id", couponId);
    request.setBody(UpdateCouponRequestSerializer.serialize(updateCouponRequest));
    return request.send(this.requestCtx, CouponSerializer.parse, requestOptions);
  }

  /** Archive a coupon */
  public archive(couponId: string, requestOptions?: RequestOptions): APIPromise<void> {
    const request = new MeteroidRequest("POST", "/api/v1/coupons/{coupon_id}/archive");

    request.setPathParam("coupon_id", couponId);
    return request.sendNoResponseBody(this.requestCtx, requestOptions);
  }

  /** Disable a coupon */
  public disable(couponId: string, requestOptions?: RequestOptions): APIPromise<void> {
    const request = new MeteroidRequest("POST", "/api/v1/coupons/{coupon_id}/disable");

    request.setPathParam("coupon_id", couponId);
    return request.sendNoResponseBody(this.requestCtx, requestOptions);
  }

  /** Enable a coupon */
  public enable(couponId: string, requestOptions?: RequestOptions): APIPromise<void> {
    const request = new MeteroidRequest("POST", "/api/v1/coupons/{coupon_id}/enable");

    request.setPathParam("coupon_id", couponId);
    return request.sendNoResponseBody(this.requestCtx, requestOptions);
  }

  /** Unarchive a coupon */
  public unarchive(couponId: string, requestOptions?: RequestOptions): APIPromise<void> {
    const request = new MeteroidRequest("POST", "/api/v1/coupons/{coupon_id}/unarchive");

    request.setPathParam("coupon_id", couponId);
    return request.sendNoResponseBody(this.requestCtx, requestOptions);
  }
}
