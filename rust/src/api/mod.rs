// this file is @generated
//! The [`Meteroid`] client, its resources and what their calls take and return.
#[path = "../call.rs"]
mod call;
pub mod client;
#[path = "../event_stream.rs"]
mod event_stream;
#[path = "../middleware.rs"]
pub mod middleware;
#[path = "../upload.rs"]
pub mod upload;
pub use crate::connector::{http_client, HttpClient};
pub use call::{ApiResponse, Call};
pub use event_stream::{EventStream, SseEvent};
pub use upload::{RequestBody, Upload};
#[path = "../auth_schemes.rs"]
pub(crate) mod auth_schemes;
pub use auth_schemes::{BasicAuth, TokenProvider};
#[path = "../pagination.rs"]
pub(crate) mod pagination;
pub use pagination::{Page, Pages, Paginator};
#[path = "../request_options.rs"]
mod request_options;
pub use request_options::RequestOptions;

/// The `http` crate, whose `HeaderMap`, `StatusCode` and `Method` the API uses.
pub use ::http;
pub use bytes::Bytes;

/// The error body nearly every operation documents.
pub type ErrorBody = crate::models::RestErrorResponse;

mod add_ons;
mod batch_jobs;
mod checkout_sessions;
mod connect;
mod coupons;
mod credit_notes;
mod custom_properties;
mod customers;
mod events;
mod features;
mod invoices;
mod metrics;
mod oauth;
mod oauth_apps;
mod plans;
mod product_families;
mod products;
mod subscriptions;
mod usage;

pub use self::{
    add_ons::{AddOns, AddOnsListOptions},
    batch_jobs::{BatchJobs, BatchJobsListFailuresOptions, BatchJobsListOptions},
    checkout_sessions::{CheckoutSessions, CheckoutSessionsListOptions},
    client::{Meteroid, MeteroidBuilder},
    connect::Connect,
    coupons::{Coupons, CouponsListOptions},
    credit_notes::{CreditNotes, CreditNotesListOptions},
    custom_properties::{CustomProperties, CustomPropertiesListCustomPropertyDefinitionsOptions},
    customers::{Customers, CustomersListOptions},
    events::Events,
    features::{Features, FeaturesListOptions},
    invoices::{Invoices, InvoicesListOptions},
    metrics::{Metrics, MetricsListOptions},
    oauth::Oauth,
    oauth_apps::OauthApps,
    plans::{Plans, PlansListOptions, PlansListVersionsOptions, PlansRetrieveOptions},
    product_families::{ProductFamilies, ProductFamiliesListOptions},
    products::{Products, ProductsListOptions},
    subscriptions::{Subscriptions, SubscriptionsListOptions},
    usage::{
        Usage, UsageRetrieveCustomerOptions, UsageRetrieveSubscriptionOptions,
        UsageRetrieveSummaryOptions,
    },
};
