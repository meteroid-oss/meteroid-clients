# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel, TaggedUnionModel
from .boolean_entitlement_value import BooleanEntitlementValue
from .config_entitlement_value import ConfigEntitlementValue
from .metered_entitlement_value import MeteredEntitlementValue


@dataclasses.dataclass
class EntitlementValue(TaggedUnionModel):
    _DISCRIMINATOR: t.ClassVar[str] = "type"
    _DISCRIMINATOR_ATTR: t.ClassVar[str] = "type"
    _CONTENT_ATTR: t.ClassVar[str] = "content"
    _CONTENT_KEY: t.ClassVar[t.Optional[str]] = None
    _VARIANTS: t.ClassVar[t.Mapping[str, t.Optional[t.Type[BaseModel]]]] = {
        "BOOLEAN": BooleanEntitlementValue,
        "METERED": MeteredEntitlementValue,
        "CONFIG": ConfigEntitlementValue,
    }

    type: t.Literal[
        "BOOLEAN",
        "METERED",
        "CONFIG",
    ]
    content: t.Union[
        BooleanEntitlementValue,
        MeteredEntitlementValue,
        ConfigEntitlementValue,
    ]
