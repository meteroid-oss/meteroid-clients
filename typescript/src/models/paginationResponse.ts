// this file is @generated

export interface PaginationResponse {
  page: number;

  perPage: number;

  totalItems: number;

  totalPages: number;
}

export const PaginationResponseSerializer = {
  _fromJsonObject(object: any): PaginationResponse {
    return {
      page: object["page"],
      perPage: object["per_page"],
      totalItems: object["total_items"],
      totalPages: object["total_pages"],
    };
  },

  _toJsonObject(self: PaginationResponse): any {
    return {
      page: self.page,
      per_page: self.perPage,
      total_items: self.totalItems,
      total_pages: self.totalPages,
    };
  },
};
