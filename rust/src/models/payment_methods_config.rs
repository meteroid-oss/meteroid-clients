// this file is @generated
use serde::{Deserialize, Deserializer, Serialize, Serializer};

use super::{
    bank_transfer_payment_method_config::BankTransferPaymentMethodConfig,
    external_payment_method_config::ExternalPaymentMethodConfig,
    online_payment_method_config::OnlinePaymentMethodConfig,
};
use crate::models::codec;

/// Online (card/direct debit), BankTransfer, or External.
///
/// Variants are told apart by `type`.
#[derive(Clone, Debug, PartialEq)]
#[non_exhaustive]
pub enum PaymentMethodsConfig {
    Online(OnlinePaymentMethodConfig),
    BankTransfer(BankTransferPaymentMethodConfig),
    External(ExternalPaymentMethodConfig),
    /// A variant this version of the SDK does not know yet, as received.
    Unknown(serde_json::Value),
}

impl PaymentMethodsConfig {
    /// The `type` value of this variant.
    #[must_use]
    pub fn tag(&self) -> Option<&str> {
        match self {
            Self::Online(_) => Some("online"),
            Self::BankTransfer(_) => Some("bank_transfer"),
            Self::External(_) => Some("external"),
            Self::Unknown(value) => value.get("type")?.as_str(),
        }
    }
}

impl Serialize for PaymentMethodsConfig {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        match self {
            Self::Online(value) => codec::internally_tagged(serializer, "type", "online", value),
            Self::BankTransfer(value) => {
                codec::internally_tagged(serializer, "type", "bank_transfer", value)
            }
            Self::External(value) => {
                codec::internally_tagged(serializer, "type", "external", value)
            }
            Self::Unknown(value) => value.serialize(serializer),
        }
    }
}

impl<'de> Deserialize<'de> for PaymentMethodsConfig {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        let (tag, value) = codec::split_tag(deserializer, "type")?;
        Ok(match tag.as_str() {
            "online" => Self::Online(codec::from_value(value)?),
            "bank_transfer" => Self::BankTransfer(codec::from_value(value)?),
            "external" => Self::External(codec::from_value(value)?),
            _ => Self::Unknown(value),
        })
    }
}
