# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .billing_period_enum import BillingPeriodEnum


@dataclasses.dataclass
class ComponentParameters(BaseModel):
    billing_period: t.Optional[BillingPeriodEnum] = None

    committed_capacity: t.Optional[int] = None

    initial_slot_count: t.Optional[int] = None
