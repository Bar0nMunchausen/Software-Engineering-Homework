public class Rectangle extends Shape{
    private int height;
    private int width;
    public Rectangle(int height, int width){
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
