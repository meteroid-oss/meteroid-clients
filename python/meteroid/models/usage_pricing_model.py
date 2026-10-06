# this file is @generated
from __future__ import annotations

import typing as t

from ..serialization import Discriminator, UnknownVariant
from .matrix_pricing import MatrixPricing
from .package_pricing import PackagePricing
from .per_unit_pricing import PerUnitPricing
from .tiered_pricing import TieredPricing
from .volume_pricing import VolumePricing

UsagePricingModel: t.TypeAlias = t.Annotated[
    PerUnitPricing
    | TieredPricing
    | VolumePricing
    | PackagePricing
    | MatrixPricing
    | UnknownVariant,
    Discriminator(
        "type",
        {
            "PER_UNIT": PerUnitPricing,
            "TIERED": TieredPricing,
            "VOLUME": VolumePricing,
            "PACKAGE": PackagePricing,
            "MATRIX": MatrixPricing,
        },
    ),
]
"""Told apart by `type`; a variant this SDK version does not know is an `UnknownVariant`."""
