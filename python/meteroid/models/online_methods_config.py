# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .online_method_config import OnlineMethodConfig


@dataclasses.dataclass
class OnlineMethodsConfig(BaseModel):
    card: t.Optional[OnlineMethodConfig] = None

    direct_debit: t.Optional[OnlineMethodConfig] = None
