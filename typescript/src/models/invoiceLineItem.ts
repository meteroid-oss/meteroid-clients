// this file is @generated
import { type SubLineItem, SubLineItemSerializer } from "./subLineItem";

export interface InvoiceLineItem {
  amountTotal: number;

  description?: string | null;

  endDate: string;

  name: string;

  quantity?: string;

  startDate: string;

  subLineItems: SubLineItem[];

  taxRate: string;

  unitPrice?: string;
}

export const InvoiceLineItemSerializer = {
  _fromJsonObject(object: any): InvoiceLineItem {
    return {
      amountTotal: object["amount_total"],
      description: object["description"],
      endDate: object["end_date"],
      name: object["name"],
      quantity: object["quantity"],
      startDate: object["start_date"],
      subLineItems: object["sub_line_items"].map((item: any) =>
        SubLineItemSerializer._fromJsonObject(item)
      ),
      taxRate: object["tax_rate"],
      unitPrice: object["unit_price"],
    };
  },

  _toJsonObject(self: InvoiceLineItem): any {
    return {
      amount_total: self.amountTotal,
      description: self.description,
      end_date: self.endDate,
      name: self.name,
      quantity: self.quantity,
      start_date: self.startDate,
      sub_line_items: self.subLineItems.map((item: any) =>
        SubLineItemSerializer._toJsonObject(item)
      ),
      tax_rate: self.taxRate,
      unit_price: self.unitPrice,
    };
  },
};
