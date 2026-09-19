# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel


@dataclasses.dataclass
class BillingConfig(BaseModel):
    billing_cycles: t.Optional[int] = None

    net_terms: t.Optional[int] = None

    period_start_day: t.Optional[int] = None
