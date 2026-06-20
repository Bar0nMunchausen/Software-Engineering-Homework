public class RightAngleTriangle extends Shape {
    private int height;
    private int width;

    public RightAngleTriangle(int width,int height) {
        this.height = height;
        this.width = width;
        sb = new StringBuilder();

        symbol = new char[height+1][width * 3];
        for (int i = 0; i < symbol.length; i++) {
            for (int j = 0; j < symbol[0].length; j++) {
                symbol[i][j] = ' ';
            }
        }
        for (int i = 1; i < symbol.length; i++) {
            int starsPerLine = Math.max(1, ((int) ((double) i * width / height)));
            for (int j = 1; j < starsPerLine*3; j = j + 3) {
                symbol[i][j] = '*';
            }
            sb.append(String.valueOf(symbol[i]));
            sb.append("\n");
        }
    }

    @Override
    double area() {
        return (double) (height * width) / 2;
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
        return sb.toString().replace('\0', ' ');
    }
}
