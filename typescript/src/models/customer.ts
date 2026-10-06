// this file is @generated
import { extraProperties } from "../json.js";
import { type Address, AddressSerializer } from "./address.js";
import { type Currency, CurrencySerializer } from "./currency.js";
import { type CustomTaxRate, CustomTaxRateSerializer } from "./customTaxRate.js";
import { type CustomerId, CustomerIdSerializer } from "./customerId.js";
import { type CustomerType, CustomerTypeSerializer } from "./customerType.js";
import {
  type InvoicingEntityId,
  InvoicingEntityIdSerializer,
} from "./invoicingEntityId.js";
import { type ShippingAddress, ShippingAddressSerializer } from "./shippingAddress.js";

export interface Customer {
  alias?: string | null | undefined;
  billingAddress?: Address | null | undefined;
  billingEmail?: string | null | undefined;
  connectedAccountId?: string | null | undefined;
  currency: Currency;
  /** User-defined custom property values, keyed by definition `key`. */
  customProperties: unknown;
  customTaxes: CustomTaxRate[];
  customerType?: CustomerType | undefined;
  firstName?: string | null | undefined;
  id: CustomerId;
  invoicingEmails: string[];
  invoicingEntityId: InvoicingEntityId;
  /**
   * Deprecated: the first entry of `preferred_locales`.
   *
   * @deprecated
   */
  invoicingLanguage?: string | null | undefined;
  lastName?: string | null | undefined;
  /** BT-47 — the buyer's national register identifier (SIREN/SIRET, HRB). */
  legalNumber?: string | null | undefined;
  name: string;
  phone?: string | null | undefined;
  /**
   * Preferred document languages, most-preferred first (BCP-47 tags, e.g.
   * `["fr-FR", "en"]`); overrides the invoicing entity default.
   */
  preferredLocales: string[];
  shippingAddress?: ShippingAddress | null | undefined;
  vatNumber?: string | null | undefined;
}

/** Converts `Customer` values from (`parse`) and to (`serialize`) their JSON form. */
export const CustomerSerializer = {
  parse(json: any): Customer {
    return {
      ...extraProperties(json, [
        "alias",
        "billing_address",
        "billing_email",
        "connected_account_id",
        "currency",
        "custom_properties",
        "custom_taxes",
        "customer_type",
        "first_name",
        "id",
        "invoicing_emails",
        "invoicing_entity_id",
        "invoicing_language",
        "last_name",
        "legal_number",
        "name",
        "phone",
        "preferred_locales",
        "shipping_address",
        "vat_number",
      ]),
      alias: json["alias"],
      billingAddress:
        json["billing_address"] != null
          ? AddressSerializer.parse(json["billing_address"])
          : json["billing_address"],
      billingEmail: json["billing_email"],
      connectedAccountId: json["connected_account_id"],
      currency: CurrencySerializer.parse(json["currency"]),
      customProperties: json["custom_properties"],
      customTaxes: json["custom_taxes"].map((item: any) =>
        CustomTaxRateSerializer.parse(item)
      ),
      customerType:
        json["customer_type"] != null
          ? CustomerTypeSerializer.parse(json["customer_type"])
          : undefined,
      firstName: json["first_name"],
      id: CustomerIdSerializer.parse(json["id"]),
      invoicingEmails: json["invoicing_emails"],
      invoicingEntityId: InvoicingEntityIdSerializer.parse(json["invoicing_entity_id"]),
      invoicingLanguage: json["invoicing_language"],
      lastName: json["last_name"],
      legalNumber: json["legal_number"],
      name: json["name"],
      phone: json["phone"],
      preferredLocales: json["preferred_locales"],
      shippingAddress:
        json["shipping_address"] != null
          ? ShippingAddressSerializer.parse(json["shipping_address"])
          : json["shipping_address"],
      vatNumber: json["vat_number"],
    };
  },

  serialize(value: Customer): any {
    return {
      ...extraProperties(value, [
        "alias",
        "billingAddress",
        "billingEmail",
        "connectedAccountId",
        "currency",
        "customProperties",
        "customTaxes",
        "customerType",
        "firstName",
        "id",
        "invoicingEmails",
        "invoicingEntityId",
        "invoicingLanguage",
        "lastName",
        "legalNumber",
        "name",
        "phone",
        "preferredLocales",
        "shippingAddress",
        "vatNumber",
      ]),
      alias: value.alias,
      billing_address:
        value.billingAddress != null
          ? AddressSerializer.serialize(value.billingAddress)
          : value.billingAddress,
      billing_email: value.billingEmail,
      connected_account_id: value.connectedAccountId,
      currency: CurrencySerializer.serialize(value.currency),
      custom_properties: value.customProperties,
      custom_taxes: value.customTaxes.map((item: any) =>
        CustomTaxRateSerializer.serialize(item)
      ),
      customer_type:
        value.customerType != null
          ? CustomerTypeSerializer.serialize(value.customerType)
          : undefined,
      first_name: value.firstName,
      id: CustomerIdSerializer.serialize(value.id),
      invoicing_emails: value.invoicingEmails,
      invoicing_entity_id: InvoicingEntityIdSerializer.serialize(value.invoicingEntityId),
      invoicing_language: value.invoicingLanguage,
      last_name: value.lastName,
      legal_number: value.legalNumber,
      name: value.name,
      phone: value.phone,
      preferred_locales: value.preferredLocales,
      shipping_address:
        value.shippingAddress != null
          ? ShippingAddressSerializer.serialize(value.shippingAddress)
          : value.shippingAddress,
      vat_number: value.vatNumber,
    };
  },
};
