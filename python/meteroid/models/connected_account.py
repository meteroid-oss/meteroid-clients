# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
from .connected_account_id import ConnectedAccountId
from .connection_status import ConnectionStatus
from .connection_type import ConnectionType
from .country_code import CountryCode
from .customer_id import CustomerId
from .onboarding_mode import OnboardingMode
from .organization_id import OrganizationId
from .tenant_id import TenantId


@dataclasses.dataclass
class ConnectedAccount(BaseModel):
    """A connected account (relationship between platform and connected org)"""

    connection_type: ConnectionType

    created_at: datetime

    id: ConnectedAccountId

    onboarding_mode: OnboardingMode

    platform_organization_id: OrganizationId

    status: ConnectionStatus

    connected_organization_id: t.Optional[OrganizationId] = None

    connected_tenant_id: t.Optional[TenantId] = None

    metadata: t.Optional[t.Dict[str, t.Any]] = None

    onboarding_completed_at: t.Optional[datetime] = None

    pending_country: t.Optional[CountryCode] = None

    pending_email: t.Optional[str] = None
    """Email of the user being invited (express flow only)"""

    pending_organization_name: t.Optional[str] = None
    """Name of the organization to be created (express flow only)"""

    platform_customer_id: t.Optional[CustomerId] = None

    revoked_at: t.Optional[datetime] = None
