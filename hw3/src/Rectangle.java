public class Rectangle extends Shape {
    private int height;
    private int width;

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
        sb = new StringBuilder();

        symbol = new char[height][width * 3];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width * 3; j=j+3) {
                symbol[i][j] = ' ';
                symbol[i][j+1] = '*';
                symbol[i][j+2] = ' ';
            }
            sb.append(String.valueOf(symbol[i]));
            sb.append("\n");
        }
    }

    @Override
    double area() {
        return height * width;
    }

    @Override
    double perimeter() {
        return 2 * (height + width);
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
        return symbol;
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}
