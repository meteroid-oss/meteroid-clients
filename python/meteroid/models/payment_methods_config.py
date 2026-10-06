# this file is @generated
from __future__ import annotations

import typing as t

from ..serialization import Discriminator, UnknownVariant
from .bank_transfer_payment_method_config import BankTransferPaymentMethodConfig
from .external_payment_method_config import ExternalPaymentMethodConfig
from .online_payment_method_config import OnlinePaymentMethodConfig

PaymentMethodsConfig: t.TypeAlias = t.Annotated[
    OnlinePaymentMethodConfig
    | BankTransferPaymentMethodConfig
    | ExternalPaymentMethodConfig
    | UnknownVariant,
    Discriminator(
        "type",
        {
            "online": OnlinePaymentMethodConfig,
            "bank_transfer": BankTransferPaymentMethodConfig,
            "external": ExternalPaymentMethodConfig,
        },
    ),
]
"""Online (card/direct debit), BankTransfer, or External.

Told apart by `type`; a variant this SDK version does not know is an `UnknownVariant`."""
