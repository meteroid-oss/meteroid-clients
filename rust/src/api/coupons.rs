// this file is @generated
#[allow(unused_imports)]
use crate::{error::Result, models::*, Configuration};

pub struct Coupons<'a> {
    cfg: &'a Configuration,
}

impl<'a> Coupons<'a> {
    pub(super) fn new(cfg: &'a Configuration) -> Self {
        Self { cfg }
    }

    pub async fn create_coupon(
        &self,
        create_coupon_request: crate::models::CreateCouponRequest,
    ) -> Result<crate::models::Coupon> {
        crate::request::Request::new(http1::Method::POST, "/api/v1/coupons")
            .with_body_param(create_coupon_request)
            .execute(self.cfg)
            .await
    }

    pub async fn get_coupon(&self, coupon_id: String) -> Result<crate::models::Coupon> {
        crate::request::Request::new(http1::Method::GET, "/api/v1/coupons/{coupon_id}")
            .with_path_param("coupon_id", coupon_id)
            .execute(self.cfg)
            .await
    }

    pub async fn update_coupon(
        &self,
        coupon_id: String,
        update_coupon_request: crate::models::UpdateCouponRequest,
    ) -> Result<crate::models::Coupon> {
        crate::request::Request::new(http1::Method::PATCH, "/api/v1/coupons/{coupon_id}")
            .with_path_param("coupon_id", coupon_id)
            .with_body_param(update_coupon_request)
            .execute(self.cfg)
            .await
    }

    pub async fn archive_coupon(&self, coupon_id: String) -> Result<()> {
        crate::request::Request::new(http1::Method::POST, "/api/v1/coupons/{coupon_id}/archive")
            .with_path_param("coupon_id", coupon_id)
            .returns_nothing()
            .execute(self.cfg)
            .await
    }

    pub async fn disable_coupon(&self, coupon_id: String) -> Result<()> {
        crate::request::Request::new(http1::Method::POST, "/api/v1/coupons/{coupon_id}/disable")
            .with_path_param("coupon_id", coupon_id)
            .returns_nothing()
            .execute(self.cfg)
            .await
    }

    pub async fn enable_coupon(&self, coupon_id: String) -> Result<()> {
        crate::request::Request::new(http1::Method::POST, "/api/v1/coupons/{coupon_id}/enable")
            .with_path_param("coupon_id", coupon_id)
            .returns_nothing()
            .execute(self.cfg)
            .await
    }

    pub async fn unarchive_coupon(&self, coupon_id: String) -> Result<()> {
        crate::request::Request::new(http1::Method::POST, "/api/v1/coupons/{coupon_id}/unarchive")
            .with_path_param("coupon_id", coupon_id)
            .returns_nothing()
            .execute(self.cfg)
            .await
    }
}
