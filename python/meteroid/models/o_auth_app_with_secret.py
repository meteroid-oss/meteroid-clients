# this file is @generated
import dataclasses

from ..serialization import BaseModel
from .o_auth_app import OAuthApp


@dataclasses.dataclass
class OAuthAppWithSecret(BaseModel):
    """Result of creating an OAuth app (includes the plain-text secret)"""

    app: OAuthApp

    client_secret: str
