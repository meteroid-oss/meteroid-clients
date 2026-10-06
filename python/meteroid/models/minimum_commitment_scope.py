# this file is @generated
from __future__ import annotations

import typing as t

from ..serialization import Discriminator, UnknownVariant
from .all_components_scope import AllComponentsScope
from .products_scope import ProductsScope

MinimumCommitmentScope: t.TypeAlias = t.Annotated[
    AllComponentsScope | ProductsScope | UnknownVariant,
    Discriminator(
        "type",
        {
            "all_components": AllComponentsScope,
            "products": ProductsScope,
        },
    ),
]
"""Told apart by `type`; a variant this SDK version does not know is an `UnknownVariant`."""
