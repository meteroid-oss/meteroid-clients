module github.com/meteroid-oss/meteroid-clients/examples/backends/go

go 1.22

require github.com/meteroid-oss/meteroid-clients/go v0.0.0

// The SDK is consumed by path, the way the Rust backend uses `path = "../../../rust"`:
// the demo always builds against the SDK in this repository, not a published one.
replace github.com/meteroid-oss/meteroid-clients/go => ../../../go
