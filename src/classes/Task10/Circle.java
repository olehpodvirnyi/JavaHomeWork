package classes.Task10;

import static java.lang.Math.PI;
import static java.lang.Math.pow;
import static java.lang.System.out;

public class Circle extends TwoDimensional {
    private double r;

    Circle(String name, double r) throws Exception {
        this.name = name;
        this.r = r;
        if (!isExist()) {
            throw new Exception("[Triangle] Unable to create shape with specified parameters!");
        }
    }

    @Override
    Boolean isExist() {
        return r > 0;
    }

    @Override
    double getSquare() {
        return PI * pow(r, 2);
    }

    @Override
    double getPerimeter() {
        return 2 * PI * r;
    }

    @Override
    void display() {
        out.println(name + "\tSquare: " + getSquare() + "\tPerimeter: " + getPerimeter());
    }
}
