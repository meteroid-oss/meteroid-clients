// this file is @generated
import {
  type CreateProductRequest,
  CreateProductRequestSerializer,
} from "../models/createProductRequest";
import { type Product, ProductSerializer } from "../models/product";
import type { ProductFamilyId } from "../models/productFamilyId";
import {
  type ProductListResponse,
  ProductListResponseSerializer,
} from "../models/productListResponse";
import {
  type ResolvedEntitlementListResponse,
  ResolvedEntitlementListResponseSerializer,
} from "../models/resolvedEntitlementListResponse";
import {
  type UpdateProductRequest,
  UpdateProductRequestSerializer,
} from "../models/updateProductRequest";
import { HttpMethod, MeteroidRequest, type MeteroidRequestContext } from "../request";

export interface ProductsListProductsOptions {
  productFamilyId?: ProductFamilyId;
  search?: string;
  /** Sort order. Format: `column.direction`. Allowed columns: `name`, `created_at`. Direction: `asc` or `desc`. Default: `name.asc`. */
  orderBy?: string;
  /** Page number (0-indexed) */
  page?: number;
  /** Number of items per page */
  perPage?: number;
}

export class Products {
  public constructor(private readonly requestCtx: MeteroidRequestContext) {}

  /**  */
  public listProducts(
    options?: ProductsListProductsOptions
  ): Promise<ProductListResponse> {
    const request = new MeteroidRequest(HttpMethod.GET, "/api/v1/products");

    request.setQueryParam("product_family_id", options?.productFamilyId);
    request.setQueryParam("search", options?.search);
    request.setQueryParam("order_by", options?.orderBy);
    request.setQueryParam("page", options?.page);
    request.setQueryParam("per_page", options?.perPage);
    return request.send(this.requestCtx, ProductListResponseSerializer._fromJsonObject);
  }

  /**  */
  public createProduct(createProductRequest: CreateProductRequest): Promise<Product> {
    const request = new MeteroidRequest(HttpMethod.POST, "/api/v1/products");

    request.setBody(CreateProductRequestSerializer._toJsonObject(createProductRequest));
    return request.send(this.requestCtx, ProductSerializer._fromJsonObject);
  }

  /**  */
  public getProduct(productId: string): Promise<Product> {
    const request = new MeteroidRequest(HttpMethod.GET, "/api/v1/products/{product_id}");

    request.setPathParam("product_id", productId);
    return request.send(this.requestCtx, ProductSerializer._fromJsonObject);
  }

  /** Partially update product fields. The fee_type is immutable and cannot be changed. */
  public updateProduct(
    productId: string,
    updateProductRequest: UpdateProductRequest
  ): Promise<Product> {
    const request = new MeteroidRequest(
      HttpMethod.PATCH,
      "/api/v1/products/{product_id}"
    );

    request.setPathParam("product_id", productId);
    request.setBody(UpdateProductRequestSerializer._toJsonObject(updateProductRequest));
    return request.send(this.requestCtx, ProductSerializer._fromJsonObject);
  }

  /**  */
  public archiveProduct(productId: string): Promise<void> {
    const request = new MeteroidRequest(
      HttpMethod.POST,
      "/api/v1/products/{product_id}/archive"
    );

    request.setPathParam("product_id", productId);
    return request.sendNoResponseBody(this.requestCtx);
  }

  /**  */
  public listProductEntitlements(
    productId: string
  ): Promise<ResolvedEntitlementListResponse> {
    const request = new MeteroidRequest(
      HttpMethod.GET,
      "/api/v1/products/{product_id}/entitlements"
    );

    request.setPathParam("product_id", productId);
    return request.send(
      this.requestCtx,
      ResolvedEntitlementListResponseSerializer._fromJsonObject
    );
  }

  /**  */
  public unarchiveProduct(productId: string): Promise<void> {
    const request = new MeteroidRequest(
      HttpMethod.POST,
      "/api/v1/products/{product_id}/unarchive"
    );

    request.setPathParam("product_id", productId);
    return request.sendNoResponseBody(this.requestCtx);
  }
}
