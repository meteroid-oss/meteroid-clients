"""The whole HTTP layer: a bare ASGI callable, no framework.

A web framework would be the largest thing in this backend, and the point of the demo
is the Meteroid call inside each handler. What a handler needs is small — the method and
path, the headers, and the **raw** body bytes (webhook signatures are computed over
bytes, so nothing may parse the body first) — and it fits in the two types below.
``app.py`` turns a :class:`ScribeRequest` into a :class:`ScribeResponse` with no socket
involved, which is also what lets the tests drive the router in-process.
"""

from __future__ import annotations

from collections.abc import Awaitable, Callable, Coroutine, MutableMapping
from dataclasses import dataclass
from typing import Any, Generic, TypeVar
from urllib.parse import parse_qsl

from .error import ApiError

# What `axum` buffers by default, so an oversized body is refused at the same size.
MAX_BODY_BYTES = 2 * 1024 * 1024

T = TypeVar("T")


@dataclass(frozen=True)
class ScribeRequest:
    method: str
    path: str
    # In order, repeats kept: the handlers are as strict about the query as about bodies.
    query: list[tuple[str, str]]
    # Lower-cased names; repeated headers joined with `", "`.
    headers: dict[str, str]
    # The request body exactly as it arrived, or `None` if it exceeded `MAX_BODY_BYTES`.
    body: bytes | None


@dataclass(frozen=True)
class ScribeResponse:
    status: int
    headers: dict[str, str]
    # Already-serialized JSON, or `b""` for the few bodiless answers.
    body: bytes


@dataclass(frozen=True)
class Reply(Generic[T]):
    """What a handler returns: a status and the contract object to serialize."""

    status: int
    body: T


def ok(body: T) -> Reply[T]:
    return Reply(200, body)


def created(body: T) -> Reply[T]:
    return Reply(201, body)


def accepted(body: T) -> Reply[T]:
    return Reply(202, body)


def raw_body(request: ScribeRequest) -> bytes:
    """The raw request body, for the handlers that read one. Refusing an oversized body
    here rather than on arrival keeps the order of checks the same as the other
    backends: a request with no session token is a 401 whatever its body looks like.
    """
    if request.body is None:
        raise ApiError.bad_request(
            f"The request body exceeds the {MAX_BODY_BYTES}-byte limit."
        ).with_status(413)
    return request.body


Handle = Callable[[ScribeRequest], Coroutine[Any, Any, ScribeResponse]]

Scope = MutableMapping[str, Any]
Message = MutableMapping[str, Any]
Receive = Callable[[], Awaitable[Message]]
Send = Callable[[Message], Awaitable[None]]
AsgiApp = Callable[[Scope, Receive, Send], Awaitable[None]]


def serve(handle: Handle) -> AsgiApp:
    """Put a :data:`Handle` behind the ASGI interface uvicorn speaks."""

    async def app(scope: Scope, receive: Receive, send: Send) -> None:
        if scope["type"] != "http":
            return
        request = await _read_request(scope, receive)
        if request is None:
            # The client went away mid-request; there is nobody to answer.
            return
        response = await handle(request)

        headers = {**response.headers, "content-length": str(len(response.body))}
        await send(
            {
                "type": "http.response.start",
                "status": response.status,
                "headers": [(k.encode("latin-1"), v.encode("latin-1")) for k, v in headers.items()],
            }
        )
        # HEAD is answered with GET's headers, `content-length` included, and no body.
        body = b"" if request.method == "HEAD" else response.body
        await send({"type": "http.response.body", "body": body})

    return app


async def _read_request(scope: Scope, receive: Receive) -> ScribeRequest | None:
    headers: dict[str, str] = {}
    for raw_name, raw_value in scope["headers"]:
        name, value = raw_name.decode("latin-1").lower(), raw_value.decode("latin-1")
        headers[name] = f"{headers[name]}, {value}" if name in headers else value

    # An oversized body is still read to the end, just not kept: answering before the
    # client has finished sending makes most clients report a broken pipe, not the 413.
    chunks: list[bytes] = []
    size = 0
    while True:
        message = await receive()
        if message["type"] == "http.disconnect":
            return None
        chunk: bytes = message.get("body", b"")
        size += len(chunk)
        if size <= MAX_BODY_BYTES:
            chunks.append(chunk)
        if not message.get("more_body", False):
            break

    # `raw_path`, because `path` arrives percent-decoded: `/api/%68ealth` is not a route
    # in any other backend, and must not become one here.
    raw_path: bytes | None = scope.get("raw_path")
    path = raw_path.decode("latin-1") if raw_path is not None else str(scope["path"])

    return ScribeRequest(
        method=str(scope["method"]),
        path=path,
        query=parse_qsl(scope.get("query_string", b"").decode("latin-1"), keep_blank_values=True),
        headers=headers,
        body=b"".join(chunks) if size <= MAX_BODY_BYTES else None,
    )
