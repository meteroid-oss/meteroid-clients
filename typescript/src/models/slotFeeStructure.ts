// this file is @generated
import {
  type SlotDowngradePolicyEnum,
  SlotDowngradePolicyEnumSerializer,
} from "./slotDowngradePolicyEnum";
import {
  type SlotUpgradePolicyEnum,
  SlotUpgradePolicyEnumSerializer,
} from "./slotUpgradePolicyEnum";

export interface SlotFeeStructure {
  downgradePolicy: SlotDowngradePolicyEnum;

  slotUnitName: string;

  upgradePolicy: SlotUpgradePolicyEnum;
}

export const SlotFeeStructureSerializer = {
  _fromJsonObject(object: any): SlotFeeStructure {
    return {
      downgradePolicy: SlotDowngradePolicyEnumSerializer._fromJsonObject(
        object["downgrade_policy"]
      ),
      slotUnitName: object["slot_unit_name"],
      upgradePolicy: SlotUpgradePolicyEnumSerializer._fromJsonObject(
        object["upgrade_policy"]
      ),
    };
  },

  _toJsonObject(self: SlotFeeStructure): any {
    return {
      downgrade_policy: SlotDowngradePolicyEnumSerializer._toJsonObject(
        self.downgradePolicy
      ),
      slot_unit_name: self.slotUnitName,
      upgrade_policy: SlotUpgradePolicyEnumSerializer._toJsonObject(self.upgradePolicy),
    };
  },
};
