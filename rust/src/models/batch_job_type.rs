// this file is @generated
use std::fmt;

use serde::{Deserialize, Serialize};

#[derive(
    Clone, Copy, Debug, Default, PartialEq, Eq, PartialOrd, Ord, Hash, Serialize, Deserialize,
)]
pub enum BatchJobType {
    #[default]
    #[serde(rename = "EVENT_CSV_IMPORT")]
    EventCsvImport,

    #[serde(rename = "CUSTOMER_CSV_IMPORT")]
    CustomerCsvImport,

    #[serde(rename = "SUBSCRIPTION_CSV_IMPORT")]
    SubscriptionCsvImport,

    #[serde(rename = "SUBSCRIPTION_PLAN_MIGRATION")]
    SubscriptionPlanMigration,
}

impl fmt::Display for BatchJobType {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        let value = match self {
            Self::EventCsvImport => "EVENT_CSV_IMPORT",
            Self::CustomerCsvImport => "CUSTOMER_CSV_IMPORT",
            Self::SubscriptionCsvImport => "SUBSCRIPTION_CSV_IMPORT",
            Self::SubscriptionPlanMigration => "SUBSCRIPTION_PLAN_MIGRATION",
        };
        f.write_str(value)
    }
}
