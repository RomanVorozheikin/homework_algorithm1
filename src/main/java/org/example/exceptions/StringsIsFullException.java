package org.example.exceptions;

public class StringsIsFullException extends RuntimeException {
    public StringsIsFullException() {
    }

    public StringsIsFullException(String message) {
        super(message);
    }

    public StringsIsFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public StringsIsFullException(Throwable cause) {
        super(cause);
    }

    public StringsIsFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
