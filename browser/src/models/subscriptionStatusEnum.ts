export enum SubscriptionStatusEnum {
  PendingActivation = "PENDING_ACTIVATION",
  PendingCharge = "PENDING_CHARGE",
  TrialActive = "TRIAL_ACTIVE",
  Active = "ACTIVE",
  TrialExpired = "TRIAL_EXPIRED",
  Paused = "PAUSED",
  Suspended = "SUSPENDED",
  Cancelled = "CANCELLED",
  Aborted = "ABORTED",
  Completed = "COMPLETED",
  Superseded = "SUPERSEDED",
  Errored = "ERRORED",
}

export const SubscriptionStatusEnumSerializer = {
  _fromJsonObject(object: any): SubscriptionStatusEnum {
    return object;
  },

  _toJsonObject(self: SubscriptionStatusEnum): any {
    return self;
  },
};
