#!/usr/bin/env python3
"""
Apply a new public API spec to this repository.

Called by the `SDK sync` workflow of meteroid-oss/enterprise (and usable by hand):

    scripts/spec_sync.py --spec /path/to/openapi.json --api-version 2026-09-20 \
        --source-repo meteroid-oss/enterprise --source-sha <sha> --source-release v1.14.0

The API version is a dated snapshot (`YYYY-MM-DD`, optional `.N` suffix); the SDK keeps its own
semver, derived here from the change: breaking (per oasdiff) -> major (minor while 0.x), anything
else -> minor. SDK-only fixes between syncs are patch bumps made by hand with bump_version.js.
The script copies the spec, bumps `.version`, pins the API version the SDKs send in
`Meteroid-Version`, drafts the CHANGELOG entry from `oasdiff changelog` and records the source in
spec/SOURCE. It does not regenerate code: run ./regen_openapi.py afterwards.
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


def parse_semver(v: str) -> tuple[int, int, int]:
    m = re.fullmatch(r"(\d+)\.(\d+)\.(\d+)", v.strip())
    if not m:
        sys.exit(f"not a MAJOR.MINOR.PATCH version: {v!r}")
    return tuple(int(x) for x in m.groups())


def parse_api_version(v: str) -> tuple[int, int, int, int]:
    m = re.fullmatch(r"(\d{4})-(\d{2})-(\d{2})(?:\.([1-9]\d*))?", v.strip())
    if not m:
        sys.exit(f"not a YYYY-MM-DD[.N] API version: {v!r}")
    return tuple(int(x or 0) for x in m.groups())


def github_output(**kv: str) -> None:
    path = os.getenv("GITHUB_OUTPUT")
    if not path:
        return
    with open(path, "a") as f:
        for k, v in kv.items():
            f.write(f"{k}={v}\n")


def oasdiff_changelog(old: Path, new: Path) -> list[dict]:
    """Structured change list from oasdiff. The SDK version is derived from it, so a run without
    a working oasdiff is an error."""
    docker = shutil.which("docker") or shutil.which("podman")
    if not docker:
        sys.exit("docker (or podman) is required to run oasdiff")
    work = Path(os.getenv("RUNNER_TEMP", "/tmp")) / "spec-sync-oasdiff"
    work.mkdir(parents=True, exist_ok=True)
    shutil.copy(old, work / "old.json")
    shutil.copy(new, work / "new.json")
    cmd = [docker, "run", "--rm", "-v", f"{work}:/w", OASDIFF_IMAGE,
           "changelog", "/w/old.json", "/w/new.json", "--format", "json"]
    res = subprocess.run(cmd, capture_output=True, text=True)
    try:
        changes = json.loads(res.stdout)
    except json.JSONDecodeError:
        changes = None
    if not isinstance(changes, list):
        sys.exit(f"oasdiff failed ({res.returncode}): {res.stderr.strip() or res.stdout.strip()}")
    return changes


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


def bump_sdk_version(breaking: bool) -> str:
    major, minor, _ = parse_semver(VERSION_FILE.read_text().strip())
    if breaking and major > 0:
        target = f"{major + 1}.0.0"
    else:
        target = f"{major}.{minor + 1}.0"
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
    """bump_version.js has already turned `## Next` into `## Version <sdk>` and left an empty
    `## Next` placeholder above it; fill the new section, spec changes first."""
    text = CHANGELOG.read_text().replace("## Next\n* \n\n", "## Next\n\n", 1)
    heading = f"## Version {sdk_version}\n"
    if heading not in text:
        sys.exit(f"CHANGELOG.md has no '{heading.strip()}' section; did bump_version.js run?")
    body = "\n".join(f"* {b}" for b in bullets)
    text = text.replace(heading, f"{heading}\n{body}\n", 1)
    CHANGELOG.write_text(re.sub(r"\n{3,}", "\n\n", text))


def main() -> None:
    ap = argparse.ArgumentParser(description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter)
    ap.add_argument("--spec", required=True, type=Path)
    ap.add_argument("--api-version", required=True)
    ap.add_argument("--source-repo", required=True)
    ap.add_argument("--source-sha", required=True)
    ap.add_argument("--source-release", help="release tag of the source repo, for the changelog")
    ap.add_argument("--commits-file", type=Path, help="one `<sha> <subject>` per line, listed in the changelog")
    ap.add_argument("--pr-body", type=Path, help="write a PR description here")
    args = ap.parse_args()

    parse_api_version(args.api_version)
    new_spec = json.loads(args.spec.read_text())
    old_spec = json.loads(SPEC.read_text()) if SPEC.exists() else {}
    strip = lambda s: {k: v for k, v in s.items() if k != "info"}  # noqa: E731
    if strip(new_spec) == strip(old_spec):
        print(f"spec unchanged at API version {args.api_version}; nothing to do")
        github_output(changed="false")
        return
    if SOURCE.exists():
        previous = json.loads(SOURCE.read_text()).get("api_version", "")
        if previous and parse_api_version(previous) >= parse_api_version(args.api_version):
            sys.exit(f"spec changed but API version {args.api_version} is not newer than the synced {previous}")

    changes = oasdiff_changelog(SPEC, args.spec) if SPEC.exists() else []
    breaking = any(c.get("level") == 3 for c in changes)  # oasdiff: 3 = ERR (breaking)
    shutil.copy(args.spec, SPEC)

    sdk_version = bump_sdk_version(breaking)
    write_api_version(args.api_version)

    src_url = f"https://github.com/{args.source_repo}/commit/{args.source_sha}"
    release = f" {args.source_release}" if args.source_release else ""
    bullets = [f"API version **{args.api_version}**, generated from {args.source_repo}{release} ([{args.source_sha[:7]}]({src_url}))"]
    if breaking:
        bullets.append("**Breaking** — see the API changes below")
    bullets += describe(changes)
    if args.commits_file and args.commits_file.exists():
        for line in args.commits_file.read_text().splitlines():
            sha, _, subject = line.strip().partition(" ")
            if sha:
                bullets.append(f"API: {subject} ([{sha}](https://github.com/{args.source_repo}/commit/{sha}))")
    update_changelog(sdk_version, bullets)

    SOURCE.write_text(json.dumps({"repo": args.source_repo, "release": args.source_release,
                                  "sha": args.source_sha, "api_version": args.api_version},
                                 indent=2) + "\n")

    if args.pr_body:
        args.pr_body.write_text(
            f"Automated sync of API version **{args.api_version}** from {args.source_repo}{release} (`{args.source_sha[:7]}`).\n\n"
            f"SDK version: **{sdk_version}** ({'major: breaking per oasdiff' if breaking else 'minor: additive'}).\n\n"
            "Auto-merges when CI passes; merging `.version` on `main` triggers the releases.\n\n"
            "## Changes\n\n" + "\n".join(f"* {b}" for b in bullets) + "\n"
        )

    print(f"API {args.api_version} -> SDK {sdk_version} ({len(changes)} spec changes, breaking={breaking})")
    github_output(changed="true", api_version=args.api_version, sdk_version=sdk_version,
                  breaking=str(breaking).lower())


if __name__ == "__main__":
    main()
