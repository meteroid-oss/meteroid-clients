// this file is @generated

import { type Customer, CustomerSerializer } from "../models/customer.js";
import {
  type CustomerCreateRequest,
  CustomerCreateRequestSerializer,
} from "../models/customerCreateRequest.js";
import {
  type CustomerListResponse,
  CustomerListResponseSerializer,
} from "../models/customerListResponse.js";
import {
  type CustomerPatchRequest,
  CustomerPatchRequestSerializer,
} from "../models/customerPatchRequest.js";
import {
  type CustomerPortalTokenRequest,
  CustomerPortalTokenRequestSerializer,
} from "../models/customerPortalTokenRequest.js";
import {
  type CustomerPortalTokenResponse,
  CustomerPortalTokenResponseSerializer,
} from "../models/customerPortalTokenResponse.js";
import {
  type CustomerUpdateRequest,
  CustomerUpdateRequestSerializer,
} from "../models/customerUpdateRequest.js";
import {
  type EffectiveEntitlementListResponse,
  EffectiveEntitlementListResponseSerializer,
} from "../models/effectiveEntitlementListResponse.js";
import type { APIPromise } from "../apiPromise.js";
import {
  MeteroidRequest,
  type MeteroidRequestContext,
  type RequestOptions,
} from "../request.js";

/** The query and header parameters of `list`. */
export interface CustomersListOptions {
  /** Sort order. Format: `column.direction`. Allowed columns: `name`, `email`, `alias`, `created_at`. Direction: `asc` or `desc`. Default: `created_at.desc`. */
  orderBy?: string | undefined;
  /** Page number (0-indexed) */
  page?: number | undefined;
  /** Number of items per page */
  perPage?: number | undefined;
  search?: string | undefined;
  archived?: boolean | undefined;
}

/** The customers operations, reached through the client's `customers`. */
export class Customers {
  /** @internal */
  public constructor(private readonly requestCtx: MeteroidRequestContext) {}

  /** List customers with optional pagination and search filtering. */
  public list(
    options?: CustomersListOptions,
    requestOptions?: RequestOptions
  ): APIPromise<CustomerListResponse> {
    const request = new MeteroidRequest("GET", "/api/v1/customers");

    request.setQueryParam("order_by", options?.orderBy);
    request.setQueryParam("page", options?.page);
    request.setQueryParam("per_page", options?.perPage);
    request.setQueryParam("search", options?.search);
    request.setQueryParam("archived", options?.archived);
    return request.send(
      this.requestCtx,
      CustomerListResponseSerializer.parse,
      requestOptions
    );
  }

  /** Create customer */
  public create(
    customerCreateRequest: CustomerCreateRequest,
    requestOptions?: RequestOptions
  ): APIPromise<Customer> {
    const request = new MeteroidRequest("POST", "/api/v1/customers");

    request.setBody(CustomerCreateRequestSerializer.serialize(customerCreateRequest));
    return request.send(this.requestCtx, CustomerSerializer.parse, requestOptions);
  }

  /**
   * Get customer
   *
   * Retrieve a single customer by ID or alias.
   */
  public retrieve(
    idOrAlias: string,
    requestOptions?: RequestOptions
  ): APIPromise<Customer> {
    const request = new MeteroidRequest("GET", "/api/v1/customers/{id_or_alias}");

    request.setPathParam("id_or_alias", idOrAlias);
    return request.send(this.requestCtx, CustomerSerializer.parse, requestOptions);
  }

  /** Update customer */
  public replace(
    idOrAlias: string,
    customerUpdateRequest: CustomerUpdateRequest,
    requestOptions?: RequestOptions
  ): APIPromise<Customer> {
    const request = new MeteroidRequest("PUT", "/api/v1/customers/{id_or_alias}");

    request.setPathParam("id_or_alias", idOrAlias);
    request.setBody(CustomerUpdateRequestSerializer.serialize(customerUpdateRequest));
    return request.send(this.requestCtx, CustomerSerializer.parse, requestOptions);
  }

  /**
   * Archive a customer
   *
   * No linked entity will be deleted. You need to terminate all active subscriptions before archiving a customer, or the call will fail.
   */
  public archive(idOrAlias: string, requestOptions?: RequestOptions): APIPromise<void> {
    const request = new MeteroidRequest("DELETE", "/api/v1/customers/{id_or_alias}");

    request.setPathParam("id_or_alias", idOrAlias);
    return request.sendNoResponseBody(this.requestCtx, requestOptions);
  }

  /**
   * Patch customer
   *
   * Partially update a customer. Only provided fields will be updated.
   */
  public update(
    idOrAlias: string,
    customerPatchRequest: CustomerPatchRequest,
    requestOptions?: RequestOptions
  ): APIPromise<Customer> {
    const request = new MeteroidRequest("PATCH", "/api/v1/customers/{id_or_alias}");

    request.setPathParam("id_or_alias", idOrAlias);
    request.setBody(CustomerPatchRequestSerializer.serialize(customerPatchRequest));
    return request.send(this.requestCtx, CustomerSerializer.parse, requestOptions);
  }

  /** List customer entitlements */
  public listEntitlements(
    idOrAlias: string,
    requestOptions?: RequestOptions
  ): APIPromise<EffectiveEntitlementListResponse> {
    const request = new MeteroidRequest(
      "GET",
      "/api/v1/customers/{id_or_alias}/entitlements"
    );

    request.setPathParam("id_or_alias", idOrAlias);
    return request.send(
      this.requestCtx,
      EffectiveEntitlementListResponseSerializer.parse,
      requestOptions
    );
  }

  /**
   * Generate a portal token for a customer
   *
   * Generates a JWT token that grants access to the customer portal.
   * The token can be used to access invoices, payment methods, and other portal features.
   */
  public createPortalToken(
    idOrAlias: string,
    customerPortalTokenRequest: CustomerPortalTokenRequest,
    requestOptions?: RequestOptions
  ): APIPromise<CustomerPortalTokenResponse> {
    const request = new MeteroidRequest(
      "POST",
      "/api/v1/customers/{id_or_alias}/portal-token"
    );

    request.setPathParam("id_or_alias", idOrAlias);
    request.setBody(
      CustomerPortalTokenRequestSerializer.serialize(customerPortalTokenRequest)
    );
    return request.send(
      this.requestCtx,
      CustomerPortalTokenResponseSerializer.parse,
      requestOptions
    );
  }

  /** Restore an archived customer */
  public unarchive(idOrAlias: string, requestOptions?: RequestOptions): APIPromise<void> {
    const request = new MeteroidRequest(
      "POST",
      "/api/v1/customers/{id_or_alias}/unarchive"
    );

    request.setPathParam("id_or_alias", idOrAlias);
    return request.sendNoResponseBody(this.requestCtx, requestOptions);
  }
}
