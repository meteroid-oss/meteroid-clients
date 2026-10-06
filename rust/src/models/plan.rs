// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    available_parameters::AvailableParameters, entitlement::Entitlement,
    minimum_commitment::MinimumCommitment, plan_id::PlanId, plan_status_enum::PlanStatusEnum,
    plan_type_enum::PlanTypeEnum, plan_version_id::PlanVersionId, price_component::PriceComponent,
    product_family::ProductFamily, trial_config::TrialConfig,
};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct Plan {
    pub available_parameters: AvailableParameters,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub billing_cycles: Option<i32>,

    pub created_at: chrono::DateTime<chrono::Utc>,

    pub currency: String,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub description: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub entitlements: Option<Vec<Entitlement>>,

    pub id: PlanId,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub minimum_commitment: Option<MinimumCommitment>,

    pub name: String,

    pub net_terms: i32,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub period_start_day: Option<i32>,

    pub plan_type: PlanTypeEnum,

    pub price_components: Vec<PriceComponent>,

    pub product_family: ProductFamily,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub self_service_rank: Option<i32>,

    pub status: PlanStatusEnum,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub trial: Option<TrialConfig>,

    pub version: i32,

    pub version_id: PlanVersionId,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl Plan {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        available_parameters: AvailableParameters,
        created_at: chrono::DateTime<chrono::Utc>,
        currency: impl Into<String>,
        id: PlanId,
        name: impl Into<String>,
        net_terms: i32,
        plan_type: PlanTypeEnum,
        price_components: Vec<PriceComponent>,
        product_family: ProductFamily,
        status: PlanStatusEnum,
        version: i32,
        version_id: PlanVersionId,
    ) -> Self {
        Self {
            available_parameters,
            billing_cycles: None,
            created_at,
            currency: currency.into(),
            description: None,
            entitlements: None,
            id,
            minimum_commitment: None,
            name: name.into(),
            net_terms,
            period_start_day: None,
            plan_type,
            price_components,
            product_family,
            self_service_rank: None,
            status,
            trial: None,
            version,
            version_id,
            extra: serde_json::Map::new(),
        }
    }
}
