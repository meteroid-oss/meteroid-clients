# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel, TaggedUnionModel
from .matrix_plan_pricing import MatrixPlanPricing
from .package_plan_pricing import PackagePlanPricing
from .per_unit_plan_pricing import PerUnitPlanPricing
from .tiered_plan_pricing import TieredPlanPricing
from .volume_plan_pricing import VolumePlanPricing


@dataclasses.dataclass
class PlanUsagePricingModel(TaggedUnionModel):
    _DISCRIMINATOR: t.ClassVar[str] = "type"
    _DISCRIMINATOR_ATTR: t.ClassVar[str] = "type"
    _CONTENT_ATTR: t.ClassVar[str] = "content"
    _CONTENT_KEY: t.ClassVar[t.Optional[str]] = None
    _VARIANTS: t.ClassVar[t.Mapping[str, t.Optional[t.Type[BaseModel]]]] = {
        "PER_UNIT": PerUnitPlanPricing,
        "TIERED": TieredPlanPricing,
        "VOLUME": VolumePlanPricing,
        "PACKAGE": PackagePlanPricing,
        "MATRIX": MatrixPlanPricing,
    }

    type: t.Literal[
        "PER_UNIT",
        "TIERED",
        "VOLUME",
        "PACKAGE",
        "MATRIX",
    ]
    content: t.Union[
        PerUnitPlanPricing,
        TieredPlanPricing,
        VolumePlanPricing,
        PackagePlanPricing,
        MatrixPlanPricing,
    ]
