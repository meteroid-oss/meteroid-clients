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

/**
 * Token introspection response as per RFC 7662
 *
 * <p>Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class TokenIntrospectionResponse {
    @JsonProperty("active")
    private Boolean active;

    @JsonProperty("client_id")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> clientId = JsonField.missing();

    @JsonProperty("exp")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Long> exp = JsonField.missing();

    @JsonProperty("iat")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Long> iat = JsonField.missing();

    @JsonProperty("scope")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> scope = JsonField.missing();

    @JsonProperty("sub")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> sub = JsonField.missing();

    @JsonProperty("token_type")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> tokenType = JsonField.missing();

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private TokenIntrospectionResponse() {}

    private TokenIntrospectionResponse(Builder builder) {
        this.active = builder.active;
        this.clientId = builder.clientId;
        this.exp = builder.exp;
        this.iat = builder.iat;
        this.scope = builder.scope;
        this.sub = builder.sub;
        this.tokenType = builder.tokenType;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code TokenIntrospectionResponse}.
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
        builder.active = active;
        builder.clientId = clientId;
        builder.exp = exp;
        builder.iat = iat;
        builder.scope = scope;
        builder.sub = sub;
        builder.tokenType = tokenType;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code active} property.
     *
     * @return the value, never null
     */
    public Boolean active() {
        return Utils.required(active, "active");
    }

    /**
     * The {@code client_id} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> clientId() {
        return clientId.asOptional();
    }

    /**
     * The {@code exp} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Long> exp() {
        return exp.asOptional();
    }

    /**
     * The {@code iat} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Long> iat() {
        return iat.asOptional();
    }

    /**
     * The {@code scope} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> scope() {
        return scope.asOptional();
    }

    /**
     * The {@code sub} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> sub() {
        return sub.asOptional();
    }

    /**
     * The {@code token_type} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> tokenType() {
        return tokenType.asOptional();
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
        TokenIntrospectionResponse that = (TokenIntrospectionResponse) o;
        return Objects.equals(active, that.active)
                && Objects.equals(clientId, that.clientId)
                && Objects.equals(exp, that.exp)
                && Objects.equals(iat, that.iat)
                && Objects.equals(scope, that.scope)
                && Objects.equals(sub, that.sub)
                && Objects.equals(tokenType, that.tokenType)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                active, clientId, exp, iat, scope, sub, tokenType, additionalProperties);
    }

    @Override
    public String toString() {
        return "TokenIntrospectionResponse{"
                + "active="
                + active
                + ", clientId="
                + clientId
                + ", exp="
                + exp
                + ", iat="
                + iat
                + ", scope="
                + scope
                + ", sub="
                + sub
                + ", tokenType="
                + tokenType
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link TokenIntrospectionResponse}. */
    public static final class Builder {
        private Boolean active;
        private JsonField<String> clientId = JsonField.missing();
        private JsonField<Long> exp = JsonField.missing();
        private JsonField<Long> iat = JsonField.missing();
        private JsonField<String> scope = JsonField.missing();
        private JsonField<String> sub = JsonField.missing();
        private JsonField<String> tokenType = JsonField.missing();
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code active} property.
         *
         * @param active the value
         * @return this builder
         */
        public Builder active(Boolean active) {
            this.active = active;
            return this;
        }

        /**
         * The {@code client_id} property.
         *
         * @param clientId the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder clientId(String clientId) {
            this.clientId = JsonField.ofNullable(clientId);
            return this;
        }

        /**
         * The {@code exp} property.
         *
         * @param exp the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder exp(Long exp) {
            this.exp = JsonField.ofNullable(exp);
            return this;
        }

        /**
         * The {@code iat} property.
         *
         * @param iat the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder iat(Long iat) {
            this.iat = JsonField.ofNullable(iat);
            return this;
        }

        /**
         * The {@code scope} property.
         *
         * @param scope the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder scope(String scope) {
            this.scope = JsonField.ofNullable(scope);
            return this;
        }

        /**
         * The {@code sub} property.
         *
         * @param sub the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder sub(String sub) {
            this.sub = JsonField.ofNullable(sub);
            return this;
        }

        /**
         * The {@code token_type} property.
         *
         * @param tokenType the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder tokenType(String tokenType) {
            this.tokenType = JsonField.ofNullable(tokenType);
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
         * The {@code TokenIntrospectionResponse}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public TokenIntrospectionResponse build() {
            Utils.checkRequired(active, "active");
            return new TokenIntrospectionResponse(this);
        }
    }

    /**
     * Parse {@code json} as {@code TokenIntrospectionResponse}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static TokenIntrospectionResponse fromJson(String json) {
        return Utils.parse(json, TokenIntrospectionResponse.class);
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
