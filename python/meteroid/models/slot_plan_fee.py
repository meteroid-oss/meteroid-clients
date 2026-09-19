# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .term_rate import TermRate


@dataclasses.dataclass
class SlotPlanFee(BaseModel):
    """Slot-based fee (e.g., per-seat pricing)"""

    rates: t.List[TermRate]

    slot_unit_name: str

    minimum_count: t.Optional[int] = None

    quota: t.Optional[int] = None
