package com.scribe;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.fasterxml.jackson.databind.type.LogicalType;

/** The one {@link ObjectMapper} this backend serializes its own contract with. */
public final class Json {

    private Json() {}

    private static final ObjectMapper MAPPER = create();

    public static ObjectMapper mapper() {
        return MAPPER;
    }

    private static ObjectMapper create() {
        ObjectMapper mapper = new ObjectMapper();

        // The contract is snake_case; the records in `Dto` are camelCase. One strategy here beats
        // a @JsonProperty on every component.
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);

        // Two settings deliberately left at Jackson's defaults, because the contract depends on
        // them:
        //
        //   * inclusion stays ALWAYS, so every response serializes every key — "nullable means
        //     present-and-null, never absent";
        //   * FAIL_ON_UNKNOWN_PROPERTIES stays on, which is `additionalProperties: false` for the
        //     request bodies (serde's `deny_unknown_fields` in the Rust backend).
        //
        // What is *not* the default: an absent required field must not silently become 0/false.
        mapper.enable(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES);

        // Nor is this. Jackson will happily coerce a JSON number or boolean into a String, so
        // `{"workspace_name": 123}` would deserialize to the string "123" and be accepted — while
        // the Rust backend's serde rejects it, and the contract types the field as `string`.
        //
        // That divergence is invisible until someone compares the two backends on the same
        // request, which is exactly what tests/contract does ("rejects a malformed body"). Turning
        // coercion off makes a type error a type error in both languages.
        mapper.coercionConfigFor(LogicalType.Textual)
                .setCoercion(CoercionInputShape.Integer, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.Float, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.Boolean, CoercionAction.Fail);

        return mapper;
    }
}
