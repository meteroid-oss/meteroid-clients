# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .term_rate import TermRate


@dataclasses.dataclass
class RatePlanFee(BaseModel):
    """Recurring rate fee (e.g., monthly subscription)"""

    rates: t.List[TermRate]
