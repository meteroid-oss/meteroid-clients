# this file is @generated
"""Models for the Meteroid API.

Each model's module is imported the first time the model is used.
"""

from __future__ import annotations

import importlib
import typing as t

from ..serialization import UNSET, UnknownVariant, Unset

if t.TYPE_CHECKING:
    from .add_on import AddOn
    from .add_on_event import AddOnEvent
    from .add_on_event_data import AddOnEventData
    from .add_on_id import AddOnId
    from .add_on_list_response import AddOnListResponse
    from .address import Address
    from .all_components_scope import AllComponentsScope
    from .applied_coupon import AppliedCoupon
    from .applied_coupon_detailed import AppliedCouponDetailed
    from .applied_coupon_id import AppliedCouponId
    from .available_parameters import AvailableParameters
    from .bank_account_id import BankAccountId
    from .bank_transfer_payment_method_config import BankTransferPaymentMethodConfig
    from .batch_job_chunk_id import BatchJobChunkId
    from .batch_job_detail_response import BatchJobDetailResponse
    from .batch_job_failures_response import BatchJobFailuresResponse
    from .batch_job_id import BatchJobId
    from .batch_job_item_failure_response import BatchJobItemFailureResponse
    from .batch_job_list_response import BatchJobListResponse
    from .batch_job_response import BatchJobResponse
    from .batch_job_status import BatchJobStatus, BatchJobStatusLiteral
    from .batch_job_type import BatchJobType, BatchJobTypeLiteral
    from .billable_metric_id import BillableMetricId
    from .billing_config import BillingConfig
    from .billing_cycle_reset_period import BillingCycleResetPeriod
    from .billing_metric_aggregate_enum import (
        BillingMetricAggregateEnum,
        BillingMetricAggregateEnumLiteral,
    )
    from .billing_period_enum import BillingPeriodEnum, BillingPeriodEnumLiteral
    from .billing_type import BillingType, BillingTypeLiteral
    from .billing_type_enum import BillingTypeEnum, BillingTypeEnumLiteral
    from .boolean_config_value import BooleanConfigValue
    from .boolean_effective_entitlement_value import BooleanEffectiveEntitlementValue
    from .boolean_entitlement_value import BooleanEntitlementValue
    from .boolean_feature_type import BooleanFeatureType
    from .boolean_resolved_entitlement_value import BooleanResolvedEntitlementValue
    from .calendar_reset_period import CalendarResetPeriod
    from .calendar_unit import CalendarUnit, CalendarUnitLiteral
    from .cancel_checkout_session_response import CancelCheckoutSessionResponse
    from .cancel_subscription_request import CancelSubscriptionRequest
    from .cancel_subscription_response import CancelSubscriptionResponse
    from .capacity_fee import CapacityFee
    from .capacity_fee_structure import CapacityFeeStructure
    from .capacity_plan_fee import CapacityPlanFee
    from .capacity_pricing import CapacityPricing
    from .capacity_threshold import CapacityThreshold
    from .checkout_session import CheckoutSession
    from .checkout_session_id import CheckoutSessionId
    from .checkout_session_status import (
        CheckoutSessionStatus,
        CheckoutSessionStatusLiteral,
    )
    from .checkout_type import CheckoutType, CheckoutTypeLiteral
    from .component_override import ComponentOverride
    from .component_parameterization import ComponentParameterization
    from .component_parameters import ComponentParameters
    from .components_scope import ComponentsScope
    from .config_effective_entitlement_value import ConfigEffectiveEntitlementValue
    from .config_entitlement_value import ConfigEntitlementValue
    from .config_feature_type import ConfigFeatureType
    from .config_resolved_entitlement_value import ConfigResolvedEntitlementValue
    from .config_value import ConfigValue
    from .config_value_type import ConfigValueType, ConfigValueTypeLiteral
    from .connected_account import ConnectedAccount
    from .connected_account_id import ConnectedAccountId
    from .connected_accounts_response import ConnectedAccountsResponse
    from .connection_status import ConnectionStatus, ConnectionStatusLiteral
    from .connection_type import ConnectionType, ConnectionTypeLiteral
    from .country_code import CountryCode
    from .coupon import Coupon
    from .coupon_discount import CouponDiscount
    from .coupon_event import CouponEvent
    from .coupon_event_data import CouponEventData
    from .coupon_filter import CouponFilter, CouponFilterLiteral
    from .coupon_id import CouponId
    from .coupon_line_item import CouponLineItem
    from .coupon_list_response import CouponListResponse
    from .create_add_on_request import CreateAddOnRequest
    from .create_checkout_session_request import CreateCheckoutSessionRequest
    from .create_checkout_session_response import CreateCheckoutSessionResponse
    from .create_connected_account_request import CreateConnectedAccountRequest
    from .create_coupon_request import CreateCouponRequest
    from .create_metric_request import CreateMetricRequest
    from .create_o_auth_app_request import CreateOAuthAppRequest
    from .create_onboarding_link_request import CreateOnboardingLinkRequest
    from .create_plan_request import CreatePlanRequest
    from .create_product_request import CreateProductRequest
    from .create_subscription_add_on import CreateSubscriptionAddOn
    from .create_subscription_components import CreateSubscriptionComponents
    from .credit_note import CreditNote
    from .credit_note_custom_properties_request import CreditNoteCustomPropertiesRequest
    from .credit_note_event import CreditNoteEvent
    from .credit_note_event_data import CreditNoteEventData
    from .credit_note_id import CreditNoteId
    from .credit_note_list_response import CreditNoteListResponse
    from .credit_note_status import CreditNoteStatus, CreditNoteStatusLiteral
    from .credit_type import CreditType, CreditTypeLiteral
    from .currency import Currency, CurrencyLiteral
    from .custom_property_definition import CustomPropertyDefinition
    from .custom_property_definition_create_request import (
        CustomPropertyDefinitionCreateRequest,
    )
    from .custom_property_definition_id import CustomPropertyDefinitionId
    from .custom_property_definition_list_response import (
        CustomPropertyDefinitionListResponse,
    )
    from .custom_property_definition_update_request import (
        CustomPropertyDefinitionUpdateRequest,
    )
    from .custom_property_entity_type import (
        CustomPropertyEntityType,
        CustomPropertyEntityTypeLiteral,
    )
    from .custom_property_type import CustomPropertyType, CustomPropertyTypeLiteral
    from .custom_tax_rate import CustomTaxRate
    from .customer import Customer
    from .customer_create_request import CustomerCreateRequest
    from .customer_details import CustomerDetails
    from .customer_event import CustomerEvent
    from .customer_event_data import CustomerEventData
    from .customer_id import CustomerId
    from .customer_list_response import CustomerListResponse
    from .customer_patch_request import CustomerPatchRequest
    from .customer_payment_method_id import CustomerPaymentMethodId
    from .customer_portal_token_request import CustomerPortalTokenRequest
    from .customer_portal_token_response import CustomerPortalTokenResponse
    from .customer_type import CustomerType, CustomerTypeLiteral
    from .customer_update_request import CustomerUpdateRequest
    from .double_segmentation_matrix import DoubleSegmentationMatrix
    from .e_invoicing_finding import EInvoicingFinding
    from .e_invoicing_status import EInvoicingStatus, EInvoicingStatusLiteral
    from .effective_entitlement import EffectiveEntitlement
    from .effective_entitlement_list_response import EffectiveEntitlementListResponse
    from .effective_entitlement_value import EffectiveEntitlementValue
    from .entitlement import Entitlement
    from .entitlement_id import EntitlementId
    from .entitlement_product_ref import EntitlementProductRef
    from .entitlement_value import EntitlementValue
    from .error_code import ErrorCode, ErrorCodeLiteral
    from .event import Event
    from .event_id import EventId
    from .event_type import EventType, EventTypeLiteral
    from .existing_price_ref import ExistingPriceRef
    from .existing_product_ref import ExistingProductRef
    from .external_payment_method_config import ExternalPaymentMethodConfig
    from .extra_component import ExtraComponent
    from .extra_recurring_billing_type_enum import (
        ExtraRecurringBillingTypeEnum,
        ExtraRecurringBillingTypeEnumLiteral,
    )
    from .extra_recurring_fee_structure import ExtraRecurringFeeStructure
    from .extra_recurring_plan_fee import ExtraRecurringPlanFee
    from .extra_recurring_pricing import ExtraRecurringPricing
    from .feature import Feature
    from .feature_id import FeatureId
    from .feature_list_response import FeatureListResponse
    from .feature_ref import FeatureRef
    from .feature_status import FeatureStatus, FeatureStatusLiteral
    from .feature_type import FeatureType
    from .fee import Fee
    from .fixed_discount import FixedDiscount
    from .fixed_window_reset_period import FixedWindowResetPeriod
    from .get_checkout_session_response import GetCheckoutSessionResponse
    from .grouped_usage import GroupedUsage
    from .ingest_events_request import IngestEventsRequest
    from .ingest_events_response import IngestEventsResponse
    from .ingest_failure import IngestFailure
    from .introspection_request import IntrospectionRequest
    from .invoice import Invoice
    from .invoice_custom_properties_request import InvoiceCustomPropertiesRequest
    from .invoice_documents_event import InvoiceDocumentsEvent
    from .invoice_documents_event_data import InvoiceDocumentsEventData
    from .invoice_event import InvoiceEvent
    from .invoice_event_data import InvoiceEventData
    from .invoice_id import InvoiceId
    from .invoice_line_item import InvoiceLineItem
    from .invoice_list_response import InvoiceListResponse
    from .invoice_payment_status import (
        InvoicePaymentStatus,
        InvoicePaymentStatusLiteral,
    )
    from .invoice_status import InvoiceStatus, InvoiceStatusLiteral
    from .invoice_type import InvoiceType, InvoiceTypeLiteral
    from .invoicing_entity_id import InvoicingEntityId
    from .json_config_value import JsonConfigValue
    from .linked_segmentation_matrix import LinkedSegmentationMatrix
    from .list_checkout_sessions_response import ListCheckoutSessionsResponse
    from .matrix_dimension import MatrixDimension
    from .matrix_plan_pricing import MatrixPlanPricing
    from .matrix_pricing import MatrixPricing
    from .matrix_row import MatrixRow
    from .metered_effective_entitlement_value import MeteredEffectiveEntitlementValue
    from .metered_entitlement_spec import MeteredEntitlementSpec
    from .metered_entitlement_usage import MeteredEntitlementUsage
    from .metered_entitlement_value import MeteredEntitlementValue
    from .metered_feature_type import MeteredFeatureType
    from .metered_resolved_entitlement_value import MeteredResolvedEntitlementValue
    from .metric import Metric
    from .metric_dimension import MetricDimension
    from .metric_event import MetricEvent
    from .metric_event_data import MetricEventData
    from .metric_filter import MetricFilter
    from .metric_filter_operator import (
        MetricFilterOperator,
        MetricFilterOperatorLiteral,
    )
    from .metric_list_response import MetricListResponse
    from .metric_segmentation_matrix import MetricSegmentationMatrix
    from .metric_summary import MetricSummary
    from .metric_usage import MetricUsage
    from .minimum_commitment import MinimumCommitment
    from .minimum_commitment_input import MinimumCommitmentInput
    from .minimum_commitment_input_scope import MinimumCommitmentInputScope
    from .minimum_commitment_scope import MinimumCommitmentScope
    from .never_reset_period import NeverResetPeriod
    from .new_product_ref import NewProductRef
    from .number_config_value import NumberConfigValue
    from .o_auth_app import OAuthApp
    from .o_auth_app_id import OAuthAppId
    from .o_auth_app_with_secret import OAuthAppWithSecret
    from .o_auth_apps_response import OAuthAppsResponse
    from .o_auth_error_code import OAuthErrorCode, OAuthErrorCodeLiteral
    from .o_auth_error_response import OAuthErrorResponse
    from .onboarding_link_response import OnboardingLinkResponse
    from .onboarding_mode import OnboardingMode, OnboardingModeLiteral
    from .one_time_fee import OneTimeFee
    from .one_time_fee_structure import OneTimeFeeStructure
    from .one_time_plan_fee import OneTimePlanFee
    from .one_time_pricing import OneTimePricing
    from .online_method_config import OnlineMethodConfig
    from .online_methods_config import OnlineMethodsConfig
    from .online_payment_method_config import OnlinePaymentMethodConfig
    from .organization_id import OrganizationId
    from .package_plan_pricing import PackagePlanPricing
    from .package_pricing import PackagePricing
    from .pagination_response import PaginationResponse
    from .patch_plan_request import PatchPlanRequest
    from .payment_method_info import PaymentMethodInfo
    from .payment_method_type_enum import (
        PaymentMethodTypeEnum,
        PaymentMethodTypeEnumLiteral,
    )
    from .payment_methods_config import PaymentMethodsConfig
    from .payment_status_enum import PaymentStatusEnum, PaymentStatusEnumLiteral
    from .payment_transaction_id import PaymentTransactionId
    from .payment_type_enum import PaymentTypeEnum, PaymentTypeEnumLiteral
    from .per_unit_plan_pricing import PerUnitPlanPricing
    from .per_unit_pricing import PerUnitPricing
    from .percentage_discount import PercentageDiscount
    from .plan import Plan
    from .plan_add_on_input import PlanAddOnInput
    from .plan_event import PlanEvent
    from .plan_event_data import PlanEventData
    from .plan_id import PlanId
    from .plan_list_response import PlanListResponse
    from .plan_status_enum import PlanStatusEnum, PlanStatusEnumLiteral
    from .plan_type_enum import PlanTypeEnum, PlanTypeEnumLiteral
    from .plan_usage_pricing_model import PlanUsagePricingModel
    from .plan_version_id import PlanVersionId
    from .plan_version_list_response import PlanVersionListResponse
    from .plan_version_summary import PlanVersionSummary
    from .price_component import PriceComponent
    from .price_component_id import PriceComponentId
    from .price_component_input import PriceComponentInput
    from .price_entry import PriceEntry
    from .price_id import PriceId
    from .price_input import PriceInput
    from .pricing import Pricing
    from .product import Product
    from .product_event import ProductEvent
    from .product_event_data import ProductEventData
    from .product_family import ProductFamily
    from .product_family_create_request import ProductFamilyCreateRequest
    from .product_family_id import ProductFamilyId
    from .product_family_list_response import ProductFamilyListResponse
    from .product_fee_structure import ProductFeeStructure
    from .product_fee_type_enum import ProductFeeTypeEnum, ProductFeeTypeEnumLiteral
    from .product_id import ProductId
    from .product_list_response import ProductListResponse
    from .product_ref import ProductRef
    from .products_scope import ProductsScope
    from .property_config import PropertyConfig
    from .quote_event import QuoteEvent
    from .quote_event_data import QuoteEventData
    from .quote_id import QuoteId
    from .rate_fee import RateFee
    from .rate_fee_structure import RateFeeStructure
    from .rate_plan_fee import RatePlanFee
    from .rate_pricing import RatePricing
    from .recurring_fee import RecurringFee
    from .replace_plan_request import ReplacePlanRequest
    from .reset_period import ResetPeriod
    from .resolved_entitlement import ResolvedEntitlement
    from .resolved_entitlement_list_response import ResolvedEntitlementListResponse
    from .resolved_entitlement_value import ResolvedEntitlementValue
    from .rest_error_response import RestErrorResponse
    from .revocation_request import RevocationRequest
    from .rotated_secret import RotatedSecret
    from .select_option import SelectOption
    from .shipping_address import ShippingAddress
    from .sliding_window_reset_period import SlidingWindowResetPeriod
    from .slot_downgrade_policy_enum import (
        SlotDowngradePolicyEnum,
        SlotDowngradePolicyEnumLiteral,
    )
    from .slot_fee import SlotFee
    from .slot_fee_structure import SlotFeeStructure
    from .slot_plan_fee import SlotPlanFee
    from .slot_pricing import SlotPricing
    from .slot_upgrade_policy_enum import (
        SlotUpgradePolicyEnum,
        SlotUpgradePolicyEnumLiteral,
    )
    from .sub_line_item import SubLineItem
    from .subscription import Subscription
    from .subscription_activation_condition_enum import (
        SubscriptionActivationConditionEnum,
        SubscriptionActivationConditionEnumLiteral,
    )
    from .subscription_add_on import SubscriptionAddOn
    from .subscription_add_on_customization import SubscriptionAddOnCustomization
    from .subscription_add_on_id import SubscriptionAddOnId
    from .subscription_add_on_parameterization import SubscriptionAddOnParameterization
    from .subscription_add_on_price_override import SubscriptionAddOnPriceOverride
    from .subscription_component import SubscriptionComponent
    from .subscription_coupon import SubscriptionCoupon
    from .subscription_create_request import SubscriptionCreateRequest
    from .subscription_details import SubscriptionDetails
    from .subscription_event import SubscriptionEvent
    from .subscription_event_data import SubscriptionEventData
    from .subscription_fee import SubscriptionFee
    from .subscription_fee_billing_period_enum import (
        SubscriptionFeeBillingPeriodEnum,
        SubscriptionFeeBillingPeriodEnumLiteral,
    )
    from .subscription_id import SubscriptionId
    from .subscription_list_response import SubscriptionListResponse
    from .subscription_status_enum import (
        SubscriptionStatusEnum,
        SubscriptionStatusEnumLiteral,
    )
    from .subscription_update_request import SubscriptionUpdateRequest
    from .subscription_update_response import SubscriptionUpdateResponse
    from .subscription_update_type import (
        SubscriptionUpdateType,
        SubscriptionUpdateTypeLiteral,
    )
    from .tax_breakdown_item import TaxBreakdownItem
    from .tax_exemption_type import TaxExemptionType, TaxExemptionTypeLiteral
    from .tenant_id import TenantId
    from .term_rate import TermRate
    from .text_config_value import TextConfigValue
    from .tier_row import TierRow
    from .tiered_plan_pricing import TieredPlanPricing
    from .tiered_pricing import TieredPricing
    from .token_introspection_response import TokenIntrospectionResponse
    from .token_request import TokenRequest
    from .token_response import TokenResponse
    from .transaction import Transaction
    from .trial_config import TrialConfig
    from .unit_conversion import UnitConversion
    from .unit_conversion_rounding_enum import (
        UnitConversionRoundingEnum,
        UnitConversionRoundingEnumLiteral,
    )
    from .update_add_on_request import UpdateAddOnRequest
    from .update_coupon_request import UpdateCouponRequest
    from .update_metric_request import UpdateMetricRequest
    from .update_product_request import UpdateProductRequest
    from .usage_fee import UsageFee
    from .usage_fee_structure import UsageFeeStructure
    from .usage_model_enum import UsageModelEnum, UsageModelEnumLiteral
    from .usage_plan_fee import UsagePlanFee
    from .usage_pricing import UsagePricing
    from .usage_pricing_model import UsagePricingModel
    from .usage_response import UsageResponse
    from .volume_plan_pricing import VolumePlanPricing
    from .volume_pricing import VolumePricing

