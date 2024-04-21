package com.self.learn.designpattern.oops.state;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class VendingMachine {
    private State state;
    private final List<RackPlace> inventory;
    private int loadedAmount;
    private RackPlace requestedItem;

    public VendingMachine( List<RackPlace> inventory ){
        this.inventory = inventory;
        this.state = new Ready(this);
    }

    public void changeState(State state) {
        this.state = state;
    }

    public void getItemLeftCount(String name) {
        var count = inventory.stream().filter(rp -> rp.getRackNum().equals(name))
                .map(rp -> rp.getItems().size())
                .findFirst().orElseThrow(() -> new RuntimeException("No such item in inventory"));
        System.out.println("Items left: "+count);
    }

    public void getInventoryDetails() {
        var inventoryDetails =  inventory.stream()
                .collect(Collectors.toMap(rp -> rp.getItems().get(0).getName(), e -> e.getItems().size()));
        System.out.println("Inventory details: "+inventoryDetails);

    }

    public void loadMoney(int amount){
        this.state.onLoadMoney(amount);
    }

    public void orderItem(String name){
        this.state.onChooseItem(name);
    }

    public void collectItem() {
        this.state.onCollectItem();
    }

    public void collectRemainingAmount() {
        this.state.onCollectMoney();
    }
}
