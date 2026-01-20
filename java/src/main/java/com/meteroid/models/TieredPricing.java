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

import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class TieredPricing {
    @JsonProperty("block_size")
    private Long blockSize;

    @JsonProperty private List<TierRow> tiers;

    public TieredPricing() {}

    public TieredPricing blockSize(Long blockSize) {
        this.blockSize = blockSize;
        return this;
    }

    /**
     * Get blockSize
     *
     * @return blockSize
     */
    @javax.annotation.Nullable
    public Long getBlockSize() {
        return blockSize;
    }

    public void setBlockSize(Long blockSize) {
        this.blockSize = blockSize;
    }

    public TieredPricing tiers(List<TierRow> tiers) {
        this.tiers = tiers;
        return this;
    }

    public TieredPricing addTiersItem(TierRow tiersItem) {
        if (this.tiers == null) {
            this.tiers = new ArrayList<>();
        }
        this.tiers.add(tiersItem);

        return this;
    }

    /**
     * Get tiers
     *
     * @return tiers
     */
    @javax.annotation.Nonnull
    public List<TierRow> getTiers() {
        return tiers;
    }

    public void setTiers(List<TierRow> tiers) {
        this.tiers = tiers;
    }

    /**
     * Create an instance of TieredPricing given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of TieredPricing
     * @throws JsonProcessingException if the JSON string is invalid with respect to TieredPricing
     */
    public static TieredPricing fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, TieredPricing.class);
    }

    /**
     * Convert an instance of TieredPricing to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
