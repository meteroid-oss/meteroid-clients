# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .checkout_session import CheckoutSession


@dataclasses.dataclass
class ListCheckoutSessionsResponse(BaseModel):
    sessions: t.List[CheckoutSession]
