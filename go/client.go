// this file is @generated
package meteroid

// Client is the entry point of the Meteroid SDK.
//
// A Client is safe for concurrent use by multiple goroutines. Each API area is
// reached through an accessor method, e.g. client.Customers().ListCustomers(ctx, nil).
type Client struct {
	cfg *config
}

// New builds a Client authenticated with the given API token.
//
// Pass nil options to use the defaults: https://api.meteroid.com as the server,
// a 15 second per-request timeout and two retries on transient failures.
func New(token string, options *Options) *Client {
	return &Client{cfg: newConfig(token, options)}
}

// WithToken returns a copy of the client that authenticates with a different
// API token, reusing the underlying HTTP client and every other setting.
func (c *Client) WithToken(token string) *Client {
	return &Client{cfg: c.cfg.withToken(token)}
}

// AddOns returns the add ons API.
func (c *Client) AddOns() *AddOns {
	return &AddOns{client: c}
}

// BatchJobs returns the batch jobs API.
func (c *Client) BatchJobs() *BatchJobs {
	return &BatchJobs{client: c}
}

// CheckoutSessions returns the checkout sessions API.
func (c *Client) CheckoutSessions() *CheckoutSessions {
	return &CheckoutSessions{client: c}
}

// Connect returns the connect API.
func (c *Client) Connect() *Connect {
	return &Connect{client: c}
}

// Coupons returns the coupons API.
func (c *Client) Coupons() *Coupons {
	return &Coupons{client: c}
}

// CreditNotes returns the credit notes API.
func (c *Client) CreditNotes() *CreditNotes {
	return &CreditNotes{client: c}
}

// CustomProperties returns the custom properties API.
func (c *Client) CustomProperties() *CustomProperties {
	return &CustomProperties{client: c}
}

// Customers returns the customers API.
func (c *Client) Customers() *Customers {
	return &Customers{client: c}
}

// Events returns the events API.
func (c *Client) Events() *Events {
	return &Events{client: c}
}

// Features returns the features API.
func (c *Client) Features() *Features {
	return &Features{client: c}
}

// Invoices returns the invoices API.
func (c *Client) Invoices() *Invoices {
	return &Invoices{client: c}
}

// Metrics returns the metrics API.
func (c *Client) Metrics() *Metrics {
	return &Metrics{client: c}
}

// OAuth returns the o auth API.
func (c *Client) OAuth() *OAuth {
	return &OAuth{client: c}
}

// OAuthApps returns the o auth apps API.
func (c *Client) OAuthApps() *OAuthApps {
	return &OAuthApps{client: c}
}

// Plans returns the plans API.
func (c *Client) Plans() *Plans {
	return &Plans{client: c}
}

// ProductFamilies returns the product families API.
func (c *Client) ProductFamilies() *ProductFamilies {
	return &ProductFamilies{client: c}
}

// Products returns the products API.
func (c *Client) Products() *Products {
	return &Products{client: c}
}

// Subscriptions returns the subscriptions API.
func (c *Client) Subscriptions() *Subscriptions {
	return &Subscriptions{client: c}
}

// Usage returns the usage API.
func (c *Client) Usage() *Usage {
	return &Usage{client: c}
}
