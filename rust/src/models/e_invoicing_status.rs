// this file is @generated
use std::fmt;

use serde::{Deserialize, Serialize};

/// Whether the structured e-invoice was produced with the accounting PDF. Absent when the
/// invoicing entity had not opted in at the time the invoice was issued.
#[derive(
    Clone, Copy, Debug, Default, PartialEq, Eq, PartialOrd, Ord, Hash, Serialize, Deserialize,
)]
pub enum EInvoicingStatus {
    #[default]
    #[serde(rename = "GENERATED")]
    Generated,

    #[serde(rename = "FAILED")]
    Failed,
}

impl fmt::Display for EInvoicingStatus {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        let value = match self {
            Self::Generated => "GENERATED",
            Self::Failed => "FAILED",
        };
        f.write_str(value)
    }
}

impl crate::request::QueryParamValue for EInvoicingStatus {
    fn encode(&self) -> String {
        self.to_string()
    }
}
