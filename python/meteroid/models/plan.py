# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .available_parameters import AvailableParameters
    from .entitlement import Entitlement
    from .minimum_commitment import MinimumCommitment
    from .plan_id import PlanId
    from .plan_status_enum import PlanStatusEnum
    from .plan_type_enum import PlanTypeEnum
    from .plan_version_id import PlanVersionId
    from .price_component import PriceComponent
    from .product_family import ProductFamily
    from .trial_config import TrialConfig


@dataclasses.dataclass(kw_only=True)
class Plan(BaseModel):
    """The `Plan` object."""

    available_parameters: AvailableParameters

    created_at: datetime

    currency: str

    id: PlanId

    name: str

    net_terms: int

    plan_type: PlanTypeEnum

    price_components: list[PriceComponent]

    product_family: ProductFamily

    status: PlanStatusEnum

    version: int

    version_id: PlanVersionId

    billing_cycles: int | None = None

    description: str | None = None

    entitlements: list[Entitlement] | None = None

    minimum_commitment: MinimumCommitment | None = None

    period_start_day: int | None = None

    self_service_rank: int | None = None

    trial: TrialConfig | None = None
