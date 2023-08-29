package org.example.exceptions;

public class NullIndexException extends RuntimeException {
    public NullIndexException() {
    }

    public NullIndexException(String message) {
        super(message);
    }

    public NullIndexException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullIndexException(Throwable cause) {
        super(cause);
    }

    public NullIndexException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
