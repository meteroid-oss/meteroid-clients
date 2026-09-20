// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    address::Address, currency::Currency, custom_tax_rate::CustomTaxRate,
    customer_type::CustomerType, invoicing_entity_id::InvoicingEntityId,
    shipping_address::ShippingAddress,
};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct CustomerUpdateRequest {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub alias: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub billing_address: Option<Address>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub billing_email: Option<String>,

    pub currency: Currency,

    /// User-defined custom property values (full replace). Omit to leave unchanged.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub custom_properties: Option<serde_json::Value>,

    pub custom_taxes: Vec<CustomTaxRate>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub customer_type: Option<CustomerType>,

    /// Free-text legal exemption mention surfaced on exempt invoices.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub exemption_reason: Option<String>,

    /// Omit to keep the stored value (a full replace does not blank a person's name).
    #[serde(skip_serializing_if = "Option::is_none")]
    pub first_name: Option<String>,

    pub invoicing_emails: Vec<String>,

    pub invoicing_entity_id: InvoicingEntityId,

    /// Deprecated: use `preferred_locales`. Applied only when `preferred_locales` is absent.
    #[deprecated]
    #[serde(skip_serializing_if = "Option::is_none")]
    pub invoicing_language: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub is_tax_exempt: Option<bool>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub last_name: Option<String>,

    /// BT-47 — the buyer's national register identifier (SIREN/SIRET, HRB).
    #[serde(skip_serializing_if = "Option::is_none")]
    pub legal_number: Option<String>,

    /// Required for `COMPANY`. Ignored for `INDIVIDUAL`: derived from `first_name` + `last_name`.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub name: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub phone: Option<String>,

    /// Preferred document languages, most-preferred first (BCP-47 tags, e.g.
    /// `["fr-FR", "en"]`); overrides the invoicing entity default. Omit or send `[]` to
    /// reset to that default (full-replace update).
    #[serde(skip_serializing_if = "Option::is_none")]
    pub preferred_locales: Option<Vec<String>>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub shipping_address: Option<ShippingAddress>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub vat_number: Option<String>,
}

impl CustomerUpdateRequest {
    pub fn new(
        currency: Currency,
        custom_taxes: Vec<CustomTaxRate>,
        invoicing_emails: Vec<String>,
        invoicing_entity_id: InvoicingEntityId,
    ) -> Self {
        #[allow(deprecated)]
        Self {
            alias: None,
            billing_address: None,
            billing_email: None,
            currency,
            custom_properties: None,
            custom_taxes,
            customer_type: None,
            exemption_reason: None,
            first_name: None,
            invoicing_emails,
            invoicing_entity_id,
            invoicing_language: None,
            is_tax_exempt: None,
            last_name: None,
            legal_number: None,
            name: None,
            phone: None,
            preferred_locales: None,
            shipping_address: None,
            vat_number: None,
        }
    }
}
