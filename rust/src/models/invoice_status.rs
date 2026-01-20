// this file is @generated
use std::fmt;

use serde::{Deserialize, Serialize};

#[derive(
    Clone, Copy, Debug, Default, PartialEq, Eq, PartialOrd, Ord, Hash, Serialize, Deserialize,
)]
pub enum InvoiceStatus {
    #[default]
    #[serde(rename = "Draft")]
    Draft,

    #[serde(rename = "Finalized")]
    Finalized,

    #[serde(rename = "Uncollectible")]
    Uncollectible,

    #[serde(rename = "Void")]
    Void,
}

impl fmt::Display for InvoiceStatus {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        let value = match self {
            Self::Draft => "Draft",
            Self::Finalized => "Finalized",
            Self::Uncollectible => "Uncollectible",
            Self::Void => "Void",
        };
        f.write_str(value)
    }
}
