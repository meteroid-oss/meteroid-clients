package main

import "context"

// listEntitlements is `GET /api/entitlements` — the normalized entitlement view the SPA
// gates on.
//
// One Meteroid call, then a straight projection. The list may legitimately be empty for
// a workspace that has never subscribed and has no feature-level defaults — that is not
// an error, and it is why the demo checks the *features* exist at startup instead of
// inferring "unseeded tenant" from an empty list here.
func (a *app) listEntitlements(ctx context.Context, r *request) (*reply, error) {
	session, err := a.requireSession(r)
	if err != nil {
		return nil, err
	}

	effective, err := a.fetchEntitlements(ctx, session.customerAlias)
	if err != nil {
		return nil, err
	}

	// Sequentially, so a cold metric cache is refreshed once rather than once per entry.
	entitlements := make([]Entitlement, 0, len(effective))
	for _, entitlement := range effective {
		normalized, err := a.normalizeEntitlement(ctx, entitlement)
		if err != nil {
			return nil, err
		}
		entitlements = append(entitlements, normalized)
	}

	return replyOK(EntitlementListResponse{Entitlements: entitlements})
}
