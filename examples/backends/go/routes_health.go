package main

import "context"

// version is this backend's own, reported by GET /api/health. A `go run` binary has no
// build version to read back, so it is spelled out.
const version = "1.0.0"

// getHealth is `GET /api/health` — the unauthenticated liveness and configuration probe.
func (a *app) getHealth(context.Context, *request) (*reply, error) {
	return replyOK(Health{
		Status:  "ok",
		Backend: "go",
		// False means METEROID_API_KEY (or the base URL) is missing, and every
		// Meteroid-backed operation below will fail with UPSTREAM_UNAUTHORIZED.
		// Reporting it here is what turns a wall of 502s into one clear message.
		MeteroidConfigured: a.config.meteroidConfigured(),
		Version:            ptr(version),
	})
}
