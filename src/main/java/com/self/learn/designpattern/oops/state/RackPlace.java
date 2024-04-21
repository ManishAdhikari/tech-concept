package com.self.learn.designpattern.oops.state;

import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class RackPlace {
    private String rackNum;
    private List<Item> items;

    public RackPlace ( String rackNum, List<Item> items ) {
        this.rackNum = rackNum;
        if(Objects.isNull(items)){
            this.items = List.of();
        }else {
            this.items = items;
        }
    }
}
