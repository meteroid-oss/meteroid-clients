# meteroid-clients

Libraries to interact with [Meteroid's REST API](https://api.meteroid.com/api-docs/openapi.json)

Refer to each SDK's readme for usage.

## Spec sync and releases

`spec/openapi.json` is pushed here by the `SDK sync` workflow of
[meteroid-oss/enterprise](https://github.com/meteroid-oss/enterprise) when a release is published
there (or on demand for a ref). Three versions are involved, each with one meaning:

| | Example | Set by |
|---|---|---|
| App release | `v1.14.0` | release-drafter in enterprise |
| API version | `2026-09-20` | `spec/api/v1/VERSION` in enterprise: a dated snapshot of the wire format, sent by the SDKs as `Meteroid-Version` |
| SDK version | `0.28.0` | `scripts/spec_sync.py`, from the change: breaking (per oasdiff) → major (minor while 0.x), otherwise minor; SDK-only fixes → patch by hand |

For each sync the workflow:

1. runs `scripts/spec_sync.py`, which copies the spec, bumps `.version`, pins the API version in
   `rust/src/api_version.rs` / `ApiVersion.java`, drafts the `CHANGELOG.md` entry from
   `oasdiff changelog` and records the source release, commit and API version in `spec/SOURCE`;
2. runs `./regen_openapi.py`;
3. opens a `spec-sync/<api version>` PR labelled `spec-sync` with auto-merge enabled.

The existing CI (Codegen consistency, Rust Lint, Java Build & Test) is the gate. Once `.version`
lands on `main`, `Mega Releaser` runs and the Rust and Java releases follow.

SDK-only fixes between syncs: `node scripts/bump_version.js <patch version>`, merge, released the
same way.

Repository settings this relies on: *Allow auto-merge* enabled, branch protection on `main`
requiring the three checks above, and an `SDK_SYNC_TOKEN` secret in `enterprise` with
`contents` and `pull-requests` write access to this repository.

### Thanks

Codegen is based on the work initiated by [Svix](https://github.com/svix/svix-webhooks), thanks to them !
