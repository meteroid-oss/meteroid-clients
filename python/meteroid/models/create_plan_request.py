# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .billing_config import BillingConfig
from .plan_add_on_input import PlanAddOnInput
from .plan_status_enum import PlanStatusEnum
from .plan_type_enum import PlanTypeEnum
from .price_component_input import PriceComponentInput
from .product_family_id import ProductFamilyId
from .trial_config import TrialConfig


@dataclasses.dataclass
class CreatePlanRequest(BaseModel):
    components: t.List[PriceComponentInput]

    currency: str

    name: str

    plan_type: PlanTypeEnum

    product_family_id: ProductFamilyId

    status: PlanStatusEnum

    add_ons: t.Optional[t.List[PlanAddOnInput]] = None

    billing: t.Optional[BillingConfig] = None

    description: t.Optional[str] = None

    self_service_rank: t.Optional[int] = None

    trial: t.Optional[TrialConfig] = None
