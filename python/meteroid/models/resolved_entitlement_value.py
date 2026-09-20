# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel, TaggedUnionModel
from .boolean_resolved_entitlement_value import BooleanResolvedEntitlementValue
from .config_resolved_entitlement_value import ConfigResolvedEntitlementValue
from .metered_resolved_entitlement_value import MeteredResolvedEntitlementValue


@dataclasses.dataclass
class ResolvedEntitlementValue(TaggedUnionModel):
    _DISCRIMINATOR: t.ClassVar[str] = "type"
    _DISCRIMINATOR_ATTR: t.ClassVar[str] = "type"
    _CONTENT_ATTR: t.ClassVar[str] = "content"
    _CONTENT_KEY: t.ClassVar[t.Optional[str]] = None
    _VARIANTS: t.ClassVar[t.Mapping[str, t.Optional[t.Type[BaseModel]]]] = {
        "BOOLEAN": BooleanResolvedEntitlementValue,
        "METERED": MeteredResolvedEntitlementValue,
        "CONFIG": ConfigResolvedEntitlementValue,
    }

    type: t.Literal[
        "BOOLEAN",
        "METERED",
        "CONFIG",
    ]
    content: t.Union[
        BooleanResolvedEntitlementValue,
        MeteredResolvedEntitlementValue,
        ConfigResolvedEntitlementValue,
    ]
