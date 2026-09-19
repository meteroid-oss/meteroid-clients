// this file is @generated

export interface SubLineItem {
  id: string;

  name: string;

  quantity: string;

  total: number;

  unitPrice: string;
}

export const SubLineItemSerializer = {
  _fromJsonObject(object: any): SubLineItem {
    return {
      id: object["id"],
      name: object["name"],
      quantity: object["quantity"],
      total: object["total"],
      unitPrice: object["unit_price"],
    };
  },

  _toJsonObject(self: SubLineItem): any {
    return {
      id: self.id,
      name: self.name,
      quantity: self.quantity,
      total: self.total,
      unit_price: self.unitPrice,
    };
  },
};
