// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    address::Address, currency::Currency, custom_tax_rate::CustomTaxRate, customer_id::CustomerId,
    customer_type::CustomerType, invoicing_entity_id::InvoicingEntityId,
    shipping_address::ShippingAddress,
};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct Customer {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub alias: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub billing_address: Option<Address>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub billing_email: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub connected_account_id: Option<String>,

    pub currency: Currency,

    /// User-defined custom property values, keyed by definition `key`.
    pub custom_properties: serde_json::Value,

    pub custom_taxes: Vec<CustomTaxRate>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub customer_type: Option<CustomerType>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub first_name: Option<String>,

    pub id: CustomerId,

    pub invoicing_emails: Vec<String>,

    pub invoicing_entity_id: InvoicingEntityId,

    /// Deprecated: the first entry of `preferred_locales`.
    #[deprecated]
    #[serde(skip_serializing_if = "Option::is_none")]
    pub invoicing_language: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub last_name: Option<String>,

    /// BT-47 — the buyer's national register identifier (SIREN/SIRET, HRB).
    #[serde(skip_serializing_if = "Option::is_none")]
    pub legal_number: Option<String>,

    pub name: String,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub phone: Option<String>,

    /// Preferred document languages, most-preferred first (BCP-47 tags, e.g.
    /// `["fr-FR", "en"]`); overrides the invoicing entity default.
    pub preferred_locales: Vec<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub shipping_address: Option<ShippingAddress>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub vat_number: Option<String>,
}

impl Customer {
    pub fn new(
        currency: Currency,
        custom_properties: serde_json::Value,
        custom_taxes: Vec<CustomTaxRate>,
        id: CustomerId,
        invoicing_emails: Vec<String>,
        invoicing_entity_id: InvoicingEntityId,
        name: String,
        preferred_locales: Vec<String>,
    ) -> Self {
        #[allow(deprecated)]
        Self {
            alias: None,
            billing_address: None,
            billing_email: None,
            connected_account_id: None,
            currency,
            custom_properties,
            custom_taxes,
            customer_type: None,
            first_name: None,
            id,
            invoicing_emails,
            invoicing_entity_id,
            invoicing_language: None,
            last_name: None,
            legal_number: None,
            name,
            phone: None,
            preferred_locales,
            shipping_address: None,
            vat_number: None,
        }
    }
}
