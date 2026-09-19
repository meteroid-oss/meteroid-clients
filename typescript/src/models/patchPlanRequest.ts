// this file is @generated

export interface PatchPlanRequest {
  description?: string | null;

  name?: string | null;

  selfServiceRank?: number | null;
}

export const PatchPlanRequestSerializer = {
  _fromJsonObject(object: any): PatchPlanRequest {
    return {
      description: object["description"],
      name: object["name"],
      selfServiceRank: object["self_service_rank"],
    };
  },

  _toJsonObject(self: PatchPlanRequest): any {
    return {
      description: self.description,
      name: self.name,
      self_service_rank: self.selfServiceRank,
    };
  },
};
