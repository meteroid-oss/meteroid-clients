package com.scribe.routes;

import com.meteroid.models.Customer;
import com.meteroid.models.CustomerCreateRequest;
import com.meteroid.models.Subscription;
import com.scribe.AppState;
import com.scribe.Catalog;
import com.scribe.Dto;
import com.scribe.PlanCode;
import com.scribe.Routes;
import com.scribe.SessionToken;
import com.scribe.Upstream;
import com.scribe.Workspaces;

import io.javalin.http.Context;

import java.util.List;
import java.util.UUID;

/** {@code POST /api/session} and {@code GET /api/me} — the demo workspace and what it is subscribed to. */
public final class SessionRoutes {

    private SessionRoutes() {}

    private static final Dto.CreateSessionRequest NO_BODY = new Dto.CreateSessionRequest(null, null);

    /**
     * Create a brand-new Meteroid customer and hand back a session token bound to it.
     *
     * <p>This is the only object the demo ever creates in Meteroid. The catalog is seeded once, by
     * hand ({@code examples/CATALOG.md}); customers are per demo run and disposable.
     */
    public static void createSession(Context ctx, AppState state) {
        Dto.CreateSessionRequest request =
                Routes.optionalJsonBody(ctx, Dto.CreateSessionRequest.class, NO_BODY);

        // A short random alias is the workspace's identity everywhere: it is what the session token
        // carries, what ingested events reference, and what every `id_or_alias` path parameter
        // below receives.
        String alias = "scribe-demo-" + UUID.randomUUID().toString().replace("-", "");
        String name =
                request.workspaceName() == null
                        ? "Scribe demo workspace"
                        : Routes.bounded("workspace_name", request.workspaceName(), 120);
        String email =
                request.email() == null
                        ? alias + "@example.invalid"
                        : Routes.bounded("email", request.email(), 254);

        CustomerCreateRequest customerRequest =
                new CustomerCreateRequest()
                        .alias(alias)
                        .name(name)
                        // Meteroid requires all four of these. The currency must match the seeded
                        // plans' currency or checkout will refuse the plan version later on.
                        .currency(state.config.defaultCurrency)
                        .invoicingEmails(List.of(email))
                        .customTaxes(List.of());

        Customer customer =
                Upstream.call(
                        "POST /api/v1/customers",
                        () -> state.meteroid.getCustomers().createCustomer(customerRequest));

        Routes.created(
                ctx,
                new Dto.CreateSessionResponse(
                        SessionToken.mint(state.config.sessionSecret, alias),
                        Workspaces.toWorkspace(customer, alias)));
    }

    /** The current workspace, its subscription, and the plan that subscription is on. */
    public static void getMe(Context ctx, AppState state) {
        String alias = SessionToken.requireCustomerAlias(ctx, state.config);

        Customer customer = Workspaces.loadCustomer(state, alias);
        Subscription subscription = Workspaces.currentSubscription(state, alias);

        Dto.Subscription projected = null;
        Dto.Plan plan = null;
        // The plan is only looked up when there is a subscription to look it up for, so a
        // never-subscribed workspace works even before the catalog is reachable.
        if (subscription != null) {
            Catalog catalog = state.catalog();
            PlanCode planCode =
                    catalog.planCodeFor(subscription.getPlanId(), subscription.getPlanName());
            plan = planCode == null ? null : catalog.plan(planCode);
            projected = project(subscription, planCode);
        }

        ctx.json(new Dto.MeResponse(Workspaces.toWorkspace(customer, alias), projected, plan));
    }

    /**
     * Every field is a 1:1 projection of a Meteroid field — nothing is derived, so the demo's view
     * and Meteroid's can never drift. In particular {@code trial_duration_days} is Meteroid's
     * {@code trial_duration}, not a computed trial end date.
     */
    private static Dto.Subscription project(Subscription subscription, PlanCode planCode) {
        return new Dto.Subscription(
                subscription.getId(),
                subscription.getStatus().getValue(),
                planCode,
                subscription.getPlanName(),
                subscription.getPlanVersionId(),
                subscription.getCurrency().getValue(),
                subscription.getCurrentPeriodStart(),
                subscription.getCurrentPeriodEnd(),
                subscription.getTrialDuration(),
                Dto.timestamp(subscription.getCreatedAt()));
    }
}
