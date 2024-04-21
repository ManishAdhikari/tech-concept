package com.self.learn.designpattern.oops.observer;

public record SmsAlert(String mobileNumber) implements NotificationAlert{

    @Override
    public void update (String message) {
        System.out.println(message+" "+"Sending sms to mobile number: "+mobileNumber);
    }
}
