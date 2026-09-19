#!/usr/bin/env bash
# Developer helper: run a single Python codegen task straight into the working
# tree, skipping the full `./regen_openapi.py` sweep. Usage:
#   python/scripts/dev_codegen_one.sh <template-basename> <output-dir>
# e.g. python/scripts/dev_codegen_one.sh component_type python/meteroid/models
set -euo pipefail

cd "$(dirname "$0")/../.."
ROOT="$(pwd)"
TPL="$1"
OUT="$2"
IMAGE="${IMAGE:-ghcr.io/meteroid-oss/openapi-codegen:latest}"

mkdir -p "${OUT}"
docker run --rm -w /app \
    --mount "type=bind,src=${ROOT}/spec/openapi.json,dst=/app/openapi.json,ro" \
    --mount "type=bind,src=${ROOT}/codegen/templates/python,dst=/app/codegen/templates/python,ro" \
    -v "${ROOT}/${OUT}:/app/${OUT}" \
    "${IMAGE}" \
    openapi-codegen generate --no-postprocess \
    "--template=codegen/templates/python/${TPL}.py.jinja" \
    --input-file=openapi.json \
    "--output-dir=${OUT}"

# The container runs as root, so hand the freshly written files back to the
# invoking user.
docker run --rm -v "${ROOT}/${OUT}:/out" --entrypoint chown "${IMAGE}" \
    -R "$(id -u):$(id -g)" /out
