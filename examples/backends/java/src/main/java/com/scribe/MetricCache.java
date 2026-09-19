package com.scribe;

import com.meteroid.Meteroid;
import com.meteroid.api.MetricsListMetricsOptions;
import com.meteroid.models.MetricListResponse;
import com.meteroid.models.MetricSummary;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Meteroid identifies the metric behind a metered entitlement — and behind a {@code USAGE} or
 * {@code CAPACITY} price component — by <b>id</b> only. This maps ids back onto the codes
 * application code actually knows.
 */
public final class MetricCache {

    private final AtomicReference<Map<String, String>> codesById = new AtomicReference<>(Map.of());

    /** Load (or reload) the whole map. Cheap: one page covers any realistic demo tenant. */
    public void refresh(Meteroid meteroid) {
        MetricsListMetricsOptions options = new MetricsListMetricsOptions();
        options.setPerPage(100);

        MetricListResponse response =
                Upstream.call("GET /api/v1/metrics", () -> meteroid.getMetrics().listMetrics(options));

        Map<String, String> map = new HashMap<>();
        for (MetricSummary metric : response.getData()) {
            map.put(metric.getId(), metric.getCode());
        }
        codesById.set(Map.copyOf(map));
    }

    /**
     * Resolve one metric id, refreshing once on a miss so a metric seeded after startup still shows
     * up. {@code null} is not fatal anywhere — the code is presentational.
     */
    public String codeFor(Meteroid meteroid, String metricId) {
        String cached = cachedCodeFor(metricId);
        if (cached != null) {
            return cached;
        }
        try {
            refresh(meteroid);
        } catch (ApiError e) {
            return null;
        }
        return cachedCodeFor(metricId);
    }

    /** Look in the map only; never calls Meteroid. */
    public String cachedCodeFor(String metricId) {
        return metricId == null ? null : codesById.get().get(metricId);
    }
}
