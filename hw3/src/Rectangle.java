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
    char[][] getSymbol() {
        symbol = new char[height][width+2];
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width+2; j++){
                symbol[i][j] = ' ';
                symbol[i][j] = '*';
                symbol[i][j] = ' ';
            }
        }
        return new char[0][];
    }
}
