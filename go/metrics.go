// this file is @generated
package meteroid

import (
	"context"
	"net/http"
)

// MetricsListMetricsOptions carries the query and header parameters of
// Metrics.ListMetrics.
//
// Optional parameters are pointers; leave them nil to omit them.
type MetricsListMetricsOptions struct {
	ProductFamilyId *ProductFamilyId

	// Search by metric name or code
	Search *string

	// Sort order. Format: `column.direction`. Allowed columns: `name`, `code`, `created_at`. Direction: `asc` or `desc`. Default: `name.asc`.
	OrderBy *string

	// Page number (0-indexed)
	Page *int32

	// Number of items per page
	PerPage *int32
}

// Metrics groups the metrics operations of the Meteroid API.
type Metrics struct {
	client *Client
}

func (a *Metrics) ListMetrics(ctx context.Context, options *MetricsListMetricsOptions) (*MetricListResponse, error) {
	req := newRequest(http.MethodGet, "/api/v1/metrics")

	if options != nil {
		if options.ProductFamilyId != nil {
			req.SetQueryParam("product_family_id", string(*options.ProductFamilyId))
		}
		if options.Search != nil {
			req.SetQueryParam("search", *options.Search)
		}
		if options.OrderBy != nil {
			req.SetQueryParam("order_by", *options.OrderBy)
		}
		if options.Page != nil {
			req.SetQueryParam("page", formatInt(int64(*options.Page)))
		}
		if options.PerPage != nil {
			req.SetQueryParam("per_page", formatInt(int64(*options.PerPage)))
		}
	}

	var out MetricListResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

func (a *Metrics) CreateMetric(ctx context.Context, createMetricRequest CreateMetricRequest) (*Metric, error) {
	req := newRequest(http.MethodPost, "/api/v1/metrics")

	req.SetJSONBody(createMetricRequest)

	var out Metric
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

func (a *Metrics) GetMetric(ctx context.Context, metricId string) (*Metric, error) {
	req := newRequest(http.MethodGet, "/api/v1/metrics/{metric_id}")
	req.SetPathParam("metric_id", metricId)

	var out Metric
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

// Partially update metric fields. Code and aggregation_type are immutable.
func (a *Metrics) UpdateMetric(ctx context.Context, metricId string, updateMetricRequest UpdateMetricRequest) (*Metric, error) {
	req := newRequest(http.MethodPatch, "/api/v1/metrics/{metric_id}")
	req.SetPathParam("metric_id", metricId)

	req.SetJSONBody(updateMetricRequest)

	var out Metric
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

func (a *Metrics) ArchiveMetric(ctx context.Context, metricId string) error {
	req := newRequest(http.MethodPost, "/api/v1/metrics/{metric_id}/archive")
	req.SetPathParam("metric_id", metricId)

	return a.client.execute(ctx, req, nil)
}

func (a *Metrics) UnarchiveMetric(ctx context.Context, metricId string) error {
	req := newRequest(http.MethodPost, "/api/v1/metrics/{metric_id}/unarchive")
	req.SetPathParam("metric_id", metricId)

	return a.client.execute(ctx, req, nil)
}
