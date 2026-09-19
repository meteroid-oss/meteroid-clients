// this file is @generated

export interface CancelSubscriptionRequest {
  /** If not provided, the cancellation will be effective at the end of the current billing or committed period. */
  effectiveDate?: string | null;

  reason?: string | null;
}

export const CancelSubscriptionRequestSerializer = {
  _fromJsonObject(object: any): CancelSubscriptionRequest {
    return {
      effectiveDate: object["effective_date"],
      reason: object["reason"],
    };
  },

  _toJsonObject(self: CancelSubscriptionRequest): any {
    return {
      effective_date: self.effectiveDate,
      reason: self.reason,
    };
  },
};
