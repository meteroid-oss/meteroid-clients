# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel


@dataclasses.dataclass
class ComponentsScope(BaseModel):
    """Component names — matched against `ReplacePlanRequest::components[].name`."""

    component_names: t.List[str]
