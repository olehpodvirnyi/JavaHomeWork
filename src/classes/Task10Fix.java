package classes;

import static java.lang.Math.*;

public class Task10Fix {
    abstract class Figure {
        abstract double getSquare();
    }

    class TwoDimensional extends Figure {
        double getSquare() {
            return 0;
        }

        double Perimeter() {
            return 0;
        }
    }

    class Triangle extends TwoDimensional {
        private double a;
        private double b;
        private double c;

        @Override
        double getSquare() {
            double p = (a + b + c) / 2;
            return sqrt(p * (p - a) * (p - b) * (p - c));
        }

        @Override
        double Perimeter() {
            return a + b + c;
        }

    }

    class Rectangle extends TwoDimensional {
        private double a;
        private double b;

        @Override
        double getSquare() {
            return a * b;
        }

        @Override
        double Perimeter() {
            return 2 * (a + b);
        }
    }

    class Rhomb extends TwoDimensional {
        private double a;
        private double h;

        @Override
        double getSquare() {
            return a * h;
        }

        @Override
        double Perimeter() {
            return 4 * a;
        }
    }

    class Circle extends TwoDimensional {
        private double r;

        @Override
        double getSquare() {
            return PI * pow(r, 2);
        }

        @Override
        double Perimeter() {
            return 2 * PI * r;
        }
    }

    class ThreeDimensional extends Figure {
        double getSquare() {
            return 0;
        }

        double getSquareSideArea() {
            return 0;
        }

        double Volume() {
            return 0;
        }
    }

    class Cube extends ThreeDimensional {
        private double a;

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
        double Volume() {
            return pow(a, 3);
        }

    }

    class Sphere extends ThreeDimensional {
        private double r;

        @Override
        double getSquare() {
            return 4 * PI * pow(r, 2);
        }

        @Override
        double Volume() {
            return 4.0/3.0 * PI * pow(r, 3);
        }

    }

    class Cylinder extends ThreeDimensional {
        private double r;
        private double h;

        @Override
        double getSquare() {
            return 2 * PI * r * (h + r);
        }

        @Override
        double getSquareSideArea() {
            return 2 * PI * r * h;
        }
        @Override
        double Volume() {
            return PI * pow(r, 2) * h;
        }
    }

    class Konus extends ThreeDimensional {
        private double r;
        private double h;

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
        double Volume() {
            return 1.0/3.0 * PI * h * pow(r, 2);
        }
    }

    public static void main(String[] args) {
        // TODO document why this method is empty
    }
}
