# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import UNSET, BaseModel, Unset

if t.TYPE_CHECKING:
    from .billing_config import BillingConfig
    from .plan_add_on_input import PlanAddOnInput
    from .plan_status_enum import PlanStatusEnum
    from .plan_type_enum import PlanTypeEnum
    from .price_component_input import PriceComponentInput
    from .product_family_id import ProductFamilyId
    from .trial_config import TrialConfig


@dataclasses.dataclass(kw_only=True)
class CreatePlanRequest(BaseModel):
    """The `CreatePlanRequest` object."""

    components: list[PriceComponentInput]

    currency: str

    name: str

    plan_type: PlanTypeEnum

    product_family_id: ProductFamilyId

    status: PlanStatusEnum

    add_ons: list[PlanAddOnInput] | None = None

    billing: BillingConfig | None | Unset = UNSET

    description: str | None | Unset = UNSET

    self_service_rank: int | None | Unset = UNSET

    trial: TrialConfig | None | Unset = UNSET
