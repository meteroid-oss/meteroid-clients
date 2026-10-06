# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .extra_recurring_billing_type_enum import ExtraRecurringBillingTypeEnum


@dataclasses.dataclass(kw_only=True)
class ExtraRecurringFeeStructure(BaseModel):
    """The `ExtraRecurringFeeStructure` object."""

    billing_type: ExtraRecurringBillingTypeEnum
