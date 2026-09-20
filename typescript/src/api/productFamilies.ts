// this file is @generated
import { type ProductFamily, ProductFamilySerializer } from "../models/productFamily";
import {
  type ProductFamilyCreateRequest,
  ProductFamilyCreateRequestSerializer,
} from "../models/productFamilyCreateRequest";
import {
  type ProductFamilyListResponse,
  ProductFamilyListResponseSerializer,
} from "../models/productFamilyListResponse";
import { HttpMethod, MeteroidRequest, type MeteroidRequestContext } from "../request";

export interface ProductFamiliesListProductFamiliesOptions {
  /** Sort order. Format: `column.direction`. Allowed columns: `name`, `created_at`. Direction: `asc` or `desc`. Default: `created_at.desc`. */
  orderBy?: string;
  /** Page number (0-indexed) */
  page?: number;
  /** Number of items per page */
  perPage?: number;
  search?: string;
}

export class ProductFamilies {
  public constructor(private readonly requestCtx: MeteroidRequestContext) {}

  /**  */
  public listProductFamilies(
    options?: ProductFamiliesListProductFamiliesOptions
  ): Promise<ProductFamilyListResponse> {
    const request = new MeteroidRequest(HttpMethod.GET, "/api/v1/product_families");

    request.setQueryParam("order_by", options?.orderBy);
    request.setQueryParam("page", options?.page);
    request.setQueryParam("per_page", options?.perPage);
    request.setQueryParam("search", options?.search);
    return request.send(
      this.requestCtx,
      ProductFamilyListResponseSerializer._fromJsonObject
    );
  }

  /**  */
  public createProductFamily(
    productFamilyCreateRequest: ProductFamilyCreateRequest
  ): Promise<ProductFamily> {
    const request = new MeteroidRequest(HttpMethod.POST, "/api/v1/product_families");

    request.setBody(
      ProductFamilyCreateRequestSerializer._toJsonObject(productFamilyCreateRequest)
    );
    return request.send(this.requestCtx, ProductFamilySerializer._fromJsonObject);
  }

  /** Retrieve a single product family by ID or alias. */
  public getProductFamilyByIdOrAlias(idOrAlias: string): Promise<ProductFamily> {
    const request = new MeteroidRequest(
      HttpMethod.GET,
      "/api/v1/product_families/{id_or_alias}"
    );

    request.setPathParam("id_or_alias", idOrAlias);
    return request.send(this.requestCtx, ProductFamilySerializer._fromJsonObject);
  }
}
