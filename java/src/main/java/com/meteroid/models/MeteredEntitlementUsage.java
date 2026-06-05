// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.meteroid.Utils;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class MeteredEntitlementUsage {
    @JsonProperty private BigDecimal consumed;
    @JsonProperty private BigDecimal remaining;

    @JsonProperty("reset_at")
    private OffsetDateTime resetAt;

    public MeteredEntitlementUsage() {}

    public MeteredEntitlementUsage consumed(BigDecimal consumed) {
        this.consumed = consumed;
        return this;
    }

    /**
     * Get consumed
     *
     * @return consumed
     */
    @javax.annotation.Nullable
    public BigDecimal getConsumed() {
        return consumed;
    }

    public void setConsumed(BigDecimal consumed) {
        this.consumed = consumed;
    }

    public MeteredEntitlementUsage remaining(BigDecimal remaining) {
        this.remaining = remaining;
        return this;
    }

    /**
     * Get remaining
     *
     * @return remaining
     */
    @javax.annotation.Nullable
    public BigDecimal getRemaining() {
        return remaining;
    }

    public void setRemaining(BigDecimal remaining) {
        this.remaining = remaining;
    }

    public MeteredEntitlementUsage resetAt(OffsetDateTime resetAt) {
        this.resetAt = resetAt;
        return this;
    }

    /**
     * Get resetAt
     *
     * @return resetAt
     */
    @javax.annotation.Nullable
    public OffsetDateTime getResetAt() {
        return resetAt;
    }

    public void setResetAt(OffsetDateTime resetAt) {
        this.resetAt = resetAt;
    }

    /**
     * Create an instance of MeteredEntitlementUsage given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of MeteredEntitlementUsage
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     MeteredEntitlementUsage
     */
    public static MeteredEntitlementUsage fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, MeteredEntitlementUsage.class);
    }

    /**
     * Convert an instance of MeteredEntitlementUsage to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
