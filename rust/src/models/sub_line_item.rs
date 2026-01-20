// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct SubLineItem {
    pub id: String,

    pub name: String,

    pub quantity: String,

    pub total: i32,

    pub unit_price: String,
}

impl SubLineItem {
    pub fn new(id: String, name: String, quantity: String, total: i32, unit_price: String) -> Self {
        Self {
            id,
            name,
            quantity,
            total,
            unit_price,
        }
    }
}
