# this file is @generated
import dataclasses

from ..serialization import BaseModel


@dataclasses.dataclass
class IntrospectionRequest(BaseModel):
    """Token introspection request"""

    token: str
    """The token to introspect"""
