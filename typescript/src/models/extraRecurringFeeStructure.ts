// this file is @generated
import {
  type ExtraRecurringBillingTypeEnum,
  ExtraRecurringBillingTypeEnumSerializer,
} from "./extraRecurringBillingTypeEnum";

export interface ExtraRecurringFeeStructure {
  billingType: ExtraRecurringBillingTypeEnum;
}

export const ExtraRecurringFeeStructureSerializer = {
  _fromJsonObject(object: any): ExtraRecurringFeeStructure {
    return {
      billingType: ExtraRecurringBillingTypeEnumSerializer._fromJsonObject(
        object["billing_type"]
      ),
    };
  },

  _toJsonObject(self: ExtraRecurringFeeStructure): any {
    return {
      billing_type: ExtraRecurringBillingTypeEnumSerializer._toJsonObject(
        self.billingType
      ),
    };
  },
};
