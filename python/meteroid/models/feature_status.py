# this file is @generated
import typing as t

from ..serialization import StrEnum


class FeatureStatus(StrEnum):
    """Lifecycle status of a feature."""

    ACTIVE = "ACTIVE"
    DISABLED = "DISABLED"
    ARCHIVED = "ARCHIVED"


FeatureStatusLiteral: t.TypeAlias = t.Literal["ACTIVE", "DISABLED", "ARCHIVED"]
"""The values of :class:`FeatureStatus`, which arguments take as plain strings too."""
