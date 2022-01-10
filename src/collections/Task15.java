package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.lang.System.out;

public class Task15 {
    static class Car {
        private int year;
        private int price;
        private double еngineСapacity;
        private String brand;
        private String bodyType;

        public Car(int year, String bodyType, String brand, double engineCapacity, int price) {
            this.year = year;
            this.price = price;
            this.еngineСapacity = engineCapacity;
            this.brand = brand;
            this.bodyType = bodyType;
        }

        public void display() {
            out.println(year + " " + bodyType + " " + brand + " " + еngineСapacity + " " + price);
        }

    }

    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>(List.of(
                new Car(2015, "Sedan", "Audi", 2.0, 7000),
                new Car(2021, "Universal", "Audi", 2.2, 6000),
                new Car(2000, "Hatchback", "Audi", 2.0, 5000),
                new Car(2002, "Hatchback", "Audi", 2.0, 4000),
                new Car(2014, "Hatchback", "BMW", 2.0, 22000),
                new Car(2017, "Hatchback", "BMW", 2.0, 2000),
                new Car(2006, "SUV", "BMW", 2.0, 8000),
                new Car(2017, "Hatchback", "Mercedes", 2.2, 9000),
                new Car(2020, "SUV", "Mercedes", 2.2, 17000),
                new Car(2013, "Minivan", "Mercedes", 2.0, 15000)));
        out.println("Initial list:");
        cars.forEach(Car::display);

        out.println("\nEvery 3rd hatchback has been removed and every second Mercedes\n" +
                "with an engine> 2.0 has halved the price:");
        Iterator<Car> itr = cars.iterator();
        int Firstcount = 0, Secondcount = 0;
        while (itr.hasNext()) {
            Car element = (Car) itr.next();
            Firstcount += element.bodyType.equals("Hatchback") ? 1 : 0;
            if (Firstcount == 3) {
                itr.remove();
                Firstcount = 0;
            }
            Secondcount += element.brand.equals("Mercedes") ? 1 : 0;
            if (Secondcount == 2) {
                cars.stream().filter(car -> car.еngineСapacity > 2.0).forEach(car -> car.price = car.price / 2);
                Secondcount = 0;
            }
        }
        cars.forEach(Car::display);

    }

}