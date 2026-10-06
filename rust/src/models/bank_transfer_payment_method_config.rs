// this file is @generated
use serde::{Deserialize, Serialize};

use super::bank_account_id::BankAccountId;

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct BankTransferPaymentMethodConfig {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub account_id: Option<BankAccountId>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl BankTransferPaymentMethodConfig {
    /// Creates a value with every field unset.
    #[must_use]
    pub fn new() -> Self {
        Self {
            account_id: None,
            extra: serde_json::Map::new(),
        }
    }
}
