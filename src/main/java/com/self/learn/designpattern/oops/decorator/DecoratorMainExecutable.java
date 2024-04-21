package com.self.learn.designpattern.oops.decorator;

public class DecoratorMainExecutable {
    public static void main ( String[] args ) {
        CarModel carModel1 = new BaseModel(new Sedan());
        carModel1.print();
        CarModel carModel2 = new TopModel(new Sports());
        carModel2.print();
        CarModel carModel3 = new TopModel(new Sedan());
        carModel3.print();
    }
}
