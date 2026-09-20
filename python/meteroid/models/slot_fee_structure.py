# this file is @generated
import dataclasses

from ..serialization import BaseModel
from .slot_downgrade_policy_enum import SlotDowngradePolicyEnum
from .slot_upgrade_policy_enum import SlotUpgradePolicyEnum


@dataclasses.dataclass
class SlotFeeStructure(BaseModel):
    downgrade_policy: SlotDowngradePolicyEnum

    slot_unit_name: str

    upgrade_policy: SlotUpgradePolicyEnum
