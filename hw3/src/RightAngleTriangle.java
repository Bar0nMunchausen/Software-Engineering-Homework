public class RightAngleTriangle extends Shape{
    private double height;
    private double width;

    public RightAngleTriangle(double height, double width){
        this.height = height;
        this.width = width;
    }

    @Override
    double area() {
        return height * width;
    }

    @Override
    double perimeter() {
        return 2*(height + width);
    }

    @Override
    double getWidth() {
        return width;
    }

    @Override
    double getHeight() {
        return height;
    }

    @Override
    public String toString(){

        return null;
    }
}
