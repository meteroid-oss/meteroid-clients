// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct Event {
    pub code: String,

    /// Either Meteroid's customer_id or an alias
    pub customer_id: String,

    pub event_id: String,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub properties: Option<std::collections::HashMap<String, String>>,

    pub timestamp: String,
}

impl Event {
    pub fn new(code: String, customer_id: String, event_id: String, timestamp: String) -> Self {
        Self {
            code,
            customer_id,
            event_id,
            properties: None,
            timestamp,
        }
    }
}
