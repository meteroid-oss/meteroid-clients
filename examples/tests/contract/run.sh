#!/usr/bin/env bash
#
# Run the Scribe contract suite against one backend.
#
#   ./run.sh                          # BASE_URL from the environment, or localhost:8080
#   ./run.sh http://localhost:8081    # the Java backend
#   ./run.sh http://localhost:8080 --reporter=dot -t webhook
#
# Anything after the URL is passed straight to vitest.
#
# The suite needs a live backend that is itself talking to a real Meteroid tenant with the
# catalog from examples/CATALOG.md seeded. See README.md in this directory.

set -euo pipefail

here="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
examples_dir="$(cd "${here}/../.." && pwd)"

# --- the backend to drive ------------------------------------------------------------

base_url="${BASE_URL:-}"
if [[ $# -gt 0 && "$1" != -* ]]; then
  base_url="$1"
  shift
fi

# --- configuration -------------------------------------------------------------------
#
# examples/.env holds the same values the backends read: the webhook signing secret (the
# suite signs its own payloads with it) and, optionally, the session secret plus a
# subscribed customer alias. Values already in the environment win, so CI can override
# anything without editing a file. Nothing here is printed.

env_file="${examples_dir}/.env"
if [[ -f "${env_file}" ]]; then
  while IFS= read -r line || [[ -n "${line}" ]]; do
    [[ "${line}" =~ ^[[:space:]]*# ]] && continue
    [[ "${line}" =~ ^[[:space:]]*$ ]] && continue
    key="${line%%=*}"
    value="${line#*=}"
    key="$(printf '%s' "${key}" | tr -d '[:space:]')"
    [[ -z "${key}" ]] && continue
    # Strip one layer of surrounding quotes, if present.
    value="${value%\"}"; value="${value#\"}"
    value="${value%\'}"; value="${value#\'}"
    if [[ -z "${!key:-}" ]]; then
      export "${key}=${value}"
    fi
  done < "${env_file}"
  echo "Loaded configuration from ${env_file} (values already set in the environment win)."
fi

base_url="${base_url:-${BASE_URL:-http://localhost:8080}}"
base_url="${base_url%/}"
export BASE_URL="${base_url}"
# Vitest overwrites process.env.BASE_URL with Vite's base path inside the test worker, so
# the real value also travels under a name nothing else claims. vitest.config.ts forwards
# it too; setting it here means `run.sh` works even if that config is bypassed.
export SCRIBE_BASE_URL="${base_url}"

# --- preflight -------------------------------------------------------------------------

echo "Contract suite → ${BASE_URL}"

if [[ ! -d "${here}/node_modules" ]]; then
  echo "Installing test dependencies…"
  npm --prefix "${here}" install --no-audit --no-fund
fi

if command -v curl > /dev/null 2>&1; then
  if ! health="$(curl --silent --show-error --max-time 10 "${BASE_URL}/api/health" 2>&1)"; then
    cat >&2 <<EOF

No backend answered ${BASE_URL}/api/health.

Start one first, from the repository root:
  cargo run --manifest-path examples/backends/rust/Cargo.toml   # :8080
  ./gradlew -p examples/backends/java run                       # :8081

The suite will still run — every test will fail with a connection error, which is not
very informative. Aborting instead.
EOF
    exit 1
  fi
  echo "Backend says: ${health}"
fi

if [[ -z "${METEROID_WEBHOOK_SECRET:-}" ]]; then
  echo "Note: METEROID_WEBHOOK_SECRET is not set — the webhook tests will skip."
fi
if [[ -z "${SCRIBE_SUBSCRIBED_SESSION_TOKEN:-}" && -z "${SCRIBE_SUBSCRIBED_CUSTOMER_ALIAS:-}" ]]; then
  echo "Note: no subscribed workspace configured — the metered, quota and invoice-content tests will skip."
fi

# --- run ---------------------------------------------------------------------------------

exec npm --prefix "${here}" test -- "$@"
