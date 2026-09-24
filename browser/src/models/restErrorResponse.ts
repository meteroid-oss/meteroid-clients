import { type ErrorCode, ErrorCodeSerializer } from "./errorCode";

export interface RestErrorResponse {
  code: ErrorCode;

  message: string;
}

export const RestErrorResponseSerializer = {
  _fromJsonObject(object: any): RestErrorResponse {
    return {
      code: ErrorCodeSerializer._fromJsonObject(object["code"]),
      message: object["message"],
    };
  },

  _toJsonObject(self: RestErrorResponse): any {
    return {
      code: ErrorCodeSerializer._toJsonObject(self.code),
      message: self.message,
    };
  },
};
