// this file is @generated
use crate::{decode, mock};

#[tokio::test]
async fn list() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"data":[{"amount_due":-9007199254740993,"applied_credits":-9007199254740993,"coupons":[{"coupon_id":"sample","name":"sample","total":-9007199254740993}],"created_at":"2024-03-15T10:30:45.123+02:00","currency":"CNY","custom_properties":{"key":"value","count":3,"ratio":0.5,"flags":[true,false],"nested":{"ok":true}},"customer_details":{"id":"customer_id_39","name":"sample","snapshot_at":"2023-12-31T23:59:59.999-05:30"},"customer_id":"customer_id_67","id":"invoice_id_67","invoice_date":"1999-12-31","invoice_number":"sample","invoice_type":"RECURRING","line_items":[{"amount_total":9007199254740993,"end_date":"2024-02-29","name":"sample","start_date":"2024-02-29","sub_line_items":[{"id":"sample","name":"sample","quantity":"-0.000123","total":-9007199254740993,"unit_price":"-0.000123"}],"tax_rate":"12345.6789"}],"net_terms":-2147483648,"payment_status":"PARTIALLY_PAID","status":"FINALIZED","subtotal":-9007199254740993,"subtotal_recurring":9007199254740993,"tax_amount":9007199254740993,"tax_breakdown":[{"name":"sample","tax_amount":-9007199254740993,"tax_rate":"12345.6789","taxable_amount":9007199254740993}],"total":-9007199254740993,"transactions":[{"amount":-9007199254740993,"currency":"sample","id":"payment_transaction_id_40","payment_type":"PAYMENT","status":"CANCELLED"}]}],"pagination_meta":{"page":-123456789,"per_page":-123456789,"total_items":-9007199254740993,"total_pages":123456789}}"#,
    );
    client.invoices().list(None).await.unwrap();
    assert_eq!(*requests.lock().unwrap(), ["GET /api/v1/invoices"]);
}

#[tokio::test]
async fn retrieve() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"amount_due":-9007199254740993,"applied_credits":9007199254740993,"coupons":[{"coupon_id":"sample","name":"sample","total":-9007199254740993}],"created_at":"2024-03-15T10:30:45.123+02:00","currency":"NAD","custom_properties":{"key":"value","count":3,"ratio":0.5,"flags":[true,false],"nested":{"ok":true}},"customer_details":{"id":"customer_id_62","name":"sample","snapshot_at":"2024-03-15T10:30:45.123+02:00"},"customer_id":"customer_id_90","id":"invoice_id_31","invoice_date":"1999-12-31","invoice_number":"sample","invoice_type":"ONE_OFF","line_items":[{"amount_total":9007199254740993,"end_date":"1999-12-31","name":"sample","start_date":"1999-12-31","sub_line_items":[{"id":"sample","name":"sample","quantity":"-0.000123","total":-9007199254740993,"unit_price":"-0.000123"}],"tax_rate":"-0.000123"}],"net_terms":-2147483648,"payment_status":"UNPAID","status":"DRAFT","subtotal":9007199254740993,"subtotal_recurring":9007199254740993,"tax_amount":-9007199254740993,"tax_breakdown":[{"name":"sample","tax_amount":9007199254740993,"tax_rate":"-0.000123","taxable_amount":9007199254740993}],"total":9007199254740993,"transactions":[{"amount":9007199254740993,"currency":"sample","id":"payment_transaction_id_56","payment_type":"REFUND","status":"CANCELLED"}]}"#,
    );
    client.invoices().retrieve("invoice_id").await.unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["GET /api/v1/invoices/invoice_id"]
    );
}

