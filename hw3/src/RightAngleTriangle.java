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
    char[][] getSymbol() {
        symbol = new char[height][width+2];
        for(int i = 1; i <= height; i++){
            int starsPerLine = Math.max(1, ((int) ((double) i * width / height)));
            for(int j = 0; j < starsPerLine; j=j+3){
                symbol[i][j] = ' ';
                symbol[i][j] = '*';
                symbol[i][j+1] = ' ';
            }
        }
        return symbol;
    }
}
