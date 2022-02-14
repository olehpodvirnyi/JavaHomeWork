package collections.Task15;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.lang.System.out;
import static java.util.List.*;

public class Task15 {

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>(of(
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
        int firstcount = 0, secondcount = 0;
        while (itr.hasNext()) {
            Car element = (Car) itr.next();
            firstcount += element.getBodyType().equals("Hatchback") ? 1 : 0;
            if (firstcount == 3) {
                itr.remove();
                firstcount = 0;
            }
            secondcount += element.getBrand().equals("Mercedes") ? 1 : 0;
            if (secondcount == 2) {
                cars.stream().filter(car -> car.getEngineCapacity() > 2.0).forEach(car -> car.setPrice(car.getPrice() / 2));
                secondcount = 0;
            }
        }
        cars.forEach(Car::display);
    }

}