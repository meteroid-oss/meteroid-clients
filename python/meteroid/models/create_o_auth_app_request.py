# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel


@dataclasses.dataclass
class CreateOAuthAppRequest(BaseModel):
    name: str

    redirect_uris: t.List[str]

    scopes: t.Optional[t.List[str]] = None
