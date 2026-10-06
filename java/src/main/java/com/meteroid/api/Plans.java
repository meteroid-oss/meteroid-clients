// this file is @generated
package com.meteroid.api;

import com.meteroid.ApiResponse;
import com.meteroid.RequestOptions;
import com.meteroid.internal.MeteroidHttpClient;
import com.meteroid.internal.Utils;
import com.meteroid.models.CreatePlanRequest;
import com.meteroid.models.MinimumCommitment;
import com.meteroid.models.PatchPlanRequest;
import com.meteroid.models.Plan;
import com.meteroid.models.PlanListResponse;
import com.meteroid.models.PlanStatusEnum;
import com.meteroid.models.PlanTypeEnum;
import com.meteroid.models.PlanVersionListResponse;
import com.meteroid.models.ReplacePlanRequest;
import com.meteroid.models.ResolvedEntitlementListResponse;

import okhttp3.HttpUrl;

import java.util.List;
import java.util.Objects;

/**
 * The {@code plans} operations, blocking. {@link #withRawResponse()} has the same methods returning
 * the status and headers along with the body.
 */
public final class Plans {
    private final MeteroidHttpClient client;
    private final WithRawResponse withRawResponse;

    /**
     * The operations, sending through {@code client}.
     *
     * @param client the HTTP client of the SDK
     */
    public Plans(MeteroidHttpClient client) {
        this.client = client;
        this.withRawResponse = new WithRawResponse();
    }

    /**
     * The same operations, returning the status and headers along with the body.
     *
     * @return the operations
     */
    public WithRawResponse withRawResponse() {
        return withRawResponse;
    }

    /**
     * List plan version entitlements
     *
     * @param planVersionId the {@code plan_version_id} path parameter
     * @return the response body
     */
    public ResolvedEntitlementListResponse listPlanVersionEntitlements(final String planVersionId) {
        return listPlanVersionEntitlements(planVersionId, RequestOptions.none());
    }

    /**
     * List plan version entitlements
     *
     * @param planVersionId the {@code plan_version_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public ResolvedEntitlementListResponse listPlanVersionEntitlements(
            final String planVersionId, final RequestOptions requestOptions) {
        return exchangeListPlanVersionEntitlements(planVersionId, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<ResolvedEntitlementListResponse>
            exchangeListPlanVersionEntitlements(
                    final String planVersionId, final RequestOptions requestOptions) {
        Objects.requireNonNull(planVersionId, "plan_version_id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/plan-versions")
                        .addPathSegment(Utils.pathSegment("plan_version_id", planVersionId))
                        .addPathSegments("entitlements")
                        .build();
        return client.call("GET", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "429")
                .options(requestOptions)
                .returning(ResolvedEntitlementListResponse.class);
    }

    /**
     * List plans
     *
     * @return the response body
     */
    public PlanListResponse list() {
        return list(PlansListOptions.none(), RequestOptions.none());
    }

    /**
     * List plans
     *
     * @param options the optional parameters
     * @return the response body
     */
    public PlanListResponse list(final PlansListOptions options) {
        return list(options, RequestOptions.none());
    }

