# this file is @generated
import dataclasses

from ..serialization import BaseModel


@dataclasses.dataclass
class MatrixDimension(BaseModel):
    key: str

    value: str