#[tokio::test]
async fn update_custom_properties() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"amount_due":-9007199254740993,"applied_credits":9007199254740993,"coupons":[{"coupon_id":"sample","name":"sample","total":-9007199254740993}],"created_at":"2024-03-15T10:30:45.123+02:00","currency":"NAD","custom_properties":{"key":"value","count":3,"ratio":0.5,"flags":[true,false],"nested":{"ok":true}},"customer_details":{"id":"customer_id_62","name":"sample","snapshot_at":"2024-03-15T10:30:45.123+02:00"},"customer_id":"customer_id_90","id":"invoice_id_31","invoice_date":"1999-12-31","invoice_number":"sample","invoice_type":"ONE_OFF","line_items":[{"amount_total":9007199254740993,"end_date":"1999-12-31","name":"sample","start_date":"1999-12-31","sub_line_items":[{"id":"sample","name":"sample","quantity":"-0.000123","total":-9007199254740993,"unit_price":"-0.000123"}],"tax_rate":"-0.000123"}],"net_terms":-2147483648,"payment_status":"UNPAID","status":"DRAFT","subtotal":9007199254740993,"subtotal_recurring":9007199254740993,"tax_amount":-9007199254740993,"tax_breakdown":[{"name":"sample","tax_amount":9007199254740993,"tax_rate":"-0.000123","taxable_amount":9007199254740993}],"total":9007199254740993,"transactions":[{"amount":9007199254740993,"currency":"sample","id":"payment_transaction_id_56","payment_type":"REFUND","status":"CANCELLED"}]}"#,
    );
    client.invoices().update_custom_properties("invoice_id", decode::<meteroid_rs::models::InvoiceCustomPropertiesRequest>(r#"{"custom_properties":{"key":"value","count":3,"ratio":0.5,"flags":[true,false],"nested":{"ok":true}}}"#)).await.unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["PATCH /api/v1/invoices/invoice_id/custom-properties"]
    );
}

#[tokio::test]
async fn download() {
    let (client, requests) = mock(200, Some("application/octet-stream"), r#"sample"#);
    client.invoices().download("invoice_id").await.unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["GET /api/v1/invoices/invoice_id/download"]
    );
}

#[tokio::test]
async fn refresh() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"amount_due":-9007199254740993,"applied_credits":9007199254740993,"coupons":[{"coupon_id":"sample","name":"sample","total":-9007199254740993}],"created_at":"2024-03-15T10:30:45.123+02:00","currency":"NAD","custom_properties":{"key":"value","count":3,"ratio":0.5,"flags":[true,false],"nested":{"ok":true}},"customer_details":{"id":"customer_id_62","name":"sample","snapshot_at":"2024-03-15T10:30:45.123+02:00"},"customer_id":"customer_id_90","id":"invoice_id_31","invoice_date":"1999-12-31","invoice_number":"sample","invoice_type":"ONE_OFF","line_items":[{"amount_total":9007199254740993,"end_date":"1999-12-31","name":"sample","start_date":"1999-12-31","sub_line_items":[{"id":"sample","name":"sample","quantity":"-0.000123","total":-9007199254740993,"unit_price":"-0.000123"}],"tax_rate":"-0.000123"}],"net_terms":-2147483648,"payment_status":"UNPAID","status":"DRAFT","subtotal":9007199254740993,"subtotal_recurring":9007199254740993,"tax_amount":-9007199254740993,"tax_breakdown":[{"name":"sample","tax_amount":9007199254740993,"tax_rate":"-0.000123","taxable_amount":9007199254740993}],"total":9007199254740993,"transactions":[{"amount":9007199254740993,"currency":"sample","id":"payment_transaction_id_56","payment_type":"REFUND","status":"CANCELLED"}]}"#,
    );
    client.invoices().refresh("invoice_id").await.unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["POST /api/v1/invoices/invoice_id/refresh"]
    );
}

#[tokio::test]
async fn download_xml() {
    let (client, requests) = mock(200, Some("application/octet-stream"), r#"sample"#);
    client.invoices().download_xml("invoice_id").await.unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["GET /api/v1/invoices/invoice_id/xml"]
    );
}
