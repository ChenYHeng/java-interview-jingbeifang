package com.chen.common;

public class Result<T> {
    private int code;
    private T data;
    private String message;

    public static <T> Result<T> Base(int code, T data, String message) {
        Result<T> res = new Result<T>();
        res.setCode(code);
        res.setData(data);
        res.setMessage(message);
        return res;
    }

    public static <T> Result<T> OK(T result, String message) {
        return Base(0, result, message);
    }

    public static <T> Result<T> OK() {
        return OK(null, "Success");
    }

    public static <T> Result<T> OK(String message) {
        return OK(null, message);
    }

    public static <T> Result<T> OK(T result) {
        return OK(result, "Success");
    }

    public static <T> Result<T> Err(int code, String message) {
        return Base(code, null, message);
    }

    public static <T> Result<T> Err(String message) {
        return Err(-1, message);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
