// this file is @generated
#![allow(clippy::doc_markdown, clippy::default_trait_access)]
#[allow(unused_imports, clippy::wildcard_imports)]
use crate::{error::Result, models::*, Configuration};

/// Query and header parameters of [`Usage::retrieve_customer`], built
/// with the required ones by [`new`](Self::new).
#[derive(Clone, Debug)]
#[non_exhaustive]
pub struct UsageRetrieveCustomerOptions {
    /// The `start_date` query parameter.
    pub start_date: chrono::NaiveDate,
    /// The `end_date` query parameter.
    pub end_date: chrono::NaiveDate,
    /// The `metric_id` query parameter.
    pub metric_id: Option<BillableMetricId>,
}

impl UsageRetrieveCustomerOptions {
    /// Options with the required parameters set.
    #[must_use]
    pub fn new(
        start_date: impl Into<chrono::NaiveDate>,
        end_date: impl Into<chrono::NaiveDate>,
    ) -> Self {
        Self {
            start_date: start_date.into(),
            end_date: end_date.into(),
            metric_id: None,
        }
    }

    /// Sets the `metric_id` query parameter.
    #[must_use]
    pub fn metric_id(mut self, metric_id: impl Into<BillableMetricId>) -> Self {
        self.metric_id = Some(metric_id.into());
        self
    }
}

/// Query and header parameters of [`Usage::retrieve_subscription`].
#[derive(Clone, Debug, Default)]
#[non_exhaustive]
pub struct UsageRetrieveSubscriptionOptions {
    /// The `start_date` query parameter.
    pub start_date: Option<chrono::NaiveDate>,
    /// The `end_date` query parameter.
    pub end_date: Option<chrono::NaiveDate>,
    /// The `metric_id` query parameter.
    pub metric_id: Option<BillableMetricId>,
}

impl UsageRetrieveSubscriptionOptions {
    /// Options with no parameter set.
    #[must_use]
    pub fn new() -> Self {
        Self {
            start_date: None,
            end_date: None,
            metric_id: None,
        }
    }

    /// Sets the `start_date` query parameter.
    #[must_use]
    pub fn start_date(mut self, start_date: impl Into<chrono::NaiveDate>) -> Self {
        self.start_date = Some(start_date.into());
        self
    }

    /// Sets the `end_date` query parameter.
    #[must_use]
    pub fn end_date(mut self, end_date: impl Into<chrono::NaiveDate>) -> Self {
        self.end_date = Some(end_date.into());
        self
    }

    /// Sets the `metric_id` query parameter.
    #[must_use]
    pub fn metric_id(mut self, metric_id: impl Into<BillableMetricId>) -> Self {
        self.metric_id = Some(metric_id.into());
        self
    }
}

/// Query and header parameters of [`Usage::retrieve_summary`], built
/// with the required ones by [`new`](Self::new).
#[derive(Clone, Debug)]
#[non_exhaustive]
pub struct UsageRetrieveSummaryOptions {
    /// The `start_date` query parameter.
    pub start_date: chrono::NaiveDate,
    /// The `end_date` query parameter.
    pub end_date: chrono::NaiveDate,
    /// The `metric_id` query parameter.
    pub metric_id: Option<BillableMetricId>,
}

impl UsageRetrieveSummaryOptions {
    /// Options with the required parameters set.
    #[must_use]
    pub fn new(
        start_date: impl Into<chrono::NaiveDate>,
        end_date: impl Into<chrono::NaiveDate>,
    ) -> Self {
        Self {
            start_date: start_date.into(),
            end_date: end_date.into(),
            metric_id: None,
        }
    }

    /// Sets the `metric_id` query parameter.
    #[must_use]
    pub fn metric_id(mut self, metric_id: impl Into<BillableMetricId>) -> Self {
        self.metric_id = Some(metric_id.into());
        self
    }
}

/// The usage API, from the client's
/// [`usage`](crate::api::Meteroid::usage).
#[derive(Clone)]
pub struct Usage {
    cfg: std::sync::Arc<Configuration>,
    options: crate::api::RequestOptions,
}

impl std::fmt::Debug for Usage {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        f.debug_struct("Usage")
            .field("options", &self.options)
            .finish_non_exhaustive()
    }
}

impl Usage {
    pub(super) fn new(cfg: std::sync::Arc<Configuration>) -> Self {
        Self {
            cfg,
            options: crate::api::RequestOptions::default(),
        }
    }

    /// Applies `options` (headers, timeout, retries, idempotency key) to the calls made
    /// through the returned value.
    #[must_use]
    pub fn with_options(mut self, options: crate::api::RequestOptions) -> Self {
        self.options = options;
        self
    }

    /// Get customer usage
    ///
    /// Retrieve aggregated usage data for a customer over a specified period.
    ///
    /// `GET /api/v1/usage/customer/{customer_id}`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (401, 404, 429, 500).
    pub fn retrieve_customer(
        &self,
        customer_id: &str,
        options: UsageRetrieveCustomerOptions,
    ) -> crate::api::Call<crate::models::UsageResponse> {
        let UsageRetrieveCustomerOptions {
            start_date,
            end_date,
            metric_id,
        } = options;

        crate::request::Request::new(http::Method::GET, "/api/v1/usage/customer/{customer_id}")
            .with_path_param("customer_id", customer_id)
            .with_query_param("start_date", &start_date)
            .with_query_param("end_date", &end_date)
            .with_optional_query_param("metric_id", metric_id)
            .with_options(&self.options)
            .json(&self.cfg)
    }

    /// Get subscription usage
    ///
    /// Retrieve aggregated usage data for a subscription's usage-based components.
    /// If start_date/end_date are omitted, defaults to the current billing period.
    ///
    /// `GET /api/v1/usage/subscription/{subscription_id}`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (401, 404, 429, 500).
    pub fn retrieve_subscription(
        &self,
        subscription_id: &str,
        options: impl Into<Option<UsageRetrieveSubscriptionOptions>>,
    ) -> crate::api::Call<crate::models::UsageResponse> {
        let UsageRetrieveSubscriptionOptions {
            start_date,
            end_date,
            metric_id,
        } = options.into().unwrap_or_default();

        crate::request::Request::new(
            http::Method::GET,
            "/api/v1/usage/subscription/{subscription_id}",
        )
        .with_path_param("subscription_id", subscription_id)
        .with_optional_query_param("start_date", start_date)
        .with_optional_query_param("end_date", end_date)
        .with_optional_query_param("metric_id", metric_id)
        .with_options(&self.options)
        .json(&self.cfg)
    }

    /// Get usage summary
    ///
    /// Retrieve aggregated usage data across all customers for the tenant.
    ///
    /// `GET /api/v1/usage/summary`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (401, 429, 500).
    pub fn retrieve_summary(
        &self,
        options: UsageRetrieveSummaryOptions,
    ) -> crate::api::Call<crate::models::UsageResponse> {
        let UsageRetrieveSummaryOptions {
            start_date,
            end_date,
            metric_id,
        } = options;

        crate::request::Request::new(http::Method::GET, "/api/v1/usage/summary")
            .with_query_param("start_date", &start_date)
            .with_query_param("end_date", &end_date)
            .with_optional_query_param("metric_id", metric_id)
            .with_options(&self.options)
            .json(&self.cfg)
    }
}
