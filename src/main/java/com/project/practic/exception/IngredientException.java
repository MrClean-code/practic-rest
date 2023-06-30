package com.project.practic.exception;

public class IngredientException extends RuntimeException{
    public IngredientException() {
        super();
    }

    public IngredientException(String message) {
        super(message);
    }

    public IngredientException(String message, Throwable cause) {
        super(message, cause);
    }

    public IngredientException(Throwable cause) {
        super(cause);
    }

    protected IngredientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
