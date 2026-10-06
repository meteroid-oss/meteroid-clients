// this file is @generated
use serde::{Deserialize, Serialize};

use super::extra_recurring_billing_type_enum::ExtraRecurringBillingTypeEnum;

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct ExtraRecurringFeeStructure {
    pub billing_type: ExtraRecurringBillingTypeEnum,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl ExtraRecurringFeeStructure {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(billing_type: ExtraRecurringBillingTypeEnum) -> Self {
        Self {
            billing_type,
            extra: serde_json::Map::new(),
        }
    }
}
