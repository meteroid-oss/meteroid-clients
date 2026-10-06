# this file is @generated
import typing as t

from ..serialization import StrEnum


class ConfigValueType(StrEnum):
    """Authoritative value type of a Config feature. `MAP`/`JSON` both carry a JSON value."""

    NUMBER = "NUMBER"
    BOOLEAN = "BOOLEAN"
    TEXT = "TEXT"
    MAP = "MAP"
    JSON = "JSON"
    SELECT = "SELECT"


ConfigValueTypeLiteral: t.TypeAlias = t.Literal[
    "NUMBER", "BOOLEAN", "TEXT", "MAP", "JSON", "SELECT"
]
"""The values of :class:`ConfigValueType`, which arguments take as plain strings too."""
