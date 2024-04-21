package com.self.learn.designpattern.oops.observer;

public record EmailAlert(String emailAddress) implements NotificationAlert{

    @Override
    public void update (String message) {
        System.out.println(message+" "+"Sending email to "+emailAddress);
    }
}
