// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.internal.Utils.ToQueryParam;

import java.util.Map;
import java.util.Objects;

/**
 * Values this version of the SDK does not know are kept, and sent back unchanged: {@link #value()}
 * is an enum to switch on, {@code _UNKNOWN} for them, and {@link #known()} throws on them.
 */
public final class EventType implements ToQueryParam {
    /** The value {@code "metric.created"}. */
    public static final EventType METRIC_CREATED =
            new EventType("metric.created", Value.METRIC_CREATED);

    /** The value {@code "customer.created"}. */
    public static final EventType CUSTOMER_CREATED =
            new EventType("customer.created", Value.CUSTOMER_CREATED);

    /** The value {@code "subscription.created"}. */
    public static final EventType SUBSCRIPTION_CREATED =
            new EventType("subscription.created", Value.SUBSCRIPTION_CREATED);

    /** The value {@code "subscription.updated"}. */
    public static final EventType SUBSCRIPTION_UPDATED =
            new EventType("subscription.updated", Value.SUBSCRIPTION_UPDATED);

    /** The value {@code "subscription.cancelled"}. */
    public static final EventType SUBSCRIPTION_CANCELLED =
            new EventType("subscription.cancelled", Value.SUBSCRIPTION_CANCELLED);

    /** The value {@code "subscription.ended"}. */
    public static final EventType SUBSCRIPTION_ENDED =
            new EventType("subscription.ended", Value.SUBSCRIPTION_ENDED);

    /** The value {@code "invoice.created"}. */
    public static final EventType INVOICE_CREATED =
            new EventType("invoice.created", Value.INVOICE_CREATED);

    /** The value {@code "invoice.finalized"}. */
    public static final EventType INVOICE_FINALIZED =
            new EventType("invoice.finalized", Value.INVOICE_FINALIZED);

    /** The value {@code "invoice.paid"}. */
    public static final EventType INVOICE_PAID = new EventType("invoice.paid", Value.INVOICE_PAID);

    /** The value {@code "invoice.voided"}. */
    public static final EventType INVOICE_VOIDED =
            new EventType("invoice.voided", Value.INVOICE_VOIDED);

    /** The value {@code "invoice.closed"}. */
    public static final EventType INVOICE_CLOSED =
            new EventType("invoice.closed", Value.INVOICE_CLOSED);

    /** The value {@code "invoice.consolidated"}. */
    public static final EventType INVOICE_CONSOLIDATED =
            new EventType("invoice.consolidated", Value.INVOICE_CONSOLIDATED);

    /** The value {@code "invoice.deleted"}. */
    public static final EventType INVOICE_DELETED =
            new EventType("invoice.deleted", Value.INVOICE_DELETED);

    /** The value {@code "invoice.accounting_pdf_generated"}. */
    public static final EventType INVOICE_ACCOUNTING_PDF_GENERATED =
            new EventType(
                    "invoice.accounting_pdf_generated", Value.INVOICE_ACCOUNTING_PDF_GENERATED);

    /** The value {@code "quote.accepted"}. */
    public static final EventType QUOTE_ACCEPTED =
            new EventType("quote.accepted", Value.QUOTE_ACCEPTED);

    /** The value {@code "quote.converted"}. */
    public static final EventType QUOTE_CONVERTED =
            new EventType("quote.converted", Value.QUOTE_CONVERTED);

    /** The value {@code "credit_note.created"}. */
    public static final EventType CREDIT_NOTE_CREATED =
            new EventType("credit_note.created", Value.CREDIT_NOTE_CREATED);

    /** The value {@code "credit_note.finalized"}. */
    public static final EventType CREDIT_NOTE_FINALIZED =
            new EventType("credit_note.finalized", Value.CREDIT_NOTE_FINALIZED);

    /** The value {@code "credit_note.voided"}. */
    public static final EventType CREDIT_NOTE_VOIDED =
            new EventType("credit_note.voided", Value.CREDIT_NOTE_VOIDED);

    /** The value {@code "plan.created"}. */
    public static final EventType PLAN_CREATED = new EventType("plan.created", Value.PLAN_CREATED);

    /** The value {@code "plan.published"}. */
    public static final EventType PLAN_PUBLISHED =
            new EventType("plan.published", Value.PLAN_PUBLISHED);

