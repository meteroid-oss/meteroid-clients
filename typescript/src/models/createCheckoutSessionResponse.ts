// this file is @generated
import { type CheckoutSession, CheckoutSessionSerializer } from "./checkoutSession";

export interface CreateCheckoutSessionResponse {
  session: CheckoutSession;
}

export const CreateCheckoutSessionResponseSerializer = {
  _fromJsonObject(object: any): CreateCheckoutSessionResponse {
    return {
      session: CheckoutSessionSerializer._fromJsonObject(object["session"]),
    };
  },

  _toJsonObject(self: CreateCheckoutSessionResponse): any {
    return {
      session: CheckoutSessionSerializer._toJsonObject(self.session),
    };
  },
};
