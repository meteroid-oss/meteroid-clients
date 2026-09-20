# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
from .o_auth_app_id import OAuthAppId
from .organization_id import OrganizationId


@dataclasses.dataclass
class OAuthApp(BaseModel):
    """An OAuth application registered by a platform"""

    client_id: str

    client_secret_hint: str

    created_at: datetime

    id: OAuthAppId

    is_active: bool

    name: str

    organization_id: OrganizationId

    redirect_uris: t.List[str]

    scopes: t.List[str]

    updated_at: t.Optional[datetime] = None