    /** The value {@code "plan.archived"}. */
    public static final EventType PLAN_ARCHIVED =
            new EventType("plan.archived", Value.PLAN_ARCHIVED);

    /** The value {@code "product.created"}. */
    public static final EventType PRODUCT_CREATED =
            new EventType("product.created", Value.PRODUCT_CREATED);

    /** The value {@code "product.updated"}. */
    public static final EventType PRODUCT_UPDATED =
            new EventType("product.updated", Value.PRODUCT_UPDATED);

    /** The value {@code "product.archived"}. */
    public static final EventType PRODUCT_ARCHIVED =
            new EventType("product.archived", Value.PRODUCT_ARCHIVED);

    /** The value {@code "metric.updated"}. */
    public static final EventType METRIC_UPDATED =
            new EventType("metric.updated", Value.METRIC_UPDATED);

    /** The value {@code "metric.archived"}. */
    public static final EventType METRIC_ARCHIVED =
            new EventType("metric.archived", Value.METRIC_ARCHIVED);

    /** The value {@code "coupon.created"}. */
    public static final EventType COUPON_CREATED =
            new EventType("coupon.created", Value.COUPON_CREATED);

    /** The value {@code "coupon.updated"}. */
    public static final EventType COUPON_UPDATED =
            new EventType("coupon.updated", Value.COUPON_UPDATED);

    /** The value {@code "coupon.archived"}. */
    public static final EventType COUPON_ARCHIVED =
            new EventType("coupon.archived", Value.COUPON_ARCHIVED);

    /** The value {@code "addon.created"}. */
    public static final EventType ADDON_CREATED =
            new EventType("addon.created", Value.ADDON_CREATED);

    /** The value {@code "addon.updated"}. */
    public static final EventType ADDON_UPDATED =
            new EventType("addon.updated", Value.ADDON_UPDATED);

    /** The value {@code "addon.archived"}. */
    public static final EventType ADDON_ARCHIVED =
            new EventType("addon.archived", Value.ADDON_ARCHIVED);

    private static final Map<String, EventType> constants =
            Map.ofEntries(
                    Map.entry("metric.created", METRIC_CREATED),
                    Map.entry("customer.created", CUSTOMER_CREATED),
                    Map.entry("subscription.created", SUBSCRIPTION_CREATED),
                    Map.entry("subscription.updated", SUBSCRIPTION_UPDATED),
                    Map.entry("subscription.cancelled", SUBSCRIPTION_CANCELLED),
                    Map.entry("subscription.ended", SUBSCRIPTION_ENDED),
                    Map.entry("invoice.created", INVOICE_CREATED),
                    Map.entry("invoice.finalized", INVOICE_FINALIZED),
                    Map.entry("invoice.paid", INVOICE_PAID),
                    Map.entry("invoice.voided", INVOICE_VOIDED),
                    Map.entry("invoice.closed", INVOICE_CLOSED),
                    Map.entry("invoice.consolidated", INVOICE_CONSOLIDATED),
                    Map.entry("invoice.deleted", INVOICE_DELETED),
                    Map.entry("invoice.accounting_pdf_generated", INVOICE_ACCOUNTING_PDF_GENERATED),
                    Map.entry("quote.accepted", QUOTE_ACCEPTED),
                    Map.entry("quote.converted", QUOTE_CONVERTED),
                    Map.entry("credit_note.created", CREDIT_NOTE_CREATED),
                    Map.entry("credit_note.finalized", CREDIT_NOTE_FINALIZED),
                    Map.entry("credit_note.voided", CREDIT_NOTE_VOIDED),
                    Map.entry("plan.created", PLAN_CREATED),
                    Map.entry("plan.published", PLAN_PUBLISHED),
                    Map.entry("plan.archived", PLAN_ARCHIVED),
                    Map.entry("product.created", PRODUCT_CREATED),
                    Map.entry("product.updated", PRODUCT_UPDATED),
                    Map.entry("product.archived", PRODUCT_ARCHIVED),
                    Map.entry("metric.updated", METRIC_UPDATED),
                    Map.entry("metric.archived", METRIC_ARCHIVED),
                    Map.entry("coupon.created", COUPON_CREATED),
                    Map.entry("coupon.updated", COUPON_UPDATED),
                    Map.entry("coupon.archived", COUPON_ARCHIVED),
                    Map.entry("addon.created", ADDON_CREATED),
                    Map.entry("addon.updated", ADDON_UPDATED),
                    Map.entry("addon.archived", ADDON_ARCHIVED));

