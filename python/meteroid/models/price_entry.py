# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel, TaggedUnionModel
from .existing_price_ref import ExistingPriceRef
from .price_input import PriceInput


@dataclasses.dataclass
class PriceEntry(TaggedUnionModel):
    _DISCRIMINATOR: t.ClassVar[str] = "type"
    _DISCRIMINATOR_ATTR: t.ClassVar[str] = "type"
    _CONTENT_ATTR: t.ClassVar[str] = "content"
    _CONTENT_KEY: t.ClassVar[t.Optional[str]] = None
    _VARIANTS: t.ClassVar[t.Mapping[str, t.Optional[t.Type[BaseModel]]]] = {
        "EXISTING": ExistingPriceRef,
        "NEW": PriceInput,
    }

    type: t.Literal[
        "EXISTING",
        "NEW",
    ]
    content: t.Union[
        ExistingPriceRef,
        PriceInput,
    ]
