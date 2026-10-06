// this file is @generated
import { extraProperties } from "../json.js";
import { type ErrorCode, ErrorCodeSerializer } from "./errorCode.js";

export interface RestErrorResponse {
  code: ErrorCode;
  message: string;
}

/** Converts `RestErrorResponse` values from (`parse`) and to (`serialize`) their JSON form. */
export const RestErrorResponseSerializer = {
  parse(json: any): RestErrorResponse {
    return {
      ...extraProperties(json, ["code", "message"]),
      code: ErrorCodeSerializer.parse(json["code"]),
      message: json["message"],
    };
  },

  serialize(value: RestErrorResponse): any {
    return {
      ...extraProperties(value, ["code", "message"]),
      code: ErrorCodeSerializer.serialize(value.code),
      message: value.message,
    };
  },
};
