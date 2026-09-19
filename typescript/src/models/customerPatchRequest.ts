// this file is @generated
import { type Address, AddressSerializer } from "./address";
import { type Currency, CurrencySerializer } from "./currency";
import { type CustomTaxRate, CustomTaxRateSerializer } from "./customTaxRate";
import { type CustomerType, CustomerTypeSerializer } from "./customerType";
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

  customerType?: CustomerType | null;

  /** Free-text legal exemption mention surfaced on exempt invoices. */
  exemptionReason?: string | null;

  firstName?: string | null;

  invoicingEmails?: string[] | null;

  invoicingEntityId?: InvoicingEntityId | null;

  /**
   * Deprecated: use `preferred_locales`. Applied only when `preferred_locales` is absent.
   *
   * @deprecated
   */
  invoicingLanguage?: string | null;

  isTaxExempt?: boolean | null;

  lastName?: string | null;

  /** BT-47 — the buyer's national register identifier (SIREN/SIRET, HRB). */
  legalNumber?: string | null;

  name?: string | null;

  phone?: string | null;

  /**
   * Preferred document languages, most-preferred first (BCP-47 tags, e.g.
   * `["fr-FR", "en"]`); overrides the invoicing entity default. Omit to leave
   * unchanged, send `[]` to reset to that default.
   */
  preferredLocales?: string[] | null;

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
      customerType:
        object["customer_type"] != null
          ? CustomerTypeSerializer._fromJsonObject(object["customer_type"])
          : undefined,
      exemptionReason: object["exemption_reason"],
      firstName: object["first_name"],
      invoicingEmails: object["invoicing_emails"],
      invoicingEntityId:
        object["invoicing_entity_id"] != null
          ? InvoicingEntityIdSerializer._fromJsonObject(object["invoicing_entity_id"])
          : undefined,
      invoicingLanguage: object["invoicing_language"],
      isTaxExempt: object["is_tax_exempt"],
      lastName: object["last_name"],
      legalNumber: object["legal_number"],
      name: object["name"],
      phone: object["phone"],
      preferredLocales: object["preferred_locales"],
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
      customer_type:
        self.customerType != null
          ? CustomerTypeSerializer._toJsonObject(self.customerType)
          : undefined,
      exemption_reason: self.exemptionReason,
      first_name: self.firstName,
      invoicing_emails: self.invoicingEmails,
      invoicing_entity_id:
        self.invoicingEntityId != null
          ? InvoicingEntityIdSerializer._toJsonObject(self.invoicingEntityId)
          : undefined,
      invoicing_language: self.invoicingLanguage,
      is_tax_exempt: self.isTaxExempt,
      last_name: self.lastName,
      legal_number: self.legalNumber,
      name: self.name,
      phone: self.phone,
      preferred_locales: self.preferredLocales,
      shipping_address:
        self.shippingAddress != null
          ? ShippingAddressSerializer._toJsonObject(self.shippingAddress)
          : undefined,
      vat_number: self.vatNumber,
    };
  },
};
