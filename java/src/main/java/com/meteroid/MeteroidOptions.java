package com.meteroid;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Setter
@Getter
public final class MeteroidOptions {
    public static final String DEFAULT_URL = "https://api.meteroid.com";

    private String serverUrl = DEFAULT_URL;
    private final List<Long> retrySchedule = Arrays.asList(50L, 100L, 200L);
    private boolean debug = false;
}
