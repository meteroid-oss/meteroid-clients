# this file is @generated
import enum


class CustomerType(str, enum.Enum):
    """Company vs. individual (B2C). Defaults to `COMPANY`."""

    COMPANY = "COMPANY"
    INDIVIDUAL = "INDIVIDUAL"

    def __str__(self) -> str:
        return str(self.value)
