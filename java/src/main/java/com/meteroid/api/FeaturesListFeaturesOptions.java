// this file is @generated
package com.meteroid.api;

import com.meteroid.models.FeatureStatus;

import lombok.Data;

import java.util.List;

@Data
public class FeaturesListFeaturesOptions {
    /** Filter by feature status. Repeat the param to select multiple, omit to return all. */
    List<FeatureStatus> statuses;

    /** Filter by product. Omit to return features across all products. */
    String productId;

    /** Search by feature name. */
    String search;

    /** Page number (0-indexed) */
    Integer page;

    /** Number of items per page */
    Integer perPage;
}
