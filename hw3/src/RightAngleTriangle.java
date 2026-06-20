public class RightAngleTriangle extends Shape{
    private int height;
    private int width;

    public RightAngleTriangle(int height, int width){
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
    int getWidth() {
        return width;
    }

    @Override
    int getHeight() {
        return height;
    }

    @Override
    public String toString(){

        return null;
    }
}
