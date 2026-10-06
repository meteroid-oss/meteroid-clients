# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .error_code import ErrorCode


@dataclasses.dataclass(kw_only=True)
class RestErrorResponse(BaseModel):
    """The `RestErrorResponse` object."""

    code: ErrorCode

    message: str
