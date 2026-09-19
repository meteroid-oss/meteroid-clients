# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel, TaggedUnionModel
from .existing_product_ref import ExistingProductRef
from .new_product_ref import NewProductRef


@dataclasses.dataclass
class ProductRef(TaggedUnionModel):
    _DISCRIMINATOR: t.ClassVar[str] = "type"
    _DISCRIMINATOR_ATTR: t.ClassVar[str] = "type"
    _CONTENT_ATTR: t.ClassVar[str] = "content"
    _CONTENT_KEY: t.ClassVar[t.Optional[str]] = None
    _VARIANTS: t.ClassVar[t.Mapping[str, t.Optional[t.Type[BaseModel]]]] = {
        "EXISTING": ExistingProductRef,
        "NEW": NewProductRef,
    }

    type: t.Literal[
        "EXISTING",
        "NEW",
    ]
    content: t.Union[
        ExistingProductRef,
        NewProductRef,
    ]
