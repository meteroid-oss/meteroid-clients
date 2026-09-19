# this file is @generated
import dataclasses

from ..serialization import BaseModel


@dataclasses.dataclass
class CustomerPortalTokenResponse(BaseModel):
    portal_url: str
    """Base URL of the customer portal"""

    token: str
    """JWT token for portal access"""
