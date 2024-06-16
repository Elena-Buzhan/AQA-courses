package courses.lesson_5.point2;

public interface GeometricFigure {

    double getPerimeter();

    double getArea();

    String getFillColor();

    String getBorderColor();

    default void allPrint() {
        System.out.println("Perimeter: " + getPerimeter());
        System.out.println("Area: " + getArea());
        System.out.println("Fill Color: " + getFillColor());
        System.out.println("Border Color: " + getBorderColor());
    }

}


