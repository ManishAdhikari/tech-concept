package com.self.learn.designpattern.oops.state;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class VendingMachineMainApp {

    public static void main ( String[] args ) {
        Item i1 = new Item("Dairy milk", 10);
        Item i2 = new Item("Savories", 20);
        Item i3 = new Item("Diet Coke", 30);
        Item i4 = new Item("Milk", 40);
        RackPlace rp1 = new RackPlace("A1", addItemsToRack(i1,3));
        RackPlace rp2 = new RackPlace("A2", addItemsToRack(i2, 2));
        RackPlace rp3 = new RackPlace("A3", addItemsToRack(i3, 4));
        RackPlace rp4 = new RackPlace("A4", addItemsToRack(i4, 1));
        VendingMachine vendingMachine = new VendingMachine(List.of(rp1, rp2, rp3, rp4));

        vendingMachine.getItemLeftCount("A3");
        vendingMachine.getInventoryDetails();

        vendingMachine.loadMoney(50);
        vendingMachine.orderItem("A4");
        vendingMachine.collectItem();
        vendingMachine.collectRemainingAmount();

        vendingMachine.loadMoney(50);
        vendingMachine.orderItem("A3");
        vendingMachine.collectItem();
        vendingMachine.orderItem("A2");
        vendingMachine.collectItem();
        vendingMachine.orderItem("A1");
    }

    public static List<Item> addItemsToRack(Item item, int quantity){
        var rackItems = new ArrayList<Item>();
        IntStream.rangeClosed(1,quantity).forEach(i -> rackItems.add(item));
        return rackItems;
    }
}
