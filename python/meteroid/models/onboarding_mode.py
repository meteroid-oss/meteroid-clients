# this file is @generated
import typing as t

from ..serialization import StrEnum


class OnboardingMode(StrEnum):
    """Onboarding mode for connected accounts"""

    EXPRESS = "express"
    FULL = "full"


OnboardingModeLiteral: t.TypeAlias = t.Literal["express", "full"]
"""The values of :class:`OnboardingMode`, which arguments take as plain strings too."""
