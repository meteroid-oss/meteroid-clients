// this file is @generated
package com.meteroid.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.List;

class EventsTest {

    @Test
    void ingest() throws Exception {
        PerseidMock mock = new PerseidMock(200, "application/json", "{}");
        mock.client
                .events()
                .ingest(
                        PerseidMock.decode(
                                com.meteroid.models.IngestEventsRequest.class,
                                "{\"events\":[{\"code\":\"sample\",\"customer_id\":\"sample\",\"event_id\":\"sample\",\"timestamp\":\"sample\"}]}"));
        assertEquals(List.of("POST /api/v1/events/ingest"), mock.requests);
    }
}
