// this file is @generated
package meteroid

import (
	"context"
	"net/http"
)

// PlansListPlansOptions carries the query and header parameters of
// Plans.ListPlans.
//
// Optional parameters are pointers; leave them nil to omit them.
type PlansListPlansOptions struct {
	ProductFamilyId *ProductFamilyId

	// Search by plan name
	Search *string

	// Filter by plan status (can be repeated)
	Status []PlanStatusEnum

	// Filter by plan type (can be repeated)
	PlanType []PlanTypeEnum

	// Sort order. Format: `column.direction`. Allowed columns: `name`, `status`, `plan_type`, `created_at`. Direction: `asc` or `desc`. Default: `created_at.desc`.
	OrderBy *string

	// Page number (0-indexed)
	Page *int32

	// Number of items per page
	PerPage *int32
}

// PlansGetPlanDetailsOptions carries the query and header parameters of
// Plans.GetPlanDetails.
//
// Optional parameters are pointers; leave them nil to omit them.
type PlansGetPlanDetailsOptions struct {
	// Filter by version: "draft", a version number, or omitted for active
	Version *string
}

// PlansListPlanVersionsOptions carries the query and header parameters of
// Plans.ListPlanVersions.
//
// Optional parameters are pointers; leave them nil to omit them.
type PlansListPlanVersionsOptions struct {
	// Page number (0-indexed)
	Page *int32

	// Number of items per page
	PerPage *int32
}

// Plans groups the plans operations of the Meteroid API.
type Plans struct {
	client *Client
}

func (a *Plans) ListPlanVersionEntitlements(ctx context.Context, planVersionId string) (*ResolvedEntitlementListResponse, error) {
	req := newRequest(http.MethodGet, "/api/v1/plan-versions/{plan_version_id}/entitlements")
	req.SetPathParam("plan_version_id", planVersionId)

	var out ResolvedEntitlementListResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

func (a *Plans) ListPlans(ctx context.Context, options *PlansListPlansOptions) (*PlanListResponse, error) {
	req := newRequest(http.MethodGet, "/api/v1/plans")

	if options != nil {
		if options.ProductFamilyId != nil {
			req.SetQueryParam("product_family_id", string(*options.ProductFamilyId))
		}
		if options.Search != nil {
			req.SetQueryParam("search", *options.Search)
		}

		if len(options.Status) > 0 {
			for _, item := range options.Status {
				req.AddQueryParam("status", string(item))
			}
		}

		if len(options.PlanType) > 0 {
			for _, item := range options.PlanType {
				req.AddQueryParam("plan_type", string(item))
			}
		}
		if options.OrderBy != nil {
			req.SetQueryParam("order_by", *options.OrderBy)
		}
		if options.Page != nil {
			req.SetQueryParam("page", formatInt(int64(*options.Page)))
		}
		if options.PerPage != nil {
			req.SetQueryParam("per_page", formatInt(int64(*options.PerPage)))
		}
	}

	var out PlanListResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

// Create a new plan with components and pricing. Set `status` to `ACTIVE` to
// publish immediately, or `DRAFT` to stage for review.
func (a *Plans) CreatePlan(ctx context.Context, createPlanRequest CreatePlanRequest) (*Plan, error) {
	req := newRequest(http.MethodPost, "/api/v1/plans")

	req.SetJSONBody(createPlanRequest)

	var out Plan
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

func (a *Plans) SetPlanMinimum(ctx context.Context, planVersionId string, minimumCommitment MinimumCommitment) (*MinimumCommitment, error) {
	req := newRequest(http.MethodPut, "/api/v1/plans/versions/{plan_version_id}/minimum")
	req.SetPathParam("plan_version_id", planVersionId)

	req.SetJSONBody(minimumCommitment)

	var out MinimumCommitment
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

func (a *Plans) DeletePlanMinimum(ctx context.Context, planVersionId string) error {
	req := newRequest(http.MethodDelete, "/api/v1/plans/versions/{plan_version_id}/minimum")
	req.SetPathParam("plan_version_id", planVersionId)

	return a.client.execute(ctx, req, nil)
}

// Retrieve a specific plan. Use `?version=draft` for the draft version,
// `?version=2` for a specific version number, or omit for the active version.
func (a *Plans) GetPlanDetails(ctx context.Context, planId string, options *PlansGetPlanDetailsOptions) (*Plan, error) {
	req := newRequest(http.MethodGet, "/api/v1/plans/{plan_id}")
	req.SetPathParam("plan_id", planId)

	if options != nil {
		if options.Version != nil {
			req.SetQueryParam("version", *options.Version)
		}
	}

	var out Plan
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

// Full replacement of a plan's version. On a draft plan, updates in-place.
// On a published plan, creates a new version. Set `status` to `DRAFT` to
// stage as a new draft without publishing.
func (a *Plans) ReplacePlan(ctx context.Context, planId string, replacePlanRequest ReplacePlanRequest) (*Plan, error) {
	req := newRequest(http.MethodPut, "/api/v1/plans/{plan_id}")
	req.SetPathParam("plan_id", planId)

	req.SetJSONBody(replacePlanRequest)

	var out Plan
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

// Partially update plan-level fields (name, description, self_service_rank).
// Does not modify version-level configuration or components.
func (a *Plans) PatchPlan(ctx context.Context, planId string, patchPlanRequest PatchPlanRequest) (*Plan, error) {
	req := newRequest(http.MethodPatch, "/api/v1/plans/{plan_id}")
	req.SetPathParam("plan_id", planId)

	req.SetJSONBody(patchPlanRequest)

	var out Plan
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

func (a *Plans) ArchivePlan(ctx context.Context, planId string) error {
	req := newRequest(http.MethodPost, "/api/v1/plans/{plan_id}/archive")
	req.SetPathParam("plan_id", planId)

	return a.client.execute(ctx, req, nil)
}

// Publishes the current draft version, making it the active version.
func (a *Plans) PublishPlan(ctx context.Context, planId string) (*Plan, error) {
	req := newRequest(http.MethodPost, "/api/v1/plans/{plan_id}/publish")
	req.SetPathParam("plan_id", planId)

	var out Plan
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

func (a *Plans) UnarchivePlan(ctx context.Context, planId string) error {
	req := newRequest(http.MethodPost, "/api/v1/plans/{plan_id}/unarchive")
	req.SetPathParam("plan_id", planId)

	return a.client.execute(ctx, req, nil)
}

func (a *Plans) ListPlanVersions(ctx context.Context, planId string, options *PlansListPlanVersionsOptions) (*PlanVersionListResponse, error) {
	req := newRequest(http.MethodGet, "/api/v1/plans/{plan_id}/versions")
	req.SetPathParam("plan_id", planId)

	if options != nil {
		if options.Page != nil {
			req.SetQueryParam("page", formatInt(int64(*options.Page)))
		}
		if options.PerPage != nil {
			req.SetQueryParam("per_page", formatInt(int64(*options.PerPage)))
		}
	}

	var out PlanVersionListResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}
