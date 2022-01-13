package classes;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

import static java.lang.Math.*;
import static java.lang.System.out;

public class Task10 {
    abstract static class Figure {
        String name;

        abstract double getSquare();

        abstract void display();

        abstract Boolean isExist();
    }

    static class TwoDimensional extends Figure {
        double getSquare() {
            return 0;
        }

        double getPerimeter() {
            return 0;
        }

        void display() {
            out.println(name);
        }

        Boolean isExist() {
            return true;
        }
    }

    static class Triangle extends TwoDimensional {
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

    static class Rectangle extends TwoDimensional {
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

    static class Rhomb extends TwoDimensional {
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

    static class Circle extends TwoDimensional {
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

    static class ThreeDimensional extends Figure {
        double getSquare() {
            return 0;
        }

        double getSquareSideArea() {
            return 0;
        }

        double getVolume() {
            return 0;
        }

        void display() {
            out.println(name);
        }

        Boolean isExist() {
            return true;
        }
    }

    static class Cube extends ThreeDimensional {
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

    static class Sphere extends ThreeDimensional {
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

    static class Cylinder extends ThreeDimensional {
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

    static class Konus extends ThreeDimensional {
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

    public static double getSumSquare(Figure figureFirst, Figure figureSecond) throws Exception {
        if ((figureFirst instanceof ThreeDimensional && figureSecond instanceof ThreeDimensional) ||
                (figureFirst instanceof TwoDimensional && figureSecond instanceof TwoDimensional)) {
            return figureFirst.getSquare() + figureSecond.getSquare();
        } else {
            throw new Exception("It is not possible to perform operations. Different types of figures...");
        }
    }

    public static double getSumVolume(Figure figureFirst, Figure figureSecond) throws Exception {
        if (figureFirst instanceof ThreeDimensional && figureSecond instanceof ThreeDimensional) {
            return figureFirst.getSquare() + figureSecond.getSquare();
        } else {
            throw new Exception("It is not possible to perform operations. Different types of figures...");
        }
    }

    public static double getSubtractionSquare(Figure figureFirst, Figure figureSecond) throws Exception {
        if (figureFirst instanceof ThreeDimensional && figureSecond instanceof ThreeDimensional ||
                figureFirst instanceof TwoDimensional && figureSecond instanceof TwoDimensional) {
            double subtraction = figureFirst.getSquare() - figureSecond.getSquare();
            if (subtraction < 0) {
                throw new Exception("It is impossible to find the difference between the areas of the two volumes!");
            }
            return subtraction;
        } else {
            throw new Exception("It is not possible to perform operations. Different types of figures...");
        }

    }

    public static double getSubtractionVolume(Figure figureFirst, Figure figureSecond) throws Exception {
        if (figureFirst instanceof ThreeDimensional && figureSecond instanceof ThreeDimensional) {
            double subtraction = ((ThreeDimensional) figureFirst).getVolume() - ((ThreeDimensional) figureSecond).getVolume();
            if (subtraction < 0) {
                throw new Exception("It is impossible to find the difference between the areas of the two volumes!");
            }
            return subtraction;
        } else {
            throw new Exception("It is not possible to perform operations. Different types of figures...");
        }

    }

    public static boolean getComparisonSquare(Figure figureFirst, Figure figureSecond) throws Exception {
        if (figureFirst instanceof ThreeDimensional && figureSecond instanceof ThreeDimensional ||
                figureFirst instanceof TwoDimensional && figureSecond instanceof TwoDimensional) {
            return figureFirst.getSquare() > figureSecond.getSquare();
        } else {
            throw new Exception("It is impossible to find the difference between the areas of the two volumes!");
        }

    }

