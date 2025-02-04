package com.hng.hng_stage_one.NumberClassificationAPI.exceptions;

public class NumClassException extends RuntimeException {
    private final String number;
    private final boolean error;

    public NumClassException(String number, boolean error) {
        this.number = number;
        this.error = error;
    }

    public String getNumber() {
        return number;
    }

    public boolean isError() {
        return error;
    }
}
