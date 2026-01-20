// this file is @generated
use std::fmt;

use serde::{Deserialize, Serialize};

#[derive(
    Clone, Copy, Debug, Default, PartialEq, Eq, PartialOrd, Ord, Hash, Serialize, Deserialize,
)]
pub enum PaymentStrategy {
    #[default]
    #[serde(rename = "AUTO")]
    Auto,

    #[serde(rename = "BANK")]
    Bank,

    #[serde(rename = "EXTERNAL")]
    External,
}

impl fmt::Display for PaymentStrategy {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        let value = match self {
            Self::Auto => "AUTO",
            Self::Bank => "BANK",
            Self::External => "EXTERNAL",
        };
        f.write_str(value)
    }
}
