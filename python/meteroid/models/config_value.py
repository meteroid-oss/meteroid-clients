# this file is @generated
from __future__ import annotations

import typing as t

from ..serialization import Discriminator, UnknownVariant
from .boolean_config_value import BooleanConfigValue
from .json_config_value import JsonConfigValue
from .number_config_value import NumberConfigValue
from .text_config_value import TextConfigValue

ConfigValue: t.TypeAlias = t.Annotated[
    NumberConfigValue
    | BooleanConfigValue
    | TextConfigValue
    | JsonConfigValue
    | UnknownVariant,
    Discriminator(
        "kind",
        {
            "NUMBER": NumberConfigValue,
            "BOOLEAN": BooleanConfigValue,
            "TEXT": TextConfigValue,
            "JSON": JsonConfigValue,
        },
    ),
]
"""A static, typed configuration value carried by a Config entitlement. Resolved synchronously
through the entitlement hierarchy — no metric, no usage counter.

Told apart by `kind`; a variant this SDK version does not know is an `UnknownVariant`."""
