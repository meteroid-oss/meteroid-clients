# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import UNSET, BaseModel, Unset

if t.TYPE_CHECKING:
    from .bank_account_id import BankAccountId


@dataclasses.dataclass(kw_only=True)
class BankTransferPaymentMethodConfig(BaseModel):
    """The `BankTransferPaymentMethodConfig` object."""

    account_id: BankAccountId | None | Unset = UNSET
