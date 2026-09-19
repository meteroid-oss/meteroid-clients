// this file is @generated

export enum PaymentStatusEnum {
  Ready = "READY",
  Pending = "PENDING",
  Settled = "SETTLED",
  Cancelled = "CANCELLED",
  Failed = "FAILED",
  Refunded = "REFUNDED",
}

export const PaymentStatusEnumSerializer = {
  _fromJsonObject(object: any): PaymentStatusEnum {
    return object;
  },

  _toJsonObject(self: PaymentStatusEnum): any {
    return self;
  },
};
