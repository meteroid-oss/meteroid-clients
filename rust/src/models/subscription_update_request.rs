// this file is @generated
use serde::{Deserialize, Serialize};

use super::payment_methods_config::PaymentMethodsConfig;

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct SubscriptionUpdateRequest {
    /// If false, invoices will stay in Draft until manually reviewed and finalized.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub auto_advance_invoices: Option<bool>,

    /// Automatically try to charge the customer's configured payment method on finalize.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub charge_automatically: Option<bool>,

    /// Default memo for invoices
    #[serde(skip_serializing_if = "Option::is_none")]
    pub invoice_memo: Option<String>,

    /// Payment terms in days (0 = due on issue)
    #[serde(skip_serializing_if = "Option::is_none")]
    pub net_terms: Option<i32>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub payment_methods_config: Option<PaymentMethodsConfig>,

    /// Purchase order number
    #[serde(skip_serializing_if = "Option::is_none")]
    pub purchase_order: Option<String>,
}

impl SubscriptionUpdateRequest {
    pub fn new() -> Self {
        Self {
            auto_advance_invoices: None,
            charge_automatically: None,
            invoice_memo: None,
            net_terms: None,
            payment_methods_config: None,
            purchase_order: None,
        }
    }
}
