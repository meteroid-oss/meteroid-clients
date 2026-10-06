# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .minimum_commitment_input_scope import MinimumCommitmentInputScope


@dataclasses.dataclass(kw_only=True)
class MinimumCommitmentInput(BaseModel):
    """The `MinimumCommitmentInput` object."""

    amount: str
    """Decimal string in the plan currency."""

    scope: MinimumCommitmentInputScope
