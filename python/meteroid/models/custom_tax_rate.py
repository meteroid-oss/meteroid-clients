# this file is @generated
import dataclasses

from ..serialization import BaseModel


@dataclasses.dataclass
class CustomTaxRate(BaseModel):
    name: str

    rate: str

    tax_code: str
