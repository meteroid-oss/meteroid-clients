# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .connected_account_id import ConnectedAccountId
    from .connection_status import ConnectionStatus
    from .connection_type import ConnectionType
    from .country_code import CountryCode
    from .customer_id import CustomerId
    from .onboarding_mode import OnboardingMode
    from .organization_id import OrganizationId
    from .tenant_id import TenantId


@dataclasses.dataclass(kw_only=True)
class ConnectedAccount(BaseModel):
    """A connected account (relationship between platform and connected org)"""

    connection_type: ConnectionType

    created_at: datetime

    id: ConnectedAccountId

    onboarding_mode: OnboardingMode

    platform_organization_id: OrganizationId

    status: ConnectionStatus

    connected_organization_id: OrganizationId | None = None

    connected_tenant_id: TenantId | None = None

    metadata: t.Any = None

    onboarding_completed_at: datetime | None = None

    pending_country: CountryCode | None = None

    pending_email: str | None = None
    """Email of the user being invited (express flow only)"""

    pending_organization_name: str | None = None
    """Name of the organization to be created (express flow only)"""

    platform_customer_id: CustomerId | None = None

    revoked_at: datetime | None = None
