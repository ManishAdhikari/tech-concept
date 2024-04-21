package com.self.learn.designpattern.oops.state;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Ready implements State {

    private final VendingMachine vendingMachine;

    @Override
    public void onLoadMoney (int amount) {
        this.vendingMachine.setLoadedAmount(amount);
        System.out.println("Money loaded successfully. Amount loaded: "+this.vendingMachine.getLoadedAmount());
        this.vendingMachine.changeState(new ItemSelection(this.vendingMachine));
    }

    @Override
    public void onChooseItem (String name) {
        if(this.vendingMachine.getLoadedAmount() > 0) {
            this.vendingMachine.changeState(new ItemSelection(this.vendingMachine));
            this.vendingMachine.orderItem(name);
        } else {
            System.err.println("No money left. Can't choose item before payment");
        }
    }

    @Override
    public void onCollectItem () {
        System.err.println("Can't collect item before payment");
    }

    @Override
    public void onCollectMoney () {
        if(this.vendingMachine.getLoadedAmount() > 0) {
            this.vendingMachine.changeState(new ReturnMoney(this.vendingMachine));
            this.vendingMachine.collectRemainingAmount();
        } else {
            System.err.println("No money left. Please make payment first.");
        }
    }
}
