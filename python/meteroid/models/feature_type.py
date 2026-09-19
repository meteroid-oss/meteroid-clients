# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel, TaggedUnionModel
from .boolean_feature_type import BooleanFeatureType
from .config_feature_type import ConfigFeatureType
from .metered_feature_type import MeteredFeatureType


@dataclasses.dataclass
class FeatureType(TaggedUnionModel):
    _DISCRIMINATOR: t.ClassVar[str] = "type"
    _DISCRIMINATOR_ATTR: t.ClassVar[str] = "type"
    _CONTENT_ATTR: t.ClassVar[str] = "content"
    _CONTENT_KEY: t.ClassVar[t.Optional[str]] = None
    _VARIANTS: t.ClassVar[t.Mapping[str, t.Optional[t.Type[BaseModel]]]] = {
        "BOOLEAN": BooleanFeatureType,
        "METERED": MeteredFeatureType,
        "CONFIG": ConfigFeatureType,
    }

    type: t.Literal[
        "BOOLEAN",
        "METERED",
        "CONFIG",
    ]
    content: t.Union[
        BooleanFeatureType,
        MeteredFeatureType,
        ConfigFeatureType,
    ]
