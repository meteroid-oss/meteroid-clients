# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel, TaggedUnionModel
from .fixed_discount import FixedDiscount
from .percentage_discount import PercentageDiscount


@dataclasses.dataclass
class CouponDiscount(TaggedUnionModel):
    _DISCRIMINATOR: t.ClassVar[str] = "type"
    _DISCRIMINATOR_ATTR: t.ClassVar[str] = "type"
    _CONTENT_ATTR: t.ClassVar[str] = "content"
    _CONTENT_KEY: t.ClassVar[t.Optional[str]] = None
    _VARIANTS: t.ClassVar[t.Mapping[str, t.Optional[t.Type[BaseModel]]]] = {
        "PERCENTAGE": PercentageDiscount,
        "FIXED": FixedDiscount,
    }

    type: t.Literal[
        "PERCENTAGE",
        "FIXED",
    ]
    content: t.Union[
        PercentageDiscount,
        FixedDiscount,
    ]
