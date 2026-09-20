# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel, TaggedUnionModel
from .double_segmentation_matrix import DoubleSegmentationMatrix
from .linked_segmentation_matrix import LinkedSegmentationMatrix
from .metric_dimension import MetricDimension


@dataclasses.dataclass
class MetricSegmentationMatrix(TaggedUnionModel):
    _DISCRIMINATOR: t.ClassVar[str] = "type"
    _DISCRIMINATOR_ATTR: t.ClassVar[str] = "type"
    _CONTENT_ATTR: t.ClassVar[str] = "content"
    _CONTENT_KEY: t.ClassVar[t.Optional[str]] = None
    _VARIANTS: t.ClassVar[t.Mapping[str, t.Optional[t.Type[BaseModel]]]] = {
        "SINGLE": MetricDimension,
        "DOUBLE": DoubleSegmentationMatrix,
        "LINKED": LinkedSegmentationMatrix,
    }

    type: t.Literal[
        "SINGLE",
        "DOUBLE",
        "LINKED",
    ]
    content: t.Union[
        MetricDimension,
        DoubleSegmentationMatrix,
        LinkedSegmentationMatrix,
    ]
