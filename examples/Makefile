# Scribe demo — one entry point for N backends.
#
#     make help
#
# Every target loads `.env` from this directory (see .env.example). Nothing here
# hard-codes a credential.

.DEFAULT_GOAL := help
SHELL := /bin/bash

# `-include` so `make help` and `make check` still work before anyone has written a
# .env. `export` pushes every variable in it into each recipe's environment, which is
# how one file ends up driving the backends, the SPA and both test suites.
-include .env
export

# Which backend a BACKEND-parameterized target acts on.
BACKEND ?= rust

# Ports are pinned per backend rather than taken from .env, so `make run-rust` and
# `make run-java` can run side by side in two terminals. Every backend reads PORT
# first, so this wins over anything in .env. Override on the command line:
#     make run-rust PORT=9000
RUST_PORT  ?= 8080
JAVA_PORT  ?= 8081
TS_PORT    ?= 8082
PY_PORT    ?= 8083
GO_PORT    ?= 8084

# The URL a BACKEND-parameterized target drives.
BACKEND_URL_rust       := http://localhost:$(RUST_PORT)
BACKEND_URL_java       := http://localhost:$(JAVA_PORT)
BACKEND_URL_typescript := http://localhost:$(TS_PORT)
BACKEND_URL_python     := http://localhost:$(PY_PORT)
BACKEND_URL_go         := http://localhost:$(GO_PORT)
BACKEND_URL := $(BACKEND_URL_$(BACKEND))

GRADLE := backends/java/gradlew --quiet -p backends/java

# The TypeScript backend depends on the SDK by path, the way the Rust one does — but an
# npm package is consumed through its compiled `dist/`, which is build output and not
# committed. So the SDK is installed and built on demand (see the `misc` section);
# nothing tracked under ../typescript is touched.
TS_BACKEND := backends/typescript
TS_SDK     := ../typescript

# The Python SDK is pure Python and linked by path, so `uv sync` is the whole install.
PY_BACKEND := backends/python
UV_PY      := uv run --locked --directory $(PY_BACKEND)

# The Go backend uses a local `go` when there is one and the golang image otherwise, so
# nothing here requires a Go install. The container mounts the repository root because
# the SDK is a path `replace` (../../../go); -buildvcs=false because a git worktree's
# .git points outside that mount.
GO_BACKEND := backends/go
GO_IMAGE   ?= golang:1.24
REPO_ROOT  := $(abspath ..)
DOCKER_GO  := docker run --rm -u $$(id -u):$$(id -g) -e HOME=/tmp -e GOCACHE=/tmp/gocache \
	-e GOFLAGS=-buildvcs=false -v $(REPO_ROOT):/w -w /w/examples/$(GO_BACKEND)
ifeq ($(shell go version >/dev/null 2>&1 && echo yes),yes)
GO_SH     = cd $(GO_BACKEND) && sh -c
GO_RUN_SH = cd $(GO_BACKEND) && PORT=$(GO_PORT) sh -c
else
GO_SH     = $(DOCKER_GO) $(GO_IMAGE) sh -c
GO_RUN_SH = $(DOCKER_GO) --network host $(if $(wildcard .env),--env-file .env) -e PORT=$(GO_PORT) \
	$(foreach v,METEROID_API_KEY METEROID_BASE_URL METEROID_WEBHOOK_SECRET SCRIBE_SESSION_SECRET SCRIBE_DEFAULT_CURRENCY,$(if $($(v)),-e $(v))) \
	$(GO_IMAGE) sh -c
endif

.PHONY: help
help: ## Show this help
	@echo ''
	@echo '  Scribe — a Meteroid SDK example app'
	@echo ''
	@grep -hE '^[a-zA-Z0-9_-]+:.*?## .*$$' $(MAKEFILE_LIST) \
		| awk 'BEGIN {FS = ":.*?## "}; {printf "  \033[36m%-22s\033[0m %s\n", $$1, $$2}'
	@echo ''
	@echo '  Backends listen on: rust $(RUST_PORT) · java $(JAVA_PORT) · typescript $(TS_PORT) · python $(PY_PORT) · go $(GO_PORT)'
	@echo '  Targets marked [BACKEND] take BACKEND=rust|java|typescript|python|go, e.g. make test-contract BACKEND=java'
	@echo ''

# ------------------------------------------------------------------ run

.PHONY: run-rust
run-rust: ## Run the Rust backend (port 8080)
	PORT=$(RUST_PORT) cargo run --manifest-path backends/rust/Cargo.toml

.PHONY: run-java
run-java: ## Run the Java backend (port 8081)
	PORT=$(JAVA_PORT) $(GRADLE) run

.PHONY: run-typescript
run-typescript: $(TS_BACKEND)/node_modules ## Run the TypeScript backend (port 8082)
	PORT=$(TS_PORT) npm --prefix $(TS_BACKEND) start

.PHONY: run-python
run-python: ## Run the Python backend (port 8083)
	PORT=$(PY_PORT) $(UV_PY) python -m scribe

