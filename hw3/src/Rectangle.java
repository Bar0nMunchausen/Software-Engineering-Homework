public class Rectangle extends Shape{
    private double height;
    private double width;
    public Rectangle(double height, double width){
        this.height = height;
        this.width = width;
    }
    @Override
    double area() {
        return (height * width)/2;
    }

    @Override
        double perimeter() {
            double hypotenuse =  Math.sqrt((height*height) + (width*width));
            return (height + width + hypotenuse);
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
