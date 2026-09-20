# this file is @generated
import dataclasses

from ..serialization import BaseModel
from .minimum_commitment_input_scope import MinimumCommitmentInputScope


@dataclasses.dataclass
class MinimumCommitmentInput(BaseModel):
    amount: str
    """Decimal string in the plan currency."""

    scope: MinimumCommitmentInputScope
