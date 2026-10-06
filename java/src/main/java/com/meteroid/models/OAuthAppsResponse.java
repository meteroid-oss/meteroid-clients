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
import com.meteroid.internal.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/** Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class OAuthAppsResponse {
    @JsonProperty("data")
    private List<OAuthApp> data;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private OAuthAppsResponse() {}

    private OAuthAppsResponse(Builder builder) {
        this.data = Utils.copyList(builder.data);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code OAuthAppsResponse}.
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
        builder.data = Utils.mutableList(data);
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code data} property.
     *
     * @return the value, never null
     */
    public List<OAuthApp> data() {
        return Utils.required(data, "data");
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
        OAuthAppsResponse that = (OAuthAppsResponse) o;
        return Objects.equals(data, that.data)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, additionalProperties);
    }

    @Override
    public String toString() {
        return "OAuthAppsResponse{"
                + "data="
                + data
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link OAuthAppsResponse}. */
    public static final class Builder {
        private List<OAuthApp> data;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code data} property.
         *
         * @param data the value
         * @return this builder
         */
        public Builder data(List<OAuthApp> data) {
            this.data = Utils.mutableList(data);
            return this;
        }

        /**
         * Adds an item to {@code data}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addDataItem(OAuthApp item) {
            if (this.data == null) {
                this.data = new ArrayList<>();
            }
            this.data.add(item);
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
         * The {@code OAuthAppsResponse}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public OAuthAppsResponse build() {
            Utils.checkRequired(data, "data");
            return new OAuthAppsResponse(this);
        }
    }

    /**
     * Parse {@code json} as {@code OAuthAppsResponse}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static OAuthAppsResponse fromJson(String json) {
        return Utils.parse(json, OAuthAppsResponse.class);
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
