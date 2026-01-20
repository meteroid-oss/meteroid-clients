// this file is @generated
#[allow(unused_imports)]
use crate::{error::Result, models::*, Configuration};

#[derive(Default)]
pub struct PlanListPlansOptions {
    pub product_family_id: Option<ProductFamilyId>,

    /// Page number (0-indexed)
    pub page: Option<i32>,

    /// Number of items per page
    pub per_page: Option<i32>,
}

pub struct Plan<'a> {
    cfg: &'a Configuration,
}

impl<'a> Plan<'a> {
    pub(super) fn new(cfg: &'a Configuration) -> Self {
        Self { cfg }
    }

    /// List plans with optional filtering by product family.
    pub async fn list_plans(
        &self,
        options: Option<PlanListPlansOptions>,
    ) -> Result<crate::models::PlanListResponse> {
        let PlanListPlansOptions {
            product_family_id,
            page,
            per_page,
        } = options.unwrap_or_default();

        crate::request::Request::new(http1::Method::GET, "/api/v1/plans")
            .with_optional_query_param("product_family_id", product_family_id)
            .with_optional_query_param("page", page)
            .with_optional_query_param("per_page", per_page)
            .execute(self.cfg)
            .await
    }

    /// Retrieve the details of a specific plan
    pub async fn get_plan_details(&self, plan_id: String) -> Result<crate::models::Plan> {
        crate::request::Request::new(http1::Method::GET, "/api/v1/plans/{plan_id}")
            .with_path_param("plan_id", plan_id)
            .execute(self.cfg)
            .await
    }
}
