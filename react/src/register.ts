/**
 * Augment to type feature codes, e.g.
 * `declare module "@meteroid/react" { interface Register { featureCode: "sso" | "api_calls" } }`
 */
// biome-ignore lint/suspicious/noEmptyInterface: filled in by module augmentation
export interface Register {}

/** A feature code: any string, or the codes declared in `Register`. */
export type FeatureCode = Register extends { featureCode: infer T extends string }
  ? T
  : string;
