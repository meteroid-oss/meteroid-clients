# this file is @generated
import enum


class OnboardingMode(str, enum.Enum):
    """Onboarding mode for connected accounts"""

    EXPRESS = "express"
    FULL = "full"

    def __str__(self) -> str:
        return str(self.value)
