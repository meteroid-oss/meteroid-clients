//! Guards on the *shape* of what this backend serializes.
//!
//! `examples/openapi.yaml` makes one rule that a strict statically-typed client depends
//! on entirely: **in responses, nullable means present-and-null, never absent.** Every
//! property of every response schema is in `required`, and optionality is expressed as
//! the type union `[T, "null"]`. In Rust that means no `skip_serializing_if` anywhere in
//! `dto.rs` — and nothing in the compiler stops someone from adding one, so the tests
//! below do.
//!
//! [`samples`] additionally builds one populated instance of every response schema. Set
//! `SCRIBE_SAMPLE_OUT=<path>` and run `cargo test dumps_one_sample_per_response_schema`
//! to write them out, then validate that file against `examples/openapi.yaml` with any
//! JSON Schema tool — that is how these types were checked against the contract.

use std::collections::HashMap;

use serde_json::{json, Value};

use crate::{
    dto::*,
    error::{ApiError, ErrorCode},
};

fn quota() -> QuotaSnapshot {
    QuotaSnapshot {
        feature_code: "transcription_minutes".into(),
        enabled: true,
        limit: Some("60".into()),
        consumed: Some("56.5".into()),
        remaining: Some("3.5".into()),
        reset_at: Some("2026-10-01T00:00:00Z".into()),
        unlimited: false,
    }
}

fn plan() -> Plan {
    Plan {
        code: PlanCode::Pro,
        name: "Scribe Pro".into(),
        description: None,
        plan_id: "plan_1".into(),
        plan_version_id: "pv_1".into(),
        version: 1,
        currency: "USD".into(),
        is_free: false,
        trial_days: Some(14),
        prices: vec![PlanPrice {
            component_id: "pc_1".into(),
            name: "Pro monthly".into(),
            kind: "RATE",
            cadence: Some("MONTHLY".into()),
            amount: Some("29".into()),
            unit_amount: None,
            included_amount: None,
            unit_name: None,
            pricing_model: None,
        }],
        features: vec![PlanFeatureLine {
            feature_code: "sso".into(),
            label: "SSO included".into(),
        }],
    }
}

fn workspace() -> Workspace {
    Workspace {
        id: "scribe-demo-8f2a1c".into(),
        name: "Scribe demo workspace".into(),
        customer_id: "cus_7n42DGM5Tflk9n8mt7Fhc7".into(),
        customer_alias: "scribe-demo-8f2a1c".into(),
        currency: "USD".into(),
    }
}

fn transcription() -> Transcription {
    Transcription {
        id: "tr_1".into(),
        title: "Weekly standup".into(),
        duration_seconds: 210,
        minutes_billed: "3.5".into(),
        text: "[demo transcript] …".into(),
        created_at: "2026-09-01T12:00:00Z".into(),
        event_id: "tr_1".into(),
    }
}

/// One populated instance per response schema, keyed by its schema name in
/// `examples/openapi.yaml`.
fn samples() -> Value {
    json!({
        "Health": Health {
            status: "ok",
            backend: "rust",
            meteroid_configured: true,
            version: Some("1.0.0".into()),
        },
        "CreateSessionResponse": CreateSessionResponse {
            session_token: "v1.c2NyaWJlLWRlbW8.c2ln".into(),
            workspace: workspace(),
        },
        "MeResponse": MeResponse {
            workspace: workspace(),
            subscription: Some(Subscription {
                id: "sub_1".into(),
                status: "ACTIVE".into(),
                plan_code: Some(PlanCode::Pro),
                plan_name: "Scribe Pro".into(),
                plan_version_id: "pv_1".into(),
                currency: "USD".into(),
                current_period_start: "2026-09-01".into(),
                current_period_end: Some("2026-09-30".into()),
                trial_duration_days: Some(14),
                created_at: "2026-09-01T12:00:00Z".into(),
            }),
            plan: Some(plan()),
        },
        "PlanListResponse": PlanListResponse { plans: vec![plan()] },
        "CreateCheckoutResponse": CreateCheckoutResponse {
            checkout_url: "https://checkout.meteroid.com/cs_1".into(),
            checkout_session_id: "cs_1".into(),
            plan_code: PlanCode::Pro,
            plan_version_id: "pv_1".into(),
            expires_at: Some("2026-09-01T13:00:00Z".into()),
        },
        "EntitlementListResponse": EntitlementListResponse {
            entitlements: vec![
                Entitlement {
                    feature_code: "sso".into(),
                    feature_name: "SSO".into(),
                    value: EntitlementValue::Boolean { enabled: true },
                },
                Entitlement {
                    feature_code: "transcription_minutes".into(),
                    feature_name: "Transcription minutes".into(),
                    value: EntitlementValue::Metered {
                        enabled: true,
                        limit: Some("60".into()),
                        consumed: Some("1".into()),
                        remaining: Some("59".into()),
                        unlimited: false,
                        reset_at: Some("2026-10-01T00:00:00Z".into()),
                        reset_period: ResetPeriod {
                            kind: "CALENDAR",
                            interval: Some(1),
                            unit: Some("MONTH".into()),
                        },
                        metric_code: Some("transcription_minutes".into()),
                    },
                },
                Entitlement {
                    feature_code: "retention_days".into(),
                    feature_name: "Retention days".into(),
                    value: EntitlementValue::Config { value: ConfigValue::Number("90".into()) },
                },
                Entitlement {
                    feature_code: "branding".into(),
                    feature_name: "Branding".into(),
                    value: EntitlementValue::Config {
                        value: ConfigValue::Json(json!({ "logo": "https://example.test/logo.png" })),
                    },
                },
            ],
        },
        "TranscriptionListResponse": TranscriptionListResponse {
            transcriptions: vec![transcription()],
        },
        "CreateTranscriptionResponse": CreateTranscriptionResponse {
            transcription: transcription(),
            quota: quota(),
        },
        "UsageResponse": UsageResponse {
            period_start: "2026-09-01".into(),
            period_end: "2026-09-30".into(),
            scope: "subscription",
            metrics: vec![MetricUsage {
                metric_code: "transcription_minutes".into(),
                metric_name: "Transcription minutes".into(),
                total_value: "12.5".into(),
                grouped_usage: vec![GroupedUsage {
                    dimensions: HashMap::from([("region".to_string(), "eu".to_string())]),
                    value: "12.5".into(),
                }],
            }],
        },
        "CreatePortalSessionResponse": CreatePortalSessionResponse {
            portal_url: "https://portal.meteroid.com".into(),
            token: "eyJhbGciOi…".into(),
            expires_in_seconds: 86_400,
        },
        "InvoiceListResponse": InvoiceListResponse {
            invoices: vec![Invoice {
                id: "inv_1".into(),
                invoice_number: "INV-0001".into(),
                status: "DRAFT".into(),
                currency: "USD".into(),
                invoice_date: "2026-09-01".into(),
                due_date: Some("2026-09-15".into()),
                total: 2900,
                amount_due: 2900,
            }],
        },
        "WebhookAck": WebhookAck {
            received: true,
            event_id: "evt_1".into(),
            kind: Some("invoice.paid".into()),
            handled: true,
        },
        "Error": ApiError::new(ErrorCode::QuotaExhausted, "out of minutes")
            .with_quota(quota())
            .with_upgrade(Some(PlanCode::Pro)),
    })
}

