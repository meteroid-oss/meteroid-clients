# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import UNSET, BaseModel, Unset

if t.TYPE_CHECKING:
    from .add_on_id import AddOnId
    from .subscription_add_on_customization import SubscriptionAddOnCustomization


@dataclasses.dataclass(kw_only=True)
class CreateSubscriptionAddOn(BaseModel):
    """The `CreateSubscriptionAddOn` object."""

    add_on_id: AddOnId

    customization: SubscriptionAddOnCustomization | None | Unset = UNSET

    quantity: int | None = None
