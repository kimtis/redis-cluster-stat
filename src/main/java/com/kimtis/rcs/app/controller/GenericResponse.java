package com.kimtis.rcs.app.controller;

import java.util.Date;

class GenericResponse<T> {

    private Date timestamp;

    private int status;

    private String error;

    private T response;

    private String message;

    public GenericResponse() {
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static <U> GenericResponse<U> ok(U response) {
        GenericResponse<U> resp = new GenericResponse<>();
        resp.setTimestamp(new Date());
        resp.setStatus(200);
        resp.setResponse(response);
        return resp;
    }
}
