# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .add_on_id import AddOnId
from .subscription_add_on_customization import SubscriptionAddOnCustomization


@dataclasses.dataclass
class CreateSubscriptionAddOn(BaseModel):
    add_on_id: AddOnId

    customization: t.Optional[SubscriptionAddOnCustomization] = None

    quantity: t.Optional[int] = None
