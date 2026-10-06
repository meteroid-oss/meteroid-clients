# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .slot_downgrade_policy_enum import SlotDowngradePolicyEnum
    from .slot_upgrade_policy_enum import SlotUpgradePolicyEnum


@dataclasses.dataclass(kw_only=True)
class SlotFeeStructure(BaseModel):
    """The `SlotFeeStructure` object."""

    downgrade_policy: SlotDowngradePolicyEnum

    slot_unit_name: str

    upgrade_policy: SlotUpgradePolicyEnum
