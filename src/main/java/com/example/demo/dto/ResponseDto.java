package com.example.demo.dto;

public class ResponseDto<T> {

    private Integer code;
    private T data;
    private String message;

    public ResponseDto() {
    }

    public ResponseDto(int statusCodeValue, String s) {
        this.code = statusCodeValue;
        this.message = s;
    }

    public ResponseDto(Integer code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public ResponseDto(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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

    @Override
    public String toString() {
        return "ResponseDto{" +
                "code=" + code +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
