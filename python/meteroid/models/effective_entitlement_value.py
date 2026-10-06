# this file is @generated
from __future__ import annotations

import typing as t

from ..serialization import Discriminator, UnknownVariant
from .boolean_effective_entitlement_value import BooleanEffectiveEntitlementValue
from .config_effective_entitlement_value import ConfigEffectiveEntitlementValue
from .metered_effective_entitlement_value import MeteredEffectiveEntitlementValue

EffectiveEntitlementValue: t.TypeAlias = t.Annotated[
    BooleanEffectiveEntitlementValue
    | MeteredEffectiveEntitlementValue
    | ConfigEffectiveEntitlementValue
    | UnknownVariant,
    Discriminator(
        "type",
        {
            "BOOLEAN": BooleanEffectiveEntitlementValue,
            "METERED": MeteredEffectiveEntitlementValue,
            "CONFIG": ConfigEffectiveEntitlementValue,
        },
    ),
]
"""Told apart by `type`; a variant this SDK version does not know is an `UnknownVariant`."""
