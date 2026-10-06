// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum BatchJobType {
    EventCsvImport,
    CustomerCsvImport,
    SubscriptionCsvImport,
    SubscriptionPlanMigration,
    TaxReportExport,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl BatchJobType {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::EventCsvImport => "EVENT_CSV_IMPORT",
            Self::CustomerCsvImport => "CUSTOMER_CSV_IMPORT",
            Self::SubscriptionCsvImport => "SUBSCRIPTION_CSV_IMPORT",
            Self::SubscriptionPlanMigration => "SUBSCRIPTION_PLAN_MIGRATION",
            Self::TaxReportExport => "TAX_REPORT_EXPORT",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for BatchJobType {
    fn from(value: &str) -> Self {
        match value {
            "EVENT_CSV_IMPORT" => Self::EventCsvImport,
            "CUSTOMER_CSV_IMPORT" => Self::CustomerCsvImport,
            "SUBSCRIPTION_CSV_IMPORT" => Self::SubscriptionCsvImport,
            "SUBSCRIPTION_PLAN_MIGRATION" => Self::SubscriptionPlanMigration,
            "TAX_REPORT_EXPORT" => Self::TaxReportExport,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for BatchJobType {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for BatchJobType {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for BatchJobType {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for BatchJobType {
    fn encode(&self) -> String {
        self.to_string()
    }
}
