// this file is @generated
use serde::{Deserialize, Serialize};

use super::customer_id::CustomerId;

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct CustomerEventData {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub alias: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub billing_email: Option<String>,

    pub currency: String,

    pub customer_id: CustomerId,

    pub invoicing_emails: Vec<String>,

    pub name: String,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub phone: Option<String>,
}

impl CustomerEventData {
    pub fn new(
        currency: String,
        customer_id: CustomerId,
        invoicing_emails: Vec<String>,
        name: String,
    ) -> Self {
        Self {
            alias: None,
            billing_email: None,
            currency,
            customer_id,
            invoicing_emails,
            name,
            phone: None,
        }
    }
}
