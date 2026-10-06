# this file is @generated
from __future__ import annotations

import dataclasses

from ..serialization import UNSET, BaseModel, Unset


@dataclasses.dataclass(kw_only=True)
class CreateOAuthAppRequest(BaseModel):
    """The `CreateOAuthAppRequest` object."""

    name: str

    redirect_uris: list[str]

    scopes: list[str] | None | Unset = UNSET
