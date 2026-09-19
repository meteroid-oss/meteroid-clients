# this file is @generated
"""Models for the Meteroid API."""

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
from .batch_job_status import BatchJobStatus
from .batch_job_type import BatchJobType
from .billable_metric_id import BillableMetricId
from .billing_config import BillingConfig
from .billing_cycle_reset_period import BillingCycleResetPeriod
from .billing_metric_aggregate_enum import BillingMetricAggregateEnum
from .billing_period_enum import BillingPeriodEnum
from .billing_type import BillingType
from .billing_type_enum import BillingTypeEnum
from .boolean_config_value import BooleanConfigValue
from .boolean_effective_entitlement_value import BooleanEffectiveEntitlementValue
from .boolean_entitlement_value import BooleanEntitlementValue
from .boolean_feature_type import BooleanFeatureType
from .boolean_resolved_entitlement_value import BooleanResolvedEntitlementValue
from .calendar_reset_period import CalendarResetPeriod
from .calendar_unit import CalendarUnit
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
from .checkout_session_status import CheckoutSessionStatus
from .checkout_type import CheckoutType
from .component_override import ComponentOverride
from .component_parameterization import ComponentParameterization
from .component_parameters import ComponentParameters
from .components_scope import ComponentsScope
from .config_effective_entitlement_value import ConfigEffectiveEntitlementValue
from .config_entitlement_value import ConfigEntitlementValue
from .config_feature_type import ConfigFeatureType
from .config_resolved_entitlement_value import ConfigResolvedEntitlementValue
from .config_value import ConfigValue
from .config_value_type import ConfigValueType
from .connected_account import ConnectedAccount
from .connected_account_id import ConnectedAccountId
from .connected_accounts_response import ConnectedAccountsResponse
from .connection_status import ConnectionStatus
from .connection_type import ConnectionType
from .country_code import CountryCode
from .coupon import Coupon
from .coupon_discount import CouponDiscount
from .coupon_event import CouponEvent
from .coupon_event_data import CouponEventData
from .coupon_filter import CouponFilter
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
from .credit_note_status import CreditNoteStatus
from .credit_type import CreditType
from .currency import Currency
from .custom_property_definition import CustomPropertyDefinition
from .custom_property_definition_create_request import (
    CustomPropertyDefinitionCreateRequest,
)
from .custom_property_definition_id import CustomPropertyDefinitionId
from .custom_property_definition_list_response import CustomPropertyDefinitionListResponse
from .custom_property_definition_update_request import (
    CustomPropertyDefinitionUpdateRequest,
)
from .custom_property_entity_type import CustomPropertyEntityType
from .custom_property_type import CustomPropertyType
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
from .customer_update_request import CustomerUpdateRequest
from .double_segmentation_matrix import DoubleSegmentationMatrix
from .effective_entitlement import EffectiveEntitlement
from .effective_entitlement_list_response import EffectiveEntitlementListResponse
from .effective_entitlement_value import EffectiveEntitlementValue
from .entitlement import Entitlement
from .entitlement_id import EntitlementId
from .entitlement_product_ref import EntitlementProductRef
from .entitlement_value import EntitlementValue
from .error_code import ErrorCode
from .event import Event
from .event_id import EventId
from .event_type import EventType
from .existing_price_ref import ExistingPriceRef
from .existing_product_ref import ExistingProductRef
from .external_payment_method_config import ExternalPaymentMethodConfig
from .extra_component import ExtraComponent
from .extra_recurring_billing_type_enum import ExtraRecurringBillingTypeEnum
from .extra_recurring_fee_structure import ExtraRecurringFeeStructure
from .extra_recurring_plan_fee import ExtraRecurringPlanFee
from .extra_recurring_pricing import ExtraRecurringPricing
from .feature import Feature
from .feature_id import FeatureId
from .feature_list_response import FeatureListResponse
from .feature_ref import FeatureRef
from .feature_status import FeatureStatus
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
from .invoice_event import InvoiceEvent
from .invoice_event_data import InvoiceEventData
from .invoice_id import InvoiceId
from .invoice_line_item import InvoiceLineItem
from .invoice_list_response import InvoiceListResponse
from .invoice_payment_status import InvoicePaymentStatus
from .invoice_status import InvoiceStatus
from .invoice_type import InvoiceType
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
from .metric_filter_operator import MetricFilterOperator
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
from .o_auth_error_code import OAuthErrorCode
from .o_auth_error_response import OAuthErrorResponse
from .onboarding_link_response import OnboardingLinkResponse
from .onboarding_mode import OnboardingMode
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
from .payment_method_type_enum import PaymentMethodTypeEnum
from .payment_methods_config import PaymentMethodsConfig
from .payment_status_enum import PaymentStatusEnum
from .payment_transaction_id import PaymentTransactionId
from .payment_type_enum import PaymentTypeEnum
from .per_unit_plan_pricing import PerUnitPlanPricing
from .per_unit_pricing import PerUnitPricing
from .percentage_discount import PercentageDiscount
from .plan import Plan
from .plan_add_on_input import PlanAddOnInput
from .plan_event import PlanEvent
from .plan_event_data import PlanEventData
from .plan_id import PlanId
from .plan_list_response import PlanListResponse
from .plan_status_enum import PlanStatusEnum
from .plan_type_enum import PlanTypeEnum
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
from .product_fee_type_enum import ProductFeeTypeEnum
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
from .slot_downgrade_policy_enum import SlotDowngradePolicyEnum
from .slot_fee import SlotFee
from .slot_fee_structure import SlotFeeStructure
from .slot_plan_fee import SlotPlanFee
from .slot_pricing import SlotPricing
from .slot_upgrade_policy_enum import SlotUpgradePolicyEnum
from .sub_line_item import SubLineItem
from .subscription import Subscription
from .subscription_activation_condition_enum import SubscriptionActivationConditionEnum
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
from .subscription_fee_billing_period_enum import SubscriptionFeeBillingPeriodEnum
from .subscription_id import SubscriptionId
from .subscription_list_response import SubscriptionListResponse
from .subscription_status_enum import SubscriptionStatusEnum
from .subscription_update_request import SubscriptionUpdateRequest
from .subscription_update_response import SubscriptionUpdateResponse
from .subscription_update_type import SubscriptionUpdateType
from .tax_breakdown_item import TaxBreakdownItem
from .tax_exemption_type import TaxExemptionType
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
from .unit_conversion_rounding_enum import UnitConversionRoundingEnum
from .update_add_on_request import UpdateAddOnRequest
from .update_coupon_request import UpdateCouponRequest
from .update_metric_request import UpdateMetricRequest
from .update_product_request import UpdateProductRequest
from .usage_fee import UsageFee
from .usage_fee_structure import UsageFeeStructure
from .usage_model_enum import UsageModelEnum
from .usage_plan_fee import UsagePlanFee
from .usage_pricing import UsagePricing
from .usage_pricing_model import UsagePricingModel
from .usage_response import UsageResponse
from .volume_plan_pricing import VolumePlanPricing
from .volume_pricing import VolumePricing

