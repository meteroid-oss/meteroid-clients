// this file is @generated
import { parseDateTime } from "../datetime.js";
import { extraProperties } from "../json.js";
import { type Address, AddressSerializer } from "./address.js";
import { type CustomerId, CustomerIdSerializer } from "./customerId.js";

export interface CustomerDetails {
  alias?: string | null | undefined;
  billingAddress?: Address | null | undefined;
  email?: string | null | undefined;
  id: CustomerId;
  name: string;
  snapshotAt: Date;
  vatNumber?: string | null | undefined;
}

/** Converts `CustomerDetails` values from (`parse`) and to (`serialize`) their JSON form. */
export const CustomerDetailsSerializer = {
  parse(json: any): CustomerDetails {
    return {
      ...extraProperties(json, [
        "alias",
        "billing_address",
        "email",
        "id",
        "name",
        "snapshot_at",
        "vat_number",
      ]),
      alias: json["alias"],
      billingAddress:
        json["billing_address"] != null
          ? AddressSerializer.parse(json["billing_address"])
          : json["billing_address"],
      email: json["email"],
      id: CustomerIdSerializer.parse(json["id"]),
      name: json["name"],
      snapshotAt: parseDateTime(json["snapshot_at"]),
      vatNumber: json["vat_number"],
    };
  },

  serialize(value: CustomerDetails): any {
    return {
      ...extraProperties(value, [
        "alias",
        "billingAddress",
        "email",
        "id",
        "name",
        "snapshotAt",
        "vatNumber",
      ]),
      alias: value.alias,
      billing_address:
        value.billingAddress != null
          ? AddressSerializer.serialize(value.billingAddress)
          : value.billingAddress,
      email: value.email,
      id: CustomerIdSerializer.serialize(value.id),
      name: value.name,
      snapshot_at: value.snapshotAt,
      vat_number: value.vatNumber,
    };
  },
};
