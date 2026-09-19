// this file is @generated
import {
  type CustomPropertyDefinition,
  CustomPropertyDefinitionSerializer,
} from "../models/customPropertyDefinition";
import {
  type CustomPropertyDefinitionCreateRequest,
  CustomPropertyDefinitionCreateRequestSerializer,
} from "../models/customPropertyDefinitionCreateRequest";
import {
  type CustomPropertyDefinitionListResponse,
  CustomPropertyDefinitionListResponseSerializer,
} from "../models/customPropertyDefinitionListResponse";
import {
  type CustomPropertyDefinitionUpdateRequest,
  CustomPropertyDefinitionUpdateRequestSerializer,
} from "../models/customPropertyDefinitionUpdateRequest";
import type { CustomPropertyEntityType } from "../models/customPropertyEntityType";
import { HttpMethod, MeteroidRequest, type MeteroidRequestContext } from "../request";

export interface CustomPropertiesListDefinitionsOptions {
  /** Filter to a single entity type. */
  entityType?: CustomPropertyEntityType;
  /** Include archived (soft-deleted) definitions. Defaults to false. */
  includeArchived?: boolean;
  /** Page number (0-indexed) */
  page?: number;
  /** Number of items per page */
  perPage?: number;
}

export class CustomProperties {
  public constructor(private readonly requestCtx: MeteroidRequestContext) {}

  /**  */
  public listDefinitions(
    options?: CustomPropertiesListDefinitionsOptions
  ): Promise<CustomPropertyDefinitionListResponse> {
    const request = new MeteroidRequest(
      HttpMethod.GET,
      "/api/v1/custom-property-definitions"
    );

    request.setQueryParam("entity_type", options?.entityType);
    request.setQueryParam("include_archived", options?.includeArchived);
    request.setQueryParam("page", options?.page);
    request.setQueryParam("per_page", options?.perPage);
    return request.send(
      this.requestCtx,
      CustomPropertyDefinitionListResponseSerializer._fromJsonObject
    );
  }

  /**  */
  public createDefinition(
    customPropertyDefinitionCreateRequest: CustomPropertyDefinitionCreateRequest
  ): Promise<CustomPropertyDefinition> {
    const request = new MeteroidRequest(
      HttpMethod.POST,
      "/api/v1/custom-property-definitions"
    );

    request.setBody(
      CustomPropertyDefinitionCreateRequestSerializer._toJsonObject(
        customPropertyDefinitionCreateRequest
      )
    );
    return request.send(
      this.requestCtx,
      CustomPropertyDefinitionSerializer._fromJsonObject
    );
  }

  /**  */
  public getDefinition(id: string): Promise<CustomPropertyDefinition> {
    const request = new MeteroidRequest(
      HttpMethod.GET,
      "/api/v1/custom-property-definitions/{id}"
    );

    request.setPathParam("id", id);
    return request.send(
      this.requestCtx,
      CustomPropertyDefinitionSerializer._fromJsonObject
    );
  }

  /**  */
  public updateDefinition(
    id: string,
    customPropertyDefinitionUpdateRequest: CustomPropertyDefinitionUpdateRequest
  ): Promise<CustomPropertyDefinition> {
    const request = new MeteroidRequest(
      HttpMethod.PUT,
      "/api/v1/custom-property-definitions/{id}"
    );

    request.setPathParam("id", id);
    request.setBody(
      CustomPropertyDefinitionUpdateRequestSerializer._toJsonObject(
        customPropertyDefinitionUpdateRequest
      )
    );
    return request.send(
      this.requestCtx,
      CustomPropertyDefinitionSerializer._fromJsonObject
    );
  }

  /**
   * Soft-deletes the definition. Existing property values on entities are preserved; the definition
   * simply stops being enforced on new writes.
   */
  public archiveDefinition(id: string): Promise<CustomPropertyDefinition> {
    const request = new MeteroidRequest(
      HttpMethod.DELETE,
      "/api/v1/custom-property-definitions/{id}"
    );

    request.setPathParam("id", id);
    return request.send(
      this.requestCtx,
      CustomPropertyDefinitionSerializer._fromJsonObject
    );
  }
}
