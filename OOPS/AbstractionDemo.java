public class AbstractionDemo {
    public static void main(String[] args) {
        Shape shape1 = new Circle("Red", 5);
        Shape shape2 = new Rectangle("Blue", 4, 6);
        shape1.draw();
        shape2.draw();
        shape1.displayColor();
        shape2.displayColor();
    }
}

abstract class Shape {
    String color;

    Shape(String color) {
        this.color = color;
    }

    abstract void draw();

    void displayColor() {
        System.out.println("Shape color: " + color);
    }
}

class Circle extends Shape {
    int radius;

    Circle(String color, int radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    void draw() {
        System.out.println("Drawing a " + color + " circle with radius " + radius);
    }
}

class Rectangle extends Shape {
    int width, height;

    Rectangle(String color, int width, int height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    void draw() {
        System.out.println("Drawing a " + color + " rectangle of size " + width + "x" + height);
    }
}
