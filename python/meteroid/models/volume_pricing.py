# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .tier_row import TierRow


@dataclasses.dataclass
class VolumePricing(BaseModel):
    tiers: t.List[TierRow]

    block_size: t.Optional[int] = None
