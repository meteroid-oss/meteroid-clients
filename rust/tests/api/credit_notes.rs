// this file is @generated
use crate::{decode, mock};

#[tokio::test]
async fn list() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"data":[{"created_at":"2023-12-31T23:59:59.999-05:30","credit_note_number":"sample","credit_type":"DEBT_CANCELLATION","credited_amount_cents":9007199254740993,"currency":"TMT","custom_properties":{"key":"value","count":3,"ratio":0.5,"flags":[true,false],"nested":{"ok":true}},"customer_id":"customer_id_78","id":"credit_note_id_47","invoice_id":"invoice_id_67","invoice_number":"sample","line_items":[{"amount_total":-9007199254740993,"end_date":"2024-02-29","name":"sample","start_date":"2024-02-29","sub_line_items":[{"id":"sample","name":"sample","quantity":"-0.000123","total":9007199254740993,"unit_price":"-0.000123"}],"tax_rate":"-0.000123"}],"refunded_amount_cents":9007199254740993,"status":"DRAFT","subtotal":-9007199254740993,"tax_amount":9007199254740993,"tax_breakdown":[{"name":"sample","tax_amount":-9007199254740993,"tax_rate":"-0.000123","taxable_amount":-9007199254740993}],"total":-9007199254740993}],"pagination_meta":{"page":-123456789,"per_page":-123456789,"total_items":-9007199254740993,"total_pages":123456789}}"#,
    );
    client.credit_notes().list(None).await.unwrap();
    assert_eq!(*requests.lock().unwrap(), ["GET /api/v1/credit-notes"]);
}

#[tokio::test]
async fn retrieve() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"created_at":"2023-12-31T23:59:59.999-05:30","credit_note_number":"sample","credit_type":"REFUND","credited_amount_cents":9007199254740993,"currency":"MMK","custom_properties":{"key":"value","count":3,"ratio":0.5,"flags":[true,false],"nested":{"ok":true}},"customer_id":"customer_id_13","id":"credit_note_id_99","invoice_id":"invoice_id_90","invoice_number":"sample","line_items":[{"amount_total":-9007199254740993,"end_date":"2024-02-29","name":"sample","start_date":"1999-12-31","sub_line_items":[{"id":"sample","name":"sample","quantity":"12345.6789","total":-9007199254740993,"unit_price":"12345.6789"}],"tax_rate":"-0.000123"}],"refunded_amount_cents":-9007199254740993,"status":"DRAFT","subtotal":9007199254740993,"tax_amount":9007199254740993,"tax_breakdown":[{"name":"sample","tax_amount":9007199254740993,"tax_rate":"12345.6789","taxable_amount":9007199254740993}],"total":-9007199254740993}"#,
    );
    client
        .credit_notes()
        .retrieve("credit_note_id")
        .await
        .unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["GET /api/v1/credit-notes/credit_note_id"]
    );
}

#[tokio::test]
async fn update_custom_properties() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"created_at":"2023-12-31T23:59:59.999-05:30","credit_note_number":"sample","credit_type":"REFUND","credited_amount_cents":9007199254740993,"currency":"MMK","custom_properties":{"key":"value","count":3,"ratio":0.5,"flags":[true,false],"nested":{"ok":true}},"customer_id":"customer_id_13","id":"credit_note_id_99","invoice_id":"invoice_id_90","invoice_number":"sample","line_items":[{"amount_total":-9007199254740993,"end_date":"2024-02-29","name":"sample","start_date":"1999-12-31","sub_line_items":[{"id":"sample","name":"sample","quantity":"12345.6789","total":-9007199254740993,"unit_price":"12345.6789"}],"tax_rate":"-0.000123"}],"refunded_amount_cents":-9007199254740993,"status":"DRAFT","subtotal":9007199254740993,"tax_amount":9007199254740993,"tax_breakdown":[{"name":"sample","tax_amount":9007199254740993,"tax_rate":"12345.6789","taxable_amount":9007199254740993}],"total":-9007199254740993}"#,
    );
    client.credit_notes().update_custom_properties("credit_note_id", decode::<meteroid_rs::models::CreditNoteCustomPropertiesRequest>(r#"{"custom_properties":{"key":"value","count":3,"ratio":0.5,"flags":[true,false],"nested":{"ok":true}}}"#)).await.unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["PATCH /api/v1/credit-notes/credit_note_id/custom-properties"]
    );
}

#[tokio::test]
async fn download() {
    let (client, requests) = mock(200, Some("application/octet-stream"), r#"sample"#);
    client
        .credit_notes()
        .download("credit_note_id")
        .await
        .unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["GET /api/v1/credit-notes/credit_note_id/download"]
    );
}

#[tokio::test]
async fn download_xml() {
    let (client, requests) = mock(200, Some("application/octet-stream"), r#"sample"#);
    client
        .credit_notes()
        .download_xml("credit_note_id")
        .await
        .unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["GET /api/v1/credit-notes/credit_note_id/xml"]
    );
}
