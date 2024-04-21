package com.self.learn.designpattern.oops.decorator;

public class Sedan implements Car{
    @Override
    public int cost () {
        return 10_000;
    }

    @Override
    public String name () {
        return "Sedan";
    }

    @Override
    public String features () {
        return "Top speed- 100 mph";
    }
}
