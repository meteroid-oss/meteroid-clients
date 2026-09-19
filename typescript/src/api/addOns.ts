// this file is @generated
import { type AddOn, AddOnSerializer } from "../models/addOn";
import {
  type AddOnListResponse,
  AddOnListResponseSerializer,
} from "../models/addOnListResponse";
import {
  type CreateAddOnRequest,
  CreateAddOnRequestSerializer,
} from "../models/createAddOnRequest";
import {
  type ResolvedEntitlementListResponse,
  ResolvedEntitlementListResponseSerializer,
} from "../models/resolvedEntitlementListResponse";
import {
  type UpdateAddOnRequest,
  UpdateAddOnRequestSerializer,
} from "../models/updateAddOnRequest";
import { HttpMethod, MeteroidRequest, type MeteroidRequestContext } from "../request";

export interface AddOnsListAddonsOptions {
  search?: string;
  currency?: string;
  /** Include archived add-ons in the results (default: false) */
  includeArchived?: boolean;
  /** Sort order. Format: `column.direction`. Allowed columns: `name`, `created_at`. Direction: `asc` or `desc`. Default: `created_at.desc`. */
  orderBy?: string;
  /** Page number (0-indexed) */
  page?: number;
  /** Number of items per page */
  perPage?: number;
}

export class AddOns {
  public constructor(private readonly requestCtx: MeteroidRequestContext) {}

  /**  */
  public listAddons(options?: AddOnsListAddonsOptions): Promise<AddOnListResponse> {
    const request = new MeteroidRequest(HttpMethod.GET, "/api/v1/addons");

    request.setQueryParam("search", options?.search);
    request.setQueryParam("currency", options?.currency);
    request.setQueryParam("include_archived", options?.includeArchived);
    request.setQueryParam("order_by", options?.orderBy);
    request.setQueryParam("page", options?.page);
    request.setQueryParam("per_page", options?.perPage);
    return request.send(this.requestCtx, AddOnListResponseSerializer._fromJsonObject);
  }

  /**  */
  public createAddon(createAddOnRequest: CreateAddOnRequest): Promise<AddOn> {
    const request = new MeteroidRequest(HttpMethod.POST, "/api/v1/addons");

    request.setBody(CreateAddOnRequestSerializer._toJsonObject(createAddOnRequest));
    return request.send(this.requestCtx, AddOnSerializer._fromJsonObject);
  }

  /**  */
  public getAddon(addonId: string): Promise<AddOn> {
    const request = new MeteroidRequest(HttpMethod.GET, "/api/v1/addons/{addon_id}");

    request.setPathParam("addon_id", addonId);
    return request.send(this.requestCtx, AddOnSerializer._fromJsonObject);
  }

  /**  */
  public updateAddon(
    addonId: string,
    updateAddOnRequest: UpdateAddOnRequest
  ): Promise<AddOn> {
    const request = new MeteroidRequest(HttpMethod.PATCH, "/api/v1/addons/{addon_id}");

    request.setPathParam("addon_id", addonId);
    request.setBody(UpdateAddOnRequestSerializer._toJsonObject(updateAddOnRequest));
    return request.send(this.requestCtx, AddOnSerializer._fromJsonObject);
  }

  /**  */
  public archiveAddon(addonId: string): Promise<void> {
    const request = new MeteroidRequest(
      HttpMethod.POST,
      "/api/v1/addons/{addon_id}/archive"
    );

    request.setPathParam("addon_id", addonId);
    return request.sendNoResponseBody(this.requestCtx);
  }

  /**  */
  public listAddOnEntitlements(
    addonId: string
  ): Promise<ResolvedEntitlementListResponse> {
    const request = new MeteroidRequest(
      HttpMethod.GET,
      "/api/v1/addons/{addon_id}/entitlements"
    );

    request.setPathParam("addon_id", addonId);
    return request.send(
      this.requestCtx,
      ResolvedEntitlementListResponseSerializer._fromJsonObject
    );
  }

  /**  */
  public unarchiveAddon(addonId: string): Promise<void> {
    const request = new MeteroidRequest(
      HttpMethod.POST,
      "/api/v1/addons/{addon_id}/unarchive"
    );

    request.setPathParam("addon_id", addonId);
    return request.sendNoResponseBody(this.requestCtx);
  }
}
