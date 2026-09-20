# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .country_code import CountryCode


@dataclasses.dataclass
class Address(BaseModel):
    city: t.Optional[str] = None

    country: t.Optional[CountryCode] = None

    line1: t.Optional[str] = None

    line2: t.Optional[str] = None

    state: t.Optional[str] = None

    zip_code: t.Optional[str] = None
