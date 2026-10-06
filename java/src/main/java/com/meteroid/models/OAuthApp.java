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

/**
 * An OAuth application registered by a platform
 *
 * <p>Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class OAuthApp {
    @JsonProperty("client_id")
    private String clientId;

    @JsonProperty("client_secret_hint")
    private String clientSecretHint;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty("id")
    private String id;

    @JsonProperty("is_active")
    private Boolean isActive;

    @JsonProperty("name")
    private String name;

    @JsonProperty("organization_id")
    private String organizationId;

    @JsonProperty("redirect_uris")
    private List<String> redirectUris;

    @JsonProperty("scopes")
    private List<String> scopes;

    @JsonProperty("updated_at")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<OffsetDateTime> updatedAt = JsonField.missing();

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private OAuthApp() {}

    private OAuthApp(Builder builder) {
        this.clientId = builder.clientId;
        this.clientSecretHint = builder.clientSecretHint;
        this.createdAt = builder.createdAt;
        this.id = builder.id;
        this.isActive = builder.isActive;
        this.name = builder.name;
        this.organizationId = builder.organizationId;
        this.redirectUris = Utils.copyList(builder.redirectUris);
        this.scopes = Utils.copyList(builder.scopes);
        this.updatedAt = builder.updatedAt;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code OAuthApp}.
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
        builder.clientId = clientId;
        builder.clientSecretHint = clientSecretHint;
        builder.createdAt = createdAt;
        builder.id = id;
        builder.isActive = isActive;
        builder.name = name;
        builder.organizationId = organizationId;
        builder.redirectUris = Utils.mutableList(redirectUris);
        builder.scopes = Utils.mutableList(scopes);
        builder.updatedAt = updatedAt;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code client_id} property.
     *
     * @return the value, never null
     */
    public String clientId() {
        return Utils.required(clientId, "client_id");
    }

    /**
     * The {@code client_secret_hint} property.
     *
     * @return the value, never null
     */
    public String clientSecretHint() {
        return Utils.required(clientSecretHint, "client_secret_hint");
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
     * The {@code is_active} property.
     *
     * @return the value, never null
     */
    public Boolean isActive() {
        return Utils.required(isActive, "is_active");
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
     * The {@code organization_id} property.
     *
     * @return the value, never null
     */
    public String organizationId() {
        return Utils.required(organizationId, "organization_id");
    }

    /**
     * The {@code redirect_uris} property.
     *
     * @return the value, never null
     */
    public List<String> redirectUris() {
        return Utils.required(redirectUris, "redirect_uris");
    }

    /**
     * The {@code scopes} property.
     *
     * @return the value, never null
     */
    public List<String> scopes() {
        return Utils.required(scopes, "scopes");
    }

    /**
     * The {@code updated_at} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<OffsetDateTime> updatedAt() {
        return updatedAt.asOptional();
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
        OAuthApp that = (OAuthApp) o;
        return Objects.equals(clientId, that.clientId)
                && Objects.equals(clientSecretHint, that.clientSecretHint)
                && Objects.equals(createdAt, that.createdAt)
                && Objects.equals(id, that.id)
                && Objects.equals(isActive, that.isActive)
                && Objects.equals(name, that.name)
                && Objects.equals(organizationId, that.organizationId)
                && Objects.equals(redirectUris, that.redirectUris)
                && Objects.equals(scopes, that.scopes)
                && Objects.equals(updatedAt, that.updatedAt)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                clientId,
                clientSecretHint,
                createdAt,
                id,
                isActive,
                name,
                organizationId,
                redirectUris,
                scopes,
                updatedAt,
                additionalProperties);
    }

    @Override
    public String toString() {
        return "OAuthApp{"
                + "clientId="
                + clientId
                + ", clientSecretHint="
                + clientSecretHint
                + ", createdAt="
                + createdAt
                + ", id="
                + id
                + ", isActive="
                + isActive
                + ", name="
                + name
                + ", organizationId="
                + organizationId
                + ", redirectUris="
                + redirectUris
                + ", scopes="
                + scopes
                + ", updatedAt="
                + updatedAt
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link OAuthApp}. */
    public static final class Builder {
        private String clientId;
        private String clientSecretHint;
        private OffsetDateTime createdAt;
        private String id;
        private Boolean isActive;
        private String name;
        private String organizationId;
        private List<String> redirectUris;
        private List<String> scopes;
        private JsonField<OffsetDateTime> updatedAt = JsonField.missing();
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code client_id} property.
         *
         * @param clientId the value
         * @return this builder
         */
        public Builder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        /**
         * The {@code client_secret_hint} property.
         *
         * @param clientSecretHint the value
         * @return this builder
         */
        public Builder clientSecretHint(String clientSecretHint) {
            this.clientSecretHint = clientSecretHint;
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
         * The {@code is_active} property.
         *
         * @param isActive the value
         * @return this builder
         */
        public Builder isActive(Boolean isActive) {
            this.isActive = isActive;
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
         * The {@code organization_id} property.
         *
         * @param organizationId the value
         * @return this builder
         */
        public Builder organizationId(String organizationId) {
            this.organizationId = organizationId;
            return this;
        }

        /**
         * The {@code redirect_uris} property.
         *
         * @param redirectUris the value
         * @return this builder
         */
        public Builder redirectUris(List<String> redirectUris) {
            this.redirectUris = Utils.mutableList(redirectUris);
            return this;
        }

        /**
         * Adds an item to {@code redirect_uris}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addRedirectUrisItem(String item) {
            if (this.redirectUris == null) {
                this.redirectUris = new ArrayList<>();
            }
            this.redirectUris.add(item);
            return this;
        }

        /**
         * The {@code scopes} property.
         *
         * @param scopes the value
         * @return this builder
         */
        public Builder scopes(List<String> scopes) {
            this.scopes = Utils.mutableList(scopes);
            return this;
        }

        /**
         * Adds an item to {@code scopes}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addScopesItem(String item) {
            if (this.scopes == null) {
                this.scopes = new ArrayList<>();
            }
            this.scopes.add(item);
            return this;
        }

        /**
         * The {@code updated_at} property.
         *
         * @param updatedAt the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder updatedAt(OffsetDateTime updatedAt) {
            this.updatedAt = JsonField.ofNullable(updatedAt);
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
         * The {@code OAuthApp}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public OAuthApp build() {
            Utils.checkRequired(clientId, "client_id");
            Utils.checkRequired(clientSecretHint, "client_secret_hint");
            Utils.checkRequired(createdAt, "created_at");
            Utils.checkRequired(id, "id");
            Utils.checkRequired(isActive, "is_active");
            Utils.checkRequired(name, "name");
            Utils.checkRequired(organizationId, "organization_id");
            Utils.checkRequired(redirectUris, "redirect_uris");
            Utils.checkRequired(scopes, "scopes");
            return new OAuthApp(this);
        }
    }

    /**
     * Parse {@code json} as {@code OAuthApp}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static OAuthApp fromJson(String json) {
        return Utils.parse(json, OAuthApp.class);
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
