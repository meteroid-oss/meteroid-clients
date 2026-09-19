// this file is @generated
import { type Address, AddressSerializer } from "./address";
import { type Currency, CurrencySerializer } from "./currency";
import { type CustomTaxRate, CustomTaxRateSerializer } from "./customTaxRate";
import { type CustomerType, CustomerTypeSerializer } from "./customerType";
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

  /** `INDIVIDUAL` requires `first_name`, `last_name`, and a billing-address country. */
  customerType?: CustomerType;

  /** Free-text legal exemption mention surfaced on exempt invoices. */
  exemptionReason?: string | null;

  firstName?: string | null;

  invoicingEmails: string[];

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

  /** Required for `COMPANY`. Ignored for `INDIVIDUAL`: derived from `first_name` + `last_name`. */
  name?: string;

  phone?: string | null;

  /**
   * Preferred document languages, most-preferred first (BCP-47 tags, e.g.
   * `["fr-FR", "en"]`); overrides the invoicing entity default. The first one the
   * renderer has a template for wins, so an unsupported entry alongside a supported
   * one just falls through; a list of only unsupported ones is rejected.
   */
  preferredLocales?: string[] | null;

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
