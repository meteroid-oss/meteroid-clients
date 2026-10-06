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

import java.time.OffsetDateTime;
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
public final class Plan {
    @JsonProperty("available_parameters")
    private AvailableParameters availableParameters;

    @JsonProperty("billing_cycles")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Integer> billingCycles = JsonField.missing();

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("description")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> description = JsonField.missing();

    @JsonProperty("entitlements")
    private List<Entitlement> entitlements;

    @JsonProperty("id")
    private String id;

    @JsonProperty("minimum_commitment")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<MinimumCommitment> minimumCommitment = JsonField.missing();

    @JsonProperty("name")
    private String name;

    @JsonProperty("net_terms")
    private Integer netTerms;

    @JsonProperty("period_start_day")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Integer> periodStartDay = JsonField.missing();

    @JsonProperty("plan_type")
    private PlanTypeEnum planType;

    @JsonProperty("price_components")
    private List<PriceComponent> priceComponents;

    @JsonProperty("product_family")
    private ProductFamily productFamily;

    @JsonProperty("self_service_rank")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Integer> selfServiceRank = JsonField.missing();

    @JsonProperty("status")
    private PlanStatusEnum status;

    @JsonProperty("trial")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<TrialConfig> trial = JsonField.missing();

    @JsonProperty("version")
    private Integer version;

    @JsonProperty("version_id")
    private String versionId;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private Plan() {}

