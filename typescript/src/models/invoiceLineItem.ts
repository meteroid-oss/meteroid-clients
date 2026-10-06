// this file is @generated
import { extraProperties } from "../json.js";
import { type SubLineItem, SubLineItemSerializer } from "./subLineItem.js";

export interface InvoiceLineItem {
  amountTotal: number;
  description?: string | null | undefined;
  endDate: string;
  name: string;
  quantity?: string | undefined;
  startDate: string;
  subLineItems: SubLineItem[];
  taxRate: string;
  unitPrice?: string | undefined;
}

/** Converts `InvoiceLineItem` values from (`parse`) and to (`serialize`) their JSON form. */
export const InvoiceLineItemSerializer = {
  parse(json: any): InvoiceLineItem {
    return {
      ...extraProperties(json, [
        "amount_total",
        "description",
        "end_date",
        "name",
        "quantity",
        "start_date",
        "sub_line_items",
        "tax_rate",
        "unit_price",
      ]),
      amountTotal: json["amount_total"],
      description: json["description"],
      endDate: json["end_date"],
      name: json["name"],
      quantity: json["quantity"],
      startDate: json["start_date"],
      subLineItems: json["sub_line_items"].map((item: any) =>
        SubLineItemSerializer.parse(item)
      ),
      taxRate: json["tax_rate"],
      unitPrice: json["unit_price"],
    };
  },

  serialize(value: InvoiceLineItem): any {
    return {
      ...extraProperties(value, [
        "amountTotal",
        "description",
        "endDate",
        "name",
        "quantity",
        "startDate",
        "subLineItems",
        "taxRate",
        "unitPrice",
      ]),
      amount_total: value.amountTotal,
      description: value.description,
      end_date: value.endDate,
      name: value.name,
      quantity: value.quantity,
      start_date: value.startDate,
      sub_line_items: value.subLineItems.map((item: any) =>
        SubLineItemSerializer.serialize(item)
      ),
      tax_rate: value.taxRate,
      unit_price: value.unitPrice,
    };
  },
};