    private final String value;
    private final Value variant;

    private EventType(String value, Value variant) {
        this.value = value;
        this.variant = variant;
    }

    /**
     * The constant for {@code value}, or an unknown EventType holding it.
     *
     * @param value the value
     * @return the constant
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static EventType of(String value) {
        EventType constant = constants.get(Objects.requireNonNull(value, "value"));
        return constant != null ? constant : new EventType(value, Value._UNKNOWN);
    }

    /**
     * The value as sent.
     *
     * @return the value
     */
    @JsonValue
    public String asString() {
        return value;
    }

    /**
     * Whether this version of the SDK knows the value.
     *
     * @return whether it is known
     */
    public boolean isKnown() {
        return variant != Value._UNKNOWN;
    }

    /**
     * The value as an enum to switch on, unknown values included.
     *
     * @return the enum, {@code _UNKNOWN} when unknown
     */
    public Value value() {
        return variant;
    }

    /**
     * The value as an enum of the known values only.
     *
     * @return the enum
     * @throws com.meteroid.exceptions.InvalidDataException when this version of the SDK does not
     *     know the value
     */
    public Known known() {
        if (!isKnown()) {
            throw new com.meteroid.exceptions.InvalidDataException("unknown EventType: " + value);
        }
        return Known.valueOf(variant.name());
    }