    public static void printSort(Figure[] figures) {
        out.println("\t\tSorting figures by various parameters\n");
        out.println("The figures are sorted by area:");
        for (int i = 0; i < figures.length - 1; i++) {
            for (int j = figures.length - 1; j > i; j--) {
                if (figures[j - 1].getSquare() > figures[j].getSquare()) {
                    Figure tmp = figures[j - 1];
                    figures[j - 1] = figures[j];
                    figures[j] = tmp;
                }
            }
        }
        for (Figure itVar : figures) {
            itVar.display();
        }

        //фільтр обємних та плоских фігур
        LinkedList<ThreeDimensional> threeDimensionals = new LinkedList<>();
        LinkedList<TwoDimensional> twoDimensionals = new LinkedList<>();
        for (Figure itVar : figures) {
            if (itVar instanceof ThreeDimensional) {
                threeDimensionals.add((ThreeDimensional) itVar);
            } else {
                twoDimensionals.add((TwoDimensional) itVar);
            }
        }

        out.println("\n\t\t2D\n");

        out.println("The Two Dimensional figures are sorted by Square:");
        twoDimensionals.stream()
                .sorted(Comparator.comparingDouble(TwoDimensional::getSquare))
                .forEach(TwoDimensional::display);

        out.println("\nThe Two Dimensional figures are sorted by Perimeter:");
        twoDimensionals.stream()
                .sorted(Comparator.comparingDouble(TwoDimensional::getPerimeter))
                .forEach(TwoDimensional::display);

        out.println("\n\t\t3D\n");

        out.println("The Three Dimensional figures are sorted by Square:");
        threeDimensionals.stream()
                .sorted(Comparator.comparingDouble(ThreeDimensional::getSquare))
                .forEach(ThreeDimensional::display);

        out.println("\nThe Three Dimensional figures are sorted by Square Side Area:");
        threeDimensionals.stream()
                .sorted(Comparator.comparingDouble(ThreeDimensional::getSquareSideArea))
                .forEach(ThreeDimensional::display);

        out.println("\nThe Three Dimensional figures are sorted by Volume:");
        threeDimensionals.stream()
                .sorted(Comparator.comparingDouble(ThreeDimensional::getVolume))
                .forEach(ThreeDimensional::display);
    }

    public static void printMathematicalOperations(Figure[] figures) throws Exception {
        out.println("\n\t\tMathematical Operations\n");
        out.println("\tTest Sum Square:");
        out.println("Test Sum Square [threeDimensionals+threeDimensionals]");
        out.println("Sphere + Cylinder = " + getSumSquare(figures[5], figures[6]));
        out.println("Test Sum Square [twoDimensional+twoDimensional]");
        out.println("Rectangle + Rhomb = " + getSumSquare(figures[1], figures[2]));
        //Exception("It is not possible to perform operations. Different types of figures...")
        //out.println("Circle + Cube = " + getSumSquare(figures[3],figures[4]));

        out.println("\n\tTest Subtraction Square:");
        out.println("Test Subtraction Square [threeDimensional-threeDimensionals]");
        out.println("Triangle - Rectangle = " + getSubtractionSquare(figures[6], figures[5]));
        //Exception("It is impossible to find the difference between the areas of the two volumes!")
        //out.println("Rectangle + Rhomb = " + getSubtractionSquare(figures[0],figures[1]));
        //Exception("It is not possible to perform operations. Different types of figures...")
        //out.println("Circle + Cube = " + getSumSquare(figures[3],figures[4]));
        out.println("Test Subtraction Square [twoDimensional-twoDimensional]");
        out.println("Rectangle - Triangle = " + getSubtractionSquare(figures[1], figures[0]));

        out.println("\n\tTest Sum Volume:");
        out.println("Test Sum Volume [threeDimensionals+threeDimensionals]");
        out.println("Sphere + Cylinder = " + getSumVolume(figures[5], figures[6]));
        //Exception("It is not possible to perform operations. Different types of figures...")
        //out.println("Rectangle + Rhomb = " + getSumVolume(figures[1],figures[2]));


        out.println("\n\tTest Subtraction Volume:");
        out.println("Test Subtraction Volume [threeDimensional-threeDimensionals]");
        out.println("Triangle - Rectangle = " + getSubtractionVolume(figures[6], figures[5]));
        //Exception("It is impossible to find the difference between the areas of the two volumes!")
        //out.println("Rectangle + Triangle = " + getSubtractionSquare(figures[5],figures[6]));
        //Exception("It is not possible to perform operations. Different types of figures...")
        //out.println("Rectangle - Triangle = " + getSubtractionVolume(figures[1],figures[0]));

        out.println("\n\tTest Comparison:");
        out.println("Test Comparison [threeDimensionals>threeDimensionals]");
        out.println("Sphere > Cylinder = " + getComparisonSquare(figures[5], figures[6]));
        out.println("Test Sum Square [twoDimensional>twoDimensional]");
        out.println("Rectangle > Rhomb = " + getComparisonSquare(figures[1], figures[2]));
        //Exception("It is not possible to perform operations. Different types of figures...")
        //out.println("Circle > Cube = " + getComparisonSquare(figures[3],figures[4]));
    }

