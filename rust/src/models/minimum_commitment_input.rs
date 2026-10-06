// this file is @generated
use serde::{Deserialize, Serialize};

use super::minimum_commitment_input_scope::MinimumCommitmentInputScope;

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct MinimumCommitmentInput {
    /// Decimal string in the plan currency.
    pub amount: String,

    pub scope: MinimumCommitmentInputScope,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl MinimumCommitmentInput {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(amount: impl Into<String>, scope: MinimumCommitmentInputScope) -> Self {
        Self {
            amount: amount.into(),
            scope,
            extra: serde_json::Map::new(),
        }
    }
}
