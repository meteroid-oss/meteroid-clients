# this file is @generated
from __future__ import annotations

import typing as t

from ..serialization import Discriminator, UnknownVariant
from .matrix_plan_pricing import MatrixPlanPricing
from .package_plan_pricing import PackagePlanPricing
from .per_unit_plan_pricing import PerUnitPlanPricing
from .tiered_plan_pricing import TieredPlanPricing
from .volume_plan_pricing import VolumePlanPricing

PlanUsagePricingModel: t.TypeAlias = t.Annotated[
    PerUnitPlanPricing
    | TieredPlanPricing
    | VolumePlanPricing
    | PackagePlanPricing
    | MatrixPlanPricing
    | UnknownVariant,
    Discriminator(
        "type",
        {
            "PER_UNIT": PerUnitPlanPricing,
            "TIERED": TieredPlanPricing,
            "VOLUME": VolumePlanPricing,
            "PACKAGE": PackagePlanPricing,
            "MATRIX": MatrixPlanPricing,
        },
    ),
]
"""Told apart by `type`; a variant this SDK version does not know is an `UnknownVariant`."""
