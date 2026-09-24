import { type Currency, CurrencySerializer } from "./currency";
import { type CustomerId, CustomerIdSerializer } from "./customerId";
/** The signed-in customer, as seen by the customer themselves. */
export interface ClientCustomer {
  alias?: string | null;

  billingEmail?: string | null;

  currency: Currency;

  id: CustomerId;

  name: string;
}

export const ClientCustomerSerializer = {
  _fromJsonObject(object: any): ClientCustomer {
    return {
      alias: object["alias"],
      billingEmail: object["billing_email"],
      currency: CurrencySerializer._fromJsonObject(object["currency"]),
      id: CustomerIdSerializer._fromJsonObject(object["id"]),
      name: object["name"],
    };
  },

  _toJsonObject(self: ClientCustomer): any {
    return {
      alias: self.alias,
      billing_email: self.billingEmail,
      currency: CurrencySerializer._toJsonObject(self.currency),
      id: CustomerIdSerializer._toJsonObject(self.id),
      name: self.name,
    };
  },
};
