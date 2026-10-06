// this file is @generated
#![allow(clippy::doc_markdown, clippy::default_trait_access)]
#[allow(unused_imports, clippy::wildcard_imports)]
use crate::{error::Result, models::*, Configuration};

/// Query and header parameters of [`Features::list`].
#[derive(Clone, Debug, Default)]
#[non_exhaustive]
pub struct FeaturesListOptions {
    /// Filter by feature status. Repeat the param to select multiple, omit to return all.
    pub statuses: Option<Vec<FeatureStatus>>,
    /// Filter by product. Omit to return features across all products.
    pub product_id: Option<ProductId>,
    /// Search by feature name.
    pub search: Option<String>,
    /// Page number (0-indexed)
    pub page: Option<i32>,
    /// Number of items per page
    pub per_page: Option<i32>,
}

impl FeaturesListOptions {
    /// Options with no parameter set.
    #[must_use]
    pub fn new() -> Self {
        Self {
            statuses: None,
            product_id: None,
            search: None,
            page: None,
            per_page: None,
        }
    }

    /// Sets the `statuses` query parameter.
    #[must_use]
    pub fn statuses(mut self, statuses: impl Into<Vec<FeatureStatus>>) -> Self {
        self.statuses = Some(statuses.into());
        self
    }

    /// Sets the `product_id` query parameter.
    #[must_use]
    pub fn product_id(mut self, product_id: impl Into<ProductId>) -> Self {
        self.product_id = Some(product_id.into());
        self
    }

    /// Sets the `search` query parameter.
    #[must_use]
    pub fn search(mut self, search: impl Into<String>) -> Self {
        self.search = Some(search.into());
        self
    }

    /// Sets the `page` query parameter.
    #[must_use]
    pub fn page(mut self, page: impl Into<i32>) -> Self {
        self.page = Some(page.into());
        self
    }

    /// Sets the `per_page` query parameter.
    #[must_use]
    pub fn per_page(mut self, per_page: impl Into<i32>) -> Self {
        self.per_page = Some(per_page.into());
        self
    }
}

/// The features API, from the client's
/// [`features`](crate::api::Meteroid::features).
#[derive(Clone)]
pub struct Features {
    cfg: std::sync::Arc<Configuration>,
    options: crate::api::RequestOptions,
}

impl std::fmt::Debug for Features {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        f.debug_struct("Features")
            .field("options", &self.options)
            .finish_non_exhaustive()
    }
}

impl Features {
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

    /// List features
    ///
    /// `GET /api/v1/features`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (401, 429).
    pub fn list(
        &self,
        options: impl Into<Option<FeaturesListOptions>>,
    ) -> crate::api::Call<crate::models::FeatureListResponse> {
        let FeaturesListOptions {
            statuses,
            product_id,
            search,
            page,
            per_page,
        } = options.into().unwrap_or_default();

        crate::request::Request::new(http::Method::GET, "/api/v1/features")
            .with_optional_exploded_query_param("statuses", statuses)
            .with_optional_query_param("product_id", product_id)
            .with_optional_query_param("search", search)
            .with_optional_query_param("page", page)
            .with_optional_query_param("per_page", per_page)
            .with_options(&self.options)
            .json(&self.cfg)
    }

    /// Get feature details
    ///
    /// `GET /api/v1/features/{id_or_code}`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (401, 404, 429).
    pub fn retrieve(&self, id_or_code: &str) -> crate::api::Call<crate::models::Feature> {
        crate::request::Request::new(http::Method::GET, "/api/v1/features/{id_or_code}")
            .with_path_param("id_or_code", id_or_code)
            .with_options(&self.options)
            .json(&self.cfg)
    }
}
