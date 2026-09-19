// this file is @generated
import { type Address, AddressSerializer } from "./address";
import { type Currency, CurrencySerializer } from "./currency";
import { type CustomTaxRate, CustomTaxRateSerializer } from "./customTaxRate";
import { type InvoicingEntityId, InvoicingEntityIdSerializer } from "./invoicingEntityId";
import { type ShippingAddress, ShippingAddressSerializer } from "./shippingAddress";

export interface CustomerCreateRequest {
  alias?: string | null;

  billingAddress?: Address | null;

  billingEmail?: string | null;

  connectedAccountId?: string | null;

  currency: Currency;

  /**
   * User-defined custom property values, keyed by definition `key`. Validated against the
   * tenant's `CUSTOMER` property definitions. Omit to leave unset.
   */
  customProperties?: any;

  customTaxes: CustomTaxRate[];

  /** Free-text legal exemption mention surfaced on exempt invoices. */
  exemptionReason?: string | null;

  invoicingEmails: string[];

  invoicingEntityId?: InvoicingEntityId | null;

  /**
   * Preferred document language (e.g. `en-US`, `fr-FR`); overrides the invoicing entity default.
   * Unsupported languages fall back to `en-US` when rendering.
   */
  invoicingLanguage?: string | null;

  isTaxExempt?: boolean | null;

  name: string;

  phone?: string | null;

  shippingAddress?: ShippingAddress | null;

  vatNumber?: string | null;
}

export const CustomerCreateRequestSerializer = {
  _fromJsonObject(object: any): CustomerCreateRequest {
    return {
      alias: object["alias"],
      billingAddress:
        object["billing_address"] != null
          ? AddressSerializer._fromJsonObject(object["billing_address"])
          : undefined,
      billingEmail: object["billing_email"],
      connectedAccountId: object["connected_account_id"],
      currency: CurrencySerializer._fromJsonObject(object["currency"]),
      customProperties: object["custom_properties"],
      customTaxes: object["custom_taxes"].map((item: any) =>
        CustomTaxRateSerializer._fromJsonObject(item)
      ),
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

  _toJsonObject(self: CustomerCreateRequest): any {
    return {
      alias: self.alias,
      billing_address:
        self.billingAddress != null
          ? AddressSerializer._toJsonObject(self.billingAddress)
          : undefined,
      billing_email: self.billingEmail,
      connected_account_id: self.connectedAccountId,
      currency: CurrencySerializer._toJsonObject(self.currency),
      custom_properties: self.customProperties,
      custom_taxes: self.customTaxes.map((item: any) =>
        CustomTaxRateSerializer._toJsonObject(item)
      ),
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
