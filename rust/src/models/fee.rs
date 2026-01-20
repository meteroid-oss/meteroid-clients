// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    capacity_plan_fee::CapacityPlanFee, extra_recurring_plan_fee::ExtraRecurringPlanFee,
    one_time_plan_fee::OneTimePlanFee, rate_plan_fee::RatePlanFee, slot_plan_fee::SlotPlanFee,
    usage_plan_fee::UsagePlanFee,
};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[serde(tag = "fee_type")]
pub enum Fee {
    #[serde(rename = "rate")]
    Rate(RatePlanFee),
    #[serde(rename = "slot")]
    Slot(SlotPlanFee),
    #[serde(rename = "capacity")]
    Capacity(CapacityPlanFee),
    #[serde(rename = "usage")]
    Usage(UsagePlanFee),
    #[serde(rename = "extra_recurring")]
    ExtraRecurring(ExtraRecurringPlanFee),
    #[serde(rename = "one_time")]
    OneTime(OneTimePlanFee),
}

impl Default for Fee {
    fn default() -> Self {
        Self::Rate(RatePlanFee::default())
    }
}
