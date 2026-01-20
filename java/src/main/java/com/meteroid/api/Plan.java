// this file is @generated
package com.meteroid.api;

import com.meteroid.MeteroidHttpClient;
import com.meteroid.Utils;
import com.meteroid.exceptions.ApiException;
import com.meteroid.models.PlanListResponse;

import okhttp3.HttpUrl;

import java.io.IOException;

public class Plan {
    private final MeteroidHttpClient client;

    public Plan(MeteroidHttpClient client) {
        this.client = client;
    }

    /** List plans with optional filtering by product family. */
    public PlanListResponse listPlans() throws IOException, ApiException {

        return this.listPlans(new PlanListPlansOptions());
    }

    /** List plans with optional filtering by product family. */
    public PlanListResponse listPlans(final PlanListPlansOptions options)
            throws IOException, ApiException {
        HttpUrl.Builder url = this.client.newUrlBuilder().encodedPath("/api/v1/plans");
        if (options.productFamilyId != null) {
            url.addQueryParameter(
                    "product_family_id", Utils.serializeQueryParam(options.productFamilyId));
        }
        if (options.page != null) {
            url.addQueryParameter("page", Utils.serializeQueryParam(options.page));
        }
        if (options.perPage != null) {
            url.addQueryParameter("per_page", Utils.serializeQueryParam(options.perPage));
        }
        return this.client.executeRequest("GET", url.build(), null, null, PlanListResponse.class);
    }

    /** Retrieve the details of a specific plan */
    public Plan getPlanDetails(final String planId) throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client.newUrlBuilder().encodedPath(String.format("/api/v1/plans/%s", planId));
        return this.client.executeRequest("GET", url.build(), null, null, Plan.class);
    }
}
