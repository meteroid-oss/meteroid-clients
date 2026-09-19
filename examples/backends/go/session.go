package main

import (
	"crypto/hmac"
	"crypto/sha256"
	"encoding/base64"
	"strings"
	"unicode/utf8"
)

// Demo session tokens.
//
// There is no real user auth in this demo — that is not what it teaches. A session
// token is a stateless HMAC over the Meteroid customer alias:
//
//	v1.<base64url(alias)>.<base64url(hmac_sha256(SCRIBE_SESSION_SECRET, alias))>
//
// Stateless and deterministic means every backend that shares the secret mints and
// accepts the same tokens, so one contract-suite session works against all of them.
// The Meteroid API key never leaves the backend.

// session is the workspace a request is acting on.
type session struct {
	// customerAlias is the Meteroid customer alias this workspace maps onto. Every
	// Meteroid call in this backend passes it where an idOrAlias is accepted.
	customerAlias string
}

func mintToken(secret, alias string) string {
	return "v1." + base64.RawURLEncoding.EncodeToString([]byte(alias)) +
		"." + base64.RawURLEncoding.EncodeToString(sign(secret, alias))
}

// verifyToken returns the customer alias the token is bound to, or the
// 401 UNAUTHORIZED the caller answers with.
func verifyToken(secret, token string) (string, error) {
	// Everything after the second dot is the signature, so a token with a fourth
	// segment fails to decode rather than being quietly truncated.
	parts := strings.SplitN(token, ".", 3)
	if len(parts) != 3 || parts[0] != "v1" {
		return "", unauthorized("Session token is malformed; expected `v1.<payload>.<signature>`.")
	}

	alias, ok := decodeBase64URL(parts[1])
	if !ok || !utf8.Valid(alias) {
		return "", unauthorized("Session token payload is not valid base64url UTF-8.")
	}
	signature, ok := decodeBase64URL(parts[2])
	if !ok {
		return "", unauthorized("Session token signature is not valid base64url.")
	}

	// hmac.Equal is the constant-time comparison.
	if !hmac.Equal(signature, sign(secret, string(alias))) {
		return "", unauthorized("Session token was not signed by this deployment.")
	}
	return string(alias), nil
}

func sign(secret, alias string) []byte {
	mac := hmac.New(sha256.New, []byte(secret))
	mac.Write([]byte(alias))
	return mac.Sum(nil)
}

// decodeBase64URL is strict unpadded base64url. Go's decoder skips `\r` and `\n`, and
// outside Strict mode ignores stray trailing bits, so a forged token could decode to
// *something*. Re-encoding and comparing is what makes this reject exactly what the
// other backends reject.
func decodeBase64URL(value string) ([]byte, bool) {
	decoded, err := base64.RawURLEncoding.DecodeString(value)
	if err != nil || base64.RawURLEncoding.EncodeToString(decoded) != value {
		return nil, false
	}
	return decoded, true
}

// requireSession comes first in a handler, and makes the route require a valid
// `Authorization: Bearer <session_token>` header.
func (a *app) requireSession(r *request) (session, error) {
	token := ""
	if value, ok := strings.CutPrefix(r.header.Get("Authorization"), "Bearer "); ok {
		token = strings.TrimSpace(value)
	}
	if token == "" {
		return session{}, unauthorized("Missing Authorization: Bearer <session_token> header.")
	}

	alias, err := verifyToken(a.config.sessionSecret, token)
	if err != nil {
		return session{}, err
	}
	return session{customerAlias: alias}, nil
}
