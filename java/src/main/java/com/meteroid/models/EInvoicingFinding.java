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

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class EInvoicingFinding {
    @JsonProperty private String hint;
    @JsonProperty private String message;
    @JsonProperty private String rule;
    @JsonProperty private String term;

    public EInvoicingFinding() {}

    public EInvoicingFinding hint(String hint) {
        this.hint = hint;
        return this;
    }

    /**
     * Get hint
     *
     * @return hint
     */
    @javax.annotation.Nullable
    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public EInvoicingFinding message(String message) {
        this.message = message;
        return this;
    }

    /**
     * Get message
     *
     * @return message
     */
    @javax.annotation.Nonnull
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public EInvoicingFinding rule(String rule) {
        this.rule = rule;
        return this;
    }

    /**
     * The rule identifier — &quot;BR-11&quot;, &quot;PEPPOL-EN16931-R003&quot;.
     *
     * @return rule
     */
    @javax.annotation.Nonnull
    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public EInvoicingFinding term(String term) {
        this.term = term;
        return this;
    }

    /**
     * The business term path it is about — &quot;BG-8&#x2f;BT-55&quot;.
     *
     * @return term
     */
    @javax.annotation.Nonnull
    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    /**
     * Create an instance of EInvoicingFinding given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of EInvoicingFinding
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     EInvoicingFinding
     */
    public static EInvoicingFinding fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, EInvoicingFinding.class);
    }

    /**
     * Convert an instance of EInvoicingFinding to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
