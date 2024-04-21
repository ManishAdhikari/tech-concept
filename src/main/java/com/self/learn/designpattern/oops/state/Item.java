package com.self.learn.designpattern.oops.state;

import lombok.Data;

@Data
public class Item {

    private String name;
    private int price;

    public Item ( String name, int price ) {
        this.name = name;
        this.price = price;
    }
}
