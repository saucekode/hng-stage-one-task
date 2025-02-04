package com.hng.hng_stage_one.NumberClassificationAPI;

public class NumClassResponse {
    private boolean error;
    private String number;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
