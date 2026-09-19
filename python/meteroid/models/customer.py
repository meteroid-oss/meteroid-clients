# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .address import Address
from .currency import Currency
from .custom_tax_rate import CustomTaxRate
from .customer_id import CustomerId
from .customer_type import CustomerType
from .invoicing_entity_id import InvoicingEntityId
from .shipping_address import ShippingAddress


@dataclasses.dataclass
class Customer(BaseModel):
    currency: Currency

    custom_properties: t.Any
    """User-defined custom property values, keyed by definition `key`."""

    custom_taxes: t.List[CustomTaxRate]

    id: CustomerId

    invoicing_emails: t.List[str]

    invoicing_entity_id: InvoicingEntityId

    name: str

    preferred_locales: t.List[str]
    """Preferred document languages, most-preferred first (BCP-47 tags, e.g.
    `["fr-FR", "en"]`); overrides the invoicing entity default."""

    alias: t.Optional[str] = None

    billing_address: t.Optional[Address] = None

    billing_email: t.Optional[str] = None

    connected_account_id: t.Optional[str] = None

    customer_type: t.Optional[CustomerType] = None

    first_name: t.Optional[str] = None

    invoicing_language: t.Optional[str] = None
    """Deprecated: the first entry of `preferred_locales`."""

    last_name: t.Optional[str] = None

    legal_number: t.Optional[str] = None
    """BT-47 — the buyer's national register identifier (SIREN/SIRET, HRB)."""

    phone: t.Optional[str] = None

    shipping_address: t.Optional[ShippingAddress] = None

    vat_number: t.Optional[str] = None
