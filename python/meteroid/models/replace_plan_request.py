# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .billing_config import BillingConfig
from .minimum_commitment_input import MinimumCommitmentInput
from .plan_add_on_input import PlanAddOnInput
from .plan_status_enum import PlanStatusEnum
from .price_component_input import PriceComponentInput
from .trial_config import TrialConfig


@dataclasses.dataclass
class ReplacePlanRequest(BaseModel):
    components: t.List[PriceComponentInput]

    currency: str

    name: str

    add_ons: t.Optional[t.List[PlanAddOnInput]] = None

    billing: t.Optional[BillingConfig] = None

    description: t.Optional[str] = None

    minimum_commitment: t.Optional[MinimumCommitmentInput] = None

    status: t.Optional[PlanStatusEnum] = None

    trial: t.Optional[TrialConfig] = None
