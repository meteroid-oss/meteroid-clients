// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.meteroid.internal.JsonField;
import com.meteroid.internal.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/** Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class ReplacePlanRequest {
    @JsonProperty("add_ons")
    private List<PlanAddOnInput> addOns;

    @JsonProperty("billing")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<BillingConfig> billing = JsonField.missing();

    @JsonProperty("components")
    private List<PriceComponentInput> components;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("description")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> description = JsonField.missing();

    @JsonProperty("minimum_commitment")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<MinimumCommitmentInput> minimumCommitment = JsonField.missing();

    @JsonProperty("name")
    private String name;

    @JsonProperty("status")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<PlanStatusEnum> status = JsonField.missing();

    @JsonProperty("trial")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<TrialConfig> trial = JsonField.missing();

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private ReplacePlanRequest() {}

    private ReplacePlanRequest(Builder builder) {
        this.addOns = Utils.copyList(builder.addOns);
        this.billing = builder.billing;
        this.components = Utils.copyList(builder.components);
        this.currency = builder.currency;
        this.description = builder.description;
        this.minimumCommitment = builder.minimumCommitment;
        this.name = builder.name;
        this.status = builder.status;
        this.trial = builder.trial;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code ReplacePlanRequest}.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * A builder starting from this value.
     *
     * @return a new builder
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.addOns = Utils.mutableList(addOns);
        builder.billing = billing;
        builder.components = Utils.mutableList(components);
        builder.currency = currency;
        builder.description = description;
        builder.minimumCommitment = minimumCommitment;
        builder.name = name;
        builder.status = status;
        builder.trial = trial;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code add_ons} property.
     *
     * @return the value, empty when unset
     */
    public Optional<List<PlanAddOnInput>> addOns() {
        return Optional.ofNullable(addOns);
    }

    /**
     * The {@code billing} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<BillingConfig> billing() {
        return billing.asOptional();
    }

    /**
     * The {@code components} property.
     *
     * @return the value, never null
     */
    public List<PriceComponentInput> components() {
        return Utils.required(components, "components");
    }

    /**
     * The {@code currency} property.
     *
     * @return the value, never null
     */
    public String currency() {
        return Utils.required(currency, "currency");
    }

    /**
     * The {@code description} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> description() {
        return description.asOptional();
    }

    /**
     * The {@code minimum_commitment} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<MinimumCommitmentInput> minimumCommitment() {
        return minimumCommitment.asOptional();
    }

    /**
     * The {@code name} property.
     *
     * @return the value, never null
     */
    public String name() {
        return Utils.required(name, "name");
    }

    /**
     * The {@code status} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<PlanStatusEnum> status() {
        return status.asOptional();
    }

    /**
     * The {@code trial} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<TrialConfig> trial() {
        return trial.asOptional();
    }

    /**
     * Properties this version of the SDK does not know, kept as received and sent back.
     *
     * @return the properties by name, unmodifiable
     */
    public Map<String, JsonNode> additionalProperties() {
        return Collections.unmodifiableMap(additionalProperties);
    }

    @JsonAnyGetter
    private Map<String, JsonNode> anyProperties() {
        return additionalProperties;
    }

    @JsonAnySetter
    private void putAnyProperty(String name, JsonNode value) {
        additionalProperties.put(name, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ReplacePlanRequest that = (ReplacePlanRequest) o;
        return Objects.equals(addOns, that.addOns)
                && Objects.equals(billing, that.billing)
                && Objects.equals(components, that.components)
                && Objects.equals(currency, that.currency)
                && Objects.equals(description, that.description)
                && Objects.equals(minimumCommitment, that.minimumCommitment)
                && Objects.equals(name, that.name)
                && Objects.equals(status, that.status)
                && Objects.equals(trial, that.trial)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                addOns,
                billing,
                components,
                currency,
                description,
                minimumCommitment,
                name,
                status,
                trial,
                additionalProperties);
    }

    @Override
    public String toString() {
        return "ReplacePlanRequest{"
                + "addOns="
                + addOns
                + ", billing="
                + billing
                + ", components="
                + components
                + ", currency="
                + currency
                + ", description="
                + description
                + ", minimumCommitment="
                + minimumCommitment
                + ", name="
                + name
                + ", status="
                + status
                + ", trial="
                + trial
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link ReplacePlanRequest}. */
    public static final class Builder {
        private List<PlanAddOnInput> addOns;
        private JsonField<BillingConfig> billing = JsonField.missing();
        private List<PriceComponentInput> components;
        private String currency;
        private JsonField<String> description = JsonField.missing();
        private JsonField<MinimumCommitmentInput> minimumCommitment = JsonField.missing();
        private String name;
        private JsonField<PlanStatusEnum> status = JsonField.missing();
        private JsonField<TrialConfig> trial = JsonField.missing();
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code add_ons} property.
         *
         * @param addOns the value
         * @return this builder
         */
        public Builder addOns(List<PlanAddOnInput> addOns) {
            this.addOns = Utils.mutableList(addOns);
            return this;
        }

        /**
         * Adds an item to {@code add_ons}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addAddOnsItem(PlanAddOnInput item) {
            if (this.addOns == null) {
                this.addOns = new ArrayList<>();
            }
            this.addOns.add(item);
            return this;
        }

        /**
         * The {@code billing} property.
         *
         * @param billing the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder billing(BillingConfig billing) {
            this.billing = JsonField.ofNullable(billing);
            return this;
        }

        /**
         * The {@code components} property.
         *
         * @param components the value
         * @return this builder
         */
        public Builder components(List<PriceComponentInput> components) {
            this.components = Utils.mutableList(components);
            return this;
        }

        /**
         * Adds an item to {@code components}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addComponentsItem(PriceComponentInput item) {
            if (this.components == null) {
                this.components = new ArrayList<>();
            }
            this.components.add(item);
            return this;
        }

        /**
         * The {@code currency} property.
         *
         * @param currency the value
         * @return this builder
         */
        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }

        /**
         * The {@code description} property.
         *
         * @param description the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder description(String description) {
            this.description = JsonField.ofNullable(description);
            return this;
        }

        /**
         * The {@code minimum_commitment} property.
         *
         * @param minimumCommitment the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder minimumCommitment(MinimumCommitmentInput minimumCommitment) {
            this.minimumCommitment = JsonField.ofNullable(minimumCommitment);
            return this;
        }

        /**
         * The {@code name} property.
         *
         * @param name the value
         * @return this builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * The {@code status} property.
         *
         * @param status the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder status(PlanStatusEnum status) {
            this.status = JsonField.ofNullable(status);
            return this;
        }

        /**
         * The {@code trial} property.
         *
         * @param trial the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder trial(TrialConfig trial) {
            this.trial = JsonField.ofNullable(trial);
            return this;
        }

        /**
         * A property the SDK does not know, sent along.
         *
         * @param name the property name
         * @param value the JSON value
         * @return this builder
         */
        public Builder putAdditionalProperty(String name, JsonNode value) {
            additionalProperties.put(name, value);
            return this;
        }

        /**
         * Properties the SDK does not know, sent along.
         *
         * @param additionalProperties the properties by name
         * @return this builder
         */
        public Builder putAllAdditionalProperties(Map<String, JsonNode> additionalProperties) {
            this.additionalProperties.putAll(additionalProperties);
            return this;
        }

        /**
         * Leaves out a property the SDK does not know.
         *
         * @param name the property name
         * @return this builder
         */
        public Builder removeAdditionalProperty(String name) {
            additionalProperties.remove(name);
            return this;
        }

        /**
         * The {@code ReplacePlanRequest}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public ReplacePlanRequest build() {
            Utils.checkRequired(components, "components");
            Utils.checkRequired(currency, "currency");
            Utils.checkRequired(name, "name");
            return new ReplacePlanRequest(this);
        }
    }

    /**
     * Parse {@code json} as {@code ReplacePlanRequest}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static ReplacePlanRequest fromJson(String json) {
        return Utils.parse(json, ReplacePlanRequest.class);
    }

    /**
     * This value as JSON.
     *
     * @return the JSON text
     */
    public String toJson() {
        return Utils.json(this);
    }
}
