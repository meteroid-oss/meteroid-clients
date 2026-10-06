// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum CreditNoteStatus {
    Draft,
    Finalized,
    Voided,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl CreditNoteStatus {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::Draft => "DRAFT",
            Self::Finalized => "FINALIZED",
            Self::Voided => "VOIDED",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for CreditNoteStatus {
    fn from(value: &str) -> Self {
        match value {
            "DRAFT" => Self::Draft,
            "FINALIZED" => Self::Finalized,
            "VOIDED" => Self::Voided,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for CreditNoteStatus {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for CreditNoteStatus {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for CreditNoteStatus {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for CreditNoteStatus {
    fn encode(&self) -> String {
        self.to_string()
    }
}
