# this file is @generated
from __future__ import annotations

import dataclasses

from ..serialization import BaseModel


@dataclasses.dataclass(kw_only=True)
class EInvoicingFinding(BaseModel):
    """One rule the document did not satisfy, in the standard's own vocabulary."""

    message: str

    rule: str
    """The rule identifier — "BR-11", "PEPPOL-EN16931-R003"."""

    term: str
    """The business term path it is about — "BG-8/BT-55"."""

    hint: str | None = None
