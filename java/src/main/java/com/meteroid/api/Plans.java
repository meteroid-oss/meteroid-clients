// this file is @generated
package com.meteroid.api;

import com.meteroid.MeteroidHttpClient;
import com.meteroid.Utils;
import com.meteroid.exceptions.ApiException;
import com.meteroid.models.CreatePlanRequest;
import com.meteroid.models.PatchPlanRequest;
import com.meteroid.models.Plan;
import com.meteroid.models.PlanVersionListResponse;
import com.meteroid.models.ReplacePlanRequest;

import okhttp3.HttpUrl;

import java.io.IOException;

public class Plans {
    private final MeteroidHttpClient client;

    public Plans(MeteroidHttpClient client) {
        this.client = client;
    }

    /**
     * Create a new plan with components and pricing. Set `status` to `ACTIVE` to publish
     * immediately, or `DRAFT` to stage for review.
     */
    public Plan createPlan(final CreatePlanRequest createPlanRequest)
            throws IOException, ApiException {
        HttpUrl.Builder url = this.client.newUrlBuilder().encodedPath("/api/v1/plans");
        return this.client.executeRequest("POST", url.build(), null, createPlanRequest, Plan.class);
    }

    /**
     * Retrieve a specific plan. Use `?version=draft` for the draft version, `?version=2` for a
     * specific version number, or omit for the active version.
     */
    public Plan getPlanDetails(final String planId) throws IOException, ApiException {
        return this.getPlanDetails(planId, new PlansGetPlanDetailsOptions());
    }

    /**
     * Retrieve a specific plan. Use `?version=draft` for the draft version, `?version=2` for a
     * specific version number, or omit for the active version.
     */
    public Plan getPlanDetails(final String planId, final PlansGetPlanDetailsOptions options)
            throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client.newUrlBuilder().encodedPath(String.format("/api/v1/plans/%s", planId));
        if (options.version != null) {
            url.addQueryParameter("version", options.version);
        }
        return this.client.executeRequest("GET", url.build(), null, null, Plan.class);
    }

    /**
     * Full replacement of a plan's version. On a draft plan, updates in-place. On a published plan,
     * creates a new version. Set `status` to `DRAFT` to stage as a new draft without publishing.
     */
    public Plan replacePlan(final String planId, final ReplacePlanRequest replacePlanRequest)
            throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client.newUrlBuilder().encodedPath(String.format("/api/v1/plans/%s", planId));
        return this.client.executeRequest("PUT", url.build(), null, replacePlanRequest, Plan.class);
    }

    /**
     * Partially update plan-level fields (name, description, self_service_rank). Does not modify
     * version-level configuration or components.
     */
    public Plan patchPlan(final String planId, final PatchPlanRequest patchPlanRequest)
            throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client.newUrlBuilder().encodedPath(String.format("/api/v1/plans/%s", planId));
        return this.client.executeRequest("PATCH", url.build(), null, patchPlanRequest, Plan.class);
    }

    /** */
    public void archivePlan(final String planId) throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/plans/%s/archive", planId));
        this.client.executeRequest("POST", url.build(), null, null, null);
    }

    /** Publishes the current draft version, making it the active version. */
    public Plan publishPlan(final String planId) throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/plans/%s/publish", planId));
        return this.client.executeRequest("POST", url.build(), null, null, Plan.class);
    }

    /** */
    public void unarchivePlan(final String planId) throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/plans/%s/unarchive", planId));
        this.client.executeRequest("POST", url.build(), null, null, null);
    }

    /** */
    public PlanVersionListResponse listPlanVersions(final String planId)
            throws IOException, ApiException {
        return this.listPlanVersions(planId, new PlansListPlanVersionsOptions());
    }

    /** */
    public PlanVersionListResponse listPlanVersions(
            final String planId, final PlansListPlanVersionsOptions options)
            throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/plans/%s/versions", planId));
        if (options.page != null) {
            url.addQueryParameter("page", Utils.serializeQueryParam(options.page));
        }
        if (options.perPage != null) {
            url.addQueryParameter("per_page", Utils.serializeQueryParam(options.perPage));
        }
        return this.client.executeRequest(
                "GET", url.build(), null, null, PlanVersionListResponse.class);
    }
}
