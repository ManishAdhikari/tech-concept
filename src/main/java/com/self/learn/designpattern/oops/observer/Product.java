package com.self.learn.designpattern.oops.observer;

// Observer
public interface Product {

    void subscribe( NotificationAlert notificationAlert );
    void unsubscribe( NotificationAlert notificationAlert );
    void notifySubscribers(String message);
    void setQuantity(int quantity);
}
