// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    address::Address, bank_account_id::BankAccountId, currency::Currency,
    custom_tax_rate::CustomTaxRate, invoicing_entity_id::InvoicingEntityId,
    shipping_address::ShippingAddress,
};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct CustomerPatchRequest {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub alias: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub bank_account_id: Option<BankAccountId>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub billing_address: Option<Address>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub billing_email: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub currency: Option<Currency>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub custom_taxes: Option<Vec<CustomTaxRate>>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub invoicing_emails: Option<Vec<String>>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub invoicing_entity_id: Option<InvoicingEntityId>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub is_tax_exempt: Option<bool>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub name: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub phone: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub shipping_address: Option<ShippingAddress>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub vat_number: Option<String>,
}

impl CustomerPatchRequest {
    pub fn new() -> Self {
        Self {
            alias: None,
            bank_account_id: None,
            billing_address: None,
            billing_email: None,
            currency: None,
            custom_taxes: None,
            invoicing_emails: None,
            invoicing_entity_id: None,
            is_tax_exempt: None,
            name: None,
            phone: None,
            shipping_address: None,
            vat_number: None,
        }
    }
}