    /**
     * List plans
     *
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public PlanListResponse list(final RequestOptions requestOptions) {
        return list(PlansListOptions.none(), requestOptions);
    }

    /**
     * List plans
     *
     * @param options the optional parameters
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public PlanListResponse list(
            final PlansListOptions options, final RequestOptions requestOptions) {
        return exchangeList(options, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<PlanListResponse> exchangeList(
            final PlansListOptions options, final RequestOptions requestOptions) {
        Objects.requireNonNull(options, "options");
        HttpUrl.Builder url = client.newUrlBuilder().addPathSegments("api/v1/plans");
        String value1 = options.productFamilyId().orElse(null);
        if (value1 != null) {
            url.addQueryParameter("product_family_id", value1);
        }
        String value2 = options.search().orElse(null);
        if (value2 != null) {
            url.addQueryParameter("search", value2);
        }
        List<PlanStatusEnum> value3 = options.status().orElse(null);
        if (value3 != null) {
            Utils.addExplodedQueryParameter(url, "status", value3);
        }
        List<PlanTypeEnum> value4 = options.planType().orElse(null);
        if (value4 != null) {
            Utils.addExplodedQueryParameter(url, "plan_type", value4);
        }
        String value5 = options.orderBy().orElse(null);
        if (value5 != null) {
            url.addQueryParameter("order_by", value5);
        }
        Integer value6 = options.page().orElse(null);
        if (value6 != null) {
            url.addQueryParameter("page", Utils.serializeQueryParam(value6));
        }
        Integer value7 = options.perPage().orElse(null);
        if (value7 != null) {
            url.addQueryParameter("per_page", Utils.serializeQueryParam(value7));
        }
        return client.call("GET", url.build())
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "429")
                .options(requestOptions)
                .returning(PlanListResponse.class);
    }

    /**
     * Create a plan
     *
     * <p>Create a new plan with components and pricing. Set <code>status</code> to <code>ACTIVE
     * </code> to publish immediately, or <code>DRAFT</code> to stage for review.
     *
     * @param createPlanRequest the request body
     * @return the response body
     */
    public Plan create(final CreatePlanRequest createPlanRequest) {
        return create(createPlanRequest, RequestOptions.none());
    }

    /**
     * Create a plan
     *
     * <p>Create a new plan with components and pricing. Set <code>status</code> to <code>ACTIVE
     * </code> to publish immediately, or <code>DRAFT</code> to stage for review.
     *
     * @param createPlanRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public Plan create(
            final CreatePlanRequest createPlanRequest, final RequestOptions requestOptions) {
        return exchangeCreate(createPlanRequest, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Plan> exchangeCreate(
            final CreatePlanRequest createPlanRequest, final RequestOptions requestOptions) {
        Objects.requireNonNull(createPlanRequest, "body");
        HttpUrl url = client.newUrlBuilder().addPathSegments("api/v1/plans").build();
        return client.call("POST", url)
                .json(createPlanRequest)
                .errors(com.meteroid.models.RestErrorResponse.class, "400", "401", "409", "429")
                .options(requestOptions)
                .returning(Plan.class);
    }

    /**
     * Set or replace the plan-level minimum commitment for a draft plan version.
     *
     * @param planVersionId the {@code plan_version_id} path parameter
     * @param minimumCommitment the request body
     * @return the response body
     */
    public MinimumCommitment updateVersionMinimum(
            final String planVersionId, final MinimumCommitment minimumCommitment) {
        return updateVersionMinimum(planVersionId, minimumCommitment, RequestOptions.none());
    }

    /**
     * Set or replace the plan-level minimum commitment for a draft plan version.
     *
     * @param planVersionId the {@code plan_version_id} path parameter
     * @param minimumCommitment the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public MinimumCommitment updateVersionMinimum(
            final String planVersionId,
            final MinimumCommitment minimumCommitment,
            final RequestOptions requestOptions) {
        return exchangeUpdateVersionMinimum(planVersionId, minimumCommitment, requestOptions)
                .send();
    }

    MeteroidHttpClient.Exchange<MinimumCommitment> exchangeUpdateVersionMinimum(
            final String planVersionId,
            final MinimumCommitment minimumCommitment,
            final RequestOptions requestOptions) {
        Objects.requireNonNull(planVersionId, "plan_version_id");
        Objects.requireNonNull(minimumCommitment, "body");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/plans/versions")
                        .addPathSegment(Utils.pathSegment("plan_version_id", planVersionId))
                        .addPathSegments("minimum")
                        .build();
        return client.call("PUT", url)
                .json(minimumCommitment)
                .errors(com.meteroid.models.RestErrorResponse.class, "400", "401", "404", "429")
                .options(requestOptions)
                .returning(MinimumCommitment.class);
    }

    /**
     * Remove the plan-level minimum commitment for a draft plan version.
     *
     * @param planVersionId the {@code plan_version_id} path parameter
     */
    public void deleteVersionMinimum(final String planVersionId) {
        deleteVersionMinimum(planVersionId, RequestOptions.none());
    }

