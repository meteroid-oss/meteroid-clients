// this file is @generated

export enum CheckoutSessionStatus {
  Created = "CREATED",
  AwaitingPayment = "AWAITING_PAYMENT",
  Completed = "COMPLETED",
  Expired = "EXPIRED",
  Cancelled = "CANCELLED",
}

export const CheckoutSessionStatusSerializer = {
  _fromJsonObject(object: any): CheckoutSessionStatus {
    return object;
  },

  _toJsonObject(self: CheckoutSessionStatus): any {
    return self;
  },
};
