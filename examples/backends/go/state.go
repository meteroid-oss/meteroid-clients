package main

import (
	"context"
	"slices"
	"sync"

	meteroid "github.com/meteroid-oss/meteroid-clients/go"
)

// app is everything the handlers share: configuration, one Meteroid client, the catalog
// caches, and the in-memory transcription history. The handlers are its methods.
//
// There is exactly **one** meteroid.Client for the whole process. It holds nothing but
// the base URL, the API key and the retry policy, and net/http pools connections
// underneath it, so every handler simply uses a.meteroid.
type app struct {
	config         config
	meteroid       *meteroid.Client
	metrics        *metricCache
	transcriptions *transcriptionStore
	catalogCache   catalogCache
}

// newApp takes the client rather than building it so the tests can put a stub
// http.RoundTripper under the real SDK.
func newApp(config config, client *meteroid.Client) *app {
	return &app{
		config:         config,
		meteroid:       client,
		metrics:        &metricCache{},
		transcriptions: &transcriptionStore{},
	}
}

// catalog is the seeded Meteroid catalog, resolved on first use and cached afterwards.
// Only successes are cached, so seeding the tenant while the demo is running fixes it
// without a restart.
func (a *app) catalog(ctx context.Context) (*catalog, error) {
	return a.catalogCache.get(ctx, a.meteroid, a.metrics, string(a.config.defaultCurrency))
}

// transcriptionStore is the transcription history, per workspace.
//
// Deliberately in memory: Meteroid is the source of truth for *usage*, not for the
// application objects that produced it. Restarting the backend empties this; the usage
// it reported to Meteroid survives.
type transcriptionStore struct {
	mu          sync.Mutex
	byWorkspace map[string][]Transcription
}

func (s *transcriptionStore) record(customerAlias string, transcription Transcription) {
	s.mu.Lock()
	defer s.mu.Unlock()
	if s.byWorkspace == nil {
		s.byWorkspace = make(map[string][]Transcription)
	}
	s.byWorkspace[customerAlias] = append(s.byWorkspace[customerAlias], transcription)
}

// list is newest first, which is the order GET /api/transcriptions promises.
func (s *transcriptionStore) list(customerAlias string) []Transcription {
	s.mu.Lock()
	defer s.mu.Unlock()
	history := slices.Clone(s.byWorkspace[customerAlias])
	slices.Reverse(history)
	return history
}
