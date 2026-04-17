// this file is @generated
package com.meteroid;

import com.meteroid.api.*;

import lombok.Getter;

import okhttp3.HttpUrl;

import java.util.Map;

/**
 * Main entry point for the Meteroid Java SDK.
 *
 * <p>This class provides access to all Meteroid API resources through a fluent interface.
 *
 * <p>Example usage:
 *
 * <pre>{@code
 * // Initialize with API key
 * Meteroid meteroid = new Meteroid("your-api-key");
 *
 * // Or with custom options
 * MeteroidOptions options = new MeteroidOptions();
 * options.setServerUrl("https://custom.api.meteroid.com");
 * Meteroid meteroid = new Meteroid("your-api-key", options);
 *
 * // Access API resources
 * CustomerListResponse customers = meteroid.getCustomer().listCustomers();
 * }</pre>
 */
@Getter
public class Meteroid {

    private final AddOns addOns;

    private final BatchJobs batchJobs;

    private final CheckoutSessions checkoutSessions;

    private final Coupons coupons;

    private final CreditNotes creditNotes;

    private final Customers customers;

    private final Events events;

    private final Invoices invoices;

    private final Metrics metrics;

    private final Plans plans;

    private final ProductFamilies productFamilies;

    private final Products products;

    private final Subscriptions subscriptions;

    private final Usage usage;

    /**
     * Create a new Meteroid client with default options.
     *
     * @param apiKey Your Meteroid API key
     */
    public Meteroid(String apiKey) {
        this(apiKey, new MeteroidOptions());
    }

    /**
     * Create a new Meteroid client with custom options.
     *
     * @param apiKey Your Meteroid API key
     * @param options Configuration options for the client
     */
    public Meteroid(String apiKey, MeteroidOptions options) {
        HttpUrl parsedUrl = HttpUrl.parse(options.getServerUrl());
        if (parsedUrl == null) {
            throw new IllegalArgumentException("Invalid server URL: " + options.getServerUrl());
        }

        Map<String, String> defaultHeaders =
                Map.of(
                        "User-Agent", "meteroid-java/" + Version.VERSION,
                        "Authorization", "Bearer " + apiKey);

        MeteroidHttpClient httpClient =
                new MeteroidHttpClient(parsedUrl, defaultHeaders, options.getRetrySchedule());

        this.addOns = new AddOns(httpClient);

        this.batchJobs = new BatchJobs(httpClient);

        this.checkoutSessions = new CheckoutSessions(httpClient);

        this.coupons = new Coupons(httpClient);

        this.creditNotes = new CreditNotes(httpClient);

        this.customers = new Customers(httpClient);

        this.events = new Events(httpClient);

        this.invoices = new Invoices(httpClient);

        this.metrics = new Metrics(httpClient);

        this.plans = new Plans(httpClient);

        this.productFamilies = new ProductFamilies(httpClient);

        this.products = new Products(httpClient);

        this.subscriptions = new Subscriptions(httpClient);

        this.usage = new Usage(httpClient);
    }
}
