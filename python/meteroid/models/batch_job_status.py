# this file is @generated
import typing as t

from ..serialization import StrEnum


class BatchJobStatus(StrEnum):
    """The values of `BatchJobStatus`; others are kept as received."""

    PENDING = "PENDING"
    CHUNKING = "CHUNKING"
    PROCESSING = "PROCESSING"
    COMPLETED = "COMPLETED"
    COMPLETED_WITH_ERRORS = "COMPLETED_WITH_ERRORS"
    FAILED = "FAILED"
    CANCELLED = "CANCELLED"


BatchJobStatusLiteral: t.TypeAlias = t.Literal[
    "PENDING",
    "CHUNKING",
    "PROCESSING",
    "COMPLETED",
    "COMPLETED_WITH_ERRORS",
    "FAILED",
    "CANCELLED",
]
"""The values of :class:`BatchJobStatus`, which arguments take as plain strings too."""
