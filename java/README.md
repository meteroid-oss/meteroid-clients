# Meteroid Java SDK

Meteroid billing API client

```kotlin
implementation("com.meteroid:meteroid:0.26.0")
```

```xml
<dependency>
  <groupId>com.meteroid</groupId>
  <artifactId>meteroid</artifactId>
  <version>0.26.0</version>
</dependency>
```

Requires Java 11 or later. Every method of the API is listed in [api.md](api.md).

## Usage

```java
import com.meteroid.Meteroid;

try (Meteroid client = Meteroid.fromEnv()) {
    var addOn = client.addOns().retrieve("addon_id");
    System.out.println(addOn);
}
```

The client can also be configured in code:

```java
import com.meteroid.MeteroidOptions;

Meteroid client = new Meteroid(
        MeteroidOptions.builder()
                .apiKey("your-api-key")
                .baseUrl("https://api.example.com")
                .timeout(Duration.ofSeconds(20))
                .maxRetries(3)
                .build());
```

Without an API key, the client reads `METEROID_API_KEY`, and `METEROID_BASE_URL`
overrides the server of the API, `Meteroid.DEFAULT_BASE_URL`; explicit settings win. An API
without a server has no default: the client then throws an `IllegalStateException` until one of
them sets the base URL. The client is `AutoCloseable`: closing it
releases its threads and connections. `httpClient(OkHttpClient)` shares your own OkHttp client
(left open on close), and `addInterceptor` wraps every attempt for logging, caching or signing.
Requests are logged through `System.Logger` (`com.meteroid`) at `DEBUG`, or at `INFO` with
`debug(true)`.

Required path, query and header parameters are method arguments; optional ones go in an
immutable `...Options` built with `builder()`. Every method has overloads taking a
`RequestOptions` last, for the headers, timeout, retries or idempotency key of one call:

```java
var addOn = client.addOns().retrieve("addon_id", RequestOptions.builder().timeout(Duration.ofSeconds(5)).maxRetries(0).build());
```

## Models

Models are immutable: `Model.builder()...build()` checks required properties, and
`model.toBuilder()...build()` changes a copy:

```java
import com.meteroid.models.CreateOnboardingLinkRequest;

var onboardingLinkResponse = client.connect().createOnboardingLink("id", CreateOnboardingLinkRequest.builder().redirectUrl("redirect_url").build());
```

Required properties are read directly (`model.id()`), others as an `Optional`. For an optional
property that accepts `null`, passing `null` to the builder sends `null`, while leaving it unset
leaves it out. Properties this SDK version does not know are kept in `additionalProperties()` and
sent back.

Enums keep values added to the API later: `isKnown()` tells them apart, `value()` is an enum to
`switch` on with `_UNKNOWN` for them, `known()` throws on them, and `asString()` is the raw value.
Unions keep unknown variants too (`isUnrecognized()`). A union tells its variants apart with
`isCircle()` and `asCircle()`, or with a visitor whose `visitUnknown` throws unless overridden:

```java
String description = shape.accept(new Shape.Visitor<String>() {
    @Override
    public String visitCircle(Circle circle) {
        return "circle of radius " + circle.radius();
    }

    @Override
    public String visitSquare(Square square) {
        return "square of side " + square.side();
    }
});
```

## Async and raw responses

`client.async()` has the same methods returning `CompletableFuture`s, sharing the client's
connections and retries. `withRawResponse()`, on either client, returns `ApiResponse`s with the
status code and headers along with the body:

```java
var response = client.withRawResponse().addOns().retrieve("addon_id");
response.statusCode();
response.requestId();
response.body();
```

## Errors

Every exception the SDK throws is a `MeteroidException`:

- `ApiException` for an error response, with `statusCode()`, `headers()`, `body()`,
  `requestId()` and `error(Type.class)` parsing the body as the error the API declares. Common
  statuses have a subclass: `BadRequestException`, `AuthenticationException`,
  `PermissionDeniedException`, `NotFoundException`, `ConflictException`,
  `UnprocessableEntityException`, `RateLimitException` and `InternalServerException`.
- `ApiConnectionException` when no response came, and its subclass `ApiTimeoutException`.
- `InvalidDataException` when a response is not what the API describes, such as a required
  property it left out.

```java
import com.meteroid.exceptions.NotFoundException;

try {
    client.addOns().retrieve("addon_id");
} catch (NotFoundException e) {
    System.out.println(e.statusCode() + " " + e.requestId());
}
```

Connection errors, timeouts, 408, 429 and 5xx responses are retried with jittered backoff,
honoring `Retry-After` and `retry-after-ms` up to a minute (the backoff otherwise), when the method
is idempotent or the request carries an `Idempotency-Key` (POST requests get one automatically).

- Source: https://github.com/meteroid-oss/meteroid-clients
- License: Apache-2.0
