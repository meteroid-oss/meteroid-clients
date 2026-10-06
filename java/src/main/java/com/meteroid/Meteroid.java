// this file is @generated
package com.meteroid;

import com.meteroid.api.AddOns;
import com.meteroid.api.BatchJobs;
import com.meteroid.api.CheckoutSessions;
import com.meteroid.api.Connect;
import com.meteroid.api.Coupons;
import com.meteroid.api.CreditNotes;
import com.meteroid.api.CustomProperties;
import com.meteroid.api.Customers;
import com.meteroid.api.Events;
import com.meteroid.api.Features;
import com.meteroid.api.Invoices;
import com.meteroid.api.Metrics;
import com.meteroid.api.Oauth;
import com.meteroid.api.OauthApps;
import com.meteroid.api.Plans;
import com.meteroid.api.ProductFamilies;
import com.meteroid.api.Products;
import com.meteroid.api.Subscriptions;
import com.meteroid.api.Usage;
import com.meteroid.internal.MeteroidAuth;
import com.meteroid.internal.MeteroidHttpClient;

import okhttp3.HttpUrl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The Meteroid client, blocking: {@link #async()} has the same methods returning futures, and
 * {@link #withRawResponse()} the same methods returning the status and headers along with the body.
 * Close it to release its threads and connections.
 *
 * <pre>{@code
 * try (Meteroid client = Meteroid.fromEnv()) {
 *     // client.<resource>().<method>(...)
 * }
 * }</pre>
 *
 * <p>Without an API key, the client reads {@value MeteroidOptions#API_KEY_ENV}, and {@value
 * MeteroidOptions#BASE_URL_ENV} overrides the base URL, {@link #DEFAULT_BASE_URL} otherwise.
 */
public final class Meteroid implements AutoCloseable {
    private static final Map<String, MeteroidAuth.Scheme> SECURITY_SCHEMES =
            Map.ofEntries(Map.entry("bearer_auth", new MeteroidAuth.Scheme("bearer", null, null)));

    /** The base URL of the API when neither the options nor the environment set one. */
    public static final String DEFAULT_BASE_URL = "https://api.meteroid.com";

    private final MeteroidOptions options;
    private final MeteroidHttpClient httpClient;
    private final WithRawResponse withRawResponse;
    private final MeteroidAsync async;
    private final AddOns addOns;
    private final BatchJobs batchJobs;
    private final CheckoutSessions checkoutSessions;
    private final Connect connect;
    private final Coupons coupons;
    private final CreditNotes creditNotes;
    private final CustomProperties customProperties;
    private final Customers customers;
    private final Events events;
    private final Features features;
    private final Invoices invoices;
    private final Metrics metrics;
    private final Oauth oauth;
    private final OauthApps oauthApps;
    private final Plans plans;
    private final ProductFamilies productFamilies;
    private final Products products;
    private final Subscriptions subscriptions;
    private final Usage usage;

    /**
     * A client with the default options, its API key and base URL read from the environment.
     *
     * @return the client
     */
    public static Meteroid fromEnv() {
        return new Meteroid(MeteroidOptions.builder().build());
    }

    /**
     * A client with the default options.
     *
     * @param apiKey your API key, or null to read {@value MeteroidOptions#API_KEY_ENV}
     */
    public Meteroid(String apiKey) {
        this(apiKey, MeteroidOptions.builder().build());
    }

    /**
     * A client with custom options.
     *
     * @param apiKey your API key, or null for that of the options, else {@value
     *     MeteroidOptions#API_KEY_ENV}
     * @param options the options
     */
    public Meteroid(String apiKey, MeteroidOptions options) {
        this(apiKey == null ? options : options.toBuilder().apiKey(apiKey).build());
    }

    /**
     * A client with custom options.
     *
     * @param options the options; the environment supplies the API key and base URL they leave out
     */
    public Meteroid(MeteroidOptions options) {
        this.options = options;
        String baseUrl =
                options.baseUrl()
                        .orElseGet(() -> env(MeteroidOptions.BASE_URL_ENV, DEFAULT_BASE_URL));
        HttpUrl parsedUrl = HttpUrl.parse(baseUrl);
        if (parsedUrl == null) {
            throw new IllegalArgumentException("Invalid base URL: " + baseUrl);
        }
        String apiKey = options.apiKey().orElseGet(() -> env(MeteroidOptions.API_KEY_ENV, null));
        Map<String, String> defaultHeaders = new LinkedHashMap<>();
        defaultHeaders.put("User-Agent", "meteroid-java/" + Version.VERSION);
        defaultHeaders.putAll(options.headers());
        MeteroidAuth auth =
                new MeteroidAuth(
                        SECURITY_SCHEMES, List.of(List.of("bearer_auth")), apiKey, options);
        this.httpClient = new MeteroidHttpClient(parsedUrl, defaultHeaders, options, auth);
        this.addOns = new AddOns(httpClient);
        this.batchJobs = new BatchJobs(httpClient);
        this.checkoutSessions = new CheckoutSessions(httpClient);
        this.connect = new Connect(httpClient);
        this.coupons = new Coupons(httpClient);
        this.creditNotes = new CreditNotes(httpClient);
        this.customProperties = new CustomProperties(httpClient);
        this.customers = new Customers(httpClient);
        this.events = new Events(httpClient);
        this.features = new Features(httpClient);
        this.invoices = new Invoices(httpClient);
        this.metrics = new Metrics(httpClient);
        this.oauth = new Oauth(httpClient);
        this.oauthApps = new OauthApps(httpClient);
        this.plans = new Plans(httpClient);
        this.productFamilies = new ProductFamilies(httpClient);
        this.products = new Products(httpClient);
        this.subscriptions = new Subscriptions(httpClient);
        this.usage = new Usage(httpClient);
        this.withRawResponse = new WithRawResponse();
        this.async = new MeteroidAsync(this);
    }

    private static String env(String name, String fallback) {
        String value = System.getenv(name);
        return value == null || value.isEmpty() ? fallback : value;
    }

    /**
     * The options of this client.
     *
     * @return the options
     */
    public MeteroidOptions options() {
        return options;
    }

    /**
     * The same operations without blocking, sharing this client's connections.
     *
     * @return the async client
     */
    public MeteroidAsync async() {
        return async;
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
     * Releases the threads and connections of the client, unless they belong to one given in the
     * options.
     */
    @Override
    public void close() {
        httpClient.close();
    }

    /**
     * The {@code add_ons} operations.
     *
     * @return the operations
     */
    public AddOns addOns() {
        return addOns;
    }

    /**
     * The {@code batch_jobs} operations.
     *
     * @return the operations
     */
    public BatchJobs batchJobs() {
        return batchJobs;
    }

    /**
     * The {@code checkout_sessions} operations.
     *
     * @return the operations
     */
    public CheckoutSessions checkoutSessions() {
        return checkoutSessions;
    }

    /**
     * The {@code connect} operations.
     *
     * @return the operations
     */
    public Connect connect() {
        return connect;
    }

    /**
     * The {@code coupons} operations.
     *
     * @return the operations
     */
    public Coupons coupons() {
        return coupons;
    }

    /**
     * The {@code credit_notes} operations.
     *
     * @return the operations
     */
    public CreditNotes creditNotes() {
        return creditNotes;
    }

    /**
     * The {@code custom_properties} operations.
     *
     * @return the operations
     */
    public CustomProperties customProperties() {
        return customProperties;
    }

    /**
     * The {@code customers} operations.
     *
     * @return the operations
     */
    public Customers customers() {
        return customers;
    }

    /**
     * The {@code events} operations.
     *
     * @return the operations
     */
    public Events events() {
        return events;
    }

    /**
     * The {@code features} operations.
     *
     * @return the operations
     */
    public Features features() {
        return features;
    }

    /**
     * The {@code invoices} operations.
     *
     * @return the operations
     */
    public Invoices invoices() {
        return invoices;
    }

    /**
     * The {@code metrics} operations.
     *
     * @return the operations
     */
    public Metrics metrics() {
        return metrics;
    }

    /**
     * The {@code oauth} operations.
     *
     * @return the operations
     */
    public Oauth oauth() {
        return oauth;
    }

    /**
     * The {@code oauth_apps} operations.
     *
     * @return the operations
     */
    public OauthApps oauthApps() {
        return oauthApps;
    }

    /**
     * The {@code plans} operations.
     *
     * @return the operations
     */
    public Plans plans() {
        return plans;
    }

    /**
     * The {@code product_families} operations.
     *
     * @return the operations
     */
    public ProductFamilies productFamilies() {
        return productFamilies;
    }

    /**
     * The {@code products} operations.
     *
     * @return the operations
     */
    public Products products() {
        return products;
    }

    /**
     * The {@code subscriptions} operations.
     *
     * @return the operations
     */
    public Subscriptions subscriptions() {
        return subscriptions;
    }

    /**
     * The {@code usage} operations.
     *
     * @return the operations
     */
    public Usage usage() {
        return usage;
    }

    /** The operations, returning the status and headers along with the body. */
    public final class WithRawResponse {
        private WithRawResponse() {}

        /**
         * The {@code add_ons} operations.
         *
         * @return the operations
         */
        public AddOns.WithRawResponse addOns() {
            return addOns.withRawResponse();
        }

        /**
         * The {@code batch_jobs} operations.
         *
         * @return the operations
         */
        public BatchJobs.WithRawResponse batchJobs() {
            return batchJobs.withRawResponse();
        }

        /**
         * The {@code checkout_sessions} operations.
         *
         * @return the operations
         */
        public CheckoutSessions.WithRawResponse checkoutSessions() {
            return checkoutSessions.withRawResponse();
        }

        /**
         * The {@code connect} operations.
         *
         * @return the operations
         */
        public Connect.WithRawResponse connect() {
            return connect.withRawResponse();
        }

        /**
         * The {@code coupons} operations.
         *
         * @return the operations
         */
        public Coupons.WithRawResponse coupons() {
            return coupons.withRawResponse();
        }

        /**
         * The {@code credit_notes} operations.
         *
         * @return the operations
         */
        public CreditNotes.WithRawResponse creditNotes() {
            return creditNotes.withRawResponse();
        }

        /**
         * The {@code custom_properties} operations.
         *
         * @return the operations
         */
        public CustomProperties.WithRawResponse customProperties() {
            return customProperties.withRawResponse();
        }

        /**
         * The {@code customers} operations.
         *
         * @return the operations
         */
        public Customers.WithRawResponse customers() {
            return customers.withRawResponse();
        }

        /**
         * The {@code events} operations.
         *
         * @return the operations
         */
        public Events.WithRawResponse events() {
            return events.withRawResponse();
        }

        /**
         * The {@code features} operations.
         *
         * @return the operations
         */
        public Features.WithRawResponse features() {
            return features.withRawResponse();
        }

        /**
         * The {@code invoices} operations.
         *
         * @return the operations
         */
        public Invoices.WithRawResponse invoices() {
            return invoices.withRawResponse();
        }

        /**
         * The {@code metrics} operations.
         *
         * @return the operations
         */
        public Metrics.WithRawResponse metrics() {
            return metrics.withRawResponse();
        }

        /**
         * The {@code oauth} operations.
         *
         * @return the operations
         */
        public Oauth.WithRawResponse oauth() {
            return oauth.withRawResponse();
        }

        /**
         * The {@code oauth_apps} operations.
         *
         * @return the operations
         */
        public OauthApps.WithRawResponse oauthApps() {
            return oauthApps.withRawResponse();
        }

        /**
         * The {@code plans} operations.
         *
         * @return the operations
         */
        public Plans.WithRawResponse plans() {
            return plans.withRawResponse();
        }

        /**
         * The {@code product_families} operations.
         *
         * @return the operations
         */
        public ProductFamilies.WithRawResponse productFamilies() {
            return productFamilies.withRawResponse();
        }

        /**
         * The {@code products} operations.
         *
         * @return the operations
         */
        public Products.WithRawResponse products() {
            return products.withRawResponse();
        }

        /**
         * The {@code subscriptions} operations.
         *
         * @return the operations
         */
        public Subscriptions.WithRawResponse subscriptions() {
            return subscriptions.withRawResponse();
        }

        /**
         * The {@code usage} operations.
         *
         * @return the operations
         */
        public Usage.WithRawResponse usage() {
            return usage.withRawResponse();
        }
    }
}
