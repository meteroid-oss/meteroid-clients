# this file is @generated
from __future__ import annotations

import dataclasses
from datetime import datetime

from ..serialization import BaseModel


@dataclasses.dataclass(kw_only=True)
class OnboardingLinkResponse(BaseModel):
    """Result of creating an onboarding link"""

    expires_at: datetime

    url: str
