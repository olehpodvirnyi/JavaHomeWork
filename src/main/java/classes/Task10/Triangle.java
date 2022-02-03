package classes.Task10;

import static java.lang.Math.sqrt;
import static java.lang.System.out;

public class Triangle extends TwoDimensional {
    private double a;
    private double b;
    private double c;

    Triangle(String name, double a, double b, double c) throws Exception {
        this.name = name;
        this.a = a;
        this.b = b;
        this.c = c;
        if (!isExist()) {
            throw new Exception("[Triangle] Unable to create shape with specified parameters!");
        }
    }

    @Override
    Boolean isExist() {
        return (a + b > c) && (a + c > b) && (b + c > a) && (a > 0) && (b > 0) && (c > 0);
    }

    @Override
    double getSquare() {
        double p = (a + b + c) / 2;
        return sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    double getPerimeter() {
        return a + b + c;
    }

    @Override
    void display() {
        out.println(name + "\tSquare: " + getSquare() + "\tPerimeter: " + getPerimeter());
    }
}
