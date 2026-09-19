// this file is @generated
import { type PlanVersionId, PlanVersionIdSerializer } from "./planVersionId";

export interface PlanVersionSummary {
  createdAt: Date;

  currency: string;

  id: PlanVersionId;

  isDraft: boolean;

  version: number;
}

export const PlanVersionSummarySerializer = {
  _fromJsonObject(object: any): PlanVersionSummary {
    return {
      createdAt: new Date(object["created_at"]),
      currency: object["currency"],
      id: PlanVersionIdSerializer._fromJsonObject(object["id"]),
      isDraft: object["is_draft"],
      version: object["version"],
    };
  },

  _toJsonObject(self: PlanVersionSummary): any {
    return {
      created_at: self.createdAt,
      currency: self.currency,
      id: PlanVersionIdSerializer._toJsonObject(self.id),
      is_draft: self.isDraft,
      version: self.version,
    };
  },
};
