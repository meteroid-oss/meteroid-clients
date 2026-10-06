// this file is @generated

import {
  type CustomPropertyDefinition,
  CustomPropertyDefinitionSerializer,
} from "../models/customPropertyDefinition.js";
import {
  type CustomPropertyDefinitionCreateRequest,
  CustomPropertyDefinitionCreateRequestSerializer,
} from "../models/customPropertyDefinitionCreateRequest.js";
import {
  type CustomPropertyDefinitionListResponse,
  CustomPropertyDefinitionListResponseSerializer,
} from "../models/customPropertyDefinitionListResponse.js";
import {
  type CustomPropertyDefinitionUpdateRequest,
  CustomPropertyDefinitionUpdateRequestSerializer,
} from "../models/customPropertyDefinitionUpdateRequest.js";
import type { CustomPropertyEntityType } from "../models/customPropertyEntityType.js";
import type { APIPromise } from "../apiPromise.js";
import {
  MeteroidRequest,
  type MeteroidRequestContext,
  type RequestOptions,
} from "../request.js";

/** The query and header parameters of `listCustomPropertyDefinitions`. */
export interface CustomPropertiesListCustomPropertyDefinitionsOptions {
  /** Filter to a single entity type. */
  entityType?: CustomPropertyEntityType | undefined;
  /** Include archived (soft-deleted) definitions. Defaults to false. */
  includeArchived?: boolean | undefined;
  /** Page number (0-indexed) */
  page?: number | undefined;
  /** Number of items per page */
  perPage?: number | undefined;
}

/** The custom properties operations, reached through the client's `customProperties`. */
export class CustomProperties {
  /** @internal */
  public constructor(private readonly requestCtx: MeteroidRequestContext) {}

  /** List custom property definitions */
  public listCustomPropertyDefinitions(
    options?: CustomPropertiesListCustomPropertyDefinitionsOptions,
    requestOptions?: RequestOptions
  ): APIPromise<CustomPropertyDefinitionListResponse> {
    const request = new MeteroidRequest("GET", "/api/v1/custom-property-definitions");

    request.setQueryParam("entity_type", options?.entityType);
    request.setQueryParam("include_archived", options?.includeArchived);
    request.setQueryParam("page", options?.page);
    request.setQueryParam("per_page", options?.perPage);
    return request.send(
      this.requestCtx,
      CustomPropertyDefinitionListResponseSerializer.parse,
      requestOptions
    );
  }

  /** Create a custom property definition */
  public createCustomPropertyDefinition(
    customPropertyDefinitionCreateRequest: CustomPropertyDefinitionCreateRequest,
    requestOptions?: RequestOptions
  ): APIPromise<CustomPropertyDefinition> {
    const request = new MeteroidRequest("POST", "/api/v1/custom-property-definitions");

    request.setBody(
      CustomPropertyDefinitionCreateRequestSerializer.serialize(
        customPropertyDefinitionCreateRequest
      )
    );
    return request.send(
      this.requestCtx,
      CustomPropertyDefinitionSerializer.parse,
      requestOptions
    );
  }

  /** Get a custom property definition */
  public retrieveCustomPropertyDefinition(
    id: string,
    requestOptions?: RequestOptions
  ): APIPromise<CustomPropertyDefinition> {
    const request = new MeteroidRequest(
      "GET",
      "/api/v1/custom-property-definitions/{id}"
    );

    request.setPathParam("id", id);
    return request.send(
      this.requestCtx,
      CustomPropertyDefinitionSerializer.parse,
      requestOptions
    );
  }

  /** Update a custom property definition */
  public updateCustomPropertyDefinition(
    id: string,
    customPropertyDefinitionUpdateRequest: CustomPropertyDefinitionUpdateRequest,
    requestOptions?: RequestOptions
  ): APIPromise<CustomPropertyDefinition> {
    const request = new MeteroidRequest(
      "PUT",
      "/api/v1/custom-property-definitions/{id}"
    );

    request.setPathParam("id", id);
    request.setBody(
      CustomPropertyDefinitionUpdateRequestSerializer.serialize(
        customPropertyDefinitionUpdateRequest
      )
    );
    return request.send(
      this.requestCtx,
      CustomPropertyDefinitionSerializer.parse,
      requestOptions
    );
  }

  /**
   * Archive a custom property definition
   *
   * Soft-deletes the definition. Existing property values on entities are preserved; the definition
   * simply stops being enforced on new writes.
   */
  public archiveDefinition(
    id: string,
    requestOptions?: RequestOptions
  ): APIPromise<CustomPropertyDefinition> {
    const request = new MeteroidRequest(
      "DELETE",
      "/api/v1/custom-property-definitions/{id}"
    );

    request.setPathParam("id", id);
    return request.send(
      this.requestCtx,
      CustomPropertyDefinitionSerializer.parse,
      requestOptions
    );
  }
}
