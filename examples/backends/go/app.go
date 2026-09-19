package main

import (
	"bytes"
	"context"
	"encoding/json"
	"errors"
	"io"
	"log/slog"
	"net/http"
	"strconv"
	"strings"
	"unicode/utf8"
)

// The whole HTTP layer: net/http and nothing else.
//
// A web framework would be the largest thing in this backend, and the point of the demo
// is the Meteroid call inside each handler. What a handler needs is small — the headers,
// the query string, and the **raw** body bytes (webhook signatures are computed over
// bytes, so nothing may parse the body first) — and it fits in the request type below.
//
// Twelve operations are one table, not an http.ServeMux, because the contract pins down
// the edges a mux decides for itself: ServeMux redirects `/api//health` instead of
// answering 404, and writes "Method Not Allowed" as text where every backend here
// answers a bare 405.

// maxBodyBytes is what axum buffers by default, so an oversized body is refused at the
// same size by every backend.
const maxBodyBytes = 2 * 1024 * 1024

// request is what a handler sees of an *http.Request.
type request struct {
	header http.Header
	// query is the raw query string; only GET /api/invoices looks at it.
	query string
	// body is exactly as it arrived. Empty when tooLarge.
	body     []byte
	tooLarge bool
}

// reply is what a handler returns: a status and the contract object to serialize.
type reply struct {
	status int
	body   any
}

func replyOK(body any) (*reply, error)       { return &reply{http.StatusOK, body}, nil }
func replyCreated(body any) (*reply, error)  { return &reply{http.StatusCreated, body}, nil }
func replyAccepted(body any) (*reply, error) { return &reply{http.StatusAccepted, body}, nil }

type handler func(ctx context.Context, r *request) (*reply, error)

// route is the handlers of one path, by method.
type route map[string]handler

// allow is the `Allow` header of a route. HEAD is GET without the body.
func (r route) allow() string {
	var methods []string
	if r[http.MethodGet] != nil {
		methods = append(methods, "GET", "HEAD")
	}
	if r[http.MethodPost] != nil {
		methods = append(methods, "POST")
	}
	return strings.Join(methods, ",")
}

func (a *app) routes() map[string]route {
	return map[string]route{
		"/api/health":            {http.MethodGet: a.getHealth},
		"/api/session":           {http.MethodPost: a.createSession},
		"/api/me":                {http.MethodGet: a.getMe},
		"/api/plans":             {http.MethodGet: a.listPlans},
		"/api/checkout":          {http.MethodPost: a.createCheckout},
		"/api/entitlements":      {http.MethodGet: a.listEntitlements},
		"/api/transcriptions":    {http.MethodGet: a.listTranscriptions, http.MethodPost: a.createTranscription},
		"/api/usage":             {http.MethodGet: a.getUsage},
		"/api/portal-session":    {http.MethodPost: a.createPortalSession},
		"/api/invoices":          {http.MethodGet: a.listInvoices},
		"/api/webhooks/meteroid": {http.MethodPost: a.receiveWebhook},
	}
}

// router puts the app behind an http.Handler. It needs no socket, so main.go serves it
// and the tests call it with an httptest.ResponseRecorder.
func (a *app) router() http.Handler {
	routes := a.routes()

	return http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		// The SPA is served from its own origin (the Vite dev server), so it needs CORS.
		// Permissive is fine for a demo; a real backend would name its origins.
		w.Header().Set("Vary", "origin, access-control-request-method, access-control-request-headers")
		w.Header().Set("Access-Control-Allow-Origin", "*")

		// The escaped path, matched exactly: no cleaning, no trailing-slash redirect, and
		// `/api/%68ealth` is not `/api/health`.
		route, known := routes[r.URL.EscapedPath()]

		// Every OPTIONS is answered as a preflight, whether or not the path exists: the
		// browser only wants to know it may send the real request.
		if r.Method == http.MethodOptions {
			if known {
				w.Header().Set("Allow", route.allow())
			}
			w.Header().Set("Access-Control-Allow-Methods", "*")
			w.Header().Set("Access-Control-Allow-Headers", "*")
			w.Header().Set("Content-Length", "0")
			w.WriteHeader(http.StatusOK)
			return
		}
		w.Header().Set("Access-Control-Expose-Headers", "*")

		// net/http drops the body of a HEAD response on its own.
		method := r.Method
		if method == http.MethodHead {
			method = http.MethodGet
		}
		handle := route[method]

		// A known path with the wrong method. There is no error code for it in the
		// contract, so it is the bare 405 + Allow that HTTP itself specifies.
		if known && handle == nil {
			w.Header().Set("Allow", route.allow())
			w.Header().Set("Content-Length", "0")
			w.WriteHeader(http.StatusMethodNotAllowed)
			return
		}
		if !known {
			handle = notFound
		}

		request, err := readRequest(r)
		if err != nil {
			// The client went away mid-request; there is nobody to answer.
			return
		}
		status, body := run(r, request, handle)
		writeJSON(w, status, body)
	})
}