__all__ = [
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
    "BatchJobType",
    "BillableMetricId",
    "BillingConfig",
    "BillingCycleResetPeriod",
    "BillingMetricAggregateEnum",
    "BillingPeriodEnum",
    "BillingType",
    "BillingTypeEnum",
    "BooleanConfigValue",
    "BooleanEffectiveEntitlementValue",
    "BooleanEntitlementValue",
    "BooleanFeatureType",
    "BooleanResolvedEntitlementValue",
    "CalendarResetPeriod",
    "CalendarUnit",
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
    "CheckoutType",
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
    "ConnectedAccount",
    "ConnectedAccountId",
    "ConnectedAccountsResponse",
    "ConnectionStatus",
    "ConnectionType",
    "CountryCode",
    "Coupon",
    "CouponDiscount",
    "CouponEvent",
    "CouponEventData",
    "CouponFilter",
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
    "CreditType",
    "Currency",
    "CustomPropertyDefinition",
    "CustomPropertyDefinitionCreateRequest",
    "CustomPropertyDefinitionId",
    "CustomPropertyDefinitionListResponse",
    "CustomPropertyDefinitionUpdateRequest",
    "CustomPropertyEntityType",
    "CustomPropertyType",
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
    "CustomerUpdateRequest",
    "DoubleSegmentationMatrix",
    "EffectiveEntitlement",
    "EffectiveEntitlementListResponse",
    "EffectiveEntitlementValue",
    "Entitlement",
    "EntitlementId",
    "EntitlementProductRef",
    "EntitlementValue",
    "ErrorCode",
    "Event",
    "EventId",
    "EventType",
    "ExistingPriceRef",
    "ExistingProductRef",
    "ExternalPaymentMethodConfig",
    "ExtraComponent",
    "ExtraRecurringBillingTypeEnum",
    "ExtraRecurringFeeStructure",
    "ExtraRecurringPlanFee",
    "ExtraRecurringPricing",
    "Feature",
    "FeatureId",
    "FeatureListResponse",
    "FeatureRef",
    "FeatureStatus",
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
    "InvoiceEvent",
    "InvoiceEventData",
    "InvoiceId",
    "InvoiceLineItem",
    "InvoiceListResponse",
    "InvoicePaymentStatus",
    "InvoiceStatus",
    "InvoiceType",
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
    "OAuthErrorResponse",
    "OnboardingLinkResponse",
    "OnboardingMode",
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
    "PaymentMethodsConfig",
    "PaymentStatusEnum",
    "PaymentTransactionId",
    "PaymentTypeEnum",
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
    "PlanTypeEnum",
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
    "SlotFee",
    "SlotFeeStructure",
    "SlotPlanFee",
    "SlotPricing",
    "SlotUpgradePolicyEnum",
    "SubLineItem",
    "Subscription",
    "SubscriptionActivationConditionEnum",
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
    "SubscriptionId",
    "SubscriptionListResponse",
    "SubscriptionStatusEnum",
    "SubscriptionUpdateRequest",
    "SubscriptionUpdateResponse",
    "SubscriptionUpdateType",
    "TaxBreakdownItem",
    "TaxExemptionType",
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
    "UpdateAddOnRequest",
    "UpdateCouponRequest",
    "UpdateMetricRequest",
    "UpdateProductRequest",
    "UsageFee",
    "UsageFeeStructure",
    "UsageModelEnum",
    "UsagePlanFee",
    "UsagePricing",
    "UsagePricingModel",
    "UsageResponse",
    "VolumePlanPricing",
    "VolumePricing",
]
