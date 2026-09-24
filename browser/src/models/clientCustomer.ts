// this file is @generated
import { type CustomerId, CustomerIdSerializer } from "./customerId";
/** The customer the token was minted for. */
export interface ClientCustomer {
  alias?: string | null;

  billingEmail?: string | null;

  currency: string;

  id: CustomerId;

  name: string;
}

export const ClientCustomerSerializer = {
  _fromJsonObject(object: any): ClientCustomer {
    return {
      alias: object["alias"],
      billingEmail: object["billing_email"],
      currency: object["currency"],
      id: CustomerIdSerializer._fromJsonObject(object["id"]),
      name: object["name"],
    };
  },

  _toJsonObject(self: ClientCustomer): any {
    return {
      alias: self.alias,
      billing_email: self.billingEmail,
      currency: self.currency,
      id: CustomerIdSerializer._toJsonObject(self.id),
      name: self.name,
    };
  },
};
