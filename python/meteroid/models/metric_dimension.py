# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel


@dataclasses.dataclass
class MetricDimension(BaseModel):
    key: str

    values: t.List[str]
