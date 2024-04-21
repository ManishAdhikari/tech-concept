package com.self.learn.designpattern.oops.state;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ReturnMoney implements State {

    private final VendingMachine vendingMachine;

    @Override
    public void onLoadMoney (int amount) {
        System.err.println("Can't load money before returning money");
    }

    @Override
    public void onChooseItem (String name) {
        System.err.println("Can't choose item before returning money");
    }

    @Override
    public void onCollectItem () {
        System.err.println("Can't collect item before returning money");
    }

    @Override
    public void onCollectMoney () {
        var amountLeft = this.vendingMachine.getLoadedAmount();
        this.vendingMachine.setLoadedAmount(0);
        this.vendingMachine.setRequestedItem(null);
        this.vendingMachine.changeState(new Ready(this.vendingMachine));
        System.out.println("Money returned successfully. Amount returned: "+amountLeft);
    }
}
