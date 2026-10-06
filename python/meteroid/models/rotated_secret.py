# this file is @generated
from __future__ import annotations

import dataclasses

from ..serialization import BaseModel


@dataclasses.dataclass(kw_only=True)
class RotatedSecret(BaseModel):
    """Result of rotating a client secret"""

    client_secret: str

    client_secret_hint: str
