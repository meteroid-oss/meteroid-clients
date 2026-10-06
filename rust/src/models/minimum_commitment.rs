// this file is @generated
use serde::{Deserialize, Serialize};

use super::minimum_commitment_scope::MinimumCommitmentScope;

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct MinimumCommitment {
    /// Decimal string in the plan currency, e.g. "100.00".
    pub amount: String,

    pub scope: MinimumCommitmentScope,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl MinimumCommitment {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(amount: impl Into<String>, scope: MinimumCommitmentScope) -> Self {
        Self {
            amount: amount.into(),
            scope,
            extra: serde_json::Map::new(),
        }
    }
}
