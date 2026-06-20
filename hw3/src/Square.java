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
    char[][] getSymbol() {
        symbol = new char[side][side+2];
        for(int i=0; i<side; i++){
            for(int j=0; j<side; j++){
                symbol[i][j] = (char)i;
            }
        }
        return symbol;
    }
}
