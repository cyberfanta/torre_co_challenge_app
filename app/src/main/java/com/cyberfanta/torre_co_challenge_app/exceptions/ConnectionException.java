package com.cyberfanta.torre_co_challenge_app.exceptions;

import org.jetbrains.annotations.NotNull;

public class ConnectionException extends Exception{
    private final String kind;

    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public ConnectionException(String kind) {
        this.kind = kind;
    }

    @NotNull
    @Override
    public String toString() {
        return "ConnectionException{" +
                "i='" + kind + '\'' +
                "} " + super.toString();
    }
}
