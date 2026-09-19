# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel, TaggedUnionModel
from .matrix_pricing import MatrixPricing
from .package_pricing import PackagePricing
from .per_unit_pricing import PerUnitPricing
from .tiered_pricing import TieredPricing
from .volume_pricing import VolumePricing


@dataclasses.dataclass
class UsagePricingModel(TaggedUnionModel):
    _DISCRIMINATOR: t.ClassVar[str] = "type"
    _DISCRIMINATOR_ATTR: t.ClassVar[str] = "type"
    _CONTENT_ATTR: t.ClassVar[str] = "content"
    _CONTENT_KEY: t.ClassVar[t.Optional[str]] = None
    _VARIANTS: t.ClassVar[t.Mapping[str, t.Optional[t.Type[BaseModel]]]] = {
        "PER_UNIT": PerUnitPricing,
        "TIERED": TieredPricing,
        "VOLUME": VolumePricing,
        "PACKAGE": PackagePricing,
        "MATRIX": MatrixPricing,
    }

    type: t.Literal[
        "PER_UNIT",
        "TIERED",
        "VOLUME",
        "PACKAGE",
        "MATRIX",
    ]
    content: t.Union[
        PerUnitPricing,
        TieredPricing,
        VolumePricing,
        PackagePricing,
        MatrixPricing,
    ]
