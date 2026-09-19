# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel, TaggedUnionModel
from .subscription_add_on_parameterization import SubscriptionAddOnParameterization
from .subscription_add_on_price_override import SubscriptionAddOnPriceOverride


@dataclasses.dataclass
class SubscriptionAddOnCustomization(TaggedUnionModel):
    _DISCRIMINATOR: t.ClassVar[str] = "type"
    _DISCRIMINATOR_ATTR: t.ClassVar[str] = "type"
    _CONTENT_ATTR: t.ClassVar[str] = "content"
    _CONTENT_KEY: t.ClassVar[t.Optional[str]] = None
    _VARIANTS: t.ClassVar[t.Mapping[str, t.Optional[t.Type[BaseModel]]]] = {
        "PRICE_OVERRIDE": SubscriptionAddOnPriceOverride,
        "PARAMETERIZATION": SubscriptionAddOnParameterization,
    }

    type: t.Literal[
        "PRICE_OVERRIDE",
        "PARAMETERIZATION",
    ]
    content: t.Union[
        SubscriptionAddOnPriceOverride,
        SubscriptionAddOnParameterization,
    ]
