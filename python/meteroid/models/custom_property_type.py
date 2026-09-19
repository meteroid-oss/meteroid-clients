# this file is @generated
import enum


class CustomPropertyType(str, enum.Enum):
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

    def __str__(self) -> str:
        return str(self.value)
