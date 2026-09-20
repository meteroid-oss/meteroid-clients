// this file is @generated
/** One rule the document did not satisfy, in the standard's own vocabulary. */
export interface EInvoicingFinding {
  hint?: string | null;

  message: string;

  /** The rule identifier — "BR-11", "PEPPOL-EN16931-R003". */
  rule: string;

  /** The business term path it is about — "BG-8/BT-55". */
  term: string;
}

export const EInvoicingFindingSerializer = {
  _fromJsonObject(object: any): EInvoicingFinding {
    return {
      hint: object["hint"],
      message: object["message"],
      rule: object["rule"],
      term: object["term"],
    };
  },

  _toJsonObject(self: EInvoicingFinding): any {
    return {
      hint: self.hint,
      message: self.message,
      rule: self.rule,
      term: self.term,
    };
  },
};
