# Changelog

## Next

* New TypeScript SDK (`typescript/`, published as `@meteroid/sdk` on npm): typed models and resources, bearer auth, retries and webhook signature verification
* New Python SDK (`python/`, published as `meteroid` on PyPI): sync + asyncio clients, dataclass models, bearer auth, retries and webhook signature verification
* **Breaking** (Rust) — API errors are now parsed with the models generated from the spec. `Error::Http` carries `HttpErrorContent<RestErrorResponse>` (`code: ErrorCode`, `message`), a new `Error::OAuth` carries `HttpErrorContent<OAuthErrorResponse>`, and `Error::Validation` is removed (the API returns no 422 validation body; any status goes through `Error::Http`/`Error::OAuth`). The hand-written `HttpErrorOut`, `HttpValidationError` and `ValidationError` models are removed. The old `HttpErrorOut` required a `detail` field the API never sends, so `payload` was `None` for every real API error: no working code could have depended on its fields. New `Error::status()`, `code()` and `message()` accessors. Status and raw body remain available on every HTTP error
* Error response models are now generated from the spec: `RestErrorResponse`, `ErrorCode`, `OAuthErrorResponse`, `OAuthErrorCode`. A body with an error code unknown to the SDK version yields no typed payload; status and raw body are still available
* Java: `ApiException` gains `getError()` (`Optional<RestErrorResponse>`) and `getOAuthError()` (`Optional<OAuthErrorResponse>`); the existing constructor and getters are unchanged
* Java: webhook verification now gives `webhook-*` headers precedence, using `svix-*` only when the matching `webhook-*` header is absent, like the other SDKs. Previously `svix-*` headers overwrote `webhook-*` ones
* Java: the published POM's project and SCM URLs, and the Rust crate's `repository`, now point at `meteroid-oss/meteroid-clients`
* Codegen: generation fails loudly on unsupported operations or components instead of silently dropping them
* Java: `jackson-core`, `jackson-databind`, `jackson-annotations` and `standardwebhooks` are now `compile`-scope dependencies (Gradle `api`). `Webhook.verify`/`sign` throw standard-webhooks exceptions and every model's `fromJson`/`toJson` throws `JsonProcessingException`, so code catching them did not compile against the published artifact
* Java: the `Meteroid` Javadoc example called `getCustomer()`; the getter is `getCustomers()`

## Version 0.26.0

* Invoice lifecycle: new `CLOSED` invoice status (empty recurring invoice closed with nothing to bill) and the matching `invoice.closed` webhook event, plus a new `invoice.deleted` event for draft deletions
* New `billing_period_start` on `Invoice` — the period the invoice is about, stable and distinct from `invoice_date` (the emission date)
* New `backdate_invoices` on `SubscriptionCreateRequest` for historical imports: finalized invoices keep their billing-period date instead of the emission date
* Payments: `PROCESSING` added to `InvoicePaymentStatus`, `REFUNDED` added to `PaymentStatusEnum`
* Invoicing language: new `invoicing_language` on `Customer`, `CustomerCreateRequest`, `CustomerUpdateRequest` and `CustomerPatchRequest`
* Tax: new `exemption_reason` on the customer create/update/patch requests, new `exemption_reason` and `tax_reference` on `TaxBreakdownItem`, and `EXPORT` added to `TaxExemptionType`

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
