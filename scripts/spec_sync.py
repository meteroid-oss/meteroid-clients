#!/usr/bin/env python3
"""
Apply a new public API spec to this repository.

Called by the `SDK sync` workflow of meteroid-oss/enterprise (and usable by hand):

    scripts/spec_sync.py --spec /path/to/openapi.json --api-version 0.27.0 \
        --source-repo meteroid-oss/enterprise --source-sha <sha>

It copies the spec, bumps the SDK version to the API version (or the next patch when the SDK is
already past it), pins the API version the SDKs send in `Meteroid-Version`, drafts the CHANGELOG
entry from `oasdiff changelog` and records the source in spec/SOURCE. It does not regenerate
code: run ./regen_openapi.py afterwards.
"""

import argparse
import json
import os
import re
import shutil
import subprocess
import sys
from pathlib import Path

ROOT = Path(__file__).resolve().parent.parent
SPEC = ROOT / "spec" / "openapi.json"
SOURCE = ROOT / "spec" / "SOURCE"
VERSION_FILE = ROOT / ".version"
CHANGELOG = ROOT / "CHANGELOG.md"
RUST_API_VERSION = ROOT / "rust" / "src" / "api_version.rs"
JAVA_API_VERSION = ROOT / "java" / "src" / "main" / "java" / "com" / "meteroid" / "ApiVersion.java"
OASDIFF_IMAGE = os.getenv("OASDIFF_IMAGE", "tufin/oasdiff:latest")


def parse_version(v: str) -> tuple[int, int, int]:
    m = re.fullmatch(r"(\d+)\.(\d+)\.(\d+)", v.strip())
    if not m:
        sys.exit(f"not a MAJOR.MINOR.PATCH version: {v!r}")
    return tuple(int(x) for x in m.groups())


def github_output(**kv: str) -> None:
    path = os.getenv("GITHUB_OUTPUT")
    if not path:
        return
    with open(path, "a") as f:
        for k, v in kv.items():
            f.write(f"{k}={v}\n")


def oasdiff_changelog(old: Path, new: Path) -> list[dict]:
    """Structured change list from oasdiff, or [] when docker/oasdiff is unavailable."""
    docker = shutil.which("docker") or shutil.which("podman")
    if not docker:
        print("warning: docker not found, skipping oasdiff changelog", file=sys.stderr)
        return []
    work = Path(os.getenv("RUNNER_TEMP", "/tmp")) / "spec-sync-oasdiff"
    work.mkdir(parents=True, exist_ok=True)
    shutil.copy(old, work / "old.json")
    shutil.copy(new, work / "new.json")
    cmd = [docker, "run", "--rm", "-v", f"{work}:/w", OASDIFF_IMAGE,
           "changelog", "/w/old.json", "/w/new.json", "--format", "json"]
    res = subprocess.run(cmd, capture_output=True, text=True)
    if res.returncode not in (0, 1) or not res.stdout.strip():
        print(f"warning: oasdiff failed ({res.returncode}): {res.stderr.strip()}", file=sys.stderr)
        return []
    return json.loads(res.stdout)


def describe(changes: list[dict]) -> list[str]:
    """One bullet per distinct change; a schema change reported on every endpoint that returns
    it collapses to a single line. oasdiff's own version bookkeeping is dropped."""
    grouped: dict[str, list[str]] = {}
    for c in changes:
        if c.get("id", "").startswith("api-version"):
            continue
        text = c.get("text") or c.get("id", "changed")
        op = f"`{c['operation']} {c['path']}`" if c.get("operation") and c.get("path") else None
        if c.get("id", "").startswith("endpoint-") and op:
            text = f"{op} — {text}"
            op = None
        grouped.setdefault(text, [])
        if op and op not in grouped[text]:
            grouped[text].append(op)
    bullets = []
    for text, ops in grouped.items():
        if len(ops) == 1:
            bullets.append(f"{ops[0]} — {text}")
        elif ops:
            bullets.append(f"{text} ({len(ops)} endpoints)")
        else:
            bullets.append(text)
    return bullets


def bump_sdk_version(api_version: str) -> str:
    current = VERSION_FILE.read_text().strip()
    target = api_version if parse_version(api_version) > parse_version(current) else None
    if target is None:
        major, minor, patch = parse_version(current)
        target = f"{major}.{minor}.{patch + 1}"
    res = subprocess.run(["node", str(ROOT / "scripts" / "bump_version.js"), target],
                         capture_output=True, text=True, cwd=ROOT)
    if res.returncode != 0 or res.stderr.strip() or VERSION_FILE.read_text().strip() != target:
        sys.exit(f"bump_version.js failed: {res.stdout}{res.stderr}")
    return target


