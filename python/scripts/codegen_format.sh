#!/usr/bin/env bash
#
# Post-processing step for the Python codegen.
#
# The codegen Docker image does not ship `ruff`, so the Python tasks run with
# `--no-postprocess` and formatting happens here, on the host, right after the
# generator wrote its files. Invoked from `codegen/codegen.toml`
# (`[python].extra_shell_commands`), with the repository root as cwd.
set -euo pipefail

RUFF_VERSION="0.14.10"
TARGET="python/meteroid"

# The pinned version wins: generated output is committed, so a different `ruff`
# on PATH would produce spurious diffs.
if command -v uvx >/dev/null 2>&1; then
    RUFF=(uvx "ruff@${RUFF_VERSION}")
elif command -v uv >/dev/null 2>&1; then
    RUFF=(uv tool run "ruff@${RUFF_VERSION}")
elif command -v ruff >/dev/null 2>&1; then
    RUFF=(ruff)
else
    echo "error: 'ruff' is required to post-process the generated Python SDK." >&2
    echo "       Install 'uv' (recommended) or pip install ruff==${RUFF_VERSION}." >&2
    exit 1
fi

# Same pipeline the codegen's built-in Python postprocessor would run:
# lint fixes (drops unused imports), import sorting, then formatting.
"${RUFF[@]}" check --no-respect-gitignore --fix --quiet "${TARGET}"
"${RUFF[@]}" check --no-respect-gitignore --select I --fix --quiet "${TARGET}"
"${RUFF[@]}" format --no-respect-gitignore --quiet "${TARGET}"
