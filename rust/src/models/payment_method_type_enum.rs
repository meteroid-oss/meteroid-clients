// this file is @generated
use std::fmt;

use serde::{Deserialize, Serialize};

#[derive(
    Clone, Copy, Debug, Default, PartialEq, Eq, PartialOrd, Ord, Hash, Serialize, Deserialize,
)]
pub enum PaymentMethodTypeEnum {
    #[default]
    #[serde(rename = "Card")]
    Card,

    #[serde(rename = "BankTransfer")]
    BankTransfer,

    #[serde(rename = "Wallet")]
    Wallet,

    #[serde(rename = "Other")]
    Other,
}

impl fmt::Display for PaymentMethodTypeEnum {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        let value = match self {
            Self::Card => "Card",
            Self::BankTransfer => "BankTransfer",
            Self::Wallet => "Wallet",
            Self::Other => "Other",
        };
        f.write_str(value)
    }
}
