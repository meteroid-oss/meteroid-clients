# meteroid-clients

> [!WARNING]
> **Deprecated.** This repository is no longer maintained. Each SDK now lives in its own
> repository, listed below, starting with version 0.27.0.

Libraries to interact with [Meteroid's REST API](https://api.meteroid.com/api-docs/openapi.json).

## SDKs

| Language | Repository | Package | Install |
|---|---|---|---|
| TypeScript / Node.js | [meteroid-node](https://github.com/meteroid-oss/meteroid-node) | [`@meteroid/node`](https://www.npmjs.com/package/@meteroid/node) | `npm install @meteroid/node` |
| Python | [meteroid-python](https://github.com/meteroid-oss/meteroid-python) | [`meteroid`](https://pypi.org/project/meteroid/) | `pip install meteroid` |
| Go | [meteroid-go](https://github.com/meteroid-oss/meteroid-go) | [`github.com/meteroid-oss/meteroid-go`](https://pkg.go.dev/github.com/meteroid-oss/meteroid-go) | `go get github.com/meteroid-oss/meteroid-go` |
| Java | [meteroid-java](https://github.com/meteroid-oss/meteroid-java) | [`com.meteroid:meteroid`](https://central.sonatype.com/artifact/com.meteroid/meteroid) | `implementation("com.meteroid:meteroid:0.27.0")` |
| Rust | [meteroid-rust](https://github.com/meteroid-oss/meteroid-rust) | [`meteroid-rs`](https://crates.io/crates/meteroid-rs) | `cargo add meteroid-rs` |
| C# / .NET | [meteroid-csharp](https://github.com/meteroid-oss/meteroid-csharp) | [`Meteroid`](https://www.nuget.org/packages/Meteroid) | `dotnet add package Meteroid` |

## Migrating

- **Python, Java, Rust:** same package names as before. Upgrade to 0.27.0 or later.
- **TypeScript:** the package is now `@meteroid/node`.
- **Go:** the module moved from `github.com/meteroid-oss/meteroid-clients/go` to
  `github.com/meteroid-oss/meteroid-go`. Update your imports.
- **C#:** new SDK.

The new SDKs are generated from the same OpenAPI spec by a different generator, so their APIs
may differ from these clients: check each repository's README.

### Thanks

Codegen is based on the work initiated by [Svix](https://github.com/svix/svix-webhooks), thanks to them !
