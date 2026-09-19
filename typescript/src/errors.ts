import { ErrorCode } from "./models/errorCode";
import { OAuthErrorCode } from "./models/oAuthErrorCode";
import {
  type OAuthErrorResponse,
  OAuthErrorResponseSerializer,
} from "./models/oAuthErrorResponse";
import {
  type RestErrorResponse,
  RestErrorResponseSerializer,
} from "./models/restErrorResponse";

// Parsers for the error bodies documented in the OpenAPI spec. The generated
// serializers do not validate their input, so the shape (and the enum values)
// are checked here first: a body that does not match exactly is not typed.

const ERROR_CODES: ReadonlySet<unknown> = new Set(Object.values(ErrorCode));
const OAUTH_ERROR_CODES: ReadonlySet<unknown> = new Set(Object.values(OAuthErrorCode));

function isOptionalString(value: unknown): boolean {
  return value === undefined || value === null || typeof value === "string";
}

function isObject(value: unknown): value is Record<string, unknown> {
  return typeof value === "object" && value !== null && !Array.isArray(value);
}

/** Parse `json` as a `RestErrorResponse`, or return `undefined` if it is not one. */
export function parseRestErrorResponse(json: unknown): RestErrorResponse | undefined {
  if (
    !isObject(json) ||
    !ERROR_CODES.has(json.code) ||
    typeof json.message !== "string"
  ) {
    return undefined;
  }
  return RestErrorResponseSerializer._fromJsonObject(json);
}

/** Parse `json` as an `OAuthErrorResponse`, or return `undefined` if it is not one. */
export function parseOAuthErrorResponse(json: unknown): OAuthErrorResponse | undefined {
  if (
    !isObject(json) ||
    !OAUTH_ERROR_CODES.has(json.error) ||
    !isOptionalString(json.error_description) ||
    !isOptionalString(json.error_uri)
  ) {
    return undefined;
  }
  return OAuthErrorResponseSerializer._fromJsonObject(json);
}
