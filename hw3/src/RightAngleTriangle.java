public class RightAngleTriangle extends Shape {
    private int height;
    private int width;

    public RightAngleTriangle(int height, int width) {
        this.height = height;
        this.width = width;
        sb = new StringBuilder();

        symbol = new char[height+1][width * 3];
        for (int i = 1; i <= height; i++) {
            int starsPerLine = Math.max(1, ((int) ((double) i * width / height)));
            for (int j = 0; j < starsPerLine*3; j = j + 3) {
                symbol[i][j] = ' ';
                symbol[i][j + 1] = '*';
                symbol[i][j + 2] = ' ';
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
