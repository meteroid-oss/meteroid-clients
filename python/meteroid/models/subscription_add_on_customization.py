# this file is @generated
from __future__ import annotations

import typing as t

from ..serialization import Discriminator, UnknownVariant
from .subscription_add_on_parameterization import SubscriptionAddOnParameterization
from .subscription_add_on_price_override import SubscriptionAddOnPriceOverride

SubscriptionAddOnCustomization: t.TypeAlias = t.Annotated[
    SubscriptionAddOnPriceOverride | SubscriptionAddOnParameterization | UnknownVariant,
    Discriminator(
        "type",
        {
            "PRICE_OVERRIDE": SubscriptionAddOnPriceOverride,
            "PARAMETERIZATION": SubscriptionAddOnParameterization,
        },
    ),
]
"""Told apart by `type`; a variant this SDK version does not know is an `UnknownVariant`."""
