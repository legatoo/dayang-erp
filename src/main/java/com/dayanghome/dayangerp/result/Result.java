package com.dayanghome.dayangerp.result;

import com.dayanghome.dayangerp.enums.ResultCode;

public class Result<T> {
    private ResultCode code;
    private T data;
    private int length;

    public ResultCode getCode() {
        return code;
    }

    public void setCode(ResultCode code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", data=" + data +
                ", length=" + length +
                '}';
    }
}
