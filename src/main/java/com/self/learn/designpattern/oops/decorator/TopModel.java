package com.self.learn.designpattern.oops.decorator;


public record TopModel(Car car) implements CarModel {

    @Override
    public int cost () {
        return 50_000;
    }

    @Override
    public String name () {
        return "Top model" + " - " + this.car().name();
    }

    @Override
    public int showroomPrice () {
        return cost() + this.car().cost();
    }

    @Override
    public String accessories () {
        return "8 Air Bags, Power Steering, Power Windows, Sunroof, Dolby Music System" + " and "+ this.car().features();
    }
}
