import java.util.Scanner;


class InputScanner {
    Scanner sc = new Scanner(System.in);

    
    int getInput(String message) {
        System.out.print(message);
        return sc.nextInt();
    }
    double getDoubleInput(String message) {
        System.out.print(message);
        return sc.nextDouble();
    }
}



abstract class Shape extends InputScanner {
    int a, b;
    abstract void printArea(); 
}


class Rectangle extends Shape {
    void input() {
        a = getInput("Enter length of rectangle: ");
        b = getInput("Enter breadth of rectangle: ");
    }

    void printArea() {
        System.out.println("Area of Rectangle: " + (a * b));
    }
}


class Triangle extends Shape {
    void input() {
        a = getInput("Enter base of triangle: ");
        b = getInput("Enter height of triangle: ");
    }

    void printArea() {
        double area = 0.5 * a * b;
        System.out.println("Area of Triangle: " + area);
    }
}


class Circle extends Shape {
    double radius;

    void input() {
        radius = getInput("Enter radius of circle: ");
    }

    void printArea() {
        double area = Math.PI * radius * radius;
        System.out.println("Area of Circle: " + area);
    }
}


public class ShapeMain {
    public static void main(String[] args) {

        Rectangle rect = new Rectangle();
        rect.input();
        rect.printArea();

        System.out.println();

        Triangle tri = new Triangle();
        tri.input();
        tri.printArea();

        System.out.println();

        Circle cir = new Circle();
        cir.input();
        cir.printArea();
    }
}
