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
public final class CreateConnectedAccountRequest {
    @JsonProperty("connected_organization_id")
    private UUID connectedOrganizationId;

    @JsonProperty("connection_type")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<ConnectionType> connectionType = JsonField.missing();

    @JsonProperty("metadata")
    private Object metadata;

    @JsonProperty("platform_customer_id")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> platformCustomerId = JsonField.missing();

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private CreateConnectedAccountRequest() {}

    private CreateConnectedAccountRequest(Builder builder) {
        this.connectedOrganizationId = builder.connectedOrganizationId;
        this.connectionType = builder.connectionType;
        this.metadata = builder.metadata;
        this.platformCustomerId = builder.platformCustomerId;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code CreateConnectedAccountRequest}.
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
        builder.connectedOrganizationId = connectedOrganizationId;
        builder.connectionType = connectionType;
        builder.metadata = metadata;
        builder.platformCustomerId = platformCustomerId;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code connected_organization_id} property.
     *
     * @return the value, never null
     */
    public UUID connectedOrganizationId() {
        return Utils.required(connectedOrganizationId, "connected_organization_id");
    }

    /**
     * The {@code connection_type} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<ConnectionType> connectionType() {
        return connectionType.asOptional();
    }

    /**
     * The {@code metadata} property.
     *
     * @return the value, empty when unset
     */
    public Optional<Object> metadata() {
        return Optional.ofNullable(metadata);
    }

    /**
     * The {@code platform_customer_id} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> platformCustomerId() {
        return platformCustomerId.asOptional();
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
        CreateConnectedAccountRequest that = (CreateConnectedAccountRequest) o;
        return Objects.equals(connectedOrganizationId, that.connectedOrganizationId)
                && Objects.equals(connectionType, that.connectionType)
                && Objects.equals(metadata, that.metadata)
                && Objects.equals(platformCustomerId, that.platformCustomerId)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                connectedOrganizationId,
                connectionType,
                metadata,
                platformCustomerId,
                additionalProperties);
    }

    @Override
    public String toString() {
        return "CreateConnectedAccountRequest{"
                + "connectedOrganizationId="
                + connectedOrganizationId
                + ", connectionType="
                + connectionType
                + ", metadata="
                + metadata
                + ", platformCustomerId="
                + platformCustomerId
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link CreateConnectedAccountRequest}. */
    public static final class Builder {
        private UUID connectedOrganizationId;
        private JsonField<ConnectionType> connectionType = JsonField.missing();
        private Object metadata;
        private JsonField<String> platformCustomerId = JsonField.missing();
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code connected_organization_id} property.
         *
         * @param connectedOrganizationId the value
         * @return this builder
         */
        public Builder connectedOrganizationId(UUID connectedOrganizationId) {
            this.connectedOrganizationId = connectedOrganizationId;
            return this;
        }

        /**
         * The {@code connection_type} property.
         *
         * @param connectionType the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder connectionType(ConnectionType connectionType) {
            this.connectionType = JsonField.ofNullable(connectionType);
            return this;
        }

        /**
         * The {@code metadata} property.
         *
         * @param metadata the value
         * @return this builder
         */
        public Builder metadata(Object metadata) {
            this.metadata = metadata;
            return this;
        }

        /**
         * The {@code platform_customer_id} property.
         *
         * @param platformCustomerId the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder platformCustomerId(String platformCustomerId) {
            this.platformCustomerId = JsonField.ofNullable(platformCustomerId);
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
         * The {@code CreateConnectedAccountRequest}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public CreateConnectedAccountRequest build() {
            Utils.checkRequired(connectedOrganizationId, "connected_organization_id");
            return new CreateConnectedAccountRequest(this);
        }
    }

    /**
     * Parse {@code json} as {@code CreateConnectedAccountRequest}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static CreateConnectedAccountRequest fromJson(String json) {
        return Utils.parse(json, CreateConnectedAccountRequest.class);
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
