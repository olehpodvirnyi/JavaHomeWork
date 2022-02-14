package arrays.Task1.classes.Task10;

import static java.lang.Math.PI;
import static java.lang.Math.pow;
import static java.lang.System.out;

public class Cylinder extends ThreeDimensional{
    private double r;
    private double h;

    Cylinder(String name, double r, double h) throws Exception {
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

    @Override
    double getSquare() {
        return 2 * PI * r * (h + r);
    }

    @Override
    double getSquareSideArea() {
        return 2 * PI * r * h;
    }

    @Override
    double getVolume() {
        return PI * pow(r, 2) * h;
    }

    @Override
    void display() {
        out.println(name + "\tVolume: " + getVolume() + "\tSquare: " + getSquare() + "\tSquareSideArea: " + getSquareSideArea());
    }
}
