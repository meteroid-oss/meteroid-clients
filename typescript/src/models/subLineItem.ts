// this file is @generated
import { extraProperties } from "../json.js";

export interface SubLineItem {
  id: string;
  name: string;
  quantity: string;
  total: number;
  unitPrice: string;
}

/** Converts `SubLineItem` values from (`parse`) and to (`serialize`) their JSON form. */
export const SubLineItemSerializer = {
  parse(json: any): SubLineItem {
    return {
      ...extraProperties(json, ["id", "name", "quantity", "total", "unit_price"]),
      id: json["id"],
      name: json["name"],
      quantity: json["quantity"],
      total: json["total"],
      unitPrice: json["unit_price"],
    };
  },

  serialize(value: SubLineItem): any {
    return {
      ...extraProperties(value, ["id", "name", "quantity", "total", "unitPrice"]),
      id: value.id,
      name: value.name,
      quantity: value.quantity,
      total: value.total,
      unit_price: value.unitPrice,
    };
  },
};
