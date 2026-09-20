# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel, TaggedUnionModel
from .all_components_scope import AllComponentsScope
from .components_scope import ComponentsScope


@dataclasses.dataclass
class MinimumCommitmentInputScope(TaggedUnionModel):
    _DISCRIMINATOR: t.ClassVar[str] = "type"
    _DISCRIMINATOR_ATTR: t.ClassVar[str] = "type"
    _CONTENT_ATTR: t.ClassVar[str] = "content"
    _CONTENT_KEY: t.ClassVar[t.Optional[str]] = None
    _VARIANTS: t.ClassVar[t.Mapping[str, t.Optional[t.Type[BaseModel]]]] = {
        "all_components": AllComponentsScope,
        "components": ComponentsScope,
    }

    type: t.Literal[
        "all_components",
        "components",
    ]
    content: t.Union[
        AllComponentsScope,
        ComponentsScope,
    ]
