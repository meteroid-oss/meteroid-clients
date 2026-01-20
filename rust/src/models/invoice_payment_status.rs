// this file is @generated
use std::fmt;

use serde::{Deserialize, Serialize};

#[derive(
    Clone, Copy, Debug, Default, PartialEq, Eq, PartialOrd, Ord, Hash, Serialize, Deserialize,
)]
pub enum InvoicePaymentStatus {
    #[default]
    #[serde(rename = "Unpaid")]
    Unpaid,

    #[serde(rename = "PartiallyPaid")]
    PartiallyPaid,

    #[serde(rename = "Paid")]
    Paid,

    #[serde(rename = "Errored")]
    Errored,
}

impl fmt::Display for InvoicePaymentStatus {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        let value = match self {
            Self::Unpaid => "Unpaid",
            Self::PartiallyPaid => "PartiallyPaid",
            Self::Paid => "Paid",
            Self::Errored => "Errored",
        };
        f.write_str(value)
    }
}
