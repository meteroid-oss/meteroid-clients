// this file is @generated
package com.meteroid.api;

import com.meteroid.MeteroidHttpClient;
import com.meteroid.Utils;
import com.meteroid.exceptions.ApiException;
import com.meteroid.models.CustomPropertyDefinition;
import com.meteroid.models.CustomPropertyDefinitionCreateRequest;
import com.meteroid.models.CustomPropertyDefinitionListResponse;
import com.meteroid.models.CustomPropertyDefinitionUpdateRequest;

import okhttp3.HttpUrl;

import java.io.IOException;

public class CustomProperties {
    private final MeteroidHttpClient client;

    public CustomProperties(MeteroidHttpClient client) {
        this.client = client;
    }

    /** */
    public CustomPropertyDefinitionListResponse listDefinitions() throws IOException, ApiException {

        return this.listDefinitions(new CustomPropertiesListDefinitionsOptions());
    }

    /** */
    public CustomPropertyDefinitionListResponse listDefinitions(
            final CustomPropertiesListDefinitionsOptions options) throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client.newUrlBuilder().encodedPath("/api/v1/custom-property-definitions");
        if (options.entityType != null) {
            url.addQueryParameter("entity_type", Utils.serializeQueryParam(options.entityType));
        }
        if (options.includeArchived != null) {
            url.addQueryParameter(
                    "include_archived", Utils.serializeQueryParam(options.includeArchived));
        }
        if (options.page != null) {
            url.addQueryParameter("page", Utils.serializeQueryParam(options.page));
        }
        if (options.perPage != null) {
            url.addQueryParameter("per_page", Utils.serializeQueryParam(options.perPage));
        }
        return this.client.executeRequest(
                "GET", url.build(), null, null, CustomPropertyDefinitionListResponse.class);
    }

    /** */
    public CustomPropertyDefinition createDefinition(
            final CustomPropertyDefinitionCreateRequest customPropertyDefinitionCreateRequest)
            throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client.newUrlBuilder().encodedPath("/api/v1/custom-property-definitions");
        return this.client.executeRequest(
                "POST",
                url.build(),
                null,
                customPropertyDefinitionCreateRequest,
                CustomPropertyDefinition.class);
    }

    /** */
    public CustomPropertyDefinition getDefinition(final String id)
            throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/custom-property-definitions/%s", id));
        return this.client.executeRequest(
                "GET", url.build(), null, null, CustomPropertyDefinition.class);
    }

    /** */
    public CustomPropertyDefinition updateDefinition(
            final String id,
            final CustomPropertyDefinitionUpdateRequest customPropertyDefinitionUpdateRequest)
            throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/custom-property-definitions/%s", id));
        return this.client.executeRequest(
                "PUT",
                url.build(),
                null,
                customPropertyDefinitionUpdateRequest,
                CustomPropertyDefinition.class);
    }

    /**
     * Soft-deletes the definition. Existing property values on entities are preserved; the
     * definition simply stops being enforced on new writes.
     */
    public CustomPropertyDefinition archiveDefinition(final String id)
            throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/custom-property-definitions/%s", id));
        return this.client.executeRequest(
                "DELETE", url.build(), null, null, CustomPropertyDefinition.class);
    }
}
