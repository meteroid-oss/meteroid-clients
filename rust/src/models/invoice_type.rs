// this file is @generated
use std::fmt;

use serde::{Deserialize, Serialize};

#[derive(
    Clone, Copy, Debug, Default, PartialEq, Eq, PartialOrd, Ord, Hash, Serialize, Deserialize,
)]
pub enum InvoiceType {
    #[default]
    #[serde(rename = "Recurring")]
    Recurring,

    #[serde(rename = "OneOff")]
    OneOff,

    #[serde(rename = "Adjustment")]
    Adjustment,

    #[serde(rename = "UsageThreshold")]
    UsageThreshold,
}

impl fmt::Display for InvoiceType {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        let value = match self {
            Self::Recurring => "Recurring",
            Self::OneOff => "OneOff",
            Self::Adjustment => "Adjustment",
            Self::UsageThreshold => "UsageThreshold",
        };
        f.write_str(value)
    }
}
