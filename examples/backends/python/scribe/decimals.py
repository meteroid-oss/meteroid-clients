"""Exact decimals, in and out.

The Meteroid Python SDK hands every ``format: decimal`` value over as a
``decimal.Decimal``, so unlike the TypeScript backend this one gets its arithmetic for
free. What is left is the two ends: rendering a ``Decimal`` the way the contract wants
it, and making sure no operation in between ever rounds. Nothing in this backend passes
a decimal through ``float``: that is how a 0.1-minute clip eventually bills wrong.
"""

from decimal import Context, Decimal, Inexact

from .error import ApiError

# `Decimal` arithmetic rounds to the context's precision — 28 digits by default — and
# does so silently. Every sum and difference here goes through this context instead:
# far more digits than a quota will ever need, and an exception rather than a rounded
# result if that ever stops being true.
_EXACT = Context(prec=200, traps=[Inexact])


def render(value: Decimal) -> str:
    """Render a decimal the way the contract requires: an exact string, trailing zeros
    trimmed, never scientific notation. `Decimal("3.50")` becomes `"3.5"`.
    """
    # Not paranoia: the SDK builds its decimals with `Decimal(str(json_value))`, which
    # accepts "NaN" and "Infinity" as readily as "3.5". Every decimal rendered here came
    # from Meteroid, so a non-number is an upstream problem rather than a bug here.
    if not value.is_finite():
        raise ApiError(
            "UPSTREAM_ERROR",
            f"Meteroid returned {str(value)!r} where an exact decimal was expected.",
        )
    # The "f" format is what rules out `1E+3`; `normalize()` alone would produce it.
    text = format(value, "f")
    if "." in text:
        text = text.rstrip("0").rstrip(".")
    return "0" if text in ("-0", "") else text


def render_opt(value: Decimal | None) -> str | None:
    return None if value is None else render(value)


def add(a: Decimal, b: Decimal) -> Decimal:
    return _EXACT.add(a, b)


def subtract(a: Decimal, b: Decimal) -> Decimal:
    return _EXACT.subtract(a, b)


def billable_minutes(duration_seconds: int) -> Decimal:
    """`duration_seconds / 60`, rounded **up** to two decimals — the demo always bills at
    least what it used. Integer ceiling division, so `100 / 60` is exactly `1.67`.
    """
    hundredths = (duration_seconds * 100 + 59) // 60
    return Decimal(hundredths).scaleb(-2)
