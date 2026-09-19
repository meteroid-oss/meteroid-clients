"""`GET /api/invoices` — the workspace customer's invoices, newest first."""

import re

from ..dto import InvoiceListResponse
from ..error import ApiError, upstream
from ..http import Reply, ScribeRequest, ok
from ..session import require_session
from ..state import AppState


async def list_invoices(state: AppState, request: ScribeRequest) -> Reply[InvoiceListResponse]:
    """A fresh workspace has no invoices, and one that just checked out usually has a
    `DRAFT`. Amounts stay integers in **minor units** — Meteroid models invoice money as
    an integer, not a decimal, and this is the one place the decimals-are-strings rule
    does not apply.
    """
    session = require_session(state, request)
    limit = _limit_param(request.query)
    if limit is None:
        limit = 20
    if not 1 <= limit <= 100:
        raise ApiError.bad_request("limit must be between 1 and 100.")

    with upstream("GET /api/v1/invoices"):
        response = await state.meteroid.invoices.list_invoices(
            # `customer_id` accepts an id or an alias.
            customer_id=session.customer_alias,
            order_by="invoice_date.desc",
            per_page=limit,
        )

    return ok(
        {
            "invoices": [
                {
                    "id": invoice.id,
                    "invoice_number": invoice.invoice_number,
                    "status": invoice.status.value,
                    "currency": invoice.currency.value,
                    "invoice_date": invoice.invoice_date,
                    "due_date": invoice.due_date,
                    "total": invoice.total,
                    "amount_due": invoice.amount_due,
                }
                for invoice in response.data
            ]
        }
    )


def _limit_param(query: list[tuple[str, str]]) -> int | None:
    """The query string is as strict as the request bodies: `limit` is the only parameter
    the contract declares, it appears at most once, and it is an int32.
    """
    for name, _ in query:
        if name != "limit":
            raise ApiError.bad_request(
                f"Invalid query string: unknown parameter `{name}`, expected `limit`."
            )
    if len(query) > 1:
        raise ApiError.bad_request("Invalid query string: `limit` was given more than once.")
    if not query:
        return None

    raw = query[0][1]
    # `[0-9]`, not `\d`: `int()` would happily read Arabic-Indic digits, and no other
    # backend does.
    if not re.fullmatch(r"[+-]?[0-9]+", raw) or abs(int(raw)) > 2_147_483_647:
        raise ApiError.bad_request("Invalid query string: limit must be an integer.")
    return int(raw)
