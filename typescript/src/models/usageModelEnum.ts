// this file is @generated

export enum UsageModelEnum {
  PerUnit = "PER_UNIT",
  Tiered = "TIERED",
  Volume = "VOLUME",
  Package = "PACKAGE",
  Matrix = "MATRIX",
}

export const UsageModelEnumSerializer = {
  _fromJsonObject(object: any): UsageModelEnum {
    return object;
  },

  _toJsonObject(self: UsageModelEnum): any {
    return self;
  },
};
