# this file is @generated
import dataclasses

from ..serialization import BaseModel


@dataclasses.dataclass
class NeverResetPeriod(BaseModel):
    """Never resets — counts all usage since the subscription was activated."""

    pass
