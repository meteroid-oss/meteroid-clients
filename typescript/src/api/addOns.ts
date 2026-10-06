// this file is @generated

import { type AddOn, AddOnSerializer } from "../models/addOn.js";
import {
  type AddOnListResponse,
  AddOnListResponseSerializer,
} from "../models/addOnListResponse.js";
import {
  type CreateAddOnRequest,
  CreateAddOnRequestSerializer,
} from "../models/createAddOnRequest.js";
import {
  type ResolvedEntitlementListResponse,
  ResolvedEntitlementListResponseSerializer,
} from "../models/resolvedEntitlementListResponse.js";
import {
  type UpdateAddOnRequest,
  UpdateAddOnRequestSerializer,
} from "../models/updateAddOnRequest.js";
import type { APIPromise } from "../apiPromise.js";
import {
  MeteroidRequest,
  type MeteroidRequestContext,
  type RequestOptions,
} from "../request.js";

/** The query and header parameters of `list`. */
export interface AddOnsListOptions {
  search?: string | undefined;
  currency?: string | undefined;
  /** Include archived add-ons in the results (default: false) */
  includeArchived?: boolean | undefined;
  /** Sort order. Format: `column.direction`. Allowed columns: `name`, `created_at`. Direction: `asc` or `desc`. Default: `created_at.desc`. */
  orderBy?: string | undefined;
  /** Page number (0-indexed) */
  page?: number | undefined;
  /** Number of items per page */
  perPage?: number | undefined;
}

/** The add ons operations, reached through the client's `addOns`. */
export class AddOns {
  /** @internal */
  public constructor(private readonly requestCtx: MeteroidRequestContext) {}

  /** List add-ons */
  public list(
    options?: AddOnsListOptions,
    requestOptions?: RequestOptions
  ): APIPromise<AddOnListResponse> {
    const request = new MeteroidRequest("GET", "/api/v1/addons");

    request.setQueryParam("search", options?.search);
    request.setQueryParam("currency", options?.currency);
    request.setQueryParam("include_archived", options?.includeArchived);
    request.setQueryParam("order_by", options?.orderBy);
    request.setQueryParam("page", options?.page);
    request.setQueryParam("per_page", options?.perPage);
    return request.send(
      this.requestCtx,
      AddOnListResponseSerializer.parse,
      requestOptions
    );
  }

  /** Create an add-on */
  public create(
    createAddOnRequest: CreateAddOnRequest,
    requestOptions?: RequestOptions
  ): APIPromise<AddOn> {
    const request = new MeteroidRequest("POST", "/api/v1/addons");

    request.setBody(CreateAddOnRequestSerializer.serialize(createAddOnRequest));
    return request.send(this.requestCtx, AddOnSerializer.parse, requestOptions);
  }

  /** Get add-on details */
  public retrieve(addonId: string, requestOptions?: RequestOptions): APIPromise<AddOn> {
    const request = new MeteroidRequest("GET", "/api/v1/addons/{addon_id}");

    request.setPathParam("addon_id", addonId);
    return request.send(this.requestCtx, AddOnSerializer.parse, requestOptions);
  }

  /** Update an add-on */
  public update(
    addonId: string,
    updateAddOnRequest: UpdateAddOnRequest,
    requestOptions?: RequestOptions
  ): APIPromise<AddOn> {
    const request = new MeteroidRequest("PATCH", "/api/v1/addons/{addon_id}");

    request.setPathParam("addon_id", addonId);
    request.setBody(UpdateAddOnRequestSerializer.serialize(updateAddOnRequest));
    return request.send(this.requestCtx, AddOnSerializer.parse, requestOptions);
  }

  /** Archive an add-on */
  public archive(addonId: string, requestOptions?: RequestOptions): APIPromise<void> {
    const request = new MeteroidRequest("POST", "/api/v1/addons/{addon_id}/archive");

    request.setPathParam("addon_id", addonId);
    return request.sendNoResponseBody(this.requestCtx, requestOptions);
  }

  /** List add-on entitlements */
  public listEntitlements(
    addonId: string,
    requestOptions?: RequestOptions
  ): APIPromise<ResolvedEntitlementListResponse> {
    const request = new MeteroidRequest("GET", "/api/v1/addons/{addon_id}/entitlements");

    request.setPathParam("addon_id", addonId);
    return request.send(
      this.requestCtx,
      ResolvedEntitlementListResponseSerializer.parse,
      requestOptions
    );
  }

  /** Unarchive an add-on */
  public unarchive(addonId: string, requestOptions?: RequestOptions): APIPromise<void> {
    const request = new MeteroidRequest("POST", "/api/v1/addons/{addon_id}/unarchive");

    request.setPathParam("addon_id", addonId);
    return request.sendNoResponseBody(this.requestCtx, requestOptions);
  }
}
