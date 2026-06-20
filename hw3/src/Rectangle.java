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
                symbol[i][j] = '*';
                symbol[i][j] = ' ';
            }
            sb.append(String.valueOf(symbol[i]));
            sb.append("\n");
        }
    }

    @Override
    double area() {
        return (height * width) / 2;
    }

    @Override
    double perimeter() {
        double hypotenuse = Math.sqrt((height * height) + (width * width));
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
        return symbol;
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}
