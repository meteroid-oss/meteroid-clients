# meteroid-clients

Libraries to interact with [Meteroid's REST API](https://api.meteroid.com/api-docs/openapi.json)

Refer to each SDK's readme for usage.

## Spec sync and releases

`spec/openapi.json` is pushed here automatically by the `SDK sync` workflow of
[meteroid-oss/enterprise](https://github.com/meteroid-oss/enterprise) whenever the public API spec
changes on its `main`. For each sync it:

1. runs `scripts/spec_sync.py`, which copies the spec, bumps `.version` to the API version
   (`spec/api/v1/VERSION` upstream; the next patch when this repo is already past it), pins that
   version in `rust/src/api_version.rs` / `ApiVersion.java` (sent as the `Meteroid-Version`
   header), drafts the `CHANGELOG.md` entry from `oasdiff changelog` and records the source commit
   in `spec/SOURCE`;
2. runs `./regen_openapi.py`;
3. opens a `spec-sync/<version>` PR labelled `spec-sync` with auto-merge enabled.

The existing CI (Codegen consistency, Rust Lint, Java Build & Test) is the gate. Once `.version`
lands on `main`, `Mega Releaser` runs and the Rust and Java releases follow.

SDK-only fixes between syncs: bump with `node scripts/bump_version.js <patch version>` and merge;
the next sync moves on to the API version.

Repository settings this relies on: *Allow auto-merge* enabled, branch protection on `main`
requiring the three checks above, and an `SDK_SYNC_TOKEN` secret in `enterprise` with
`contents` and `pull-requests` write access to this repository.

### Thanks

Codegen is based on the work initiated by [Svix](https://github.com/svix/svix-webhooks), thanks to them !
