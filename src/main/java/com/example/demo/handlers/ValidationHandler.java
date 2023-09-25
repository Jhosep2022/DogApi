package com.example.demo.handlers;

public class ValidationHandler implements Handler {
    private Handler next;

    @Override
    public void setNext(Handler handler) {
        this.next = handler;
    }

    @Override
    public boolean handle(String request) {
        if(request.equals("validate"))
            System.out.println("ValidationHandler: Validated");
        else
            System.out.println("ValidationHandler: Not Validated");
        next.handle(request);
        return false;
    }

}
