// this file is @generated
import { extraProperties } from "../json.js";
/** One rule the document did not satisfy, in the standard's own vocabulary. */
export interface EInvoicingFinding {
  hint?: string | null | undefined;
  message: string;
  /** The rule identifier — "BR-11", "PEPPOL-EN16931-R003". */
  rule: string;
  /** The business term path it is about — "BG-8/BT-55". */
  term: string;
}

/** Converts `EInvoicingFinding` values from (`parse`) and to (`serialize`) their JSON form. */
export const EInvoicingFindingSerializer = {
  parse(json: any): EInvoicingFinding {
    return {
      ...extraProperties(json, ["hint", "message", "rule", "term"]),
      hint: json["hint"],
      message: json["message"],
      rule: json["rule"],
      term: json["term"],
    };
  },

  serialize(value: EInvoicingFinding): any {
    return {
      ...extraProperties(value, ["hint", "message", "rule", "term"]),
      hint: value.hint,
      message: value.message,
      rule: value.rule,
      term: value.term,
    };
  },
};
