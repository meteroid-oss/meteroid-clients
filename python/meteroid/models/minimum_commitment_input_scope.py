# this file is @generated
from __future__ import annotations

import typing as t

from ..serialization import Discriminator, UnknownVariant
from .all_components_scope import AllComponentsScope
from .components_scope import ComponentsScope

MinimumCommitmentInputScope: t.TypeAlias = t.Annotated[
    AllComponentsScope | ComponentsScope | UnknownVariant,
    Discriminator(
        "type",
        {
            "all_components": AllComponentsScope,
            "components": ComponentsScope,
        },
    ),
]
"""Told apart by `type`; a variant this SDK version does not know is an `UnknownVariant`."""
