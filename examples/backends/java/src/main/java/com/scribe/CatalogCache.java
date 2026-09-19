package com.scribe;

import com.meteroid.Meteroid;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Process-wide cache of the resolved catalog.
 *
 * <p>Only successes are cached, so seeding the tenant while the demo is running fixes it without a
 * restart. Two concurrent misses may both resolve; that is a handful of extra GETs the first time,
 * and cheaper than holding a lock across a network call.
 */
public final class CatalogCache {

    private final AtomicReference<Catalog> resolved = new AtomicReference<>();

    public Catalog get(Meteroid meteroid, MetricCache metrics, String expectedCurrency) {
        Catalog cached = resolved.get();
        if (cached != null) {
            return cached;
        }
        Catalog catalog = Catalog.resolve(meteroid, metrics, expectedCurrency);
        resolved.compareAndSet(null, catalog);
        return resolved.get();
    }
}
