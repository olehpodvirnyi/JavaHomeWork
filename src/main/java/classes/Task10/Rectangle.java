package classes.Task10;

import static java.lang.System.out;

public class Rectangle extends TwoDimensional{
    private double a;
    private double b;

    Rectangle(String name, double a, double b, double c) throws Exception {
        this.name = name;
        this.a = a;
        this.b = b;
        if (!isExist()) {
            throw new Exception("[Triangle] Unable to create shape with specified parameters!");
        }
    }

    @Override
    Boolean isExist() {
        return (a > 0) && (b > 0);
    }

    @Override
    double getSquare() {
        return a * b;
    }

    @Override
    double getPerimeter() {
        return 2 * (a + b);
    }

    @Override
    void display() {
        out.println(name + "\tSquare: " + getSquare() + "\tPerimeter: " + getPerimeter());
    }
}
