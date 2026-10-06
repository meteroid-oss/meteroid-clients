// this file is @generated
import { parseDateTime } from "../datetime.js";
import { extraProperties } from "../json.js";
import { type PlanVersionId, PlanVersionIdSerializer } from "./planVersionId.js";

export interface PlanVersionSummary {
  createdAt: Date;
  currency: string;
  id: PlanVersionId;
  isDraft: boolean;
  version: number;
}

/** Converts `PlanVersionSummary` values from (`parse`) and to (`serialize`) their JSON form. */
export const PlanVersionSummarySerializer = {
  parse(json: any): PlanVersionSummary {
    return {
      ...extraProperties(json, ["created_at", "currency", "id", "is_draft", "version"]),
      createdAt: parseDateTime(json["created_at"]),
      currency: json["currency"],
      id: PlanVersionIdSerializer.parse(json["id"]),
      isDraft: json["is_draft"],
      version: json["version"],
    };
  },

  serialize(value: PlanVersionSummary): any {
    return {
      ...extraProperties(value, ["createdAt", "currency", "id", "isDraft", "version"]),
      created_at: value.createdAt,
      currency: value.currency,
      id: PlanVersionIdSerializer.serialize(value.id),
      is_draft: value.isDraft,
      version: value.version,
    };
  },
};
