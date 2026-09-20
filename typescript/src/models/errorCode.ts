// this file is @generated

export enum ErrorCode {
  BadRequest = "BAD_REQUEST",
  NotFound = "NOT_FOUND",
  Conflict = "CONFLICT",
  Forbidden = "FORBIDDEN",
  Unauthorized = "UNAUTHORIZED",
  TooManyRequests = "TOO_MANY_REQUESTS",
  InternalServerError = "INTERNAL_SERVER_ERROR",
}

export const ErrorCodeSerializer = {
  _fromJsonObject(object: any): ErrorCode {
    return object;
  },

  _toJsonObject(self: ErrorCode): any {
    return self;
  },
};
