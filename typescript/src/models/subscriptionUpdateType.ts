// this file is @generated
/** Identifies which mutation triggered a `subscription.updated` webhook. */
export enum SubscriptionUpdateType {
  Activated = "activated",
  TrialEnded = "trial_ended",
  BillingConfigurationUpdated = "billing_configuration_updated",
  PlanChanged = "plan_changed",
  Amended = "amended",
  UnitsChanged = "units_changed",
  Paused = "paused",
  CancellationScheduled = "cancellation_scheduled",
}

export const SubscriptionUpdateTypeSerializer = {
  _fromJsonObject(object: any): SubscriptionUpdateType {
    return object;
  },

  _toJsonObject(self: SubscriptionUpdateType): any {
    return self;
  },
};
