// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    billing_config::BillingConfig, plan_add_on_input::PlanAddOnInput,
    plan_status_enum::PlanStatusEnum, plan_type_enum::PlanTypeEnum,
    price_component_input::PriceComponentInput, product_family_id::ProductFamilyId,
    trial_config::TrialConfig,
};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct CreatePlanRequest {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub add_ons: Option<Vec<PlanAddOnInput>>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub billing: Option<BillingConfig>,

    pub components: Vec<PriceComponentInput>,

    pub currency: String,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub description: Option<String>,

    pub name: String,

    pub plan_type: PlanTypeEnum,

    pub product_family_id: ProductFamilyId,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub self_service_rank: Option<i32>,

    pub status: PlanStatusEnum,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub trial: Option<TrialConfig>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl CreatePlanRequest {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        components: Vec<PriceComponentInput>,
        currency: impl Into<String>,
        name: impl Into<String>,
        plan_type: PlanTypeEnum,
        product_family_id: ProductFamilyId,
        status: PlanStatusEnum,
    ) -> Self {
        Self {
            add_ons: None,
            billing: None,
            components,
            currency: currency.into(),
            description: None,
            name: name.into(),
            plan_type,
            product_family_id,
            self_service_rank: None,
            status,
            trial: None,
            extra: serde_json::Map::new(),
        }
    }
}
