// this file is @generated
use serde::{Deserialize, Serialize};

use super::{price_component_id::PriceComponentId, subscription_component::SubscriptionComponent};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct ComponentOverride {
    pub component: SubscriptionComponent,

    pub component_id: PriceComponentId,
}

impl ComponentOverride {
    pub fn new(component: SubscriptionComponent, component_id: PriceComponentId) -> Self {
        Self {
            component,
            component_id,
        }
    }
}
