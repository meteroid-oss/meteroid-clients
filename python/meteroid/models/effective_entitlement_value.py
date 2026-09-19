# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel, TaggedUnionModel
from .boolean_effective_entitlement_value import BooleanEffectiveEntitlementValue
from .config_effective_entitlement_value import ConfigEffectiveEntitlementValue
from .metered_effective_entitlement_value import MeteredEffectiveEntitlementValue


@dataclasses.dataclass
class EffectiveEntitlementValue(TaggedUnionModel):
    _DISCRIMINATOR: t.ClassVar[str] = "type"
    _DISCRIMINATOR_ATTR: t.ClassVar[str] = "type"
    _CONTENT_ATTR: t.ClassVar[str] = "content"
    _CONTENT_KEY: t.ClassVar[t.Optional[str]] = None
    _VARIANTS: t.ClassVar[t.Mapping[str, t.Optional[t.Type[BaseModel]]]] = {
        "BOOLEAN": BooleanEffectiveEntitlementValue,
        "METERED": MeteredEffectiveEntitlementValue,
        "CONFIG": ConfigEffectiveEntitlementValue,
    }

    type: t.Literal[
        "BOOLEAN",
        "METERED",
        "CONFIG",
    ]
    content: t.Union[
        BooleanEffectiveEntitlementValue,
        MeteredEffectiveEntitlementValue,
        ConfigEffectiveEntitlementValue,
    ]
