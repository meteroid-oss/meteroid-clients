# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel


@dataclasses.dataclass
class ProductsScope(BaseModel):
    """Only lines for the listed products count. A product is the identity shared by plan
    components, overrides and ad-hoc extras, so a subscription's billed set is matched uniformly."""

    product_ids: t.List[str]
