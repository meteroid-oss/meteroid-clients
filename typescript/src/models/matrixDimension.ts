// this file is @generated

export interface MatrixDimension {
  key: string;

  value: string;
}

export const MatrixDimensionSerializer = {
  _fromJsonObject(object: any): MatrixDimension {
    return {
      key: object["key"],
      value: object["value"],
    };
  },

  _toJsonObject(self: MatrixDimension): any {
    return {
      key: self.key,
      value: self.value,
    };
  },
};
