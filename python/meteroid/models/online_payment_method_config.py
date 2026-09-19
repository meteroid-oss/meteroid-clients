# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .online_methods_config import OnlineMethodsConfig


@dataclasses.dataclass
class OnlinePaymentMethodConfig(BaseModel):
    config: t.Optional[OnlineMethodsConfig] = None
