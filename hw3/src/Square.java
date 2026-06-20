public class Square extends Shape {
    private double side;
    public Square(double side){
        this.side = side;
    }
    @Override
    double area() {
        return side*side;
    }

    @Override
    double perimeter() {
         return side*4;
    }

    @Override
    double getWidth() {
        return side;
    }

    @Override
    double getHeight() {
        return side;
    }

    @Override
    public String toString(){

        return null;
    }
}
