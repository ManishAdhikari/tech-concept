package com.self.learn.designpattern.oops.decorator;

public record BaseModel(Car car) implements CarModel {

    @Override
    public int cost () {
        return 30_000;
    }

    @Override
    public String name () {
        return "Base model" + " - " + this.car().name();
    }

    @Override
    public int showroomPrice () {
        return cost() + this.car().cost();
    }

    @Override
    public String accessories () {
        return "4 Air Bags, Power Steering, Sony Music System" + " and " + this.car().features();
    }
}
