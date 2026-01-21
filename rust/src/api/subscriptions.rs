// this file is @generated
#[allow(unused_imports)]
use crate::{error::Result, models::*, Configuration};

#[derive(Default)]
pub struct SubscriptionsListSubscriptionsOptions {
    /// Filter by customer ID or alias
    pub customer_id: Option<String>,

    pub plan_id: Option<PlanId>,

    pub statuses: Option<Vec<SubscriptionStatusEnum>>,

    /// Page number (0-indexed)
    pub page: Option<i32>,

    /// Number of items per page
    pub per_page: Option<i32>,
}

pub struct Subscriptions<'a> {
    cfg: &'a Configuration,
}

impl<'a> Subscriptions<'a> {
    pub(super) fn new(cfg: &'a Configuration) -> Self {
        Self { cfg }
    }

    /// List subscriptions with optional filtering by customer or plan.
    pub async fn list_subscriptions(
        &self,
        options: Option<SubscriptionsListSubscriptionsOptions>,
    ) -> Result<crate::models::SubscriptionListResponse> {
        let SubscriptionsListSubscriptionsOptions {
            customer_id,
            plan_id,
            statuses,
            page,
            per_page,
        } = options.unwrap_or_default();

        crate::request::Request::new(http1::Method::GET, "/api/v1/subscriptions")
            .with_optional_query_param("customer_id", customer_id)
            .with_optional_query_param("plan_id", plan_id)
            .with_optional_query_param("statuses", statuses)
            .with_optional_query_param("page", page)
            .with_optional_query_param("per_page", per_page)
            .execute(self.cfg)
            .await
    }

    /// Create a new subscription for a customer with a specific plan.
    pub async fn create_subscription(
        &self,
        subscription_create_request: crate::models::SubscriptionCreateRequest,
    ) -> Result<crate::models::SubscriptionDetails> {
        crate::request::Request::new(http1::Method::POST, "/api/v1/subscriptions")
            .with_body_param(subscription_create_request)
            .execute(self.cfg)
            .await
    }

    /// Retrieve detailed information about a subscription including price components and schedules.
    pub async fn subscription_details(
        &self,
        id: String,
    ) -> Result<crate::models::SubscriptionDetails> {
        crate::request::Request::new(http1::Method::GET, "/api/v1/subscriptions/{id}")
            .with_path_param("id", id)
            .execute(self.cfg)
            .await
    }

    /// Cancel a subscription either immediately or at the end of the billing period.
    pub async fn cancel_subscription(
        &self,
        subscription_id: String,
        cancel_subscription_request: crate::models::CancelSubscriptionRequest,
    ) -> Result<crate::models::CancelSubscriptionResponse> {
        crate::request::Request::new(
            http1::Method::POST,
            "/api/v1/subscriptions/{subscription_id}/cancel",
        )
        .with_path_param("subscription_id", subscription_id)
        .with_body_param(cancel_subscription_request)
        .execute(self.cfg)
        .await
    }
}