    public static void printfilter(Figure[] figures) throws Exception {
        out.println("\n\t\tSearch\n");
        //фільтр обємних та плоских фігур
        LinkedList<ThreeDimensional> threeDimensionals = new LinkedList<>();
        LinkedList<TwoDimensional> twoDimensionals = new LinkedList<>();
        for (Figure itVar : figures) {
            if (itVar instanceof ThreeDimensional) {
                threeDimensionals.add((ThreeDimensional) itVar);
            } else {
                twoDimensionals.add((TwoDimensional) itVar);
            }
        }

        Scanner console = new Scanner(System.in);
        out.println("~~~~~~~~~~~Search2D~~~~~~~~~~");
        out.println("If you want to skip the search parameter, enter 0.\nFor example: Enter country: 0");
        out.print("\nEnter MAX Perimeter: ");
        float perimeterMax2D = console.nextFloat();
        out.print("Enter Square: ");
        float squareMax2D = console.nextFloat();
        out.print("\n\tResult: \n");
        twoDimensionals.stream()
                .filter(figure -> perimeterMax2D == 0 || figure.getPerimeter() <= perimeterMax2D)
                .filter(figure -> squareMax2D == 0 || figure.getSquare() <= squareMax2D)
                .forEach(TwoDimensional::display);

        out.println("\n~~~~~~~~~~~Search3D~~~~~~~~~~");
        out.println("If you want to skip the search parameter, enter 0.\nFor example: Enter country: 0");
        out.print("\nEnter MAX Square Side Area: ");
        float squareSideArea3D = console.nextFloat();
        out.print("Enter Square: ");
        float squareMax3D = console.nextFloat();
        out.print("Enter MAX Volume: ");
        float volumeMax3D = console.nextFloat();
        out.print("\n\tResult: \n");
        threeDimensionals.stream()
                .filter(figure -> squareSideArea3D == 0 || figure.getSquareSideArea() <= squareSideArea3D)
                .filter(figure -> squareMax3D == 0 || figure.getSquare() <= squareMax3D)
                .filter(figure -> volumeMax3D == 0 || figure.getVolume() <= volumeMax3D)
                .forEach(ThreeDimensional::display);
    }

    public static void main(String[] args) throws Exception {
        Figure[] figures = new Figure[]{
                new Triangle("Triangle", 4, 2, 3),
                new Rectangle("Rectangle", 4, 5, 6),
                new Rhomb("Rhomb", 23, 55),
                new Circle("Circle", 3),
                new Cube("Cube", 23),
                new Sphere("Sphere", 12),
                new Cylinder("Cylinder", 12, 32),
                new Konus("Konus", 44, 2)
        };

        printSort(figures);
        printMathematicalOperations(figures);
        printfilter(figures);

    }

}