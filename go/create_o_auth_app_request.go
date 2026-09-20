// this file is @generated
package meteroid

type CreateOAuthAppRequest struct {
	Name string `json:"name"`

	RedirectUris RequiredSlice[string] `json:"redirect_uris"`

	Scopes []string `json:"scopes,omitempty"`
}
