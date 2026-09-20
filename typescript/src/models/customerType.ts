// this file is @generated
/** Company vs. individual (B2C). Defaults to `COMPANY`. */
export enum CustomerType {
  Company = "COMPANY",
  Individual = "INDIVIDUAL",
}

export const CustomerTypeSerializer = {
  _fromJsonObject(object: any): CustomerType {
    return object;
  },

  _toJsonObject(self: CustomerType): any {
    return self;
  },
};
