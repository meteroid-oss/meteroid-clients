# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import UNSET, BaseModel, Unset

if t.TYPE_CHECKING:
    from .online_method_config import OnlineMethodConfig


@dataclasses.dataclass(kw_only=True)
class OnlineMethodsConfig(BaseModel):
    """The `OnlineMethodsConfig` object."""

    card: OnlineMethodConfig | None | Unset = UNSET

    direct_debit: OnlineMethodConfig | None | Unset = UNSET
