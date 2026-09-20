// this file is @generated
import { type AddOnId, AddOnIdSerializer } from "./addOnId";
import {
  type SubscriptionAddOnCustomization,
  SubscriptionAddOnCustomizationSerializer,
} from "./subscriptionAddOnCustomization";

export interface CreateSubscriptionAddOn {
  addOnId: AddOnId;

  customization?: SubscriptionAddOnCustomization | null;

  quantity?: number;
}

export const CreateSubscriptionAddOnSerializer = {
  _fromJsonObject(object: any): CreateSubscriptionAddOn {
    return {
      addOnId: AddOnIdSerializer._fromJsonObject(object["add_on_id"]),
      customization:
        object["customization"] != null
          ? SubscriptionAddOnCustomizationSerializer._fromJsonObject(
              object["customization"]
            )
          : undefined,
      quantity: object["quantity"],
    };
  },

  _toJsonObject(self: CreateSubscriptionAddOn): any {
    return {
      add_on_id: AddOnIdSerializer._toJsonObject(self.addOnId),
      customization:
        self.customization != null
          ? SubscriptionAddOnCustomizationSerializer._toJsonObject(self.customization)
          : undefined,
      quantity: self.quantity,
    };
  },
};
