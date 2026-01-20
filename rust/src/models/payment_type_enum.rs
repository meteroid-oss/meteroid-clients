// this file is @generated
use std::fmt;

use serde::{Deserialize, Serialize};

#[derive(
    Clone, Copy, Debug, Default, PartialEq, Eq, PartialOrd, Ord, Hash, Serialize, Deserialize,
)]
pub enum PaymentTypeEnum {
    #[default]
    #[serde(rename = "Payment")]
    Payment,

    #[serde(rename = "Refund")]
    Refund,
}

impl fmt::Display for PaymentTypeEnum {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        let value = match self {
            Self::Payment => "Payment",
            Self::Refund => "Refund",
        };
        f.write_str(value)
    }
}
