# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .o_auth_app_id import OAuthAppId
    from .organization_id import OrganizationId


@dataclasses.dataclass(kw_only=True)
class OAuthApp(BaseModel):
    """An OAuth application registered by a platform"""

    client_id: str

    client_secret_hint: str

    created_at: datetime

    id: OAuthAppId

    is_active: bool

    name: str

    organization_id: OrganizationId

    redirect_uris: list[str]

    scopes: list[str]

    updated_at: datetime | None = None
