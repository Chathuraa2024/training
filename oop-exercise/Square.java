package calculate;

public class Square implements shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }


    @Override
    public double getPerimeter() {
        return 4 * side;
    }


}
