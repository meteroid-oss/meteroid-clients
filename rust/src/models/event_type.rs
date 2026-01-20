// this file is @generated
use std::fmt;

use serde::{Deserialize, Serialize};

#[derive(
    Clone, Copy, Debug, Default, PartialEq, Eq, PartialOrd, Ord, Hash, Serialize, Deserialize,
)]
pub enum EventType {
    #[default]
    #[serde(rename = "metric.created")]
    MetricCreated,

    #[serde(rename = "customer.created")]
    CustomerCreated,

    #[serde(rename = "subscription.created")]
    SubscriptionCreated,

    #[serde(rename = "invoice.created")]
    InvoiceCreated,

    #[serde(rename = "invoice.finalized")]
    InvoiceFinalized,

    #[serde(rename = "invoice.paid")]
    InvoicePaid,

    #[serde(rename = "invoice.voided")]
    InvoiceVoided,

    #[serde(rename = "quote.accepted")]
    QuoteAccepted,

    #[serde(rename = "quote.converted")]
    QuoteConverted,

    #[serde(rename = "credit_note.created")]
    CreditNoteCreated,

    #[serde(rename = "credit_note.finalized")]
    CreditNoteFinalized,

    #[serde(rename = "credit_note.voided")]
    CreditNoteVoided,
}

impl fmt::Display for EventType {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        let value = match self {
            Self::MetricCreated => "metric.created",
            Self::CustomerCreated => "customer.created",
            Self::SubscriptionCreated => "subscription.created",
            Self::InvoiceCreated => "invoice.created",
            Self::InvoiceFinalized => "invoice.finalized",
            Self::InvoicePaid => "invoice.paid",
            Self::InvoiceVoided => "invoice.voided",
            Self::QuoteAccepted => "quote.accepted",
            Self::QuoteConverted => "quote.converted",
            Self::CreditNoteCreated => "credit_note.created",
            Self::CreditNoteFinalized => "credit_note.finalized",
            Self::CreditNoteVoided => "credit_note.voided",
        };
        f.write_str(value)
    }
}
