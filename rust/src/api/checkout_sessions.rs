// this file is @generated
#[allow(unused_imports)]
use crate::{error::Result, models::*, Configuration};

pub struct CheckoutSessions<'a> {
    cfg: &'a Configuration,
}

impl<'a> CheckoutSessions<'a> {
    pub(super) fn new(cfg: &'a Configuration) -> Self {
        Self { cfg }
    }

    pub async fn list_checkout_sessions(
        &self,
        customer_id: String,
        status: String,
    ) -> Result<crate::models::ListCheckoutSessionsResponse> {
        crate::request::Request::new(http1::Method::GET, "/api/v1/checkout-sessions")
            .with_path_param("customer_id", customer_id)
            .with_path_param("status", status)
            .execute(self.cfg)
            .await
    }

    pub async fn create_checkout_session(
        &self,
        create_checkout_session_request: crate::models::CreateCheckoutSessionRequest,
    ) -> Result<crate::models::CreateCheckoutSessionResponse> {
        crate::request::Request::new(http1::Method::POST, "/api/v1/checkout-sessions")
            .with_body_param(create_checkout_session_request)
            .execute(self.cfg)
            .await
    }

    pub async fn get_checkout_session(
        &self,
        id: String,
    ) -> Result<crate::models::GetCheckoutSessionResponse> {
        crate::request::Request::new(http1::Method::GET, "/api/v1/checkout-sessions/{id}")
            .with_path_param("id", id)
            .execute(self.cfg)
            .await
    }

    pub async fn cancel_checkout_session(
        &self,
        id: String,
    ) -> Result<crate::models::CancelCheckoutSessionResponse> {
        crate::request::Request::new(http1::Method::POST, "/api/v1/checkout-sessions/{id}/cancel")
            .with_path_param("id", id)
            .execute(self.cfg)
            .await
    }
}
