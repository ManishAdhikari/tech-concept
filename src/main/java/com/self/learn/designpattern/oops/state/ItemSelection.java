package com.self.learn.designpattern.oops.state;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ItemSelection implements State {

    private final VendingMachine vendingMachine;

    @Override
    public void onLoadMoney (int amount) {
        System.err.println("Can't load money before item selection");
    }

    @Override
    public void onChooseItem (String name) {
        this.vendingMachine.getInventory().stream()
                .filter(rp -> rp.getRackNum().equals(name) && rp.getItems().size() > 0)
                .findFirst()
                .ifPresentOrElse(rp -> {
                            this.vendingMachine.setRequestedItem(rp);
                            this.vendingMachine.setLoadedAmount(this.vendingMachine.getLoadedAmount() - rp.getItems().get(0).getPrice());
                            System.out.println("You have requested for "+rp.getItems().get(0).getName());
                        },
                        () -> new RuntimeException("Item unavailable"));
        this.vendingMachine.changeState(new DispenseItem(this.vendingMachine));
    }

    @Override
    public void onCollectItem () {
        System.err.println("Can't collect item before item selection");
    }

    @Override
    public void onCollectMoney () {
        System.err.println("Can't collect money before item selection");
    }
}
