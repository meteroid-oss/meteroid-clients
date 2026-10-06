// this file is @generated
use crate::{decode, mock};

#[tokio::test]
async fn list() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"data":[{"code":"sample","created_at":"2024-03-15T10:30:45.123+02:00","disabled":false,"discount":{"type":"PERCENTAGE","percentage":"sample"},"id":"coupon_id_25","plan_ids":["plan_id_47"],"redemption_count":-2147483648,"reusable":false}],"pagination_meta":{"page":-123456789,"per_page":-123456789,"total_items":-9007199254740993,"total_pages":123456789}}"#,
    );
    client.coupons().list(None).await.unwrap();
    assert_eq!(*requests.lock().unwrap(), ["GET /api/v1/coupons"]);
}

#[tokio::test]
async fn create() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"code":"sample","created_at":"2023-12-31T23:59:59.999-05:30","disabled":false,"discount":{"type":"PERCENTAGE","percentage":"sample"},"id":"coupon_id_40","plan_ids":["plan_id_99"],"redemption_count":-123456789,"reusable":false}"#,
    );
    client
        .coupons()
        .create(decode::<meteroid_rs::models::CreateCouponRequest>(
            r#"{"code":"sample","discount":{"type":"PERCENTAGE","percentage":"sample"}}"#,
        ))
        .await
        .unwrap();
    assert_eq!(*requests.lock().unwrap(), ["POST /api/v1/coupons"]);
}

#[tokio::test]
async fn retrieve() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"code":"sample","created_at":"2023-12-31T23:59:59.999-05:30","disabled":false,"discount":{"type":"PERCENTAGE","percentage":"sample"},"id":"coupon_id_40","plan_ids":["plan_id_99"],"redemption_count":-123456789,"reusable":false}"#,
    );
    client.coupons().retrieve("coupon_id").await.unwrap();
    assert_eq!(*requests.lock().unwrap(), ["GET /api/v1/coupons/coupon_id"]);
}

#[tokio::test]
async fn update() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"code":"sample","created_at":"2023-12-31T23:59:59.999-05:30","disabled":false,"discount":{"type":"PERCENTAGE","percentage":"sample"},"id":"coupon_id_40","plan_ids":["plan_id_99"],"redemption_count":-123456789,"reusable":false}"#,
    );
    client
        .coupons()
        .update(
            "coupon_id",
            decode::<meteroid_rs::models::UpdateCouponRequest>(r#"{}"#),
        )
        .await
        .unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["PATCH /api/v1/coupons/coupon_id"]
    );
}

#[tokio::test]
async fn archive() {
    let (client, requests) = mock(204, None, r#""#);
    client.coupons().archive("coupon_id").await.unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["POST /api/v1/coupons/coupon_id/archive"]
    );
}

#[tokio::test]
async fn disable() {
    let (client, requests) = mock(204, None, r#""#);
    client.coupons().disable("coupon_id").await.unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["POST /api/v1/coupons/coupon_id/disable"]
    );
}

#[tokio::test]
async fn enable() {
    let (client, requests) = mock(204, None, r#""#);
    client.coupons().enable("coupon_id").await.unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["POST /api/v1/coupons/coupon_id/enable"]
    );
}

#[tokio::test]
async fn unarchive() {
    let (client, requests) = mock(204, None, r#""#);
    client.coupons().unarchive("coupon_id").await.unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["POST /api/v1/coupons/coupon_id/unarchive"]
    );
}
