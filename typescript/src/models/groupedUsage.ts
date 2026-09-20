// this file is @generated

export interface GroupedUsage {
  dimensions: { [key: string]: string };

  value: string;
}

export const GroupedUsageSerializer = {
  _fromJsonObject(object: any): GroupedUsage {
    return {
      dimensions: object["dimensions"],
      value: object["value"],
    };
  },

  _toJsonObject(self: GroupedUsage): any {
    return {
      dimensions: self.dimensions,
      value: self.value,
    };
  },
};
