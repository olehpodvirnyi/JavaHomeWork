package collections;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class Task15Fix {
    static class Car {
        private int year;
        private int price;
        private double еngineСapacity;
        private String brand;
        private String bodyType;

        public Car(int year,  String bodyType, String brand,double еngineСapacity, int price) {
            this.year = year;
            this.price = price;
            this.еngineСapacity = еngineСapacity;
            this.brand = brand;
            this.bodyType = bodyType;
        }

        public void display() {
            out.println(year + " " + bodyType + " " + brand + " " + еngineСapacity + " " + price);
        }

    }

    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<Car>(List.of(
                new Car(2015, "Sedan", "Audi", 2.0, 7000),
                new Car(2021, "Universal", "Audi", 2.2, 6000),
                new Car(2000, "Hatchback", "Audi", 2.0, 5000),
                new Car(2002, "Hatchback", "Audi", 2.0, 4000),
                new Car(2014, "Hatchback", "BMW", 2.0, 22000),
                new Car(2017, "Hatchback", "BMW", 2.0, 2000),
                new Car(2006, "SUV", "BMW", 2.0, 8000),
                new Car(2017, "Hatchback", "Mercedes", 2.0, 9000),
                new Car(2020, "Hatchback", "Mercedes", 2.0, 17000),
                new Car(2013, "Minivan", "Mercedes", 2.0, 15000)));
    }
}
