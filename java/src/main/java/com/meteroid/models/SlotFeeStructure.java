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
public class SlotFeeStructure {
    @JsonProperty("downgrade_policy")
    private SlotDowngradePolicyEnum downgradePolicy;

    @JsonProperty("slot_unit_name")
    private String slotUnitName;

    @JsonProperty("upgrade_policy")
    private SlotUpgradePolicyEnum upgradePolicy;

    public SlotFeeStructure() {}

    public SlotFeeStructure downgradePolicy(SlotDowngradePolicyEnum downgradePolicy) {
        this.downgradePolicy = downgradePolicy;
        return this;
    }

    /**
     * Get downgradePolicy
     *
     * @return downgradePolicy
     */
    @javax.annotation.Nonnull
    public SlotDowngradePolicyEnum getDowngradePolicy() {
        return downgradePolicy;
    }

    public void setDowngradePolicy(SlotDowngradePolicyEnum downgradePolicy) {
        this.downgradePolicy = downgradePolicy;
    }

    public SlotFeeStructure slotUnitName(String slotUnitName) {
        this.slotUnitName = slotUnitName;
        return this;
    }

    /**
     * Get slotUnitName
     *
     * @return slotUnitName
     */
    @javax.annotation.Nonnull
    public String getSlotUnitName() {
        return slotUnitName;
    }

    public void setSlotUnitName(String slotUnitName) {
        this.slotUnitName = slotUnitName;
    }

    public SlotFeeStructure upgradePolicy(SlotUpgradePolicyEnum upgradePolicy) {
        this.upgradePolicy = upgradePolicy;
        return this;
    }

    /**
     * Get upgradePolicy
     *
     * @return upgradePolicy
     */
    @javax.annotation.Nonnull
    public SlotUpgradePolicyEnum getUpgradePolicy() {
        return upgradePolicy;
    }

    public void setUpgradePolicy(SlotUpgradePolicyEnum upgradePolicy) {
        this.upgradePolicy = upgradePolicy;
    }

    /**
     * Create an instance of SlotFeeStructure given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of SlotFeeStructure
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     SlotFeeStructure
     */
    public static SlotFeeStructure fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, SlotFeeStructure.class);
    }

    /**
     * Convert an instance of SlotFeeStructure to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
