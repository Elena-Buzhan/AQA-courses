package courses.lesson_5.point2;

public class MainL5P2 {
    public static void main(String[] args) {
        GeometricFigure circle = new Circle(5, "Red", "Green");
        GeometricFigure rectangle = new Rectangle(2, 3, "Blue", "White");
        GeometricFigure triangle = new Triangle(7, 9, 10, "Black", "Yellow");

        System.out.println("Circle:");
        circle.allPrint();
        System.out.println("\nRectangle:");
        rectangle.allPrint();
        System.out.println("\nTriangle:");
        triangle.allPrint();
    }


}
