package com.dms.theapicat.data.exception;

public class NetworkConnectionException extends Exception {
    public NetworkConnectionException() {
        super("The connection has failed");
    }
}
