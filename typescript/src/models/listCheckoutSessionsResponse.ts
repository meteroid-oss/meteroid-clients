// this file is @generated
import { type CheckoutSession, CheckoutSessionSerializer } from "./checkoutSession";

export interface ListCheckoutSessionsResponse {
  sessions: CheckoutSession[];
}

export const ListCheckoutSessionsResponseSerializer = {
  _fromJsonObject(object: any): ListCheckoutSessionsResponse {
    return {
      sessions: object["sessions"].map((item: any) =>
        CheckoutSessionSerializer._fromJsonObject(item)
      ),
    };
  },

  _toJsonObject(self: ListCheckoutSessionsResponse): any {
    return {
      sessions: self.sessions.map((item: any) =>
        CheckoutSessionSerializer._toJsonObject(item)
      ),
    };
  },
};
