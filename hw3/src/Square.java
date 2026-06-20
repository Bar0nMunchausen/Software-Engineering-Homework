/**
 * Represents a geometric square with equal sides.
 * Inherits from the Shape base class and implements its abstract contract.
 */
public class Square extends Shape {
    private int side;

    //constructor to initialize
    public Square(int side) {
        /**
         * Constructs a new Square with the specified side length.
         * Initializes representation matrix with a square pattern.
         *
         * @param side the side length of the square, must be non-negative.
         * @throws IllegalArgumentException if the provided side length is negative.
         */
        if (side < 0) {
            throw new IllegalArgumentException("Dimensions cannot be negative");
        }
        this.side = side;
        sb = new StringBuilder();
        symbol = new char[side][side * 3];
        for (int i = 0; i < symbol.length; i++) {
            for (int j = 0; j < symbol[0].length; j++) {
                symbol[i][j] = ' ';
            }
        }
        for (int i = 0; i < symbol.length; i++) {
            for (int j = 1; j < symbol[0].length; j = j + 3) {
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
        /**
         * Generates a formatted string representation of the Square for console rendering,
         * @return the complete text-based visualization of the Square.
         */
        return sb.toString().replace('\0', ' ');
    }

}
