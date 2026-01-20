// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    available_parameters::AvailableParameters, plan_id::PlanId, plan_status_enum::PlanStatusEnum,
    plan_type_enum::PlanTypeEnum, plan_version_id::PlanVersionId, price_component::PriceComponent,
    product_family::ProductFamily, trial_config::TrialConfig,
};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct Plan {
    pub available_parameters: AvailableParameters,

    pub created_at: String,

    pub currency: String,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub description: Option<String>,

    pub id: PlanId,

    pub name: String,

    pub net_terms: i32,

    pub plan_type: PlanTypeEnum,

    pub price_components: Vec<PriceComponent>,

    pub product_family: ProductFamily,

    pub status: PlanStatusEnum,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub trial: Option<TrialConfig>,

    pub version: i32,

    pub version_id: PlanVersionId,
}

impl Plan {
    pub fn new(
        available_parameters: AvailableParameters,
        created_at: String,
        currency: String,
        id: PlanId,
        name: String,
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
            created_at,
            currency,
            description: None,
            id,
            name,
            net_terms,
            plan_type,
            price_components,
            product_family,
            status,
            trial: None,
            version,
            version_id,
        }
    }
}
