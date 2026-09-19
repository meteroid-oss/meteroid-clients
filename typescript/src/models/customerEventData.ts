// this file is @generated
import { type CustomerId, CustomerIdSerializer } from "./customerId";

export interface CustomerEventData {
  alias?: string | null;

  billingEmail?: string | null;

  currency: string;

  /** User-defined custom property values, keyed by definition key. */
  customProperties: any;

  customerId: CustomerId;

  invoicingEmails: string[];

  name: string;

  phone?: string | null;
}

export const CustomerEventDataSerializer = {
  _fromJsonObject(object: any): CustomerEventData {
    return {
      alias: object["alias"],
      billingEmail: object["billing_email"],
      currency: object["currency"],
      customProperties: object["custom_properties"],
      customerId: CustomerIdSerializer._fromJsonObject(object["customer_id"]),
      invoicingEmails: object["invoicing_emails"],
      name: object["name"],
      phone: object["phone"],
    };
  },

  _toJsonObject(self: CustomerEventData): any {
    return {
      alias: self.alias,
      billing_email: self.billingEmail,
      currency: self.currency,
      custom_properties: self.customProperties,
      customer_id: CustomerIdSerializer._toJsonObject(self.customerId),
      invoicing_emails: self.invoicingEmails,
      name: self.name,
      phone: self.phone,
    };
  },
};
