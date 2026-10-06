// this file is @generated
import { extraProperties } from "../json.js";
import { type Address, AddressSerializer } from "./address.js";
import { type Currency, CurrencySerializer } from "./currency.js";
import { type CustomTaxRate, CustomTaxRateSerializer } from "./customTaxRate.js";
import { type CustomerType, CustomerTypeSerializer } from "./customerType.js";
import {
  type InvoicingEntityId,
  InvoicingEntityIdSerializer,
} from "./invoicingEntityId.js";
import { type ShippingAddress, ShippingAddressSerializer } from "./shippingAddress.js";

export interface CustomerPatchRequest {
  alias?: string | null | undefined;
  billingAddress?: Address | null | undefined;
  billingEmail?: string | null | undefined;
  currency?: Currency | null | undefined;
  /**
   * Partial update of custom property values (merge; send a key with `null` to remove it).
   * Omit to leave unchanged.
   */
  customProperties?: unknown | undefined;
  customTaxes?: CustomTaxRate[] | null | undefined;
  customerType?: CustomerType | null | undefined;
  /** Free-text legal exemption mention surfaced on exempt invoices. */
  exemptionReason?: string | null | undefined;
  firstName?: string | null | undefined;
  invoicingEmails?: string[] | null | undefined;
  invoicingEntityId?: InvoicingEntityId | null | undefined;
  /**
   * Deprecated: use `preferred_locales`. Applied only when `preferred_locales` is absent.
   *
   * @deprecated
   */
  invoicingLanguage?: string | null | undefined;
  isTaxExempt?: boolean | null | undefined;
  lastName?: string | null | undefined;
  /** BT-47 — the buyer's national register identifier (SIREN/SIRET, HRB). */
  legalNumber?: string | null | undefined;
  name?: string | null | undefined;
  phone?: string | null | undefined;
  /**
   * Preferred document languages, most-preferred first (BCP-47 tags, e.g.
   * `["fr-FR", "en"]`); overrides the invoicing entity default. Omit to leave
   * unchanged, send `[]` to reset to that default.
   */
  preferredLocales?: string[] | null | undefined;
  shippingAddress?: ShippingAddress | null | undefined;
  vatNumber?: string | null | undefined;
}

/** Converts `CustomerPatchRequest` values from (`parse`) and to (`serialize`) their JSON form. */
export const CustomerPatchRequestSerializer = {
  parse(json: any): CustomerPatchRequest {
    return {
      ...extraProperties(json, [
        "alias",
        "billing_address",
        "billing_email",
        "currency",
        "custom_properties",
        "custom_taxes",
        "customer_type",
        "exemption_reason",
        "first_name",
        "invoicing_emails",
        "invoicing_entity_id",
        "invoicing_language",
        "is_tax_exempt",
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
      currency:
        json["currency"] != null
          ? CurrencySerializer.parse(json["currency"])
          : json["currency"],
      customProperties: json["custom_properties"],
      customTaxes:
        json["custom_taxes"] != null
          ? json["custom_taxes"].map((item: any) => CustomTaxRateSerializer.parse(item))
          : json["custom_taxes"],
      customerType:
        json["customer_type"] != null
          ? CustomerTypeSerializer.parse(json["customer_type"])
          : json["customer_type"],
      exemptionReason: json["exemption_reason"],
      firstName: json["first_name"],
      invoicingEmails: json["invoicing_emails"],
      invoicingEntityId:
        json["invoicing_entity_id"] != null
          ? InvoicingEntityIdSerializer.parse(json["invoicing_entity_id"])
          : json["invoicing_entity_id"],
      invoicingLanguage: json["invoicing_language"],
      isTaxExempt: json["is_tax_exempt"],
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

  serialize(value: CustomerPatchRequest): any {
    return {
      ...extraProperties(value, [
        "alias",
        "billingAddress",
        "billingEmail",
        "currency",
        "customProperties",
        "customTaxes",
        "customerType",
        "exemptionReason",
        "firstName",
        "invoicingEmails",
        "invoicingEntityId",
        "invoicingLanguage",
        "isTaxExempt",
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
      currency:
        value.currency != null
          ? CurrencySerializer.serialize(value.currency)
          : value.currency,
      custom_properties: value.customProperties,
      custom_taxes:
        value.customTaxes != null
          ? value.customTaxes.map((item: any) => CustomTaxRateSerializer.serialize(item))
          : value.customTaxes,
      customer_type:
        value.customerType != null
          ? CustomerTypeSerializer.serialize(value.customerType)
          : value.customerType,
      exemption_reason: value.exemptionReason,
      first_name: value.firstName,
      invoicing_emails: value.invoicingEmails,
      invoicing_entity_id:
        value.invoicingEntityId != null
          ? InvoicingEntityIdSerializer.serialize(value.invoicingEntityId)
          : value.invoicingEntityId,
      invoicing_language: value.invoicingLanguage,
      is_tax_exempt: value.isTaxExempt,
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
