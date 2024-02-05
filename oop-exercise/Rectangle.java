package calculate;

public class Rectangle implements shape{
    private double hight;
    private double width;

    public Rectangle(double hight,double width){
        this.hight = hight;
        this.width = width;
    }
    @Override
    public double getArea() {
        System.out.println(".......................................");
        return hight*width;
    }

    @Override
    public double getPerimeter() {
        return 2*(hight+width);
    }
}
