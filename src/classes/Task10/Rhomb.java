package classes.Task10;

import static java.lang.System.out;

public class Rhomb extends TwoDimensional {
    private double a;
    private double h;

    Rhomb(String name, double a, double h) throws Exception {
        this.name = name;
        this.a = a;
        this.h = h;
        if (!isExist()) {
            throw new Exception("[Triangle] Unable to create shape with specified parameters!");
        }
    }

    @Override
    Boolean isExist() {
        return (a > 0) && (h > 0);
    }

    @Override
    double getSquare() {
        return a * h;
    }

    @Override
    double getPerimeter() {
        return 4 * a;
    }

    @Override
    void display() {
        out.println(name + "\tSquare: " + getSquare() + "\tPerimeter: " + getPerimeter());
    }
}