_MODULES: dict[str, str] = {
    "AddOn": "add_on",
    "AddOnEvent": "add_on_event",
    "AddOnEventData": "add_on_event_data",
    "AddOnId": "add_on_id",
    "AddOnListResponse": "add_on_list_response",
    "Address": "address",
    "AllComponentsScope": "all_components_scope",
    "AppliedCoupon": "applied_coupon",
    "AppliedCouponDetailed": "applied_coupon_detailed",
    "AppliedCouponId": "applied_coupon_id",
    "AvailableParameters": "available_parameters",
    "BankAccountId": "bank_account_id",
    "BankTransferPaymentMethodConfig": "bank_transfer_payment_method_config",
    "BatchJobChunkId": "batch_job_chunk_id",
    "BatchJobDetailResponse": "batch_job_detail_response",
    "BatchJobFailuresResponse": "batch_job_failures_response",
    "BatchJobId": "batch_job_id",
    "BatchJobItemFailureResponse": "batch_job_item_failure_response",
    "BatchJobListResponse": "batch_job_list_response",
    "BatchJobResponse": "batch_job_response",
    "BatchJobStatus": "batch_job_status",
    "BatchJobStatusLiteral": "batch_job_status",
    "BatchJobType": "batch_job_type",
    "BatchJobTypeLiteral": "batch_job_type",
    "BillableMetricId": "billable_metric_id",
    "BillingConfig": "billing_config",
    "BillingCycleResetPeriod": "billing_cycle_reset_period",
    "BillingMetricAggregateEnum": "billing_metric_aggregate_enum",
    "BillingMetricAggregateEnumLiteral": "billing_metric_aggregate_enum",
    "BillingPeriodEnum": "billing_period_enum",
    "BillingPeriodEnumLiteral": "billing_period_enum",
    "BillingType": "billing_type",
    "BillingTypeLiteral": "billing_type",
    "BillingTypeEnum": "billing_type_enum",
    "BillingTypeEnumLiteral": "billing_type_enum",
    "BooleanConfigValue": "boolean_config_value",
    "BooleanEffectiveEntitlementValue": "boolean_effective_entitlement_value",
    "BooleanEntitlementValue": "boolean_entitlement_value",
    "BooleanFeatureType": "boolean_feature_type",
    "BooleanResolvedEntitlementValue": "boolean_resolved_entitlement_value",
    "CalendarResetPeriod": "calendar_reset_period",
    "CalendarUnit": "calendar_unit",
    "CalendarUnitLiteral": "calendar_unit",
    "CancelCheckoutSessionResponse": "cancel_checkout_session_response",
    "CancelSubscriptionRequest": "cancel_subscription_request",
    "CancelSubscriptionResponse": "cancel_subscription_response",
    "CapacityFee": "capacity_fee",
    "CapacityFeeStructure": "capacity_fee_structure",
    "CapacityPlanFee": "capacity_plan_fee",
    "CapacityPricing": "capacity_pricing",
    "CapacityThreshold": "capacity_threshold",
    "CheckoutSession": "checkout_session",
    "CheckoutSessionId": "checkout_session_id",
    "CheckoutSessionStatus": "checkout_session_status",
    "CheckoutSessionStatusLiteral": "checkout_session_status",
    "CheckoutType": "checkout_type",
    "CheckoutTypeLiteral": "checkout_type",
    "ComponentOverride": "component_override",
    "ComponentParameterization": "component_parameterization",
    "ComponentParameters": "component_parameters",
    "ComponentsScope": "components_scope",
    "ConfigEffectiveEntitlementValue": "config_effective_entitlement_value",
    "ConfigEntitlementValue": "config_entitlement_value",
    "ConfigFeatureType": "config_feature_type",
    "ConfigResolvedEntitlementValue": "config_resolved_entitlement_value",
    "ConfigValue": "config_value",
    "ConfigValueType": "config_value_type",
    "ConfigValueTypeLiteral": "config_value_type",
    "ConnectedAccount": "connected_account",
    "ConnectedAccountId": "connected_account_id",
    "ConnectedAccountsResponse": "connected_accounts_response",
    "ConnectionStatus": "connection_status",
    "ConnectionStatusLiteral": "connection_status",
    "ConnectionType": "connection_type",
    "ConnectionTypeLiteral": "connection_type",
    "CountryCode": "country_code",
    "Coupon": "coupon",
    "CouponDiscount": "coupon_discount",
    "CouponEvent": "coupon_event",
    "CouponEventData": "coupon_event_data",
    "CouponFilter": "coupon_filter",
    "CouponFilterLiteral": "coupon_filter",
    "CouponId": "coupon_id",
    "CouponLineItem": "coupon_line_item",
    "CouponListResponse": "coupon_list_response",
    "CreateAddOnRequest": "create_add_on_request",
    "CreateCheckoutSessionRequest": "create_checkout_session_request",
    "CreateCheckoutSessionResponse": "create_checkout_session_response",
    "CreateConnectedAccountRequest": "create_connected_account_request",
    "CreateCouponRequest": "create_coupon_request",
    "CreateMetricRequest": "create_metric_request",
    "CreateOAuthAppRequest": "create_o_auth_app_request",
    "CreateOnboardingLinkRequest": "create_onboarding_link_request",
    "CreatePlanRequest": "create_plan_request",
    "CreateProductRequest": "create_product_request",
    "CreateSubscriptionAddOn": "create_subscription_add_on",
    "CreateSubscriptionComponents": "create_subscription_components",
    "CreditNote": "credit_note",
    "CreditNoteCustomPropertiesRequest": "credit_note_custom_properties_request",
    "CreditNoteEvent": "credit_note_event",
    "CreditNoteEventData": "credit_note_event_data",
    "CreditNoteId": "credit_note_id",
    "CreditNoteListResponse": "credit_note_list_response",
    "CreditNoteStatus": "credit_note_status",
    "CreditNoteStatusLiteral": "credit_note_status",
    "CreditType": "credit_type",
    "CreditTypeLiteral": "credit_type",
    "Currency": "currency",
    "CurrencyLiteral": "currency",
    "CustomPropertyDefinition": "custom_property_definition",
    "CustomPropertyDefinitionCreateRequest": "custom_property_definition_create_request",
    "CustomPropertyDefinitionId": "custom_property_definition_id",
    "CustomPropertyDefinitionListResponse": "custom_property_definition_list_response",
    "CustomPropertyDefinitionUpdateRequest": "custom_property_definition_update_request",
    "CustomPropertyEntityType": "custom_property_entity_type",
    "CustomPropertyEntityTypeLiteral": "custom_property_entity_type",
    "CustomPropertyType": "custom_property_type",
    "CustomPropertyTypeLiteral": "custom_property_type",
    "CustomTaxRate": "custom_tax_rate",
    "Customer": "customer",
    "CustomerCreateRequest": "customer_create_request",
    "CustomerDetails": "customer_details",
    "CustomerEvent": "customer_event",
    "CustomerEventData": "customer_event_data",
    "CustomerId": "customer_id",
    "CustomerListResponse": "customer_list_response",
    "CustomerPatchRequest": "customer_patch_request",
    "CustomerPaymentMethodId": "customer_payment_method_id",
    "CustomerPortalTokenRequest": "customer_portal_token_request",
    "CustomerPortalTokenResponse": "customer_portal_token_response",
    "CustomerType": "customer_type",
    "CustomerTypeLiteral": "customer_type",
    "CustomerUpdateRequest": "customer_update_request",
    "DoubleSegmentationMatrix": "double_segmentation_matrix",
    "EInvoicingFinding": "e_invoicing_finding",
    "EInvoicingStatus": "e_invoicing_status",
    "EInvoicingStatusLiteral": "e_invoicing_status",
    "EffectiveEntitlement": "effective_entitlement",
    "EffectiveEntitlementListResponse": "effective_entitlement_list_response",
    "EffectiveEntitlementValue": "effective_entitlement_value",
    "Entitlement": "entitlement",
    "EntitlementId": "entitlement_id",
    "EntitlementProductRef": "entitlement_product_ref",
    "EntitlementValue": "entitlement_value",
    "ErrorCode": "error_code",
    "ErrorCodeLiteral": "error_code",
    "Event": "event",
    "EventId": "event_id",
    "EventType": "event_type",
    "EventTypeLiteral": "event_type",
    "ExistingPriceRef": "existing_price_ref",
    "ExistingProductRef": "existing_product_ref",
    "ExternalPaymentMethodConfig": "external_payment_method_config",
    "ExtraComponent": "extra_component",
    "ExtraRecurringBillingTypeEnum": "extra_recurring_billing_type_enum",
    "ExtraRecurringBillingTypeEnumLiteral": "extra_recurring_billing_type_enum",
    "ExtraRecurringFeeStructure": "extra_recurring_fee_structure",
    "ExtraRecurringPlanFee": "extra_recurring_plan_fee",
    "ExtraRecurringPricing": "extra_recurring_pricing",
    "Feature": "feature",
    "FeatureId": "feature_id",
    "FeatureListResponse": "feature_list_response",
    "FeatureRef": "feature_ref",
    "FeatureStatus": "feature_status",
    "FeatureStatusLiteral": "feature_status",
    "FeatureType": "feature_type",
    "Fee": "fee",
    "FixedDiscount": "fixed_discount",
    "FixedWindowResetPeriod": "fixed_window_reset_period",
    "GetCheckoutSessionResponse": "get_checkout_session_response",
    "GroupedUsage": "grouped_usage",
    "IngestEventsRequest": "ingest_events_request",
    "IngestEventsResponse": "ingest_events_response",
    "IngestFailure": "ingest_failure",
    "IntrospectionRequest": "introspection_request",
    "Invoice": "invoice",
    "InvoiceCustomPropertiesRequest": "invoice_custom_properties_request",
    "InvoiceDocumentsEvent": "invoice_documents_event",
    "InvoiceDocumentsEventData": "invoice_documents_event_data",
    "InvoiceEvent": "invoice_event",
    "InvoiceEventData": "invoice_event_data",
    "InvoiceId": "invoice_id",
    "InvoiceLineItem": "invoice_line_item",
    "InvoiceListResponse": "invoice_list_response",
    "InvoicePaymentStatus": "invoice_payment_status",
    "InvoicePaymentStatusLiteral": "invoice_payment_status",
    "InvoiceStatus": "invoice_status",
    "InvoiceStatusLiteral": "invoice_status",
    "InvoiceType": "invoice_type",
    "InvoiceTypeLiteral": "invoice_type",
    "InvoicingEntityId": "invoicing_entity_id",
    "JsonConfigValue": "json_config_value",
    "LinkedSegmentationMatrix": "linked_segmentation_matrix",
    "ListCheckoutSessionsResponse": "list_checkout_sessions_response",
    "MatrixDimension": "matrix_dimension",
    "MatrixPlanPricing": "matrix_plan_pricing",
    "MatrixPricing": "matrix_pricing",
    "MatrixRow": "matrix_row",
    "MeteredEffectiveEntitlementValue": "metered_effective_entitlement_value",
    "MeteredEntitlementSpec": "metered_entitlement_spec",
    "MeteredEntitlementUsage": "metered_entitlement_usage",
    "MeteredEntitlementValue": "metered_entitlement_value",
    "MeteredFeatureType": "metered_feature_type",
    "MeteredResolvedEntitlementValue": "metered_resolved_entitlement_value",
    "Metric": "metric",
    "MetricDimension": "metric_dimension",
    "MetricEvent": "metric_event",
    "MetricEventData": "metric_event_data",
    "MetricFilter": "metric_filter",
    "MetricFilterOperator": "metric_filter_operator",
    "MetricFilterOperatorLiteral": "metric_filter_operator",
    "MetricListResponse": "metric_list_response",
    "MetricSegmentationMatrix": "metric_segmentation_matrix",
    "MetricSummary": "metric_summary",
    "MetricUsage": "metric_usage",
    "MinimumCommitment": "minimum_commitment",
    "MinimumCommitmentInput": "minimum_commitment_input",
    "MinimumCommitmentInputScope": "minimum_commitment_input_scope",
    "MinimumCommitmentScope": "minimum_commitment_scope",
    "NeverResetPeriod": "never_reset_period",
    "NewProductRef": "new_product_ref",
    "NumberConfigValue": "number_config_value",
    "OAuthApp": "o_auth_app",
    "OAuthAppId": "o_auth_app_id",
    "OAuthAppWithSecret": "o_auth_app_with_secret",
    "OAuthAppsResponse": "o_auth_apps_response",
    "OAuthErrorCode": "o_auth_error_code",
    "OAuthErrorCodeLiteral": "o_auth_error_code",
    "OAuthErrorResponse": "o_auth_error_response",
    "OnboardingLinkResponse": "onboarding_link_response",
    "OnboardingMode": "onboarding_mode",
    "OnboardingModeLiteral": "onboarding_mode",
    "OneTimeFee": "one_time_fee",
    "OneTimeFeeStructure": "one_time_fee_structure",
    "OneTimePlanFee": "one_time_plan_fee",
    "OneTimePricing": "one_time_pricing",
    "OnlineMethodConfig": "online_method_config",
    "OnlineMethodsConfig": "online_methods_config",
    "OnlinePaymentMethodConfig": "online_payment_method_config",
    "OrganizationId": "organization_id",
    "PackagePlanPricing": "package_plan_pricing",
    "PackagePricing": "package_pricing",
    "PaginationResponse": "pagination_response",
    "PatchPlanRequest": "patch_plan_request",
    "PaymentMethodInfo": "payment_method_info",
    "PaymentMethodTypeEnum": "payment_method_type_enum",
    "PaymentMethodTypeEnumLiteral": "payment_method_type_enum",
    "PaymentMethodsConfig": "payment_methods_config",
    "PaymentStatusEnum": "payment_status_enum",
    "PaymentStatusEnumLiteral": "payment_status_enum",
    "PaymentTransactionId": "payment_transaction_id",
    "PaymentTypeEnum": "payment_type_enum",
    "PaymentTypeEnumLiteral": "payment_type_enum",
    "PerUnitPlanPricing": "per_unit_plan_pricing",
    "PerUnitPricing": "per_unit_pricing",
    "PercentageDiscount": "percentage_discount",
    "Plan": "plan",
    "PlanAddOnInput": "plan_add_on_input",
    "PlanEvent": "plan_event",
    "PlanEventData": "plan_event_data",
    "PlanId": "plan_id",
    "PlanListResponse": "plan_list_response",
    "PlanStatusEnum": "plan_status_enum",
    "PlanStatusEnumLiteral": "plan_status_enum",
    "PlanTypeEnum": "plan_type_enum",
    "PlanTypeEnumLiteral": "plan_type_enum",
    "PlanUsagePricingModel": "plan_usage_pricing_model",
    "PlanVersionId": "plan_version_id",
    "PlanVersionListResponse": "plan_version_list_response",
    "PlanVersionSummary": "plan_version_summary",
    "PriceComponent": "price_component",
    "PriceComponentId": "price_component_id",
    "PriceComponentInput": "price_component_input",
    "PriceEntry": "price_entry",
    "PriceId": "price_id",
    "PriceInput": "price_input",
    "Pricing": "pricing",
    "Product": "product",
    "ProductEvent": "product_event",
    "ProductEventData": "product_event_data",
    "ProductFamily": "product_family",
    "ProductFamilyCreateRequest": "product_family_create_request",
    "ProductFamilyId": "product_family_id",
    "ProductFamilyListResponse": "product_family_list_response",
    "ProductFeeStructure": "product_fee_structure",
    "ProductFeeTypeEnum": "product_fee_type_enum",
    "ProductFeeTypeEnumLiteral": "product_fee_type_enum",
    "ProductId": "product_id",
    "ProductListResponse": "product_list_response",
    "ProductRef": "product_ref",
    "ProductsScope": "products_scope",
    "PropertyConfig": "property_config",
    "QuoteEvent": "quote_event",
    "QuoteEventData": "quote_event_data",
    "QuoteId": "quote_id",
    "RateFee": "rate_fee",
    "RateFeeStructure": "rate_fee_structure",
    "RatePlanFee": "rate_plan_fee",
    "RatePricing": "rate_pricing",
    "RecurringFee": "recurring_fee",
    "ReplacePlanRequest": "replace_plan_request",
    "ResetPeriod": "reset_period",
    "ResolvedEntitlement": "resolved_entitlement",
    "ResolvedEntitlementListResponse": "resolved_entitlement_list_response",
    "ResolvedEntitlementValue": "resolved_entitlement_value",
    "RestErrorResponse": "rest_error_response",
    "RevocationRequest": "revocation_request",
    "RotatedSecret": "rotated_secret",
    "SelectOption": "select_option",
    "ShippingAddress": "shipping_address",
    "SlidingWindowResetPeriod": "sliding_window_reset_period",
    "SlotDowngradePolicyEnum": "slot_downgrade_policy_enum",
    "SlotDowngradePolicyEnumLiteral": "slot_downgrade_policy_enum",
    "SlotFee": "slot_fee",
    "SlotFeeStructure": "slot_fee_structure",
    "SlotPlanFee": "slot_plan_fee",
    "SlotPricing": "slot_pricing",
    "SlotUpgradePolicyEnum": "slot_upgrade_policy_enum",
    "SlotUpgradePolicyEnumLiteral": "slot_upgrade_policy_enum",
    "SubLineItem": "sub_line_item",
    "Subscription": "subscription",
    "SubscriptionActivationConditionEnum": "subscription_activation_condition_enum",
    "SubscriptionActivationConditionEnumLiteral": "subscription_activation_condition_enum",
    "SubscriptionAddOn": "subscription_add_on",
    "SubscriptionAddOnCustomization": "subscription_add_on_customization",
    "SubscriptionAddOnId": "subscription_add_on_id",
    "SubscriptionAddOnParameterization": "subscription_add_on_parameterization",
    "SubscriptionAddOnPriceOverride": "subscription_add_on_price_override",
    "SubscriptionComponent": "subscription_component",
    "SubscriptionCoupon": "subscription_coupon",
    "SubscriptionCreateRequest": "subscription_create_request",
    "SubscriptionDetails": "subscription_details",
    "SubscriptionEvent": "subscription_event",
    "SubscriptionEventData": "subscription_event_data",
    "SubscriptionFee": "subscription_fee",
    "SubscriptionFeeBillingPeriodEnum": "subscription_fee_billing_period_enum",
    "SubscriptionFeeBillingPeriodEnumLiteral": "subscription_fee_billing_period_enum",
    "SubscriptionId": "subscription_id",
    "SubscriptionListResponse": "subscription_list_response",
    "SubscriptionStatusEnum": "subscription_status_enum",
    "SubscriptionStatusEnumLiteral": "subscription_status_enum",
    "SubscriptionUpdateRequest": "subscription_update_request",
    "SubscriptionUpdateResponse": "subscription_update_response",
    "SubscriptionUpdateType": "subscription_update_type",
    "SubscriptionUpdateTypeLiteral": "subscription_update_type",
    "TaxBreakdownItem": "tax_breakdown_item",
    "TaxExemptionType": "tax_exemption_type",
    "TaxExemptionTypeLiteral": "tax_exemption_type",
    "TenantId": "tenant_id",
    "TermRate": "term_rate",
    "TextConfigValue": "text_config_value",
    "TierRow": "tier_row",
    "TieredPlanPricing": "tiered_plan_pricing",
    "TieredPricing": "tiered_pricing",
    "TokenIntrospectionResponse": "token_introspection_response",
    "TokenRequest": "token_request",
    "TokenResponse": "token_response",
    "Transaction": "transaction",
    "TrialConfig": "trial_config",
    "UnitConversion": "unit_conversion",
    "UnitConversionRoundingEnum": "unit_conversion_rounding_enum",
    "UnitConversionRoundingEnumLiteral": "unit_conversion_rounding_enum",
    "UpdateAddOnRequest": "update_add_on_request",
    "UpdateCouponRequest": "update_coupon_request",
    "UpdateMetricRequest": "update_metric_request",
    "UpdateProductRequest": "update_product_request",
    "UsageFee": "usage_fee",
    "UsageFeeStructure": "usage_fee_structure",
    "UsageModelEnum": "usage_model_enum",
    "UsageModelEnumLiteral": "usage_model_enum",
    "UsagePlanFee": "usage_plan_fee",
    "UsagePricing": "usage_pricing",
    "UsagePricingModel": "usage_pricing_model",
    "UsageResponse": "usage_response",
    "VolumePlanPricing": "volume_plan_pricing",
    "VolumePricing": "volume_pricing",
}


