"""One module per group of operations in ``examples/openapi.yaml``.

Each handler is deliberately shaped the same way: parse and validate the request, make
**one obvious Meteroid SDK call**, then project the result onto the contract's wire
type. The SDK call is the line worth reading.
"""

import json
from collections.abc import Awaitable, Callable
from typing import Any, NoReturn, TypeVar

from ..error import ApiError
from ..http import Reply, ScribeRequest, raw_body
from ..state import AppState

T = TypeVar("T")

Handler = Callable[[AppState, ScribeRequest], Awaitable[Reply[Any]]]

_ASCII_WHITESPACE = b" \t\n\x0c\r"


def json_body(request: ScribeRequest, decode: Callable[[object], T]) -> T:
    """Parse a **required** JSON request body, with `decode` doing what `json.loads` does
    not: checking it against the contract's schema. Every failure is the contract's `400`
    envelope.
    """
    body = raw_body(request)
    if len(body) == 0:
        raise ApiError.bad_request("A JSON request body is required.")
    return decode(_parse_json(body))


def optional_json_body(request: ScribeRequest, decode: Callable[[object], T]) -> T:
    """Parse an **optional** JSON request body.

    The contract states that for these operations no body, an empty body, `{}` and
    `{"field": null}` all mean the same thing: use the defaults. That rule is literally
    this function.
    """
    body = raw_body(request)
    return decode({} if body.strip(_ASCII_WHITESPACE) == b"" else _parse_json(body))


def _parse_json(body: bytes) -> object:
    try:
        return parse_json(body)
    except ValueError as exc:
        raise ApiError.bad_request(f"Invalid body: {exc}") from None


def parse_json(body: bytes) -> object:
    """Strict JSON, or a `ValueError`. `json.loads` on its own is looser than the other
    backends' parsers in three ways, each closed here.
    """
    try:
        # Decoded here rather than left to `json.loads`: given bytes it would sniff
        # UTF-16 and UTF-32 too. A byte-order mark survives the decode and is refused by
        # the parser.
        parsed: object = json.loads(body.decode("utf-8"), parse_constant=_not_json)
    # How the parser reports a body nested a few thousand levels deep.
    except RecursionError:
        raise ValueError("the document is nested too deeply") from None
    return parsed


def _not_json(constant: str) -> NoReturn:
    """`json.loads` accepts `NaN`, `Infinity` and `-Infinity` unless told otherwise."""
    raise ValueError(f"{constant} is not valid JSON")


def not_found() -> ApiError:
    """`404` for an unmatched route, in the standard envelope. No operation in the
    contract takes a path parameter, so this only ever fires on a typo.
    """
    return ApiError(
        "NOT_FOUND",
        "No such endpoint. See examples/openapi.yaml for the operations this demo serves.",
    )


def bounded(field: str, value: str, maximum: int) -> str:
    """Trim a string field and reject it when it is empty or too long."""
    trimmed = value.strip()
    if trimmed == "":
        raise ApiError.bad_request(f"{field} must not be empty.")
    # `len` counts code points: an emoji is one character of the limit, not two.
    if len(trimmed) > maximum:
        raise ApiError.bad_request(f"{field} must be at most {maximum} characters.")
    return trimmed
