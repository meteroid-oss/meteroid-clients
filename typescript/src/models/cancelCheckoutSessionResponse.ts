// this file is @generated
import { extraProperties } from "../json.js";
import { type CheckoutSession, CheckoutSessionSerializer } from "./checkoutSession.js";

export interface CancelCheckoutSessionResponse {
  session: CheckoutSession;
}

/** Converts `CancelCheckoutSessionResponse` values from (`parse`) and to (`serialize`) their JSON form. */
export const CancelCheckoutSessionResponseSerializer = {
  parse(json: any): CancelCheckoutSessionResponse {
    return {
      ...extraProperties(json, ["session"]),
      session: CheckoutSessionSerializer.parse(json["session"]),
    };
  },

  serialize(value: CancelCheckoutSessionResponse): any {
    return {
      ...extraProperties(value, ["session"]),
      session: CheckoutSessionSerializer.serialize(value.session),
    };
  },
};
