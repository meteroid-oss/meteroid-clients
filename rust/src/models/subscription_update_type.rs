// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

/// Identifies which mutation triggered a `subscription.updated` webhook.
#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum SubscriptionUpdateType {
    Activated,
    TrialEnded,
    BillingConfigurationUpdated,
    PlanChanged,
    Amended,
    UnitsChanged,
    Paused,
    CancellationScheduled,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl SubscriptionUpdateType {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::Activated => "activated",
            Self::TrialEnded => "trial_ended",
            Self::BillingConfigurationUpdated => "billing_configuration_updated",
            Self::PlanChanged => "plan_changed",
            Self::Amended => "amended",
            Self::UnitsChanged => "units_changed",
            Self::Paused => "paused",
            Self::CancellationScheduled => "cancellation_scheduled",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for SubscriptionUpdateType {
    fn from(value: &str) -> Self {
        match value {
            "activated" => Self::Activated,
            "trial_ended" => Self::TrialEnded,
            "billing_configuration_updated" => Self::BillingConfigurationUpdated,
            "plan_changed" => Self::PlanChanged,
            "amended" => Self::Amended,
            "units_changed" => Self::UnitsChanged,
            "paused" => Self::Paused,
            "cancellation_scheduled" => Self::CancellationScheduled,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for SubscriptionUpdateType {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for SubscriptionUpdateType {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for SubscriptionUpdateType {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for SubscriptionUpdateType {
    fn encode(&self) -> String {
        self.to_string()
    }
}
