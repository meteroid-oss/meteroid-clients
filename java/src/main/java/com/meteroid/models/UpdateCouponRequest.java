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
public class UpdateCouponRequest {
    @JsonProperty private String description;
    @JsonProperty private CouponDiscountRest discount;

    @JsonProperty("plan_ids")
    private List<String> planIds;

    public UpdateCouponRequest() {}

    public UpdateCouponRequest description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get description
     *
     * @return description
     */
    @javax.annotation.Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UpdateCouponRequest discount(CouponDiscountRest discount) {
        this.discount = discount;
        return this;
    }

    /**
     * Get discount
     *
     * @return discount
     */
    @javax.annotation.Nullable
    public CouponDiscountRest getDiscount() {
        return discount;
    }

    public void setDiscount(CouponDiscountRest discount) {
        this.discount = discount;
    }

    public UpdateCouponRequest planIds(List<String> planIds) {
        this.planIds = planIds;
        return this;
    }

    public UpdateCouponRequest addPlanIdsItem(String planIdsItem) {
        if (this.planIds == null) {
            this.planIds = new ArrayList<>();
        }
        this.planIds.add(planIdsItem);

        return this;
    }

    /**
     * Get planIds
     *
     * @return planIds
     */
    @javax.annotation.Nullable
    public List<String> getPlanIds() {
        return planIds;
    }

    public void setPlanIds(List<String> planIds) {
        this.planIds = planIds;
    }

    /**
     * Create an instance of UpdateCouponRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of UpdateCouponRequest
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     UpdateCouponRequest
     */
    public static UpdateCouponRequest fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, UpdateCouponRequest.class);
    }

    /**
     * Convert an instance of UpdateCouponRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
