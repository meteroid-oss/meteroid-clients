# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel, TaggedUnionModel
from .boolean_config_value import BooleanConfigValue
from .json_config_value import JsonConfigValue
from .number_config_value import NumberConfigValue
from .text_config_value import TextConfigValue


@dataclasses.dataclass
class ConfigValue(TaggedUnionModel):
    """A static, typed configuration value carried by a Config entitlement. Resolved synchronously
    through the entitlement hierarchy — no metric, no usage counter."""

    _DISCRIMINATOR: t.ClassVar[str] = "kind"
    _DISCRIMINATOR_ATTR: t.ClassVar[str] = "kind"
    _CONTENT_ATTR: t.ClassVar[str] = "content"
    _CONTENT_KEY: t.ClassVar[t.Optional[str]] = None
    _VARIANTS: t.ClassVar[t.Mapping[str, t.Optional[t.Type[BaseModel]]]] = {
        "NUMBER": NumberConfigValue,
        "BOOLEAN": BooleanConfigValue,
        "TEXT": TextConfigValue,
        "JSON": JsonConfigValue,
    }

    kind: t.Literal[
        "NUMBER",
        "BOOLEAN",
        "TEXT",
        "JSON",
    ]
    content: t.Union[
        NumberConfigValue,
        BooleanConfigValue,
        TextConfigValue,
        JsonConfigValue,
    ]