    /**
     * Remove the plan-level minimum commitment for a draft plan version.
     *
     * @param planVersionId the {@code plan_version_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     */
    public void deleteVersionMinimum(
            final String planVersionId, final RequestOptions requestOptions) {
        exchangeDeleteVersionMinimum(planVersionId, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Void> exchangeDeleteVersionMinimum(
            final String planVersionId, final RequestOptions requestOptions) {
        Objects.requireNonNull(planVersionId, "plan_version_id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/plans/versions")
                        .addPathSegment(Utils.pathSegment("plan_version_id", planVersionId))
                        .addPathSegments("minimum")
                        .build();
        return client.call("DELETE", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "429")
                .options(requestOptions)
                .returningNothing();
    }

    /**
     * Get plan details
     *
     * <p>Retrieve a specific plan. Use <code>?version=draft</code> for the draft version, <code>
     * ?version=2</code> for a specific version number, or omit for the active version.
     *
     * @param planId the {@code plan_id} path parameter
     * @return the response body
     */
    public Plan retrieve(final String planId) {
        return retrieve(planId, PlansRetrieveOptions.none(), RequestOptions.none());
    }

    /**
     * Get plan details
     *
     * <p>Retrieve a specific plan. Use <code>?version=draft</code> for the draft version, <code>
     * ?version=2</code> for a specific version number, or omit for the active version.
     *
     * @param planId the {@code plan_id} path parameter
     * @param options the optional parameters
     * @return the response body
     */
    public Plan retrieve(final String planId, final PlansRetrieveOptions options) {
        return retrieve(planId, options, RequestOptions.none());
    }

    /**
     * Get plan details
     *
     * <p>Retrieve a specific plan. Use <code>?version=draft</code> for the draft version, <code>
     * ?version=2</code> for a specific version number, or omit for the active version.
     *
     * @param planId the {@code plan_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public Plan retrieve(final String planId, final RequestOptions requestOptions) {
        return retrieve(planId, PlansRetrieveOptions.none(), requestOptions);
    }

    /**
     * Get plan details
     *
     * <p>Retrieve a specific plan. Use <code>?version=draft</code> for the draft version, <code>
     * ?version=2</code> for a specific version number, or omit for the active version.
     *
     * @param planId the {@code plan_id} path parameter
     * @param options the optional parameters
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public Plan retrieve(
            final String planId,
            final PlansRetrieveOptions options,
            final RequestOptions requestOptions) {
        return exchangeRetrieve(planId, options, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Plan> exchangeRetrieve(
            final String planId,
            final PlansRetrieveOptions options,
            final RequestOptions requestOptions) {
        Objects.requireNonNull(planId, "plan_id");
        Objects.requireNonNull(options, "options");
        HttpUrl.Builder url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/plans")
                        .addPathSegment(Utils.pathSegment("plan_id", planId));
        String value1 = options.version().orElse(null);
        if (value1 != null) {
            url.addQueryParameter("version", value1);
        }
        return client.call("GET", url.build())
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "429")
                .options(requestOptions)
                .returning(Plan.class);
    }

    /**
     * Replace a plan
     *
     * <p>Full replacement of a plan's version. On a draft plan, updates in-place. On a published
     * plan, creates a new version. Set <code>status</code> to <code>DRAFT</code> to stage as a new
     * draft without publishing.
     *
     * @param planId the {@code plan_id} path parameter
     * @param replacePlanRequest the request body
     * @return the response body
     */
    public Plan replace(final String planId, final ReplacePlanRequest replacePlanRequest) {
        return replace(planId, replacePlanRequest, RequestOptions.none());
    }

    /**
     * Replace a plan
     *
     * <p>Full replacement of a plan's version. On a draft plan, updates in-place. On a published
     * plan, creates a new version. Set <code>status</code> to <code>DRAFT</code> to stage as a new
     * draft without publishing.
     *
     * @param planId the {@code plan_id} path parameter
     * @param replacePlanRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public Plan replace(
            final String planId,
            final ReplacePlanRequest replacePlanRequest,
            final RequestOptions requestOptions) {
        return exchangeReplace(planId, replacePlanRequest, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Plan> exchangeReplace(
            final String planId,
            final ReplacePlanRequest replacePlanRequest,
            final RequestOptions requestOptions) {
        Objects.requireNonNull(planId, "plan_id");
        Objects.requireNonNull(replacePlanRequest, "body");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/plans")
                        .addPathSegment(Utils.pathSegment("plan_id", planId))
                        .build();
        return client.call("PUT", url)
                .json(replacePlanRequest)
                .errors(com.meteroid.models.RestErrorResponse.class, "400", "401", "404", "429")
                .options(requestOptions)
                .returning(Plan.class);
    }

    /**
     * Update plan metadata
     *
     * <p>Partially update plan-level fields (name, description, self_service_rank). Does not modify
     * version-level configuration or components.
     *
     * @param planId the {@code plan_id} path parameter
     * @param patchPlanRequest the request body
     * @return the response body
     */
    public Plan update(final String planId, final PatchPlanRequest patchPlanRequest) {
        return update(planId, patchPlanRequest, RequestOptions.none());
    }

    /**
     * Update plan metadata
     *
     * <p>Partially update plan-level fields (name, description, self_service_rank). Does not modify
     * version-level configuration or components.
     *
     * @param planId the {@code plan_id} path parameter
     * @param patchPlanRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public Plan update(
            final String planId,
            final PatchPlanRequest patchPlanRequest,
            final RequestOptions requestOptions) {
        return exchangeUpdate(planId, patchPlanRequest, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Plan> exchangeUpdate(
            final String planId,
            final PatchPlanRequest patchPlanRequest,
            final RequestOptions requestOptions) {
        Objects.requireNonNull(planId, "plan_id");
        Objects.requireNonNull(patchPlanRequest, "body");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/plans")
                        .addPathSegment(Utils.pathSegment("plan_id", planId))
                        .build();
        return client.call("PATCH", url)
                .json(patchPlanRequest)
                .errors(com.meteroid.models.RestErrorResponse.class, "400", "401", "404", "429")
                .options(requestOptions)
                .returning(Plan.class);
    }

    /**
     * Archive a plan
     *
     * @param planId the {@code plan_id} path parameter
     */
    public void archive(final String planId) {
        archive(planId, RequestOptions.none());
    }

    /**
     * Archive a plan
     *
     * @param planId the {@code plan_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     */
    public void archive(final String planId, final RequestOptions requestOptions) {
        exchangeArchive(planId, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Void> exchangeArchive(
            final String planId, final RequestOptions requestOptions) {
        Objects.requireNonNull(planId, "plan_id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/plans")
                        .addPathSegment(Utils.pathSegment("plan_id", planId))
                        .addPathSegments("archive")
                        .build();
        return client.call("POST", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "429")
                .options(requestOptions)
                .returningNothing();
    }

    /**
     * Publish a draft plan version
     *
     * <p>Publishes the current draft version, making it the active version.
     *
     * @param planId the {@code plan_id} path parameter
     * @return the response body
     */
    public Plan publish(final String planId) {
        return publish(planId, RequestOptions.none());
    }

    /**
     * Publish a draft plan version
     *
     * <p>Publishes the current draft version, making it the active version.
     *
     * @param planId the {@code plan_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public Plan publish(final String planId, final RequestOptions requestOptions) {
        return exchangePublish(planId, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Plan> exchangePublish(
            final String planId, final RequestOptions requestOptions) {
        Objects.requireNonNull(planId, "plan_id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/plans")
                        .addPathSegment(Utils.pathSegment("plan_id", planId))
                        .addPathSegments("publish")
                        .build();
        return client.call("POST", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "409", "429")
                .options(requestOptions)
                .returning(Plan.class);
    }

    /**
     * Unarchive a plan
     *
     * @param planId the {@code plan_id} path parameter
     */
    public void unarchive(final String planId) {
        unarchive(planId, RequestOptions.none());
    }

    /**
     * Unarchive a plan
     *
     * @param planId the {@code plan_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     */
    public void unarchive(final String planId, final RequestOptions requestOptions) {
        exchangeUnarchive(planId, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Void> exchangeUnarchive(
            final String planId, final RequestOptions requestOptions) {
        Objects.requireNonNull(planId, "plan_id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/plans")
                        .addPathSegment(Utils.pathSegment("plan_id", planId))
                        .addPathSegments("unarchive")
                        .build();
        return client.call("POST", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "429")
                .options(requestOptions)
                .returningNothing();
    }

    /**
     * List plan versions
     *
     * @param planId the {@code plan_id} path parameter
     * @return the response body
     */
    public PlanVersionListResponse listVersions(final String planId) {
        return listVersions(planId, PlansListVersionsOptions.none(), RequestOptions.none());
    }

    /**
     * List plan versions
     *
     * @param planId the {@code plan_id} path parameter
     * @param options the optional parameters
     * @return the response body
     */
    public PlanVersionListResponse listVersions(
            final String planId, final PlansListVersionsOptions options) {
        return listVersions(planId, options, RequestOptions.none());
    }

    /**
     * List plan versions
     *
     * @param planId the {@code plan_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public PlanVersionListResponse listVersions(
            final String planId, final RequestOptions requestOptions) {
        return listVersions(planId, PlansListVersionsOptions.none(), requestOptions);
    }

    /**
     * List plan versions
     *
     * @param planId the {@code plan_id} path parameter
     * @param options the optional parameters
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public PlanVersionListResponse listVersions(
            final String planId,
            final PlansListVersionsOptions options,
            final RequestOptions requestOptions) {
        return exchangeListVersions(planId, options, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<PlanVersionListResponse> exchangeListVersions(
            final String planId,
            final PlansListVersionsOptions options,
            final RequestOptions requestOptions) {
        Objects.requireNonNull(planId, "plan_id");
        Objects.requireNonNull(options, "options");
        HttpUrl.Builder url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/plans")
                        .addPathSegment(Utils.pathSegment("plan_id", planId))
                        .addPathSegments("versions");
        Integer value1 = options.page().orElse(null);
        if (value1 != null) {
            url.addQueryParameter("page", Utils.serializeQueryParam(value1));
        }
        Integer value2 = options.perPage().orElse(null);
        if (value2 != null) {
            url.addQueryParameter("per_page", Utils.serializeQueryParam(value2));
        }
        return client.call("GET", url.build())
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "429")
                .options(requestOptions)
                .returning(PlanVersionListResponse.class);
    }

    /** The operations, returning the status and headers along with the body. */
    public final class WithRawResponse {
        private WithRawResponse() {}

        /**
         * List plan version entitlements
         *
         * @param planVersionId the {@code plan_version_id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<ResolvedEntitlementListResponse> listPlanVersionEntitlements(
                final String planVersionId) {
            return listPlanVersionEntitlements(planVersionId, RequestOptions.none());
        }

        /**
         * List plan version entitlements
         *
         * @param planVersionId the {@code plan_version_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<ResolvedEntitlementListResponse> listPlanVersionEntitlements(
                final String planVersionId, final RequestOptions requestOptions) {
            return Plans.this
                    .exchangeListPlanVersionEntitlements(planVersionId, requestOptions)
                    .sendRaw();
        }

        /**
         * List plans
         *
         * @return the status, headers and body
         */
        public ApiResponse<PlanListResponse> list() {
            return list(PlansListOptions.none(), RequestOptions.none());
        }

        /**
         * List plans
         *
         * @param options the optional parameters
         * @return the status, headers and body
         */
        public ApiResponse<PlanListResponse> list(final PlansListOptions options) {
            return list(options, RequestOptions.none());
        }

        /**
         * List plans
         *
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<PlanListResponse> list(final RequestOptions requestOptions) {
            return list(PlansListOptions.none(), requestOptions);
        }

        /**
         * List plans
         *
         * @param options the optional parameters
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<PlanListResponse> list(
                final PlansListOptions options, final RequestOptions requestOptions) {
            return Plans.this.exchangeList(options, requestOptions).sendRaw();
        }

        /**
         * Create a plan
         *
         * <p>Create a new plan with components and pricing. Set <code>status</code> to <code>ACTIVE
         * </code> to publish immediately, or <code>DRAFT</code> to stage for review.
         *
         * @param createPlanRequest the request body
         * @return the status, headers and body
         */
        public ApiResponse<Plan> create(final CreatePlanRequest createPlanRequest) {
            return create(createPlanRequest, RequestOptions.none());
        }

        /**
         * Create a plan
         *
         * <p>Create a new plan with components and pricing. Set <code>status</code> to <code>ACTIVE
         * </code> to publish immediately, or <code>DRAFT</code> to stage for review.
         *
         * @param createPlanRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Plan> create(
                final CreatePlanRequest createPlanRequest, final RequestOptions requestOptions) {
            return Plans.this.exchangeCreate(createPlanRequest, requestOptions).sendRaw();
        }

        /**
         * Set or replace the plan-level minimum commitment for a draft plan version.
         *
         * @param planVersionId the {@code plan_version_id} path parameter
         * @param minimumCommitment the request body
         * @return the status, headers and body
         */
        public ApiResponse<MinimumCommitment> updateVersionMinimum(
                final String planVersionId, final MinimumCommitment minimumCommitment) {
            return updateVersionMinimum(planVersionId, minimumCommitment, RequestOptions.none());
        }

        /**
         * Set or replace the plan-level minimum commitment for a draft plan version.
         *
         * @param planVersionId the {@code plan_version_id} path parameter
         * @param minimumCommitment the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<MinimumCommitment> updateVersionMinimum(
                final String planVersionId,
                final MinimumCommitment minimumCommitment,
                final RequestOptions requestOptions) {
            return Plans.this
                    .exchangeUpdateVersionMinimum(planVersionId, minimumCommitment, requestOptions)
                    .sendRaw();
        }

        /**
         * Remove the plan-level minimum commitment for a draft plan version.
         *
         * @param planVersionId the {@code plan_version_id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<Void> deleteVersionMinimum(final String planVersionId) {
            return deleteVersionMinimum(planVersionId, RequestOptions.none());
        }

        /**
         * Remove the plan-level minimum commitment for a draft plan version.
         *
         * @param planVersionId the {@code plan_version_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Void> deleteVersionMinimum(
                final String planVersionId, final RequestOptions requestOptions) {
            return Plans.this.exchangeDeleteVersionMinimum(planVersionId, requestOptions).sendRaw();
        }

        /**
         * Get plan details
         *
         * <p>Retrieve a specific plan. Use <code>?version=draft</code> for the draft version,
         * <code>?version=2</code> for a specific version number, or omit for the active version.
         *
         * @param planId the {@code plan_id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<Plan> retrieve(final String planId) {
            return retrieve(planId, PlansRetrieveOptions.none(), RequestOptions.none());
        }

        /**
         * Get plan details
         *
         * <p>Retrieve a specific plan. Use <code>?version=draft</code> for the draft version,
         * <code>?version=2</code> for a specific version number, or omit for the active version.
         *
         * @param planId the {@code plan_id} path parameter
         * @param options the optional parameters
         * @return the status, headers and body
         */
        public ApiResponse<Plan> retrieve(final String planId, final PlansRetrieveOptions options) {
            return retrieve(planId, options, RequestOptions.none());
        }

        /**
         * Get plan details
         *
         * <p>Retrieve a specific plan. Use <code>?version=draft</code> for the draft version,
         * <code>?version=2</code> for a specific version number, or omit for the active version.
         *
         * @param planId the {@code plan_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Plan> retrieve(
                final String planId, final RequestOptions requestOptions) {
            return retrieve(planId, PlansRetrieveOptions.none(), requestOptions);
        }

        /**
         * Get plan details
         *
         * <p>Retrieve a specific plan. Use <code>?version=draft</code> for the draft version,
         * <code>?version=2</code> for a specific version number, or omit for the active version.
         *
         * @param planId the {@code plan_id} path parameter
         * @param options the optional parameters
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Plan> retrieve(
                final String planId,
                final PlansRetrieveOptions options,
                final RequestOptions requestOptions) {
            return Plans.this.exchangeRetrieve(planId, options, requestOptions).sendRaw();
        }

        /**
         * Replace a plan
         *
         * <p>Full replacement of a plan's version. On a draft plan, updates in-place. On a
         * published plan, creates a new version. Set <code>status</code> to <code>DRAFT</code> to
         * stage as a new draft without publishing.
         *
         * @param planId the {@code plan_id} path parameter
         * @param replacePlanRequest the request body
         * @return the status, headers and body
         */
        public ApiResponse<Plan> replace(
                final String planId, final ReplacePlanRequest replacePlanRequest) {
            return replace(planId, replacePlanRequest, RequestOptions.none());
        }

        /**
         * Replace a plan
         *
         * <p>Full replacement of a plan's version. On a draft plan, updates in-place. On a
         * published plan, creates a new version. Set <code>status</code> to <code>DRAFT</code> to
         * stage as a new draft without publishing.
         *
         * @param planId the {@code plan_id} path parameter
         * @param replacePlanRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Plan> replace(
                final String planId,
                final ReplacePlanRequest replacePlanRequest,
                final RequestOptions requestOptions) {
            return Plans.this.exchangeReplace(planId, replacePlanRequest, requestOptions).sendRaw();
        }

        /**
         * Update plan metadata
         *
         * <p>Partially update plan-level fields (name, description, self_service_rank). Does not
         * modify version-level configuration or components.
         *
         * @param planId the {@code plan_id} path parameter
         * @param patchPlanRequest the request body
         * @return the status, headers and body
         */
        public ApiResponse<Plan> update(
                final String planId, final PatchPlanRequest patchPlanRequest) {
            return update(planId, patchPlanRequest, RequestOptions.none());
        }

        /**
         * Update plan metadata
         *
         * <p>Partially update plan-level fields (name, description, self_service_rank). Does not
         * modify version-level configuration or components.
         *
         * @param planId the {@code plan_id} path parameter
         * @param patchPlanRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Plan> update(
                final String planId,
                final PatchPlanRequest patchPlanRequest,
                final RequestOptions requestOptions) {
            return Plans.this.exchangeUpdate(planId, patchPlanRequest, requestOptions).sendRaw();
        }

        /**
         * Archive a plan
         *
         * @param planId the {@code plan_id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<Void> archive(final String planId) {
            return archive(planId, RequestOptions.none());
        }

        /**
         * Archive a plan
         *
         * @param planId the {@code plan_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Void> archive(final String planId, final RequestOptions requestOptions) {
            return Plans.this.exchangeArchive(planId, requestOptions).sendRaw();
        }

        /**
         * Publish a draft plan version
         *
         * <p>Publishes the current draft version, making it the active version.
         *
         * @param planId the {@code plan_id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<Plan> publish(final String planId) {
            return publish(planId, RequestOptions.none());
        }

        /**
         * Publish a draft plan version
         *
         * <p>Publishes the current draft version, making it the active version.
         *
         * @param planId the {@code plan_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Plan> publish(final String planId, final RequestOptions requestOptions) {
            return Plans.this.exchangePublish(planId, requestOptions).sendRaw();
        }

        /**
         * Unarchive a plan
         *
         * @param planId the {@code plan_id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<Void> unarchive(final String planId) {
            return unarchive(planId, RequestOptions.none());
        }

        /**
         * Unarchive a plan
         *
         * @param planId the {@code plan_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Void> unarchive(
                final String planId, final RequestOptions requestOptions) {
            return Plans.this.exchangeUnarchive(planId, requestOptions).sendRaw();
        }

        /**
         * List plan versions
         *
         * @param planId the {@code plan_id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<PlanVersionListResponse> listVersions(final String planId) {
            return listVersions(planId, PlansListVersionsOptions.none(), RequestOptions.none());
        }

        /**
         * List plan versions
         *
         * @param planId the {@code plan_id} path parameter
         * @param options the optional parameters
         * @return the status, headers and body
         */
        public ApiResponse<PlanVersionListResponse> listVersions(
                final String planId, final PlansListVersionsOptions options) {
            return listVersions(planId, options, RequestOptions.none());
        }

        /**
         * List plan versions
         *
         * @param planId the {@code plan_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<PlanVersionListResponse> listVersions(
                final String planId, final RequestOptions requestOptions) {
            return listVersions(planId, PlansListVersionsOptions.none(), requestOptions);
        }

        /**
         * List plan versions
         *
         * @param planId the {@code plan_id} path parameter
         * @param options the optional parameters
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<PlanVersionListResponse> listVersions(
                final String planId,
                final PlansListVersionsOptions options,
                final RequestOptions requestOptions) {
            return Plans.this.exchangeListVersions(planId, options, requestOptions).sendRaw();
        }
    }
}
