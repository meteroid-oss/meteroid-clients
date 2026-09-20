// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    event_id::EventId, event_type::EventType,
    invoice_documents_event_data::InvoiceDocumentsEventData,
};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct InvoiceDocumentsEvent {
    #[serde(flatten)]
    pub flatten_invoicedocumentseventdata: InvoiceDocumentsEventData,

    pub id: EventId,

    pub timestamp: String,

    pub r#type: EventType,
}

impl InvoiceDocumentsEvent {
    pub fn new(id: EventId, timestamp: String, r#type: EventType) -> Self {
        Self {
            flatten_invoicedocumentseventdata: Default::default(),
            id,
            timestamp,
            r#type,
        }
    }
}
