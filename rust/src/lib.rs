//! Meteroid Billing SDK for Rust.
//!
//! The main entry point of this library is the API client [`api::Meteroid`].
//!
//! # Example
//!
//! ```no_run
//! use meteroid_rs::api::{Meteroid, MeteroidOptions};
//!
//! #[tokio::main]
//! async fn main() -> Result<(), meteroid_rs::error::Error> {
//!     let client = Meteroid::new("your-api-key".to_string(), None);
//!
//!     // List customers
//!     let customers = client.customers().list_customers(None).await?;
//!     println!("Found {} customers", customers.data.len());
//!
//!     Ok(())
//! }
//! ```

#![forbid(unsafe_code)]

pub mod api;
mod configuration;
mod connector;
pub mod error;
pub mod models;
mod request;
pub mod webhooks;

pub(crate) use connector::make_connector;

pub use configuration::Configuration;
