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
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * A connected account (relationship between platform and connected org)
 *
 * <p>Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class ConnectedAccount {
    @JsonProperty("connected_organization_id")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> connectedOrganizationId = JsonField.missing();

    @JsonProperty("connected_tenant_id")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> connectedTenantId = JsonField.missing();

    @JsonProperty("connection_type")
    private ConnectionType connectionType;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty("id")
    private String id;

    @JsonProperty("metadata")
    private Object metadata;

    @JsonProperty("onboarding_completed_at")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<OffsetDateTime> onboardingCompletedAt = JsonField.missing();

    @JsonProperty("onboarding_mode")
    private OnboardingMode onboardingMode;

    @JsonProperty("pending_country")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> pendingCountry = JsonField.missing();

    @JsonProperty("pending_email")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> pendingEmail = JsonField.missing();

    @JsonProperty("pending_organization_name")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> pendingOrganizationName = JsonField.missing();

    @JsonProperty("platform_customer_id")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> platformCustomerId = JsonField.missing();

    @JsonProperty("platform_organization_id")
    private String platformOrganizationId;

    @JsonProperty("revoked_at")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<OffsetDateTime> revokedAt = JsonField.missing();

    @JsonProperty("status")
    private ConnectionStatus status;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private ConnectedAccount() {}

    private ConnectedAccount(Builder builder) {
        this.connectedOrganizationId = builder.connectedOrganizationId;
        this.connectedTenantId = builder.connectedTenantId;
        this.connectionType = builder.connectionType;
        this.createdAt = builder.createdAt;
        this.id = builder.id;
        this.metadata = builder.metadata;
        this.onboardingCompletedAt = builder.onboardingCompletedAt;
        this.onboardingMode = builder.onboardingMode;
        this.pendingCountry = builder.pendingCountry;
        this.pendingEmail = builder.pendingEmail;
        this.pendingOrganizationName = builder.pendingOrganizationName;
        this.platformCustomerId = builder.platformCustomerId;
        this.platformOrganizationId = builder.platformOrganizationId;
        this.revokedAt = builder.revokedAt;
        this.status = builder.status;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code ConnectedAccount}.
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
        builder.connectedTenantId = connectedTenantId;
        builder.connectionType = connectionType;
        builder.createdAt = createdAt;
        builder.id = id;
        builder.metadata = metadata;
        builder.onboardingCompletedAt = onboardingCompletedAt;
        builder.onboardingMode = onboardingMode;
        builder.pendingCountry = pendingCountry;
        builder.pendingEmail = pendingEmail;
        builder.pendingOrganizationName = pendingOrganizationName;
        builder.platformCustomerId = platformCustomerId;
        builder.platformOrganizationId = platformOrganizationId;
        builder.revokedAt = revokedAt;
        builder.status = status;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code connected_organization_id} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> connectedOrganizationId() {
        return connectedOrganizationId.asOptional();
    }

    /**
     * The {@code connected_tenant_id} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> connectedTenantId() {
        return connectedTenantId.asOptional();
    }

    /**
     * The {@code connection_type} property.
     *
     * @return the value, never null
     */
    public ConnectionType connectionType() {
        return Utils.required(connectionType, "connection_type");
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
     * The {@code id} property.
     *
     * @return the value, never null
     */
    public String id() {
        return Utils.required(id, "id");
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
     * The {@code onboarding_completed_at} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<OffsetDateTime> onboardingCompletedAt() {
        return onboardingCompletedAt.asOptional();
    }

    /**
     * The {@code onboarding_mode} property.
     *
     * @return the value, never null
     */
    public OnboardingMode onboardingMode() {
        return Utils.required(onboardingMode, "onboarding_mode");
    }

    /**
     * The {@code pending_country} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> pendingCountry() {
        return pendingCountry.asOptional();
    }

    /**
     * Email of the user being invited (express flow only)
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> pendingEmail() {
        return pendingEmail.asOptional();
    }

    /**
     * Name of the organization to be created (express flow only)
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> pendingOrganizationName() {
        return pendingOrganizationName.asOptional();
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
     * The {@code platform_organization_id} property.
     *
     * @return the value, never null
     */
    public String platformOrganizationId() {
        return Utils.required(platformOrganizationId, "platform_organization_id");
    }

    /**
     * The {@code revoked_at} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<OffsetDateTime> revokedAt() {
        return revokedAt.asOptional();
    }

    /**
     * The {@code status} property.
     *
     * @return the value, never null
     */
    public ConnectionStatus status() {
        return Utils.required(status, "status");
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
        ConnectedAccount that = (ConnectedAccount) o;
        return Objects.equals(connectedOrganizationId, that.connectedOrganizationId)
                && Objects.equals(connectedTenantId, that.connectedTenantId)
                && Objects.equals(connectionType, that.connectionType)
                && Objects.equals(createdAt, that.createdAt)
                && Objects.equals(id, that.id)
                && Objects.equals(metadata, that.metadata)
                && Objects.equals(onboardingCompletedAt, that.onboardingCompletedAt)
                && Objects.equals(onboardingMode, that.onboardingMode)
                && Objects.equals(pendingCountry, that.pendingCountry)
                && Objects.equals(pendingEmail, that.pendingEmail)
                && Objects.equals(pendingOrganizationName, that.pendingOrganizationName)
                && Objects.equals(platformCustomerId, that.platformCustomerId)
                && Objects.equals(platformOrganizationId, that.platformOrganizationId)
                && Objects.equals(revokedAt, that.revokedAt)
                && Objects.equals(status, that.status)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                connectedOrganizationId,
                connectedTenantId,
                connectionType,
                createdAt,
                id,
                metadata,
                onboardingCompletedAt,
                onboardingMode,
                pendingCountry,
                pendingEmail,
                pendingOrganizationName,
                platformCustomerId,
                platformOrganizationId,
                revokedAt,
                status,
                additionalProperties);
    }

    @Override
    public String toString() {
        return "ConnectedAccount{"
                + "connectedOrganizationId="
                + connectedOrganizationId
                + ", connectedTenantId="
                + connectedTenantId
                + ", connectionType="
                + connectionType
                + ", createdAt="
                + createdAt
                + ", id="
                + id
                + ", metadata="
                + metadata
                + ", onboardingCompletedAt="
                + onboardingCompletedAt
                + ", onboardingMode="
                + onboardingMode
                + ", pendingCountry="
                + pendingCountry
                + ", pendingEmail="
                + pendingEmail
                + ", pendingOrganizationName="
                + pendingOrganizationName
                + ", platformCustomerId="
                + platformCustomerId
                + ", platformOrganizationId="
                + platformOrganizationId
                + ", revokedAt="
                + revokedAt
                + ", status="
                + status
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link ConnectedAccount}. */
    public static final class Builder {
        private JsonField<String> connectedOrganizationId = JsonField.missing();
        private JsonField<String> connectedTenantId = JsonField.missing();
        private ConnectionType connectionType;
        private OffsetDateTime createdAt;
        private String id;
        private Object metadata;
        private JsonField<OffsetDateTime> onboardingCompletedAt = JsonField.missing();
        private OnboardingMode onboardingMode;
        private JsonField<String> pendingCountry = JsonField.missing();
        private JsonField<String> pendingEmail = JsonField.missing();
        private JsonField<String> pendingOrganizationName = JsonField.missing();
        private JsonField<String> platformCustomerId = JsonField.missing();
        private String platformOrganizationId;
        private JsonField<OffsetDateTime> revokedAt = JsonField.missing();
        private ConnectionStatus status;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code connected_organization_id} property.
         *
         * @param connectedOrganizationId the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder connectedOrganizationId(String connectedOrganizationId) {
            this.connectedOrganizationId = JsonField.ofNullable(connectedOrganizationId);
            return this;
        }

        /**
         * The {@code connected_tenant_id} property.
         *
         * @param connectedTenantId the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder connectedTenantId(String connectedTenantId) {
            this.connectedTenantId = JsonField.ofNullable(connectedTenantId);
            return this;
        }

        /**
         * The {@code connection_type} property.
         *
         * @param connectionType the value
         * @return this builder
         */
        public Builder connectionType(ConnectionType connectionType) {
            this.connectionType = connectionType;
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
         * The {@code onboarding_completed_at} property.
         *
         * @param onboardingCompletedAt the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder onboardingCompletedAt(OffsetDateTime onboardingCompletedAt) {
            this.onboardingCompletedAt = JsonField.ofNullable(onboardingCompletedAt);
            return this;
        }

        /**
         * The {@code onboarding_mode} property.
         *
         * @param onboardingMode the value
         * @return this builder
         */
        public Builder onboardingMode(OnboardingMode onboardingMode) {
            this.onboardingMode = onboardingMode;
            return this;
        }

        /**
         * The {@code pending_country} property.
         *
         * @param pendingCountry the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder pendingCountry(String pendingCountry) {
            this.pendingCountry = JsonField.ofNullable(pendingCountry);
            return this;
        }

        /**
         * Email of the user being invited (express flow only)
         *
         * @param pendingEmail the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder pendingEmail(String pendingEmail) {
            this.pendingEmail = JsonField.ofNullable(pendingEmail);
            return this;
        }

        /**
         * Name of the organization to be created (express flow only)
         *
         * @param pendingOrganizationName the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder pendingOrganizationName(String pendingOrganizationName) {
            this.pendingOrganizationName = JsonField.ofNullable(pendingOrganizationName);
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
         * The {@code platform_organization_id} property.
         *
         * @param platformOrganizationId the value
         * @return this builder
         */
        public Builder platformOrganizationId(String platformOrganizationId) {
            this.platformOrganizationId = platformOrganizationId;
            return this;
        }

        /**
         * The {@code revoked_at} property.
         *
         * @param revokedAt the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder revokedAt(OffsetDateTime revokedAt) {
            this.revokedAt = JsonField.ofNullable(revokedAt);
            return this;
        }

        /**
         * The {@code status} property.
         *
         * @param status the value
         * @return this builder
         */
        public Builder status(ConnectionStatus status) {
            this.status = status;
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
         * The {@code ConnectedAccount}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public ConnectedAccount build() {
            Utils.checkRequired(connectionType, "connection_type");
            Utils.checkRequired(createdAt, "created_at");
            Utils.checkRequired(id, "id");
            Utils.checkRequired(onboardingMode, "onboarding_mode");
            Utils.checkRequired(platformOrganizationId, "platform_organization_id");
            Utils.checkRequired(status, "status");
            return new ConnectedAccount(this);
        }
    }

    /**
     * Parse {@code json} as {@code ConnectedAccount}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static ConnectedAccount fromJson(String json) {
        return Utils.parse(json, ConnectedAccount.class);
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
