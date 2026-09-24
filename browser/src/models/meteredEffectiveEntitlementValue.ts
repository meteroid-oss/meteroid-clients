import {
  type MeteredEntitlementSpec,
  MeteredEntitlementSpecSerializer,
} from "./meteredEntitlementSpec";
import {
  type MeteredEntitlementUsage,
  MeteredEntitlementUsageSerializer,
} from "./meteredEntitlementUsage";

export interface MeteredEffectiveEntitlementValue {
  spec: MeteredEntitlementSpec;

  usage: MeteredEntitlementUsage;
}

export const MeteredEffectiveEntitlementValueSerializer = {
  _fromJsonObject(object: any): MeteredEffectiveEntitlementValue {
    return {
      spec: MeteredEntitlementSpecSerializer._fromJsonObject(object["spec"]),
      usage: MeteredEntitlementUsageSerializer._fromJsonObject(object["usage"]),
    };
  },

  _toJsonObject(self: MeteredEffectiveEntitlementValue): any {
    return {
      spec: MeteredEntitlementSpecSerializer._toJsonObject(self.spec),
      usage: MeteredEntitlementUsageSerializer._toJsonObject(self.usage),
    };
  },
};
