# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import UNSET, BaseModel, Unset

if t.TYPE_CHECKING:
    from .billing_config import BillingConfig
    from .minimum_commitment_input import MinimumCommitmentInput
    from .plan_add_on_input import PlanAddOnInput
    from .plan_status_enum import PlanStatusEnum
    from .price_component_input import PriceComponentInput
    from .trial_config import TrialConfig


@dataclasses.dataclass(kw_only=True)
class ReplacePlanRequest(BaseModel):
    """The `ReplacePlanRequest` object."""

    components: list[PriceComponentInput]

    currency: str

    name: str

    add_ons: list[PlanAddOnInput] | None = None

    billing: BillingConfig | None | Unset = UNSET

    description: str | None | Unset = UNSET

    minimum_commitment: MinimumCommitmentInput | None | Unset = UNSET

    status: PlanStatusEnum | None | Unset = UNSET

    trial: TrialConfig | None | Unset = UNSET
