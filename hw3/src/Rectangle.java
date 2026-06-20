/**
 * Represents a Rectangle shape
 * Inherits from the Shape base class and implements its abstract contract.
 */
public class Rectangle extends Shape {
    private int height;
    private int width;

    public Rectangle(int width, int height) {
        /**
         * Constructs a new Rectangle with the given width and height.
         * Allocates and initializes the internal character matrix accordingly
         *
         * @param width  the horizontal size of the rectangle.
         * @param height the vertical size of the rectangle.
         * @throws IllegalArgumentException if either width or height is negative.
         */
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Dimensions cannot be negative");
        }
        this.height = height;
        this.width = width;
        sb = new StringBuilder();

        symbol = new char[height][width * 3];
        for (int i = 0; i < symbol.length; i++) {
            for (int j = 0; j < symbol[0].length; j++) {
                symbol[i][j] = SPACE_SYMBOL;
            }
        }

        for (int i = 0; i < symbol.length; i++) {
            for (int j = 1; j < symbol[0].length; j = j + 3) {
                symbol[i][j] = STAR_SYMBOL;
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

    /**
     * Generates a formatted string representation of the Rectangle for console rendering,
     * @return the complete text-based visualization of the Rectangle.
     */
    @Override
    public String toString() {
        return sb.toString().replace('\0', SPACE_SYMBOL);

    }
}
