// this file is @generated
package meteroid

// Result of creating an OAuth app (includes the plain-text secret)
type OAuthAppWithSecret struct {
	App OAuthApp `json:"app"`

	ClientSecret string `json:"client_secret"`
}
