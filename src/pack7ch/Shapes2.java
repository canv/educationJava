package pack7ch;

abstract class TwoDShape {
    private double width;
    private double height;
    private String name;

    TwoDShape() {
        width = 0;
        height = 0;
        name = "none";
    }
    TwoDShape(double width, double height, String name) {
        this.width = width;
        this.height = height;
        this.name = name;
    }
    TwoDShape(double isosceles, String name) {
        width = height = isosceles;
        this.name = name;
    }
    TwoDShape(TwoDShape copy){
        this.width = copy.width;
        this.height = copy.height;
        this.name = copy.name;
    }

    double getWidth() {return width;}
    double getHeight() {return height;}
    String getName() {return name;}
    String getDim() {
        return ("\nWidth - " + width +
                "\nHeight - " + height);
    }

    abstract void showInfo();

    abstract double area ();
}

class Triangle extends TwoDShape {
    private String style;

    Triangle() {
        super();
        style = "none";
    }
    Triangle(String style, double width, double height) {
        super(width, height, "Triangle");
        this.style = style;
    }
    Triangle(double isosceles) {
        super(isosceles, "Triangle");
        style = "painted";
    }
    Triangle(Triangle copy){
        super(copy);
        this.style = copy.style;
    }

    double area() {
        return ((getWidth() * getHeight()) / 2);
    }

    void showInfo(){
        System.out.println("Info: " +
                "\nTriangle - " + style +
                getDim() +
                "\nArea - " + area() +
                "\n");
    }
}

class Rectangle extends TwoDShape{

    Rectangle() {
        super();
    }
    Rectangle(double width, double height){
        super(width,height,"Rectangle");
    }
    Rectangle(double square) {
        super(square,"Square");
    }

    double area () {
        return (getWidth() * getHeight());
    }

    void showInfo(){
        System.out.println("Info: " +
                "\nSquare - default" +
                getDim() +
                "\nArea - " + area() +
                "\n");
    }
}

class Circle extends TwoDShape {
    Circle (){super();}
    Circle (double rad) {
        super(rad, "circle");
    }
    Circle (Circle copy) {
        super(copy);
    }

    double area () {
        return (getWidth()/2) * (getWidth()/2) * 3.1416;
    }

    void showInfo(){
        System.out.println("Info: " +
                "\nCircle - default" +
                getDim() +
                "\nArea - " + area() +
                "\n");
    }
}

public class Shapes2 {
    public static void main(String[] args) {

        TwoDShape[] shapes = {
                new Triangle(),
                new Triangle("based",22,4),
                new Triangle(40),
                new Triangle(),

                new Rectangle(),
                new Rectangle(10,4),
                new Rectangle(7),

                new Circle(14),
        };
//        shapes[6] = new TwoDShape2(shapes [3]);

        for (TwoDShape x:shapes) x.showInfo();

    }
}
