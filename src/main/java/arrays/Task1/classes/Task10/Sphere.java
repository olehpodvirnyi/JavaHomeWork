package arrays.Task1.classes.Task10;

import static java.lang.Math.PI;
import static java.lang.Math.pow;
import static java.lang.System.out;

public class Sphere extends ThreeDimensional {
    private double r;

    Sphere(String name, double r) throws Exception {
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
        return 4 * PI * pow(r, 2);
    }

    @Override
    double getVolume() {
        return 4.0 / 3.0 * PI * pow(r, 3);
    }

    @Override
    void display() {
        out.println(name + "\tVolume: " + getVolume() + "\tSquare: " + getSquare() + "\tSquareSideArea: " + getSquareSideArea());
    }
}
