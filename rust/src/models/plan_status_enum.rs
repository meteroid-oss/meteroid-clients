// this file is @generated
use std::fmt;

use serde::{Deserialize, Serialize};

#[derive(
    Clone, Copy, Debug, Default, PartialEq, Eq, PartialOrd, Ord, Hash, Serialize, Deserialize,
)]
pub enum PlanStatusEnum {
    #[default]
    #[serde(rename = "DRAFT")]
    Draft,

    #[serde(rename = "ACTIVE")]
    Active,

    #[serde(rename = "INACTIVE")]
    Inactive,

    #[serde(rename = "ARCHIVED")]
    Archived,
}

impl fmt::Display for PlanStatusEnum {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        let value = match self {
            Self::Draft => "DRAFT",
            Self::Active => "ACTIVE",
            Self::Inactive => "INACTIVE",
            Self::Archived => "ARCHIVED",
        };
        f.write_str(value)
    }
}
