# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import UNSET, BaseModel, Unset

if t.TYPE_CHECKING:
    from .online_methods_config import OnlineMethodsConfig


@dataclasses.dataclass(kw_only=True)
class OnlinePaymentMethodConfig(BaseModel):
    """The `OnlinePaymentMethodConfig` object."""

    config: OnlineMethodsConfig | None | Unset = UNSET
