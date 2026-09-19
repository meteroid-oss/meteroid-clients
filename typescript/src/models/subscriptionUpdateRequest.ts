// this file is @generated
import {
  type PaymentMethodsConfig,
  PaymentMethodsConfigSerializer,
} from "./paymentMethodsConfig";

export interface SubscriptionUpdateRequest {
  /** If false, invoices will stay in Draft until manually reviewed and finalized. */
  autoAdvanceInvoices?: boolean | null;

  /** Automatically try to charge the customer's configured payment method on finalize. */
  chargeAutomatically?: boolean | null;

  /**
   * Partial update of custom property values (merge; send a key with `null` to remove it).
   * Validated against the tenant's `SUBSCRIPTION` property definitions. Omit to leave unchanged.
   */
  customProperties?: any;

  /** Default memo for invoices */
  invoiceMemo?: string | null;

  /** Payment terms in days (0 = due on issue) */
  netTerms?: number | null;

  paymentMethodsConfig?: PaymentMethodsConfig | null;

  /** Purchase order number */
  purchaseOrder?: string | null;
}

export const SubscriptionUpdateRequestSerializer = {
  _fromJsonObject(object: any): SubscriptionUpdateRequest {
    return {
      autoAdvanceInvoices: object["auto_advance_invoices"],
      chargeAutomatically: object["charge_automatically"],
      customProperties: object["custom_properties"],
      invoiceMemo: object["invoice_memo"],
      netTerms: object["net_terms"],
      paymentMethodsConfig:
        object["payment_methods_config"] != null
          ? PaymentMethodsConfigSerializer._fromJsonObject(
              object["payment_methods_config"]
            )
          : undefined,
      purchaseOrder: object["purchase_order"],
    };
  },

  _toJsonObject(self: SubscriptionUpdateRequest): any {
    return {
      auto_advance_invoices: self.autoAdvanceInvoices,
      charge_automatically: self.chargeAutomatically,
      custom_properties: self.customProperties,
      invoice_memo: self.invoiceMemo,
      net_terms: self.netTerms,
      payment_methods_config:
        self.paymentMethodsConfig != null
          ? PaymentMethodsConfigSerializer._toJsonObject(self.paymentMethodsConfig)
          : undefined,
      purchase_order: self.purchaseOrder,
    };
  },
};
