package com.dms.theapicat.domain;

//Callback to comunicate between layers
public interface Handler<T> {

    void handle(T result);

    void error(Exception exception);

}
