# this file is @generated
from __future__ import annotations

import typing as t

from ..serialization import Discriminator, UnknownVariant
from .boolean_resolved_entitlement_value import BooleanResolvedEntitlementValue
from .config_resolved_entitlement_value import ConfigResolvedEntitlementValue
from .metered_resolved_entitlement_value import MeteredResolvedEntitlementValue

ResolvedEntitlementValue: t.TypeAlias = t.Annotated[
    BooleanResolvedEntitlementValue
    | MeteredResolvedEntitlementValue
    | ConfigResolvedEntitlementValue
    | UnknownVariant,
    Discriminator(
        "type",
        {
            "BOOLEAN": BooleanResolvedEntitlementValue,
            "METERED": MeteredResolvedEntitlementValue,
            "CONFIG": ConfigResolvedEntitlementValue,
        },
    ),
]
"""Told apart by `type`; a variant this SDK version does not know is an `UnknownVariant`."""
