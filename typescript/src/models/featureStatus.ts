// this file is @generated
/** Lifecycle status of a feature. */
export enum FeatureStatus {
  Active = "ACTIVE",
  Disabled = "DISABLED",
  Archived = "ARCHIVED",
}

export const FeatureStatusSerializer = {
  _fromJsonObject(object: any): FeatureStatus {
    return object;
  },

  _toJsonObject(self: FeatureStatus): any {
    return self;
  },
};
