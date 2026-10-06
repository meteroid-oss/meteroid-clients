// this file is @generated
import { extraProperties } from "../json.js";
import { type Address, AddressSerializer } from "./address.js";

export interface ShippingAddress {
  address?: Address | null | undefined;
  sameAsBilling: boolean;
}

/** Converts `ShippingAddress` values from (`parse`) and to (`serialize`) their JSON form. */
export const ShippingAddressSerializer = {
  parse(json: any): ShippingAddress {
    return {
      ...extraProperties(json, ["address", "same_as_billing"]),
      address:
        json["address"] != null
          ? AddressSerializer.parse(json["address"])
          : json["address"],
      sameAsBilling: json["same_as_billing"],
    };
  },

  serialize(value: ShippingAddress): any {
    return {
      ...extraProperties(value, ["address", "sameAsBilling"]),
      address:
        value.address != null
          ? AddressSerializer.serialize(value.address)
          : value.address,
      same_as_billing: value.sameAsBilling,
    };
  },
};
