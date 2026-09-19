# this file is @generated
import enum


class ConfigValueType(str, enum.Enum):
    """Authoritative value type of a Config feature. `MAP`/`JSON` both carry a JSON value."""

    NUMBER = "NUMBER"
    BOOLEAN = "BOOLEAN"
    TEXT = "TEXT"
    MAP = "MAP"
    JSON = "JSON"
    SELECT = "SELECT"

    def __str__(self) -> str:
        return str(self.value)
