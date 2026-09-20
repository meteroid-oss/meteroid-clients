# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
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


@dataclasses.dataclass
class Plan(BaseModel):
    available_parameters: AvailableParameters

    created_at: datetime

    currency: str

    id: PlanId

    name: str

    net_terms: int

    plan_type: PlanTypeEnum

    price_components: t.List[PriceComponent]

    product_family: ProductFamily

    status: PlanStatusEnum

    version: int

    version_id: PlanVersionId

    billing_cycles: t.Optional[int] = None

    description: t.Optional[str] = None

    entitlements: t.Optional[t.List[Entitlement]] = None

    minimum_commitment: t.Optional[MinimumCommitment] = None

    period_start_day: t.Optional[int] = None

    self_service_rank: t.Optional[int] = None

    trial: t.Optional[TrialConfig] = None
