package main

import "context"

// listPlans is `GET /api/plans` — the pricing table, straight from the seeded Meteroid
// catalog. Unauthenticated: the pricing page is public.
//
// All the work happens in catalog.go, which resolves each plan by its exact seeded
// name, flattens its price components and turns the plan version's entitlements into
// marketing bullets. The result is cached for the life of the process.
func (a *app) listPlans(ctx context.Context, _ *request) (*reply, error) {
	catalog, err := a.catalog(ctx)
	if err != nil {
		return nil, err
	}

	return replyOK(PlanListResponse{Plans: catalog.plans})
}
