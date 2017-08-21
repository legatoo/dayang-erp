package com.dayanghome.dayangerp.enums;

public enum ResultCode {
    SUCCESS(200),
    INTERNAL_ERROR(500);

    private int code;

    ResultCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
