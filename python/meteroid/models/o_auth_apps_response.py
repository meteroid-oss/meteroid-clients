# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .o_auth_app import OAuthApp


@dataclasses.dataclass
class OAuthAppsResponse(BaseModel):
    data: t.List[OAuthApp]
