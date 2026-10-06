# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from uuid import UUID

from ..serialization import UNSET, BaseModel, Unset

if t.TYPE_CHECKING:
    from .connection_type import ConnectionType
    from .customer_id import CustomerId


@dataclasses.dataclass(kw_only=True)
class CreateConnectedAccountRequest(BaseModel):
    """The `CreateConnectedAccountRequest` object."""

    connected_organization_id: UUID

    connection_type: ConnectionType | None | Unset = UNSET

    metadata: t.Any = None

    platform_customer_id: CustomerId | None | Unset = UNSET