/// Assert that `object` serializes every one of `keys`, present even when null.
fn assert_keys(value: &Value, keys: &[&str]) {
    let object = value.as_object().expect("a JSON object");
    for key in keys {
        assert!(
            object.contains_key(*key),
            "`{key}` was omitted — response schemas must serialize every property, \
             null included. Did a `skip_serializing_if` sneak into dto.rs?\n{value:#}"
        );
    }
    assert_eq!(
        object.len(),
        keys.len(),
        "unexpected extra properties (every response schema is additionalProperties: false)\n{value:#}"
    );
}

#[test]
fn nullable_response_fields_are_serialized_as_null_not_omitted() {
    // Every optional field empty: the shape must not change.
    let subscription = serde_json::to_value(Subscription {
        id: "sub_1".into(),
        status: "PENDING_ACTIVATION".into(),
        plan_code: None,
        plan_name: "Something bespoke".into(),
        plan_version_id: "pv_9".into(),
        currency: "USD".into(),
        current_period_start: "2026-09-01".into(),
        current_period_end: None,
        trial_duration_days: None,
        created_at: "2026-09-01T12:00:00Z".into(),
    })
    .unwrap();
    assert_keys(
        &subscription,
        &[
            "id",
            "status",
            "plan_code",
            "plan_name",
            "plan_version_id",
            "currency",
            "current_period_start",
            "current_period_end",
            "trial_duration_days",
            "created_at",
        ],
    );
    assert!(subscription["plan_code"].is_null());
    assert!(subscription["current_period_end"].is_null());
    assert!(subscription["trial_duration_days"].is_null());

    let error = serde_json::to_value(ApiError::new(ErrorCode::Internal, "boom")).unwrap();
    assert_keys(&error, &["code", "message", "quota", "upgrade_plan_code"]);
    assert!(error["quota"].is_null());
    assert!(error["upgrade_plan_code"].is_null());

    let ack = serde_json::to_value(WebhookAck {
        received: true,
        event_id: "msg_1".into(),
        kind: None,
        handled: false,
    })
    .unwrap();
    assert_keys(&ack, &["received", "event_id", "type", "handled"]);
    assert!(ack["type"].is_null());
}

#[test]
fn the_unions_are_tagged_the_way_meteroid_tags_them() {
    // `type` on entitlement values, `kind` on config values — internally tagged, so a
    // strict decoder needs no discriminator support.
    let metered = serde_json::to_value(EntitlementValue::Metered {
        enabled: true,
        limit: None,
        consumed: None,
        remaining: None,
        unlimited: true,
        reset_at: None,
        reset_period: ResetPeriod {
            kind: "BILLING_CYCLE",
            interval: None,
            unit: None,
        },
        metric_code: None,
    })
    .unwrap();
    assert_eq!(metered["type"], "METERED");
    assert_keys(
        &metered,
        &[
            "type",
            "enabled",
            "limit",
            "consumed",
            "remaining",
            "unlimited",
            "reset_at",
            "reset_period",
            "metric_code",
        ],
    );

    let config = serde_json::to_value(EntitlementValue::Config {
        value: ConfigValue::Number("90".into()),
    })
    .unwrap();
    assert_eq!(config["type"], "CONFIG");
    assert_eq!(config["value"]["kind"], "NUMBER");
    // A decimal, as a string — never a JSON number.
    assert_eq!(config["value"]["value"], "90");
}

/// Opt-in: writes one sample per response schema to `$SCRIBE_SAMPLE_OUT` so it can be
/// validated against `examples/openapi.yaml`. A no-op when the variable is unset.
#[test]
fn dumps_one_sample_per_response_schema() {
    let Ok(path) = std::env::var("SCRIBE_SAMPLE_OUT") else {
        return;
    };
    std::fs::write(path, serde_json::to_string_pretty(&samples()).unwrap()).unwrap();
}
