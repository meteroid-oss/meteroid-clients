# this file is @generated
import dataclasses

from ..serialization import BaseModel


@dataclasses.dataclass
class ProductFamilyCreateRequest(BaseModel):
    name: str
