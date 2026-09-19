"""Three log levels on stderr, in the same line format as the other backends.

`logging` would do, but its configuration would be longer than this file, and uvicorn
already owns the root of that tree.
"""

import sys
from datetime import UTC, datetime


def _write(level: str, message: str) -> None:
    now = datetime.now(UTC).isoformat(timespec="milliseconds").replace("+00:00", "Z")
    print(f"{now} {level:>5} scribe_backend: {message}", file=sys.stderr, flush=True)


def info(message: str) -> None:
    _write("INFO", message)


def warn(message: str) -> None:
    _write("WARN", message)


def error(message: str) -> None:
    _write("ERROR", message)
