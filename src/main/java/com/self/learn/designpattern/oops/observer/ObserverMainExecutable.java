package com.self.learn.designpattern.oops.observer;

public class ObserverMainExecutable {

    public static void main ( String[] args ) {
        User user1 = new User("Manish", new EmailAlert("manish.adhikari@mail.com"));
        Product product1 = new Iphone();
        product1.setQuantity(2);
        product1.subscribe(user1.notificationAlert());
        User user2 = new User("Adhikari", new SmsAlert("+91-123456789"));
        product1.subscribe(user2.notificationAlert());
        product1.setQuantity(1);
        product1.setQuantity(-3);
    }
}
