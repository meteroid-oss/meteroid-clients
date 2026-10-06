# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .connected_account import ConnectedAccount


@dataclasses.dataclass(kw_only=True)
class ConnectedAccountsResponse(BaseModel):
    """The `ConnectedAccountsResponse` object."""

    data: list[ConnectedAccount]
