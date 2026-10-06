# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .o_auth_app import OAuthApp


@dataclasses.dataclass(kw_only=True)
class OAuthAppsResponse(BaseModel):
    """The `OAuthAppsResponse` object."""

    data: list[OAuthApp]
