package calculate;
import java.awt.*;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner str = new Scanner(System.in);
        System.out.print("Enter the sape \n 1.square\n 2.Rectangle \n 3.Circle\n chose your shape 1, 2 or 3: ");
        int shap = str.nextInt();

        shape shape = null;
        if(shap == 1){
            System.out.print("Enter side length of the square: ");
            double side = str.nextDouble();
            shape = new Square(side);
        }else if (shap == 2){
            System.out.print("Enter width of the rectangle: ");
            double width = str.nextDouble();
            System.out.print("Enter height of the rectangle: ");
            double height = str.nextDouble();
            shape = new Rectangle(height,width);
        }else if(shap == 3){
            System.out.print("Enter the radius of the circle: ");
            double radius = str.nextDouble();
            shape = new Circle(radius);
        }else{
            System.out.println(" enter right one");
        }

        printShapeDetails(shape);

    }

    public static void printShapeDetails(shape shape) {;
        System.out.println("run printShapeDetails");
        System.out.print("Area :");
        System.out.println(shape.getArea());
        System.out.print("Perimeter :");
        System.out.println(shape.getPerimeter());
    }


}
