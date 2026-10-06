// this file is @generated
use serde::{Deserialize, Serialize};

use super::{o_auth_app_id::OAuthAppId, organization_id::OrganizationId};

/// An OAuth application registered by a platform
#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct OAuthApp {
    pub client_id: String,

    pub client_secret_hint: String,

    pub created_at: chrono::DateTime<chrono::Utc>,

    pub id: OAuthAppId,

    pub is_active: bool,

    pub name: String,

    pub organization_id: OrganizationId,

    pub redirect_uris: Vec<String>,

    pub scopes: Vec<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub updated_at: Option<chrono::DateTime<chrono::Utc>>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl OAuthApp {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        client_id: impl Into<String>,
        client_secret_hint: impl Into<String>,
        created_at: chrono::DateTime<chrono::Utc>,
        id: OAuthAppId,
        is_active: bool,
        name: impl Into<String>,
        organization_id: OrganizationId,
        redirect_uris: Vec<String>,
        scopes: Vec<String>,
    ) -> Self {
        Self {
            client_id: client_id.into(),
            client_secret_hint: client_secret_hint.into(),
            created_at,
            id,
            is_active,
            name: name.into(),
            organization_id,
            redirect_uris,
            scopes,
            updated_at: None,
            extra: serde_json::Map::new(),
        }
    }
}
