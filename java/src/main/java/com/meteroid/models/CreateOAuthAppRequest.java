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
public final class CreateOAuthAppRequest {
    @JsonProperty("name")
    private String name;

    @JsonProperty("redirect_uris")
    private List<String> redirectUris;

    @JsonProperty("scopes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<List<String>> scopes = JsonField.missing();

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private CreateOAuthAppRequest() {}

    private CreateOAuthAppRequest(Builder builder) {
        this.name = builder.name;
        this.redirectUris = Utils.copyList(builder.redirectUris);
        this.scopes = builder.scopes.map(Utils::copyList);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code CreateOAuthAppRequest}.
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
        builder.name = name;
        builder.redirectUris = Utils.mutableList(redirectUris);
        builder.scopes = scopes.map(Utils::mutableList);
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
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
     * @return the value, empty when unset or null
     */
    public Optional<List<String>> scopes() {
        return scopes.asOptional();
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
        CreateOAuthAppRequest that = (CreateOAuthAppRequest) o;
        return Objects.equals(name, that.name)
                && Objects.equals(redirectUris, that.redirectUris)
                && Objects.equals(scopes, that.scopes)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, redirectUris, scopes, additionalProperties);
    }

    @Override
    public String toString() {
        return "CreateOAuthAppRequest{"
                + "name="
                + name
                + ", redirectUris="
                + redirectUris
                + ", scopes="
                + scopes
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link CreateOAuthAppRequest}. */
    public static final class Builder {
        private String name;
        private List<String> redirectUris;
        private JsonField<List<String>> scopes = JsonField.missing();
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

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
         * @param scopes the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder scopes(List<String> scopes) {
            this.scopes = JsonField.ofNullable(Utils.mutableList(scopes));
            return this;
        }

        /**
         * Adds an item to {@code scopes}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addScopesItem(String item) {
            List<String> items = this.scopes.orNull();
            if (items == null) {
                items = new ArrayList<>();
                this.scopes = JsonField.ofNullable(items);
            }
            items.add(item);
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
         * The {@code CreateOAuthAppRequest}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public CreateOAuthAppRequest build() {
            Utils.checkRequired(name, "name");
            Utils.checkRequired(redirectUris, "redirect_uris");
            return new CreateOAuthAppRequest(this);
        }
    }

    /**
     * Parse {@code json} as {@code CreateOAuthAppRequest}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static CreateOAuthAppRequest fromJson(String json) {
        return Utils.parse(json, CreateOAuthAppRequest.class);
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
