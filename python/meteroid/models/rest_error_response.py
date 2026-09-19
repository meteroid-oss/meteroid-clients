# this file is @generated
import dataclasses

from ..serialization import BaseModel
from .error_code import ErrorCode


@dataclasses.dataclass
class RestErrorResponse(BaseModel):
    code: ErrorCode

    message: str
