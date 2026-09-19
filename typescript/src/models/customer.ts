// this file is @generated
import { type Address, AddressSerializer } from "./address";
import { type Currency, CurrencySerializer } from "./currency";
import { type CustomTaxRate, CustomTaxRateSerializer } from "./customTaxRate";
import { type CustomerId, CustomerIdSerializer } from "./customerId";
import { type InvoicingEntityId, InvoicingEntityIdSerializer } from "./invoicingEntityId";
import { type ShippingAddress, ShippingAddressSerializer } from "./shippingAddress";

export interface Customer {
  alias?: string | null;

  billingAddress?: Address | null;

  billingEmail?: string | null;

  connectedAccountId?: string | null;

  currency: Currency;

  /** User-defined custom property values, keyed by definition `key`. */
  customProperties: any;

  customTaxes: CustomTaxRate[];

  id: CustomerId;

  invoicingEmails: string[];

  invoicingEntityId: InvoicingEntityId;

  /** Preferred document language (e.g. `en-US`, `fr-FR`); overrides the invoicing entity default. */
  invoicingLanguage?: string | null;

  name: string;

  phone?: string | null;

  shippingAddress?: ShippingAddress | null;

  vatNumber?: string | null;
}

export const CustomerSerializer = {
  _fromJsonObject(object: any): Customer {
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
      id: CustomerIdSerializer._fromJsonObject(object["id"]),
      invoicingEmails: object["invoicing_emails"],
      invoicingEntityId: InvoicingEntityIdSerializer._fromJsonObject(
        object["invoicing_entity_id"]
      ),
      invoicingLanguage: object["invoicing_language"],
      name: object["name"],
      phone: object["phone"],
      shippingAddress:
        object["shipping_address"] != null
          ? ShippingAddressSerializer._fromJsonObject(object["shipping_address"])
          : undefined,
      vatNumber: object["vat_number"],
    };
  },

  _toJsonObject(self: Customer): any {
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
      id: CustomerIdSerializer._toJsonObject(self.id),
      invoicing_emails: self.invoicingEmails,
      invoicing_entity_id: InvoicingEntityIdSerializer._toJsonObject(
        self.invoicingEntityId
      ),
      invoicing_language: self.invoicingLanguage,
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
