package com.self.learn.designpattern.oops.observer;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class Iphone implements Product {

    private Set<NotificationAlert> notificationAlerts;
    private int quantityInInventory;

    @Override
    public void subscribe ( NotificationAlert notificationAlert ) {
        if(notificationAlerts == null || notificationAlerts.isEmpty()){
            notificationAlerts = new HashSet<>();
        }
        notificationAlerts.add(notificationAlert);
        System.out.println("Subscribed successfully!");
    }

    @Override
    public void unsubscribe ( NotificationAlert notificationAlert ) {
        if(notificationAlerts != null && !notificationAlerts.isEmpty()) {
            notificationAlerts.remove(notificationAlert);
            System.out.println("Unsubscribed successfully!");
        }
    }

    @Override
    public void notifySubscribers (String message) {
        if(notificationAlerts != null && !notificationAlerts.isEmpty()) {
            notificationAlerts.forEach(alert -> alert.update(message));
        }
    }

    @Override
    public void setQuantity ( int quantity ) {
        if((quantityInInventory + quantity) < 0){
            throw new IllegalArgumentException("Can't remove "+quantity+" items from inventory. Only "+quantityInInventory+" items left.");
        }
        quantityInInventory = quantityInInventory + quantity;
        if(quantityInInventory == 0){
            notifySubscribers("All items sold!");
        }else {
            notifySubscribers(quantityInInventory+" items left in inventory.");
        }
    }
}
