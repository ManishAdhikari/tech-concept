package com.self.learn.designpattern.oops.decorator;

public class Sports implements Car{
    @Override
    public int cost () {
        return 80_000;
    }

    @Override
    public String name () {
        return "Sports";
    }

    @Override
    public String features () {
        return "Top speed- 150 mph";
    }
}
