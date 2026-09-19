# this file is @generated
import dataclasses

from ..serialization import BaseModel
from .minimum_commitment_scope import MinimumCommitmentScope


@dataclasses.dataclass
class MinimumCommitment(BaseModel):
    amount: str
    """Decimal string in the plan currency, e.g. "100.00"."""

    scope: MinimumCommitmentScope
