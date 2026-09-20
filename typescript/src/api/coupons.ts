// this file is @generated
import { type Coupon, CouponSerializer } from "../models/coupon";
import type { CouponFilter } from "../models/couponFilter";
import {
  type CouponListResponse,
  CouponListResponseSerializer,
} from "../models/couponListResponse";
import {
  type CreateCouponRequest,
  CreateCouponRequestSerializer,
} from "../models/createCouponRequest";
import {
  type UpdateCouponRequest,
  UpdateCouponRequestSerializer,
} from "../models/updateCouponRequest";
import { HttpMethod, MeteroidRequest, type MeteroidRequestContext } from "../request";

export interface CouponsListCouponsOptions {
  search?: string;
  filter?: CouponFilter;
  /** Sort order. Format: `column.direction`. Allowed columns: `code`, `created_at`, `expires_at`. Direction: `asc` or `desc`. Default: `created_at.desc`. */
  orderBy?: string;
  /** Page number (0-indexed) */
  page?: number;
  /** Number of items per page */
  perPage?: number;
}

export class Coupons {
  public constructor(private readonly requestCtx: MeteroidRequestContext) {}

  /**  */
  public listCoupons(options?: CouponsListCouponsOptions): Promise<CouponListResponse> {
    const request = new MeteroidRequest(HttpMethod.GET, "/api/v1/coupons");

    request.setQueryParam("search", options?.search);
    request.setQueryParam("filter", options?.filter);
    request.setQueryParam("order_by", options?.orderBy);
    request.setQueryParam("page", options?.page);
    request.setQueryParam("per_page", options?.perPage);
    return request.send(this.requestCtx, CouponListResponseSerializer._fromJsonObject);
  }

  /**  */
  public createCoupon(createCouponRequest: CreateCouponRequest): Promise<Coupon> {
    const request = new MeteroidRequest(HttpMethod.POST, "/api/v1/coupons");

    request.setBody(CreateCouponRequestSerializer._toJsonObject(createCouponRequest));
    return request.send(this.requestCtx, CouponSerializer._fromJsonObject);
  }

  /**  */
  public getCoupon(couponId: string): Promise<Coupon> {
    const request = new MeteroidRequest(HttpMethod.GET, "/api/v1/coupons/{coupon_id}");

    request.setPathParam("coupon_id", couponId);
    return request.send(this.requestCtx, CouponSerializer._fromJsonObject);
  }

  /**  */
  public updateCoupon(
    couponId: string,
    updateCouponRequest: UpdateCouponRequest
  ): Promise<Coupon> {
    const request = new MeteroidRequest(HttpMethod.PATCH, "/api/v1/coupons/{coupon_id}");

    request.setPathParam("coupon_id", couponId);
    request.setBody(UpdateCouponRequestSerializer._toJsonObject(updateCouponRequest));
    return request.send(this.requestCtx, CouponSerializer._fromJsonObject);
  }

  /**  */
  public archiveCoupon(couponId: string): Promise<void> {
    const request = new MeteroidRequest(
      HttpMethod.POST,
      "/api/v1/coupons/{coupon_id}/archive"
    );

    request.setPathParam("coupon_id", couponId);
    return request.sendNoResponseBody(this.requestCtx);
  }

  /**  */
  public disableCoupon(couponId: string): Promise<void> {
    const request = new MeteroidRequest(
      HttpMethod.POST,
      "/api/v1/coupons/{coupon_id}/disable"
    );

    request.setPathParam("coupon_id", couponId);
    return request.sendNoResponseBody(this.requestCtx);
  }

  /**  */
  public enableCoupon(couponId: string): Promise<void> {
    const request = new MeteroidRequest(
      HttpMethod.POST,
      "/api/v1/coupons/{coupon_id}/enable"
    );

    request.setPathParam("coupon_id", couponId);
    return request.sendNoResponseBody(this.requestCtx);
  }

  /**  */
  public unarchiveCoupon(couponId: string): Promise<void> {
    const request = new MeteroidRequest(
      HttpMethod.POST,
      "/api/v1/coupons/{coupon_id}/unarchive"
    );

    request.setPathParam("coupon_id", couponId);
    return request.sendNoResponseBody(this.requestCtx);
  }
}
