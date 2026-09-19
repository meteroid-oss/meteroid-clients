package com.scribe;

import com.meteroid.api.SubscriptionsListSubscriptionsOptions;
import com.meteroid.models.Customer;
import com.meteroid.models.Subscription;
import com.meteroid.models.SubscriptionStatusEnum;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;

/**
 * Per-workspace Meteroid lookups shared by several handlers — the Java twin of the Rust backend's
 * {@code src/workspace.rs}.
 *
 * <p>A "workspace" is one Meteroid <b>customer</b>. The demo addresses it everywhere by its
 * <i>alias</i> ({@code scribe-demo-…}), never by the Meteroid id: every Meteroid endpoint the demo
 * touches accepts {@code id_or_alias}, which is the point being demonstrated — you can drive
 * Meteroid entirely from your own identifiers.
 */
public final class Workspaces {

    private Workspaces() {}

    /** Statuses that count as "the subscription this workspace is living on right now". */
    private static final Set<SubscriptionStatusEnum> LIVE_STATUSES =
            EnumSet.of(SubscriptionStatusEnum.ACTIVE, SubscriptionStatusEnum.TRIAL_ACTIVE);

    public static Customer loadCustomer(AppState state, String alias) {
        return Upstream.call(
                "GET /api/v1/customers/" + alias,
                () -> state.meteroid.getCustomers().getCustomer(alias));
    }

    /**
     * The workspace's most relevant subscription, or {@code null} if it has never checked out.
     *
     * <p>The contract pins the rule down so every backend picks the same one: ask Meteroid for the
     * customer's subscriptions newest-first, take the first {@code ACTIVE} or {@code TRIAL_ACTIVE}
     * one, and otherwise the most recently created regardless of status.
     */
    public static Subscription currentSubscription(AppState state, String alias) {
        // `customer_id` accepts a Meteroid id *or* an external alias, so no id lookup first.
        SubscriptionsListSubscriptionsOptions options = new SubscriptionsListSubscriptionsOptions();
        options.setCustomerId(alias);
        options.setOrderBy("created_at.desc");
        options.setPerPage(100);

        List<Subscription> subscriptions =
                Upstream.call(
                                "GET /api/v1/subscriptions",
                                () -> state.meteroid.getSubscriptions().listSubscriptions(options))
                        .getData();

        if (subscriptions == null || subscriptions.isEmpty()) {
            return null;
        }
        for (Subscription subscription : subscriptions) {
            if (LIVE_STATUSES.contains(subscription.getStatus())) {
                return subscription;
            }
        }
        return subscriptions.get(0);
    }

    /**
     * Project a Meteroid customer onto the contract's {@code Workspace}.
     *
     * <p>Note there is no {@code created_at}: Meteroid's {@code Customer} carries no creation
     * timestamp, so the contract does not pretend it does.
     */
    public static Dto.Workspace toWorkspace(Customer customer, String fallbackAlias) {
        String alias = customer.getAlias() == null ? fallbackAlias : customer.getAlias();
        return new Dto.Workspace(
                alias, customer.getName(), customer.getId(), alias, customer.getCurrency().getValue());
    }

    /**
     * The plan to offer when a workspace hits a wall ({@code 402} / {@code 403}).
     *
     * <p>One plan up from where it is now: {@code pro} for an unsubscribed workspace or one on a
     * plan outside the Scribe catalog, {@code scale} for a {@code pro} workspace, and {@code null}
     * on {@code scale} — there is nothing left to sell. Never throws: this decorates an error
     * response, and a failed lookup here must not replace the error the caller actually hit.
     */
    public static PlanCode upgradeTarget(AppState state, String alias) {
        try {
            Subscription subscription = currentSubscription(state, alias);
            if (subscription == null) {
                return PlanCode.PRO;
            }
            PlanCode current =
                    state.catalog()
                            .planCodeFor(subscription.getPlanId(), subscription.getPlanName());
            return current == null ? PlanCode.PRO : current.nextUp();
        } catch (RuntimeException e) {
            return null;
        }
    }
}