    private Plan(Builder builder) {
        this.availableParameters = builder.availableParameters;
        this.billingCycles = builder.billingCycles;
        this.createdAt = builder.createdAt;
        this.currency = builder.currency;
        this.description = builder.description;
        this.entitlements = Utils.copyList(builder.entitlements);
        this.id = builder.id;
        this.minimumCommitment = builder.minimumCommitment;
        this.name = builder.name;
        this.netTerms = builder.netTerms;
        this.periodStartDay = builder.periodStartDay;
        this.planType = builder.planType;
        this.priceComponents = Utils.copyList(builder.priceComponents);
        this.productFamily = builder.productFamily;
        this.selfServiceRank = builder.selfServiceRank;
        this.status = builder.status;
        this.trial = builder.trial;
        this.version = builder.version;
        this.versionId = builder.versionId;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code Plan}.
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
        builder.availableParameters = availableParameters;
        builder.billingCycles = billingCycles;
        builder.createdAt = createdAt;
        builder.currency = currency;
        builder.description = description;
        builder.entitlements = Utils.mutableList(entitlements);
        builder.id = id;
        builder.minimumCommitment = minimumCommitment;
        builder.name = name;
        builder.netTerms = netTerms;
        builder.periodStartDay = periodStartDay;
        builder.planType = planType;
        builder.priceComponents = Utils.mutableList(priceComponents);
        builder.productFamily = productFamily;
        builder.selfServiceRank = selfServiceRank;
        builder.status = status;
        builder.trial = trial;
        builder.version = version;
        builder.versionId = versionId;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code available_parameters} property.
     *
     * @return the value, never null
     */
    public AvailableParameters availableParameters() {
        return Utils.required(availableParameters, "available_parameters");
    }

    /**
     * The {@code billing_cycles} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Integer> billingCycles() {
        return billingCycles.asOptional();
    }

    /**
     * The {@code created_at} property.
     *
     * @return the value, never null
     */
    public OffsetDateTime createdAt() {
        return Utils.required(createdAt, "created_at");
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
     * The {@code entitlements} property.
     *
     * @return the value, empty when unset
     */
    public Optional<List<Entitlement>> entitlements() {
        return Optional.ofNullable(entitlements);
    }

    /**
     * The {@code id} property.
     *
     * @return the value, never null
     */
    public String id() {
        return Utils.required(id, "id");
    }

    /**
     * The {@code minimum_commitment} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<MinimumCommitment> minimumCommitment() {
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
     * The {@code net_terms} property.
     *
     * @return the value, never null
     */
    public Integer netTerms() {
        return Utils.required(netTerms, "net_terms");
    }

    /**
     * The {@code period_start_day} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Integer> periodStartDay() {
        return periodStartDay.asOptional();
    }

    /**
     * The {@code plan_type} property.
     *
     * @return the value, never null
     */
    public PlanTypeEnum planType() {
        return Utils.required(planType, "plan_type");
    }

    /**
     * The {@code price_components} property.
     *
     * @return the value, never null
     */
    public List<PriceComponent> priceComponents() {
        return Utils.required(priceComponents, "price_components");
    }

    /**
     * The {@code product_family} property.
     *
     * @return the value, never null
     */
    public ProductFamily productFamily() {
        return Utils.required(productFamily, "product_family");
    }

    /**
     * The {@code self_service_rank} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Integer> selfServiceRank() {
        return selfServiceRank.asOptional();
    }

    /**
     * The {@code status} property.
     *
     * @return the value, never null
     */
    public PlanStatusEnum status() {
        return Utils.required(status, "status");
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
     * The {@code version} property.
     *
     * @return the value, never null
     */
    public Integer version() {
        return Utils.required(version, "version");
    }

    /**
     * The {@code version_id} property.
     *
     * @return the value, never null
     */
    public String versionId() {
        return Utils.required(versionId, "version_id");
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
        Plan that = (Plan) o;
        return Objects.equals(availableParameters, that.availableParameters)
                && Objects.equals(billingCycles, that.billingCycles)
                && Objects.equals(createdAt, that.createdAt)
                && Objects.equals(currency, that.currency)
                && Objects.equals(description, that.description)
                && Objects.equals(entitlements, that.entitlements)
                && Objects.equals(id, that.id)
                && Objects.equals(minimumCommitment, that.minimumCommitment)
                && Objects.equals(name, that.name)
                && Objects.equals(netTerms, that.netTerms)
                && Objects.equals(periodStartDay, that.periodStartDay)
                && Objects.equals(planType, that.planType)
                && Objects.equals(priceComponents, that.priceComponents)
                && Objects.equals(productFamily, that.productFamily)
                && Objects.equals(selfServiceRank, that.selfServiceRank)
                && Objects.equals(status, that.status)
                && Objects.equals(trial, that.trial)
                && Objects.equals(version, that.version)
                && Objects.equals(versionId, that.versionId)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                availableParameters,
                billingCycles,
                createdAt,
                currency,
                description,
                entitlements,
                id,
                minimumCommitment,
                name,
                netTerms,
                periodStartDay,
                planType,
                priceComponents,
                productFamily,
                selfServiceRank,
                status,
                trial,
                version,
                versionId,
                additionalProperties);
    }

    @Override
    public String toString() {
        return "Plan{"
                + "availableParameters="
                + availableParameters
                + ", billingCycles="
                + billingCycles
                + ", createdAt="
                + createdAt
                + ", currency="
                + currency
                + ", description="
                + description
                + ", entitlements="
                + entitlements
                + ", id="
                + id
                + ", minimumCommitment="
                + minimumCommitment
                + ", name="
                + name
                + ", netTerms="
                + netTerms
                + ", periodStartDay="
                + periodStartDay
                + ", planType="
                + planType
                + ", priceComponents="
                + priceComponents
                + ", productFamily="
                + productFamily
                + ", selfServiceRank="
                + selfServiceRank
                + ", status="
                + status
                + ", trial="
                + trial
                + ", version="
                + version
                + ", versionId="
                + versionId
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link Plan}. */
    public static final class Builder {
        private AvailableParameters availableParameters;
        private JsonField<Integer> billingCycles = JsonField.missing();
        private OffsetDateTime createdAt;
        private String currency;
        private JsonField<String> description = JsonField.missing();
        private List<Entitlement> entitlements;
        private String id;
        private JsonField<MinimumCommitment> minimumCommitment = JsonField.missing();
        private String name;
        private Integer netTerms;
        private JsonField<Integer> periodStartDay = JsonField.missing();
        private PlanTypeEnum planType;
        private List<PriceComponent> priceComponents;
        private ProductFamily productFamily;
        private JsonField<Integer> selfServiceRank = JsonField.missing();
        private PlanStatusEnum status;
        private JsonField<TrialConfig> trial = JsonField.missing();
        private Integer version;
        private String versionId;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code available_parameters} property.
         *
         * @param availableParameters the value
         * @return this builder
         */
        public Builder availableParameters(AvailableParameters availableParameters) {
            this.availableParameters = availableParameters;
            return this;
        }

        /**
         * The {@code billing_cycles} property.
         *
         * @param billingCycles the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder billingCycles(Integer billingCycles) {
            this.billingCycles = JsonField.ofNullable(billingCycles);
            return this;
        }

        /**
         * The {@code created_at} property.
         *
         * @param createdAt the value
         * @return this builder
         */
        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
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
         * The {@code entitlements} property.
         *
         * @param entitlements the value
         * @return this builder
         */
        public Builder entitlements(List<Entitlement> entitlements) {
            this.entitlements = Utils.mutableList(entitlements);
            return this;
        }

        /**
         * Adds an item to {@code entitlements}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addEntitlementsItem(Entitlement item) {
            if (this.entitlements == null) {
                this.entitlements = new ArrayList<>();
            }
            this.entitlements.add(item);
            return this;
        }

        /**
         * The {@code id} property.
         *
         * @param id the value
         * @return this builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * The {@code minimum_commitment} property.
         *
         * @param minimumCommitment the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder minimumCommitment(MinimumCommitment minimumCommitment) {
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
         * The {@code net_terms} property.
         *
         * @param netTerms the value
         * @return this builder
         */
        public Builder netTerms(Integer netTerms) {
            this.netTerms = netTerms;
            return this;
        }

        /**
         * The {@code period_start_day} property.
         *
         * @param periodStartDay the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder periodStartDay(Integer periodStartDay) {
            this.periodStartDay = JsonField.ofNullable(periodStartDay);
            return this;
        }

        /**
         * The {@code plan_type} property.
         *
         * @param planType the value
         * @return this builder
         */
        public Builder planType(PlanTypeEnum planType) {
            this.planType = planType;
            return this;
        }

        /**
         * The {@code price_components} property.
         *
         * @param priceComponents the value
         * @return this builder
         */
        public Builder priceComponents(List<PriceComponent> priceComponents) {
            this.priceComponents = Utils.mutableList(priceComponents);
            return this;
        }

        /**
         * Adds an item to {@code price_components}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addPriceComponentsItem(PriceComponent item) {
            if (this.priceComponents == null) {
                this.priceComponents = new ArrayList<>();
            }
            this.priceComponents.add(item);
            return this;
        }

        /**
         * The {@code product_family} property.
         *
         * @param productFamily the value
         * @return this builder
         */
        public Builder productFamily(ProductFamily productFamily) {
            this.productFamily = productFamily;
            return this;
        }

        /**
         * The {@code self_service_rank} property.
         *
         * @param selfServiceRank the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder selfServiceRank(Integer selfServiceRank) {
            this.selfServiceRank = JsonField.ofNullable(selfServiceRank);
            return this;
        }

        /**
         * The {@code status} property.
         *
         * @param status the value
         * @return this builder
         */
        public Builder status(PlanStatusEnum status) {
            this.status = status;
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
         * The {@code version} property.
         *
         * @param version the value
         * @return this builder
         */
        public Builder version(Integer version) {
            this.version = version;
            return this;
        }

        /**
         * The {@code version_id} property.
         *
         * @param versionId the value
         * @return this builder
         */
        public Builder versionId(String versionId) {
            this.versionId = versionId;
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
         * The {@code Plan}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public Plan build() {
            Utils.checkRequired(availableParameters, "available_parameters");
            Utils.checkRequired(createdAt, "created_at");
            Utils.checkRequired(currency, "currency");
            Utils.checkRequired(id, "id");
            Utils.checkRequired(name, "name");
            Utils.checkRequired(netTerms, "net_terms");
            Utils.checkRequired(planType, "plan_type");
            Utils.checkRequired(priceComponents, "price_components");
            Utils.checkRequired(productFamily, "product_family");
            Utils.checkRequired(status, "status");
            Utils.checkRequired(version, "version");
            Utils.checkRequired(versionId, "version_id");
            return new Plan(this);
        }
    }

    /**
     * Parse {@code json} as {@code Plan}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static Plan fromJson(String json) {
        return Utils.parse(json, Plan.class);
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
