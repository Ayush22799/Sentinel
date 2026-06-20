package com.sentinel.core.service;

import com.sentinel.core.model.RateLimitResult;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryRateLimiter implements RateLimiter{

    private final ConcurrentHashMap<String, AtomicInteger> userCounters;
    private final int maxLimit;

    public InMemoryRateLimiter(int maxLimit){
        this.maxLimit = maxLimit;
        userCounters = new ConcurrentHashMap<>();
    }

    @Override
    public RateLimitResult evaluateAndConsumeLimit(String apiToken) {
        AtomicInteger counter = userCounters.computeIfAbsent(apiToken, k -> new AtomicInteger(0));
        int count = counter.incrementAndGet();
        if( count > maxLimit){
            return new RateLimitResult(false, 0);
        }

        return new RateLimitResult(true, maxLimit - count);
    }
}
