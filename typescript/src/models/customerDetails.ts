// this file is @generated
import { parseDateTime } from "../datetime";
import { type Address, AddressSerializer } from "./address";
import { type CustomerId, CustomerIdSerializer } from "./customerId";

export interface CustomerDetails {
  alias?: string | null;

  billingAddress?: Address | null;

  email?: string | null;

  id: CustomerId;

  name: string;

  snapshotAt: Date;

  vatNumber?: string | null;
}

export const CustomerDetailsSerializer = {
  _fromJsonObject(object: any): CustomerDetails {
    return {
      alias: object["alias"],
      billingAddress:
        object["billing_address"] != null
          ? AddressSerializer._fromJsonObject(object["billing_address"])
          : undefined,
      email: object["email"],
      id: CustomerIdSerializer._fromJsonObject(object["id"]),
      name: object["name"],
      snapshotAt: parseDateTime(object["snapshot_at"]),
      vatNumber: object["vat_number"],
    };
  },

  _toJsonObject(self: CustomerDetails): any {
    return {
      alias: self.alias,
      billing_address:
        self.billingAddress != null
          ? AddressSerializer._toJsonObject(self.billingAddress)
          : undefined,
      email: self.email,
      id: CustomerIdSerializer._toJsonObject(self.id),
      name: self.name,
      snapshot_at: self.snapshotAt,
      vat_number: self.vatNumber,
    };
  },
};
