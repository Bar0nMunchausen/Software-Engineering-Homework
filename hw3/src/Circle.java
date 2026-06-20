public class Circle extends Shape{
    int radius;
    public Circle(int radius) {
        this.radius = radius;
    }

    public double area() {
        return  Math.PI * (radius * radius);
    }

    public double perimeter() {
        return Math.PI * (radius * 2);
    }

    @Override
    double getWidth() {
        return 2*radius;
    }

    @Override
    double getHeight() {
        return 2*radius;
    }

    @Override
    public String toString(){

        return null;
    }
}
