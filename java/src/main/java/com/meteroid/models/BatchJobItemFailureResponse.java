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

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/** Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class BatchJobItemFailureResponse {
    @JsonProperty("chunk_id")
    private String chunkId;

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("item_identifier")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> itemIdentifier = JsonField.missing();

    @JsonProperty("item_index")
    private Integer itemIndex;

    @JsonProperty("reason")
    private String reason;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private BatchJobItemFailureResponse() {}

    private BatchJobItemFailureResponse(Builder builder) {
        this.chunkId = builder.chunkId;
        this.id = builder.id;
        this.itemIdentifier = builder.itemIdentifier;
        this.itemIndex = builder.itemIndex;
        this.reason = builder.reason;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code BatchJobItemFailureResponse}.
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
        builder.chunkId = chunkId;
        builder.id = id;
        builder.itemIdentifier = itemIdentifier;
        builder.itemIndex = itemIndex;
        builder.reason = reason;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code chunk_id} property.
     *
     * @return the value, never null
     */
    public String chunkId() {
        return Utils.required(chunkId, "chunk_id");
    }

    /**
     * The {@code id} property.
     *
     * @return the value, never null
     */
    public UUID id() {
        return Utils.required(id, "id");
    }

    /**
     * The {@code item_identifier} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> itemIdentifier() {
        return itemIdentifier.asOptional();
    }

    /**
     * The {@code item_index} property.
     *
     * @return the value, never null
     */
    public Integer itemIndex() {
        return Utils.required(itemIndex, "item_index");
    }

    /**
     * The {@code reason} property.
     *
     * @return the value, never null
     */
    public String reason() {
        return Utils.required(reason, "reason");
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
        BatchJobItemFailureResponse that = (BatchJobItemFailureResponse) o;
        return Objects.equals(chunkId, that.chunkId)
                && Objects.equals(id, that.id)
                && Objects.equals(itemIdentifier, that.itemIdentifier)
                && Objects.equals(itemIndex, that.itemIndex)
                && Objects.equals(reason, that.reason)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chunkId, id, itemIdentifier, itemIndex, reason, additionalProperties);
    }

    @Override
    public String toString() {
        return "BatchJobItemFailureResponse{"
                + "chunkId="
                + chunkId
                + ", id="
                + id
                + ", itemIdentifier="
                + itemIdentifier
                + ", itemIndex="
                + itemIndex
                + ", reason="
                + reason
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link BatchJobItemFailureResponse}. */
    public static final class Builder {
        private String chunkId;
        private UUID id;
        private JsonField<String> itemIdentifier = JsonField.missing();
        private Integer itemIndex;
        private String reason;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code chunk_id} property.
         *
         * @param chunkId the value
         * @return this builder
         */
        public Builder chunkId(String chunkId) {
            this.chunkId = chunkId;
            return this;
        }

        /**
         * The {@code id} property.
         *
         * @param id the value
         * @return this builder
         */
        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        /**
         * The {@code item_identifier} property.
         *
         * @param itemIdentifier the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder itemIdentifier(String itemIdentifier) {
            this.itemIdentifier = JsonField.ofNullable(itemIdentifier);
            return this;
        }

        /**
         * The {@code item_index} property.
         *
         * @param itemIndex the value
         * @return this builder
         */
        public Builder itemIndex(Integer itemIndex) {
            this.itemIndex = itemIndex;
            return this;
        }

        /**
         * The {@code reason} property.
         *
         * @param reason the value
         * @return this builder
         */
        public Builder reason(String reason) {
            this.reason = reason;
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
         * The {@code BatchJobItemFailureResponse}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public BatchJobItemFailureResponse build() {
            Utils.checkRequired(chunkId, "chunk_id");
            Utils.checkRequired(id, "id");
            Utils.checkRequired(itemIndex, "item_index");
            Utils.checkRequired(reason, "reason");
            return new BatchJobItemFailureResponse(this);
        }
    }

    /**
     * Parse {@code json} as {@code BatchJobItemFailureResponse}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static BatchJobItemFailureResponse fromJson(String json) {
        return Utils.parse(json, BatchJobItemFailureResponse.class);
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
