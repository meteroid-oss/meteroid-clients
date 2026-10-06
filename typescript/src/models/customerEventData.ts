// this file is @generated
import { extraProperties } from "../json.js";
import { type CustomerId, CustomerIdSerializer } from "./customerId.js";

export interface CustomerEventData {
  alias?: string | null | undefined;
  billingEmail?: string | null | undefined;
  currency: string;
  /** User-defined custom property values, keyed by definition key. */
  customProperties: unknown;
  customerId: CustomerId;
  invoicingEmails: string[];
  name: string;
  phone?: string | null | undefined;
}

/** Converts `CustomerEventData` values from (`parse`) and to (`serialize`) their JSON form. */
export const CustomerEventDataSerializer = {
  parse(json: any): CustomerEventData {
    return {
      ...extraProperties(json, [
        "alias",
        "billing_email",
        "currency",
        "custom_properties",
        "customer_id",
        "invoicing_emails",
        "name",
        "phone",
      ]),
      alias: json["alias"],
      billingEmail: json["billing_email"],
      currency: json["currency"],
      customProperties: json["custom_properties"],
      customerId: CustomerIdSerializer.parse(json["customer_id"]),
      invoicingEmails: json["invoicing_emails"],
      name: json["name"],
      phone: json["phone"],
    };
  },

  serialize(value: CustomerEventData): any {
    return {
      ...extraProperties(value, [
        "alias",
        "billingEmail",
        "currency",
        "customProperties",
        "customerId",
        "invoicingEmails",
        "name",
        "phone",
      ]),
      alias: value.alias,
      billing_email: value.billingEmail,
      currency: value.currency,
      custom_properties: value.customProperties,
      customer_id: CustomerIdSerializer.serialize(value.customerId),
      invoicing_emails: value.invoicingEmails,
      name: value.name,
      phone: value.phone,
    };
  },
};
