# this file is @generated
import dataclasses
from datetime import datetime

from ..serialization import BaseModel


@dataclasses.dataclass
class OnboardingLinkResponse(BaseModel):
    """Result of creating an onboarding link"""

    expires_at: datetime

    url: str
