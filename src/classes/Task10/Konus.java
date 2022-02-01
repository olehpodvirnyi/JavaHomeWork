package classes.Task10;

import static java.lang.Math.*;
import static java.lang.System.out;

public class Konus extends ThreeDimensional {
    private double r;
    private double h;

    Konus(String name, double r, double h) throws Exception {
        this.name = name;
        this.r = r;
        this.h = h;
        if (!isExist()) {
            throw new Exception("[Triangle] Unable to create shape with specified parameters!");
        }
    }

    @Override
    Boolean isExist() {
        return (r > 0) && (h > 0);
    }

    double getTvirna() {
        return sqrt(pow(r, 2) + pow(h, 2));
    }

    @Override
    double getSquare() {
        return getSquareSideArea() * PI * pow(r, 2);
    }

    @Override
    double getSquareSideArea() {
        return PI * r * getTvirna();
    }

    @Override
    double getVolume() {
        return 1.0 / 3.0 * PI * h * pow(r, 2);
    }

    @Override
    void display() {
        out.println(name + "\tVolume: " + getVolume() + "\tSquare: " + getSquare() + "\tSquareSideArea: " + getSquareSideArea());
    }
}
