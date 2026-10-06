// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum SubscriptionStatusEnum {
    PendingActivation,
    PendingCharge,
    TrialActive,
    Active,
    TrialExpired,
    Paused,
    Suspended,
    Cancelled,
    Aborted,
    Completed,
    Superseded,
    Errored,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl SubscriptionStatusEnum {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::PendingActivation => "PENDING_ACTIVATION",
            Self::PendingCharge => "PENDING_CHARGE",
            Self::TrialActive => "TRIAL_ACTIVE",
            Self::Active => "ACTIVE",
            Self::TrialExpired => "TRIAL_EXPIRED",
            Self::Paused => "PAUSED",
            Self::Suspended => "SUSPENDED",
            Self::Cancelled => "CANCELLED",
            Self::Aborted => "ABORTED",
            Self::Completed => "COMPLETED",
            Self::Superseded => "SUPERSEDED",
            Self::Errored => "ERRORED",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for SubscriptionStatusEnum {
    fn from(value: &str) -> Self {
        match value {
            "PENDING_ACTIVATION" => Self::PendingActivation,
            "PENDING_CHARGE" => Self::PendingCharge,
            "TRIAL_ACTIVE" => Self::TrialActive,
            "ACTIVE" => Self::Active,
            "TRIAL_EXPIRED" => Self::TrialExpired,
            "PAUSED" => Self::Paused,
            "SUSPENDED" => Self::Suspended,
            "CANCELLED" => Self::Cancelled,
            "ABORTED" => Self::Aborted,
            "COMPLETED" => Self::Completed,
            "SUPERSEDED" => Self::Superseded,
            "ERRORED" => Self::Errored,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for SubscriptionStatusEnum {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for SubscriptionStatusEnum {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for SubscriptionStatusEnum {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for SubscriptionStatusEnum {
    fn encode(&self) -> String {
        self.to_string()
    }
}
