# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .term_rate import TermRate


@dataclasses.dataclass(kw_only=True)
class RatePlanFee(BaseModel):
    """Recurring rate fee (e.g., monthly subscription)"""

    rates: list[TermRate]
