import { ErrorCode } from "./models/errorCode";
import {
  type RestErrorResponse,
  RestErrorResponseSerializer,
} from "./models/restErrorResponse";

/**
 * Thrown on a non-2xx answer. `restError` is set when the body is a `{ code, message }` error
 * with a code this version knows; `status` and the raw `body` are always set.
 */
export class ApiException extends Error {
  /** HTTP status code of the response. */
  public readonly status: number;
  /** Raw response body, as received. */
  public readonly body: string;
  /** The error body, when it is a `RestErrorResponse`. */
  public readonly restError: RestErrorResponse | undefined;

  public constructor(status: number, body: string) {
    const restError = parseRestError(body);
    super(
      `API Error ${status}${restError ? `: ${restError.code}: ${restError.message}` : ""}`
    );
    this.name = "ApiException";
    this.status = status;
    this.body = body;
    this.restError = restError;
  }
}

function parseRestError(body: string): RestErrorResponse | undefined {
  let json: any;
  try {
    json = JSON.parse(body);
  } catch {
    return undefined;
  }
  const known: unknown[] = Object.values(ErrorCode);
  return typeof json === "object" &&
    json !== null &&
    known.includes(json.code) &&
    typeof json.message === "string"
    ? RestErrorResponseSerializer._fromJsonObject(json)
    : undefined;
}
