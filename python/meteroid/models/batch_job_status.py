# this file is @generated
import enum


class BatchJobStatus(str, enum.Enum):
    PENDING = "PENDING"
    CHUNKING = "CHUNKING"
    PROCESSING = "PROCESSING"
    COMPLETED = "COMPLETED"
    COMPLETED_WITH_ERRORS = "COMPLETED_WITH_ERRORS"
    FAILED = "FAILED"
    CANCELLED = "CANCELLED"

    def __str__(self) -> str:
        return str(self.value)
