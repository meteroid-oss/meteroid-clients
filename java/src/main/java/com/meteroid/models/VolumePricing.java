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
public class VolumePricing {
    @JsonProperty("block_size")
    private Long blockSize;

    @JsonProperty private List<TierRow> tiers;

    public VolumePricing() {}

    public VolumePricing blockSize(Long blockSize) {
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

    public VolumePricing tiers(List<TierRow> tiers) {
        this.tiers = tiers;
        return this;
    }

    public VolumePricing addTiersItem(TierRow tiersItem) {
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
     * Create an instance of VolumePricing given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of VolumePricing
     * @throws JsonProcessingException if the JSON string is invalid with respect to VolumePricing
     */
    public static VolumePricing fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, VolumePricing.class);
    }

    /**
     * Convert an instance of VolumePricing to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
