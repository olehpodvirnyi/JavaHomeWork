package arrays.Task1.classes.Task10;

import static java.lang.Math.pow;
import static java.lang.System.out;

public class Cube extends ThreeDimensional {
    private double a;

    Cube(String name, double a) throws Exception {
        this.name = name;
        this.a = a;
        if (!isExist()) {
            throw new Exception("[Triangle] Unable to create shape with specified parameters!");
        }
    }

    @Override
    Boolean isExist() {
        return a > 0;
    }

    @Override
    double getSquare() {
        return 6 * getSquareSideArea();
    }

    @Override
    double getSquareSideArea() {
        return pow(a, 2);
    }

    double Perimeter() {
        return 12 * a;
    }

    @Override
    double getVolume() {
        return pow(a, 3);
    }

    @Override
    void display() {
        out.println(name + "\tVolume: " + getVolume() + "\tSquare: " + getSquare() + "\tSquareSideArea: " + getSquareSideArea());
    }

}
