# this file is @generated
import enum


class MetricFilterOperator(str, enum.Enum):
    """Operator of a pre-aggregation [`MetricFilter`]. `EQUAL`/`NOT_EQUAL` are the single-value
    forms of `IN`/`NOT_IN`. Negation (`NOT_EQUAL`/`NOT_IN`) is presence-required: an event
    missing the property is excluded."""

    EQUAL = "EQUAL"
    NOT_EQUAL = "NOT_EQUAL"
    IN = "IN"
    NOT_IN = "NOT_IN"

    def __str__(self) -> str:
        return str(self.value)
