// this file is @generated
use serde::{Deserialize, Serialize};

use super::payment_method_type_enum::PaymentMethodTypeEnum;

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct PaymentMethodInfo {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub account_number_hint: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub card_brand: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub card_last4: Option<String>,

    pub payment_method_type: PaymentMethodTypeEnum,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl PaymentMethodInfo {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(payment_method_type: PaymentMethodTypeEnum) -> Self {
        Self {
            account_number_hint: None,
            card_brand: None,
            card_last4: None,
            payment_method_type,
            extra: serde_json::Map::new(),
        }
    }
}
