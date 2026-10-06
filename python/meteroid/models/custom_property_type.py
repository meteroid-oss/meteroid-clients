# this file is @generated
import typing as t

from ..serialization import StrEnum


class CustomPropertyType(StrEnum):
    """The values of `CustomPropertyType`; others are kept as received."""

    TEXT = "TEXT"
    NUMBER = "NUMBER"
    BOOLEAN = "BOOLEAN"
    DATE = "DATE"
    DATETIME = "DATETIME"
    SINGLE_SELECT = "SINGLE_SELECT"
    MULTI_SELECT = "MULTI_SELECT"
    JSON = "JSON"
    URL = "URL"
    EMAIL = "EMAIL"


CustomPropertyTypeLiteral: t.TypeAlias = t.Literal[
    "TEXT",
    "NUMBER",
    "BOOLEAN",
    "DATE",
    "DATETIME",
    "SINGLE_SELECT",
    "MULTI_SELECT",
    "JSON",
    "URL",
    "EMAIL",
]
"""The values of :class:`CustomPropertyType`, which arguments take as plain strings too."""
