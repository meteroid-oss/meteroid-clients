# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel


@dataclasses.dataclass
class LinkedSegmentationMatrix(BaseModel):
    dimension1_key: str

    dimension2_key: str

    values: t.Dict[str, t.List[str]]