def __getattr__(name: str) -> t.Any:
    module = _MODULES.get(name)
    if module is None:
        raise AttributeError(f"module {__name__!r} has no attribute {name!r}")
    value = getattr(importlib.import_module(f".{module}", __name__), name)
    globals()[name] = value
    return value


def __dir__() -> list[str]:
    return sorted({*globals(), *_MODULES})


__all__ = [
    "UNSET",
    "Unset",
    "UnknownVariant",
    "AddOn",
    "AddOnEvent",
    "AddOnEventData",
    "AddOnId",
    "AddOnListResponse",
    "Address",
    "AllComponentsScope",
    "AppliedCoupon",
    "AppliedCouponDetailed",
    "AppliedCouponId",
    "AvailableParameters",
    "BankAccountId",
    "BankTransferPaymentMethodConfig",
    "BatchJobChunkId",
    "BatchJobDetailResponse",
    "BatchJobFailuresResponse",
    "BatchJobId",
    "BatchJobItemFailureResponse",
    "BatchJobListResponse",
    "BatchJobResponse",
    "BatchJobStatus",
    "BatchJobStatusLiteral",
    "BatchJobType",
    "BatchJobTypeLiteral",
    "BillableMetricId",
    "BillingConfig",
    "BillingCycleResetPeriod",
    "BillingMetricAggregateEnum",
    "BillingMetricAggregateEnumLiteral",
    "BillingPeriodEnum",
    "BillingPeriodEnumLiteral",
    "BillingType",
    "BillingTypeLiteral",
    "BillingTypeEnum",
    "BillingTypeEnumLiteral",
    "BooleanConfigValue",
    "BooleanEffectiveEntitlementValue",
    "BooleanEntitlementValue",
    "BooleanFeatureType",
    "BooleanResolvedEntitlementValue",
    "CalendarResetPeriod",
    "CalendarUnit",
    "CalendarUnitLiteral",
    "CancelCheckoutSessionResponse",
    "CancelSubscriptionRequest",
    "CancelSubscriptionResponse",
    "CapacityFee",
    "CapacityFeeStructure",
    "CapacityPlanFee",
    "CapacityPricing",
    "CapacityThreshold",
    "CheckoutSession",
    "CheckoutSessionId",
    "CheckoutSessionStatus",
    "CheckoutSessionStatusLiteral",
    "CheckoutType",
    "CheckoutTypeLiteral",
    "ComponentOverride",
    "ComponentParameterization",
    "ComponentParameters",
    "ComponentsScope",
    "ConfigEffectiveEntitlementValue",
    "ConfigEntitlementValue",
    "ConfigFeatureType",
    "ConfigResolvedEntitlementValue",
    "ConfigValue",
    "ConfigValueType",
    "ConfigValueTypeLiteral",
    "ConnectedAccount",
    "ConnectedAccountId",
    "ConnectedAccountsResponse",
    "ConnectionStatus",
    "ConnectionStatusLiteral",
    "ConnectionType",
    "ConnectionTypeLiteral",
    "CountryCode",
    "Coupon",
    "CouponDiscount",
    "CouponEvent",
    "CouponEventData",
    "CouponFilter",
    "CouponFilterLiteral",
    "CouponId",
    "CouponLineItem",
    "CouponListResponse",
    "CreateAddOnRequest",
    "CreateCheckoutSessionRequest",
    "CreateCheckoutSessionResponse",
    "CreateConnectedAccountRequest",
    "CreateCouponRequest",
    "CreateMetricRequest",
    "CreateOAuthAppRequest",
    "CreateOnboardingLinkRequest",
    "CreatePlanRequest",
    "CreateProductRequest",
    "CreateSubscriptionAddOn",
    "CreateSubscriptionComponents",
    "CreditNote",
    "CreditNoteCustomPropertiesRequest",
    "CreditNoteEvent",
    "CreditNoteEventData",
    "CreditNoteId",
    "CreditNoteListResponse",
    "CreditNoteStatus",
    "CreditNoteStatusLiteral",
    "CreditType",
    "CreditTypeLiteral",
    "Currency",
    "CurrencyLiteral",
    "CustomPropertyDefinition",
    "CustomPropertyDefinitionCreateRequest",
    "CustomPropertyDefinitionId",
    "CustomPropertyDefinitionListResponse",
    "CustomPropertyDefinitionUpdateRequest",
    "CustomPropertyEntityType",
    "CustomPropertyEntityTypeLiteral",
    "CustomPropertyType",
    "CustomPropertyTypeLiteral",
    "CustomTaxRate",
    "Customer",
    "CustomerCreateRequest",
    "CustomerDetails",
    "CustomerEvent",
    "CustomerEventData",
    "CustomerId",
    "CustomerListResponse",
    "CustomerPatchRequest",
    "CustomerPaymentMethodId",
    "CustomerPortalTokenRequest",
    "CustomerPortalTokenResponse",
    "CustomerType",
    "CustomerTypeLiteral",
    "CustomerUpdateRequest",
    "DoubleSegmentationMatrix",
    "EInvoicingFinding",
    "EInvoicingStatus",
    "EInvoicingStatusLiteral",
    "EffectiveEntitlement",
    "EffectiveEntitlementListResponse",
    "EffectiveEntitlementValue",
    "Entitlement",
    "EntitlementId",
    "EntitlementProductRef",
    "EntitlementValue",
    "ErrorCode",
    "ErrorCodeLiteral",
    "Event",
    "EventId",
    "EventType",
    "EventTypeLiteral",
    "ExistingPriceRef",
    "ExistingProductRef",
    "ExternalPaymentMethodConfig",
    "ExtraComponent",
    "ExtraRecurringBillingTypeEnum",
    "ExtraRecurringBillingTypeEnumLiteral",
    "ExtraRecurringFeeStructure",
    "ExtraRecurringPlanFee",
    "ExtraRecurringPricing",
    "Feature",
    "FeatureId",
    "FeatureListResponse",
    "FeatureRef",
    "FeatureStatus",
    "FeatureStatusLiteral",
    "FeatureType",
    "Fee",
    "FixedDiscount",
    "FixedWindowResetPeriod",
    "GetCheckoutSessionResponse",
    "GroupedUsage",
    "IngestEventsRequest",
    "IngestEventsResponse",
    "IngestFailure",
    "IntrospectionRequest",
    "Invoice",
    "InvoiceCustomPropertiesRequest",
    "InvoiceDocumentsEvent",
    "InvoiceDocumentsEventData",
    "InvoiceEvent",
    "InvoiceEventData",
    "InvoiceId",
    "InvoiceLineItem",
    "InvoiceListResponse",
    "InvoicePaymentStatus",
    "InvoicePaymentStatusLiteral",
    "InvoiceStatus",
    "InvoiceStatusLiteral",
    "InvoiceType",
    "InvoiceTypeLiteral",
    "InvoicingEntityId",
    "JsonConfigValue",
    "LinkedSegmentationMatrix",
    "ListCheckoutSessionsResponse",
    "MatrixDimension",
    "MatrixPlanPricing",
    "MatrixPricing",
    "MatrixRow",
    "MeteredEffectiveEntitlementValue",
    "MeteredEntitlementSpec",
    "MeteredEntitlementUsage",
    "MeteredEntitlementValue",
    "MeteredFeatureType",
    "MeteredResolvedEntitlementValue",
    "Metric",
    "MetricDimension",
    "MetricEvent",
    "MetricEventData",
    "MetricFilter",
    "MetricFilterOperator",
    "MetricFilterOperatorLiteral",
    "MetricListResponse",
    "MetricSegmentationMatrix",
    "MetricSummary",
    "MetricUsage",
    "MinimumCommitment",
    "MinimumCommitmentInput",
    "MinimumCommitmentInputScope",
    "MinimumCommitmentScope",
    "NeverResetPeriod",
    "NewProductRef",
    "NumberConfigValue",
    "OAuthApp",
    "OAuthAppId",
    "OAuthAppWithSecret",
    "OAuthAppsResponse",
    "OAuthErrorCode",
    "OAuthErrorCodeLiteral",
    "OAuthErrorResponse",
    "OnboardingLinkResponse",
    "OnboardingMode",
    "OnboardingModeLiteral",
    "OneTimeFee",
    "OneTimeFeeStructure",
    "OneTimePlanFee",
    "OneTimePricing",
    "OnlineMethodConfig",
    "OnlineMethodsConfig",
    "OnlinePaymentMethodConfig",
    "OrganizationId",
    "PackagePlanPricing",
    "PackagePricing",
    "PaginationResponse",
    "PatchPlanRequest",
    "PaymentMethodInfo",
    "PaymentMethodTypeEnum",
    "PaymentMethodTypeEnumLiteral",
    "PaymentMethodsConfig",
    "PaymentStatusEnum",
    "PaymentStatusEnumLiteral",
    "PaymentTransactionId",
    "PaymentTypeEnum",
    "PaymentTypeEnumLiteral",
    "PerUnitPlanPricing",
    "PerUnitPricing",
    "PercentageDiscount",
    "Plan",
    "PlanAddOnInput",
    "PlanEvent",
    "PlanEventData",
    "PlanId",
    "PlanListResponse",
    "PlanStatusEnum",
    "PlanStatusEnumLiteral",
    "PlanTypeEnum",
    "PlanTypeEnumLiteral",
    "PlanUsagePricingModel",
    "PlanVersionId",
    "PlanVersionListResponse",
    "PlanVersionSummary",
    "PriceComponent",
    "PriceComponentId",
    "PriceComponentInput",
    "PriceEntry",
    "PriceId",
    "PriceInput",
    "Pricing",
    "Product",
    "ProductEvent",
    "ProductEventData",
    "ProductFamily",
    "ProductFamilyCreateRequest",
    "ProductFamilyId",
    "ProductFamilyListResponse",
    "ProductFeeStructure",
    "ProductFeeTypeEnum",
    "ProductFeeTypeEnumLiteral",
    "ProductId",
    "ProductListResponse",
    "ProductRef",
    "ProductsScope",
    "PropertyConfig",
    "QuoteEvent",
    "QuoteEventData",
    "QuoteId",
    "RateFee",
    "RateFeeStructure",
    "RatePlanFee",
    "RatePricing",
    "RecurringFee",
    "ReplacePlanRequest",
    "ResetPeriod",
    "ResolvedEntitlement",
    "ResolvedEntitlementListResponse",
    "ResolvedEntitlementValue",
    "RestErrorResponse",
    "RevocationRequest",
    "RotatedSecret",
    "SelectOption",
    "ShippingAddress",
    "SlidingWindowResetPeriod",
    "SlotDowngradePolicyEnum",
    "SlotDowngradePolicyEnumLiteral",
    "SlotFee",
    "SlotFeeStructure",
    "SlotPlanFee",
    "SlotPricing",
    "SlotUpgradePolicyEnum",
    "SlotUpgradePolicyEnumLiteral",
    "SubLineItem",
    "Subscription",
    "SubscriptionActivationConditionEnum",
    "SubscriptionActivationConditionEnumLiteral",
    "SubscriptionAddOn",
    "SubscriptionAddOnCustomization",
    "SubscriptionAddOnId",
    "SubscriptionAddOnParameterization",
    "SubscriptionAddOnPriceOverride",
    "SubscriptionComponent",
    "SubscriptionCoupon",
    "SubscriptionCreateRequest",
    "SubscriptionDetails",
    "SubscriptionEvent",
    "SubscriptionEventData",
    "SubscriptionFee",
    "SubscriptionFeeBillingPeriodEnum",
    "SubscriptionFeeBillingPeriodEnumLiteral",
    "SubscriptionId",
    "SubscriptionListResponse",
    "SubscriptionStatusEnum",
    "SubscriptionStatusEnumLiteral",
    "SubscriptionUpdateRequest",
    "SubscriptionUpdateResponse",
    "SubscriptionUpdateType",
    "SubscriptionUpdateTypeLiteral",
    "TaxBreakdownItem",
    "TaxExemptionType",
    "TaxExemptionTypeLiteral",
    "TenantId",
    "TermRate",
    "TextConfigValue",
    "TierRow",
    "TieredPlanPricing",
    "TieredPricing",
    "TokenIntrospectionResponse",
    "TokenRequest",
    "TokenResponse",
    "Transaction",
    "TrialConfig",
    "UnitConversion",
    "UnitConversionRoundingEnum",
    "UnitConversionRoundingEnumLiteral",
    "UpdateAddOnRequest",
    "UpdateCouponRequest",
    "UpdateMetricRequest",
    "UpdateProductRequest",
    "UsageFee",
    "UsageFeeStructure",
    "UsageModelEnum",
    "UsageModelEnumLiteral",
    "UsagePlanFee",
    "UsagePricing",
    "UsagePricingModel",
    "UsageResponse",
    "VolumePlanPricing",
    "VolumePricing",
]
