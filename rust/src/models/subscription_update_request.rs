// this file is @generated
use serde::{Deserialize, Serialize};

use super::payment_methods_config::PaymentMethodsConfig;

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct SubscriptionUpdateRequest {
    /// If false, invoices will stay in Draft until manually reviewed and finalized.
    #[serde(
        default,
        skip_serializing_if = "Option::is_none",
        deserialize_with = "crate::models::codec::nullable"
    )]
    pub auto_advance_invoices: Option<Option<bool>>,

    /// Automatically try to charge the customer's configured payment method on finalize.
    #[serde(
        default,
        skip_serializing_if = "Option::is_none",
        deserialize_with = "crate::models::codec::nullable"
    )]
    pub charge_automatically: Option<Option<bool>>,

    /// Partial update of custom property values (merge; send a key with `null` to remove it).
    /// Validated against the tenant's `SUBSCRIPTION` property definitions. Omit to leave unchanged.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub custom_properties: Option<serde_json::Value>,

    /// Default memo for invoices
    #[serde(
        default,
        skip_serializing_if = "Option::is_none",
        deserialize_with = "crate::models::codec::nullable"
    )]
    pub invoice_memo: Option<Option<String>>,

    /// Payment terms in days (0 = due on issue)
    #[serde(
        default,
        skip_serializing_if = "Option::is_none",
        deserialize_with = "crate::models::codec::nullable"
    )]
    pub net_terms: Option<Option<i32>>,

    #[serde(
        default,
        skip_serializing_if = "Option::is_none",
        deserialize_with = "crate::models::codec::nullable"
    )]
    pub payment_methods_config: Option<Option<PaymentMethodsConfig>>,

    /// Purchase order number
    #[serde(
        default,
        skip_serializing_if = "Option::is_none",
        deserialize_with = "crate::models::codec::nullable"
    )]
    pub purchase_order: Option<Option<String>>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl SubscriptionUpdateRequest {
    /// Creates a value with every field unset.
    #[must_use]
    pub fn new() -> Self {
        Self {
            auto_advance_invoices: None,
            charge_automatically: None,
            custom_properties: None,
            invoice_memo: None,
            net_terms: None,
            payment_methods_config: None,
            purchase_order: None,
            extra: serde_json::Map::new(),
        }
    }
}
