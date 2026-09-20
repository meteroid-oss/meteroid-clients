# this file is @generated
import dataclasses

from ..serialization import BaseModel
from .checkout_session import CheckoutSession


@dataclasses.dataclass
class CancelCheckoutSessionResponse(BaseModel):
    session: CheckoutSession
