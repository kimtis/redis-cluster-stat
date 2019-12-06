package com.kimtis.rcs.app.exception;

public class ResourceAlreadyExistException extends RuntimeException {

    public ResourceAlreadyExistException() {
        super();
    }

    public ResourceAlreadyExistException(String s) {
        super(s);
    }

    public ResourceAlreadyExistException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ResourceAlreadyExistException(Throwable throwable) {
        super(throwable);
    }

    protected ResourceAlreadyExistException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
