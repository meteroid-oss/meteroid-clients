// this file is @generated
import { extraProperties } from "../json.js";
import { type CheckoutSession, CheckoutSessionSerializer } from "./checkoutSession.js";

export interface ListCheckoutSessionsResponse {
  sessions: CheckoutSession[];
}

/** Converts `ListCheckoutSessionsResponse` values from (`parse`) and to (`serialize`) their JSON form. */
export const ListCheckoutSessionsResponseSerializer = {
  parse(json: any): ListCheckoutSessionsResponse {
    return {
      ...extraProperties(json, ["sessions"]),
      sessions: json["sessions"].map((item: any) =>
        CheckoutSessionSerializer.parse(item)
      ),
    };
  },

  serialize(value: ListCheckoutSessionsResponse): any {
    return {
      ...extraProperties(value, ["sessions"]),
      sessions: value.sessions.map((item: any) =>
        CheckoutSessionSerializer.serialize(item)
      ),
    };
  },
};
