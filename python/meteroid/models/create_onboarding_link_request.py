# this file is @generated
import dataclasses

from ..serialization import BaseModel


@dataclasses.dataclass
class CreateOnboardingLinkRequest(BaseModel):
    redirect_url: str
