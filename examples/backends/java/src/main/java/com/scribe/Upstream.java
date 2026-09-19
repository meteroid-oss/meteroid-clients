package com.scribe;

import com.meteroid.exceptions.ApiException;

import java.io.IOException;

/**
 * One place where a Meteroid SDK failure becomes an {@link ApiError}.
 *
 * <p>The SDK's methods declare two checked exceptions — {@link ApiException} for a non-2xx response
 * and {@link IOException} for "could not reach Meteroid at all". Rather than repeat that {@code
 * try/catch} in ten handlers, every call goes through {@link #call}, which names the Meteroid
 * endpoint for the error message:
 *
 * <pre>{@code
 * Customer customer = Upstream.call(
 *         "POST /api/v1/customers", () -> meteroid.getCustomers().createCustomer(request));
 * }</pre>
 *
 * <p>This is what the Rust backend's {@code error::upstream} does for {@code Result}; Java's
 * checked exceptions just need the lambda to carry them out.
 */
public final class Upstream {

    private Upstream() {}

    /** A Meteroid SDK call, with the two checked exceptions the SDK declares. */
    @FunctionalInterface
    public interface Call<T> {
        T execute() throws IOException, ApiException;
    }

    /**
     * @param context the Meteroid endpoint being called, e.g. {@code "GET /api/v1/plans"}. It ends
     *     up in the error message an operator reads, so name the real endpoint.
     */
    public static <T> T call(String context, Call<T> call) {
        try {
            return call.execute();
        } catch (ApiException e) {
            throw ApiError.upstream(context, e);
        } catch (IOException e) {
            throw ApiError.unreachable(context, e);
        }
    }
}
