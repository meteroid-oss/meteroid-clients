# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .metered_entitlement_spec import MeteredEntitlementSpec
    from .metered_entitlement_usage import MeteredEntitlementUsage


@dataclasses.dataclass(kw_only=True)
class MeteredEffectiveEntitlementValue(BaseModel):
    """The `MeteredEffectiveEntitlementValue` object."""

    spec: MeteredEntitlementSpec

    usage: MeteredEntitlementUsage
