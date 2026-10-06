// this file is @generated
package com.meteroid;

import com.meteroid.api.AddOnsAsync;
import com.meteroid.api.BatchJobsAsync;
import com.meteroid.api.CheckoutSessionsAsync;
import com.meteroid.api.ConnectAsync;
import com.meteroid.api.CouponsAsync;
import com.meteroid.api.CreditNotesAsync;
import com.meteroid.api.CustomPropertiesAsync;
import com.meteroid.api.CustomersAsync;
import com.meteroid.api.EventsAsync;
import com.meteroid.api.FeaturesAsync;
import com.meteroid.api.InvoicesAsync;
import com.meteroid.api.MetricsAsync;
import com.meteroid.api.OauthAppsAsync;
import com.meteroid.api.OauthAsync;
import com.meteroid.api.PlansAsync;
import com.meteroid.api.ProductFamiliesAsync;
import com.meteroid.api.ProductsAsync;
import com.meteroid.api.SubscriptionsAsync;
import com.meteroid.api.UsageAsync;

/**
 * The Meteroid client without blocking: every method returns a {@link
 * java.util.concurrent.CompletableFuture}. Obtained from {@link Meteroid#async()}, it shares the
 * connections of the blocking client.
 */
public final class MeteroidAsync implements AutoCloseable {
    private final Meteroid sync;
    private final WithRawResponse withRawResponse;
    private final AddOnsAsync addOns;
    private final BatchJobsAsync batchJobs;
    private final CheckoutSessionsAsync checkoutSessions;
    private final ConnectAsync connect;
    private final CouponsAsync coupons;
    private final CreditNotesAsync creditNotes;
    private final CustomPropertiesAsync customProperties;
    private final CustomersAsync customers;
    private final EventsAsync events;
    private final FeaturesAsync features;
    private final InvoicesAsync invoices;
    private final MetricsAsync metrics;
    private final OauthAsync oauth;
    private final OauthAppsAsync oauthApps;
    private final PlansAsync plans;
    private final ProductFamiliesAsync productFamilies;
    private final ProductsAsync products;
    private final SubscriptionsAsync subscriptions;
    private final UsageAsync usage;

    MeteroidAsync(Meteroid sync) {
        this.sync = sync;
        this.addOns = new AddOnsAsync(sync.addOns());
        this.batchJobs = new BatchJobsAsync(sync.batchJobs());
        this.checkoutSessions = new CheckoutSessionsAsync(sync.checkoutSessions());
        this.connect = new ConnectAsync(sync.connect());
        this.coupons = new CouponsAsync(sync.coupons());
        this.creditNotes = new CreditNotesAsync(sync.creditNotes());
        this.customProperties = new CustomPropertiesAsync(sync.customProperties());
        this.customers = new CustomersAsync(sync.customers());
        this.events = new EventsAsync(sync.events());
        this.features = new FeaturesAsync(sync.features());
        this.invoices = new InvoicesAsync(sync.invoices());
        this.metrics = new MetricsAsync(sync.metrics());
        this.oauth = new OauthAsync(sync.oauth());
        this.oauthApps = new OauthAppsAsync(sync.oauthApps());
        this.plans = new PlansAsync(sync.plans());
        this.productFamilies = new ProductFamiliesAsync(sync.productFamilies());
        this.products = new ProductsAsync(sync.products());
        this.subscriptions = new SubscriptionsAsync(sync.subscriptions());
        this.usage = new UsageAsync(sync.usage());
        this.withRawResponse = new WithRawResponse();
    }

