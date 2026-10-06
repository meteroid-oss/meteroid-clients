# this file is @generated
from __future__ import annotations

import typing as t

from ..serialization import Discriminator, UnknownVariant
from .existing_price_ref import ExistingPriceRef
from .price_input import PriceInput

PriceEntry: t.TypeAlias = t.Annotated[
    ExistingPriceRef | PriceInput | UnknownVariant,
    Discriminator(
        "type",
        {
            "EXISTING": ExistingPriceRef,
            "NEW": PriceInput,
        },
    ),
]
"""Told apart by `type`; a variant this SDK version does not know is an `UnknownVariant`."""
