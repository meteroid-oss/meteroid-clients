// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    address::Address, currency::Currency, custom_tax_rate::CustomTaxRate,
    customer_type::CustomerType, invoicing_entity_id::InvoicingEntityId,
    shipping_address::ShippingAddress,
};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct CustomerPatchRequest {
    #[serde(
        default,
        skip_serializing_if = "Option::is_none",
        deserialize_with = "crate::models::codec::nullable"
    )]
    pub alias: Option<Option<String>>,

    #[serde(
        default,
        skip_serializing_if = "Option::is_none",
        deserialize_with = "crate::models::codec::nullable"
    )]
    pub billing_address: Option<Option<Address>>,

    #[serde(
        default,
        skip_serializing_if = "Option::is_none",
        deserialize_with = "crate::models::codec::nullable"
    )]
    pub billing_email: Option<Option<String>>,

    #[serde(
        default,
        skip_serializing_if = "Option::is_none",
        deserialize_with = "crate::models::codec::nullable"
    )]
    pub currency: Option<Option<Currency>>,

    /// Partial update of custom property values (merge; send a key with `null` to remove it).
    /// Omit to leave unchanged.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub custom_properties: Option<serde_json::Value>,

    #[serde(
        default,
        skip_serializing_if = "Option::is_none",
        deserialize_with = "crate::models::codec::nullable"
    )]
    pub custom_taxes: Option<Option<Vec<CustomTaxRate>>>,

    #[serde(
        default,
        skip_serializing_if = "Option::is_none",
        deserialize_with = "crate::models::codec::nullable"
    )]
    pub customer_type: Option<Option<CustomerType>>,

    /// Free-text legal exemption mention surfaced on exempt invoices.
    #[serde(
        default,
        skip_serializing_if = "Option::is_none",
        deserialize_with = "crate::models::codec::nullable"
    )]
    pub exemption_reason: Option<Option<String>>,

    #[serde(
        default,
        skip_serializing_if = "Option::is_none",
        deserialize_with = "crate::models::codec::nullable"
    )]
    pub first_name: Option<Option<String>>,

    #[serde(
        default,
        skip_serializing_if = "Option::is_none",
        deserialize_with = "crate::models::codec::nullable"
    )]
    pub invoicing_emails: Option<Option<Vec<String>>>,

    #[serde(
        default,
        skip_serializing_if = "Option::is_none",
        deserialize_with = "crate::models::codec::nullable"
    )]
    pub invoicing_entity_id: Option<Option<InvoicingEntityId>>,

    /// Deprecated: use `preferred_locales`. Applied only when `preferred_locales` is absent.
    #[deprecated]
    #[serde(
        default,
        skip_serializing_if = "Option::is_none",
        deserialize_with = "crate::models::codec::nullable"
    )]
    pub invoicing_language: Option<Option<String>>,

    #[serde(
        default,
        skip_serializing_if = "Option::is_none",
        deserialize_with = "crate::models::codec::nullable"
    )]
    pub is_tax_exempt: Option<Option<bool>>,

    #[serde(
        default,
        skip_serializing_if = "Option::is_none",
        deserialize_with = "crate::models::codec::nullable"
    )]
    pub last_name: Option<Option<String>>,

    /// BT-47 — the buyer's national register identifier (SIREN/SIRET, HRB).
    #[serde(
        default,
        skip_serializing_if = "Option::is_none",
        deserialize_with = "crate::models::codec::nullable"
    )]
    pub legal_number: Option<Option<String>>,

    #[serde(
        default,
        skip_serializing_if = "Option::is_none",
        deserialize_with = "crate::models::codec::nullable"
    )]
    pub name: Option<Option<String>>,

    #[serde(
        default,
        skip_serializing_if = "Option::is_none",
        deserialize_with = "crate::models::codec::nullable"
    )]
    pub phone: Option<Option<String>>,

    /// Preferred document languages, most-preferred first (BCP-47 tags, e.g.
    /// `["fr-FR", "en"]`); overrides the invoicing entity default. Omit to leave
    /// unchanged, send `[]` to reset to that default.
    #[serde(
        default,
        skip_serializing_if = "Option::is_none",
        deserialize_with = "crate::models::codec::nullable"
    )]
    pub preferred_locales: Option<Option<Vec<String>>>,

    #[serde(
        default,
        skip_serializing_if = "Option::is_none",
        deserialize_with = "crate::models::codec::nullable"
    )]
    pub shipping_address: Option<Option<ShippingAddress>>,

    #[serde(
        default,
        skip_serializing_if = "Option::is_none",
        deserialize_with = "crate::models::codec::nullable"
    )]
    pub vat_number: Option<Option<String>>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl CustomerPatchRequest {
    /// Creates a value with every field unset.
    #[must_use]
    pub fn new() -> Self {
        #[allow(deprecated)]
        Self {
            alias: None,
            billing_address: None,
            billing_email: None,
            currency: None,
            custom_properties: None,
            custom_taxes: None,
            customer_type: None,
            exemption_reason: None,
            first_name: None,
            invoicing_emails: None,
            invoicing_entity_id: None,
            invoicing_language: None,
            is_tax_exempt: None,
            last_name: None,
            legal_number: None,
            name: None,
            phone: None,
            preferred_locales: None,
            shipping_address: None,
            vat_number: None,
            extra: serde_json::Map::new(),
        }
    }
}
