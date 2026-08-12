// this file is @generated
package com.meteroid.api;

import com.meteroid.models.CustomPropertyEntityType;

import lombok.Data;

@Data
public class CustomPropertiesListDefinitionsOptions {
    /** Filter to a single entity type. */
    CustomPropertyEntityType entityType;

    /** Include archived (soft-deleted) definitions. Defaults to false. */
    Boolean includeArchived;

    /** Page number (0-indexed) */
    Integer page;

    /** Number of items per page */
    Integer perPage;
}
