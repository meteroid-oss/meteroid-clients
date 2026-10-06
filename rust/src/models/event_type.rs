// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum EventType {
    MetricCreated,
    CustomerCreated,
    SubscriptionCreated,
    SubscriptionUpdated,
    SubscriptionCancelled,
    SubscriptionEnded,
    InvoiceCreated,
    InvoiceFinalized,
    InvoicePaid,
    InvoiceVoided,
    InvoiceClosed,
    InvoiceConsolidated,
    InvoiceDeleted,
    InvoiceAccountingPdfGenerated,
    QuoteAccepted,
    QuoteConverted,
    CreditNoteCreated,
    CreditNoteFinalized,
    CreditNoteVoided,
    PlanCreated,
    PlanPublished,
    PlanArchived,
    ProductCreated,
    ProductUpdated,
    ProductArchived,
    MetricUpdated,
    MetricArchived,
    CouponCreated,
    CouponUpdated,
    CouponArchived,
    AddonCreated,
    AddonUpdated,
    AddonArchived,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl EventType {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::MetricCreated => "metric.created",
            Self::CustomerCreated => "customer.created",
            Self::SubscriptionCreated => "subscription.created",
            Self::SubscriptionUpdated => "subscription.updated",
            Self::SubscriptionCancelled => "subscription.cancelled",
            Self::SubscriptionEnded => "subscription.ended",
            Self::InvoiceCreated => "invoice.created",
            Self::InvoiceFinalized => "invoice.finalized",
            Self::InvoicePaid => "invoice.paid",
            Self::InvoiceVoided => "invoice.voided",
            Self::InvoiceClosed => "invoice.closed",
            Self::InvoiceConsolidated => "invoice.consolidated",
            Self::InvoiceDeleted => "invoice.deleted",
            Self::InvoiceAccountingPdfGenerated => "invoice.accounting_pdf_generated",
            Self::QuoteAccepted => "quote.accepted",
            Self::QuoteConverted => "quote.converted",
            Self::CreditNoteCreated => "credit_note.created",
            Self::CreditNoteFinalized => "credit_note.finalized",
            Self::CreditNoteVoided => "credit_note.voided",
            Self::PlanCreated => "plan.created",
            Self::PlanPublished => "plan.published",
            Self::PlanArchived => "plan.archived",
            Self::ProductCreated => "product.created",
            Self::ProductUpdated => "product.updated",
            Self::ProductArchived => "product.archived",
            Self::MetricUpdated => "metric.updated",
            Self::MetricArchived => "metric.archived",
            Self::CouponCreated => "coupon.created",
            Self::CouponUpdated => "coupon.updated",
            Self::CouponArchived => "coupon.archived",
            Self::AddonCreated => "addon.created",
            Self::AddonUpdated => "addon.updated",
            Self::AddonArchived => "addon.archived",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for EventType {
    fn from(value: &str) -> Self {
        match value {
            "metric.created" => Self::MetricCreated,
            "customer.created" => Self::CustomerCreated,
            "subscription.created" => Self::SubscriptionCreated,
            "subscription.updated" => Self::SubscriptionUpdated,
            "subscription.cancelled" => Self::SubscriptionCancelled,
            "subscription.ended" => Self::SubscriptionEnded,
            "invoice.created" => Self::InvoiceCreated,
            "invoice.finalized" => Self::InvoiceFinalized,
            "invoice.paid" => Self::InvoicePaid,
            "invoice.voided" => Self::InvoiceVoided,
            "invoice.closed" => Self::InvoiceClosed,
            "invoice.consolidated" => Self::InvoiceConsolidated,
            "invoice.deleted" => Self::InvoiceDeleted,
            "invoice.accounting_pdf_generated" => Self::InvoiceAccountingPdfGenerated,
            "quote.accepted" => Self::QuoteAccepted,
            "quote.converted" => Self::QuoteConverted,
            "credit_note.created" => Self::CreditNoteCreated,
            "credit_note.finalized" => Self::CreditNoteFinalized,
            "credit_note.voided" => Self::CreditNoteVoided,
            "plan.created" => Self::PlanCreated,
            "plan.published" => Self::PlanPublished,
            "plan.archived" => Self::PlanArchived,
            "product.created" => Self::ProductCreated,
            "product.updated" => Self::ProductUpdated,
            "product.archived" => Self::ProductArchived,
            "metric.updated" => Self::MetricUpdated,
            "metric.archived" => Self::MetricArchived,
            "coupon.created" => Self::CouponCreated,
            "coupon.updated" => Self::CouponUpdated,
            "coupon.archived" => Self::CouponArchived,
            "addon.created" => Self::AddonCreated,
            "addon.updated" => Self::AddonUpdated,
            "addon.archived" => Self::AddonArchived,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for EventType {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for EventType {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for EventType {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for EventType {
    fn encode(&self) -> String {
        self.to_string()
    }
}
