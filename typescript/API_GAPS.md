# Meteroid TypeScript SDK — known API gaps

Things a user may reasonably expect that the API (and therefore this generated SDK) does not
offer today. Everything here was re-verified against `spec/openapi.json`.

If you need one of these, please open an issue at
<https://github.com/meteroid-oss/meteroid/issues>.

## Dates are split between two representations

This mirrors the spec rather than being an SDK choice:

- `format: date-time` fields (`createdAt`, `finalizedAt`, `activatedAt`, …) are `Date`.
- `format: date` fields (`startDate`, `endDate`, `invoiceDate`, `billingStartDate`,
  `billingPeriodStart`, `dueDate`, …) are ISO `YYYY-MM-DD` **strings**.

## Decimals are strings

`format: decimal` fields (`rate`, `flatFee`, `flatCap`, `unitPrice`, `invoiceThreshold`, …)
travel over the wire as exact decimal strings and are typed `string` in TypeScript, since
`number` cannot represent them losslessly. Use a decimal library if you need to do arithmetic
on them.

## Lookup keys are not uniform

- Customer endpoints take an `idOrAlias` path parameter (a UUID or the customer alias).
- Product families take `idOrAlias` too (`getProductFamilyByIdOrAlias`).
- Subscriptions, invoices, credit notes, plans and metrics are id-only.
