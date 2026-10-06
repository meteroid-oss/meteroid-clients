// this file is @generated
import { extraProperties } from "../json.js";
/** Every revenue line counts toward the floor. */
export interface AllComponentsScope {}

/** Converts `AllComponentsScope` values from (`parse`) and to (`serialize`) their JSON form. */
export const AllComponentsScopeSerializer = {
  parse(json: any): AllComponentsScope {
    return {
      ...extraProperties(json, []),
    };
  },

  serialize(value: AllComponentsScope): any {
    return {
      ...extraProperties(value, []),
    };
  },
};
