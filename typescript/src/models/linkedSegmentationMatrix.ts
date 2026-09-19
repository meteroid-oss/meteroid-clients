// this file is @generated

export interface LinkedSegmentationMatrix {
  dimension1Key: string;

  dimension2Key: string;

  values: { [key: string]: string[] };
}

export const LinkedSegmentationMatrixSerializer = {
  _fromJsonObject(object: any): LinkedSegmentationMatrix {
    return {
      dimension1Key: object["dimension1_key"],
      dimension2Key: object["dimension2_key"],
      values: Object.fromEntries(
        Object.entries(object["values"]).map((entry: [string, any]) => [
          entry[0],
          entry[1],
        ])
      ),
    };
  },

  _toJsonObject(self: LinkedSegmentationMatrix): any {
    return {
      dimension1_key: self.dimension1Key,
      dimension2_key: self.dimension2Key,
      values: Object.fromEntries(
        Object.entries(self.values).map((entry: [string, any]) => [entry[0], entry[1]])
      ),
    };
  },
};
