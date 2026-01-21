// this file is @generated
package com.meteroid.api;

import lombok.Data;

@Data
public class PlansListPlansOptions {
    String productFamilyId;

    /** Page number (0-indexed) */
    Integer page;

    /** Number of items per page */
    Integer perPage;
}
