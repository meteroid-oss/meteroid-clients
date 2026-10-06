# this file is @generated
from __future__ import annotations

import typing as t

from ..serialization import Discriminator, UnknownVariant
from .existing_product_ref import ExistingProductRef
from .new_product_ref import NewProductRef

ProductRef: t.TypeAlias = t.Annotated[
    ExistingProductRef | NewProductRef | UnknownVariant,
    Discriminator(
        "type",
        {
            "EXISTING": ExistingProductRef,
            "NEW": NewProductRef,
        },
    ),
]
"""Told apart by `type`; a variant this SDK version does not know is an `UnknownVariant`."""
