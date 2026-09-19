// Scribe — the Go backend for the Meteroid SDK demo.
//
// Implements every operation of examples/openapi.yaml on top of the Meteroid Go SDK.
// Read the handlers in the routes_*.go files; each one is written so that the Meteroid
// SDK call is the line worth reading, and everything around it is framing.
//
// Start here:
//
//   - routes_transcriptions.go — the metered action: check the entitlement, then report
//     the consumption. This is what the demo exists to show.
//   - entitlements.go — normalizing Meteroid's three-way entitlement union.
//   - catalog.go — resolving a catalog the demo never creates.
//   - routes_webhooks.go — verifying a Standard Webhooks signature over raw bytes.
package main

import (
	"context"
	"errors"
	"fmt"
	"log/slog"
	"net"
	"net/http"
	"os"
	"os/signal"
	"strings"
	"syscall"
	"time"
)

func main() {
	// A configuration error is the operator's to fix and there is nothing useful to
	// serve without it, so say what is wrong and stop.
	config, err := configFromEnv(os.Getenv)
	if err != nil {
		slog.Error(err.Error())
		os.Exit(1)
	}

	if !config.meteroidConfigured() {
		slog.Warn("METEROID_API_KEY is not set. The server will start and GET /api/health will report " +
			"meteroid_configured=false, but every Meteroid-backed operation will fail. " +
			"See examples/.env.example.")
	}

	app := newApp(config, config.meteroidClient())
	server := &http.Server{
		Handler: app.router(),
		// Bodies are buffered whole (they are capped at 2 MiB), so only the headers
		// need a deadline of their own.
		ReadHeaderTimeout: 10 * time.Second,
	}

	address := fmt.Sprintf("0.0.0.0:%d", config.port)
	listener, err := net.Listen("tcp", address)
	if err != nil {
		slog.Error(fmt.Sprintf("Cannot bind %s: %v", address, err))
		os.Exit(1)
	}
	slog.Info(fmt.Sprintf("Scribe (go) listening on http://localhost:%d", config.port))

	ctx, stop := signal.NotifyContext(context.Background(), os.Interrupt, syscall.SIGTERM)
	defer stop()

	// Probe the catalog once the port is open rather than before binding: an unreachable
	// Meteroid would otherwise hold it closed for the length of the SDK's retry
	// schedule, and GET /api/health is exactly what you want answering during that.
	go app.probeCatalog(ctx)

	go func() {
		<-ctx.Done()
		slog.Info("Shutting down.")
		// Keep-alive connections would otherwise hold Shutdown open indefinitely.
		deadline, cancel := context.WithTimeout(context.Background(), 5*time.Second)
		defer cancel()
		_ = server.Shutdown(deadline)
	}()

	if err := server.Serve(listener); !errors.Is(err, http.ErrServerClosed) {
		slog.Error(fmt.Sprintf("Server error: %v", err))
		os.Exit(1)
	}
}

// probeCatalog resolves the seeded catalog once at boot.
//
// This is not a hard requirement to start — the process stays up so that
// GET /api/health answers and so that seeding the tenant fixes things without a
// restart — but it turns "my first transcription says I'm not entitled" into an
// unmissable startup error naming the object that is missing.
func (a *app) probeCatalog(ctx context.Context) {
	if !a.config.meteroidConfigured() {
		return
	}
	catalog, err := a.catalog(ctx)
	if err != nil {
		slog.Error(fmt.Sprintf("Meteroid catalog is not usable yet: %v\n"+
			"The demo never creates catalog objects — seed them once, by hand, as described in "+
			"examples/CATALOG.md. Requests that need the catalog will keep returning "+
			"503 CATALOG_NOT_SEEDED until it is there.", err))
		return
	}

	names := make([]string, 0, len(catalog.plans))
	for _, plan := range catalog.plans {
		names = append(names, plan.Name)
	}
	slog.Info(fmt.Sprintf("Meteroid catalog resolved: %d plans (%s).", len(names), strings.Join(names, ", ")))
}
