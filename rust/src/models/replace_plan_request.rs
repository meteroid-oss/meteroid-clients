// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    billing_config::BillingConfig, minimum_commitment_input::MinimumCommitmentInput,
    plan_add_on_input::PlanAddOnInput, plan_status_enum::PlanStatusEnum,
    price_component_input::PriceComponentInput, trial_config::TrialConfig,
};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct ReplacePlanRequest {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub add_ons: Option<Vec<PlanAddOnInput>>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub billing: Option<BillingConfig>,

    pub components: Vec<PriceComponentInput>,

    pub currency: String,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub description: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub minimum_commitment: Option<MinimumCommitmentInput>,

    pub name: String,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub status: Option<PlanStatusEnum>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub trial: Option<TrialConfig>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl ReplacePlanRequest {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        components: Vec<PriceComponentInput>,
        currency: impl Into<String>,
        name: impl Into<String>,
    ) -> Self {
        Self {
            add_ons: None,
            billing: None,
            components,
            currency: currency.into(),
            description: None,
            minimum_commitment: None,
            name: name.into(),
            status: None,
            trial: None,
            extra: serde_json::Map::new(),
        }
    }
}
