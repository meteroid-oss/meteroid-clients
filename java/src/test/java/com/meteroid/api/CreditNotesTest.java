// this file is @generated
package com.meteroid.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.List;

class CreditNotesTest {

    @Test
    void list() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"data\":[{\"created_at\":\"2023-12-31T23:59:59.999-05:30\",\"credit_note_number\":\"sample\",\"credit_type\":\"DEBT_CANCELLATION\",\"credited_amount_cents\":9007199254740993,\"currency\":\"TMT\",\"custom_properties\":{\"key\":\"value\",\"count\":3,\"ratio\":0.5,\"flags\":[true,false],\"nested\":{\"ok\":true}},\"customer_id\":\"customer_id_78\",\"id\":\"credit_note_id_47\",\"invoice_id\":\"invoice_id_67\",\"invoice_number\":\"sample\",\"line_items\":[{\"amount_total\":-9007199254740993,\"end_date\":\"2024-02-29\",\"name\":\"sample\",\"start_date\":\"2024-02-29\",\"sub_line_items\":[{\"id\":\"sample\",\"name\":\"sample\",\"quantity\":\"-0.000123\",\"total\":9007199254740993,\"unit_price\":\"-0.000123\"}],\"tax_rate\":\"-0.000123\"}],\"refunded_amount_cents\":9007199254740993,\"status\":\"DRAFT\",\"subtotal\":-9007199254740993,\"tax_amount\":9007199254740993,\"tax_breakdown\":[{\"name\":\"sample\",\"tax_amount\":-9007199254740993,\"tax_rate\":\"-0.000123\",\"taxable_amount\":-9007199254740993}],\"total\":-9007199254740993}],\"pagination_meta\":{\"page\":-123456789,\"per_page\":-123456789,\"total_items\":-9007199254740993,\"total_pages\":123456789}}");
        mock.client.creditNotes().list();
        assertEquals(List.of("GET /api/v1/credit-notes"), mock.requests);
    }

    @Test
    void retrieve() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"created_at\":\"2023-12-31T23:59:59.999-05:30\",\"credit_note_number\":\"sample\",\"credit_type\":\"REFUND\",\"credited_amount_cents\":9007199254740993,\"currency\":\"MMK\",\"custom_properties\":{\"key\":\"value\",\"count\":3,\"ratio\":0.5,\"flags\":[true,false],\"nested\":{\"ok\":true}},\"customer_id\":\"customer_id_13\",\"id\":\"credit_note_id_99\",\"invoice_id\":\"invoice_id_90\",\"invoice_number\":\"sample\",\"line_items\":[{\"amount_total\":-9007199254740993,\"end_date\":\"2024-02-29\",\"name\":\"sample\",\"start_date\":\"1999-12-31\",\"sub_line_items\":[{\"id\":\"sample\",\"name\":\"sample\",\"quantity\":\"12345.6789\",\"total\":-9007199254740993,\"unit_price\":\"12345.6789\"}],\"tax_rate\":\"-0.000123\"}],\"refunded_amount_cents\":-9007199254740993,\"status\":\"DRAFT\",\"subtotal\":9007199254740993,\"tax_amount\":9007199254740993,\"tax_breakdown\":[{\"name\":\"sample\",\"tax_amount\":9007199254740993,\"tax_rate\":\"12345.6789\",\"taxable_amount\":9007199254740993}],\"total\":-9007199254740993}");
        mock.client.creditNotes().retrieve("credit_note_id");
        assertEquals(List.of("GET /api/v1/credit-notes/credit_note_id"), mock.requests);
    }

    @Test
    void updateCustomProperties() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"created_at\":\"2023-12-31T23:59:59.999-05:30\",\"credit_note_number\":\"sample\",\"credit_type\":\"REFUND\",\"credited_amount_cents\":9007199254740993,\"currency\":\"MMK\",\"custom_properties\":{\"key\":\"value\",\"count\":3,\"ratio\":0.5,\"flags\":[true,false],\"nested\":{\"ok\":true}},\"customer_id\":\"customer_id_13\",\"id\":\"credit_note_id_99\",\"invoice_id\":\"invoice_id_90\",\"invoice_number\":\"sample\",\"line_items\":[{\"amount_total\":-9007199254740993,\"end_date\":\"2024-02-29\",\"name\":\"sample\",\"start_date\":\"1999-12-31\",\"sub_line_items\":[{\"id\":\"sample\",\"name\":\"sample\",\"quantity\":\"12345.6789\",\"total\":-9007199254740993,\"unit_price\":\"12345.6789\"}],\"tax_rate\":\"-0.000123\"}],\"refunded_amount_cents\":-9007199254740993,\"status\":\"DRAFT\",\"subtotal\":9007199254740993,\"tax_amount\":9007199254740993,\"tax_breakdown\":[{\"name\":\"sample\",\"tax_amount\":9007199254740993,\"tax_rate\":\"12345.6789\",\"taxable_amount\":9007199254740993}],\"total\":-9007199254740993}");
        mock.client
                .creditNotes()
                .updateCustomProperties(
                        "credit_note_id",
                        PerseidMock.decode(
                                com.meteroid.models.CreditNoteCustomPropertiesRequest.class,
                                "{\"custom_properties\":{\"key\":\"value\",\"count\":3,\"ratio\":0.5,\"flags\":[true,false],\"nested\":{\"ok\":true}}}"));
        assertEquals(
                List.of("PATCH /api/v1/credit-notes/credit_note_id/custom-properties"),
                mock.requests);
    }

    @Test
    void download() throws Exception {
        PerseidMock mock = new PerseidMock(200, "application/octet-stream", "sample");
        mock.client.creditNotes().download("credit_note_id");
        assertEquals(List.of("GET /api/v1/credit-notes/credit_note_id/download"), mock.requests);
    }

    @Test
    void downloadXml() throws Exception {
        PerseidMock mock = new PerseidMock(200, "application/octet-stream", "sample");
        mock.client.creditNotes().downloadXml("credit_note_id");
        assertEquals(List.of("GET /api/v1/credit-notes/credit_note_id/xml"), mock.requests);
    }
}
