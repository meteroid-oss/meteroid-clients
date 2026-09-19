# this file is @generated
import dataclasses

from ..serialization import BaseModel
from .extra_recurring_billing_type_enum import ExtraRecurringBillingTypeEnum


@dataclasses.dataclass
class ExtraRecurringFeeStructure(BaseModel):
    billing_type: ExtraRecurringBillingTypeEnum
