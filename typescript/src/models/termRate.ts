// this file is @generated
import { extraProperties } from "../json.js";
import {
  type BillingPeriodEnum,
  BillingPeriodEnumSerializer,
} from "./billingPeriodEnum.js";

export interface TermRate {
  price: string;
  term: BillingPeriodEnum;
}

/** Converts `TermRate` values from (`parse`) and to (`serialize`) their JSON form. */
export const TermRateSerializer = {
  parse(json: any): TermRate {
    return {
      ...extraProperties(json, ["price", "term"]),
      price: json["price"],
      term: BillingPeriodEnumSerializer.parse(json["term"]),
    };
  },

  serialize(value: TermRate): any {
    return {
      ...extraProperties(value, ["price", "term"]),
      price: value.price,
      term: BillingPeriodEnumSerializer.serialize(value.term),
    };
  },
};