def write_api_version(api_version: str) -> None:
    RUST_API_VERSION.write_text(
        "// Written by scripts/spec_sync.py from the API spec version; do not edit.\n"
        "/// API version this SDK was generated against, sent as the `Meteroid-Version` header.\n"
        f'pub const API_VERSION: &str = "{api_version}";\n'
    )
    JAVA_API_VERSION.write_text(
        "package com.meteroid;\n\n"
        "// Written by scripts/spec_sync.py from the API spec version; do not edit.\n"
        "/** API version this SDK was generated against, sent as the {@code Meteroid-Version} header. */\n"
        "public final class ApiVersion {\n"
        f'    public static final String API_VERSION = "{api_version}";\n\n'
        "    private ApiVersion() {}\n"
        "}\n"
    )


def update_changelog(sdk_version: str, bullets: list[str]) -> None:
    text = CHANGELOG.read_text()
    body = "\n".join(f"* {b}" for b in bullets)
    if re.search(r"^## Next\s*$", text, flags=re.M):
        # Fold the pending hand-written entries into this release, spec changes first.
        text = re.sub(r"^## Next\s*$", f"## Version {sdk_version}\n\n{body}", text, count=1, flags=re.M)
    else:
        text = text.replace("# Changelog\n", f"# Changelog\n\n## Version {sdk_version}\n\n{body}\n", 1)
    CHANGELOG.write_text(text)


def main() -> None:
    ap = argparse.ArgumentParser(description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter)
    ap.add_argument("--spec", required=True, type=Path)
    ap.add_argument("--api-version", required=True)
    ap.add_argument("--source-repo", required=True)
    ap.add_argument("--source-sha", required=True)
    ap.add_argument("--commits-file", type=Path, help="one `<sha> <subject>` per line, listed in the changelog")
    ap.add_argument("--pr-body", type=Path, help="write a PR description here")
    args = ap.parse_args()

    parse_version(args.api_version)
    new_spec = json.loads(args.spec.read_text())
    old_spec = json.loads(SPEC.read_text()) if SPEC.exists() else {}
    strip = lambda s: {k: v for k, v in s.items() if k != "info"}  # noqa: E731
    if strip(new_spec) == strip(old_spec) and old_spec.get("info", {}).get("version") == new_spec.get("info", {}).get("version"):
        print(f"spec unchanged at API version {args.api_version}; nothing to do")
        github_output(changed="false")
        return

    changes = oasdiff_changelog(SPEC, args.spec) if SPEC.exists() else []
    breaking = any(c.get("level") == 3 for c in changes)  # oasdiff: 3 = ERR (breaking)
    shutil.copy(args.spec, SPEC)

    sdk_version = bump_sdk_version(args.api_version)
    write_api_version(args.api_version)

    src_url = f"https://github.com/{args.source_repo}/commit/{args.source_sha}"
    bullets = [f"Regenerated from API spec {args.api_version} ([{args.source_repo}@{args.source_sha[:7]}]({src_url}))"]
    if breaking:
        bullets.append("**Breaking** — see the API changes below")
    bullets += describe(changes)
    if args.commits_file and args.commits_file.exists():
        for line in args.commits_file.read_text().splitlines():
            sha, _, subject = line.strip().partition(" ")
            if sha:
                bullets.append(f"API: {subject} ([{sha}](https://github.com/{args.source_repo}/commit/{sha}))")
    update_changelog(sdk_version, bullets)

    SOURCE.write_text(json.dumps({"repo": args.source_repo, "sha": args.source_sha,
                                  "api_version": args.api_version}, indent=2) + "\n")

    if args.pr_body:
        args.pr_body.write_text(
            f"Automated sync of the public API spec **{args.api_version}** from {args.source_repo}@`{args.source_sha[:7]}`.\n\n"
            f"SDK version: **{sdk_version}**. Breaking (per oasdiff): **{'yes' if breaking else 'no'}**.\n\n"
            "Auto-merges when CI passes; merging `.version` on `main` triggers the releases.\n\n"
            "## Changes\n\n" + "\n".join(f"* {b}" for b in bullets) + "\n"
        )

    print(f"API {args.api_version} -> SDK {sdk_version} ({len(changes)} spec changes, breaking={breaking})")
    github_output(changed="true", api_version=args.api_version, sdk_version=sdk_version,
                  breaking=str(breaking).lower())


if __name__ == "__main__":
    main()
