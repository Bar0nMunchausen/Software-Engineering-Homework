public class Square extends Shape {
    private int side;
    public Square(int side){
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
    int getWidth() {
        return side;
    }

    @Override
    int getHeight() {
        return side;
    }

    @Override
    public String toString(){

        return null;
    }
}
