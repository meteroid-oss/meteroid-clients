# this file is @generated
import dataclasses

from ..serialization import BaseModel


@dataclasses.dataclass
class IngestFailure(BaseModel):
    event_id: str

    reason: str
