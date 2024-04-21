package com.self.learn.designpattern.oops.decorator;

// Decorator
public interface CarModel extends Car {
    int showroomPrice ();
    String accessories ();

    default String features () {
        return "";
    }

    default void print () {
        System.out.println(this.name()+ " with " + this.accessories() + " is available for £"+ this.showroomPrice());
    }
}
