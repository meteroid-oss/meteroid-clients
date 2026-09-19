package com.scribe;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Locale;

/**
 * Stable identifier for a Scribe plan, used everywhere in the contract.
 *
 * <p>Meteroid plans carry no user-supplied code, so each of these maps onto the exact seeded plan
 * <b>name</b> documented in {@code examples/CATALOG.md}. Renaming a plan in the dashboard breaks
 * the lookup — that is unavoidable given the API, and it is why the failure is loud.
 */
public enum PlanCode {
    FREE("free", "Scribe Free"),
    PRO("pro", "Scribe Pro"),
    SCALE("scale", "Scribe Scale");

    /** Cheapest first, matching the order {@code GET /api/plans} promises. */
    public static final PlanCode[] ALL = {FREE, PRO, SCALE};

    private final String wireValue;
    private final String meteroidPlanName;

    PlanCode(String wireValue, String meteroidPlanName) {
        this.wireValue = wireValue;
        this.meteroidPlanName = meteroidPlanName;
    }

    /** The wire value of this code, exactly as it appears in the contract's enum. */
    @JsonValue
    public String wireValue() {
        return wireValue;
    }

    /** The exact Meteroid plan name this code maps onto — see {@code examples/CATALOG.md}. */
    public String meteroidPlanName() {
        return meteroidPlanName;
    }

    /** The plan to offer as an upgrade when this one runs out of quota. */
    public PlanCode nextUp() {
        switch (this) {
            case FREE:
                return PRO;
            case PRO:
                return SCALE;
            default:
                return null;
        }
    }

    @JsonCreator
    public static PlanCode fromWire(String value) {
        if (value != null) {
            for (PlanCode code : ALL) {
                if (code.wireValue.equals(value.toLowerCase(Locale.ROOT))) {
                    return code;
                }
            }
        }
        throw new IllegalArgumentException(
                "plan_code must be one of free, pro, scale; got \"" + value + "\".");
    }
}
