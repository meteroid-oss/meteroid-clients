# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .connection_type import ConnectionType
from .customer_id import CustomerId


@dataclasses.dataclass
class CreateConnectedAccountRequest(BaseModel):
    connected_organization_id: str

    connection_type: t.Optional[ConnectionType] = None

    metadata: t.Optional[t.Any] = None

    platform_customer_id: t.Optional[CustomerId] = None
