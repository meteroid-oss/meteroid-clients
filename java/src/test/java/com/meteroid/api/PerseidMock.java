// this file is @generated
package com.meteroid.api;

import com.meteroid.Meteroid;
import com.meteroid.MeteroidOptions;
import com.meteroid.internal.Utils;

import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/** The mock client of the generated tests: every request gets the same canned response. */
final class PerseidMock {
    /** The method and path of each request. */
    final List<String> requests = new ArrayList<>();

    /** A client answering every request with this response. */
    final Meteroid client;

    PerseidMock(int status, String contentType, String body) {
        MediaType mediaType = contentType == null ? null : MediaType.get(contentType);
        MeteroidOptions options =
                MeteroidOptions.builder()
                        .baseUrl("http://localhost")
                        .maxRetries(0)
                        .addInterceptor(
                                chain -> {
                                    requests.add(
                                            chain.request().method()
                                                    + " "
                                                    + chain.request().url().encodedPath());
                                    Response.Builder response =
                                            new Response.Builder()
                                                    .request(chain.request())
                                                    .protocol(Protocol.HTTP_1_1)
                                                    .code(status)
                                                    .message("mock")
                                                    .body(ResponseBody.create(body, mediaType));
                                    if (contentType != null) {
                                        response.header("Content-Type", contentType);
                                    }
                                    return response.build();
                                })
                        .build();
        client = new Meteroid(options);
    }

    /** The {@code type} that JSON {@code text} holds. */
    static <T> T decode(Class<T> type, String text) throws Exception {
        return Utils.getObjectMapper().readValue(text, type);
    }
}
