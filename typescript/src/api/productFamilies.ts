// this file is @generated

import { type ProductFamily, ProductFamilySerializer } from "../models/productFamily.js";
import {
  type ProductFamilyCreateRequest,
  ProductFamilyCreateRequestSerializer,
} from "../models/productFamilyCreateRequest.js";
import {
  type ProductFamilyListResponse,
  ProductFamilyListResponseSerializer,
} from "../models/productFamilyListResponse.js";
import type { APIPromise } from "../apiPromise.js";
import {
  MeteroidRequest,
  type MeteroidRequestContext,
  type RequestOptions,
} from "../request.js";

/** The query and header parameters of `list`. */
export interface ProductFamiliesListOptions {
  /** Sort order. Format: `column.direction`. Allowed columns: `name`, `created_at`. Direction: `asc` or `desc`. Default: `created_at.desc`. */
  orderBy?: string | undefined;
  /** Page number (0-indexed) */
  page?: number | undefined;
  /** Number of items per page */
  perPage?: number | undefined;
  search?: string | undefined;
}

/** The product families operations, reached through the client's `productFamilies`. */
export class ProductFamilies {
  /** @internal */
  public constructor(private readonly requestCtx: MeteroidRequestContext) {}

  /** List product families */
  public list(
    options?: ProductFamiliesListOptions,
    requestOptions?: RequestOptions
  ): APIPromise<ProductFamilyListResponse> {
    const request = new MeteroidRequest("GET", "/api/v1/product_families");

    request.setQueryParam("order_by", options?.orderBy);
    request.setQueryParam("page", options?.page);
    request.setQueryParam("per_page", options?.perPage);
    request.setQueryParam("search", options?.search);
    return request.send(
      this.requestCtx,
      ProductFamilyListResponseSerializer.parse,
      requestOptions
    );
  }

  /** Create product family */
  public create(
    productFamilyCreateRequest: ProductFamilyCreateRequest,
    requestOptions?: RequestOptions
  ): APIPromise<ProductFamily> {
    const request = new MeteroidRequest("POST", "/api/v1/product_families");

    request.setBody(
      ProductFamilyCreateRequestSerializer.serialize(productFamilyCreateRequest)
    );
    return request.send(this.requestCtx, ProductFamilySerializer.parse, requestOptions);
  }

  /**
   * Get product family
   *
   * Retrieve a single product family by ID or alias.
   */
  public retrieve(
    idOrAlias: string,
    requestOptions?: RequestOptions
  ): APIPromise<ProductFamily> {
    const request = new MeteroidRequest("GET", "/api/v1/product_families/{id_or_alias}");

    request.setPathParam("id_or_alias", idOrAlias);
    return request.send(this.requestCtx, ProductFamilySerializer.parse, requestOptions);
  }
}
