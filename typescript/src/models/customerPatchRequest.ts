// this file is @generated
import { type Address, AddressSerializer } from "./address";
import { type Currency, CurrencySerializer } from "./currency";
import { type CustomTaxRate, CustomTaxRateSerializer } from "./customTaxRate";
import { type InvoicingEntityId, InvoicingEntityIdSerializer } from "./invoicingEntityId";
import { type ShippingAddress, ShippingAddressSerializer } from "./shippingAddress";

export interface CustomerPatchRequest {
  alias?: string | null;

  billingAddress?: Address | null;

  billingEmail?: string | null;

  currency?: Currency | null;

  /**
   * Partial update of custom property values (merge; send a key with `null` to remove it).
   * Omit to leave unchanged.
   */
  customProperties?: any;

  customTaxes?: CustomTaxRate[] | null;

  /** Free-text legal exemption mention surfaced on exempt invoices. */
  exemptionReason?: string | null;

  invoicingEmails?: string[] | null;

  invoicingEntityId?: InvoicingEntityId | null;

  /**
   * Preferred document language (e.g. `en-US`, `fr-FR`); overrides the invoicing entity default.
   * Omit to leave unchanged, send `""` to reset to the invoicing entity default.
   * Unsupported languages fall back to `en-US` when rendering.
   */
  invoicingLanguage?: string | null;

  isTaxExempt?: boolean | null;

  name?: string | null;

  phone?: string | null;

  shippingAddress?: ShippingAddress | null;

  vatNumber?: string | null;
}

export const CustomerPatchRequestSerializer = {
  _fromJsonObject(object: any): CustomerPatchRequest {
    return {
      alias: object["alias"],
      billingAddress:
        object["billing_address"] != null
          ? AddressSerializer._fromJsonObject(object["billing_address"])
          : undefined,
      billingEmail: object["billing_email"],
      currency:
        object["currency"] != null
          ? CurrencySerializer._fromJsonObject(object["currency"])
          : undefined,
      customProperties: object["custom_properties"],
      customTaxes:
        object["custom_taxes"] != null
          ? object["custom_taxes"].map((item: any) =>
              CustomTaxRateSerializer._fromJsonObject(item)
            )
          : undefined,
      exemptionReason: object["exemption_reason"],
      invoicingEmails: object["invoicing_emails"],
      invoicingEntityId:
        object["invoicing_entity_id"] != null
          ? InvoicingEntityIdSerializer._fromJsonObject(object["invoicing_entity_id"])
          : undefined,
      invoicingLanguage: object["invoicing_language"],
      isTaxExempt: object["is_tax_exempt"],
      name: object["name"],
      phone: object["phone"],
      shippingAddress:
        object["shipping_address"] != null
          ? ShippingAddressSerializer._fromJsonObject(object["shipping_address"])
          : undefined,
      vatNumber: object["vat_number"],
    };
  },

  _toJsonObject(self: CustomerPatchRequest): any {
    return {
      alias: self.alias,
      billing_address:
        self.billingAddress != null
          ? AddressSerializer._toJsonObject(self.billingAddress)
          : undefined,
      billing_email: self.billingEmail,
      currency:
        self.currency != null
          ? CurrencySerializer._toJsonObject(self.currency)
          : undefined,
      custom_properties: self.customProperties,
      custom_taxes:
        self.customTaxes != null
          ? self.customTaxes.map((item: any) =>
              CustomTaxRateSerializer._toJsonObject(item)
            )
          : undefined,
      exemption_reason: self.exemptionReason,
      invoicing_emails: self.invoicingEmails,
      invoicing_entity_id:
        self.invoicingEntityId != null
          ? InvoicingEntityIdSerializer._toJsonObject(self.invoicingEntityId)
          : undefined,
      invoicing_language: self.invoicingLanguage,
      is_tax_exempt: self.isTaxExempt,
      name: self.name,
      phone: self.phone,
      shipping_address:
        self.shippingAddress != null
          ? ShippingAddressSerializer._toJsonObject(self.shippingAddress)
          : undefined,
      vat_number: self.vatNumber,
    };
  },
};
