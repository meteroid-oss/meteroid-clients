//! Everything the handlers share: configuration, one Meteroid client, the catalog
//! caches, and the in-memory transcription history.
//!
//! There is exactly **one** [`Meteroid`] client for the whole process. It owns a
//! connection pool, so building one per request would throw away keep-alive and TLS
//! session reuse. `Meteroid` is cheap to clone (an `Arc` internally) and every method
//! takes `&self`, so sharing it across tasks needs no locking.

use std::{collections::HashMap, sync::Arc};

use meteroid_rs::api::Meteroid;
use tokio::sync::RwLock;

use crate::{
    catalog::{Catalog, CatalogCache, MetricCache},
    config::Config,
    dto::Transcription,
    error::ApiResult,
};

#[derive(Clone)]
pub struct AppState {
    pub config: Arc<Config>,
    pub meteroid: Arc<Meteroid>,
    catalog: Arc<CatalogCache>,
    pub metrics: Arc<MetricCache>,
    pub transcriptions: Arc<TranscriptionStore>,
}

impl AppState {
    pub fn new(config: Config) -> Self {
        let meteroid = Arc::new(config.meteroid_client());
        Self {
            config: Arc::new(config),
            meteroid,
            catalog: Arc::new(CatalogCache::default()),
            metrics: Arc::new(MetricCache::default()),
            transcriptions: Arc::new(TranscriptionStore::default()),
        }
    }

    /// The seeded Meteroid catalog, resolved on first use and cached afterwards.
    /// Only successes are cached, so seeding the tenant while the demo is running
    /// fixes it without a restart.
    pub async fn catalog(&self) -> ApiResult<Arc<Catalog>> {
        self.catalog
            .get(
                &self.meteroid,
                &self.metrics,
                &self.config.default_currency.to_string(),
            )
            .await
    }
}

/// Transcription history, per workspace.
///
/// Deliberately in memory: Meteroid is the source of truth for *usage*, not for the
/// application objects that produced it. Restarting the backend empties this; the
/// usage it reported to Meteroid survives.
#[derive(Default)]
pub struct TranscriptionStore {
    by_workspace: RwLock<HashMap<String, Vec<Transcription>>>,
}

impl TranscriptionStore {
    pub async fn record(&self, customer_alias: &str, transcription: Transcription) {
        self.by_workspace
            .write()
            .await
            .entry(customer_alias.to_string())
            .or_default()
            // Newest first, which is the order `GET /api/transcriptions` promises.
            .insert(0, transcription);
    }

    pub async fn list(&self, customer_alias: &str) -> Vec<Transcription> {
        self.by_workspace
            .read()
            .await
            .get(customer_alias)
            .cloned()
            .unwrap_or_default()
    }
}
