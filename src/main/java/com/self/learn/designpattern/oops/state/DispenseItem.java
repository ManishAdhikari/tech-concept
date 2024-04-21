package com.self.learn.designpattern.oops.state;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DispenseItem implements State {

    private final VendingMachine vendingMachine;
    @Override
    public void onLoadMoney (int amount) {
        System.err.println("Can't load money before dispensing item");
    }

    @Override
    public void onChooseItem (String name) {
        System.err.println("Can't choose before dispensing item");
    }

    @Override
    public void onCollectItem () {
        var itemCollected = this.vendingMachine.getInventory().stream()
                .filter(rp -> rp.equals(this.vendingMachine.getRequestedItem()))
                .findFirst().map(rp -> rp.getItems().remove(0))
                .orElseThrow(() -> new RuntimeException("Problem while collecting item"));
        this.vendingMachine.setRequestedItem(null);
        this.vendingMachine.changeState(new Ready(this.vendingMachine));
        System.out.println(itemCollected.getName()+" collected successfully");
    }

    @Override
    public void onCollectMoney () {
        System.err.println("Can't collect money before dispensing item");
    }
}
