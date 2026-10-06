# this file is @generated
from __future__ import annotations

import typing as t

from ..serialization import Discriminator, UnknownVariant
from .boolean_feature_type import BooleanFeatureType
from .config_feature_type import ConfigFeatureType
from .metered_feature_type import MeteredFeatureType

FeatureType: t.TypeAlias = t.Annotated[
    BooleanFeatureType | MeteredFeatureType | ConfigFeatureType | UnknownVariant,
    Discriminator(
        "type",
        {
            "BOOLEAN": BooleanFeatureType,
            "METERED": MeteredFeatureType,
            "CONFIG": ConfigFeatureType,
        },
    ),
]
"""Told apart by `type`; a variant this SDK version does not know is an `UnknownVariant`."""
