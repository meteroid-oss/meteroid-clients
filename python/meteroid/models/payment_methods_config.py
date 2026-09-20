# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel, TaggedUnionModel
from .bank_transfer_payment_method_config import BankTransferPaymentMethodConfig
from .external_payment_method_config import ExternalPaymentMethodConfig
from .online_payment_method_config import OnlinePaymentMethodConfig


@dataclasses.dataclass
class PaymentMethodsConfig(TaggedUnionModel):
    """Online (card/direct debit), BankTransfer, or External."""

    _DISCRIMINATOR: t.ClassVar[str] = "type"
    _DISCRIMINATOR_ATTR: t.ClassVar[str] = "type"
    _CONTENT_ATTR: t.ClassVar[str] = "content"
    _CONTENT_KEY: t.ClassVar[t.Optional[str]] = None
    _VARIANTS: t.ClassVar[t.Mapping[str, t.Optional[t.Type[BaseModel]]]] = {
        "online": OnlinePaymentMethodConfig,
        "bank_transfer": BankTransferPaymentMethodConfig,
        "external": ExternalPaymentMethodConfig,
    }

    type: t.Literal[
        "online",
        "bank_transfer",
        "external",
    ]
    content: t.Union[
        OnlinePaymentMethodConfig,
        BankTransferPaymentMethodConfig,
        ExternalPaymentMethodConfig,
    ]
