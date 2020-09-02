package com.m3d.blog.blogger.model;

public class GenericResponse<T> {

    private int status;
    private String message;
    private T data;

    public GenericResponse() {
    }

    public GenericResponse(int status, String msg) {
        this.status = status;
        this.message = msg;
    }

    public GenericResponse(int status, String msg, T t) {
        this(status, msg);
        this.data = t;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "GenericResponse [data=" + data + ", message=" + message + ", status=" + status + "]";
    }

}