// this file is @generated
use std::fmt;

use serde::{Deserialize, Serialize};

/// Company vs. individual (B2C). Defaults to `COMPANY`.
#[derive(
    Clone, Copy, Debug, Default, PartialEq, Eq, PartialOrd, Ord, Hash, Serialize, Deserialize,
)]
pub enum CustomerType {
    #[default]
    #[serde(rename = "COMPANY")]
    Company,

    #[serde(rename = "INDIVIDUAL")]
    Individual,
}

impl fmt::Display for CustomerType {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        let value = match self {
            Self::Company => "COMPANY",
            Self::Individual => "INDIVIDUAL",
        };
        f.write_str(value)
    }
}

impl crate::request::QueryParamValue for CustomerType {
    fn encode(&self) -> String {
        self.to_string()
    }
}
