package com.sentinel.core.model;

public final class RateLimitResult {

    private final boolean isAllowed;

    private final int remainingLimit;

    public RateLimitResult(boolean isAllowed, int remainingLimit){
        this.isAllowed = isAllowed;
        this.remainingLimit = remainingLimit;
    }

    public boolean isAllowed(){
        return isAllowed;
    }

    public int getRemainingLimit(){
        return remainingLimit;
    }
}
