# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .o_auth_app import OAuthApp


@dataclasses.dataclass(kw_only=True)
class OAuthAppWithSecret(BaseModel):
    """Result of creating an OAuth app (includes the plain-text secret)"""

    app: OAuthApp

    client_secret: str