// readRequest buffers the body up to the limit. An oversized body is still read to the
// end, just not kept: answering before the client has finished sending makes most
// clients report a broken pipe, not the 413. Whether it *is* a 413 is up to rawBody, so
// that a request with no session token is a 401 whatever its body looks like.
func readRequest(r *http.Request) (*request, error) {
	body, err := io.ReadAll(io.LimitReader(r.Body, maxBodyBytes+1))
	if err != nil {
		return nil, err
	}
	request := &request{header: r.Header, query: r.URL.RawQuery, body: body}
	if len(body) > maxBodyBytes {
		request.body, request.tooLarge = nil, true
		if _, err := io.Copy(io.Discard, r.Body); err != nil {
			return nil, err
		}
	}
	return request, nil
}

// run one handler; whatever goes wrong comes back as the contract's error envelope.
func run(r *http.Request, request *request, handle handler) (status int, body any) {
	unexpected := func(detail any) (int, any) {
		// A bug in this backend. The detail goes to the log, never to the client.
		slog.Error("unhandled error", "method", r.Method, "path", r.URL.Path, "error", detail)
		internal := internalError("Unexpected error handling the request.")
		return internal.httpStatus(), internal
	}
	defer func() {
		if panicked := recover(); panicked != nil {
			status, body = unexpected(panicked)
		}
	}()

	reply, err := handle(r.Context(), request)
	if err == nil {
		return reply.status, reply.body
	}
	var apiErr *apiError
	if !errors.As(err, &apiErr) {
		return unexpected(err)
	}
	if apiErr.Code == codeInternal {
		slog.Error("internal error", "message", apiErr.Message)
	}
	return apiErr.httpStatus(), apiErr
}

func writeJSON(w http.ResponseWriter, status int, body any) {
	var buffer bytes.Buffer
	encoder := json.NewEncoder(&buffer)
	// The default escapes `<` and `>`, which would mangle "Bearer <session_token>".
	encoder.SetEscapeHTML(false)
	if err := encoder.Encode(body); err != nil {
		slog.Error("cannot serialize a response", "error", err)
		status, body = http.StatusInternalServerError, internalError("Unexpected error handling the request.")
		buffer.Reset()
		_ = encoder.Encode(body)
	}
	payload := bytes.TrimSuffix(buffer.Bytes(), []byte("\n"))

	w.Header().Set("Content-Type", "application/json")
	w.Header().Set("Content-Length", strconv.Itoa(len(payload)))
	w.WriteHeader(status)
	_, _ = w.Write(payload)
}

// notFound is the 404 for an unmatched route, in the standard envelope. No operation in
// the contract takes a path parameter, so this only ever fires on a typo.
func notFound(context.Context, *request) (*reply, error) {
	return nil, newAPIError(codeNotFound,
		"No such endpoint. See examples/openapi.yaml for the operations this demo serves.")
}

// rawBody is the raw request body, for the handlers that read one.
func (r *request) rawBody() ([]byte, error) {
	if r.tooLarge {
		return nil, badRequest("The request body exceeds the %d-byte limit.", maxBodyBytes).
			withStatus(http.StatusRequestEntityTooLarge)
	}
	return r.body, nil
}

// jsonBody parses a **required** JSON request body, with decode checking it against the
// contract's schema. Every failure is the contract's 400 envelope.
func jsonBody[T any](r *request, decode func(any) (T, error)) (T, error) {
	var zero T
	body, err := r.rawBody()
	if err != nil {
		return zero, err
	}
	if len(body) == 0 {
		return zero, badRequest("A JSON request body is required.")
	}
	value, err := parseJSON(body)
	if err != nil {
		return zero, err
	}
	return decode(value)
}

// optionalJSONBody parses an **optional** JSON request body.
//
// The contract states that for these operations no body, an empty body, `{}` and
// `{"field": null}` all mean the same thing: use the defaults. That rule is literally
// this function.
func optionalJSONBody[T any](r *request, decode func(any) (T, error)) (T, error) {
	var zero T
	body, err := r.rawBody()
	if err != nil {
		return zero, err
	}
	if len(bytes.Trim(body, " \t\n\f\r")) == 0 {
		return decode(map[string]any{})
	}
	value, err := parseJSON(body)
	if err != nil {
		return zero, err
	}
	return decode(value)
}

// bounded trims a string field and rejects it when it is empty or too long.
func bounded(field, value string, limit int) (string, error) {
	trimmed := strings.TrimSpace(value)
	if trimmed == "" {
		return "", badRequest("%s must not be empty.", field)
	}
	// Code points, not bytes: an emoji is one character of the limit, not four.
	if utf8.RuneCountInString(trimmed) > limit {
		return "", badRequest("%s must be at most %d characters.", field, limit)
	}
	return trimmed, nil
}
