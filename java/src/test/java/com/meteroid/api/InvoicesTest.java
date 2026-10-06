// this file is @generated
package com.meteroid.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.List;

class InvoicesTest {

    @Test
    void list() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"data\":[{\"amount_due\":-9007199254740993,\"applied_credits\":-9007199254740993,\"coupons\":[{\"coupon_id\":\"sample\",\"name\":\"sample\",\"total\":-9007199254740993}],\"created_at\":\"2024-03-15T10:30:45.123+02:00\",\"currency\":\"CNY\",\"custom_properties\":{\"key\":\"value\",\"count\":3,\"ratio\":0.5,\"flags\":[true,false],\"nested\":{\"ok\":true}},\"customer_details\":{\"id\":\"customer_id_39\",\"name\":\"sample\",\"snapshot_at\":\"2023-12-31T23:59:59.999-05:30\"},\"customer_id\":\"customer_id_67\",\"id\":\"invoice_id_67\",\"invoice_date\":\"1999-12-31\",\"invoice_number\":\"sample\",\"invoice_type\":\"RECURRING\",\"line_items\":[{\"amount_total\":9007199254740993,\"end_date\":\"2024-02-29\",\"name\":\"sample\",\"start_date\":\"2024-02-29\",\"sub_line_items\":[{\"id\":\"sample\",\"name\":\"sample\",\"quantity\":\"-0.000123\",\"total\":-9007199254740993,\"unit_price\":\"-0.000123\"}],\"tax_rate\":\"12345.6789\"}],\"net_terms\":-2147483648,\"payment_status\":\"PARTIALLY_PAID\",\"status\":\"FINALIZED\",\"subtotal\":-9007199254740993,\"subtotal_recurring\":9007199254740993,\"tax_amount\":9007199254740993,\"tax_breakdown\":[{\"name\":\"sample\",\"tax_amount\":-9007199254740993,\"tax_rate\":\"12345.6789\",\"taxable_amount\":9007199254740993}],\"total\":-9007199254740993,\"transactions\":[{\"amount\":-9007199254740993,\"currency\":\"sample\",\"id\":\"payment_transaction_id_40\",\"payment_type\":\"PAYMENT\",\"status\":\"CANCELLED\"}]}],\"pagination_meta\":{\"page\":-123456789,\"per_page\":-123456789,\"total_items\":-9007199254740993,\"total_pages\":123456789}}");
        mock.client.invoices().list();
        assertEquals(List.of("GET /api/v1/invoices"), mock.requests);
    }

    @Test
    void retrieve() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"amount_due\":-9007199254740993,\"applied_credits\":9007199254740993,\"coupons\":[{\"coupon_id\":\"sample\",\"name\":\"sample\",\"total\":-9007199254740993}],\"created_at\":\"2024-03-15T10:30:45.123+02:00\",\"currency\":\"NAD\",\"custom_properties\":{\"key\":\"value\",\"count\":3,\"ratio\":0.5,\"flags\":[true,false],\"nested\":{\"ok\":true}},\"customer_details\":{\"id\":\"customer_id_62\",\"name\":\"sample\",\"snapshot_at\":\"2024-03-15T10:30:45.123+02:00\"},\"customer_id\":\"customer_id_90\",\"id\":\"invoice_id_31\",\"invoice_date\":\"1999-12-31\",\"invoice_number\":\"sample\",\"invoice_type\":\"ONE_OFF\",\"line_items\":[{\"amount_total\":9007199254740993,\"end_date\":\"1999-12-31\",\"name\":\"sample\",\"start_date\":\"1999-12-31\",\"sub_line_items\":[{\"id\":\"sample\",\"name\":\"sample\",\"quantity\":\"-0.000123\",\"total\":-9007199254740993,\"unit_price\":\"-0.000123\"}],\"tax_rate\":\"-0.000123\"}],\"net_terms\":-2147483648,\"payment_status\":\"UNPAID\",\"status\":\"DRAFT\",\"subtotal\":9007199254740993,\"subtotal_recurring\":9007199254740993,\"tax_amount\":-9007199254740993,\"tax_breakdown\":[{\"name\":\"sample\",\"tax_amount\":9007199254740993,\"tax_rate\":\"-0.000123\",\"taxable_amount\":9007199254740993}],\"total\":9007199254740993,\"transactions\":[{\"amount\":9007199254740993,\"currency\":\"sample\",\"id\":\"payment_transaction_id_56\",\"payment_type\":\"REFUND\",\"status\":\"CANCELLED\"}]}");
        mock.client.invoices().retrieve("invoice_id");
        assertEquals(List.of("GET /api/v1/invoices/invoice_id"), mock.requests);
    }

    @Test
    void updateCustomProperties() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"amount_due\":-9007199254740993,\"applied_credits\":9007199254740993,\"coupons\":[{\"coupon_id\":\"sample\",\"name\":\"sample\",\"total\":-9007199254740993}],\"created_at\":\"2024-03-15T10:30:45.123+02:00\",\"currency\":\"NAD\",\"custom_properties\":{\"key\":\"value\",\"count\":3,\"ratio\":0.5,\"flags\":[true,false],\"nested\":{\"ok\":true}},\"customer_details\":{\"id\":\"customer_id_62\",\"name\":\"sample\",\"snapshot_at\":\"2024-03-15T10:30:45.123+02:00\"},\"customer_id\":\"customer_id_90\",\"id\":\"invoice_id_31\",\"invoice_date\":\"1999-12-31\",\"invoice_number\":\"sample\",\"invoice_type\":\"ONE_OFF\",\"line_items\":[{\"amount_total\":9007199254740993,\"end_date\":\"1999-12-31\",\"name\":\"sample\",\"start_date\":\"1999-12-31\",\"sub_line_items\":[{\"id\":\"sample\",\"name\":\"sample\",\"quantity\":\"-0.000123\",\"total\":-9007199254740993,\"unit_price\":\"-0.000123\"}],\"tax_rate\":\"-0.000123\"}],\"net_terms\":-2147483648,\"payment_status\":\"UNPAID\",\"status\":\"DRAFT\",\"subtotal\":9007199254740993,\"subtotal_recurring\":9007199254740993,\"tax_amount\":-9007199254740993,\"tax_breakdown\":[{\"name\":\"sample\",\"tax_amount\":9007199254740993,\"tax_rate\":\"-0.000123\",\"taxable_amount\":9007199254740993}],\"total\":9007199254740993,\"transactions\":[{\"amount\":9007199254740993,\"currency\":\"sample\",\"id\":\"payment_transaction_id_56\",\"payment_type\":\"REFUND\",\"status\":\"CANCELLED\"}]}");
        mock.client
                .invoices()
                .updateCustomProperties(
                        "invoice_id",
                        PerseidMock.decode(
                                com.meteroid.models.InvoiceCustomPropertiesRequest.class,
                                "{\"custom_properties\":{\"key\":\"value\",\"count\":3,\"ratio\":0.5,\"flags\":[true,false],\"nested\":{\"ok\":true}}}"));
        assertEquals(List.of("PATCH /api/v1/invoices/invoice_id/custom-properties"), mock.requests);
    }

    @Test
    void download() throws Exception {
        PerseidMock mock = new PerseidMock(200, "application/octet-stream", "sample");
        mock.client.invoices().download("invoice_id");
        assertEquals(List.of("GET /api/v1/invoices/invoice_id/download"), mock.requests);
    }

    @Test
    void refresh() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"amount_due\":-9007199254740993,\"applied_credits\":9007199254740993,\"coupons\":[{\"coupon_id\":\"sample\",\"name\":\"sample\",\"total\":-9007199254740993}],\"created_at\":\"2024-03-15T10:30:45.123+02:00\",\"currency\":\"NAD\",\"custom_properties\":{\"key\":\"value\",\"count\":3,\"ratio\":0.5,\"flags\":[true,false],\"nested\":{\"ok\":true}},\"customer_details\":{\"id\":\"customer_id_62\",\"name\":\"sample\",\"snapshot_at\":\"2024-03-15T10:30:45.123+02:00\"},\"customer_id\":\"customer_id_90\",\"id\":\"invoice_id_31\",\"invoice_date\":\"1999-12-31\",\"invoice_number\":\"sample\",\"invoice_type\":\"ONE_OFF\",\"line_items\":[{\"amount_total\":9007199254740993,\"end_date\":\"1999-12-31\",\"name\":\"sample\",\"start_date\":\"1999-12-31\",\"sub_line_items\":[{\"id\":\"sample\",\"name\":\"sample\",\"quantity\":\"-0.000123\",\"total\":-9007199254740993,\"unit_price\":\"-0.000123\"}],\"tax_rate\":\"-0.000123\"}],\"net_terms\":-2147483648,\"payment_status\":\"UNPAID\",\"status\":\"DRAFT\",\"subtotal\":9007199254740993,\"subtotal_recurring\":9007199254740993,\"tax_amount\":-9007199254740993,\"tax_breakdown\":[{\"name\":\"sample\",\"tax_amount\":9007199254740993,\"tax_rate\":\"-0.000123\",\"taxable_amount\":9007199254740993}],\"total\":9007199254740993,\"transactions\":[{\"amount\":9007199254740993,\"currency\":\"sample\",\"id\":\"payment_transaction_id_56\",\"payment_type\":\"REFUND\",\"status\":\"CANCELLED\"}]}");
        mock.client.invoices().refresh("invoice_id");
        assertEquals(List.of("POST /api/v1/invoices/invoice_id/refresh"), mock.requests);
    }

    @Test
    void downloadXml() throws Exception {
        PerseidMock mock = new PerseidMock(200, "application/octet-stream", "sample");
        mock.client.invoices().downloadXml("invoice_id");
        assertEquals(List.of("GET /api/v1/invoices/invoice_id/xml"), mock.requests);
    }
}
