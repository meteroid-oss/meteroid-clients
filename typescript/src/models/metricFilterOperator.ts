// this file is @generated
/**
 * Operator of a pre-aggregation [`MetricFilter`]. `EQUAL`/`NOT_EQUAL` are the single-value
 * forms of `IN`/`NOT_IN`. Negation (`NOT_EQUAL`/`NOT_IN`) is presence-required: an event
 * missing the property is excluded.
 */
export const MetricFilterOperator = {
  Equal: "EQUAL",
  NotEqual: "NOT_EQUAL",
  In: "IN",
  NotIn: "NOT_IN",
} as const;
export type MetricFilterOperator =
  | (typeof MetricFilterOperator)[keyof typeof MetricFilterOperator]
  | (string & {});

/** Converts `MetricFilterOperator` values from (`parse`) and to (`serialize`) their JSON form. */
export const MetricFilterOperatorSerializer = {
  parse(json: any): MetricFilterOperator {
    return json;
  },

  serialize(value: MetricFilterOperator): any {
    return value;
  },
};
