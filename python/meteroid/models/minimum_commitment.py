# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .minimum_commitment_scope import MinimumCommitmentScope


@dataclasses.dataclass(kw_only=True)
class MinimumCommitment(BaseModel):
    """The `MinimumCommitment` object."""

    amount: str
    """Decimal string in the plan currency, e.g. "100.00"."""

    scope: MinimumCommitmentScope