    /**
     * The blocking client sharing these connections.
     *
     * @return the blocking client
     */
    public Meteroid sync() {
        return sync;
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
     * The {@code add_ons} operations.
     *
     * @return the operations
     */
    public AddOnsAsync addOns() {
        return addOns;
    }

    /**
     * The {@code batch_jobs} operations.
     *
     * @return the operations
     */
    public BatchJobsAsync batchJobs() {
        return batchJobs;
    }

    /**
     * The {@code checkout_sessions} operations.
     *
     * @return the operations
     */
    public CheckoutSessionsAsync checkoutSessions() {
        return checkoutSessions;
    }

    /**
     * The {@code connect} operations.
     *
     * @return the operations
     */
    public ConnectAsync connect() {
        return connect;
    }

    /**
     * The {@code coupons} operations.
     *
     * @return the operations
     */
    public CouponsAsync coupons() {
        return coupons;
    }

    /**
     * The {@code credit_notes} operations.
     *
     * @return the operations
     */
    public CreditNotesAsync creditNotes() {
        return creditNotes;
    }

    /**
     * The {@code custom_properties} operations.
     *
     * @return the operations
     */
    public CustomPropertiesAsync customProperties() {
        return customProperties;
    }

    /**
     * The {@code customers} operations.
     *
     * @return the operations
     */
    public CustomersAsync customers() {
        return customers;
    }

    /**
     * The {@code events} operations.
     *
     * @return the operations
     */
    public EventsAsync events() {
        return events;
    }

    /**
     * The {@code features} operations.
     *
     * @return the operations
     */
    public FeaturesAsync features() {
        return features;
    }

    /**
     * The {@code invoices} operations.
     *
     * @return the operations
     */
    public InvoicesAsync invoices() {
        return invoices;
    }

    /**
     * The {@code metrics} operations.
     *
     * @return the operations
     */
    public MetricsAsync metrics() {
        return metrics;
    }

    /**
     * The {@code oauth} operations.
     *
     * @return the operations
     */
    public OauthAsync oauth() {
        return oauth;
    }

    /**
     * The {@code oauth_apps} operations.
     *
     * @return the operations
     */
    public OauthAppsAsync oauthApps() {
        return oauthApps;
    }

    /**
     * The {@code plans} operations.
     *
     * @return the operations
     */
    public PlansAsync plans() {
        return plans;
    }

    /**
     * The {@code product_families} operations.
     *
     * @return the operations
     */
    public ProductFamiliesAsync productFamilies() {
        return productFamilies;
    }

    /**
     * The {@code products} operations.
     *
     * @return the operations
     */
    public ProductsAsync products() {
        return products;
    }

    /**
     * The {@code subscriptions} operations.
     *
     * @return the operations
     */
    public SubscriptionsAsync subscriptions() {
        return subscriptions;
    }

    /**
     * The {@code usage} operations.
     *
     * @return the operations
     */
    public UsageAsync usage() {
        return usage;
    }

    /** Closes the client shared with {@link #sync()}. */
    @Override
    public void close() {
        sync.close();
    }

    /** The operations, returning the status and headers along with the body. */
    public final class WithRawResponse {
        private WithRawResponse() {}

        /**
         * The {@code add_ons} operations.
         *
         * @return the operations
         */
        public AddOnsAsync.WithRawResponse addOns() {
            return addOns.withRawResponse();
        }

        /**
         * The {@code batch_jobs} operations.
         *
         * @return the operations
         */
        public BatchJobsAsync.WithRawResponse batchJobs() {
            return batchJobs.withRawResponse();
        }

        /**
         * The {@code checkout_sessions} operations.
         *
         * @return the operations
         */
        public CheckoutSessionsAsync.WithRawResponse checkoutSessions() {
            return checkoutSessions.withRawResponse();
        }

        /**
         * The {@code connect} operations.
         *
         * @return the operations
         */
        public ConnectAsync.WithRawResponse connect() {
            return connect.withRawResponse();
        }

        /**
         * The {@code coupons} operations.
         *
         * @return the operations
         */
        public CouponsAsync.WithRawResponse coupons() {
            return coupons.withRawResponse();
        }

        /**
         * The {@code credit_notes} operations.
         *
         * @return the operations
         */
        public CreditNotesAsync.WithRawResponse creditNotes() {
            return creditNotes.withRawResponse();
        }

        /**
         * The {@code custom_properties} operations.
         *
         * @return the operations
         */
        public CustomPropertiesAsync.WithRawResponse customProperties() {
            return customProperties.withRawResponse();
        }

        /**
         * The {@code customers} operations.
         *
         * @return the operations
         */
        public CustomersAsync.WithRawResponse customers() {
            return customers.withRawResponse();
        }

        /**
         * The {@code events} operations.
         *
         * @return the operations
         */
        public EventsAsync.WithRawResponse events() {
            return events.withRawResponse();
        }

        /**
         * The {@code features} operations.
         *
         * @return the operations
         */
        public FeaturesAsync.WithRawResponse features() {
            return features.withRawResponse();
        }

        /**
         * The {@code invoices} operations.
         *
         * @return the operations
         */
        public InvoicesAsync.WithRawResponse invoices() {
            return invoices.withRawResponse();
        }

        /**
         * The {@code metrics} operations.
         *
         * @return the operations
         */
        public MetricsAsync.WithRawResponse metrics() {
            return metrics.withRawResponse();
        }

        /**
         * The {@code oauth} operations.
         *
         * @return the operations
         */
        public OauthAsync.WithRawResponse oauth() {
            return oauth.withRawResponse();
        }

        /**
         * The {@code oauth_apps} operations.
         *
         * @return the operations
         */
        public OauthAppsAsync.WithRawResponse oauthApps() {
            return oauthApps.withRawResponse();
        }

        /**
         * The {@code plans} operations.
         *
         * @return the operations
         */
        public PlansAsync.WithRawResponse plans() {
            return plans.withRawResponse();
        }

        /**
         * The {@code product_families} operations.
         *
         * @return the operations
         */
        public ProductFamiliesAsync.WithRawResponse productFamilies() {
            return productFamilies.withRawResponse();
        }

        /**
         * The {@code products} operations.
         *
         * @return the operations
         */
        public ProductsAsync.WithRawResponse products() {
            return products.withRawResponse();
        }

        /**
         * The {@code subscriptions} operations.
         *
         * @return the operations
         */
        public SubscriptionsAsync.WithRawResponse subscriptions() {
            return subscriptions.withRawResponse();
        }

        /**
         * The {@code usage} operations.
         *
         * @return the operations
         */
        public UsageAsync.WithRawResponse usage() {
            return usage.withRawResponse();
        }
    }
}
