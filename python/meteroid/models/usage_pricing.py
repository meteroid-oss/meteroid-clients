# this file is @generated
import dataclasses

from ..serialization import BaseModel
from .usage_pricing_model import UsagePricingModel


@dataclasses.dataclass
class UsagePricing(BaseModel):
    model: UsagePricingModel
