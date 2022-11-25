package com.app.policy.common;

import org.springframework.beans.factory.annotation.Value;

public interface Constants {
    @Value("${policy.id.min}:100000000")
    public static final int MIN_ID = 100_000_000;
    @Value("${policy.id.max}:999999999")
    public static final int MAX_ID = 999_999_999;
}
