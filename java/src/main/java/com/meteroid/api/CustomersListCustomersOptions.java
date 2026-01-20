// this file is @generated
package com.meteroid.api;

import lombok.Data;

@Data
public class CustomersListCustomersOptions {
    /** Page number (0-indexed) */
    Integer page;

    /** Number of items per page */
    Integer perPage;

    String search;
    Boolean archived;
}
