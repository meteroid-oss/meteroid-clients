// this file is @generated
package meteroid

import (
	"context"
	"net/http"
)

// CustomPropertiesListDefinitionsOptions carries the query and header parameters of
// CustomProperties.ListDefinitions.
//
// Optional parameters are pointers; leave them nil to omit them.
type CustomPropertiesListDefinitionsOptions struct {
	// Filter to a single entity type.
	EntityType *CustomPropertyEntityType

	// Include archived (soft-deleted) definitions. Defaults to false.
	IncludeArchived *bool

	// Page number (0-indexed)
	Page *int32

	// Number of items per page
	PerPage *int32
}

// CustomProperties groups the custom properties operations of the Meteroid API.
type CustomProperties struct {
	client *Client
}

func (a *CustomProperties) ListDefinitions(ctx context.Context, options *CustomPropertiesListDefinitionsOptions) (*CustomPropertyDefinitionListResponse, error) {
	req := newRequest(http.MethodGet, "/api/v1/custom-property-definitions")

	if options != nil {
		if options.EntityType != nil {
			req.SetQueryParam("entity_type", string(*options.EntityType))
		}
		if options.IncludeArchived != nil {
			req.SetQueryParam("include_archived", formatBool(*options.IncludeArchived))
		}
		if options.Page != nil {
			req.SetQueryParam("page", formatInt(int64(*options.Page)))
		}
		if options.PerPage != nil {
			req.SetQueryParam("per_page", formatInt(int64(*options.PerPage)))
		}
	}

	var out CustomPropertyDefinitionListResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

func (a *CustomProperties) CreateDefinition(ctx context.Context, customPropertyDefinitionCreateRequest CustomPropertyDefinitionCreateRequest) (*CustomPropertyDefinition, error) {
	req := newRequest(http.MethodPost, "/api/v1/custom-property-definitions")

	req.SetJSONBody(customPropertyDefinitionCreateRequest)

	var out CustomPropertyDefinition
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

func (a *CustomProperties) GetDefinition(ctx context.Context, id string) (*CustomPropertyDefinition, error) {
	req := newRequest(http.MethodGet, "/api/v1/custom-property-definitions/{id}")
	req.SetPathParam("id", id)

	var out CustomPropertyDefinition
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

func (a *CustomProperties) UpdateDefinition(ctx context.Context, id string, customPropertyDefinitionUpdateRequest CustomPropertyDefinitionUpdateRequest) (*CustomPropertyDefinition, error) {
	req := newRequest(http.MethodPut, "/api/v1/custom-property-definitions/{id}")
	req.SetPathParam("id", id)

	req.SetJSONBody(customPropertyDefinitionUpdateRequest)

	var out CustomPropertyDefinition
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

// Soft-deletes the definition. Existing property values on entities are preserved; the definition
// simply stops being enforced on new writes.
func (a *CustomProperties) ArchiveDefinition(ctx context.Context, id string) (*CustomPropertyDefinition, error) {
	req := newRequest(http.MethodDelete, "/api/v1/custom-property-definitions/{id}")
	req.SetPathParam("id", id)

	var out CustomPropertyDefinition
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}