    @Override
    public String toQueryParam() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof EventType && Objects.equals(value, ((EventType) o).value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    /** The values this version of the SDK knows. */
    public enum Known {
        /** The {@code METRIC_CREATED} constant. */
        METRIC_CREATED,
        /** The {@code CUSTOMER_CREATED} constant. */
        CUSTOMER_CREATED,
        /** The {@code SUBSCRIPTION_CREATED} constant. */
        SUBSCRIPTION_CREATED,
        /** The {@code SUBSCRIPTION_UPDATED} constant. */
        SUBSCRIPTION_UPDATED,
        /** The {@code SUBSCRIPTION_CANCELLED} constant. */
        SUBSCRIPTION_CANCELLED,
        /** The {@code SUBSCRIPTION_ENDED} constant. */
        SUBSCRIPTION_ENDED,
        /** The {@code INVOICE_CREATED} constant. */
        INVOICE_CREATED,
        /** The {@code INVOICE_FINALIZED} constant. */
        INVOICE_FINALIZED,
        /** The {@code INVOICE_PAID} constant. */
        INVOICE_PAID,
        /** The {@code INVOICE_VOIDED} constant. */
        INVOICE_VOIDED,
        /** The {@code INVOICE_CLOSED} constant. */
        INVOICE_CLOSED,
        /** The {@code INVOICE_CONSOLIDATED} constant. */
        INVOICE_CONSOLIDATED,
        /** The {@code INVOICE_DELETED} constant. */
        INVOICE_DELETED,
        /** The {@code INVOICE_ACCOUNTING_PDF_GENERATED} constant. */
        INVOICE_ACCOUNTING_PDF_GENERATED,
        /** The {@code QUOTE_ACCEPTED} constant. */
        QUOTE_ACCEPTED,
        /** The {@code QUOTE_CONVERTED} constant. */
        QUOTE_CONVERTED,
        /** The {@code CREDIT_NOTE_CREATED} constant. */
        CREDIT_NOTE_CREATED,
        /** The {@code CREDIT_NOTE_FINALIZED} constant. */
        CREDIT_NOTE_FINALIZED,
        /** The {@code CREDIT_NOTE_VOIDED} constant. */
        CREDIT_NOTE_VOIDED,
        /** The {@code PLAN_CREATED} constant. */
        PLAN_CREATED,
        /** The {@code PLAN_PUBLISHED} constant. */
        PLAN_PUBLISHED,
        /** The {@code PLAN_ARCHIVED} constant. */
        PLAN_ARCHIVED,
        /** The {@code PRODUCT_CREATED} constant. */
        PRODUCT_CREATED,
        /** The {@code PRODUCT_UPDATED} constant. */
        PRODUCT_UPDATED,
        /** The {@code PRODUCT_ARCHIVED} constant. */
        PRODUCT_ARCHIVED,
        /** The {@code METRIC_UPDATED} constant. */
        METRIC_UPDATED,
        /** The {@code METRIC_ARCHIVED} constant. */
        METRIC_ARCHIVED,
        /** The {@code COUPON_CREATED} constant. */
        COUPON_CREATED,
        /** The {@code COUPON_UPDATED} constant. */
        COUPON_UPDATED,
        /** The {@code COUPON_ARCHIVED} constant. */
        COUPON_ARCHIVED,
        /** The {@code ADDON_CREATED} constant. */
        ADDON_CREATED,
        /** The {@code ADDON_UPDATED} constant. */
        ADDON_UPDATED,
        /** The {@code ADDON_ARCHIVED} constant. */
        ADDON_ARCHIVED
    }

    /** The values this version of the SDK knows, and {@code _UNKNOWN} for the others. */
    public enum Value {
        /** The {@code METRIC_CREATED} constant. */
        METRIC_CREATED,
        /** The {@code CUSTOMER_CREATED} constant. */
        CUSTOMER_CREATED,
        /** The {@code SUBSCRIPTION_CREATED} constant. */
        SUBSCRIPTION_CREATED,
        /** The {@code SUBSCRIPTION_UPDATED} constant. */
        SUBSCRIPTION_UPDATED,
        /** The {@code SUBSCRIPTION_CANCELLED} constant. */
        SUBSCRIPTION_CANCELLED,
        /** The {@code SUBSCRIPTION_ENDED} constant. */
        SUBSCRIPTION_ENDED,
        /** The {@code INVOICE_CREATED} constant. */
        INVOICE_CREATED,
        /** The {@code INVOICE_FINALIZED} constant. */
        INVOICE_FINALIZED,
        /** The {@code INVOICE_PAID} constant. */
        INVOICE_PAID,
        /** The {@code INVOICE_VOIDED} constant. */
        INVOICE_VOIDED,
        /** The {@code INVOICE_CLOSED} constant. */
        INVOICE_CLOSED,
        /** The {@code INVOICE_CONSOLIDATED} constant. */
        INVOICE_CONSOLIDATED,
        /** The {@code INVOICE_DELETED} constant. */
        INVOICE_DELETED,
        /** The {@code INVOICE_ACCOUNTING_PDF_GENERATED} constant. */
        INVOICE_ACCOUNTING_PDF_GENERATED,
        /** The {@code QUOTE_ACCEPTED} constant. */
        QUOTE_ACCEPTED,
        /** The {@code QUOTE_CONVERTED} constant. */
        QUOTE_CONVERTED,
        /** The {@code CREDIT_NOTE_CREATED} constant. */
        CREDIT_NOTE_CREATED,
        /** The {@code CREDIT_NOTE_FINALIZED} constant. */
        CREDIT_NOTE_FINALIZED,
        /** The {@code CREDIT_NOTE_VOIDED} constant. */
        CREDIT_NOTE_VOIDED,
        /** The {@code PLAN_CREATED} constant. */
        PLAN_CREATED,
        /** The {@code PLAN_PUBLISHED} constant. */
        PLAN_PUBLISHED,
        /** The {@code PLAN_ARCHIVED} constant. */
        PLAN_ARCHIVED,
        /** The {@code PRODUCT_CREATED} constant. */
        PRODUCT_CREATED,
        /** The {@code PRODUCT_UPDATED} constant. */
        PRODUCT_UPDATED,
        /** The {@code PRODUCT_ARCHIVED} constant. */
        PRODUCT_ARCHIVED,
        /** The {@code METRIC_UPDATED} constant. */
        METRIC_UPDATED,
        /** The {@code METRIC_ARCHIVED} constant. */
        METRIC_ARCHIVED,
        /** The {@code COUPON_CREATED} constant. */
        COUPON_CREATED,
        /** The {@code COUPON_UPDATED} constant. */
        COUPON_UPDATED,
        /** The {@code COUPON_ARCHIVED} constant. */
        COUPON_ARCHIVED,
        /** The {@code ADDON_CREATED} constant. */
        ADDON_CREATED,
        /** The {@code ADDON_UPDATED} constant. */
        ADDON_UPDATED,
        /** The {@code ADDON_ARCHIVED} constant. */
        ADDON_ARCHIVED,
        /** A value this version of the SDK does not know. */
        _UNKNOWN
    }
}
