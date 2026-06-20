package com.sentinel.core.service;

import com.sentinel.core.model.RateLimitResult;

public interface RateLimiter {
    RateLimitResult evaluateAndConsumeLimit(String apiToken);
}
