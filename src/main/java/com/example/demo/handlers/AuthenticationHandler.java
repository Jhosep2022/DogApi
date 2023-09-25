package com.example.demo.handlers;

public class AuthenticationHandler implements Handler{
    private Handler next;

    @Override
    public void setNext(Handler handler) {
        this.next = handler;
    }

    @Override
    public boolean handle(String request) {
        if(request.equals("authenticate"))
            System.out.println("AuthenticationHandler: Authenticated");
        else
            System.out.println("AuthenticationHandler: Not Authenticated");
        next.handle(request);
        return false;
    }
}
