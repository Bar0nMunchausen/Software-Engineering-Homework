public class Square extends Shape {
    private int side;

    public Square(int side) {
        this.side = side;
        sb = new StringBuilder();
        symbol = new char[side][side * 3];
        for (int i = 0; i < symbol.length; i++) {
            for (int j = 0; j < symbol[0].length; j++) {
                symbol[i][j] = ' ';
            }
        }
        for (int i = 0; i < symbol.length; i++) {
            for (int j = 1; j < symbol[0].length; j = j+3) {
                symbol[i][j] = '*';
            }
            sb.append(String.valueOf(symbol[i]));
            sb.append("\n");
        }
    }

    @Override
    double area() {
        return side * side;
    }

    @Override
    double perimeter() {
        return side * 4;
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
        return symbol;
    }

    @Override
    public String toString() {
        return sb.toString().replace('\0', ' ');
    }

}
