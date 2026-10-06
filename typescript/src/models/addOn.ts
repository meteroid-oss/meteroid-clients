// this file is @generated
import { parseDateTime } from "../datetime.js";
import { extraProperties } from "../json.js";
import { type AddOnId, AddOnIdSerializer } from "./addOnId.js";
import { type Entitlement, EntitlementSerializer } from "./entitlement.js";
import { type PriceId, PriceIdSerializer } from "./priceId.js";
import {
  type ProductFeeTypeEnum,
  ProductFeeTypeEnumSerializer,
} from "./productFeeTypeEnum.js";
import { type ProductId, ProductIdSerializer } from "./productId.js";

export interface AddOn {
  archivedAt?: Date | null | undefined;
  createdAt: Date;
  description?: string | null | undefined;
  entitlements?: Entitlement[] | undefined;
  feeType?: ProductFeeTypeEnum | null | undefined;
  id: AddOnId;
  maxInstancesPerSubscription?: number | null | undefined;
  name: string;
  priceId: PriceId;
  productId: ProductId;
  selfServiceable: boolean;
}

/** Converts `AddOn` values from (`parse`) and to (`serialize`) their JSON form. */
export const AddOnSerializer = {
  parse(json: any): AddOn {
    return {
      ...extraProperties(json, [
        "archived_at",
        "created_at",
        "description",
        "entitlements",
        "fee_type",
        "id",
        "max_instances_per_subscription",
        "name",
        "price_id",
        "product_id",
        "self_serviceable",
      ]),
      archivedAt:
        json["archived_at"] != null
          ? parseDateTime(json["archived_at"])
          : json["archived_at"],
      createdAt: parseDateTime(json["created_at"]),
      description: json["description"],
      entitlements:
        json["entitlements"] != null
          ? json["entitlements"].map((item: any) => EntitlementSerializer.parse(item))
          : undefined,
      feeType:
        json["fee_type"] != null
          ? ProductFeeTypeEnumSerializer.parse(json["fee_type"])
          : json["fee_type"],
      id: AddOnIdSerializer.parse(json["id"]),
      maxInstancesPerSubscription: json["max_instances_per_subscription"],
      name: json["name"],
      priceId: PriceIdSerializer.parse(json["price_id"]),
      productId: ProductIdSerializer.parse(json["product_id"]),
      selfServiceable: json["self_serviceable"],
    };
  },

  serialize(value: AddOn): any {
    return {
      ...extraProperties(value, [
        "archivedAt",
        "createdAt",
        "description",
        "entitlements",
        "feeType",
        "id",
        "maxInstancesPerSubscription",
        "name",
        "priceId",
        "productId",
        "selfServiceable",
      ]),
      archived_at: value.archivedAt,
      created_at: value.createdAt,
      description: value.description,
      entitlements:
        value.entitlements != null
          ? value.entitlements.map((item: any) => EntitlementSerializer.serialize(item))
          : undefined,
      fee_type:
        value.feeType != null
          ? ProductFeeTypeEnumSerializer.serialize(value.feeType)
          : value.feeType,
      id: AddOnIdSerializer.serialize(value.id),
      max_instances_per_subscription: value.maxInstancesPerSubscription,
      name: value.name,
      price_id: PriceIdSerializer.serialize(value.priceId),
      product_id: ProductIdSerializer.serialize(value.productId),
      self_serviceable: value.selfServiceable,
    };
  },
};
