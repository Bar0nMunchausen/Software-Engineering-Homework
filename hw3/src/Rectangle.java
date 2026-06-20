public class Rectangle extends Shape {
    private int height;
    private int width;

    public Rectangle(int width,int height) {
        this.height = height;
        this.width = width;
        sb = new StringBuilder();

        symbol = new char[height][width * 3];
        for (int i = 0; i < symbol.length; i++) {
            for (int j = 0; j < symbol[0].length; j++) {
                symbol[i][j] = ' ';
            }
        }

        for (int i = 0; i < symbol.length; i++) {
            for (int j = 0; j < symbol[0].length; j=j+3) {
                symbol[i][j+1] = '*';
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
        return sb.toString().replace('\0', ' ');
    }
}
