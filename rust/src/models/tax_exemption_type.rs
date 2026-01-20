// this file is @generated
use std::fmt;

use serde::{Deserialize, Serialize};

#[derive(
    Clone, Copy, Debug, Default, PartialEq, Eq, PartialOrd, Ord, Hash, Serialize, Deserialize,
)]
pub enum TaxExemptionType {
    #[default]
    #[serde(rename = "ReverseCharge")]
    ReverseCharge,

    #[serde(rename = "TaxExempt")]
    TaxExempt,

    #[serde(rename = "NotRegistered")]
    NotRegistered,
}

impl fmt::Display for TaxExemptionType {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        let value = match self {
            Self::ReverseCharge => "ReverseCharge",
            Self::TaxExempt => "TaxExempt",
            Self::NotRegistered => "NotRegistered",
        };
        f.write_str(value)
    }
}
