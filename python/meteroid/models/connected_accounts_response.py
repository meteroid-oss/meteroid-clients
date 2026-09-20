# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .connected_account import ConnectedAccount


@dataclasses.dataclass
class ConnectedAccountsResponse(BaseModel):
    data: t.List[ConnectedAccount]
