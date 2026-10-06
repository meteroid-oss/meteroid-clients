// this file is @generated
import { extraProperties } from "../json.js";
import { type CheckoutSession, CheckoutSessionSerializer } from "./checkoutSession.js";

export interface CreateCheckoutSessionResponse {
  session: CheckoutSession;
}

/** Converts `CreateCheckoutSessionResponse` values from (`parse`) and to (`serialize`) their JSON form. */
export const CreateCheckoutSessionResponseSerializer = {
  parse(json: any): CreateCheckoutSessionResponse {
    return {
      ...extraProperties(json, ["session"]),
      session: CheckoutSessionSerializer.parse(json["session"]),
    };
  },

  serialize(value: CreateCheckoutSessionResponse): any {
    return {
      ...extraProperties(value, ["session"]),
      session: CheckoutSessionSerializer.serialize(value.session),
    };
  },
};
