# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .bank_account_id import BankAccountId


@dataclasses.dataclass
class BankTransferPaymentMethodConfig(BaseModel):
    account_id: t.Optional[BankAccountId] = None
