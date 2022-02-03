package string.collections.Task15;

import static java.lang.System.out;

public class Car {
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

    public double getEngineCapacity() {
        return еngineСapacity;
    }

    public int getPrice() {
        return price;
    }

    public String getBodyType() {
        return bodyType;
    }

    public String getBrand() {
        return brand;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void display() {
        out.println(year + " " + bodyType + " " + brand + " " + еngineСapacity + " " + price);
    }

}
