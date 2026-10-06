# this file is @generated
from __future__ import annotations

import typing as t

from ..serialization import Discriminator, UnknownVariant
from .double_segmentation_matrix import DoubleSegmentationMatrix
from .linked_segmentation_matrix import LinkedSegmentationMatrix
from .metric_dimension import MetricDimension

MetricSegmentationMatrix: t.TypeAlias = t.Annotated[
    MetricDimension
    | DoubleSegmentationMatrix
    | LinkedSegmentationMatrix
    | UnknownVariant,
    Discriminator(
        "type",
        {
            "SINGLE": MetricDimension,
            "DOUBLE": DoubleSegmentationMatrix,
            "LINKED": LinkedSegmentationMatrix,
        },
    ),
]
"""Told apart by `type`; a variant this SDK version does not know is an `UnknownVariant`."""
