# this file is @generated
from __future__ import annotations

import typing as t

from ..serialization import Discriminator, UnknownVariant
from .boolean_entitlement_value import BooleanEntitlementValue
from .config_entitlement_value import ConfigEntitlementValue
from .metered_entitlement_value import MeteredEntitlementValue

EntitlementValue: t.TypeAlias = t.Annotated[
    BooleanEntitlementValue
    | MeteredEntitlementValue
    | ConfigEntitlementValue
    | UnknownVariant,
    Discriminator(
        "type",
        {
            "BOOLEAN": BooleanEntitlementValue,
            "METERED": MeteredEntitlementValue,
            "CONFIG": ConfigEntitlementValue,
        },
    ),
]
"""Told apart by `type`; a variant this SDK version does not know is an `UnknownVariant`."""
