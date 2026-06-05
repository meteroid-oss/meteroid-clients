// this file is @generated
package com.meteroid.api;

import com.meteroid.MeteroidHttpClient;
import com.meteroid.Utils;
import com.meteroid.exceptions.ApiException;
import com.meteroid.models.AddOn;
import com.meteroid.models.AddOnListResponse;
import com.meteroid.models.CreateAddOnRequest;
import com.meteroid.models.ResolvedEntitlementListResponse;
import com.meteroid.models.UpdateAddOnRequest;

import okhttp3.HttpUrl;

import java.io.IOException;

public class AddOns {
    private final MeteroidHttpClient client;

    public AddOns(MeteroidHttpClient client) {
        this.client = client;
    }

    /** */
    public AddOnListResponse listAddons() throws IOException, ApiException {

        return this.listAddons(new AddOnsListAddonsOptions());
    }

    /** */
    public AddOnListResponse listAddons(final AddOnsListAddonsOptions options)
            throws IOException, ApiException {
        HttpUrl.Builder url = this.client.newUrlBuilder().encodedPath("/api/v1/addons");
        if (options.search != null) {
            url.addQueryParameter("search", options.search);
        }
        if (options.currency != null) {
            url.addQueryParameter("currency", options.currency);
        }
        if (options.includeArchived != null) {
            url.addQueryParameter(
                    "include_archived", Utils.serializeQueryParam(options.includeArchived));
        }
        if (options.orderBy != null) {
            url.addQueryParameter("order_by", options.orderBy);
        }
        if (options.page != null) {
            url.addQueryParameter("page", Utils.serializeQueryParam(options.page));
        }
        if (options.perPage != null) {
            url.addQueryParameter("per_page", Utils.serializeQueryParam(options.perPage));
        }
        return this.client.executeRequest("GET", url.build(), null, null, AddOnListResponse.class);
    }

    /** */
    public AddOn createAddon(final CreateAddOnRequest createAddOnRequest)
            throws IOException, ApiException {
        HttpUrl.Builder url = this.client.newUrlBuilder().encodedPath("/api/v1/addons");
        return this.client.executeRequest(
                "POST", url.build(), null, createAddOnRequest, AddOn.class);
    }

    /** */
    public AddOn getAddon(final String addonId) throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/addons/%s", addonId));
        return this.client.executeRequest("GET", url.build(), null, null, AddOn.class);
    }

    /** */
    public AddOn updateAddon(final String addonId, final UpdateAddOnRequest updateAddOnRequest)
            throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/addons/%s", addonId));
        return this.client.executeRequest(
                "PATCH", url.build(), null, updateAddOnRequest, AddOn.class);
    }

    /** */
    public void archiveAddon(final String addonId) throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/addons/%s/archive", addonId));
        this.client.executeRequest("POST", url.build(), null, null, null);
    }

    /** */
    public ResolvedEntitlementListResponse listAddOnEntitlements(final String addonId)
            throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/addons/%s/entitlements", addonId));
        return this.client.executeRequest(
                "GET", url.build(), null, null, ResolvedEntitlementListResponse.class);
    }

    /** */
    public void unarchiveAddon(final String addonId) throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/addons/%s/unarchive", addonId));
        this.client.executeRequest("POST", url.build(), null, null, null);
    }
}
