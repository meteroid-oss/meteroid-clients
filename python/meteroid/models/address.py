# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import UNSET, BaseModel, Unset

if t.TYPE_CHECKING:
    from .country_code import CountryCode


@dataclasses.dataclass(kw_only=True)
class Address(BaseModel):
    """The `Address` object."""

    city: str | None | Unset = UNSET

    country: CountryCode | None | Unset = UNSET

    line1: str | None | Unset = UNSET

    line2: str | None | Unset = UNSET

    state: str | None | Unset = UNSET

    zip_code: str | None | Unset = UNSET
