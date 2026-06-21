# Changelog

## Version 0.24.0

* Plan minimum commitments: new `Plans` endpoints `set_plan_minimum` (`PUT /plans/versions/{plan_version_id}/minimum`) and `delete_plan_minimum` (`DELETE`), new `minimum_commitment` field on `Plan`, `ReplacePlanRequest` and `Subscription`, and new models (`MinimumCommitment`, `MinimumCommitmentInput`, `MinimumCommitmentScope`, `MinimumCommitmentInputScope`, `AllComponentsScope`, `ProductsScope`, `ComponentsScope`)
* Clarified `Feature.code` documentation

## Version 0.23.0

* Entitlements support: new `Features` API and entitlement models (`Entitlement`, `EffectiveEntitlement`, `ResolvedEntitlement`, feature types, reset periods, etc.)

## Version 0.22.0

* Decimal support (`BigDecimal` in Java, `rust_decimal::Decimal` in Rust)

## Version 0.0.0 (Initial)

- java and rust sdks
