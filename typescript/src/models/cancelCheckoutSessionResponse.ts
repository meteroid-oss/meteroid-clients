// this file is @generated
import { type CheckoutSession, CheckoutSessionSerializer } from "./checkoutSession";

export interface CancelCheckoutSessionResponse {
  session: CheckoutSession;
}

export const CancelCheckoutSessionResponseSerializer = {
  _fromJsonObject(object: any): CancelCheckoutSessionResponse {
    return {
      session: CheckoutSessionSerializer._fromJsonObject(object["session"]),
    };
  },

  _toJsonObject(self: CancelCheckoutSessionResponse): any {
    return {
      session: CheckoutSessionSerializer._toJsonObject(self.session),
    };
  },
};
