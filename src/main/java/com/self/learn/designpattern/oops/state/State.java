package com.self.learn.designpattern.oops.state;

/**
 * State/Action		    LoadMoney  			ChooseItem  		    CollectItem  		CollectMoney
 * Ready				ItemSelection		Ready/ItemSelection     Ready				Ready/ReturnMoney
 *                                          (loadedMoney > 0)                           (loadedMoney > 0)
 * ItemSelection		ItemSelection		DispenseItem		    ItemSelection		ItemSelection
 * DispenseItem		    DispenseItem		DispenseItem		    Ready				DispenseItem
 * ReturnMoney			ReturnMoney			ReturnMoney			    ReturnMoney			Ready
 */
public interface State {
    void onLoadMoney(int amount);
    void onChooseItem(String name);
    void onCollectItem();
    void onCollectMoney();
}
