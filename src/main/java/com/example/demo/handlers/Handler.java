package com.example.demo.handlers;

public interface Handler {
    void setNext(Handler handler);
    boolean handle(String request);
}
