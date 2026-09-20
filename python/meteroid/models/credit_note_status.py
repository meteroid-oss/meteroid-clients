# this file is @generated
import enum


class CreditNoteStatus(str, enum.Enum):
    DRAFT = "DRAFT"
    FINALIZED = "FINALIZED"
    VOIDED = "VOIDED"

    def __str__(self) -> str:
        return str(self.value)
