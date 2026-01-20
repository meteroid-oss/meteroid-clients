# Meteroid Java SDK

Official Java SDK for the [Meteroid](https://meteroid.com) billing platform.

## Requirements

- Java 11 or later

## Installation

### Gradle

```groovy
dependencies {
    implementation 'com.meteroid:meteroid-java:0.1.0'
}
```

### Maven

```xml
<dependency>
    <groupId>com.meteroid</groupId>
    <artifactId>meteroid-java</artifactId>
    <version>0.1.0</version>
</dependency>
```

## Quick Start

```java
import com.meteroid.Meteroid;
import com.meteroid.MeteroidOptions;
import com.meteroid.models.*;

// Initialize the client
Meteroid meteroid = new Meteroid("your-api-key");

// Or with custom options
MeteroidOptions options = new MeteroidOptions();
options.setServerUrl("https://api.meteroid.com");
Meteroid meteroid = new Meteroid("your-api-key", options);
```

## Usage

### Customers

```java
// List customers
CustomerListResponse customers = meteroid.getCustomer().listCustomers();

// List with options
CustomerListCustomersOptions options = new CustomerListCustomersOptions();
options.page = 1L;
options.perPage = 20L;
options.search = "acme";
CustomerListResponse customers = meteroid.getCustomer().listCustomers(options);

// Create a customer
CustomerCreateRequest request = new CustomerCreateRequest()
    .name("Acme Corp")
    .alias("acme-corp")
    .email("billing@acme.com");
Customer customer = meteroid.getCustomer().createCustomer(request);

// Get a customer by ID or alias
Customer customer = meteroid.getCustomer().getCustomer("acme-corp");

// Update a customer
CustomerUpdateRequest updateRequest = new CustomerUpdateRequest()
    .name("Acme Corporation");
Customer updated = meteroid.getCustomer().updateCustomer("acme-corp", updateRequest);

// Archive a customer (all subscriptions must be terminated first)
meteroid.getCustomer().archiveCustomer("acme-corp");

// Generate a customer portal token
CustomerPortalTokenResponse token = meteroid.getCustomer().createPortalToken("acme-corp");
```

### Subscriptions

```java
// List subscriptions
SubscriptionListResponse subscriptions = meteroid.getSubscription().listSubscriptions();

// Create a subscription
SubscriptionCreateRequest request = new SubscriptionCreateRequest()
    .customerId("cust_123")
    .planVersionId("pv_456")
    .billingDay(1);
Subscription subscription = meteroid.getSubscription().createSubscription(request);

// Get subscription details
SubscriptionDetails details = meteroid.getSubscription().getSubscriptionDetails("sub_789");

// Cancel a subscription
CancelSubscriptionRequest cancelRequest = new CancelSubscriptionRequest()
    .reason("Customer requested");
meteroid.getSubscription().cancelSubscription("sub_789", cancelRequest);
```

### Plans

```java
// List plans
PlanListResponse plans = meteroid.getPlan().listPlans();

// Get a plan by ID or alias
Plan plan = meteroid.getPlan().getPlan("plan_123");
```

### Invoices

```java
// List invoices
InvoiceListResponse invoices = meteroid.getInvoice().listInvoices();

// Get an invoice
Invoice invoice = meteroid.getInvoice().getInvoice("inv_123");

// Download invoice as PDF
byte[] pdfBytes = meteroid.getInvoice().downloadInvoicePdf("inv_123");
```

### Product Families

```java
// List product families
ProductFamilyListResponse families = meteroid.getProductFamily().listProductFamilies();

// Create a product family
ProductFamilyCreateRequest request = new ProductFamilyCreateRequest()
    .name("SaaS Products")
    .externalId("saas-products");
ProductFamily family = meteroid.getProductFamily().createProductFamily(request);
```

### Events (Usage Tracking)

```java
// Ingest usage events
IngestEventsRequest request = new IngestEventsRequest()
    .events(Arrays.asList(
        new Event()
            .eventName("api_call")
            .customerId("cust_123")
            .timestamp(Instant.now())
            .properties(Map.of("endpoint", "/users", "method", "GET"))
    ));
IngestEventsResponse response = meteroid.getEvents().ingestEvents(request);
```

### Checkout Sessions

```java
// Create a checkout session
CreateCheckoutSessionRequest request = new CreateCheckoutSessionRequest()
    .customerId("cust_123")
    .planId("plan_456")
    .successUrl("https://example.com/success")
    .cancelUrl("https://example.com/cancel");
CreateCheckoutSessionResponse session = meteroid.getCheckoutSessions().createCheckoutSession(request);

// Get a checkout session
GetCheckoutSessionResponse session = meteroid.getCheckoutSessions().getCheckoutSession("cs_789");

// Cancel a checkout session
meteroid.getCheckoutSessions().cancelCheckoutSession("cs_789");
```

## Webhook Verification

The SDK provides utilities for verifying webhook signatures using the [Standard Webhooks](https://www.standardwebhooks.com/) specification. Meteroid uses Svix for webhook delivery, so the SDK supports both `svix-*` headers and `webhook-*` headers.

**Supported headers:**

- `svix-id`, `svix-timestamp`, `svix-signature` (Svix-branded)
- `webhook-id`, `webhook-timestamp`, `webhook-signature` (Standard Webhooks)

```java
import com.meteroid.Webhook;
import com.standardwebhooks.exceptions.WebhookVerificationException;

// Initialize with your webhook signing secret
Webhook webhook = new Webhook("whsec_your_secret_here");

// In your webhook endpoint handler:
try {
    // payload is the raw request body as a string
    // headers are the HTTP headers from the request
    webhook.verify(payload, headers);

    // Signature is valid, process the webhook
    // ...
} catch (WebhookVerificationException e) {
    // Invalid signature - reject the request
    return ResponseEntity.status(401).body("Invalid signature");
}
```

### Using with Spring Boot

```java
@RestController
public class WebhookController {
    private final Webhook webhook = new Webhook("whsec_your_secret");

    @PostMapping("/webhooks/meteroid")
    public ResponseEntity<String> handleWebhook(
            @RequestBody String payload,
            @RequestHeader Map<String, String> headerMap) {

        try {
            // Convert headers to the expected format
            Map<String, List<String>> headers = new HashMap<>();
            headerMap.forEach((k, v) -> headers.put(k.toLowerCase(), List.of(v)));

            webhook.verify(payload, headers);

            // Process the webhook event
            JsonNode event = objectMapper.readTree(payload);
            String eventType = event.get("type").asText();

            switch (eventType) {
                case "customer.created":
                    handleCustomerCreated(event);
                    break;
                case "invoice.finalized":
                    handleInvoiceFinalized(event);
                    break;
                // ... handle other event types
            }

            return ResponseEntity.ok("OK");
        } catch (WebhookVerificationException e) {
            return ResponseEntity.status(401).body("Invalid signature");
        }
    }
}
```

## Error Handling

The SDK throws `ApiException` for API errors:

```java
import com.meteroid.exceptions.ApiException;

try {
    Customer customer = meteroid.getCustomer().getCustomer("nonexistent");
} catch (ApiException e) {
    System.out.println("Status code: " + e.getCode());
    System.out.println("Error message: " + e.getMessage());
    System.out.println("Response body: " + e.getResponseBody());
} catch (IOException e) {
    System.out.println("Network error: " + e.getMessage());
}
```

## Configuration

### Custom Server URL

```java
MeteroidOptions options = new MeteroidOptions();
options.setServerUrl("https://meteroid-api.example.com");
Meteroid meteroid = new Meteroid("your-api-key", options);
```

### Retry Configuration

The SDK automatically retries requests on 5xx server errors. You can customize the retry schedule:

```java
MeteroidOptions options = new MeteroidOptions();
// Retry delays in milliseconds (default: 50ms, 100ms, 200ms)
options.setRetrySchedule(Arrays.asList(100L, 500L, 1000L));
Meteroid meteroid = new Meteroid("your-api-key", options);
```

## Building from Source

```bash
# Build the project
./gradlew build

# Run tests
./gradlew test
```

## Code Generation

The API client code is generated from the OpenAPI specification. To regenerate:

```bash
# Build the codegen Docker image (from repo root)
cd codegen && docker build -t meteroid-codegen:latest .

# Run code generation (from repo root)
./regen_openapi.py
```

## License

Apache License 2.0
