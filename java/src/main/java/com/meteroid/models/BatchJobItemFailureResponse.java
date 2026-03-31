// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.meteroid.Utils;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class BatchJobItemFailureResponse {
    @JsonProperty("chunk_id")
    private String chunkId;

    @JsonProperty private String id;

    @JsonProperty("item_identifier")
    private String itemIdentifier;

    @JsonProperty("item_index")
    private Integer itemIndex;

    @JsonProperty private String reason;

    public BatchJobItemFailureResponse() {}

    public BatchJobItemFailureResponse chunkId(String chunkId) {
        this.chunkId = chunkId;
        return this;
    }

    /**
     * Get chunkId
     *
     * @return chunkId
     */
    @javax.annotation.Nonnull
    public String getChunkId() {
        return chunkId;
    }

    public void setChunkId(String chunkId) {
        this.chunkId = chunkId;
    }

    public BatchJobItemFailureResponse id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     */
    @javax.annotation.Nonnull
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BatchJobItemFailureResponse itemIdentifier(String itemIdentifier) {
        this.itemIdentifier = itemIdentifier;
        return this;
    }

    /**
     * Get itemIdentifier
     *
     * @return itemIdentifier
     */
    @javax.annotation.Nullable
    public String getItemIdentifier() {
        return itemIdentifier;
    }

    public void setItemIdentifier(String itemIdentifier) {
        this.itemIdentifier = itemIdentifier;
    }

    public BatchJobItemFailureResponse itemIndex(Integer itemIndex) {
        this.itemIndex = itemIndex;
        return this;
    }

    /**
     * Get itemIndex
     *
     * @return itemIndex
     */
    @javax.annotation.Nonnull
    public Integer getItemIndex() {
        return itemIndex;
    }

    public void setItemIndex(Integer itemIndex) {
        this.itemIndex = itemIndex;
    }

    public BatchJobItemFailureResponse reason(String reason) {
        this.reason = reason;
        return this;
    }

    /**
     * Get reason
     *
     * @return reason
     */
    @javax.annotation.Nonnull
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * Create an instance of BatchJobItemFailureResponse given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of BatchJobItemFailureResponse
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     BatchJobItemFailureResponse
     */
    public static BatchJobItemFailureResponse fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, BatchJobItemFailureResponse.class);
    }

    /**
     * Convert an instance of BatchJobItemFailureResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