.PHONY: run-go
run-go: ## Run the Go backend (port 8084; in Docker when there is no local go)
	$(GO_RUN_SH) 'go run .'

.PHONY: run-frontend
run-frontend: frontend/node_modules ## Run the SPA against BACKEND (default rust)
	VITE_API_BASE_URL=$(BACKEND_URL) npm --prefix frontend run dev

# ------------------------------------------------------------------ test

.PHONY: test-contract
test-contract: tests/contract/node_modules ## [BACKEND] Contract suite against one backend
	@echo "==> contract suite against $(BACKEND) ($(BACKEND_URL))"
	tests/contract/run.sh $(BACKEND_URL)

.PHONY: test-contract-all
test-contract-all: ## Contract suite against every running backend, in turn
	@$(MAKE) test-contract BACKEND=rust
	@$(MAKE) test-contract BACKEND=java
	@$(MAKE) test-contract BACKEND=typescript
	@$(MAKE) test-contract BACKEND=python
	@$(MAKE) test-contract BACKEND=go

.PHONY: test-e2e
test-e2e: tests/e2e/node_modules ## [BACKEND] Playwright happy path (needs a running SPA)
	BASE_URL=$(BACKEND_URL) npm --prefix tests/e2e test

.PHONY: test-backends
test-backends: $(TS_BACKEND)/node_modules ## Every backend's own offline unit tests
	cargo test --manifest-path backends/rust/Cargo.toml
	$(GRADLE) test
	npm --prefix $(TS_BACKEND) test
	$(UV_PY) pytest -q
	$(GO_SH) 'go test ./...'

# ------------------------------------------------------------------ check

.PHONY: check
check: lint-contract typecheck ## Everything that can be verified without a tenant
	cargo clippy --manifest-path backends/rust/Cargo.toml --all-targets -- -D warnings
	cargo fmt --manifest-path backends/rust/Cargo.toml --check
	$(GRADLE) build
	$(UV_PY) ruff check .
	$(UV_PY) ruff format --check .
	$(GO_SH) 'test -z "$$(gofmt -l .)" && go vet ./...'

.PHONY: lint-contract
lint-contract: ## Validate openapi.yaml as OpenAPI and against the demo's modelling rules
	npx --yes @redocly/cli@latest lint openapi.yaml
	python3 lint_contract.py

.PHONY: typecheck
typecheck: frontend/node_modules tests/contract/node_modules tests/e2e/node_modules $(TS_BACKEND)/node_modules ## Typecheck the SPA, both suites and the TypeScript and Python backends
	npm --prefix frontend run typecheck
	npm --prefix tests/contract run typecheck
	npm --prefix tests/e2e run typecheck
	npm --prefix $(TS_BACKEND) run typecheck
	$(UV_PY) mypy

.PHONY: generate-api
generate-api: frontend/node_modules ## Regenerate the SPA's types from openapi.yaml
	npm --prefix frontend run generate:api
	@git diff --stat -- frontend/src/api/schema.ts

# ------------------------------------------------------------------ misc

.PHONY: install
install: frontend/node_modules tests/contract/node_modules tests/e2e/node_modules $(TS_BACKEND)/node_modules ## Install every npm and Python dependency
	uv sync --locked --directory $(PY_BACKEND)

frontend/node_modules: frontend/package-lock.json
	npm --prefix frontend ci
	@touch $@

tests/contract/node_modules: tests/contract/package-lock.json
	npm --prefix tests/contract ci
	@touch $@

tests/e2e/node_modules: tests/e2e/package-lock.json
	npm --prefix tests/e2e ci
	@touch $@

# The backend's node_modules holds a symlink to the SDK, so the SDK has to be built
# before the backend can import it — hence the prerequisite.
$(TS_BACKEND)/node_modules: $(TS_BACKEND)/package-lock.json $(TS_SDK)/dist/index.js
	npm --prefix $(TS_BACKEND) ci
	@touch $@

# `npm ci`, never `npm install`: the SDK's lockfile is tracked and belongs to the SDK.
# What this writes — node_modules/ and dist/ — is gitignored there.
$(TS_SDK)/dist/index.js: $(TS_SDK)/package-lock.json $(shell find $(TS_SDK)/src -name '*.ts' 2>/dev/null)
	npm --prefix $(TS_SDK) ci --no-audit --no-fund
	npm --prefix $(TS_SDK) run build
	@touch $@

.PHONY: health
health: ## Curl /api/health on BACKEND
	@curl -fsS $(BACKEND_URL)/api/health | (command -v jq >/dev/null && jq || cat)

.PHONY: clean
clean: ## Remove build output (keeps .env)
	rm -rf frontend/dist frontend/node_modules
	rm -rf tests/contract/node_modules tests/e2e/node_modules tests/e2e/test-results
	rm -rf $(TS_BACKEND)/node_modules
	rm -rf $(PY_BACKEND)/.venv $(PY_BACKEND)/.mypy_cache $(PY_BACKEND)/.pytest_cache $(PY_BACKEND)/.ruff_cache
	cargo clean --manifest-path backends/rust/Cargo.toml
	$(GRADLE) clean
