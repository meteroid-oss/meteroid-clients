# Changelog

## Version 0.25.0

* Credit notes: new `CreditNotes` endpoints `list_credit_notes`, `get_credit_note_by_id` and `patch_credit_note_custom_properties`, and new models (`CreditNote`, `CreditNoteListResponse`, `CreditNoteCustomPropertiesRequest`, `CreditType`)
* Custom properties: new `CustomProperties` resource on the client (`list_definitions`, `create_definition`, `get_definition`, `update_definition`, `archive_definition`), a `patch_invoice_custom_properties` endpoint, a `custom_properties` field on `Customer`, `Invoice`, `Subscription` and `CreditNote`, and new models (`CustomPropertyDefinition`, `CustomPropertyType`, `CustomPropertyEntityType`, `PropertyConfig`, `SelectOption`)
* Config entitlements: new models (`ConfigValue`, `ConfigValueType`, `ConfigFeatureType`, `ConfigEntitlementValue`, `ConfigEffectiveEntitlementValue`, `ConfigResolvedEntitlementValue`, `BooleanConfigValue`, `NumberConfigValue`, `TextConfigValue`, `JsonConfigValue`)
* Metric filters (`MetricFilter`, `MetricFilterOperator`) and `SubscriptionUpdateType` on subscription webhooks
* **Breaking** — `TierRow.flat_fee` and `flat_cap` are optional; they were wrongly required, so `TierRow::new` no longer takes them
* **Breaking** — `Coupon` is now the coupons resource, gaining `created_at`, `archived_at`, `redemption_count` and `plan_ids`, with `description` now optional; the subscription-embedded subset is `SubscriptionCoupon`
* **Breaking** — `Customer::new` takes `custom_properties`
* **Breaking** — `create_portal_token` takes a `CustomerPortalTokenRequest` body
* The entitlements product reference is now `EntitlementProductRef`; `ProductRef` remains the `EXISTING`/`NEW` union used when creating subscriptions
* `CreditNoteEventData.line_items` and `tax_breakdown` are typed as `InvoiceLineItem` and `TaxBreakdownItem` instead of untyped arrays

## Version 0.24.0

* Plan minimum commitments: new `Plans` endpoints `set_plan_minimum` (`PUT /plans/versions/{plan_version_id}/minimum`) and `delete_plan_minimum` (`DELETE`), new `minimum_commitment` field on `Plan`, `ReplacePlanRequest` and `Subscription`, and new models (`MinimumCommitment`, `MinimumCommitmentInput`, `MinimumCommitmentScope`, `MinimumCommitmentInputScope`, `AllComponentsScope`, `ProductsScope`, `ComponentsScope`)
* Clarified `Feature.code` documentation

## Version 0.23.0

* Entitlements support: new `Features` API and entitlement models (`Entitlement`, `EffectiveEntitlement`, `ResolvedEntitlement`, feature types, reset periods, etc.)

## Version 0.22.0

* Decimal support (`BigDecimal` in Java, `rust_decimal::Decimal` in Rust)

## Version 0.0.0 (Initial)

- java and rust sdks
