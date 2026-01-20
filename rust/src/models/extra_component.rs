// this file is @generated
use serde::{Deserialize, Serialize};

use super::subscription_component::SubscriptionComponent;

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct ExtraComponent {
    pub component: SubscriptionComponent,
}

impl ExtraComponent {
    pub fn new(component: SubscriptionComponent) -> Self {
        Self { component }
    }
}
