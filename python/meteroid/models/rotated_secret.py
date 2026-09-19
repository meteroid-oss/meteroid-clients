# this file is @generated
import dataclasses

from ..serialization import BaseModel


@dataclasses.dataclass
class RotatedSecret(BaseModel):
    """Result of rotating a client secret"""

    client_secret: str

    client_secret_hint: str
