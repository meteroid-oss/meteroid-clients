// this file is @generated
use std::fmt;

use serde::{Deserialize, Serialize};

#[derive(
    Clone, Copy, Debug, Default, PartialEq, Eq, PartialOrd, Ord, Hash, Serialize, Deserialize,
)]
pub enum PaymentStatusEnum {
    #[default]
    #[serde(rename = "Ready")]
    Ready,

    #[serde(rename = "Pending")]
    Pending,

    #[serde(rename = "Settled")]
    Settled,

    #[serde(rename = "Cancelled")]
    Cancelled,

    #[serde(rename = "Failed")]
    Failed,
}

impl fmt::Display for PaymentStatusEnum {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        let value = match self {
            Self::Ready => "Ready",
            Self::Pending => "Pending",
            Self::Settled => "Settled",
            Self::Cancelled => "Cancelled",
            Self::Failed => "Failed",
        };
        f.write_str(value)
    }
}
