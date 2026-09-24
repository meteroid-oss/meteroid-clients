# meteroid-clients

Libraries to interact with [Meteroid's REST API](https://api.meteroid.com/api-docs/openapi.json)

Server SDKs, authenticated with your API key (never ship it to a browser):

| Language | Package | Directory |
| --- | --- | --- |
| TypeScript / JavaScript | [`@meteroid/sdk`](https://www.npmjs.com/package/@meteroid/sdk) | [`typescript/`](typescript) |
| Python | [`meteroid`](https://pypi.org/project/meteroid/) | [`python/`](python) |
| Go | `github.com/meteroid-oss/meteroid-clients/go` | [`go/`](go) |
| Java | `com.meteroid:meteroid-java` | [`java/`](java) |
| Rust | [`meteroid-rs`](https://crates.io/crates/meteroid-rs) | [`rust/`](rust) |

Frontend packages, authenticated with a short-lived token that your backend mints for the
signed-in customer:

| Package | Directory | |
| --- | --- | --- |
| [`@meteroid/browser`](https://www.npmjs.com/package/@meteroid/browser) | [`browser/`](browser) | Entitlements, usage, subscriptions and billing embeds, for any framework |
| [`@meteroid/react`](https://www.npmjs.com/package/@meteroid/react) | [`react/`](react) | Provider, hooks, `<Gate>`, `<UsageMeter>` and `<BillingEmbed>` for React |

`browser/` and `react/` form the npm workspace at the root of the repository.

Refer to each SDK's readme for usage.

### Thanks

Codegen is based on the work initiated by [Svix](https://github.com/svix/svix-webhooks), thanks to them !
